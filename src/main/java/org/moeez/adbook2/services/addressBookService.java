package org.moeez.adbook2.services;

import org.moeez.adbook2.dao.addressDao;
import org.moeez.adbook2.models.address;
import org.moeez.adbook2.models.connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressBookService {
    @Autowired
    private connection connection;

    @Autowired
    private addressDao addressDao;

    public boolean insertAddress(address newAddress){

        return addressDao.AddAddress(newAddress,connection);
    }

    public address GetAddressById(int id){
        address address=addressDao.LoadAddressById(id,connection);
        System.out.println(address);
        return address;
    }

    public boolean updateAddress(address updateAddress){
        return addressDao.UpdateAddress(updateAddress,connection);
    }

    public boolean deleteAddressById(int id){
        return addressDao.DeleteAddressById(id,connection);
    }


}
