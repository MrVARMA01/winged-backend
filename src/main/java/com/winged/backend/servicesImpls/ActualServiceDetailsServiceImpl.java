package com.winged.backend.servicesImpls;

import com.winged.backend.entities.ActualServiceDetails;
import com.winged.backend.repositories.ActualServiceDetailsRepository;
import com.winged.backend.services.ActualServiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualServiceDetailsServiceImpl implements ActualServiceDetailsService {
    @Autowired
    private ActualServiceDetailsRepository repository;
    @Override
    public String addActualServiceDetails(ActualServiceDetails details) {
        if (details.getActualServiceId() == 0){
            return "Please Enter Actual Service ID";
        }
        else {
            repository.save(details);
            return "Record Saved!";
        }
    }

    @Override
    public ActualServiceDetails actualServiceDetails(long id) {
        return repository.findByActualServiceId(id);
    }

    @Override
    public List<ActualServiceDetails> allActualServiceDetails() {
        return repository.findAll();
    }
}
