package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.crms.entity.SimpleClaimEntity;

public interface SimpleClaimDAO extends JpaRepository<SimpleClaimEntity, Integer> {

	List<SimpleClaimEntity> findAllByApplicant(int id);

}
