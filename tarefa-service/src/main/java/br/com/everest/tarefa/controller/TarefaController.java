package br.com.everest.tarefa.controller;

import br.com.everest.tarefa.model.Tarefa;
import br.com.everest.tarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> findAll(){
        return this.tarefaService.findAll();
    }

    @GetMapping("{id}")
    public Tarefa findOne(@PathVariable Long id){
        return this.tarefaService.findOne(id);
    }

    @PostMapping
    public Tarefa save(@RequestBody @Valid Tarefa tarefa){
        return this.tarefaService.save(tarefa);
    }

    @DeleteMapping
    public void remove(@RequestBody Tarefa tarefa){
        this.tarefaService.remove(tarefa);
    }
}
