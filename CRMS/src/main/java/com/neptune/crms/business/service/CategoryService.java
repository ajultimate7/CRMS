package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.CategoryDTO;
import com.neptune.crms.indto.CategoryInDTO;

public interface CategoryService {

	List<CategoryDTO> getAll();

	void addCategory(CategoryInDTO category);

	CategoryDTO getById(int id);

	CategoryDTO getByName(String name);

}
