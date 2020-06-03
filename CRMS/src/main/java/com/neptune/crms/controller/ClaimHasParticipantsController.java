package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.serviceimpl.ClaimHasParticipantsServiceImpl;
import com.neptune.crms.dto.ClaimHasParticipantsDTO;

@RestController
@RequestMapping("/api/claimHasParticipants/")
public class ClaimHasParticipantsController {

	@Autowired
	private ClaimHasParticipantsServiceImpl claimHasParticipantsService;

	@GetMapping("{id}")
	public List<ClaimHasParticipantsDTO> getAllByClaimId(@PathVariable int id) {
		return claimHasParticipantsService.getByClaimId(id);
	}

	@GetMapping("?employeeId/{employeeId}")
	public List<ClaimHasParticipantsDTO> getAllByEmployeeId(@PathVariable int employeeId) {
		return claimHasParticipantsService.getByEmployeeId(employeeId);
	}

}
