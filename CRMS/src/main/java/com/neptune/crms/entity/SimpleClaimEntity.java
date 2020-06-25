package com.neptune.crms.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

//import com.neptune.crms.enums.ClaimStatus;

import lombok.Data;

@Data
@Entity(name = "simple_claim")
@PrimaryKeyJoinColumn(name = "ref_claim")
@DiscriminatorValue(value = "0")
public class SimpleClaimEntity extends ClaimEntity {

	@ManyToOne
	@JoinColumn(name = "ref_category", nullable = false)
	private CategoryEntity category;

}
