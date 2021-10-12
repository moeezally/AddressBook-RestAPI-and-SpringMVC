package org.moeez.adbook2.dao;

import org.moeez.adbook2.models.address;
import org.moeez.adbook2.models.connection;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component
public class addressDao {
    address newAddress;


    public ArrayList<address> LoadAddresses(connection con) {
        ArrayList<address> allAddresses=new ArrayList<>();

        try {
            Statement st = con.makeStatement();

            // 4. Create a query
            String query = "select * from adresses.address_table;";
            System.out.println(query);

            // 5. Create a ResultSet
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                String name=rs.getString("name");
                String gender=rs.getString("gender");
                String city=rs.getString("city");
                String country=rs.getString("country");
                int id=rs.getInt("id");

                address newAddress = new address(id,name,city,country,gender);
                allAddresses.add(newAddress);

            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return allAddresses;
    }

    public address LoadAddressById(int addressId, connection con){

        try {
            Statement st = con.makeStatement();

            // 4. Create a query
            String query = "select * from adresses.address_table where id="+addressId+";";
            System.out.println(query);

            // 5. Create a ResultSet
            ResultSet rs = st.executeQuery(query);

            rs.next();
                String name=rs.getString("name");
                String gender=rs.getString("gender");
                String city=rs.getString("city");
                String country=rs.getString("country");
                int id= rs.getInt("id");
                newAddress = new address(id,name,city,country,gender);


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return newAddress;

    }


    public boolean AddAddress(address newAddress, connection con){
        boolean inserted=false;

        try {
            Statement st = con.makeStatement();

            // 4. Create a query
            String query = "INSERT INTO `adresses`.`address_table`(`country`,`city`,`name`,`gender`)VALUES('" + newAddress.getCountry() + "','" + newAddress.getCity() + "','" + newAddress.getName() + "','" + newAddress.getGender() + "');";
            int result = st.executeUpdate(query);
            System.out.println(query);
            if(result!=0){
                inserted=true;
            }
            st.close();
            con.closeCon();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return inserted;
    }

    public boolean UpdateAddress(address newAddress, connection con){
        boolean updated=false;

        try {
            Statement st = con.makeStatement();

            // 4. Create a query
            String query = "UPDATE `adresses`.`address_table` SET `country` = '" + newAddress.getCountry() + "',`city` = '" + newAddress.getCity() + "',`name` = '" + newAddress.getName() + "',`gender` = '" + newAddress.getGender() + "' WHERE `id` = '" + newAddress.getId() + "';";
            int result = st.executeUpdate(query);
            System.out.println(query);
            if(result!=0){
                updated=true;
            }
            st.close();
            con.closeCon();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return updated;
    }

    public boolean DeleteAddressById(int id, connection con){
        boolean deleted=false;

        try {
            Statement st = con.makeStatement();

            // 4. Create a query
            String query = "DELETE FROM `adresses`.`address_table` WHERE id=" + id + ";";
            int result = st.executeUpdate(query);
            System.out.println(query);
            if(result!=0){
                deleted=true;
            }
            st.close();
            con.closeCon();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return deleted;
    }

}
