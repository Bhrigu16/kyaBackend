package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.repository.postgres.SubActivityRepository;
import com.backend.model.subActivities;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/kya/")
public class SubActivityController {
	
	@Autowired
	SubActivityRepository subActivtyRepository;
	
	
	@RequestMapping(value = "getSubactivities", method = RequestMethod.GET)
	public List<subActivities> getSubactivity() {
		return subActivtyRepository.findAllSubactivities();
	}
	
	@GetMapping("/getSubactivity")
	public List<subActivities> getSubactivityById(@RequestParam Long id) {
		return (subActivtyRepository.findAllSubactivityById(id));
	}

}
