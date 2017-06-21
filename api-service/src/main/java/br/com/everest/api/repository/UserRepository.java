package br.com.everest.api.repository;

import br.com.everest.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Joao on 29/05/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = ?1 or u.username = ?1")
    Optional<User> findByEmailOrUsername(String emailOrUsername);
}
