package com.winged.backend.servicesImpls;
import com.winged.backend.entities.Role;
import com.winged.backend.repositories.RoleRepository;
import com.winged.backend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;
    @Override
    public String addNewRole(Role role) {
        if (role != null){
            repository.save(role);
            return "Record Saved!";
        }else {
            return "Failed to Save Record!";
        }
    }

    @Override
    public List<Role> allRoles() {
        return repository.findAll();
    }

    @Override
    public Role roleById(int id) {
        return repository.findById(id);
    }
}
