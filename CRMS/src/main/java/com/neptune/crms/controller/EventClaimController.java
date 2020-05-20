package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.EventClaimService;
import com.neptune.crms.entity.EventClaimEntity;

@RestController
@RequestMapping("/api")
public class EventClaimController {

	@Autowired
	private EventClaimService eventClaimService;

	@GetMapping("/eventClaim")
	public List<EventClaimEntity> getAll() {
		return eventClaimService.getAllEventClaims();
	}

	@GetMapping("/eventClaim/{id}")
	public EventClaimEntity getById(@PathVariable String id) {
		return eventClaimService.getById(id);
	}

	@PostMapping("/eventClaim")
	public void addEventClaim(@RequestBody EventClaimEntity eventClaim) {
		eventClaimService.addEventClaim(eventClaim);
	}

}
