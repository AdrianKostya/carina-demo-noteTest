package com.qaprosoft.carina.demo.api.randomUser.UserData;

import com.google.gson.JsonObject;

public class Location {
    private String street;
    private String city;
    private String country;
    private String postcode;
    private String obj;
    JsonObject jsonObject = new JsonObject();

    public Location(String country, String city, String street){
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Location(){

    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setCity(String city){
        this.city= city;
    }

    public void setStreet(String street){
        this.street=street;
    }

    public void setPostcode(String postcode){
        this.postcode=postcode;
    }

    public String getCountry(){
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet(){
        return this.street;
    }

    public String getPostcode() {
        return postcode;
    }

}
