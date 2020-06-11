package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.business.serviceUtil.EmployeeUtil;
import com.neptune.crms.dao.EmployeeDAO;
import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.entity.QEmployeeEntity;
import com.neptune.crms.enums.EmployeeStatus;
import com.neptune.crms.exceptions.NotFoundException;
import com.neptune.crms.indto.EmployeeInDTO;
import com.neptune.crms.mapper.EmployeeMapper;
import com.querydsl.core.types.dsl.BooleanExpression;

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
		return employees.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> getEmployees(String lastName, String firstName, EmployeeStatus status) {
		QEmployeeEntity employeeEntity = QEmployeeEntity.employeeEntity;
		BooleanExpression condition;
		// if (lastName != null)
		condition = employeeEntity.lastName.equalsIgnoreCase("cartoon");
//		if (firstName != null)
//			condition = employeeEntity.firstName.equalsIgnoreCase(firstName);
//		if (status != null)
//			condition = employeeEntity.status.eq(status);
		List<EmployeeEntity> entities = new ArrayList<>();
		employeeDao.findAll(condition).forEach(entities::add);
		System.out.println(entities.toString());
		// return
		// entities.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
//		if (lastName != null && firstName != null) {
//			QEmployeeEntity employeeEntity = QEmployeeEntity.employeeEntity;
//			BooleanExpression condition = employeeEntity.firstName.eq(firstName)
//					.and(employeeEntity.lastName.eq(lastName));
//			List<EmployeeEntity> employees = new ArrayList<>();
//			employeeDao.findAll(condition).forEach(employees::add);
//			return employees.stream().map(employeeMapper::entityToDTO).collect(Collectors.toList());
//		}
		if (lastName != null)
			return employeeDao.findByLastNameIgnoreCase(lastName).stream().map(employeeMapper::entityToDTO)
					.collect(Collectors.toList());
		else if (firstName != null)
			return employeeDao.findByFirstNameIgnoreCase(firstName).stream().map(employeeMapper::entityToDTO)
					.collect(Collectors.toList());
		else if (status != null)
			return employeeDao.findByStatus(status).stream().map(employeeMapper::entityToDTO)
					.collect(Collectors.toList());
		else
			return null;
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
		employeeEntity.setUsername(employeeEntity.getFirstName() + "." + employeeEntity.getLastName());
		if (count > 0)
			employeeEntity.setUsername(employeeEntity.getUsername() + Integer.toString(count));
		employeeEntity
				.setEmailId(employeeEntity.getFirstName() + "." + employeeEntity.getLastName() + "@neptune-ubi.com");
		employeeEntity.setStatus(EmployeeStatus.Active);
		employeeEntity = employeeDao.save(employeeEntity);
		return employeeMapper.entityToDTO(employeeEntity);
	}

	@Override
	public EmployeeDTO activateEmployee(int id) {
		EmployeeEntity entity = employeeMapper.DTOToEntity(getById(id));
		entity.setStatus(EmployeeStatus.Active);
		entity = employeeDao.save(entity);
		return employeeMapper.entityToDTO(entity);
	}

	@Override
	public EmployeeDTO deactivateEmployee(int id) {
		EmployeeEntity entity = employeeMapper.DTOToEntity(getById(id));
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
}
