package com.servicefinder.model;

public class Customer extends User {

    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String phone, String email, String location, String address) {
        super(id, name, phone, email, location);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayCustomer() {
        displayUser();
        System.out.println("Address: " + address);
    }
}