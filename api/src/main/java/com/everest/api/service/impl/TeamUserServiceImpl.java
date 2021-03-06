package com.everest.api.service.impl;

import com.everest.api.model.Team;
import com.everest.api.model.TeamUser;
import com.everest.api.model.User;
import com.everest.api.repository.TeamUserRepository;
import com.everest.api.service.TeamUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class TeamUserServiceImpl extends CrudServiceImpl<TeamUser, Long> implements TeamUserService {

    @Autowired
    private TeamUserRepository repository;

    @Override
    protected JpaRepository<TeamUser, Long> getRepository() {
        return repository;
    }

    @Override
    public List<User> findByTeam(Team team) {
        return repository.findByTeam(team);
    }
}
