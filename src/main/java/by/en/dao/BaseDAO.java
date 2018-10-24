package by.en.dao;

import by.en.entity.BaseEntity;

import java.util.List;

public interface BaseDAO<T extends BaseEntity>{
    List<T> findAll();
    T getById(Long id);
    void save(T entity);
    void delete(T entity);
    void update(T entity);
}
