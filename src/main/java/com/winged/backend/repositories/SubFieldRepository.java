package com.winged.backend.repositories;
import com.winged.backend.entities.SubField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubFieldRepository extends JpaRepository<SubField,Long> {
    SubField findBySubFieldId(long id);
    List<SubField> findByServiceFieldId(int id);

}
