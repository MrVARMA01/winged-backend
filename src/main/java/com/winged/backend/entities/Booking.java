package com.winged.backend.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String customerName;
    private String email;
    private long phone;
    private long address;
    private int serviceField;
    private long subField;
    private long actualService;
    private String issueDescription;
    // Automated Data //
    private LocalDate bookingDate;
    private LocalDate updateDate;
    private LocalDate updateByEmployee;
    private String status;
    private boolean isDeleted;
}
