package com.servicefinder.service;

import com.servicefinder.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingService implements BookingOperations {

    private List<Booking> bookings = new ArrayList<>();

    @Override
    public void createBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booking created successfully.");
    }

    @Override
    public void updateBookingStatus(int bookingId, String status) {
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                b.setStatus(status);
                System.out.println("Booking status updated.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    @Override
    public void cancelBooking(int bookingId) {
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                b.setStatus("Cancelled");
                System.out.println("Booking cancelled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void displayAllBookings() {
        for (Booking b : bookings) {
            b.displayBooking();
            System.out.println("-------------------");
        }
    }
}