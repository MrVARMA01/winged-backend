package com.winged.backend.services.electronics;
import com.winged.backend.entities.electronics.ElectronicsCompQualityType;
import java.util.List;

public interface ElectronicsCompQualityTypeService {
    String addCompQualityType(ElectronicsCompQualityType type);
    List<ElectronicsCompQualityType> allCompQualityTypes();
    ElectronicsCompQualityType compQualityType(long id);
    List<ElectronicsCompQualityType> QualityTypesByComponentId(long id);

}
