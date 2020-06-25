package com.neptune.crms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.neptune.crms.dto.ClaimHasParticipantsDTO;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface ClaimHasParticipantsMapper {

	@Mapping(target = "employeeName", source = "employeeEntity")
	@Mapping(target = "employeeId", source = "employeeEntity")
	ClaimHasParticipantsDTO entityToDTO(ClaimHasParticipantsEntity entity);

	default int getId(EmployeeEntity employeeEntity) {
		return employeeEntity.getId();
	}

	default String getName(EmployeeEntity employeeEntity) {
		return employeeEntity.getFirstName() + " " + employeeEntity.getLastName();
	}

}
