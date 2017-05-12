package br.com.everest.tarefa.service.impl;

import br.com.everest.tarefa.client.UserClient;
import br.com.everest.tarefa.model.User;
import br.com.everest.tarefa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Joao on 11/05/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserClient userClient;

    @Override
    public User findOne(Long id) {
        return this.userClient.findOne(id);
    }
}
