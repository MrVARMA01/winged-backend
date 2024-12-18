package com.winged.backend.repositories.electronics;
import com.winged.backend.entities.electronics.ElectronicDeviceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicDeviceModelRepository extends JpaRepository<ElectronicDeviceModel,Long> {
    ElectronicDeviceModel findById(long id);
    List<ElectronicDeviceModel> findByBrandId(long id);

}
