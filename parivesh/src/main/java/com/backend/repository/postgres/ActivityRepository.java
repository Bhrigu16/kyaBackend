package com.backend.repository.postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.model.Activities;


public interface ActivityRepository extends JpaRepository<Activities, Integer>{

	
	@Query("SELECT a from activities a where a.is_active='true' and a.is_deleted='false' order by name")
    List<Activities> findAllActivities();
    
}
