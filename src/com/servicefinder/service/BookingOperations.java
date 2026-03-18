package com.servicefinder.service;

import com.servicefinder.model.Booking;
import com.servicefinder.util.InvalidBookingException;

public interface BookingOperations {

    void createBooking(Booking booking) throws InvalidBookingException;

    void updateBookingStatus(int bookingId, String status) throws InvalidBookingException;

    void cancelBooking(int bookingId) throws InvalidBookingException;
}