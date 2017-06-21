package br.com.everest.api.service.impl;

import br.com.everest.api.model.Frame;
import br.com.everest.api.repository.FrameRepository;
import br.com.everest.api.service.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class FrameServiceImpl extends CrudServiceImpl<Frame, Long> implements FrameService {

    @Autowired private FrameRepository repository;

    @Override
    protected JpaRepository<Frame, Long> getRepository() {
        return repository;
    }
}
