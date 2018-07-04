package dao.impl;

import dao.AddressDaoInterface;
import model.Address;

import java.util.List;

public class AddressDao implements AddressDaoInterface<Address,Long> {

    @Override
    public void persist(Address entity) {
        
    }

    @Override
    public void update(Address entity) {

    }

    @Override
    public Address findById(Long aLong) {
        return null;
    }

    @Override
    public void delete(Address entity) {

    }

    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
