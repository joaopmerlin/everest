package com.everest.api.repository;

import com.everest.api.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joao on 29/05/2017.
 */

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
