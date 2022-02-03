package com.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.activityMap;
import com.backend.model.activities;
import com.backend.model.subActivities;
import com.backend.repository.ActivityRepository;
import com.backend.repository.SubActivityRepository;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/kya/")
public class ActivitiesController {

	
	@Autowired
	ActivityRepository activityRepository;
	
	@Autowired
	SubActivityRepository subActivityRepository;
	
	@RequestMapping("/test")
	public String hello() {
		return "Test Link";
	}
	
	@RequestMapping(value = "/newactivity",method=RequestMethod.POST)
	public String newActivity(@RequestBody activities newactivity){
		activityRepository.save(newactivity);
		
		return "SUCCESS";
		
	}
	
	@RequestMapping(value = "/newsubactivity",method=RequestMethod.POST)
	public String newSubActivity(@RequestBody subActivities newactivity){
		subActivityRepository.save(newactivity);
		
		return "SUCCESS";
		
	}
	
	@RequestMapping(value = "/getactivities",method=RequestMethod.GET)
	public List<activityMap> registerUser(){
		
		
		return(getMappedActivity(activityRepository.findAll()));
		
		
	}
	
	
	public List<activityMap> getMappedActivity(List<activities> activitiesList){
		
		
	List<activityMap> responseList=new ArrayList<>();
		
	List<subActivities> subActivity_list=subActivityRepository.findAll();
		

			for(activities a:activitiesList ) {
				activityMap ob1=new activityMap();
				ob1.setActivity_name(a.getActivity_name());
				ob1.setThreshold_param(a.getThreshold_parameter());
				ob1.setThreshold_unit(a.getThreshold_unit());
				ob1.setThreshold_val(a.getThreshold_value());
				for(subActivities t:subActivity_list) {
					if(a.getId()==t.getActivityId()) {
						ob1.setThreshold_val(t.getThreshold_value());
						//System.out.print("---------"+t.getSub_activity_name());
						ob1.addSubActivity_name(t.getSub_activity_name());
						
					}
				}
				responseList.add(ob1);
			}
			
			return responseList;
			
			
		}
	
}
