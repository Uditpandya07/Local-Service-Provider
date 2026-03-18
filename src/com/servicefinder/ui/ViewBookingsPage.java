package com.servicefinder.ui;

import com.servicefinder.model.Booking;
import com.servicefinder.service.BookingService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewBookingsPage {

    BookingService bookingService = new BookingService();

    public ViewBookingsPage() {

        JFrame frame = new JFrame("View Bookings");

        String[] columnNames = {"Booking ID", "Customer ID", "Provider ID", "Service", "Status"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 500, 200);

        frame.add(scrollPane);

        List<Booking> bookings = bookingService.getBookings();

        for (Booking b : bookings) {
            Object[] row = {
                    b.getBookingId(),
                    b.getCustomerId(),
                    b.getProviderId(),
                    b.getServiceType(),
                    b.getStatus()
            };
            model.addRow(row);
        }

        frame.setSize(550, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}