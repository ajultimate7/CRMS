package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;

public interface ClaimHasParticipantsDAO extends JpaRepository<ClaimHasParticipantsEntity, Integer>,
		QuerydslPredicateExecutor<ClaimHasParticipantsEntity> {

	List<ClaimHasParticipantsEntity> findAllByClaimEntity(ClaimEntity claimEntity);

	// List<ClaimHasParticipantsEntity> findAllByEmployeeId(int id);

}
