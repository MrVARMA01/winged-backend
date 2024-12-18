package com.winged.backend.servicesImpls.electronics;
import com.winged.backend.entities.electronics.ElectronicDeviceModel;
import com.winged.backend.repositories.electronics.ElectronicDeviceModelRepository;
import com.winged.backend.services.electronics.ElectronicDeviceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ElectronicDeviceModelServiceImpl implements ElectronicDeviceModelService {
    @Autowired
    private ElectronicDeviceModelRepository repository;
    @Override
    public String addModel(ElectronicDeviceModel model) {
        if (model==null){
            return "Record Failed!";
        }
        else{
            repository.save(model);
            return "Record Saved!";
        }
    }

    @Override
    public List<ElectronicDeviceModel> allModels() {
        return repository.findAll();
    }

    @Override
    public List<ElectronicDeviceModel> allModelsByBrand(long id) {
        return repository.findByBrandId(id);
    }

    @Override
    public ElectronicDeviceModel model(long id) {
        return repository.findById(id);
    }
}
