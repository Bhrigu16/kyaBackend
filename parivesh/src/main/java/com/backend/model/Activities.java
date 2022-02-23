package com.backend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import java.util.Date;
//import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

//@Data
@Entity(name="activities")
@Table(name="activities", schema = "master")
public class Activities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/*@JsonManagedReference
	@OneToMany(mappedBy="activity", targetEntity = subActivities.class)
	@OrderBy("name ASC")
	private List<subActivities> subactivity=new ArrayList<>();
	*/
//	
//	@OneToMany(mappedBy="activity", targetEntity = ThresholdParameter.class)
//	@JsonManagedReference
//	private Set<ThresholdParameter> thresholdParameter=new HashSet<>();
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public Long getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Long updated_by) {
		this.updated_by = updated_by;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}	
	
	
	
	

