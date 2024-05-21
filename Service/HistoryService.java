package com.csit321.NaviGo.Service;

//HistoryService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csit321.NaviGo.Entity.HistoryEntity;
import com.csit321.NaviGo.Repository.HistoryRepository;

import java.time.LocalDateTime;

@Service
public class HistoryService {

 @Autowired
 private HistoryRepository historyRepository;

 public void logActivity(Long userId, String activity) {
     HistoryEntity history = new HistoryEntity();
     history.setUserId(userId);
     history.setActivity(activity);
     history.setTimestamp(LocalDateTime.now());
     historyRepository.save(history);
 }
}

