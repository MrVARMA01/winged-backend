package com.winged.backend.entities.electronics;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ElectronicsTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long bookingId;
    private LocalDate bookingDate;
    private String customerName;
    private String email;
    private long phone;
    private String address;
    private int serviceField;
    private long subField;
    private long actualService;
    private String issueDescription;
    private int brand;
    private int model;
    private int component;
    private int componentType;
    //    private int type;
    //    private int Quantity;
    // Automated Data //
    private double componentPrice;
    private double servicePrice;
    private int commitmentDays;
    private double totalPrice;
    private LocalDate approvalDate;
    private LocalDate updatedDate;
    private String status;
    private String paymentStatus;
    private boolean isDeleted;
}
