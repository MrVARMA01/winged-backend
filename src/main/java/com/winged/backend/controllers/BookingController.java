package com.winged.backend.controllers;
import com.winged.backend.entities.Booking;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class BookingController {
    @Autowired
    private BookingService service;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/new-booking")
    public ResponseEntity<?> newBooking(@RequestBody Booking booking){
            String result = service.createBooking(booking);
            Map<String, Object> response = new HashMap<>();
            if (result.equals("SERVICE BOOKED!"))
            {
                response.put("status", true);
                response.put("response", result);
                return new ResponseEntity<>(response,HttpStatus.OK);
            } else{
                response.put("status", false);
                response.put("response", result);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<?> bookingById(@PathVariable long id){
        Booking booking = service.getBookingById(id);
        Map<String, Object> response = new HashMap<>();
        if (booking != null)
        {
            response.put("status", true);
            response.put("response", booking);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "Booking not found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/all-bookings")
    public ResponseEntity<?> allBookings(){
        List<Booking> bookingsList = service.allBookings();
        Map<String, Object> response = new HashMap<>();
        if (bookingsList != null)
        {
            response.put("status", true);
            response.put("response", bookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/all-new-bookings")
    public ResponseEntity<?> allNewBookings(){
        List<Booking> newBookingsList = service.allNewBookings();
        Map<String, Object> response = new HashMap<>();
        if (newBookingsList != null)
        {
            response.put("status", true);
            response.put("response", newBookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


    @GetMapping("/user-bookings/{userid}")
    public ResponseEntity<?> allUserBookings(@PathVariable long userid){
        List<Booking> bookingsList = service.allUserBookings(userid);
        Map<String, Object> response = new HashMap<>();
        if (bookingsList != null)
        {
            response.put("status", true);
            response.put("response", bookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/bookings-by-date/{date}")
    public ResponseEntity<?> bookingsByDate(@PathVariable LocalDate date){
        List<Booking> bookingsList = service.bookingsByDate(date);
        Map<String, Object> response = new HashMap<>();
        if (bookingsList != null)
        {
            response.put("status", true);
            response.put("response", bookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/bookings-today")
    public ResponseEntity<?> bookingsToday(){
        List<Booking> bookingsList = service.bookingsToday();
        Map<String, Object> response = new HashMap<>();
        if (bookingsList != null)
        {
            response.put("status", true);
            response.put("response", bookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/bookings-of-month")
    public ResponseEntity<?> BookingsOfMonth(){
        List<Booking> bookingsList = service.bookingsOfMonth();
        Map<String, Object> response = new HashMap<>();
        if (bookingsList != null)
        {
            response.put("status", true);
            response.put("response", bookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/bookings-of-year")
    public ResponseEntity<?> BookingsOfYear(){
        List<Booking> bookingsList = service.bookingsOfYear();
        Map<String, Object> response = new HashMap<>();
        if (bookingsList != null)
        {
            response.put("status", true);
            response.put("response", bookingsList);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Bookings found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
