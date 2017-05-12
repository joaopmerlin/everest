package br.com.everest.tarefa.service.impl;

import br.com.everest.tarefa.data.TarefaData;
import br.com.everest.tarefa.model.Tarefa;
import br.com.everest.tarefa.service.TarefaService;
import br.com.everest.tarefa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */

@Service
@Transactional
public class TarefaServiceImpl implements TarefaService {

    @Autowired private TarefaData tarefaData;
    @Autowired private UserService userService;

    @Override
    public Tarefa save(Tarefa tarefa) {
        return this.tarefaData.save(tarefa);
    }

    @Override
    public void remove(Tarefa tarefa) {
        this.tarefaData.delete(tarefa);
    }

    @Override
    public List<Tarefa> findAll() {
        return this.tarefaData.findAll();
    }

    @Override
    public Tarefa findOne(Long id) {
        return this.tarefaData.findOne(id);
    }
}
