package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.entity.SimpleClaimEntity;
import com.neptune.crms.indto.SimpleClaimInDTO;

@Mapper
public interface SimpleClaimEntityMapper {

	SimpleClaimInDTO entityToInDTO(SimpleClaimEntity claim);

	SimpleClaimEntity inDTOToEntity(SimpleClaimInDTO claim);

	SimpleClaimEntity entityToDTO(SimpleClaimDTO claim);

}
