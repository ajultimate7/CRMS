package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.CategoryDAO;
import com.neptune.crms.entity.CategoryEntity;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDao;

	public List<CategoryEntity> getAll() {
		List<CategoryEntity> categories = new ArrayList<>();
		categoryDao.findAll().forEach(categories::add);
		return categories;
	}

	public void addCategory(CategoryEntity category) {
		categoryDao.save(category);
	}

	public CategoryEntity getById(int id) {
		return categoryDao.findById(id).get();
	}

}
