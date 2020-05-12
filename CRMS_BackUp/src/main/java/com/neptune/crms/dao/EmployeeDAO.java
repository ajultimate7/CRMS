package com.neptune.crms.dao;

import org.springframework.data.repository.CrudRepository;
import com.neptune.crms.entity.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

}
