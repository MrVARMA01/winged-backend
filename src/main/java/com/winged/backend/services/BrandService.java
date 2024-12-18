package com.winged.backend.services;
import com.winged.backend.entities.Brand;
import java.util.List;

public interface BrandService {
    String addBrand(Brand brand);
    List<Brand> allBrands();
    List<Brand> allBrandsByServiceField(long id);

    Brand brand(long id);
}
