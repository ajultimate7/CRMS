package com.neptune.crms.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class ClaimHasParticipantsId implements Serializable{
	
	private String claimId;
	private int employeeId;

}
