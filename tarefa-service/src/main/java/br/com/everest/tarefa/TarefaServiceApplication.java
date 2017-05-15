package br.com.everest.tarefa;

import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableFeignClients
@EnableCircuitBreaker
public class TarefaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefaServiceApplication.class, args);
	}

	@LoadBalanced
	@Bean
	public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context)  {
		return new OAuth2RestTemplate(resource, context);
	}
	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext,
															OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails) {
		return new OAuth2FeignRequestInterceptor(oauth2ClientContext, oAuth2ProtectedResourceDetails);
	}
}
