package br.com.everest.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Joao on 11/05/2017.
 */

@Controller
@RequestMapping
public class HomeController extends BasicController {

    @Override
    protected String template() {
        return "home";
    }
}
