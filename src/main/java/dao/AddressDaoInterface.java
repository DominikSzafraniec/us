package dao;

import java.io.Serializable;
import java.util.List;

public interface AddressDaoInterface<T,Id extends Serializable> {
    void persist(T entity);

    void update(T entity);

    T findAddress(T entity);

    public T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
