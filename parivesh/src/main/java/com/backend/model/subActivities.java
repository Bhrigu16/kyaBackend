package com.backend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name="subActivities")
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sub_activities", schema = "master")
public class subActivities {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/*@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "activity_id", insertable = false, updatable = false)
	private activities activity;
	*/

	@OneToMany(mappedBy="subActivity",fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<ThresholdParameter> thresholdParameter=new ArrayList<>();

	// Activity_Id link from activity table
	// Foreign Key
	@Column(nullable = false)
	private Long activity_id;

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

	public subActivities(Long id, String name) {
        this.id = id;
        this.name = name;

    }

	public boolean isIs_active() {
		return is_active;
	}

	@Override
	public String toString() {
		return "subActivities [id=" + id + ", name=" + name + "]";
	}

	
	
}
