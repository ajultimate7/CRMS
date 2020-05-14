package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.Cascade;

@Entity(name="claim_has_participants")
@IdClass(ClaimHasParticipantsId.class)
public class ClaimHasParticipantsEntity {

	@Id
	@Column(name="claim_id",nullable = false)
	private String claimId;
	
	@Id
	@Column(name="employee_id",nullable = false)
	private int employeeId;
	
}
