package com.servicefinder.model;

public class ServiceProvider extends User {

    private String serviceType;
    private boolean verified;

    public ServiceProvider() {
    }

    public ServiceProvider(int id, String name, String phone, String email, String location, String serviceType, boolean verified) {
        super(id, name, phone, email, location);
        this.serviceType = serviceType;
        this.verified = verified;
    }

    public String getServiceType() {
        return serviceType;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void displayProvider() {
        displayUser();
        System.out.println("Service Type: " + serviceType);
        System.out.println("Verified: " + verified);
    }
}