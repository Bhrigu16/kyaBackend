package com.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
@Entity
@Table(name = "gen_code_master", schema = "master")
public class GenCodeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String abbr;

	@Column(nullable = false)
	private int val;

	@Column(nullable = false)
	private String parent_grp;

	@Column(nullable = false)
	private String uuid;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getParent_grp() {
		return parent_grp;
	}

	public void setParent_grp(String parent_grp) {
		this.parent_grp = parent_grp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	
	

	
}
