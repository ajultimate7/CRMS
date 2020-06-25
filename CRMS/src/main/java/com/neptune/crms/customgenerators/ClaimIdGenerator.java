package com.neptune.crms.customgenerators;

import org.springframework.stereotype.Component;

import com.neptune.crms.entity.ClaimEntity;

@Component
public class ClaimIdGenerator {

	public void generateClaimId(ClaimEntity claimEntity) {
		claimEntity.setClaimId("CL0" + "0" + claimEntity.getApplicant().getId());
		// claimEntity.setClaimId("CL0" + claimEntity.getId() + "0" +
		// claimEntity.getApplicant().getId());
	}

}
