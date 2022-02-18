package com.backend.repository.postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.model.activities;


public interface ActivityRepository extends JpaRepository<activities, Integer>{

	
	@Query("SELECT new activities(a.id, a.name) from activities a where a.is_active='true' and a.is_deleted='false'")
    List<activities> findAllActivities();
    
}
