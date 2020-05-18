package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.ClaimService;
import com.neptune.crms.entity.ClaimEntity;

@RestController
@RequestMapping("/api")
public class ClaimController {

	@Autowired
	private ClaimService claimService;

	@GetMapping("/claims/{id}")
	public ClaimEntity get(@PathVariable String id) {
		System.out.println("Get claim by id called");
		return claimService.getById(id);
	}

	@RequestMapping(value = "/claims/getAll", produces = "application/json", method = RequestMethod.GET)
	public List<ClaimEntity> getAll() {
		System.out.println("Got all claims");
		return claimService.getAllClaims();
	}

	@GetMapping("/claims/byEmpId/{id}")
	public List<ClaimEntity> getByEmployeeId(int id) {
		System.out.println("Get By Employee Id called");
		return claimService.getByEmployeeId(id);
	}

}
