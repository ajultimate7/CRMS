package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.EventClaimService;
import com.neptune.crms.dto.EventClaimDTO;
import com.neptune.crms.indto.EventClaimInDTO;

@RestController
@RequestMapping("/api/eventClaim/")
public class EventClaimController {

	@Autowired
	private EventClaimService eventClaimService;

	@GetMapping
	public List<EventClaimDTO> getAll() {
		return eventClaimService.getAllClaims();
	}

	@GetMapping("{id}")
	public EventClaimDTO getById(@PathVariable int id) {
		return eventClaimService.getByClaimId(id);
	}

	@GetMapping("?eId/{employeeId}")
	public List<EventClaimDTO> getByEmployeeId(int employeeId) {
		return eventClaimService.getByEmployeeId(employeeId);
	}

	@PostMapping
	public void add(@RequestBody EventClaimInDTO event) {
		eventClaimService.addClaim(event);
	}

	@PutMapping("{id}")
	public EventClaimDTO updateClaim(@PathVariable int id, @RequestBody EventClaimInDTO claim) {
		return eventClaimService.updateClaim(id, claim);
	}

}
