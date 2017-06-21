package com.everest.api.controller;

import com.everest.api.model.User;
import com.everest.api.service.CrudService;
import com.everest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.certpath.OCSPResponse;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, Long> {

    @Autowired
    private UserService service;

    @Override
    protected CrudService<User, Long> getService() {
        return service;
    }

    @GetMapping("userLogged")
    public User userLogged(Principal principal){
        return service.findByEmail(principal.getName()).get();
    }
}
