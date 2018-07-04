package dao.impl;


import dao.UserDaoInterface;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.List;
import static config.DatabaseConfiguration.getSessionFactory;

public class UserDao implements UserDaoInterface<User, Long> {

    private Session currentSession;
    private Transaction currentTransaction;

    public UserDao() {

    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }


    public void persist(User entity) {
        getCurrentSession().save(entity);
    }


    public void update(User entity) {
        getCurrentSession().update(entity);
    }


    public User findById(Long id) {
        User user = getCurrentSession().get(User.class, id);
        return user;

    }

    public void delete(User entity) {
        getCurrentSession().delete(entity);
    }

    public List<User> findAll() {
        @SuppressWarnings("unchecked")
        List<User> users = (List<User>) getCurrentSession().createQuery("from User ").list();
        return users;
    }

    public void deleteAll() {
        List<User> entityList = findAll();
        for (User entity : entityList) {
            delete(entity);
        }

    }
    @SuppressWarnings("unchecked")
    public List<User> customQuery() {
        List<User> users = (List<User>) getCurrentSession().createNativeQuery("Select * from User where User.id > 2").list();
        return users;
    }

    @Override
    public User findByLogin(String login) {
        Query query = getCurrentSession().createNativeQuery("select user.id from user where user.login = :login")
                .setParameter("login",login);
        BigInteger tmp = (BigInteger) query.getSingleResult();
        User user = getCurrentSession().get(User.class,tmp.longValue());
        return user;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public User findByLoginAndPassword(String login, String password)
    {
        Query query = getCurrentSession().createNativeQuery("select user.id from user where user.login = :login and user.password = :password")
                .setParameter("login", login).setParameter("password", password);
        BigInteger tmp = (BigInteger) query.getSingleResult();
        User user = getCurrentSession().get(User.class, tmp.longValue());
        return user;
    }

}
