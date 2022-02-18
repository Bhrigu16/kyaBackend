package com.backend.repository.postgres;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.subActivities;

@Repository
public interface SubActivityRepository extends JpaRepository<subActivities, Integer>{

	Optional<subActivities> findById(Long id);
	
	
    @Query("SELECT new subActivities(s.id, s.name) from subActivities s where s.is_active='true' and s.is_deleted='false'")
    List<subActivities> findAllSubactivities();
    
    @Query("SELECT new subActivities(s.id, s.name) from subActivities s where s.is_active='true' and s.is_deleted='false' and s.activity_id=?1")
    List<subActivities> findAllSubactivityById(Integer id);
    
	//select id,name from master.sub_activities where is_active='true' and is_deleted='false';
	
}
