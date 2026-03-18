package com.servicefinder.service;

import com.servicefinder.model.Booking;

public interface BookingOperations {

    void createBooking(Booking booking);

    void updateBookingStatus(int bookingId, String status);

    void cancelBooking(int bookingId);
}