package com.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity(name="ThresholdParameter")
@Table(name = "threshold_parameters", schema = "master")
public class ThresholdParameter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "activity_id", insertable = false, updatable = false)
//	@JsonBackReference
//	private Activities activity;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "subactivity_id", insertable = false, updatable = false)
//	@JsonBackReference
//	private SubActivities subActivity;

	// Activity_Id link from activity table
	// Foreign Key
	@Column(nullable = false)
	private Integer activity_id;

	@Column(nullable = true)
	private Integer subactivity_id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int unit;

	@Column(nullable = false)
	private String val;
	
	private String threshold_unit;

	@Column(nullable = false)
	private String data_type;

	@Column(nullable = false)
	private String rendering_type;

	@Column(nullable = true)
	private String regex;

	@Column(nullable = false)
	private Date created_on;

	// Foreign Key link to user
	@Column(nullable = false)
	private Long created_by;

	@Column(nullable = false)
	private Date updated_on;

	// Foreign Key link to user
	@Column(nullable = false)
	private Long updated_by;

	@Column(nullable = false)
	private boolean is_active;

	@Column(nullable = false)
	private boolean is_deleted;
	
	private String unit_name;

	@Column(nullable = false)
	private boolean required;
	
	@Column(nullable = true)
	private String description;
	
	
	
}
