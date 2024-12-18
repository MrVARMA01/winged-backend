package com.winged.backend.entities.electronics;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ElectronicDeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long actualServiceId;
    private long brandId;
    @Column(unique = true)
    private String modelName;

}
