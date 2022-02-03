package com.backend.dto;

import java.util.ArrayList;
import java.util.List;

import com.backend.model.EnumThreshold;

public class activityMap {
	
	String activity_name;
	
	List<String> subActivity_name=new ArrayList<String>();
	
	String threshold_param;
	
	private EnumThreshold threshold_unit;
	
	Long threshold_val;

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public List<String> getSubActivity_name() {
		return subActivity_name;
	}

	public void addSubActivity_name(String subActivity_name) {
		//System.out.println("--------------Here"+subActivity_name);
		this.subActivity_name.add(subActivity_name);
		//System.out.println("--------------Afterrrrr"+subActivity_name);
	}

	public String getThreshold_param() {
		return threshold_param;
	}

	public void setThreshold_param(String threshold_param) {
		this.threshold_param = threshold_param;
	}

	public EnumThreshold getThreshold_unit() {
		return threshold_unit;
	}

	public void setThreshold_unit(EnumThreshold threshold_unit) {
		this.threshold_unit = threshold_unit;
	}

	public Long getThreshold_val() {
		return threshold_val;
	}

	public void setThreshold_val(Long threshold_val) {
		this.threshold_val = threshold_val;
	}
	
	
}
