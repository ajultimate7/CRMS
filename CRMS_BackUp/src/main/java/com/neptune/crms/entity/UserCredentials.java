package com.neptune.crms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserCredentials {

	@Id
	private String username;
	private String password;
	private String role;
}
