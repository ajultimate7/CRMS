package com.neptune.crms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.neptune.crms.dto.ClaimDTO;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

	@Mapping(target = "claimHasParticipants", ignore = true)
	@Mapping(target = "employeeId", source = "applicant")
	@Mapping(target = "applicantName", source = "applicant")
	ClaimDTO entityToDTO(ClaimEntity entity);

	default int getId(EmployeeEntity employeeEntity) {
		return employeeEntity.getId();
	}

	default String getName(EmployeeEntity employeeEntity) {
		return employeeEntity.getFirstName() + " " + employeeEntity.getLastName();
	}

}
