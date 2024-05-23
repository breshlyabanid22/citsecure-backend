package com.csit321.NaviGo.Controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import com.csit321.NaviGo.Entity.NaviGoEntity;
import com.csit321.NaviGo.Service.NaviGoService;
 
@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*", methods = { "GET", "POST", "PUT", "DELETE", "OPTIONS" })
public class NaviGoController {
 
    @Autowired
    private NaviGoService userService;
 
    @GetMapping("/print/name")
    public String printHello() {
        return "Hello, CIT-Navigo!";
    }
 
    @PostMapping("/insertUser")
    public NaviGoEntity insertUser(@RequestBody NaviGoEntity user) {
        return userService.insertUser(user);
    }
 
    @GetMapping("/getAllUsers")
    public List<NaviGoEntity> getAllUsers() {
        return userService.getAllUser();
    }
 
    @PutMapping("/updateUser/{id}")
    public NaviGoEntity updateUser(@PathVariable int id, @RequestBody NaviGoEntity newUserDetails) {
        return userService.updateUser(id, newUserDetails);
    }
 
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
 
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
 
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
 
 
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody NaviGoEntity newUser) {
        // Implement signup logic using your existing insertUser method in the service
        // You can add additional validation or processing as needed
        userService.insertUser(newUser);
        return ResponseEntity.ok("Signup successful");
    }
}
