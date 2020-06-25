package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.CategoryDTO;
import com.neptune.crms.entity.CategoryEntity;
import com.neptune.crms.indto.CategoryInDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryEntity inDTOToEntity(CategoryInDTO category);

	CategoryDTO entityToDTO(CategoryEntity category);

	CategoryEntity dtoToEntity(CategoryDTO category);

}
