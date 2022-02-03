package com.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trans_mst_history")
public class transactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private Long user_id;
	
	@Column(nullable = false)
	private Date created_on;
	
	@Column(nullable = false)
	private Long created_by_role_id;
	
	@Column(nullable = false)
	private Long gid_kml;
	
	@Column(nullable = false)
	private String remote_ip_address;
	
	@Column(nullable = false)
	private String remote_user_agent;
	
}
