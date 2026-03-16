package com.servicefinder.model;

public class User {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String location;

    public User() {
    }

    public User(int id, String name, String phone, String email, String location) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void displayUser() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Location: " + location);
    }
}