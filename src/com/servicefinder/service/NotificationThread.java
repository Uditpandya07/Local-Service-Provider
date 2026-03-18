package com.servicefinder.service;

public class NotificationThread extends Thread {

    private String message;

    public NotificationThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Notification: " + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}