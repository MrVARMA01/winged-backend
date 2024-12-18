package com.winged.backend.controllers.electronics;

import com.winged.backend.entities.Brand;
import com.winged.backend.entities.electronics.ElectronicDeviceModel;
import com.winged.backend.services.electronics.ElectronicDeviceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class ElectronicDeviceModelController {
    @Autowired
    private ElectronicDeviceModelService service;
    @PostMapping("add-electronic-device-model")
    private ResponseEntity<?> addModel(@RequestBody ElectronicDeviceModel model){
        return new ResponseEntity<>(service.addModel(model), HttpStatus.OK);
    }
    @GetMapping("all-electronic-device-models")
    private ResponseEntity<?> allModel(){
        return new ResponseEntity<>(service.allModels(), HttpStatus.OK);
    }
    @GetMapping("all-electronic-device-models-by-brand/{id}")
    private ResponseEntity<?> allModelsByBrand(@PathVariable long id){
        return new ResponseEntity<>(service.allModelsByBrand(id), HttpStatus.OK);
    }
    @GetMapping("electronic-device-model/{id}")
    private ResponseEntity<?> model(@PathVariable long id){
        Map<String,Object> response = new HashMap<>();
        ElectronicDeviceModel result = service.model(id);
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
