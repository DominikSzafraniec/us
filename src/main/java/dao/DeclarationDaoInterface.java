package dao;

import java.io.Serializable;
import java.util.List;

public interface DeclarationDaoInterface<T, Id extends Serializable> {
    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();
}