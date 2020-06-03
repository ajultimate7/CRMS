package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.indto.EmployeeInDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getEmployee(int id);

	List<EmployeeDTO> getByLastName(String lastName);

	List<EmployeeDTO> getByFirstName(String firstName);

	EmployeeDTO save(EmployeeInDTO emp);

	void deleteById(int id);

}
