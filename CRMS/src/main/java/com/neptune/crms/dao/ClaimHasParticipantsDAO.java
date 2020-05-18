package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.entity.ClaimHasParticipantsId;

public interface ClaimHasParticipantsDAO extends CrudRepository<ClaimHasParticipantsEntity, ClaimHasParticipantsId> {

	List<ClaimHasParticipantsEntity> findAllByClaimId(String claimId);

	List<ClaimHasParticipantsEntity> findAllByEmployeeId(int id);

}
