package br.com.everest.client.controller;

import br.com.everest.client.client.TarefaClient;
import br.com.everest.tarefa.model.Tarefa;
import br.com.everest.tarefa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */

@Controller
@RequestMapping("tarefa")
public class TarefaController extends BasicController {

    @Autowired private TarefaClient tarefaClient;

    @Override
    protected String template() {
        return "tarefa";
    }

    @GetMapping("find")
    public @ResponseBody List<Tarefa> find(){
        return this.tarefaClient.findAll();
    }

    @GetMapping("last")
    public @ResponseBody List<Tarefa> last(){
        return this.tarefaClient.findLast();
    }

    @PostMapping
    public @ResponseBody Tarefa save(@RequestBody @Valid Tarefa tarefa){
        return this.tarefaClient.save(tarefa);
    }
}
