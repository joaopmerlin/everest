package br.com.everest.api.repository;

import br.com.everest.api.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joao on 29/05/2017.
 */

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
