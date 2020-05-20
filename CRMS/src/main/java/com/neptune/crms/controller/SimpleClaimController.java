package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.SimpleClaimService;
import com.neptune.crms.entity.SimpleClaimEntity;

@RestController
@RequestMapping("/api")
public class SimpleClaimController {

	@Autowired
	private SimpleClaimService simpleClaimService;

	@GetMapping("/claims/{id}")
	public SimpleClaimEntity getById(@PathVariable String id) {
		System.out.println("Get claim by id called");
		return simpleClaimService.getById(id);
	}

	@RequestMapping(value = "/claims", produces = "application/json", method = RequestMethod.GET)
	public List<SimpleClaimEntity> getAll() {
		System.out.println("Got all claims");
		return simpleClaimService.getAllClaims();
	}

	@GetMapping("/claims/{employee_id}")
	public List<SimpleClaimEntity> getByEmployeeId(int employee_id) {
		System.out.println("Get By Employee Id called");
		return simpleClaimService.getByEmployeeId(employee_id);
	}

	@PostMapping("/claims")
	public void addSimpleClaim(@RequestBody SimpleClaimEntity claim) {
		simpleClaimService.addClaim(claim);
	}

}
