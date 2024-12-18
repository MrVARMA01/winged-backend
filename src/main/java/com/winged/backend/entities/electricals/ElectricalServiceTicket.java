package com.winged.backend.entities.electricals;

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
public class ElectricalServiceTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String customerName;
    private String email;
    private long phone;
    private String address;
    private int serviceField;
    private int subField;
    private int service;
    private int brand;
    private int type;
    private int color;
    private int otherComponents;
    private String issueDescription;
    // Approval Data //
    private double paintsPrice;
    private double componentsPrice;
    private int areaInMeters;
    private double servicePrice;
    private int commitmentDays;
    private double TotalPrice;
    private LocalDate bookingDate;
    private String status;
    private boolean isDeleted;
}
