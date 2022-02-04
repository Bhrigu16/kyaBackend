package com.backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.dto.ActivityData;
import com.backend.dto.activityMap;
import com.backend.dto.subActivityMap;
import com.backend.model.activities;
import com.backend.model.subActivities;
import com.backend.repository.ActivityRepository;
import com.backend.repository.SubActivityRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

	@RequestMapping(value = "/newactivity", method = RequestMethod.POST)
	public String newActivity(@RequestBody activities newactivity) {
		activityRepository.save(newactivity);

		return "SUCCESS";

	}

	@RequestMapping(value = "/newsubactivity", method = RequestMethod.POST)
	public String newSubActivity(@RequestBody subActivities newactivity) {
		subActivityRepository.save(newactivity);

		return "SUCCESS";

	}

	@RequestMapping(value = "/getactivities", method = RequestMethod.GET)
	public List<activityMap> registerUser() {

		return (getMappedActivity(activityRepository.findAll()));

	}

	@RequestMapping(value = "/userActivity", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public boolean userActivityInput(@RequestPart("json") String json, @RequestPart("file") MultipartFile file) {
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper();
		try {
			ActivityData data = mapper.readValue(json, ActivityData.class);
			System.out.println(data.toString());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(file.getContentType());
		return true;
	}

	public List<activityMap> getMappedActivity(List<activities> activitiesList) {

		List<activityMap> responseList = new ArrayList<>();

		List<subActivities> subActivity_list = subActivityRepository.findAll();

		for (activities a : activitiesList) {
			activityMap ob1 = new activityMap();
			ob1.setActivityId(a.getId());
			ob1.setActivity_name(a.getActivity_name());
			ob1.setthreshold_parameter(a.getThreshold_parameter());
			ob1.setThreshold_unit(a.getThreshold_unit());
			ob1.setthreshold_value(a.getThreshold_value());
			for (subActivities t : subActivity_list) {
				if (a.getId() == t.getActivityId()) {
//					ob1.setthreshold_value(t.getThreshold_value());
					// System.out.print("---------"+t.getSub_activity_name());

					subActivityMap obj2 = new subActivityMap();
					obj2.setSubactivityId(t.getId());
					obj2.setSub_activity_name(t.getSub_activity_name());
					obj2.setThreshold_value(t.getThreshold_value());
					obj2.setThreshold_unit(t.getThreshold_unit());
					ob1.setSubactivityMap(obj2);

				}
			}
			responseList.add(ob1);
		}

		return responseList;

	}

}
