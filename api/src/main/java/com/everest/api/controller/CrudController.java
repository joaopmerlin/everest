package com.everest.api.controller;

import com.everest.api.service.CrudService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Joao on 30/05/2017.
 */
public abstract class CrudController<T, ID extends Serializable> {

    protected abstract CrudService<T, ID> getService();

    @PostMapping
    public <S extends T> S save(@RequestBody @Valid S entity) {
        return getService().save(entity);
    }

    @PostMapping("list")
    public <S extends T> List<S> save(@RequestBody List<S> list) {
        return getService().save(list);
    }

    @GetMapping("{id}")
    public T findOne(@PathVariable("id") ID id) {
        return getService().findOne(id);
    }

    @GetMapping(value = "exists/{id}")
    public boolean exists(@PathVariable("id") ID id) {
        return getService().exists(id);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(value = "sort", required = false) String sort,
                                  @RequestParam(value = "page", required = false) Integer page,
                                  @RequestParam(value = "size", required = false) Integer size) {
        if (sort != null) {
            // property, direction
            String[] paramsSort = sort.split(",");
            Sort.Order order = new Sort.Order(Sort.Direction.fromString(paramsSort[1]), paramsSort[0]).ignoreCase();

            if (page != null && size != null) {
                return ResponseEntity.ok(getService().findAll(new PageRequest(page, size, new Sort(order))));
            }

            return ResponseEntity.ok(getService().findAll(new Sort(order)));
        }
        return ResponseEntity.ok(getService().findAll());
    }

    @GetMapping("count")
    public long count() {
        return getService().count();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ID id) {
        getService().delete(id);
    }

    @DeleteMapping
    public void delete(@RequestBody T entity) {
        getService().delete(entity);
    }
}
