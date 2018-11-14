package com.messageconsumption.service.impl;

import com.messageconsumption.db.model.IdentityModel;
import com.messageconsumption.db.repositories.Repository;
import com.messageconsumption.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Seema
 * @param <E>
 * @param <R>
 */
public class BaseService<E extends IdentityModel, R extends Repository<E>> implements Service<E, R> {

    @Autowired
    private R repository;

    @Override
    public E findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAllBy(String column, String value) {
        return repository.findAllBy(column, value);
    }

    @Override
    public List<E> findAllByOffset(int from, int to) {
        return repository.findAllByOffset(from, to);
    }

    @Override
    public E findOneBy(String column, String value) {
        return repository.findOneBy(column, value);
    }

    @Override
    public void delete(E object) {
        repository.delete(object);
    }

    @Override
    public int delete(String id) {
        return repository.delete(id);
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public boolean isPresent(String column, String value) {
        return repository.isPresent(column, value);
    }
}
