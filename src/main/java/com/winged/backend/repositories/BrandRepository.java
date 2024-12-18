package com.winged.backend.repositories;
import com.winged.backend.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findByBrandId(long id);
    List<Brand> findByServiceFieldId(long id);

}
