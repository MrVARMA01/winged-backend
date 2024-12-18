package com.winged.backend.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ServiceField {
    @Id
    @GeneratedValue
    private int serviceFieldId;
    @Column(unique = true)
    private String fieldName;
    private String serviceImage;
}
