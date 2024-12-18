package com.winged.backend.controllers.PaintingAndRenovation;
import com.winged.backend.entities.paintingAndRenovations.PaintingAndRenovationTicket;
import com.winged.backend.services.PaintingAndRenovation.PaintingAndRenovationTicketService;
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
public class PaintingAndRenovationTicketController
{
    @Autowired
    private PaintingAndRenovationTicketService service;
    @PostMapping("/new-painting-and-renovation-ticket")
    public ResponseEntity<?> addNewTicket(@RequestBody PaintingAndRenovationTicket ticket){
        String result = service.addNewTicket(ticket);
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

    @GetMapping("/all-painting-and-renovation-tickets")
    public ResponseEntity<?> allTickets(){
        List<PaintingAndRenovationTicket> result = service.allTickets();
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

    @GetMapping("/all-user-painting-and-renovation-tickets/{id}")
    public ResponseEntity<?> allUserTickets(@PathVariable long id){
        List<PaintingAndRenovationTicket> result = service.allUserTickets(id);
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

    @PutMapping("update-painting-and-renovation-ticket-status/{id}")
    public ResponseEntity<?> allUserTickets(@PathVariable long id, @RequestBody String status){
        String result = service.updateStatus(id,status);
        Map<String, Object> response = new HashMap<>();
        if (result.equals("Record Saved"))
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
