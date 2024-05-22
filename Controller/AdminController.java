//package com.csit321.NaviGo.Controller;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
// 
//import com.csit321.NaviGo.Entity.AdminEntity; // Assuming you have an AcadEntity class
//import com.csit321.NaviGo.Service.AdminService; // Assuming you have an AcadService class
// 
//import java.util.List;
// 
//@RestController
//@RequestMapping("/admin")
//@CrossOrigin(origins = "https://citsecure-log-system.onrender.com")
//public class AdminController {
// 
//    @Autowired
//    private AdminService acadService;
// 
//    @GetMapping("/print/name")
//    public String printHello() {
//        return "Hello, Admin Module!";
//    }
// 
//    @PostMapping("/login")
//    public AdminEntity addAcad(@RequestBody AdminEntity acad) {
//        return AdminService.addAdmin(acad);
//    }
// 
//    @GetMapping("/getAllAcads")
//    public List<AdminEntity> getAllAcads() {
//        return AdminService.getAllAcads();
//    }
// 
//    @GetMapping("/getAcad/{id}")
//    public ResponseEntity<AdminEntity> getAcadById(@PathVariable int id) {
//        AdminEntity acad = acadService.getAcadById(id);
//        if (acad != null) {
//            return ResponseEntity.ok(acad);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
// 
//    @PutMapping("/updateAcad/{id}")
//    public ResponseEntity<AdminEntity> updateAcad(@PathVariable int id, @RequestBody AdminEntity updatedAcad) {
//        AdminEntity acad = acadService.updateAcad(id, updatedAcad);
//        if (acad != null) {
//            return ResponseEntity.ok(acad);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
// 
//    @DeleteMapping("/deleteAcad/{id}")
//    public ResponseEntity<String> deleteAcad(@PathVariable int id) {
//        boolean deleted = AdminService.deleteAcad(id);
//        if (deleted) {
//            return ResponseEntity.ok("Acad deleted successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acad not found");
//        }
//    }
//}