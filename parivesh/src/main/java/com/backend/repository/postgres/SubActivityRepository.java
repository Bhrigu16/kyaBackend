package com.backend.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.SubActivities;

@Repository
public interface SubActivityRepository extends JpaRepository<SubActivities, Integer>{

	Optional<SubActivities> findById(Long id);
	
	
    @Query("SELECT s from SubActivities s where s.is_active='true' and s.is_deleted='false' order by name")
    List<SubActivities> findAllSubActivities();
    
    @Query("SELECT s from SubActivities s where s.is_active='true' and s.is_deleted='false' and s.activity_id=?1 order by name")
    List<SubActivities> findAllSubactivityById(Integer id);
    
	//select id,name from master.sub_activities where is_active='true' and is_deleted='false';
	
}
