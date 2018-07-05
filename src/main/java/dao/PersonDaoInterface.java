package dao;

import java.io.Serializable;
import java.util.List;

public interface PersonDaoInterface<T, Id extends Serializable> {
    void persist(T entity);

    void update(T entity);

    T findByPesel(Id pesel);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
