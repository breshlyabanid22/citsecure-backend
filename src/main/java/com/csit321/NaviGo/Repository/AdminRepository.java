package com.csit321.NaviGo.Repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
 
import com.csit321.NaviGo.Entity.NaviGoEntity;
 
@Repository

public interface AdminRepository extends JpaRepository<NaviGoEntity, Integer> {
	 NaviGoEntity findByEmail(String username);
}
