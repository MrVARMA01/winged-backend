package com.winged.backend.servicesImpls;
import com.winged.backend.entities.SubField;
import com.winged.backend.repositories.SubFieldRepository;
import com.winged.backend.services.SubFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubFieldServiceImpl implements SubFieldService {
    @Autowired
    private SubFieldRepository repository;
    @Override
    public String addSubService(SubField service) {
        try {
            repository.save(service);
            return "SubService Added !";
        }catch (Exception e){
            System.out.println(e);
            return "Addidng SubService Failed !";
        }

    }

    @Override
    public List<SubField> allSubServices() {
        return repository.findAll();
    }

    @Override
    public SubField subServiceById(long id) {
        return repository.findBySubFieldId(id);
    }

    @Override
    public List<SubField> subServicesByFieldId(int id) {
        return repository.findByServiceFieldId(id);
    }
}
