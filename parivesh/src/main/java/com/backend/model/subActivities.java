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
@Entity
@Table(name = "sub_activities", schema = "master")
public class SubActivities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/*@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "activity_id", insertable = false, updatable = false)
	private activities activity;
	*/
//
//	@OneToMany(mappedBy="subActivity",fetch = FetchType.EAGER)
//	@JsonManagedReference
//	private List<ThresholdParameter> thresholdParameter=new ArrayList<>();

	// Activity_Id link from activity table
	// Foreign Key
	@Column(nullable = false)
	private Integer activity_id;

	@Column(nullable = false)
	private String name;

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

	@Column(nullable = true)
	private String description;
	
}
