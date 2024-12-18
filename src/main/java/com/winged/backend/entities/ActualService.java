package com.winged.backend.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ActualService {
    @Id
    @GeneratedValue
    private long actualServiceId;
    private String service;
    @Column(nullable = false)
    private long subFieldId;
    @Column(nullable = false)
    private int serviceFieldId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_details_id")
    private ActualServiceDetails serviceDetails;

}
