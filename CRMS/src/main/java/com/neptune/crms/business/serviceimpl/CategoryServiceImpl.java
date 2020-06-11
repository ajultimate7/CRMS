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
import com.neptune.crms.exceptions.BadRequestException;
import com.neptune.crms.exceptions.NotFoundException;
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
	public CategoryEntity addCategory(CategoryInDTO category) {
		if (categoryDao.findByNameIgnoreCase(category.getName()) == null)
			return categoryDao.save(categoryMapper.inDTOToEntity(category));
		else
			throw new BadRequestException("Category already exist");
	}

	@Override
	public CategoryDTO getById(int id) {
		return categoryMapper.entityToDTO(
				categoryDao.findById(id).orElseThrow(() -> new NotFoundException("No category found by the given id")));
	}

	@Override
	public void deleteById(int id) {
		if (categoryDao.existsById(id))
			categoryDao.deleteById(id);
		else
			throw new NotFoundException("No category found for the given id");
	}

}
