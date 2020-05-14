package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="Employee")
public class EmployeeEntity {

	@Id
	private int id;
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name="username",nullable = false)
	private String username;
	
	@Column(name="email_id",nullable = false)
	private String emailId;
	
	@Column(name="contact_no",nullable = false)
	private int contactNo;
	
	
}
