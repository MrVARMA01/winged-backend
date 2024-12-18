package com.winged.backend.repositories.electronics;
import com.winged.backend.entities.electronics.ElectronicsTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicsTicketRepository extends JpaRepository<ElectronicsTicket,Long> {
    ElectronicsTicket findById(long id);

    List<ElectronicsTicket> findByUserId(long id);
}
