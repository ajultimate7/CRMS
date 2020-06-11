package com.neptune.crms.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClaimHasParticipantsId implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClaimEntity claimId;
	private EmployeeEntity employeeId;

}
