package service;

import dao.impl.AddressDao;
import model.Address;

import java.util.List;

public class AddressService {
    private static AddressDao addressDao;

    public AddressService() {addressDao=new AddressDao();}

    public void persist(Address entity)
    {
        addressDao.openCurrentSessionWithTransaction();
        addressDao.persist(entity);
        addressDao.closeCurrentSessionWithTransaction();
    }
    public void update(Address entity) {
        addressDao.openCurrentSessionWithTransaction();
        addressDao.update(entity);
        addressDao.closeCurrentSessionWithTransaction();

    }

    public Address findById(Long id) {
        addressDao.openCurrentSession();
        Address address = addressDao.findById(id);
        addressDao.closeCurrentSession();
        return address;
    }

    public void delete(Long id) {
        addressDao.openCurrentSessionWithTransaction();
        Address address = addressDao.findById(id);
        addressDao.delete(address);
        addressDao.closeCurrentSessionWithTransaction();
    }

    public List<Address> findAll() {
        addressDao.openCurrentSession();
        List<Address> addresses = addressDao.findAll();
        addressDao.closeCurrentSession();
        return addresses;
    }

    public void deleteAll() {
        addressDao.openCurrentSessionWithTransaction();
        addressDao.deleteAll();
        addressDao.closeCurrentSessionWithTransaction();
    }
}
