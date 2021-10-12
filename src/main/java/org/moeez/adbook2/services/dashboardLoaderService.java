package org.moeez.adbook2.services;

import org.moeez.adbook2.models.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class dashboardLoaderService {

    @Autowired
    private org.moeez.adbook2.models.connection connection;

    @Autowired
    private org.moeez.adbook2.dao.addressDao addressDao;

    public ArrayList<address> LoadDashboard(){
        return addressDao.LoadAddresses(connection);
    }




}
