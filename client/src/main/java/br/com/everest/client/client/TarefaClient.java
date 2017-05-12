package br.com.everest.client.client;

import br.com.everest.tarefa.model.Tarefa;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */

@FeignClient(value = "tarefa-service", path = "tarefa")
public interface TarefaClient {

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Tarefa findOne(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET)
    List<Tarefa> findAll();

    @RequestMapping(method = RequestMethod.POST)
    Tarefa save(@RequestBody Tarefa tarefa);

    @RequestMapping(method = RequestMethod.DELETE)
    void remove(@RequestBody Tarefa tarefa);
}
