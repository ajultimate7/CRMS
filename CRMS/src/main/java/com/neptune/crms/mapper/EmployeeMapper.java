package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.indto.EmployeeInDTO;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

	EmployeeDTO entityToDTO(EmployeeEntity emp);

	EmployeeEntity inDTOToEntity(EmployeeInDTO emp);

	EmployeeEntity DTOToEntity(EmployeeDTO emp);

}
