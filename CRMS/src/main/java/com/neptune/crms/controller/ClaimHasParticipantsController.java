package com.neptune.crms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.ClaimHasParticipantsService;

@RestController
@RequestMapping("/api/claimHasParticipants/")
public class ClaimHasParticipantsController {

	@Autowired
	private ClaimHasParticipantsService claimHasParticipantsService;

}
