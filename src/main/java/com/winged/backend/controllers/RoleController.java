package com.winged.backend.controllers;
import com.winged.backend.entities.Role;
import com.winged.backend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping("/new-role")
    public ResponseEntity<?> addNewRole(@RequestBody Role role){
        String result = service.addNewRole(role);
        Map<String, Object> response = new HashMap<>();
        if (result!=null)
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/all-roles")
    public ResponseEntity<?> allRoles(){
        List<Role> result = service.allRoles();
        Map<String, Object> response = new HashMap<>();
        if (result != null)
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "No Roles found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("/role/{id}")
    public ResponseEntity<?> roleById(@PathVariable int id){
        Role result = service.roleById(id);
        Map<String, Object> response = new HashMap<>();
        if (result != null)
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", "Role not found!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
