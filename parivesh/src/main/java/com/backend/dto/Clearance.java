package com.backend.dto;

import lombok.Data;

@Data
public class Clearance {
	private long id;
	private String approval;
	private String applicabilty;
	private String remarks;
}
