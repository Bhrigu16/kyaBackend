package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.SubActivities;
import com.backend.repository.postgres.SubActivityRepository;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/kya/")
public class SubActivityController {
	
	@Autowired
	SubActivityRepository subActivtyRepository;
	
	
	@RequestMapping(value = "getSubactivities", method = RequestMethod.GET)
	public List<SubActivities> getSubactivity() {
		return subActivtyRepository.findAllSubActivities();
	}
	
	@GetMapping("/getSubactivity")
	public List<SubActivities> getSubactivityById(@RequestParam Integer id) {
		return (subActivtyRepository.findAllSubactivityById(id));
	}

}
