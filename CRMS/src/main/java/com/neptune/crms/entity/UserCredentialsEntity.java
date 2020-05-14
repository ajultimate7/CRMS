package com.neptune.crms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="user_credentials")
public class UserCredentialsEntity implements Serializable{

	@Id
	@OneToOne
	@JoinColumn(name="username",referencedColumnName = "username",nullable = false,unique = true)
	private EmployeeEntity username;
	
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="role",nullable = false)
	private String role;
}
