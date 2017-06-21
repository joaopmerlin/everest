package br.com.everest.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by joao on 11/05/17.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping
    public Principal principal(Principal principal) {
        return principal;
    }
}
