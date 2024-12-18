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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    @Column(unique = true)
    private long phoneNumber;
    private long addressId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "userId")
    private List<UserAddress> addresses;
    @Column(unique = true)
    private String email;
    private String password;
    private String profilePic;
    private LocalDate registeredDate;

    public User(long userId) {
        this.userId = userId;
    }

}
