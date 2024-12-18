package com.winged.backend.repositories;
import com.winged.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
    User findByUserId(long userId);
    User findByPhoneNumber(long phone);
}
//    List<Booking> findByBookingDate(LocalDate date);
//    @Query("SELECT t FROM Booking t WHERE YEAR(t.bookingDate) = YEAR(CURRENT_DATE()) AND MONTH(t.bookingDate) = MONTH(CURRENT_DATE())")
//    List<Booking> findThisMonthTickets();
//    @Query("SELECT t FROM Booking t WHERE YEAR(t.bookingDate) = YEAR(CURRENT_DATE())")
//    List<Booking> findThisYearTickets();

