package com.winged.backend.repositories;
import com.winged.backend.entities.paintingAndRenovations.Paint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintRepository extends JpaRepository<Paint,Long> {
    Paint findById(long id);
}
