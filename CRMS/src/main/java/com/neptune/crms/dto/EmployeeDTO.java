package com.neptune.crms.dto;

import com.neptune.crms.enums.EmployeeStatus;

import lombok.Data;

@Data
public class EmployeeDTO {

	private String firstName;
	private String lastName;
	private int id;
	private String username;
	private String emailId;
	private Long contactNo;
	private EmployeeStatus status;

}
