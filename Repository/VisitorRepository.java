package com.csit321.NaviGo.Repository;

import com.csit321.NaviGo.Entity.VisitorEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<VisitorEntity, Long> {
    Optional<VisitorEntity> findByCardNo(int cardNo);
}