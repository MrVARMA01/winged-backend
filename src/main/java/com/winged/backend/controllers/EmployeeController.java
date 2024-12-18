package com.winged.backend.controllers;

import com.winged.backend.entities.Employee;
import com.winged.backend.entities.Role;
import com.winged.backend.entities.User;
import com.winged.backend.services.EmployeeService;
import com.winged.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/all-employees")
    public ResponseEntity<?> allEmployees(){
        return new ResponseEntity<>(service.allEmployees(), HttpStatus.OK);
    }
    @GetMapping("/employee/{email}")
    public ResponseEntity<?> employeeByEmail(@PathVariable String email){
        Employee empData= service.findByEmail(email);
        if (empData==null){
            return new ResponseEntity<>("User Not Found!", HttpStatus.OK);
        }
        return new ResponseEntity<>(empData, HttpStatus.OK);
    }
    @PutMapping("/update-employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        if (employee==null){
            return new ResponseEntity<>("error !", HttpStatus.OK);
        }
        else {
            service.updateEmployee(id, employee);
            return new ResponseEntity<>("Record updated !", HttpStatus.OK);
        }
    }
}
