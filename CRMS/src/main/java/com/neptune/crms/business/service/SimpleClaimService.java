package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.indto.SimpleClaimInDTO;

public interface SimpleClaimService {

	List<SimpleClaimDTO> getAllClaims();

	SimpleClaimDTO getByClaimId(int id);

	List<SimpleClaimDTO> getByEmployeeId(int id);

	SimpleClaimDTO addClaim(SimpleClaimInDTO claim);

	SimpleClaimDTO updateClaim(int id, SimpleClaimInDTO claim);

}
