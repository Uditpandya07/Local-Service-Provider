package com.servicefinder.model;

public class Admin extends User {

    public Admin() {
    }

    public Admin(int id, String name, String phone, String email, String location) {
        super(id, name, phone, email, location);
    }

    public void verifyProvider(ServiceProvider provider) {
        provider.setVerified(true);
        System.out.println("Provider verified successfully.");
    }
}