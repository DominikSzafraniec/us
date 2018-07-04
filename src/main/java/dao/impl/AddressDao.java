package dao.impl;

import dao.AddressDaoInterface;
import model.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static config.DatabaseConfiguration.getSessionFactory;

public class AddressDao implements AddressDaoInterface<Address,Long> {
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


    public void persist(Address entity) {
        getCurrentSession().save(entity);
    }


    public void update(Address entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Address findById(Long id) {
        Address address = getCurrentSession().get(Address.class, id);
        return address;

    }

    public void delete(Address entity) {
        getCurrentSession().delete(entity);
    }

    public List<Address> findAll() {
        @SuppressWarnings("unchecked")
        List<Address> adresses = (List<Address>) getCurrentSession().createQuery("from Address ").list();
        return adresses;
    }

    public void deleteAll() {
        List<Address> entityList = findAll();
        for (Address entity : entityList) {
            delete(entity);
        }

    }

}
