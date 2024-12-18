package com.winged.backend.servicesImpls.electronics;
import com.winged.backend.entities.electronics.ElectronicsComponent;
import com.winged.backend.repositories.electronics.ElectronicsComponentRepository;
import com.winged.backend.services.electronics.ElectronicsComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElectronicsComponentServiceImpl implements ElectronicsComponentService {
    @Autowired
    private ElectronicsComponentRepository repository;
    @Override
    public String addComponentAndPrice(ElectronicsComponent componentAndPrice) {
        if (componentAndPrice==null){
            return "Record Failed!";
        }
        else {
            repository.save(componentAndPrice);
            return "Record Saved!";
        }
    }

    @Override
    public List<ElectronicsComponent> allComponentsAndPrices() {
        return repository.findAll();
    }


    @Override
    public ElectronicsComponent ComponentAndPrice(long id) {
        return repository.findById(id);
    }
}
