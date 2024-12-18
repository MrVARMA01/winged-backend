package com.winged.backend.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ActualServiceDetails {
    @Id
    @GeneratedValue
    private long id;
    private long actualServiceId;
    private String serviceImage;
    private String shortDescription;
    private String fullDescription;
    private double price;
}
