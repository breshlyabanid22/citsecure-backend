package com.csit321.NaviGo.Controller;

import com.csit321.NaviGo.Entity.TimeoutEntity;
import com.csit321.NaviGo.Service.TimeoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/out")
@CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
public class TimeoutController {

    @Autowired
    private TimeoutService timeoutService;

    @GetMapping("/print/visitor")
    public String printHello() {
        return "VISITOR!";
    }

    @PostMapping("/addtimeout")
    public ResponseEntity<TimeoutEntity> addTimeout(@RequestBody TimeoutEntity timeout) {
        // Set timeOut to current server time
        LocalDateTime currentTime = LocalDateTime.now();
        timeout.setTimeOut(formatDateTime(currentTime));

        TimeoutEntity addedTimeout = timeoutService.addTimeout(timeout);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTimeout);
    }

    @GetMapping("/getalltimeouts")
    public ResponseEntity<List<TimeoutEntity>> getAllTimeouts() {
        List<TimeoutEntity> timeouts = timeoutService.getAllTimeouts();
        return ResponseEntity.ok(timeouts);
    }

    @GetMapping("/gettimeoutbyid/{id}")
    public ResponseEntity<TimeoutEntity> getTimeoutById(@PathVariable Integer id) {
        Optional<TimeoutEntity> timeoutOptional = timeoutService.getTimeoutById(id);
        return timeoutOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/gettimeoutbycard/{cardNo}")
    public ResponseEntity<TimeoutEntity> getTimeoutByCardNo(@PathVariable long cardNo) {
        Optional<TimeoutEntity> timeoutOptional = timeoutService.getTimeoutByCardNo(cardNo);
        return timeoutOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/updatetimeout")
    public ResponseEntity<TimeoutEntity> updateTimeout(@RequestBody TimeoutEntity timeout) {
        TimeoutEntity updatedTimeout = timeoutService.updateTimeout(timeout);
        return ResponseEntity.ok(updatedTimeout);
    }

    @DeleteMapping("/deletetimeout/{id}")
    public ResponseEntity<Void> deleteTimeout(@PathVariable Integer id) {
        boolean deleted = timeoutService.deleteTimeout(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Helper method to format LocalDateTime to desired format
    private String formatDateTime(LocalDateTime dateTime) {
        // Define the desired date-time format pattern
        String pattern = "HH:mm dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }
}


//
//package com.csit321.NaviGo.Controller;
//
//import com.csit321.NaviGo.Entity.TimeoutEntity;
//import com.csit321.NaviGo.Service.TimeoutService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/out")
//@CrossOrigin(origins = "http://localhost:3000")
//public class TimeoutController {
//
//    @Autowired
//    private TimeoutService timeoutService;
//
//    @GetMapping("/print/visitor")
//    public String printHello() {
//        return "VISITOR!";
//    }
//
//    @PostMapping("/addtimeout")
//    public ResponseEntity<TimeoutEntity> addTimeout(@RequestBody TimeoutEntity timeout) {
//        // Set timeOut to current server time
//        LocalDateTime currentTime = LocalDateTime.now();
//        timeout.setTimeOut(formatDateTime(currentTime));
//
//        TimeoutEntity addedTimeout = timeoutService.addTimeout(timeout);
//        return ResponseEntity.status(HttpStatus.CREATED).body(addedTimeout);
//    }
//
//    @GetMapping("/getalltimeouts")
//    public ResponseEntity<List<TimeoutEntity>> getAllTimeouts() {
//        List<TimeoutEntity> timeouts = timeoutService.getAllTimeouts();
//        return ResponseEntity.ok(timeouts);
//    }
//
//    @GetMapping("/gettimeoutbyid/{id}")
//    public ResponseEntity<TimeoutEntity> getTimeoutById(@PathVariable long id) {
//        Optional<TimeoutEntity> timeoutOptional = timeoutService.getTimeoutById(id);
//        return timeoutOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/gettimeoutbycard/{cardNo}")
//    public ResponseEntity<TimeoutEntity> getTimeoutByCardNo(@PathVariable long cardNo) {
//        Optional<TimeoutEntity> timeoutOptional = timeoutService.getTimeoutByCardNo(cardNo);
//        return timeoutOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/updatetimeout")
//    public ResponseEntity<TimeoutEntity> updateTimeout(@RequestBody TimeoutEntity timeout) {
//        TimeoutEntity updatedTimeout = timeoutService.updateTimeout(timeout);
//        return ResponseEntity.ok(updatedTimeout);
//    }
//
//    @DeleteMapping("/deletetimeout/{id}")
//    public ResponseEntity<Void> deleteTimeout(@PathVariable long id) {
//        boolean deleted = timeoutService.deleteTimeout(id);
//        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//
//    // Helper method to format LocalDateTime to desired format
//    private String formatDateTime(LocalDateTime dateTime) {
//        // Customize the format as needed
//        return dateTime.toString(); // Default format is used here
//    }
//}