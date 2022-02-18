package com.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import java.util.Date;
//import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="activities")
@Table(name="activities", schema = "master")
public class activities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/*@JsonManagedReference
	@OneToMany(mappedBy="activity", targetEntity = subActivities.class)
	@OrderBy("name ASC")
	private List<subActivities> subactivity=new ArrayList<>();
	*/
	
	@OneToMany(mappedBy="activity", targetEntity = ThresholdParameter.class)
	@JsonManagedReference
	private Set<ThresholdParameter> thresholdParameter=new HashSet<>();
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Date created_on;
	
	//Foreign Key
	@Column(nullable = false)
	private Long created_by;
	
	@Column(nullable = false)
	private Date updated_on;
	
	//Foreign Key
	@Column(nullable = false)
	private Long updated_by;
	
	@Column(nullable = false)
	private boolean is_active;
	
	@Column(nullable = false)
	private boolean is_deleted;

	@Column(nullable = true)
	private String description;

	public activities(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}	
	
	
}	
	
	
	
	

