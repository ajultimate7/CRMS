package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.EventClaimDTO;
import com.neptune.crms.indto.EventClaimInDTO;

public interface EventClaimService {

	List<EventClaimDTO> getAllClaims();

	EventClaimDTO getByClaimId(int id);

	List<EventClaimDTO> getByEmployeeId(int id);

	EventClaimDTO addClaim(EventClaimInDTO claimInDTO);

	EventClaimDTO updateClaim(int id, EventClaimInDTO claimInDTO);

}
