package com.servicefinder.service;

import com.servicefinder.model.Booking;
import com.servicefinder.util.InvalidBookingException;
import com.servicefinder.database.BookingDAO;
import com.servicefinder.service.NotificationThread;

import java.util.ArrayList;
import java.util.List;

public class BookingService implements BookingOperations {

    private static List<Booking> bookings = new ArrayList<>();
    private BookingDAO bookingDAO = new BookingDAO();

    @Override
    public void createBooking(Booking booking) {
        if (booking == null) {
            try {
                throw new InvalidBookingException("Booking cannot be null");
            } catch (InvalidBookingException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        bookings.add(booking);
        bookingDAO.insertBooking(booking);

        NotificationThread nt = new NotificationThread("New booking created!");
        nt.start();

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

    public List<Booking> getBookings() {
        return bookings;
    }
}