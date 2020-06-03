package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.ClaimHasParticipantsDTO;
import com.neptune.crms.entity.ClaimEntity;

public interface ClaimHasParticipantsService {

	List<ClaimHasParticipantsDTO> getByClaimId(int claimId);

	List<ClaimHasParticipantsDTO> getByEmployeeId(int employeeId);

	void addParticipants(List<Integer> employeeids, ClaimEntity claimEntity);

}
