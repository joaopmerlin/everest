package br.com.everest.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Joao on 30/05/2017.
 */
public interface CrudService<T, ID extends Serializable> {

    <S extends T> S save(S entity);

    <S extends T> List<S> save(List<S> list);

    T findOne(ID id);

    boolean exists(ID id);

    List<T> findAll();

    List<T> findAll(List<ID> list);

    List<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    long count();

    void delete(ID id);

    void delete(T entity);

    void delete(List<? extends T> list);

    void deleteAll();
}
