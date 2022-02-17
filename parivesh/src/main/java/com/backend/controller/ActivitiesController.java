package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Activities;
import com.backend.model.GenCodeMaster;
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
		//String ip = ;
		return "SUCCESS";

	}
	
	@RequestMapping(value = "/getactivities", method = RequestMethod.GET)
	public List<Activities> registerUser() {
		List<Activities> activities = activityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
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
	}
	
	
	
//	@RequestMapping(value = "/userActivity", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.MULTIPART_FORM_DATA_VALUE })
//	public boolean userActivityInput(@RequestPart("json") String json, @RequestPart("file") MultipartFile file,HttpServletRequest request) {
//		System.out.println(json);
//		ObjectMapper mapper = new ObjectMapper();
//		ActivityData data = new ActivityData();
//		try {
//			data = mapper.readValue(json, ActivityData.class);
//			System.out.println(data.toString());
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		System.out.println(file.getContentType());
//		Parser parser = new Parser(new KMLConfiguration());
//		SimpleFeature f;
//		try {
//			kmlFile kmlfile= new kmlFile();
//			System.out.println("--------------------------------"+data.getActivityId());
//			
//			
//			//File path of kml file
//			System.out.println("--------------------------------Start of file ");
//			
//			byte[] bytes=file.getBytes();
//			 System.out.print(bytes);
//			
//			kmlfile.setFile_kml(bytes);
//			 
//			
//			System.out.println("--------------------------------End of file ");
//			kmlfile.setActivity_id(data.getActivityId());
//			System.out.println("--------------------------------"+kmlfile.getActivity_id());
//			kmlfile.setSub_activity_name(data.getSubActivityId());
//			kmlfile.setKmlfile_name(file.getOriginalFilename());
//			
//			
//			f = (SimpleFeature) parser.parse( file.getInputStream() );
//			Collection<SimpleFeature> placemarks =  (Collection<SimpleFeature>) f.getAttribute("Feature");
//			placemarks.forEach(feature -> {
//				kmlfile.setGeom((org.locationtech.jts.geom.Geometry) feature.getAttribute("Geometry"));
//			});
//			kmlUploadRepository.save(kmlfile);
//			System.out.println("///////////////////////////////////////////////");
//			System.out.println("Id of KML IS      "+kmlfile.getGid_kml());
//			
//			
//			//Updating the guest_User table
//			registerGuestUser(request,kmlfile.getGid_kml());
//			
//		} catch (IOException | SAXException | ParserConfigurationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return true;
//	}
	//@RequestMapping(value = "/guestUser", method = RequestMethod.GET)
	
//	public void registerGuestUser(HttpServletRequest request,Long gid_kml) {
//		guestUser ob1=new guestUser();
//		
//		
//		String ipaddress=requestServiceImpl.getClientIp(request);
//		String UserAgent=request.getHeader("USER-AGENT");
//			
//		
//		ob1.setRemoteIP(ipaddress);
//		ob1.setRemoteUserAgent(UserAgent);
//		ob1.setGidKml(gid_kml);
//		ob1.setUsername("Anonymous");
//		guestUserRepository.save(ob1);
//		
//		//request.getHeader("USER-AGENT");
//		System.out.println("  Guest User Table updated...");
//	}
	
//	public List<activityMap> getMappedActivity(List<activities> activitiesList) {
//		List<activityMap> responseList = new ArrayList<>();
//
//		List<SubActivities> subActivity_list = subActivityRepository.findAll();
//
//		for (activities a : activitiesList) {
//			activityMap ob1 = new activityMap();
//			ob1.setActivityId(a.getId());
//			ob1.setActivity_name(a.getActivity_name());
//			ob1.setthreshold_parameter(a.getThreshold_parameter());
//			ob1.setThreshold_unit(a.getThreshold_unit());
//			ob1.setthreshold_value(a.getThreshold_value());
//			for (SubActivities t : subActivity_list) {
//				if (a.getId() == t.getActivityId()) {
////					ob1.setthreshold_value(t.getThreshold_value());
//					// System.out.print("---------"+t.getSub_activity_name());
//
//					subActivityMap obj2 = new subActivityMap();
//					obj2.setSubactivityId(t.getId());
//					obj2.setSub_activity_name(t.getSub_activity_name());
//					obj2.setThreshold_value(t.getThreshold_value());
//					obj2.setThreshold_unit(t.getThreshold_unit());
//					ob1.setSubactivityMap(obj2);
//
//				}
//			}
//			responseList.add(ob1);
//		}
//
//		return responseList;
//
//	}

}
