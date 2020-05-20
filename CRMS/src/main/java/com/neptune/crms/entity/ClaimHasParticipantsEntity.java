package com.neptune.crms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "claim_has_participants")
@IdClass(ClaimHasParticipantsId.class)
public class ClaimHasParticipantsEntity {

	@Id
	@ManyToOne
	@JoinColumn(name = "ref_claim", nullable = false)
	private SimpleClaimEntity claimId;

	@Id
	@ManyToOne
	@JoinColumn(name = "ref_employee", nullable = false)
	private EmployeeEntity employeeId;

}
