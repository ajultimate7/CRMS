package com.neptune.crms.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Data
@Entity(name = "event_claim")
@PrimaryKeyJoinColumn(name = "claim_id")
public class EventClaimEntity extends ClaimEntity {

//	@Column(name = "claim_id", nullable = false)
//	private String claimId;

	@ManyToOne
	@JoinColumn(name = "ref_event", nullable = false)
	private EventEntity refEvent;
}
