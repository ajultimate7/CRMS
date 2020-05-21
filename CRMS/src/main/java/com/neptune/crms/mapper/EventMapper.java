package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.EventDTO;
import com.neptune.crms.entity.EventEntity;
import com.neptune.crms.indto.EventInDTO;

@Mapper
public interface EventMapper {

	EventInDTO entityToInDTO(EventEntity event);

	EventEntity inDTOToEntity(EventInDTO event);

	EventDTO entityToDTO(EventEntity event);

}
