package br.com.everest.client.controller;

import br.com.everest.client.client.UserClient;
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
@RequestMapping("usuario")
public class UsuarioController extends BasicController {

    @Autowired private UserClient userClient;

    @Override
    protected String template() {
        return "usuario";
    }

    @GetMapping("find")
    public @ResponseBody List<User> find(){
        return this.userClient.findAll();
    }

    @PostMapping
    public @ResponseBody User save(@RequestBody @Valid User user){
        return this.userClient.save(user);
    }

    @PostMapping("remove")
    public @ResponseBody void remove(@RequestBody User user){
        this.userClient.remove(user);
    }
}
