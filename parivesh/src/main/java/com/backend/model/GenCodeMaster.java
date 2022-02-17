package com.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
