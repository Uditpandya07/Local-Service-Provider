package com.servicefinder.service;

import com.servicefinder.model.Booking;
import com.servicefinder.util.InvalidBookingException;
import com.servicefinder.database.BookingDAO;

import java.util.ArrayList;
import java.util.List;

public class BookingService implements BookingOperations {

    private static List<Booking> bookings = new ArrayList<>();
    private BookingDAO bookingDAO = new BookingDAO();

    @Override
    public void createBooking(Booking booking) throws InvalidBookingException {

        if (booking == null) {
            throw new InvalidBookingException("Booking cannot be null.");
        }

        if (booking.getCustomerId() <= 0) {
            throw new InvalidBookingException("Invalid customer ID.");
        }

        bookings.add(booking);
        bookingDAO.insertBooking(booking);

        NotificationThread nt = new NotificationThread("New booking created for: "
                + booking.getServiceType());
        nt.start();

        System.out.println("Booking created successfully.");
    }

    @Override
    public void updateBookingStatus(int bookingId, String status) throws InvalidBookingException {

        if (status == null || status.trim().isEmpty()) {
            throw new InvalidBookingException("Status cannot be empty.");
        }

        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                b.setStatus(status);
                System.out.println("Booking status updated.");
                return;
            }
        }

        throw new InvalidBookingException("Booking ID " + bookingId + " not found.");
    }

    @Override
    public void cancelBooking(int bookingId) throws InvalidBookingException {

        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                b.setStatus("Cancelled");
                System.out.println("Booking cancelled.");
                return;
            }
        }

        throw new InvalidBookingException("Booking ID " + bookingId + " not found.");
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : bookings) {
            b.displayBooking();
            System.out.println("-------------------");
        }
    }
}