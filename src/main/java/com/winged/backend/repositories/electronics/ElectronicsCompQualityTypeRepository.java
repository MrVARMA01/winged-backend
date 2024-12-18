package com.winged.backend.repositories.electronics;
import com.winged.backend.entities.electronics.ElectronicsCompQualityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ElectronicsCompQualityTypeRepository extends JpaRepository<ElectronicsCompQualityType,Long> {
    ElectronicsCompQualityType findById(long type);
    List<ElectronicsCompQualityType> findByComponentId(long type);

}
