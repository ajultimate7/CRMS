package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.crms.entity.EventClaimEntity;

public interface EventClaimDAO extends JpaRepository<EventClaimEntity, Integer> {

	List<EventClaimEntity> findAllByApplicant(int id);

}
