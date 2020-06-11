package com.neptune.crms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.neptune.crms.dto.EventClaimDTO;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.entity.EventClaimEntity;
import com.neptune.crms.entity.EventEntity;
import com.neptune.crms.indto.EventClaimInDTO;

@Mapper(componentModel = "spring")
public interface EventClaimMapper {

	@Mapping(target = "billDate", dateFormat = "dd.mm.yyyy")
	@Mapping(target = "event", ignore = true)
	@Mapping(target = "applicant", ignore = true)
	EventClaimEntity inDTOToEntity(EventClaimInDTO event);

	@Mapping(target = "billDate", dateFormat = "dd.mm.yyyy")
	@Mapping(target = "event", ignore = true)
	@Mapping(target = "applicant", ignore = true)
	EventClaimEntity dtoToEntity(EventClaimDTO event);

	@Mapping(target = "billDate", dateFormat = "dd.mm.yyyy")
	@Mapping(source = "applicant", target = "employeeId")
	EventClaimDTO entityToDTO(EventClaimEntity event);

	default int getId(EmployeeEntity employee) {
		return employee.getId();
	}

	default String getName(EmployeeEntity employee) {
		return employee.getFirstName() + " " + employee.getLastName();
	}

	default String getName(EventEntity event) {
		return event.getName();
	}

}
