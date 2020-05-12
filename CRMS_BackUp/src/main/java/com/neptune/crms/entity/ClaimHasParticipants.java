package com.neptune.crms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClaimHasParticipants {

	@Id
	private String claimId;
	private int employeeId;
	
}
