package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.serviceimpl.CategoryServiceImpl;
import com.neptune.crms.dto.CategoryDTO;
import com.neptune.crms.indto.CategoryInDTO;

@RestController
@RequestMapping("/api/category/")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryService;

	@GetMapping
	public List<CategoryDTO> getAll() {
		return categoryService.getAll();
	}

	@GetMapping("{id}")
	public CategoryDTO getById(@PathVariable int id) {
		return categoryService.getById(id);
	}

	@GetMapping("?name/{name}")
	public CategoryDTO getByName(@PathVariable String name) {
		return categoryService.getByName(name);
	}

	@PostMapping
	public void add(@RequestBody CategoryInDTO category) {
		categoryService.addCategory(category);
	}

}
