package com.everest.api.repository;

import com.everest.api.model.Frame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joao on 29/05/2017.
 */

@Repository
public interface FrameRepository extends JpaRepository<Frame, Long> {
}
