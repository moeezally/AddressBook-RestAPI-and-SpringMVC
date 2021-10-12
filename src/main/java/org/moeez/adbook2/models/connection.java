package org.moeez.adbook2.models;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.sql.*;


@Component
public class connection {

    private final String url = "jdbc:mysql://localhost:3306/adresses";
    private final String dbUsername = "root";
    private final String dbPassword = "moeez99";
    private java.sql.Connection con;
    private Statement st;


    @Bean
    public Statement makeStatement() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        setCon(DriverManager.getConnection(getUrl(), getDbUsername(), getDbPassword()));
        setSt(getCon().createStatement());
        return st;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    public void closeCon() throws SQLException {
        this.con.close();
    }


    public void setSt(Statement st) {
        this.st = st;
    }

    public String getUrl() {
        return url;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }



}
