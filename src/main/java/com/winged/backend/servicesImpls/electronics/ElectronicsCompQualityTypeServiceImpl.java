package com.winged.backend.servicesImpls.electronics;
import com.winged.backend.entities.electronics.ElectronicsCompQualityType;
import com.winged.backend.repositories.electronics.ElectronicsCompQualityTypeRepository;
import com.winged.backend.services.electronics.ElectronicsCompQualityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElectronicsCompQualityTypeServiceImpl implements ElectronicsCompQualityTypeService {
    @Autowired
    private ElectronicsCompQualityTypeRepository repository;
    @Override
    public String addCompQualityType(ElectronicsCompQualityType type) {
        if (type == null){
            return "Record Failed!";
        }else {
            repository.save(type);
            return "Record Saved!";
        }
    }

    @Override
    public List<ElectronicsCompQualityType> allCompQualityTypes() {
        return repository.findAll();
    }

    @Override
    public ElectronicsCompQualityType compQualityType(long id) {
        return repository.findById(id);
    }

    @Override
    public List<ElectronicsCompQualityType> QualityTypesByComponentId(long id) {
        return repository.findByComponentId(id);
    }
}
