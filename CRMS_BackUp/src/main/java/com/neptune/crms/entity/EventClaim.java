package com.neptune.crms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class EventClaim extends Claim{
	
	private int refEvent;
}
