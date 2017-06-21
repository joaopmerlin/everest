package br.com.everest.api.controller;

import br.com.everest.api.model.Board;
import br.com.everest.api.service.BoardService;
import br.com.everest.api.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("board")
public class BoardController extends CrudController<Board, Long> {

    @Autowired private BoardService service;

    @Override
    protected CrudService<Board, Long> getService() {
        return service;
    }
}
