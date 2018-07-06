package dao;

import java.io.Serializable;
import java.util.List;

public interface UserDaoInterface<T, Id extends Serializable> {

    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();

    List<T> customQuery();

    List<T> findByLogin(String login);

    T findByLoginAndPassword(String login, String password);
}
