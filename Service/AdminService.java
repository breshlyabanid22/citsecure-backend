//package com.csit321.NaviGo.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.NoSuchElementException;
//import java.util.List;
//
//import com.csit321.NaviGo.Entity.AdminEntity;
//import com.csit321.NaviGo.Repository.AdminRepository;
//
//@Service
//public class AdminService {
//
//    @Autowired
//    AdminRepository urepo;
//
//    public AdminEntity insertUser(AdminEntity user) {
//        return urepo.save(user);
//    }
//
//    public List<AdminEntity> getAllUser() {
//        return urepo.findAll();
//    }
//
//    public AdminEntity updateUser(int id, AdminEntity newUserDetails) {
//        try {
//            AdminEntity user = urepo.findById(id)
//                    .orElseThrow(() -> new NoSuchElementException("User " + id + " does not exist!"));
//
//            user.setFirstName(newUserDetails.getFirstName());
//            user.setLastName(newUserDetails.getLastName());
//
//            return urepo.save(user);
//        } catch (NoSuchElementException ex) {
//            throw new NoSuchElementException("User " + id + " does not exist!");
//        }
//    }
//
//    public String deleteUser(int id) {
//        if (urepo.existsById(id)) {
//            urepo.deleteById(id);
//            return "User " + id + " is successfully deleted!";
//        } else {
//            return "User " + id + " does not exist!";
//        }
//    }
//
//    public boolean authenticateUser(String email, String password) {
//        // Find the user by email using the repository
//        AdminEntity user = urepo.findByEmail(email);
//
//        // Check if the user exists and if the provided password matches the user's password
//        return user != null && user.getPassword().equals(password);
//    }
//
//    public AdminEntity getUserByEmail(String email) {
//        return urepo.findByEmail(email);
//    }
//}
