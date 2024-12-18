package com.winged.backend.servicesImpls;
import com.winged.backend.entities.ServiceField;
import com.winged.backend.repositories.ServiceFieldRepository;
import com.winged.backend.services.ServiceFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceFieldServiceImpl implements ServiceFieldService {
    @Autowired
    private ServiceFieldRepository repository;
    @Override
    public String saveServiceField(ServiceField field) {
        try{
            repository.save(field);
            return "Service Field Added!";
        }catch (Exception e){
            return "Adding Service Field Failed!";
        }

    }

    @Override
    public List<ServiceField> allServiceFields() {
        return repository.findAll();
    }

    @Override
    public ServiceField fieldById(int id) {
        return repository.findByServiceFieldId(id);
    }
}
