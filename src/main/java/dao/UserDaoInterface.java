package dao;

import java.io.Serializable;
import java.util.List;

public interface UserDaoInterface<T, Id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    public T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();

    List<T> customQuery();

    T findByUsername(String login);

    T findByUsernameAndPassword(String login, String password);
}
