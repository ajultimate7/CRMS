package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.ClaimaHasParticipantsService;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;

@RestController
@RequestMapping("/api")
public class ClaimHasParticipantsController {

	@Autowired
	private ClaimaHasParticipantsService claimHasParticipantsService;

	@GetMapping("/claimHasParticipants/{id}")
	public List<ClaimHasParticipantsEntity> getAllByClaimId(String claimId) {
		return claimHasParticipantsService.getByClaimId(claimId);
	}

	@GetMapping("/claimHasParticipants/{employee_id}")
	public List<ClaimHasParticipantsEntity> getAllByEmployeeId(int employee_id) {
		return claimHasParticipantsService.getByEmployeeId(employee_id);
	}

}