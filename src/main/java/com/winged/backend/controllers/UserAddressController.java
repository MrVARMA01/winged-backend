package com.winged.backend.controllers;

import com.winged.backend.entities.User;
import com.winged.backend.entities.UserAddress;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.UserAddressService;
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
public class UserAddressController {
    @Autowired
    private UserAddressService service;
    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/new-user-address/{id}")
//    public ResponseEntity<?> newUserAddress(@PathVariable long id){
//        User user = userRepository.findByUserId(id);
//        Map<String, Object> response = new HashMap<>();
//        if (user != null)
//        {
//            response.put("status", true);
//            response.put("response", user);
//            return new ResponseEntity<>(response,HttpStatus.OK);
//        } else{
//            response.put("status", false);
//            response.put("response", "UserAddress not found!");
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//    }
    @GetMapping("/address/{id}")
    public ResponseEntity<?> addressById(@PathVariable long id){
        UserAddress address = service.address(id);
        Map<String, Object> response = new HashMap<>();
        if (address != null)
        {
            response.put("status", true);
            response.put("response", address);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "UserAddress not found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
