package com.backend.repository.postgres;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.model.ThresholdParameter;


public interface ThresholdRepository extends JpaRepository<ThresholdParameter, Integer>{

	
	@Query("SELECT new ThresholdParameter(t.id, t.name,t.unit,t.val,t.threshold_unit,t.rendering_type,t.regex,t.description) from ThresholdParameter t where t.is_active='true' and t.is_deleted='false' and t.activity_id=?1")
    List<ThresholdParameter> findThresholdbyActId(Integer id);
    
    @Query("SELECT new ThresholdParameter(t.id, t.name,t.unit,t.val,t.threshold_unit,t.rendering_type,t.regex,t.description) from ThresholdParameter t where t.is_active='true' and t.is_deleted='false' and t.subactivity_id=?1")
    List<ThresholdParameter> findThresholdbySubActId(Integer id);
    
    @Query("SELECT new ThresholdParameter(t.id, t.name,t.unit,t.val,t.threshold_unit,t.rendering_type,t.regex,t.description) from ThresholdParameter t where t.is_active='true' and t.is_deleted='false' and t.activity_id=?2 and t.subactivity_id=?1")
    List<ThresholdParameter> findThreshold(Integer ActId,Integer SubId);
}
