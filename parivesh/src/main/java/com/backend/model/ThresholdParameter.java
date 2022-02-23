package com.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

//@Data
//@Setter
//@Getter
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Integer activity_id) {
		this.activity_id = activity_id;
	}

	public Integer getSubactivity_id() {
		return subactivity_id;
	}

	public void setSubactivity_id(Integer subactivity_id) {
		this.subactivity_id = subactivity_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getThreshold_unit() {
		return threshold_unit;
	}

	public void setThreshold_unit(String threshold_unit) {
		this.threshold_unit = threshold_unit;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public String getRendering_type() {
		return rendering_type;
	}

	public void setRendering_type(String rendering_type) {
		this.rendering_type = rendering_type;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
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

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
