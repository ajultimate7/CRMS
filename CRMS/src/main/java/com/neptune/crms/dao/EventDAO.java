package com.neptune.crms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.crms.entity.EventEntity;

public interface EventDAO extends JpaRepository<EventEntity, Integer> {

	EventEntity findByNameIgnoreCase(String name);

}
