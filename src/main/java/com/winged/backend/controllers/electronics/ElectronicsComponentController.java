package com.winged.backend.controllers.electronics;

import com.winged.backend.entities.electronics.ElectronicDeviceModel;
import com.winged.backend.entities.electronics.ElectronicsComponent;
import com.winged.backend.services.electronics.ElectronicsComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class ElectronicsComponentController {
    @Autowired
    private ElectronicsComponentService service;
    @PostMapping("add-electronics-component")
    public ResponseEntity<?> addComponentAndPrice(@RequestBody ElectronicsComponent componentAndPrice){
        return new ResponseEntity<>(service.addComponentAndPrice(componentAndPrice), HttpStatus.OK);
    }
    @GetMapping("all-electronics-components")
    public ResponseEntity<?> allComponentAndPrice(){
        return new ResponseEntity<>(service.allComponentsAndPrices(), HttpStatus.OK);
    }
    @GetMapping("electronics-component/{id}")
    public ResponseEntity<?> ComponentAndPrice(@PathVariable long id){
        Map<String,Object> response = new HashMap<>();
        ElectronicsComponent result = service.ComponentAndPrice(id);
        if (result != null){
            response.put("status",true);
            response.put("result",result);
        }else {
            response.put("status",false);
            response.put("result","Failed to Fetch!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
