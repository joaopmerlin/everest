package br.com.everest.auth.service.impl;

import br.com.everest.auth.data.UserData;
import br.com.everest.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by joao on 11/05/17.
 */

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private UserData userData;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userData.findByEmail(username);
        if (user.isPresent()){
            return user.get();
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }
}
