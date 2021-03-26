package by.gomel.novik.library.persistance.dao;

import by.gomel.novik.library.model.entity.Entity;

import java.util.List;

public interface BaseDao <T extends Entity> {

    T findById(long id);

    List<T> findAll();

    T save(T t);

    T update(T t);

    void deleteById(long id);
}
