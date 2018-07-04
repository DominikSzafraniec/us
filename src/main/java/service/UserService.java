package service;

import dao.impl.UserDao;
import model.User;

import java.util.List;

public class UserService {
    private static UserDao userDao;

    public UserService(){
        userDao=new UserDao();
    }

    public void persist(User entity)
    {
        userDao.openCurrentSessionWithTransaction();
        userDao.persist(entity);
        userDao.closeCurrentSessionWithTransaction();
    }
    public void update(User entity) {
        userDao.openCurrentSessionWithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionWithTransaction();

    }

    public User findById(Long id) {
        userDao.openCurrentSession();
        User user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(Long id) {
        userDao.openCurrentSessionWithTransaction();
        User user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionWithTransaction();
    }

    public List<User> findAll() {
        userDao.openCurrentSession();
        List<User> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionWithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionWithTransaction();
    }
    public List<User> customQuery() {
        userDao.openCurrentSession();
        List<User> users = userDao.customQuery();
        userDao.closeCurrentSession();
        return users;
    }

    public User findByLogin(String login)
    {
        userDao.openCurrentSession();
        User user = userDao.findByLogin(login);
        userDao.closeCurrentSession();
        return user;
    }

    public User findByLoginAndPassword(String login, String password)
    {
        userDao.openCurrentSession();
        User user = userDao.findByLoginAndPassword(login, password);
        userDao.closeCurrentSession();
        return user;
    }
}
