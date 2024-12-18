package com.winged.backend.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SubField {
    @Id
    @GeneratedValue
    private long subFieldId;
    private String subFieldName;
    @Column(nullable = false)
    private int serviceFieldId;
}
