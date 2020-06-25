package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "claim_has_participants")
public class ClaimHasParticipantsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ref_claim", nullable = false)
	private ClaimEntity claimEntity;

	@ManyToOne
	@JoinColumn(name = "ref_employee", nullable = false)
	private EmployeeEntity employeeEntity;

}
