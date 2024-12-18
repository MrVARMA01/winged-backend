package com.winged.backend.entities.electronics;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ElectronicsCompQualityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long BrandId;
    private long ModelId;
    private long componentId;
    private String type;
    private double price;
}
