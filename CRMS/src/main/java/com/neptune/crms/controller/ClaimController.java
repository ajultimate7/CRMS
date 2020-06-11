package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.ClaimService;
import com.neptune.crms.dto.ClaimDTO;

@RestController
@RequestMapping("api/claims/")
public class ClaimController {

	@Autowired
	private ClaimService service;

	@GetMapping("{id}")
	public ClaimDTO getById(@PathVariable int id) {
		return service.getById(id);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@GetMapping
	public List<ClaimDTO> getAll() {
		return service.getAll();
	}

}
