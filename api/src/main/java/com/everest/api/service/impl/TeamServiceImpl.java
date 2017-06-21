package com.everest.api.service.impl;

import com.everest.api.model.Team;
import com.everest.api.repository.TeamRepository;
import com.everest.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class TeamServiceImpl extends CrudServiceImpl<Team, Long> implements TeamService {

    @Autowired
    private TeamRepository repository;

    @Override
    protected JpaRepository<Team, Long> getRepository() {
        return repository;
    }
}
