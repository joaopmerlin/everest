package com.everest.api.security;

import com.everest.api.model.User;
import com.everest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by joao on 11/05/17.
 */

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(email);
        if (user.isPresent()) {
            return new org.springframework.security.core.userdetails
                    .User(user.get().getEmail(), user.get().getPassword(), AuthorityUtils.NO_AUTHORITIES);
        } else {
            throw new UsernameNotFoundException("email not found");
        }
    }
}
