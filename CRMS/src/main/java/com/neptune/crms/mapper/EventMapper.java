package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.EventDTO;
import com.neptune.crms.entity.EventEntity;
import com.neptune.crms.indto.EventInDTO;

@Mapper(componentModel = "spring")
public interface EventMapper {

	EventEntity inDTOToEntity(EventInDTO event);

	EventDTO entityToDTO(EventEntity event);

	EventEntity dtoToEntity(EventDTO event);

}
