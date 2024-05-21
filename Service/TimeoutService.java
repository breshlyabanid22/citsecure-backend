package com.csit321.NaviGo.Service;

import com.csit321.NaviGo.Entity.TimeoutEntity;
import com.csit321.NaviGo.Repository.TimeoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeoutService {

    @Autowired
    private TimeoutRepository timeoutRepository;

    public TimeoutEntity addTimeout(TimeoutEntity timeout) {
        return timeoutRepository.save(timeout);
    }

    public List<TimeoutEntity> getAllTimeouts() {
        return timeoutRepository.findAll();
    }

    public Optional<TimeoutEntity> getTimeoutById(long id) {
        return timeoutRepository.findById(id);
    }

    public Optional<TimeoutEntity> getTimeoutByCardNo(long cardNo) {
        return timeoutRepository.findByCardNo(String.valueOf(cardNo));
    }

    public TimeoutEntity updateTimeout(TimeoutEntity timeout) {
        return timeoutRepository.save(timeout);
    }

    public boolean deleteTimeout(long id) {
        timeoutRepository.deleteById(id);
        return true;
    }
    
    
}

//package com.csit321.NaviGo.Service;
//
//import com.csit321.NaviGo.Entity.TimeoutEntity;
//import com.csit321.NaviGo.Entity.VisitorEntity;
//import com.csit321.NaviGo.Repository.TimeoutRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TimeoutService {
//
//    @Autowired
//    private TimeoutRepository timeoutRepository;
//
//    public TimeoutEntity addTimeout(TimeoutEntity timeout) {
//        return timeoutRepository.save(timeout);
//    }
//
//    public List<TimeoutEntity> getAllTimeouts() {
//        return timeoutRepository.findAll();
//    }
//
//    public Optional<TimeoutEntity> getTimeoutById(long id) {
//        return timeoutRepository.findById(id);
//    }
//
//    public Optional<TimeoutEntity> getTimeoutByCardNo(long cardNo) {
//        return timeoutRepository.findByCardNo(String.valueOf(cardNo));
//    }
//
//    public TimeoutEntity updateTimeout(TimeoutEntity timeout) {
//        return timeoutRepository.save(timeout);
//    }
//
//    public boolean deleteTimeout(long id) {
//        timeoutRepository.deleteById(id);
//        return true;
//    }
//
//    public void checkoutVisitor(long cardNo) {
//        Optional<TimeoutEntity> timeoutOptional = timeoutRepository.findByCardNo(cardNo);
//        if (timeoutOptional.isPresent()) {
//            TimeoutEntity timeout = timeoutOptional.get();
//            VisitorEntity visitor = timeout.getVisitor();
//            // Update the timeout and status
//            timeout.setTimeOut(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy")));
//            timeout.setStatus("false"); // or "not used"
//            timeoutRepository.save(timeout);
//        }
//    }
//}
//


//
//package com.csit321.NaviGo.Service;
//
//import com.csit321.NaviGo.Entity.TimeoutEntity;
//import com.csit321.NaviGo.Entity.VisitorEntity;
//import com.csit321.NaviGo.Repository.TimeoutRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TimeoutService {
//
//    @Autowired
//    private TimeoutRepository timeoutRepository;
//
//    public TimeoutEntity addTimeout(TimeoutEntity timeout) {
//        return timeoutRepository.save(timeout);
//    }
//
//    public List<TimeoutEntity> getAllTimeouts() {
//        return timeoutRepository.findAll();
//    }
//
//    public Optional<TimeoutEntity> getTimeoutById(long id) {
//        return timeoutRepository.findById(id);
//    }
//
//    public Optional<TimeoutEntity> getTimeoutByCardNo(long cardNo) {
//        return timeoutRepository.findByCardNo(String.valueOf(cardNo));
//    }
//
//    public TimeoutEntity updateTimeout(TimeoutEntity timeout) {
//        return timeoutRepository.save(timeout);
//    }
//
//    public boolean deleteTimeout(long id) {
//        timeoutRepository.deleteById(id);
//        return true;
//    }
//}
