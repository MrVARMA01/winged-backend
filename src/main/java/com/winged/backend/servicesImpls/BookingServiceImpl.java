package com.winged.backend.servicesImpls;
import com.winged.backend.entities.Booking;
import com.winged.backend.entities.User;
import com.winged.backend.repositories.ActualServiceRepository;
import com.winged.backend.repositories.BookingRepository;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository repository;
    @Autowired
    private ActualServiceRepository actualServiceRepository;
    @Autowired
    private UserRepository userRepository;

    public String validateBooking(Booking booking) throws NullPointerException {
        User user = userRepository.findByUserId(booking.getUserId());
        if (user == null){
            return "USER DOES NOT EXIST!";
        }
        else {
            if (booking.getCustomerName().equals("") || booking.getCustomerName().equals(null)) {
                return "Enter proper name";
            } else if (booking.getEmail().equals("") || booking.getEmail().equals(null)) {
                return "Enter proper email";
            } else if (booking.getPhone() == 0 || booking.getPhone() == 91) {
                return "Enter proper phone";
            } else if (booking.getAddress() == 0) {
                return "Invalid Address";
            } else if (booking.getServiceField() == 0) {
                return "Invalid Service-Field";
            } else if (booking.getSubField() == 0) {
                return "Invalid Sub-Field";
            } else if (booking.getActualService() == 0) {
                return "Invalid Actual-service";
            } else {
                String str = Long.toString(booking.getPhone());
                Pattern phonePtrn = Pattern.compile("(0/91)?[6-9][0-9]{11}");
                Matcher match = phonePtrn.matcher(str);
                boolean isValid1 = match.find() && match.group().equals(str);

                Pattern emailPtrn = Pattern.compile("^(.+)@(.+)$");
                match = emailPtrn.matcher(booking.getEmail());
                boolean isValid2 = match.find() && match.group().equals(booking.getEmail());

                if (isValid1 != true || isValid2 != true) {
                    System.out.println("\n-Invalid PhoneNumber or Email");
                    throw new NullPointerException();
                } else {
                    return "Booking validated!";
                }
            }
        }
    }

    @Override
    public String createBooking(Booking booking) {
        try {
            String isValidated = validateBooking(booking);
            if (isValidated.equals("Booking validated!")){
                System.out.println(isValidated);
                booking.setBookingDate(LocalDate.now());
                booking.setUpdateDate(LocalDate.now());
                booking.setStatus("BOOKED");
                booking.setDeleted(false);
                repository.save(booking);
                return "SERVICE BOOKED!";
            }else {
                return isValidated;
            }
        }catch (Exception e){
            System.out.println(e);
            return "BOOKING FAILED!";
        }
    }

    @Override
    public String updateBooking(Booking booking) {
        return null;
    }

    @Override
    public List<Booking> allBookings() {
        return repository.findAll();
    }

    @Override
    public List<Booking> allNewBookings() {
        return repository.findAllBookings();
    }

    @Override
    public List<Booking> allUserBookings(long userId) {
            return repository.findByUserId(userId);
    }

    @Override
    public Booking getBookingById(long bookingId) {
        return repository.findById(bookingId);
    }

    @Override
    public List<Booking> bookingsByDate(LocalDate date) {
        return repository.findByBookingDate(date);
    }

    @Override
    public List<Booking> bookingsToday() {
        return repository.findByBookingDate(LocalDate.now());
    }

    @Override
    public List<Booking> bookingsOfMonth() {
        return repository.findBookingsOfMonth();
    }

    @Override
    public List<Booking> bookingsOfYear() {
        return repository.findBookingsOfYear();
    }

    @Override
    public boolean deleteBooking(long id) {
        Booking booking = getBookingById(id);
        if (booking != null){
            booking.setDeleted(true);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean permanentlyDeleteBooking(long id) {
        return false;
    }


}
