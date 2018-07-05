package dao.impl;

import dao.AddressDaoInterface;
import model.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigInteger;
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
    public Address findAddress(Address adr) {
        Query query = getCurrentSession().createNativeQuery("select address.id from address where address.city = :city " +
                "and address.number= :number and address.postCode=:postCode and address.province=:province and address.street=:street")
                .setParameter("city",adr.getCity()).setParameter("number",adr.getNumber()).setParameter("postCode",adr.getPostCode())
                .setParameter("province",adr.getProvince()).setParameter("street",adr.getStreet());
        BigInteger tmp = (BigInteger) query.getSingleResult();
        Address address = getCurrentSession().get(Address.class, tmp.longValue());
        return address;
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
        List<Address> addresses = (List<Address>) getCurrentSession().createQuery("from Address ").list();
        return addresses;
    }

    public void deleteAll() {
        List<Address> entityList = findAll();
        for (Address entity : entityList) {
            delete(entity);
        }

    }

}
