package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.EmployeeDAO;
import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.indto.EmployeeInDTO;
import com.neptune.crms.mapper.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	private EmployeeMapper mapper;

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

	public List<EmployeeEntity> getByLastName(String lName) {
		System.out.println("calling getbylastname");
		return employeeDao.findByLastName(lName);
	}

	public EmployeeDTO save(EmployeeInDTO emp) {
		EmployeeEntity empEntity = mapper.employeeInDTOToEntity(emp);
		empEntity = employeeDao.save(empEntity);

		EmployeeDTO empDto = mapper.employeeEntityToDTO(empEntity);
		return empDto;
	}

}
