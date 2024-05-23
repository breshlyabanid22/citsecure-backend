package com.csit321.NaviGo.Controller;

import com.csit321.NaviGo.Entity.VisitorEntity;
import com.csit321.NaviGo.Repository.VisitorRepository;
import com.csit321.NaviGo.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;
    
    @Autowired
    private VisitorRepository visitorRepository;

    @GetMapping("/print/visitor")
    public String printHello() {
        return "VISITOR!";
    }
    
    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @PostMapping("/addvisitor")
    public ResponseEntity<VisitorEntity> addVisitor(@RequestBody VisitorEntity visitor) {
        // Set timeIn and timeOut to current server time
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = formatDateTime(currentTime);
        visitor.setTimeIn(formattedTime);
        visitor.setStatus(visitor.getStatus());
        visitor.setTimeOut(""); // Initialize timeOut as empty as 1
        VisitorEntity addedVisitor = visitorService.addVisitor(visitor);
        return ResponseEntity.ok(addedVisitor);
    }

    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @GetMapping("/getAllVisitors")
    public List<VisitorEntity> getAllVisitors() {
        return visitorService.getAllVisitors();
    }
    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @GetMapping("/getVisitor/{id}")
    public ResponseEntity<VisitorEntity> getVisitorById(@PathVariable int id) {
        VisitorEntity visitor = visitorService.getVisitorById(id);
        if (visitor != null) {
            return ResponseEntity.ok(visitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
     
    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @PutMapping("/updateVisitorTimeOut/{cardNo}")
    public ResponseEntity<VisitorEntity> updateVisitorTimeOut(@PathVariable int cardNo) {
        String formattedTimeOut = formatDateTime(LocalDateTime.now());
        VisitorEntity visitor = visitorService.updateVisitorTimeOut(cardNo, formattedTimeOut);
        if (visitor != null) {
            // Set status based on timeIn and timeOut
            if (visitor.getTimeIn() != null && !visitor.getTimeIn().isEmpty() &&
                    (visitor.getTimeOut() == null || visitor.getTimeOut().isEmpty())) {
                visitor.setStatus(1); // Visitor is checked in, card in use
            } else {
                visitor.setStatus(0); // Visitor is checked out, card available
            }
            
            // Save the updated VisitorEntity object
            visitorRepository.save(visitor);
            
            return ResponseEntity.ok(visitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @PutMapping("/updateVisitor/{id}")
    public ResponseEntity<VisitorEntity> updateVisitor(@PathVariable int id, @RequestBody VisitorEntity updatedVisitor) {
        VisitorEntity visitor = visitorService.getVisitorById(id);
        if (visitor != null) {
            // Update first name if provided
            if (updatedVisitor.getFirstName() != null && !updatedVisitor.getFirstName().isEmpty()) {
                visitor.setFirstName(updatedVisitor.getFirstName());
            }
            
            // Update last name if provided
            if (updatedVisitor.getLastName() != null && !updatedVisitor.getLastName().isEmpty()) {
                visitor.setLastName(updatedVisitor.getLastName());
            }
            
            // Save the updated visitor
            VisitorEntity updatedEntity = visitorService.updateVisitor(id, visitor); // Pass the id here
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteVisitor/{id}")
    public ResponseEntity<String> deleteVisitor(@PathVariable int id) {
        boolean deleted = visitorService.deleteVisitor(id);
        if (deleted) {
            return ResponseEntity.ok("Visitor deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Visitor not found");
        }
    }

    // Helper method to format LocalDateTime to desired format
    private String formatDateTime(LocalDateTime dateTime) {
        // Customize the format as needed
        return dateTime.toString();     }
}

