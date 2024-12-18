package com.winged.backend.repositories;
import com.winged.backend.entities.ServiceField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceFieldRepository extends JpaRepository<ServiceField,Integer> {
    ServiceField findByServiceFieldId(int id);
}
