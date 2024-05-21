package com.csit321.NaviGo.Entity;
 
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;
 
@Entity

@Table(name = "tblnavigo")

public class AdminEntity {
 
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
 
   
 
    private String username;
 
    private String password;

    public AdminEntity() {

        super();

    }
 
    public AdminEntity(int id, String username, String password) 
    {

        this.id = id;

        


        this.username = username;

        this.password = password;

        

    }
 
    // Getters and setters
 
    public int getId() {

        return id;

    }
 
    public void setId(int id) {

        this.id = id;

    }
 
    
 
   
 
    public String getEmail() {

        return username;

    }
 
    public void setEmail(String email) {

        this.username = email;

    }
 
    public String getPassword() {

        return password;

    }
 
    public void setPassword(String password) {

        this.password = password;

    }
 
 

}
