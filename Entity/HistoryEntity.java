package com.csit321.NaviGo.Entity;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_activity")
public class HistoryEntity {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "user_id")
 private Long userId;

 @Column(name = "activity")
 private String activity;

 @Column(name = "timestamp")
 private LocalDateTime timestamp;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

public String getActivity() {
	return activity;
}

public void setActivity(String activity) {
	this.activity = activity;
}

public LocalDateTime getTimestamp() {
	return timestamp;
}

public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}

public HistoryEntity() {
	
}

public HistoryEntity(Long id, Long userId, String activity, LocalDateTime timestamp) {
	super();
	this.id = id;
	this.userId = userId;
	this.activity = activity;
	this.timestamp = timestamp;
}

 
}
