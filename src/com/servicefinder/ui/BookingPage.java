package com.servicefinder.ui;

import com.servicefinder.model.Booking;
import com.servicefinder.service.BookingService;
import com.servicefinder.util.InvalidBookingException;
import java.awt.*;
import javax.swing.*;

public class BookingPage {

    private BookingService bookingService = new BookingService();

    public BookingPage(JFrame parent) {

        JDialog dialog = new JDialog(parent, "Book a Service", true);
        dialog.setSize(350, 250);
        dialog.setLocationRelativeTo(parent);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Book a Service", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel customerLabel = new JLabel("Customer ID:");
        JTextField customerField = new JTextField();

        JLabel serviceLabel = new JLabel("Service:");
        String[] services = {"Electrician", "Plumber", "Mechanic"};
        JComboBox<String> serviceBox = new JComboBox<>(services);

        formPanel.add(customerLabel);
        formPanel.add(customerField);
        formPanel.add(serviceLabel);
        formPanel.add(serviceBox);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton bookButton = new JButton("Confirm Booking");
        mainPanel.add(bookButton, BorderLayout.SOUTH);

        dialog.add(mainPanel);

        bookButton.addActionListener(e -> {
            String customerText = customerField.getText().trim();

            if (customerText.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "Please enter a customer ID.");
                return;
            }

            try {
                int customerId = Integer.parseInt(customerText);
                String service = (String) serviceBox.getSelectedItem();

                bookButton.setEnabled(false);
                bookButton.setText("Booking...");

                Booking booking = new Booking(
                        (int) (Math.random() * 1000),
                        customerId,
                        201,
                        service,
                        "Requested"
                );

                Thread bookingThread = new Thread(() -> {
                    try {
                        bookingService.createBooking(booking);
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(dialog, "Booking successful!");
                            dialog.dispose();
                        });
                    } catch (InvalidBookingException ex) {
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(dialog, ex.getMessage());
                            bookButton.setEnabled(true);
                            bookButton.setText("Confirm Booking");
                        });
                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage());
                            bookButton.setEnabled(true);
                            bookButton.setText("Confirm Booking");
                        });
                    }
                });

                bookingThread.start();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Customer ID must be a number.");
            }
        });

        dialog.setVisible(true);
    }
}