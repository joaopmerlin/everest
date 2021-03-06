package com.everest.api.controller;

import com.everest.api.model.TeamUser;
import com.everest.api.service.CrudService;
import com.everest.api.service.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("team-user")
public class TeamUserController extends CrudController<TeamUser, Long> {

    @Autowired
    private TeamUserService service;

    @Override
    protected CrudService<TeamUser, Long> getService() {
        return service;
    }
}
