package br.com.everest.client.controller;

import br.com.everest.client.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Joao on 11/05/2017.
 */

@Controller
@RequestMapping
public class HomeController {

    @Autowired private UserClient userClient;

    @GetMapping
    public String home(Model model){
        model.addAttribute("user", this.userClient.logado());
        return "home";
    }
}
