package com.neptune.crms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SingleClaim extends Claim{
	
}
