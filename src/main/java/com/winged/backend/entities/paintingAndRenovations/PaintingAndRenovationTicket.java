package com.winged.backend.entities.paintingAndRenovations;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaintingAndRenovationTicket {
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
    private double areaInSqft;
//    private int brand;
//    private int type;
//    private int color;
//    private int price;
//    private int Quantity;
    // Automated Data //
//    private double componentPrice;
    private double pricePerSqft;
    private double servicePrice;
    private double consultationFee;
    private int commitmentDays;
    private double totalPrice;
    private LocalDate approvalDate;
    private LocalDate updatedDate;
    private String status;
    private String paymentStatus;
    private boolean isDeleted;
}
