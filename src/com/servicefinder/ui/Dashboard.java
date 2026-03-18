package com.servicefinder.ui;

import javax.swing.*;

public class Dashboard {

    public Dashboard() {

        JFrame frame = new JFrame("Dashboard");

        JLabel title = new JLabel("Welcome to Service Finder");
        title.setBounds(80, 20, 250, 30);

        JButton bookService = new JButton("Book Service");
        bookService.setBounds(100, 80, 150, 30);

        JButton viewBookings = new JButton("View Bookings");
        viewBookings.setBounds(100, 130, 150, 30);

        frame.add(title);
        frame.add(bookService);
        frame.add(viewBookings);

        frame.setSize(350, 300);
        frame.setLayout(null);
        frame.setVisible(true);

        bookService.addActionListener(e -> new BookingPage());
        viewBookings.addActionListener(e -> new ViewBookingsPage());
    }
}