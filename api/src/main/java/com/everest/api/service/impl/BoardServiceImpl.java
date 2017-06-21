package com.everest.api.service.impl;

import com.everest.api.model.Board;
import com.everest.api.repository.BoardRepository;
import com.everest.api.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class BoardServiceImpl extends CrudServiceImpl<Board, Long> implements BoardService {

    @Autowired
    private BoardRepository repository;

    @Override
    protected JpaRepository<Board, Long> getRepository() {
        return repository;
    }
}
