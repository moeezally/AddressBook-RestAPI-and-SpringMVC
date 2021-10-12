package org.moeez.adbook2.dao;

import org.moeez.adbook2.models.connection;
import org.moeez.adbook2.models.user;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class userDao {

    public boolean validate(user User, connection con){

        boolean userExist=false;
        try {
            Statement st = con.makeStatement();

            // 4. Create a query
            String query = "select * from adresses.users where email='" + User.getEmail() + "' and password='" + User.getPassword() + "';";
            System.out.println(query);

            // 5. Create a ResultSet
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                userExist = true;
                System.out.println(rs.getRow());
            }

            // 6. Close all connections
            rs.close();
            st.close();
            con.closeCon();
        }
        catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return userExist;
    }



}
