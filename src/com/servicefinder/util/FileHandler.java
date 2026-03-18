package com.servicefinder.util;

import com.servicefinder.model.Booking;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {

    public static void saveBookingsToFile(List<Booking> bookings) {
        try {
            FileWriter writer = new FileWriter("bookings.txt");

            for (Booking b : bookings) {
                writer.write(
                    b.getBookingId() + "," +
                    b.getCustomerId() + "," +
                    b.getProviderId() + "," +
                    b.getServiceType() + "," +
                    b.getStatus() + "\n"
                );
            }

            writer.close();
            System.out.println("Bookings saved to file.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}