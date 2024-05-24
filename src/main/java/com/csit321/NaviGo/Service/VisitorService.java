package com.csit321.NaviGo.Service;
 
import com.csit321.NaviGo.Entity.VisitorEntity;
import com.csit321.NaviGo.Repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
 
@Service
public class VisitorService {
 
    @Autowired
    private VisitorRepository visitorRepository;
 
    public VisitorEntity addVisitor(VisitorEntity visitor) {
        ZonedDateTime currentTime = ZonedDateTime.now();
        visitor.setTimeIn(formatDateTime(currentTime));
        visitor.setTimeOut("");
        visitor.setStatus(1);
        return visitorRepository.save(visitor);
    }
 
    public List<VisitorEntity> getAllVisitors() {
        return visitorRepository.findAll();
    }
 
    public VisitorEntity getVisitorById(long id) {
        Optional<VisitorEntity> optionalVisitor = visitorRepository.findById(id);
        return optionalVisitor.orElse(null);
    }
 
    public List<VisitorEntity> getVisitorsByCardNo(int cardNo) {
        return visitorRepository.findByCardNo(cardNo);
    }
 
    
    @Transactional
    public VisitorEntity updateVisitorTimeOut(int cardNo, String timeOut) {
        List<VisitorEntity> visitors = visitorRepository.findByCardNo(cardNo);
 
        if (!visitors.isEmpty()) {
            for (VisitorEntity visitor : visitors) {
                if (visitor.getStatus() == 1) {
                    // Format current time and set it to timeOut
                    visitor.setTimeOut(formatDateTime(ZonedDateTime.now()));
                    visitor.setStatus(0);
                    return visitorRepository.save(visitor);
                }
            }
            throw new RuntimeException("No visitor with cardNo: " + cardNo + " is currently checked in.");
        } else {
            throw new RuntimeException("Visitor not found with cardNo: " + cardNo);
        }
    }
 
    // Helper method to format LocalDateTime to desired format (12-hour with uppercase AM/PM marker)
    private String formatDateTime(ZonedDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a dd/MM/yyyy");
        String formattedDateTime = dateTime.format(formatter);
        formattedDateTime = formattedDateTime.replace("am", "AM").replace("pm", "PM");
        return formattedDateTime;
    }
 
 
}