package com.winged.backend.repositories;

import com.winged.backend.entities.Employee;
import com.winged.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByEmail(String email);
    Employee findById(long empId);
    Employee findByPhoneNumber(long phone);
}
