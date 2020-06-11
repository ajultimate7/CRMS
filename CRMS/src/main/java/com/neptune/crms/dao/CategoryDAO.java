package com.neptune.crms.dao;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.CategoryEntity;

public interface CategoryDAO extends CrudRepository<CategoryEntity, Integer> {

	CategoryEntity findByNameIgnoreCase(String name);

}
