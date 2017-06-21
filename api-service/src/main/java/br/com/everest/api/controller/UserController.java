package br.com.everest.api.controller;

import br.com.everest.api.model.User;
import br.com.everest.api.service.CrudService;
import br.com.everest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, Long> {

    @Autowired private UserService service;

    @Override
    protected CrudService<User, Long> getService() {
        return service;
    }

    @GetMapping("findByEmailOrUsername")
    public User findByEmailOrUsername(String emailOrUsername){
        Optional<User> user = service.findByEmailOrUsername(emailOrUsername);
        return user.isPresent() ? user.get() : null;
    }
}
