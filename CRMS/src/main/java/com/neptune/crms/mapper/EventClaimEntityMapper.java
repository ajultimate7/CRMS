package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.EventCLaimDTO;
import com.neptune.crms.entity.EventClaimEntity;
import com.neptune.crms.indto.EventClaimInDTO;

@Mapper
public interface EventClaimEntityMapper {

	EventClaimInDTO entityToInDTO(EventClaimEntity event);

	EventClaimEntity inDTOToEntity(EventClaimInDTO event);

	EventCLaimDTO entityToDTO(EventClaimEntity event);

}
