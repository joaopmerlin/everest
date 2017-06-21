package br.com.everest.api.controller;

import br.com.everest.api.model.Frame;
import br.com.everest.api.service.CrudService;
import br.com.everest.api.service.FrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joao on 30/05/2017.
 */

@RestController
@RequestMapping("frame")
public class FrameController extends CrudController<Frame, Long> {

    @Autowired private FrameService service;

    @Override
    protected CrudService<Frame, Long> getService() {
        return service;
    }
}
