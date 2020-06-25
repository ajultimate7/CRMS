package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.enums.EmployeeStatus;

public interface EmployeeDAO
		extends CrudRepository<EmployeeEntity, Integer>, QuerydslPredicateExecutor<EmployeeEntity> {

	List<EmployeeEntity> findByLastNameIgnoreCase(String lName);

	List<EmployeeEntity> findByFirstNameIgnoreCase(String firstName);

	List<EmployeeEntity> findByStatus(EmployeeStatus status);

	List<EmployeeEntity> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);

}
