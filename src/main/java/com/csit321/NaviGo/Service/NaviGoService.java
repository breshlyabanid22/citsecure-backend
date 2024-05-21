package com.csit321.NaviGo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.List;

import com.csit321.NaviGo.Entity.NaviGoEntity;
import com.csit321.NaviGo.Repository.NaviGoRepository;

@Service
public class NaviGoService {

    @Autowired
    NaviGoRepository urepo;

    public NaviGoEntity insertUser(NaviGoEntity user) {
        return urepo.save(user);
    }

    public List<NaviGoEntity> getAllUser() {
        return urepo.findAll();
    }

    public NaviGoEntity updateUser(int id, NaviGoEntity newUserDetails) {
        try {
            NaviGoEntity user = urepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("User " + id + " does not exist!"));

            user.setFirstName(newUserDetails.getFirstName());
            user.setLastName(newUserDetails.getLastName());

            return urepo.save(user);
        } catch (NoSuchElementException ex) {
            throw new NoSuchElementException("User " + id + " does not exist!");
        }
    }

    public String deleteUser(int id) {
        if (urepo.existsById(id)) {
            urepo.deleteById(id);
            return "User " + id + " is successfully deleted!";
        } else {
            return "User " + id + " does not exist!";
        }
    }

    public boolean authenticateUser(String email, String password) {
        // Find the user by email using the repository
        NaviGoEntity user = urepo.findByEmail(email);

        // Check if the user exists and if the provided password matches the user's password
        return user != null && user.getPassword().equals(password);
    }

    public NaviGoEntity getUserByEmail(String email) {
        return urepo.findByEmail(email);
    }
}
