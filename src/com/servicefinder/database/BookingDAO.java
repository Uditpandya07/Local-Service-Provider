package com.servicefinder.database;

import com.servicefinder.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO {

    public void insertBooking(Booking booking) {

        String query = "INSERT INTO bookings (booking_id, customer_id, provider_id, service_type, status) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, booking.getBookingId());
            ps.setInt(2, booking.getCustomerId());
            ps.setInt(3, booking.getProviderId());
            ps.setString(4, booking.getServiceType());
            ps.setString(5, booking.getStatus());

            ps.executeUpdate();

            System.out.println("Booking inserted into database.");

        } catch (SQLException e) {
            System.out.println("Error inserting booking.");
        }
    }
}