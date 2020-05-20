package com.neptune.crms.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

//import com.neptune.crms.enumref.ClaimStatusEnum;

import lombok.Data;

@Data
@Entity(name = "simple_claim")
@PrimaryKeyJoinColumn(name = "claim_id")
public class SimpleClaimEntity extends ClaimEntity {

//	@OneToOne
//	@JoinColumn(name = "ref_claim_id", nullable = false)
//	private String claim_id;

	@ManyToOne
	@JoinColumn(name = "ref_category", nullable = false)
	private CategoryEntity category;

}
