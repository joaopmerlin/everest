package com.everest.api.service.impl;

import com.everest.api.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Joao on 30/05/2017.
 */
public abstract class CrudServiceImpl<T, ID extends Serializable> implements CrudService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public <S extends T> S save(S entity) {
        entity = preSave(entity);
        return getRepository().save(entity);
    }

    @Override
    public <S extends T> List<S> save(List<S> list) {
        return getRepository().save(list);
    }

    @Override
    public T findOne(ID id) {
        return getRepository().findOne(id);
    }

    @Override
    public boolean exists(ID id) {
        return getRepository().exists(id);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(List<ID> list) {
        return getRepository().findAll(list);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void delete(ID id) {
        getRepository().delete(id);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void delete(List<? extends T> list) {
        getRepository().delete(list);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

    protected <S extends T> S preSave(S entity) {
        return entity;
    }
}
