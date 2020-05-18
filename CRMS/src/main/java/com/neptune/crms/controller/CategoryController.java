package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.CategoryService;
import com.neptune.crms.entity.CategoryEntity;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category/getAll")
	public List<CategoryEntity> getAll() {
		return categoryService.getAll();
	}

	@PostMapping("/category/save")
	public void addCategory(@RequestBody CategoryEntity category) {
		categoryService.addCategory(category);
	}

}
