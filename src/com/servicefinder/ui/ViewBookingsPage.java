package com.servicefinder.ui;

import com.servicefinder.model.Booking;
import com.servicefinder.service.BookingService;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewBookingsPage {

    private BookingService bookingService = new BookingService();

    public ViewBookingsPage(JFrame parent) {

        JDialog dialog = new JDialog(parent, "View Bookings", true);
        dialog.setSize(560, 350);
        dialog.setLocationRelativeTo(parent);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel title = new JLabel("All Bookings", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(title, BorderLayout.NORTH);

        String[] columns = {"Booking ID", "Customer ID", "Provider ID", "Service", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        JTable table = new JTable(model);
        table.setRowHeight(25);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        mainPanel.add(closeButton, BorderLayout.SOUTH);

        List<Booking> bookings = bookingService.getBookings();

        if (bookings.isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "No bookings found.");
        } else {
            for (Booking b : bookings) {
                model.addRow(new Object[]{
                        b.getBookingId(),
                        b.getCustomerId(),
                        b.getProviderId(),
                        b.getServiceType(),
                        b.getStatus()
                });
            }
        }

        dialog.add(mainPanel);

        closeButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }
}