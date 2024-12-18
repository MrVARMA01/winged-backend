package com.winged.backend.controllers;
import com.winged.backend.entities.Brand;
import com.winged.backend.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class BrandController {
    @Autowired
    private BrandService service;

    @PostMapping("add-brand")
    private ResponseEntity<?> addBrand(@RequestBody Brand brand) {
        return new ResponseEntity<>(service.addBrand(brand), HttpStatus.OK);
    }
    @GetMapping("all-brands")
    private ResponseEntity<?> allBrands() {
        return new ResponseEntity<>(service.allBrands(), HttpStatus.OK);
    }
    @GetMapping("all-brands-by-service-field/{id}")
    private ResponseEntity<?> allBrandsByServiceField(@PathVariable long id) {
        return new ResponseEntity<>(service.allBrandsByServiceField(id), HttpStatus.OK);
    }
    @GetMapping("brand/{id}")
    private ResponseEntity<?> brand(@PathVariable long id) {
        Map<String,Object> response = new HashMap<>();
        Brand result = service.brand(id);
        if(result != null){
            response.put("status",true);
            response.put("result",result);
        }else {
            response.put("status",false);
            response.put("result","Failed to Fetch!");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
