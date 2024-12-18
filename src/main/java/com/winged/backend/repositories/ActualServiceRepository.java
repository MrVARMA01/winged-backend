package com.winged.backend.repositories;

import com.winged.backend.entities.ActualService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActualServiceRepository extends JpaRepository<ActualService,Long> {
    ActualService findByActualServiceId(long id);
    List<ActualService> findBySubFieldId(long id);

}
