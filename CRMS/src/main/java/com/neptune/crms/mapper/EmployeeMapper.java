package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.indto.EmployeeInDTO;

@Mapper
public interface EmployeeMapper {

	EmployeeDTO employeeEntityToDTO(EmployeeEntity emp);

	EmployeeInDTO employeeEntityToInDTO(EmployeeEntity emp);

	EmployeeEntity employeeInDTOToEntity(EmployeeInDTO emp);

}
