package br.com.everest.api.service;

import br.com.everest.api.model.User;

import java.util.Optional;

/**
 * Created by Joao on 30/05/2017.
 */
public interface UserService extends CrudService<User, Long> {

    Optional<User> findByEmailOrUsername(String emailOrUsername);
}
