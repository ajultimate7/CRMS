package com.neptune.crms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
//Discriminator Value "1" defines EventClaim, it is of integer type
public class EventClaim extends Claim {

	@OneToOne
	private Event refEvent;

}
