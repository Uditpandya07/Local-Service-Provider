package com.servicefinder.ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public Dashboard() {

        JFrame frame = new JFrame("Service Finder - Dashboard");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("Welcome to Service Finder", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton bookService = new JButton("Book a Service");
        JButton viewBookings = new JButton("View Bookings");
        JButton logout = new JButton("Logout");

        buttonPanel.add(bookService);
        buttonPanel.add(viewBookings);
        buttonPanel.add(logout);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);

        bookService.addActionListener(e -> new BookingPage(frame));
        viewBookings.addActionListener(e -> new ViewBookingsPage(frame));

        logout.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                frame.dispose();
                new LoginPage();
            }
        });
    }
}