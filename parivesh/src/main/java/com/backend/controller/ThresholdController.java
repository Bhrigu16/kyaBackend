package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.repository.postgres.GenCodeMasterRepository;
import com.backend.repository.postgres.ThresholdRepository;
import com.backend.model.GenCodeMaster;
import com.backend.model.ThresholdParameter;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/kya/")
public class ThresholdController {
	
	@Autowired
	ThresholdRepository thresholdRepository;
	
	@Autowired
	GenCodeMasterRepository genCodeMasterRepository;

	@RequestMapping(value = "/getThreshold", method = RequestMethod.GET)
	public List<ThresholdParameter> getThreshold(){
		List<ThresholdParameter> thresholdParameter = thresholdRepository.findAll();
		
		return thresholdParameter;
	}
	
	@GetMapping("/getActivityThreshold")
	public List<ThresholdParameter> getActivityByThreshold(@RequestParam Integer id) {
		List<ThresholdParameter> ThreshParam=thresholdRepository.findThresholdbyActId(id);
		

		List<GenCodeMaster> genCodeMasters = genCodeMasterRepository.findAllByParentGrp("THRESHOLD_UNIT");

		ThreshParam.forEach(parameter -> {
					genCodeMasters.forEach(code -> {
						if(code.getVal() == parameter.getUnit()) {	
							parameter.setThreshold_unit(code.getName());
						}
					});
		});
		
		
		return (ThreshParam);
	}
	
	@GetMapping("/getSubActivityThreshold")
	public List<ThresholdParameter> getSubActivityByThreshold(@RequestParam Integer id) {
		List<ThresholdParameter> ThreshParam=thresholdRepository.findThresholdbySubActId(id);
		
		List<GenCodeMaster> genCodeMasters = genCodeMasterRepository.findAllByParentGrp("THRESHOLD_UNIT");

		ThreshParam.forEach(parameter -> {
					genCodeMasters.forEach(code -> {
						if(code.getVal() == parameter.getUnit()) {						
							parameter.setThreshold_unit(code.getName());
						}
					});
		});
		
		
		return (ThreshParam);
	}
	
	
	
}
