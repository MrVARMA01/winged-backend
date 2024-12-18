package com.winged.backend.controllers;
import com.winged.backend.entities.paintingAndRenovations.Paint;
import com.winged.backend.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class PaintController {
    @Autowired
    private PaintService service;
    @PostMapping("add-paint")
    private ResponseEntity<?> addPaint(@RequestBody Paint paint){
        return new ResponseEntity<>(service.addPaint(paint), HttpStatus.OK);
    }

    @PostMapping("all-paints")
    private ResponseEntity<?> allPaints(){
        return new ResponseEntity<>(service.allPaints(), HttpStatus.OK);
    }
    @PostMapping("paint/{id}")
    private ResponseEntity<?> paint(@PathVariable long id){
        return new ResponseEntity<>(service.paint(id), HttpStatus.OK);
    }

}
