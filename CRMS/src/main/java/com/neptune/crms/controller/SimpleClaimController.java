package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.SimpleClaimService;
import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.indto.SimpleClaimInDTO;

@RestController
@RequestMapping("/api/claims/simple")
public class SimpleClaimController {

	@Autowired
	private SimpleClaimService simpleClaimService;

	@GetMapping("{id}")
	public SimpleClaimDTO getByClaimId(@PathVariable int id) {
		System.out.println("Get claim by id called");
		return simpleClaimService.getByClaimId(id);
	}

	@RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
	public List<SimpleClaimDTO> getAll() {
		System.out.println("Got all claims");
		return simpleClaimService.getAllClaims();
	}

	@GetMapping("?eId/{employeeId}")
	public List<SimpleClaimDTO> getByEmployeeId(@PathVariable int employeeId) {
		System.out.println("Get By Employee Id called");
		return simpleClaimService.getByEmployeeId(employeeId);
	}

	@PostMapping
	public void add(@RequestBody SimpleClaimInDTO claim) {
		System.out.println("Post controller called");

		simpleClaimService.addClaim(claim);
	}

	@PutMapping("{id}")
	public SimpleClaimDTO updateClaim(@PathVariable int id, @RequestBody SimpleClaimInDTO claim) {
		return simpleClaimService.updateClaim(id, claim);
	}

}
