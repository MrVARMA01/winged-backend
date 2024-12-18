package com.winged.backend.controllers;
import com.winged.backend.entities.ActualService;
import com.winged.backend.entities.ServiceField;
import com.winged.backend.entities.SubField;
import com.winged.backend.services.ActualServiceService;
import com.winged.backend.services.ServiceFieldService;
import com.winged.backend.services.SubFieldService;
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
public class ServicesController {
    @Autowired
    private ServiceFieldService service1;
    @Autowired
    private SubFieldService service2;
    @Autowired
    private ActualServiceService service3;


    //************************************** SERVICE FIELD *****************************************//
    @PostMapping("add-service-field")
    public ResponseEntity<?> addServiceField(@RequestBody ServiceField field){
        return new ResponseEntity<>(service1.saveServiceField(field), HttpStatus.OK);
    }
    @GetMapping("all-service-fields")
    public ResponseEntity<?> allServiceField(){
        return new ResponseEntity<>(service1.allServiceFields(), HttpStatus.OK);
    }
    @GetMapping("service-field/{id}")
    public ResponseEntity<?> serviceFieldById(@PathVariable int id){
        return new ResponseEntity<>(service1.fieldById(id), HttpStatus.OK);
    }


    //************************************** SUB Field *****************************************//
    @PostMapping("add-sub-field")
    public ResponseEntity<?> addSubField(@RequestBody SubField service){
        return new ResponseEntity<>(service2.addSubService(service), HttpStatus.OK);
    }
    @GetMapping("all-sub-fields")
    public ResponseEntity<?> allSubFields(){
        return new ResponseEntity<>(service2.allSubServices(), HttpStatus.OK);
    }
    @GetMapping("sub-field/{id}")
    public ResponseEntity<?> subFieldById(@PathVariable long id){
        return new ResponseEntity<>(service2.subServiceById(id), HttpStatus.OK);
    }
    @GetMapping("sub-fields-by-service-field/{id}")
    public ResponseEntity<?> subFieldsByServiceField(@PathVariable int id){
        return new ResponseEntity<>(service2.subServicesByFieldId(id), HttpStatus.OK);
    }


    //************************************** ACTUAL SERVICE *****************************************//
    @PostMapping("add-actual-service")
    public ResponseEntity<?> addActualService(@RequestBody ActualService service){
        String result = service3.addActualService(service);
        Map<String, Object> response = new HashMap<>();
        if (result.equals("Actual Service Added !"))
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("all-actual-services")
    public ResponseEntity<?> allActualServices(){
        List<ActualService> result = service3.allActualServices();
        Map<String, Object> response = new HashMap<>();
        if (result != null)
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("actual-service/{id}")
    public ResponseEntity<?> actualServiceById(@PathVariable long id){
        ActualService result = service3.actualServiceById(id);
        Map<String, Object> response = new HashMap<>();
        if (result != null)
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    @GetMapping("actual-services-by-sub-field/{id}")
    public ResponseEntity<?> actualServicesBySubField(@PathVariable long id){
        List<ActualService> result = service3.actualServicesBySubService(id);
        Map<String, Object> response = new HashMap<>();
        if (result != null)
        {
            response.put("status", true);
            response.put("response", result);
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else{
            response.put("status", false);
            response.put("response", result);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


}
