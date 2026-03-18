package com.servicefinder.ui;

import java.awt.*;
import javax.swing.*;

public class LoginPage {

    public LoginPage() {

        JFrame frame = new JFrame("Local Service Finder - Login");
        frame.setSize(350, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        formPanel.add(userLabel);
        formPanel.add(userField);
        formPanel.add(passLabel);
        formPanel.add(passField);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JButton loginButton = new JButton("Login");
        mainPanel.add(loginButton, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            String username = userField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                return;
            }

            if (username.equals("admin") && password.equals("1234")) {
                frame.dispose();
                new Dashboard();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid credentials.");
                passField.setText("");
            }
        });

        passField.addActionListener(e -> loginButton.doClick());
    }
}