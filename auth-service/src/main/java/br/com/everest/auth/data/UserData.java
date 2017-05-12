package br.com.everest.auth.data;

import br.com.everest.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by joao on 11/05/17.
 */

@Repository
public interface UserData extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
