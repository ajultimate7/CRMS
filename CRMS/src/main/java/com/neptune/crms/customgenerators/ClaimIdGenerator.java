package com.neptune.crms.customgenerators;

import org.springframework.stereotype.Component;

import com.neptune.crms.entity.ClaimEntity;

@Component
public class ClaimIdGenerator {

	public void generateClaimId(ClaimEntity claim) {
		claim.setClaimId("CL0" + claim.getApplicant().getId());
	}

}
