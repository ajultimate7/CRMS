package com.neptune.crms.dao;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.EventEntity;

public interface EventDAO extends CrudRepository<EventEntity, Integer> {

	EventEntity findByNameIgnoreCase(String name);

}
