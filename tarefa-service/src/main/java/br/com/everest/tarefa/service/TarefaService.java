package br.com.everest.tarefa.service;

import br.com.everest.tarefa.model.Tarefa;

import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */
public interface TarefaService {

    Tarefa save(Tarefa tarefa);

    void remove(Tarefa tarefa);

    List<Tarefa> findAll();

    Tarefa findOne(Long id);
}
