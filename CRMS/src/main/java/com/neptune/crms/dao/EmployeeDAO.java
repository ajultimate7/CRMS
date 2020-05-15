package com.neptune.crms.dao;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.EmployeeEntity;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Integer> {

}
