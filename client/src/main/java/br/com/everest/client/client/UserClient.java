package br.com.everest.client.client;

import br.com.everest.tarefa.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Joao on 11/05/2017.
 */

@FeignClient(value = "auth-service", path = "/auth/user")
public interface UserClient {

    @RequestMapping(value = "/logado", method = RequestMethod.GET)
    User logado();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findOne(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.GET)
    List<User> findAll();
}
