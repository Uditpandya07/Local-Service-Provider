package com.servicefinder.util;

import com.servicefinder.model.Booking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "bookings.txt";

    public static void saveBookingsToFile(List<Booking> bookings) {

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Booking b : bookings) {
                writer.write(
                    b.getBookingId() + "," +
                    b.getCustomerId() + "," +
                    b.getProviderId() + "," +
                    b.getServiceType() + "," +
                    b.getStatus()
                );
                writer.newLine();
            }

            System.out.println("Bookings saved to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }

    public static List<Booking> loadBookingsFromFile() {

        List<Booking> bookings = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 5) {
                    Booking booking = new Booking(
                            Integer.parseInt(parts[0]),
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[2]),
                            parts[3],
                            parts[4]
                    );
                    bookings.add(booking);
                }
            }

            System.out.println("Bookings loaded from file.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }

        return bookings;
    }
}