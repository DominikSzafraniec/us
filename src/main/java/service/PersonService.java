package service;

import dao.impl.PersonDao;
import model.Person;

import java.util.List;

public class PersonService {
    private static PersonDao personDao;

    public PersonService() {personDao=new PersonDao();}
    public void persist(Person entity)
    {
        personDao.openCurrentSessionWithTransaction();
        personDao.persist(entity);
        personDao.closeCurrentSessionWithTransaction();
    }
    public void update(Person entity) {
        personDao.openCurrentSessionWithTransaction();
        personDao.update(entity);
        personDao.closeCurrentSessionWithTransaction();

    }

    public Person findByPesel(Long pesel) {
        personDao.openCurrentSession();
        Person person = personDao.findByPesel(pesel);
        personDao.closeCurrentSession();
        return person;
    }

    public void delete(Long pesel) {
        personDao.openCurrentSessionWithTransaction();
        Person person = personDao.findByPesel(pesel);
        personDao.delete(person);
        personDao.closeCurrentSessionWithTransaction();
    }

    public List<Person> findAll() {
        personDao.openCurrentSession();
        List<Person> persons = personDao.findAll();
        personDao.closeCurrentSession();
        return persons;
    }

    public void deleteAll() {
        personDao.openCurrentSessionWithTransaction();
        personDao.deleteAll();
        personDao.closeCurrentSessionWithTransaction();
    }
}
