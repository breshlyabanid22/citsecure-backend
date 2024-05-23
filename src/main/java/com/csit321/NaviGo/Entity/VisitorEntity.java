package com.csit321.NaviGo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "CITsecure")
public class VisitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_no")
    private int cardNo;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "time_in")
    private String timeIn; 

    @Column(name = "time_out")
    private String timeOut; 

    private String purpose;

    @Column(name = "building_to_visit")
    private String buildingToVisit;

    @Column(name = "status")
    private int status;

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
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

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getBuildingToVisit() {
        return buildingToVisit;
    }

    public void setBuildingToVisit(String buildingToVisit) {
        this.buildingToVisit = buildingToVisit;
    }

    public int getStatus() {
        if (timeOut == null || timeOut.isEmpty()) {
            return 1; // Visitor is checked in, card in use
        } else {
            return 0; // Visitor has checked out, card available
        }
    }


    public void setStatus(int status) {
        this.status = status;
    }
}