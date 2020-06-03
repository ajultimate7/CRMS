package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.dao.EmployeeDAO;
import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.indto.EmployeeInDTO;
import com.neptune.crms.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeEntity> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);
		return employees.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		return employeeMapper.entityToDTO(employeeDao.findById(id).get());
	}

	@Override
	public List<EmployeeDTO> getByLastName(String lastName) {
		List<EmployeeEntity> employees = new ArrayList<>();
		employeeDao.findByLastName(lastName).forEach(employees::add);
		return employees.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> getByFirstName(String firstName) {
		List<EmployeeEntity> employees = new ArrayList<>();
		employeeDao.findByFirstName(firstName).forEach(employees::add);
		return employees.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO save(EmployeeInDTO employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity = employeeMapper.inDTOToEntity(employee);
		employeeEntity.setUsername(employeeEntity.getFirstName() + "." + employeeEntity.getLastName());
		employeeEntity
				.setEmailId(employeeEntity.getFirstName() + "." + employeeEntity.getLastName() + "@neptune-ubi.com");
		employeeEntity = employeeDao.save(employeeEntity);
		EmployeeDTO empDto = employeeMapper.entityToDTO(employeeEntity);

		return empDto;
	}

	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}

	// QueryDSL for querying employees on the basis of last name in descending order
//	public List<EmployeeDTO> getByLastNameDesc(String lastName){
//		QEmployeeEntity employee = QEmployeeEntity.employeeEntity;
//		return employeeMapper. from(employee).where(employee.lastName.eq(lastName).desc()).list(employee);
//	}

}
