package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.ClaimHasParticipantsDTO;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;

public interface ClaimHasParticipantsService {

	List<ClaimHasParticipantsEntity> addParticipants(List<Integer> employeeids, ClaimEntity claimEntity);

	List<ClaimHasParticipantsDTO> getByClaimEntity(ClaimEntity claimEntity);

	List<ClaimHasParticipantsEntity> findByClaimEntity(ClaimEntity claimEntity);

}
