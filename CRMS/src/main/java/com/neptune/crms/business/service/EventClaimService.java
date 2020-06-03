package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.EventClaimDTO;
import com.neptune.crms.indto.EventClaimInDTO;

public interface EventClaimService {

	List<EventClaimDTO> getAllEventClaims();

	EventClaimDTO getById(int claimId);

	void addEventClaim(EventClaimInDTO eventCLaim);

}
