package com.neptune.crms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.neptune.crms.entity.EmployeeEntity;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Integer> {

	List<EmployeeEntity> findByLastName(String lName);

//	@Query(value = "from EmployeeEntity e where e.lastName=?1", nativeQuery = false)
//	List<EmployeeEntity> findAllByLastName(String lastName, Sort sort);

//	@Query("select e from EmployeeEntity e where e.lastName = 'Jain'")
	// List<EmployeeEntity> findByLastName();

}
