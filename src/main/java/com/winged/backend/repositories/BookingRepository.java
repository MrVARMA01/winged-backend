package com.winged.backend.repositories;
import com.winged.backend.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Query("SELECT b FROM Booking b WHERE b.isDeleted = false")
    List<Booking> findAllBookings();
    List<Booking> findByEmail(String email);
    @Query("SELECT b FROM Booking b WHERE b.userId = :userId AND b.status = 'Booked'")
    List<Booking> findByUserId( long userId);
    Booking findById(long id);
    List<Booking> findByBookingDate(LocalDate date);
    @Query("SELECT t FROM Booking t WHERE YEAR(t.bookingDate) = YEAR(CURRENT_DATE()) AND MONTH(t.bookingDate) = MONTH(CURRENT_DATE())")
    List<Booking> findBookingsOfMonth();
    @Query("SELECT t FROM Booking t WHERE YEAR(t.bookingDate) = YEAR(CURRENT_DATE())")
    List<Booking> findBookingsOfYear();
}
