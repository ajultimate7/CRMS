package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.enums.EmployeeStatus;

public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Integer>, QuerydslPredicateExecutor<EmployeeEntity> {

	List<EmployeeEntity> findByLastNameIgnoreCase(String lName);

	List<EmployeeEntity> findByFirstNameIgnoreCase(String firstName);

	List<EmployeeEntity> findByStatus(EmployeeStatus status);

	List<EmployeeEntity> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);

}
