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

import com.neptune.crms.business.serviceimpl.SimpleClaimServiceImpl;
import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.indto.SimpleClaimInDTO;

@RestController
@RequestMapping("/api/claims/")
public class SimpleClaimController {

	@Autowired
	private SimpleClaimServiceImpl simpleClaimService;

	@GetMapping("{id}")
	public SimpleClaimDTO getById(@PathVariable int id) {
		System.out.println("Get claim by id called");
		return simpleClaimService.getById(id);
	}

	@RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
	public List<SimpleClaimDTO> getAll() {
		System.out.println("Got all claims");
		return simpleClaimService.getAllClaims();
	}

	@GetMapping("?eId/{employee_id}")
	public List<SimpleClaimDTO> getByEmployeeId(int employee_id) {
		System.out.println("Get By Employee Id called");
		return simpleClaimService.getByEmployeeId(employee_id);
	}

	@PostMapping
	public void add(@RequestBody SimpleClaimInDTO claim) {
		System.out.println("Post controller called");
		simpleClaimService.addClaim(claim);
	}

}
