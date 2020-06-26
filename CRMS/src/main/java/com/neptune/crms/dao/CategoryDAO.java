package com.neptune.crms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neptune.crms.entity.CategoryEntity;

public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer> {

	CategoryEntity findByNameIgnoreCase(String name);

}
