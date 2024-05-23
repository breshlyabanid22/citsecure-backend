package com.csit321.NaviGo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Timeout")
public class TimeoutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_no")
    private long cardNo;

    @Column(name = "time_out")
    private String timeOut; 

    @Column(name = "status")
    private String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

  
    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

//package com.csit321.NaviGo.Entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Timeout")
//public class TimeoutEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "card_no")
//    private long cardNo;
//
//    @Column(name = "time_out")
//    private String timeOut; 
//
//    @Column(name = "status")
//    private String status;
//
//    @OneToOne
//    @JoinColumn(name = "card_no", referencedColumnName = "card_no", insertable = false, updatable = false)
//    private VisitorEntity visitor;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getCardNo() {
//        return cardNo;
//    }
//
//    public void setCardNo(long cardNo) {
//        this.cardNo = cardNo;
//    }
//
//  
//    public String getTimeOut() {
//        return timeOut;
//    }
//
//    public void setTimeOut(String timeOut) {
//        this.timeOut = timeOut;
//    }
//
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public VisitorEntity getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(VisitorEntity visitor) {
//        this.visitor = visitor;
//    }
//}

//
//package com.csit321.NaviGo.Entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Timeout")
//public class TimeoutEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "card_no")
//    private long cardNo;
//
//    @Column(name = "time_out")
//    private String timeOut; 
//
//    @Column(name = "status")
//    private String status;
//
//    @ManyToOne(fetch = FetchType.LAZY) // Specify FetchType
//    @JoinColumn(name = "card_no", referencedColumnName = "card_no", insertable = false, updatable = false)
//    private VisitorEntity visitor;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public long getCardNo() {
//        return cardNo;
//    }
//
//    public void setCardNo(long cardNo) {
//        this.cardNo = cardNo;
//    }
//
//    public String getTimeOut() {
//        return timeOut;
//    }
//
//    public void setTimeOut(String timeOut) {
//        this.timeOut = timeOut;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public VisitorEntity getVisitor() {
//        return visitor;
//    }
//
//    public void setVisitor(VisitorEntity visitor) {
//        this.visitor = visitor;
//    }
//}
