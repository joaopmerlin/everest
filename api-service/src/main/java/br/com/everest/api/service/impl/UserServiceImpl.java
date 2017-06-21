package br.com.everest.api.service.impl;

import br.com.everest.api.model.User;
import br.com.everest.api.repository.UserRepository;
import br.com.everest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User, Long> implements UserService {

    @Autowired private UserRepository repository;

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    public Optional<User> findByEmailOrUsername(String emailOrUsername) {
        return repository.findByEmailOrUsername(emailOrUsername);
    }
}
