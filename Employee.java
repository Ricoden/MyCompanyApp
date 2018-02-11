package com.example.roman.mycompanyapp;

/**
 * Created by roman on 11.02.2018.
 */

public class Employee {
    private String name;
    private String position;
    private String city;
    private int followers;
    private int photo;


    Employee(String name, String position, String city, int followers, int photo){
        this.name = name;
        this.position = position;
        this.city = city;
        this.followers = followers;
        this.photo = photo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
