package com.csit321.NaviGo.Repository;

import com.csit321.NaviGo.Entity.TimeoutEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeoutRepository extends JpaRepository<TimeoutEntity, Long> {
    Optional<TimeoutEntity> findByCardNo(String cardNo);
}

//package com.csit321.NaviGo.Repository;
//
//import com.csit321.NaviGo.Entity.TimeoutEntity;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface TimeoutRepository extends JpaRepository<TimeoutEntity, Long> {
//    Optional<TimeoutEntity> findByCardNo(String cardNo);
//}