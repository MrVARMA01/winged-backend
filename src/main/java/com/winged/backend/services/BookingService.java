package com.winged.backend.services;
import com.winged.backend.entities.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    String createBooking(Booking booking);
    String updateBooking(Booking booking);
    List<Booking> allBookings();
    List<Booking> allNewBookings();

    List<Booking> allUserBookings(long userId);
    Booking getBookingById(long bookingId);
    List<Booking> bookingsByDate(LocalDate date);
    List<Booking> bookingsToday();
    List<Booking> bookingsOfMonth();
    List<Booking> bookingsOfYear();
    boolean deleteBooking(long id);
    boolean permanentlyDeleteBooking(long id);

}
