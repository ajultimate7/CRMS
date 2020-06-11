package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.enums.EmployeeStatus;
import com.neptune.crms.indto.EmployeeInDTO;

public interface EmployeeService {

	List<EmployeeDTO> getAllEmployees();

	EmployeeDTO getById(int id);

	List<EmployeeDTO> getEmployees(String lastName, String firstName, EmployeeStatus status);

	EmployeeDTO save(EmployeeInDTO emp);

	EmployeeDTO activateEmployee(int id);

	EmployeeDTO deactivateEmployee(int id);

	boolean checkAuthority(int id);

}
