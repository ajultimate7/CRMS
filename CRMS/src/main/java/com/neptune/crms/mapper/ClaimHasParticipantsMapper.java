package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.ClaimHasParticipantsDTO;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.entity.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface ClaimHasParticipantsMapper {

	ClaimHasParticipantsDTO entityToDTO(ClaimHasParticipantsEntity entity);

	default int getId(ClaimEntity claimEntity) {
		return claimEntity.getId();
	}

	default int getId(EmployeeEntity employeeEntity) {
		return employeeEntity.getId();
	}

}
