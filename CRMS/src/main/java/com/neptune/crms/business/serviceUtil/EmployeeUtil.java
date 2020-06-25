package com.neptune.crms.business.serviceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neptune.crms.dao.EmployeeDAO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.exceptions.NotFoundException;

import lombok.Data;

@Data
@Component
public class EmployeeUtil {

	@Autowired
	private EmployeeDAO employeeDao;

	public EmployeeEntity getById(int id) {
		EmployeeEntity entity = employeeDao.findById(id).orElse(null);
		if (entity == null)
			throw new NotFoundException("No such employee exist by id " + id + ". Try Again!");
		return entity;
	}
}
