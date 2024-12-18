package com.winged.backend.controllers;
import com.winged.backend.entities.User;
import com.winged.backend.entities.UserAddress;
import com.winged.backend.repositories.UserRepository;
import com.winged.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;

    @GetMapping("/all-users")
    public ResponseEntity<?> allUsers(){
        return new ResponseEntity<>(service.allUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<?> userByEmail(@PathVariable String email){
        User userData= service.findByUserName(email);
        if (userData==null){
            return new ResponseEntity<>("User Not Found!", HttpStatus.OK);
        }
        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

//    @GetMapping("/all-user-tickets/{id}")
//    public ResponseEntity<?> allUserTickets(@PathVariable long id){
//        List<Object> result= service.allUserTickets(id);
//        Map<String, Object> response = new HashMap<>();
//        if (result!=null)
//        {
//            response.put("status", true);
//            response.put("response", result);
//            return new ResponseEntity<>(response,HttpStatus.OK);
//        } else{
//            response.put("status", false);
//            response.put("response", result);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
//        }
//    }
    @PutMapping("/update-user/{userid}")
    public ResponseEntity<?> updateUser(@PathVariable long userid, @RequestBody User user){
        if (user==null){
            return new ResponseEntity<>("error !", HttpStatus.OK);
        }
        else {
            service.updateUser(userid, user);
            return new ResponseEntity<>("Record updated !", HttpStatus.OK);
        }
    }
    @PutMapping("/new-user-address/{userid}")
    public ResponseEntity<?> newUserAddress(@PathVariable long userid, @RequestBody UserAddress address){
        User user = repository.findByUserId(userid);
        Map<String, Object> response = new HashMap<>();
        String result =  service.newUserAddress(userid,address);
        if (user != null && result.equals("Record Saved!"))
        {
            user = repository.findByUserId(userid);
            response.put("status", true);
            response.put("response", user);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
