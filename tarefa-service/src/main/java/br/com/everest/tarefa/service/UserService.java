package br.com.everest.tarefa.service;

import br.com.everest.tarefa.model.User;

/**
 * Created by Joao on 11/05/2017.
 */
public interface UserService {

    User findOne(Long id);
}
