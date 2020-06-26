package com.neptune.crms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.crms.entity.ClaimEntity;

public interface ClaimDao extends JpaRepository<ClaimEntity, Integer> {

}
