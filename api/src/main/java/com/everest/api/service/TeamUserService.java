package com.everest.api.service;

import com.everest.api.model.Team;
import com.everest.api.model.TeamUser;
import com.everest.api.model.User;

import java.util.List;

/**
 * Created by Joao on 30/05/2017.
 */
public interface TeamUserService extends CrudService<TeamUser, Long> {

    List<User> findByTeam(Team team);
}
