package com.winged.backend.servicesImpls;
import com.winged.backend.entities.Brand;
import com.winged.backend.repositories.BrandRepository;
import com.winged.backend.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repository;
    @Override
    public String addBrand(Brand brand) {
        repository.save(brand);
        return "Record Saved!";
    }

    @Override
    public List<Brand> allBrands() {
        return repository.findAll();
    }

    @Override
    public List<Brand> allBrandsByServiceField(long id) {
        return repository.findByServiceFieldId(id);
    }

    @Override
    public Brand brand(long id) {
        return repository.findByBrandId(id);
    }
}
