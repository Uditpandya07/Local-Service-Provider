package com.servicefinder.database;

import com.servicefinder.model.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public void insertBooking(Booking booking) {

        String query = "INSERT INTO bookings (booking_id, customer_id, provider_id, service_type, status) VALUES (?, ?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("No database connection.");
                return;
            }

            ps = con.prepareStatement(query);
            ps.setInt(1, booking.getBookingId());
            ps.setInt(2, booking.getCustomerId());
            ps.setInt(3, booking.getProviderId());
            ps.setString(4, booking.getServiceType());
            ps.setString(5, booking.getStatus());

            ps.executeUpdate();
            System.out.println("Booking inserted into database.");

        } catch (SQLException e) {
            System.out.println("Error inserting booking: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources.");
            }
        }
    }

    public List<Booking> getAllBookings() {

        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT booking_id, customer_id, provider_id, service_type, status FROM bookings";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("No database connection.");
                return bookings;
            }

            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("customer_id"),
                        rs.getInt("provider_id"),
                        rs.getString("service_type"),
                        rs.getString("status")
                );
                bookings.add(booking);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching bookings: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources.");
            }
        }

        return bookings;
    }

    public boolean updateStatus(int bookingId, String status) {

        String query = "UPDATE bookings SET status = ? WHERE booking_id = ?";

        Connection con = null;
        PreparedStatement ps = null;
        boolean updated = false;

        try {
            con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("No database connection.");
                return false;
            }

            ps = con.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, bookingId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                updated = true;
            }

        } catch (SQLException e) {
            System.out.println("Error updating status: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources.");
            }
        }

        return updated;
    }
}