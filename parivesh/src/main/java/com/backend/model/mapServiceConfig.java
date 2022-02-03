package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map_service_configuration")
public class mapServiceConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long map_id;
	
	@Column(nullable = false)
	private String layer_name;
	
	@Column(nullable = false)
	private String source;
	
	@Column(nullable = false)
	private String service_name;
	
	@Column(nullable = false)
	private boolean status;
	
	private String remarks;
	
	private String zoom_extend;
	
	private String maxzoom_scale;
}
