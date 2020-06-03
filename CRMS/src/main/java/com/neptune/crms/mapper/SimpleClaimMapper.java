package com.neptune.crms.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.entity.CategoryEntity;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.entity.SimpleClaimEntity;
import com.neptune.crms.indto.SimpleClaimInDTO;

@Mapper(componentModel = "spring")
public interface SimpleClaimMapper {

	@Mapping(target = "billDate", dateFormat = "dd.mm.yyyy")
	@Mapping(target = "category", ignore = true)
	@Mapping(target = "applicant", ignore = true)
	SimpleClaimEntity inDTOToEntity(SimpleClaimInDTO claim);

	@Mapping(target = "category", ignore = true)
	@Mapping(target = "billDate", dateFormat = "dd.mm.yyyy")
	@Mapping(target = "applicant", ignore = true)
	SimpleClaimEntity dtoToEntity(SimpleClaimDTO claim);

	@Mapping(target = "billDate", dateFormat = "dd.mm.yyyy")
	@Mapping(source = "applicant", target = "employeeId")
	// @Mapping(target = "category", ignore = true)
	SimpleClaimDTO entityToDTO(SimpleClaimEntity claim);

	default int getId(EmployeeEntity employee) {
		return employee.getId();
	}

	default String getName(EmployeeEntity employee) {
		return employee.getFirstName() + " " + employee.getLastName();
	}

	default String getName(CategoryEntity category) {
		return category.getName();
	}

}
