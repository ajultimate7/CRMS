package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.serviceimpl.EventClaimServiceImpl;
import com.neptune.crms.dto.EventClaimDTO;
import com.neptune.crms.indto.EventClaimInDTO;

@RestController
@RequestMapping("/api/eventClaim/")
public class EventClaimController {

	@Autowired
	private EventClaimServiceImpl eventClaimService;

	@GetMapping
	public List<EventClaimDTO> getAll() {
		return eventClaimService.getAllEventClaims();
	}

	@GetMapping("{id}")
	public EventClaimDTO getById(@PathVariable int id) {
		return eventClaimService.getById(id);
	}

	@PostMapping
	public void addEventClaim(@RequestBody EventClaimInDTO eventClaim) {
		eventClaimService.addEventClaim(eventClaim);
	}

}
