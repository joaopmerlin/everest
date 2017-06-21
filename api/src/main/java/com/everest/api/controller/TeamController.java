package com.everest.api.controller;

import com.everest.api.model.Team;
import com.everest.api.service.CrudService;
import com.everest.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("team")
public class TeamController extends CrudController<Team, Long> {

    @Autowired
    private TeamService service;

    @Override
    protected CrudService<Team, Long> getService() {
        return service;
    }
}
