package com.everest.api.controller;

import com.everest.api.model.Card;
import com.everest.api.service.CardService;
import com.everest.api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("card")
public class CardController extends CrudController<Card, Long> {

    @Autowired
    private CardService service;

    @Override
    protected CrudService<Card, Long> getService() {
        return service;
    }
}
