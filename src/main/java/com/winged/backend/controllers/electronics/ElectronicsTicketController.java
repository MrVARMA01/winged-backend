package com.winged.backend.controllers.electronics;
import com.winged.backend.entities.electronics.ElectronicsTicket;
import com.winged.backend.services.electronics.ElectronicsTicketService;
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
public class ElectronicsTicketController {
    @Autowired
    private ElectronicsTicketService service;
    @PostMapping("new-electronics-ticket")
    public ResponseEntity<?> newTicket(@RequestBody ElectronicsTicket ticket){
        Map<String,Object> response = new HashMap<>();
        String result = service.newTicket(ticket);
        if(result.equals("Ticket Activated!")){
            response.put("status",true);
            response.put("message",result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            response.put("status",false);
            response.put("message",result);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
//    @PutMapping("electronics-ticket-approval")
//    public ResponseEntity<?> ticketApproval(@RequestBody ElectronicsTicket ticket){
//        Map<String,Object> response = new HashMap<>();
//        String result = service.ticketApproval(ticket);
//        if(result.equals("Service Approved!")){
//            response.put("status",true);
//            response.put("message",result);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }else {
//            response.put("status",false);
//            response.put("message",result);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }
//    }
    @GetMapping("all-electronics-tickets")
    public ResponseEntity<?> allElectronicsTickets(){
        List<ElectronicsTicket> result = service.allElectronicsTickets();
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
    @GetMapping("all-user-electronics-tickets/{id}")
    public ResponseEntity<?> allTicketsOfUser(@PathVariable long id){
        List<ElectronicsTicket> result = service.allUserTickets(id);
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
    @GetMapping("electronics-ticket/{id}")
    public ResponseEntity<?> ticket(@PathVariable long id){
        ElectronicsTicket result = service.ticket(id);
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
    @PutMapping("delete-electronics-ticket/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable long id){
        return new ResponseEntity<>(service.deleteTicket(id), HttpStatus.OK);
    }
}
