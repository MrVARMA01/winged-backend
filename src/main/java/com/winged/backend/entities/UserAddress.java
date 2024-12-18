package com.winged.backend.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UserAddress {
        @Id
        @GeneratedValue
        private long id;
        private String country;
        private String state;
        private String city;
        private String streetAddress;
        private int pinCode;

}
