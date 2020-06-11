package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.EventClaimEntity;

public interface EventClaimDAO extends CrudRepository<EventClaimEntity, Integer> {

	List<EventClaimEntity> findAllByApplicant(int id);

}
