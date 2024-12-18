package com.winged.backend.repositories.electronics;
import com.winged.backend.entities.electronics.ElectronicsComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicsComponentRepository extends JpaRepository<ElectronicsComponent,Long> {
    ElectronicsComponent findById(long id);
}
