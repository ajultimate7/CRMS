package com.neptune.crms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("1")
public class EventClaimEntity extends ClaimEntity{
	
	
	@ManyToOne
	@JoinColumn(name="ref_event")
	private EventEntity refEvent;
}
