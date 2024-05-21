package com.csit321.NaviGo.Entity;
 
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;
 
@Entity

@Table(name = "tblnavigo")

public class NaviGoEntity {
 
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
 
    @Column(name = "first_name")

    private String firstName;
 
    @Column(name = "last_name")

    private String lastName;
 
    private String gender;
 
    private String email;
 
    private String password;

    public NaviGoEntity() {

        super();

    }
 
    public NaviGoEntity(int id, String firstName, String lastName, String gender, String email, String password) 
    {

        this.id = id;

        this.firstName = firstName;

        this.lastName = lastName;

        this.gender = gender;

        this.email = email;

        this.password = password;

        

    }
 
    // Getters and setters
 
    public int getId() {

        return id;

    }
 
    public void setId(int id) {

        this.id = id;

    }
 
    public String getFirstName() {

        return firstName;

    }
 
    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }
 
    public String getLastName() {

        return lastName;

    }
 
    public void setLastName(String lastName) {

        this.lastName = lastName;

    }
 
    public String getGender() {

        return gender;

    }
 
    public void setGender(String gender) {

        this.gender = gender;

    }
 
    public String getEmail() {

        return email;

    }
 
    public void setEmail(String email) {

        this.email = email;

    }
 
    public String getPassword() {

        return password;

    }
 
    public void setPassword(String password) {

        this.password = password;

    }
 
 

}
