package dao.impl;

import dao.PersonDaoInterface;
import model.Person;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.List;

import static config.DatabaseConfiguration.getSessionFactory;

public class PersonDao implements PersonDaoInterface<Person, Long> {
    private Session currentSession;
    private Transaction currentTransaction;

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


    public void persist(Person entity) {
        getCurrentSession().save(entity);
    }


    public void update(Person entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Person findByPesel(Long pesel) {
        Query query = getCurrentSession().createNativeQuery("select person.pesel from person where person.pesel = :pesel")
                .setParameter("pesel",pesel);
        BigInteger tmp = (BigInteger) query.getSingleResult();
        Person person = getCurrentSession().get(Person.class,tmp.longValue());
        return person;
    }

    public void delete(Person entity) {
        getCurrentSession().delete(entity);
    }

    public List<Person> findAll() {
        @SuppressWarnings("unchecked")
        List<Person> persons = (List<Person>) getCurrentSession().createQuery("from Person ").list();
        return persons;
    }

    public void deleteAll() {
        List<Person> entityList = findAll();
        for (Person entity : entityList) {
            delete(entity);
        }

    }

}
