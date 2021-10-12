package org.moeez.adbook2.models;


public class user {
    private String email;
    private String password;

    public user(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User's email='"+ email + ", password='" + password;
    }
}
