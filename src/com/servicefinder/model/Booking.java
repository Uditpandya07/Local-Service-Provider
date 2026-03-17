package com.servicefinder.model;

public class Booking {

    private int bookingId;
    private int customerId;
    private int providerId;
    private String serviceType;
    private String status;

    public Booking() {
    }

    public Booking(int bookingId, int customerId, int providerId, String serviceType, String status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.providerId = providerId;
        this.serviceType = serviceType;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProviderId() {
        return providerId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Provider ID: " + providerId);
        System.out.println("Service: " + serviceType);
        System.out.println("Status: " + status);
    }
}