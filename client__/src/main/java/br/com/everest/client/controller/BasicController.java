package br.com.everest.client.controller;

import br.com.everest.client.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by joao on 12/05/17.
 */

@Component
public abstract class BasicController {

    @Autowired private UserClient userClient;

    protected abstract String template();

    @GetMapping
    public String index(Model model){
        model.addAttribute("user", this.userClient.logado());
        return template();
    }
}
