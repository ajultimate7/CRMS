package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.business.serviceUtil.EmployeeUtil;
import com.neptune.crms.dao.EmployeeDAO;
import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.enums.EmployeeStatus;
import com.neptune.crms.exceptions.NotFoundException;
import com.neptune.crms.indto.EmployeeInDTO;
import com.neptune.crms.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private EmployeeUtil employeeUtil;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeEntity> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);
		Predicate<EmployeeEntity> isInactive = EmployeeEntity -> EmployeeEntity.getStatus()
				.equals(EmployeeStatus.Inactive);
		employees.removeIf(isInactive);
		return employees.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> getEmployees(String lastName, String firstName, EmployeeStatus status, Integer id) {
		if (lastName != null)
			return employeeDao.findByLastNameIgnoreCase(lastName).stream().map(employeeMapper::entityToDTO)
					.collect(Collectors.toList());
		else if (firstName != null)
			return employeeDao.findByFirstNameIgnoreCase(firstName).stream().map(employeeMapper::entityToDTO)
					.collect(Collectors.toList());
		else if (status != null)
			return employeeDao.findByStatus(status).stream().map(employeeMapper::entityToDTO)
					.collect(Collectors.toList());
		else if (id != null)
			return Arrays.asList(getById(id));
		else if (lastName == null && firstName == null && status == null && id == null)
			return getAllEmployees();
		else
			return Arrays.asList(null);
		// TODO Instead of null, we can return empty list
	}

	@Override
	public EmployeeDTO getById(int id) {
		EmployeeEntity entity = employeeDao.findById(id).orElse(null);
		if (entity == null)
			throw new NotFoundException("No such employee Exist");
		return employeeMapper.entityToDTO(entity);
	}

	@Override
	public EmployeeDTO save(EmployeeInDTO employeeInDTO) {
		EmployeeEntity employeeEntity = employeeMapper.inDTOToEntity(employeeInDTO);
		int count = employeeDao
				.findByFirstNameAndLastNameIgnoreCase(employeeInDTO.getFirstName(), employeeInDTO.getLastName()).size();
		employeeEntity.setUsername(
				employeeEntity.getFirstName().toLowerCase() + "." + employeeEntity.getLastName().toLowerCase());
		if (count > 0)
			employeeEntity.setUsername(employeeEntity.getUsername() + Integer.toString(count));
		employeeEntity.setEmailId(employeeEntity.getFirstName().toLowerCase() + "."
				+ employeeEntity.getLastName().toLowerCase() + "@neptune-ubi.com");
		employeeEntity.setStatus(EmployeeStatus.Active);
		employeeEntity = employeeDao.save(employeeEntity);
		return employeeMapper.entityToDTO(employeeEntity);
	}

	@Override
	public EmployeeDTO toggleStatusOfEmployee(int id) {
		EmployeeEntity entity = employeeMapper.DTOToEntity(getById(id));
		if (entity.getStatus() == EmployeeStatus.Inactive)
			entity.setStatus(EmployeeStatus.Active);
		else
			entity.setStatus(EmployeeStatus.Inactive);
		entity = employeeDao.save(entity);
		return employeeMapper.entityToDTO(entity);
	}

	@Override
	public boolean checkAuthority(int id) {
		EmployeeEntity entity = employeeUtil.getById(id);
		if (entity.getStatus() == EmployeeStatus.Active)
			return true;
		return false;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeInDTO employeeInDTO, int id) {
		if (!employeeDao.existsById(id))
			throw new NotFoundException("No employee exist by given id");
		EmployeeEntity employeeEntity = employeeMapper.inDTOToEntity(employeeInDTO);
		int count = employeeDao
				.findByFirstNameAndLastNameIgnoreCase(employeeInDTO.getFirstName(), employeeInDTO.getLastName()).size();
		employeeEntity.setUsername(
				employeeEntity.getFirstName().toLowerCase() + "." + employeeEntity.getLastName().toLowerCase());
		if (count > 0)
			employeeEntity.setUsername(employeeEntity.getUsername() + Integer.toString(count));
		employeeEntity.setEmailId(employeeEntity.getFirstName().toLowerCase() + "."
				+ employeeEntity.getLastName().toLowerCase() + "@neptune-ubi.com");
		employeeEntity.setStatus(EmployeeStatus.Active);
		employeeEntity.setId(id);
		System.out.println("Saving updated employee");
		employeeEntity = employeeDao.save(employeeEntity);
		System.out.println("Updated employee saved");
		System.out.println(employeeEntity.toString());
		return employeeMapper.entityToDTO(employeeEntity);
	}

}
