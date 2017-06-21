package br.com.everest.auth.service.impl;

import br.com.everest.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by joao on 11/05/17.
 */

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmailOrUsername(username);
        if (user != null) {
            return new org.springframework.security.core.userdetails
                    .User(user.getUsername(), user.getPassword(), AuthorityUtils.NO_AUTHORITIES);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
}
