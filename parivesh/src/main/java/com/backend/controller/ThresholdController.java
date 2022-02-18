package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.repository.postgres.ThresholdRepository;
import com.backend.model.ThresholdParameter;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/kya/")
public class ThresholdController {
	
	@Autowired
	ThresholdRepository thresholdRepository;

	@RequestMapping(value = "/getThreshold", method = RequestMethod.GET)
	public List<ThresholdParameter> getThreshold(){
		List<ThresholdParameter> thresholdParameter = thresholdRepository.findAll();
		
		return thresholdParameter;
	}
	
	@GetMapping("/getActivityThreshold")
	public List<ThresholdParameter> getActivityByThreshold(@RequestParam Integer id) {
		return (thresholdRepository.findThresholdbyActId(id));
	}
	
	@GetMapping("/getSubActivityThreshold")
	public List<ThresholdParameter> getSubActivityByThreshold(@RequestParam Integer id) {
		return (thresholdRepository.findThresholdbySubActId(id));
	}
	
	
	
}
