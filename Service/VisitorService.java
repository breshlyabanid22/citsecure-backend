package com.csit321.NaviGo.Service;

import com.csit321.NaviGo.Entity.VisitorEntity;
import com.csit321.NaviGo.Repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository visitorRepository;

    public VisitorEntity addVisitor(VisitorEntity visitor) {
        // Automatically set timeIn to current server time
        LocalDateTime currentTime = LocalDateTime.now();
        visitor.setTimeIn(formatDateTime(currentTime)); // Ensure this sets the timeIn field
        return visitorRepository.save(visitor);
    }

    public List<VisitorEntity> getAllVisitors() {
        return visitorRepository.findAll();
    }

    public VisitorEntity getVisitorById(long id) {
        Optional<VisitorEntity> optionalVisitor = visitorRepository.findById(id);
        return optionalVisitor.orElse(null);
    }

    public Optional<VisitorEntity> getVisitorByCardNo(int cardNo) {
        return visitorRepository.findByCardNo(cardNo);
    }

    public VisitorEntity updateVisitor(long id, VisitorEntity updatedVisitor) {
        Optional<VisitorEntity> optionalVisitor = visitorRepository.findById(id);
        if (optionalVisitor.isPresent()) {
            VisitorEntity existingVisitor = optionalVisitor.get();
            
            // Update first name if it's provided
            if (updatedVisitor.getFirstName() != null && !updatedVisitor.getFirstName().isEmpty()) {
                existingVisitor.setFirstName(updatedVisitor.getFirstName());
            }
            
            // Update last name if it's provided
            if (updatedVisitor.getLastName() != null && !updatedVisitor.getLastName().isEmpty()) {
                existingVisitor.setLastName(updatedVisitor.getLastName());
            }
            
            // Save the updated visitor
            return visitorRepository.save(existingVisitor);
        } else {
            return null;
        }
    }

    @Transactional
    public VisitorEntity updateVisitorTimeOut(int cardNo, String timeOut) {
      Optional<VisitorEntity> optionalVisitor = visitorRepository.findByCardNo(cardNo);
      if (optionalVisitor.isPresent()) {
        VisitorEntity existingVisitor = optionalVisitor.get();

        // Update timeOut
        existingVisitor.setTimeOut(timeOut);

        // Update status based on timeOut
        if (existingVisitor.getTimeIn() != null && !existingVisitor.getTimeIn().isEmpty() &&
                (existingVisitor.getTimeOut() == null || existingVisitor.getTimeOut().isEmpty())) {
            existingVisitor.setStatus(1); // Visitor is checked in, card in use
        } else {
            existingVisitor.setStatus(0); // Visitor is checked out, card available
        }

        // Save the updated VisitorEntity object
        return visitorRepository.save(existingVisitor);
      } else {
        throw new RuntimeException("Visitor not found with cardNo: " + cardNo);
      }
    }





    public boolean deleteVisitor(long id) {
        if (visitorRepository.existsById(id)) {
            visitorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

 // Helper method to format LocalDateTime to desired format
    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        return dateTime.format(formatter);
    }

}
