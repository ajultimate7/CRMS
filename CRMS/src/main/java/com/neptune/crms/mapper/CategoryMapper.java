package com.neptune.crms.mapper;

import org.mapstruct.Mapper;

import com.neptune.crms.dto.CategoryDTO;
import com.neptune.crms.entity.CategoryEntity;
import com.neptune.crms.indto.CategoryInDTO;

@Mapper
public interface CategoryMapper {

	CategoryInDTO entityToInDTO(CategoryEntity category);

	CategoryEntity inDTOToEntity(CategoryInDTO category);

	CategoryDTO entityToDTO(CategoryEntity category);

}
