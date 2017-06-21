package br.com.everest.api.service.impl;

import br.com.everest.api.model.Card;
import br.com.everest.api.repository.CardRepository;
import br.com.everest.api.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Joao on 30/05/2017.
 */

@Service
@Transactional
public class CardServiceImpl extends CrudServiceImpl<Card, Long> implements CardService {

    @Autowired private CardRepository repository;

    @Override
    protected JpaRepository<Card, Long> getRepository() {
        return repository;
    }
}
