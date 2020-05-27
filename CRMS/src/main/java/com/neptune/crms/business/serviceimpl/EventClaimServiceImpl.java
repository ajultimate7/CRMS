package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.EventClaimDAO;
import com.neptune.crms.entity.EventClaimEntity;

@Service
public class EventClaimService {

	@Autowired
	private EventClaimDAO eventClaimDao;

	public List<EventClaimEntity> getAllEventClaims() {
		List<EventClaimEntity> eventClaims = new ArrayList<>();
		eventClaimDao.findAll().forEach(eventClaims::add);
		return eventClaims;
	}

	public EventClaimEntity getById(String claimId) {
		return eventClaimDao.findById(claimId).get();
	}

	public void addEventClaim(EventClaimEntity eventCLaim) {
		eventClaimDao.save(eventCLaim);
	}

}
