package com.servicefinder.ui;

import com.servicefinder.model.Booking;
import com.servicefinder.service.BookingService;

import javax.swing.*;

public class BookingPage {

    BookingService bookingService = new BookingService();

    public BookingPage() {

        JFrame frame = new JFrame("Book Service");

        JLabel title = new JLabel("Book a Service");
        title.setBounds(120, 10, 150, 30);

        JLabel customerLabel = new JLabel("Customer ID:");
        customerLabel.setBounds(50, 50, 100, 30);

        JTextField customerField = new JTextField();
        customerField.setBounds(150, 50, 150, 30);

        JLabel serviceLabel = new JLabel("Service:");
        serviceLabel.setBounds(50, 100, 100, 30);

        String[] services = {"Electrician", "Plumber", "Mechanic"};
        JComboBox<String> serviceBox = new JComboBox<>(services);
        serviceBox.setBounds(150, 100, 150, 30);

        JButton bookButton = new JButton("Book Service");
        bookButton.setBounds(100, 150, 150, 30);

        frame.add(title);
        frame.add(customerLabel);
        frame.add(customerField);
        frame.add(serviceLabel);
        frame.add(serviceBox);
        frame.add(bookButton);

        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setVisible(true);

        bookButton.addActionListener(e -> {

            try {
                int customerId = Integer.parseInt(customerField.getText());
                String service = (String) serviceBox.getSelectedItem();

                Booking booking = new Booking(
                        (int)(Math.random() * 1000),
                        customerId,
                        201,
                        service,
                        "Requested"
                );

                bookingService.createBooking(booking);

                JOptionPane.showMessageDialog(frame, "Booking Successful!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid Input!");
            }
        });
    }
}