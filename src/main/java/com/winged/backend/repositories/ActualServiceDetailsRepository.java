package com.winged.backend.repositories;
import com.winged.backend.entities.ActualServiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActualServiceDetailsRepository extends JpaRepository<ActualServiceDetails,Long> {
    ActualServiceDetails findByActualServiceId(long actualServiceId);
}
