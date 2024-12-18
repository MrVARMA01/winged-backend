package com.winged.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String empCode;
    String name;
    @Column(unique = true)
    long phoneNumber;
    String address;
    @Column(unique = true)
    String pan;
    @Column(unique = true)
    long aadhar;
    @Column(unique = true)
    String email;
    String password;
    String profilePic;
    LocalDate joiningDate;
    LocalDate leftDate;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
