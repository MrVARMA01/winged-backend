package com.winged.backend.servicesImpls;
import com.winged.backend.entities.UserAddress;
import com.winged.backend.repositories.UserAddressRepository;
import com.winged.backend.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressRepository repository;
    @Override
    public String addAddress(UserAddress address) {
        repository.save(address);
        return "Record Saved!";
    }

    @Override
    public List<UserAddress> allAddresses() {
        return repository.findAll();
    }

    @Override
    public UserAddress address(long id) {
        return repository.findById(id);
    }
}
