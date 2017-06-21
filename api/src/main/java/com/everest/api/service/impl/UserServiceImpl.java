package com.everest.api.service.impl;

import com.everest.api.model.User;
import com.everest.api.repository.UserRepository;
import com.everest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    protected User preSave(User user) {
        if (user.getId() == null){
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            if (repository.findByEmail(user.getEmail()).isPresent()){
                throw new RuntimeException("Email already exists, try again with another");
            }
        }
        return super.preSave(user);
    }
}
