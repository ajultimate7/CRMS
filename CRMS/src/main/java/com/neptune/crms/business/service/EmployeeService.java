package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.EmployeeDAO;
import com.neptune.crms.entity.EmployeeEntity;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);
		return employees;
	}

	public EmployeeEntity getEmployee(int id) {
		return employeeDao.findById(id).get();
	}

	public void addEmployee(EmployeeEntity employee) {
		employeeDao.save(employee);
	}

}
