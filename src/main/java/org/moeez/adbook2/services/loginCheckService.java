package org.moeez.adbook2.services;
import org.moeez.adbook2.dao.userDao;
import org.moeez.adbook2.models.connection;
import org.moeez.adbook2.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginCheckService {

    @Autowired
    private connection connection;

    @Autowired
    private userDao userDao;

    public boolean checkUser(user User) {

        return userDao.validate(User,connection);
    }
}
