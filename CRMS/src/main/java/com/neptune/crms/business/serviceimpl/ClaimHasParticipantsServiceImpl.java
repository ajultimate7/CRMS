package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.ClaimHasParticipantsDAO;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;

@Service
public class ClaimaHasParticipantsService {

	@Autowired
	private ClaimHasParticipantsDAO claimHasParticipantsDao;

	public List<ClaimHasParticipantsEntity> getByClaimId(String claimId) {
		List<ClaimHasParticipantsEntity> allParticipants = new ArrayList<>();
		claimHasParticipantsDao.findAllByClaimId(claimId).forEach(allParticipants::add);
		return allParticipants;
	}

	public List<ClaimHasParticipantsEntity> getByEmployeeId(int employeeId) {
		List<ClaimHasParticipantsEntity> allParticipants = new ArrayList<>();
		claimHasParticipantsDao.findAllByEmployeeId(employeeId).forEach(allParticipants::add);
		return allParticipants;
	}

}
