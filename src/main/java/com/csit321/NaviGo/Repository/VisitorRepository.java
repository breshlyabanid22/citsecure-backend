package com.csit321.NaviGo.Repository;
 
import com.csit321.NaviGo.Entity.VisitorEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface VisitorRepository extends JpaRepository<VisitorEntity, Long> {
    List<VisitorEntity> findByCardNo(int cardNo); //gihimong list
}