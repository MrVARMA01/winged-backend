package com.winged.backend.controllers.electronics;
import com.winged.backend.entities.electronics.ElectronicsCompQualityType;
import com.winged.backend.entities.electronics.ElectronicsComponent;
import com.winged.backend.services.electronics.ElectronicsCompQualityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class ElectronicsCompQualityTypeController {
    @Autowired
    private ElectronicsCompQualityTypeService service;
    @PostMapping("add-comp-quality-type")
    public ResponseEntity<?> addCompQualityType(@RequestBody ElectronicsCompQualityType type){
        return new ResponseEntity<>(service.addCompQualityType(type), HttpStatus.OK);
    }
    @GetMapping("all-comp-quality-types")
    public ResponseEntity<?> allCompQualityTypes(){
        return new ResponseEntity<>(service.allCompQualityTypes(), HttpStatus.OK);
    }
    @GetMapping("electronics-comp-quality-type/{id}")
    public ResponseEntity<?> CompQualityType(@PathVariable long id){
        Map<String,Object> response = new HashMap<>();
        ElectronicsCompQualityType result = service.compQualityType(id);
        if (result != null){
            response.put("status",true);
            response.put("result",result);
        }else {
            response.put("status",false);
            response.put("result","Failed to Fetch!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("component-quality-types/{id}")
    public ResponseEntity<?> QualityTypesByComponentId(@PathVariable long id){
        return new ResponseEntity<>(service.QualityTypesByComponentId(id), HttpStatus.OK);
    }
}
