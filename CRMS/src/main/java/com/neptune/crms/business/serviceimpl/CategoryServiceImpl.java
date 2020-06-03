package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.CategoryService;
import com.neptune.crms.dao.CategoryDAO;
import com.neptune.crms.dto.CategoryDTO;
import com.neptune.crms.entity.CategoryEntity;
import com.neptune.crms.indto.CategoryInDTO;
import com.neptune.crms.mapper.CategoryMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryEntity> categories = new ArrayList<>();
		categoryDao.findAll().forEach(categories::add);
		return categories.stream().map(categoryMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public void addCategory(CategoryInDTO category) {
		categoryDao.save(categoryMapper.inDTOToEntity(category));
	}

	@Override
	public CategoryDTO getById(int id) {
		return categoryMapper.entityToDTO(categoryDao.findById(id).get());
	}

	@Override
	public CategoryDTO getByName(String name) {
		return categoryMapper.entityToDTO(categoryDao.findByName(name));
	}
}
