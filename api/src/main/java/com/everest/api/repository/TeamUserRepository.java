package com.everest.api.repository;

import com.everest.api.model.Team;
import com.everest.api.model.TeamUser;
import com.everest.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Joao on 29/05/2017.
 */

@Repository
public interface TeamUserRepository extends JpaRepository<TeamUser, Long> {

    List<User> findByTeam(Team team);
}
