package com.winged.backend.repositories.PaintingAndRenovation;
import com.winged.backend.entities.paintingAndRenovations.PaintingAndRenovationTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingAndRenovationTicketRepository extends JpaRepository<PaintingAndRenovationTicket,Long> {
    PaintingAndRenovationTicket findById(long id);
    List<PaintingAndRenovationTicket> findByUserId(long userId);
}
