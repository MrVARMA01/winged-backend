package com.winged.backend.services;

import com.winged.backend.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee register(Employee emp);
    List<Employee> allEmployees();
    Employee findByEmail(String email);
    Employee findByPhoneNumber(long phone);
    String forgetPassword(Employee emp);
//     String changePassword(User user);

    String updateEmployee(long userid,Employee emp);
}
