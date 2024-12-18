package com.winged.backend.servicesImpls;
import com.winged.backend.entities.ActualService;
import com.winged.backend.entities.ActualServiceDetails;
import com.winged.backend.repositories.ActualServiceDetailsRepository;
import com.winged.backend.repositories.ActualServiceRepository;
import com.winged.backend.services.ActualServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualServiceServiceImpl implements ActualServiceService {
    @Autowired
    private ActualServiceRepository repository;
    @Autowired
    private ActualServiceDetailsRepository detailsRepository;
    @Override
    public String addActualService(ActualService service) {
        try {
            // Save ActualService, which will also save ActualServiceDetails due to CascadeType.ALL
            repository.save(service);
            return "Actual Service Added !";
        }catch (Exception e){
            System.out.println(e);
            return "Adding Actual Service Failed";
        }

    }

    @Override
    public List<ActualService> allActualServices() {
        return repository.findAll();
    }

    @Override
    public ActualService actualServiceById(long id) {
        return repository.findByActualServiceId(id);
    }

    @Override
    public List<ActualService> actualServicesBySubService(long id) {
        return repository.findBySubFieldId(id);
    }
}
