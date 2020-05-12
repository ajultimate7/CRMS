package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class ClaimStatus {
	
	@Id
	@Column(name="id")
	private int claimStatusId;
	@Column(name="name")
	private String claimStatusValue;
}
