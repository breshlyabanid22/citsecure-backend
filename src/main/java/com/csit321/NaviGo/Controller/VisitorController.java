package com.csit321.NaviGo.Controller;
 
import com.csit321.NaviGo.Entity.VisitorEntity;
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
 
    @GetMapping("/print/visitor")
    public String printHello() {
        return "VISITOR!";
    }
    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @PostMapping("/addvisitor")
    public ResponseEntity<VisitorEntity> addVisitor(@RequestBody VisitorEntity visitor) {
        List<VisitorEntity> existingVisitors = visitorService.getVisitorsByCardNo(visitor.getCardNo());
        for (VisitorEntity existingVisitor : existingVisitors) {
            if (existingVisitor.getStatus() == 1) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
            }
        }
 
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = formatDateTime(currentTime);
        visitor.setTimeIn(formattedTime);
        visitor.setTimeOut("");
        visitor.setStatus(1);
 
        VisitorEntity addedVisitor = visitorService.addVisitor(visitor);
        return ResponseEntity.ok(addedVisitor);
    }
    @CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
    @GetMapping("/getAllVisitors")
    public List<VisitorEntity> getAllVisitors() {
        return visitorService.getAllVisitors();
    }
 
 
    @GetMapping("/getVisitor/{id}")
    public ResponseEntity<VisitorEntity> getVisitorById(@PathVariable long id) {
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
        String formattedTime = formatDateTime(LocalDateTime.now());
        VisitorEntity visitor = visitorService.updateVisitorTimeOut(cardNo, formattedTime);
        if (visitor != null) {
            return ResponseEntity.ok(visitor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
 
    private String formatDateTime(LocalDateTime dateTime) {
        return dateTime.toString();
    }
}