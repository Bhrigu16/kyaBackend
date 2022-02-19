package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Activities;
import com.backend.repository.postgres.ActivityRepository;
import com.backend.repository.postgres.GenCodeMasterRepository;
import com.backend.service.RequestServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/kya/")
public class ActivitiesController {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	GenCodeMasterRepository genCodeMasterRepository;

	//Service to fetch IP Address
	@Autowired
	RequestServiceImpl requestServiceImpl;

	@RequestMapping("/test")
	public String hello() {
		return "Test Link";
	}

	@RequestMapping(value = "/newactivity", method = RequestMethod.POST)
	public String newActivity(@RequestBody Activities newactivity) {
		activityRepository.save(newactivity);
		return "SUCCESS";

	}
	
	/*@RequestMapping(value = "/getactivities", method = RequestMethod.GET)
	public List<activities> registerUser() {
		List<activities> activities = activityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		List<GenCodeMaster> genCodeMasters = genCodeMasterRepository.findAllByParentGrp("THRESHOLD_UNIT");
		activities.forEach(activity -> {
			activity.getSubactivity().forEach(subactivity -> {
				subactivity.getThresholdParameter().forEach(parameter -> {
					genCodeMasters.forEach(code -> {
						if(code.getVal() == parameter.getUnit()) {						
							parameter.setThreshold_unit(code.getName());
						}
					});
				});
			});
			activity.getThresholdParameter().forEach(parameter -> {
				genCodeMasters.forEach(code -> {
					if(code.getVal() == parameter.getUnit()) {						
						parameter.setThreshold_unit(code.getName());
					}
				});
			});
		});
		return activities;
	}*/
	
	@RequestMapping(value = "/getactivities", method = RequestMethod.GET)
	public List<Activities> getActivities() {
		//List<activities> activities = activityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		List<Activities> activities = activityRepository.findAllActivities();
		return activities;
	}
	
	
	@GetMapping("/getactivity/id")
	public Optional<Activities> getActivityId(@RequestParam Integer id) {
		return (activityRepository.findById(id));
	}
	

}
