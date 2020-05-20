package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.SimpleClaimDAO;
import com.neptune.crms.entity.SimpleClaimEntity;

@Service
public class SimpleClaimService {

	@Autowired
	private SimpleClaimDAO simpleClaimDao;

	public List<SimpleClaimEntity> getAllClaims() {
		List<SimpleClaimEntity> claims = new ArrayList<>();
		simpleClaimDao.findAll().forEach(claims::add);
		return claims;
	}

	public SimpleClaimEntity getById(String id) {
		return simpleClaimDao.findById(id).get();
	}

	public List<SimpleClaimEntity> getByEmployeeId(int id) {
		List<SimpleClaimEntity> allClaimsByEmployee = new ArrayList<>();
		List<SimpleClaimEntity> claims = new ArrayList<>();
		simpleClaimDao.findAll().forEach(claims::add);
		for (SimpleClaimEntity claim : claims) {
			if (claim.getApplicant().getId() == id)
				allClaimsByEmployee.add(claim);
		}
		return allClaimsByEmployee;
	}

	public void addClaim(SimpleClaimEntity claim) {
		simpleClaimDao.save(claim);
	}

}
