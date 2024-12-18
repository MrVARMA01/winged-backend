package com.winged.backend.entities.electronics;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ElectronicsComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long actualServiceId;
    private String componentName;
}
