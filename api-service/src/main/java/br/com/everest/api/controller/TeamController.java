package br.com.everest.api.controller;

import br.com.everest.api.model.Team;
import br.com.everest.api.service.CrudService;
import br.com.everest.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("team")
public class TeamController extends CrudController<Team, Long> {

    @Autowired private TeamService service;

    @Override
    protected CrudService<Team, Long> getService() {
        return service;
    }
}
