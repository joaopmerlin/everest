package br.com.everest.auth.service.impl;

import br.com.everest.api.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by Joao on 29/05/2017.
 */

@FeignClient(value = "api-service", path = "/user")
public interface UserService {

    @RequestMapping(value = "/findByEmailOrUsername", method = RequestMethod.GET)
    User findByEmailOrUsername(@RequestParam("emailOrUsername") String emailOrUsername);
}
