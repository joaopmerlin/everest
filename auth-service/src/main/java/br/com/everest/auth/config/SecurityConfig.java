package br.com.everest.auth.config;

import br.com.everest.auth.data.UserData;
import br.com.everest.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by João on 11/05/2017.
 */

@Configuration
@EnableWebSecurity
@Order(-20)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private UserDetailsService userDetailsService;
    @Autowired private UserData userData;
    @Autowired private OAuth2ClientContext oauth2ClientContext;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginPage("/login")
                .and().rememberMe()
                .and().logout()
                .and().authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .and().requestMatchers().antMatchers("/login/**", "/oauth/authorize", "/oauth/confirm_access")
                .antMatchers(HttpMethod.POST, "/user")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private Filter ssoFilter() {
        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();
        filters.add(ssoFilter(facebook(), "/login/facebook", authoritiesExtractor(), principalExtractor()));
        filter.setFilters(filters);
        return filter;
    }

    private PrincipalExtractor principalExtractor() {
        return map -> {
            String name = map.get("name").toString();
            String email = map.get("email").toString();
            String password = new BigInteger(130, new SecureRandom()).toString(32);

            if (!userData.findByEmail(email).isPresent()) {
                User user = new User(null, name, email, new BCryptPasswordEncoder().encode(password));
                this.userData.save(user);
            }

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            if (userDetails != null && userDetails.isEnabled()) {
                return userDetails;
            }

            throw new BadCredentialsException("Bad Credentials");
        };
    }

    private AuthoritiesExtractor authoritiesExtractor() {
        return map -> {
            String email = map.get("email").toString();
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            if (userDetails != null) {
                userDetails.getAuthorities().size();
                return (List<GrantedAuthority>) userDetails.getAuthorities();
            }
            throw new BadCredentialsException("Bad Credentials");
        };
    }

    private Filter ssoFilter(ClientResources client, String path, AuthoritiesExtractor authoritiesExtractor,
                             PrincipalExtractor principalExtractor) {
        OAuth2ClientAuthenticationProcessingFilter oAuth2Filter = new OAuth2ClientAuthenticationProcessingFilter(path);
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
        oAuth2Filter.setRestTemplate(oAuth2RestTemplate);
        UserInfoTokenServices userInfoTokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId());
        userInfoTokenServices.setAuthoritiesExtractor(authoritiesExtractor);
        userInfoTokenServices.setPrincipalExtractor(principalExtractor);
        oAuth2Filter.setTokenServices(userInfoTokenServices);
        return oAuth2Filter;
    }

    @Bean
    @ConfigurationProperties("facebook")
    public ClientResources facebook() {
        return new ClientResources();
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }
}