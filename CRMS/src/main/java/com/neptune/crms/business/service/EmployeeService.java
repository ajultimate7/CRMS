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
		System.out.println("Converting InDTO to Entity");
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity = mapper.employeeInDTOToEntity(emp);
		System.out.println("Conversion completed");

		System.out.println("Adding username to entity");
		empEntity.setUsername(empEntity.getFirstName() + "." + empEntity.getLastName());
		System.out.println("Addition done");

		System.out.println("Adding email id to entity");
		empEntity.setEmailId(empEntity.getFirstName() + "." + empEntity.getLastName() + "@neptune.com");
		System.out.println("Addition done");

		System.out.println("Saving employee entity");
		empEntity = employeeDao.save(empEntity);
		System.out.println("Save done");

		System.out.println("Creating DTO from Entity");
		EmployeeDTO empDto = mapper.employeeEntityToDTO(empEntity);
		System.out.println("Creation done");
		return empDto;
	}

}
