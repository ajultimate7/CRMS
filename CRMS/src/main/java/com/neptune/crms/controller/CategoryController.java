package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.CategoryService;
import com.neptune.crms.dto.CategoryDTO;
import com.neptune.crms.entity.CategoryEntity;
import com.neptune.crms.indto.CategoryInDTO;

@RestController
@RequestMapping("/api/categories/")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<CategoryDTO> getAll() {
		return categoryService.getAll();
	}

	@GetMapping("{id}")
	public CategoryDTO getById(@PathVariable int id) {
		return categoryService.getById(id);
	}

	@PostMapping
	public CategoryEntity add(@RequestBody CategoryInDTO category) {
		return categoryService.addCategory(category);
	}

	@DeleteMapping("{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteById(id);
	}

}
