package com.winged.backend.controllers;

import com.winged.backend.entities.Employee;
import com.winged.backend.entities.User;
import com.winged.backend.jwt.*;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.EmployeeService;
import com.winged.backend.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@AllArgsConstructor
@Slf4j
public class JwtAuthenticationController {

    @Autowired
    private UserService service;
    @Autowired
    private EmployeeService employeeService;
    private AuthenticationManager manager;
    @Autowired
    private JwtHelper helper;


    @PostMapping("/user-register")
    public ResponseEntity<?> register(@RequestBody User user){
        User UserData1 = service.findByUserName(user.getEmail());
        User UserData2 = service.findByPhoneNumber(user.getPhoneNumber());
        Map<String,Object> response = new HashMap<>();
        if (UserData1!=null ){
            response.put("status",false);
            response.put("response","User Already Exists !");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else if (UserData2!=null) {
            response.put("status",false);
            response.put("response","User Already Exists !");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            service.register(user);
            response.put("status",true);
            response.put("response","User Registered Successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest request) {
        User userData = service.findByUserName(request.getUsername());
        if (userData==null){
            return new ResponseEntity<>("Invalid Username !",HttpStatus.NOT_FOUND);
        }
        else {
            if (new BCryptPasswordEncoder().matches(request.getPassword(), userData.getPassword())) {
//                this.doAuthenticate(request.getUsername(), request.getPassword());
//        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
                String token = this.helper.doGenerateToken(userData.getEmail());

                JwtResponse response = JwtResponse.builder()
                        .jwtToken(token)
                        .user(userData).build();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid Password !", HttpStatus.NOT_ACCEPTABLE);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credentials Invalid !!");
        }
    }
    @PutMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody User user){
        return new ResponseEntity<>(service.forgetPassword(user),HttpStatus.OK);
    }





    /****************************       ADMIN-PANEL      *****************************/

    @PostMapping("/employee-register")
    public ResponseEntity<?> register(@RequestBody Employee employee){
        Employee empData1 = employeeService.findByEmail(employee.getEmail());
        Employee empData2 = employeeService.findByPhoneNumber(employee.getPhoneNumber());
        Map<String,Object> response = new HashMap<>();
        if (empData1!=null || empData2!=null){
            response.put("status",false);
            response.put("response","User Already Exists !");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            employeeService.register(employee);
            response.put("status",true);
            response.put("response","User Registered Successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/employee-login")
    public ResponseEntity<?> login(@RequestBody JwtEmpRequest request) {
        Employee empData = employeeService.findByEmail(request.getEmail());
        if (empData==null){
            return new ResponseEntity<>("Invalid Username !",HttpStatus.NOT_FOUND);
        }
        else {
            if (new BCryptPasswordEncoder().matches(request.getPassword(), empData.getPassword())) {
//                this.doAuthenticate(request.getUsername(), request.getPassword());
//        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
                String token = this.helper.doGenerateToken(empData.getEmail());

                JwtEmpResponse response = JwtEmpResponse.builder()
                        .jwtToken(token)
                        .employee(empData).build();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid Password !", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/employee-forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.forgetPassword(employee),HttpStatus.OK);
    }
}

