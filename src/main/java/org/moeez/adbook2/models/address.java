package org.moeez.adbook2.models;



public class address {
    private int id;
    private String name;
    private String city;
    private String country;
    private String gender;


    public address(int id, String name, String city, String country, String gender) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.gender = gender;
    }

    public address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "Address details: " +" id=" + id +", name=" + name + ", city=" + city + ", country=" + country + ", gender=  " + gender +".\n";

    }
}
