package br.com.everest.tarefa.service.impl;

import br.com.everest.tarefa.data.TarefaData;
import br.com.everest.tarefa.model.Tarefa;
import br.com.everest.tarefa.model.User;
import br.com.everest.tarefa.service.TarefaService;
import br.com.everest.tarefa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Joao on 11/05/2017.
 */

@Service
@Transactional
public class TarefaServiceImpl implements TarefaService {

    @Autowired private TarefaData tarefaData;
    @Autowired private UserService userService;

    @Override
    @CacheEvict("TarefaServiceImpl-findAll")
    public Tarefa save(Tarefa tarefa) {
        if (tarefa.getId() == null){
            tarefa.setCriacao(LocalDateTime.now());
        }
        return this.tarefaData.save(tarefa);
    }

    @Override
    @CacheEvict("TarefaServiceImpl-findAll")
    public void remove(Tarefa tarefa) {
        this.tarefaData.delete(tarefa);
    }

    @Override
    @Cacheable("TarefaServiceImpl-findAll")
    public List<Tarefa> findAll() {
        List<User> users = new ArrayList<>();
        return this.tarefaData.findAll().parallelStream().map(tarefa -> {
            if (tarefa.getUserId() != null){
                Optional<User> user = users.stream().filter(e -> e.getId() == tarefa.getUserId()).findAny();
                if (user.isPresent()){
                    tarefa.setUser(user.get());
                } else {
                    tarefa.setUser(this.userService.findOne(tarefa.getUserId()));
                }
            }
            return tarefa;
        }).collect(Collectors.toList());
    }

    @Override
    public Tarefa findOne(Long id) {
        return this.tarefaData.findOne(id);
    }
}
