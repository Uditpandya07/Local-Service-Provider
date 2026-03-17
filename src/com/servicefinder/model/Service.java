package com.servicefinder.model;

public class Service {

    private int serviceId;
    private String serviceName;
    private String description;

    public Service() {
    }

    public Service(int serviceId, String serviceName, String description) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
    }

    public int getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void displayService() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Service Name: " + serviceName);
        System.out.println("Description: " + description);
    }
}