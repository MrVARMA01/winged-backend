package com.winged.backend.controllers;

import com.winged.backend.entities.ActualServiceDetails;
import com.winged.backend.services.ActualServiceDetailsService;
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
public class ActualServiceDetailsController {
    @Autowired
    private ActualServiceDetailsService service;

    @PostMapping("add-actual-service-details")
    public ResponseEntity<?> addActualServiceDetails(@RequestBody ActualServiceDetails details){
        String result = service.addActualServiceDetails(details);
        Map<String, Object> response = new HashMap<>();
        if (result != null)
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

    @GetMapping("actual-service-details/{id}")
    public ResponseEntity<?> actualServiceDetails(@PathVariable long id ){
        ActualServiceDetails result = service.actualServiceDetails(id);
        Map<String, Object> response = new HashMap<>();
        if (result != null)
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

    @GetMapping("all-actual-service-details")
    public ResponseEntity<?> allActualServiceDetails(){
        List<ActualServiceDetails> result = service.allActualServiceDetails();
        Map<String, Object> response = new HashMap<>();
        if (result != null)
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
}
