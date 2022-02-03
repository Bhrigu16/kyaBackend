package com.backend.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class guestUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String remoteIP;
	
	private String remoteUserAgent;
	
	private Long gidKml;

	public guestUser(Long id, String username, String remoteIP, String remoteUserAgent, Long gidKml) {
		super();
		this.id = id;
		this.username = username;
		this.remoteIP = remoteIP;
		this.remoteUserAgent = remoteUserAgent;
		this.gidKml = gidKml;
	}

	public guestUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
