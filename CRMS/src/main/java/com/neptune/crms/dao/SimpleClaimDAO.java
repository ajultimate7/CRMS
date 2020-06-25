package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.SimpleClaimEntity;

public interface SimpleClaimDAO extends CrudRepository<SimpleClaimEntity, Integer> {

	List<SimpleClaimEntity> findAllByApplicant(int id);

}
