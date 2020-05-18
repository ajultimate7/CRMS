package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.ClaimDAO;
import com.neptune.crms.entity.ClaimEntity;

@Service
public class ClaimService {

	@Autowired
	private ClaimDAO claimDao;

	public List<ClaimEntity> getAllClaims() {
		List<ClaimEntity> claims = new ArrayList<>();
		claimDao.findAll().forEach(claims::add);
		return claims;
	}

	public ClaimEntity getById(String id) {
		return claimDao.findById(id).get();
	}

	public List<ClaimEntity> getByEmployeeId(int id) {
		List<ClaimEntity> allClaimsByEmployee = new ArrayList<>();
		List<ClaimEntity> claims = new ArrayList<>();
		claimDao.findAll().forEach(claims::add);
		for (ClaimEntity claim : claims) {
			if (claim.getApplicant().getId() == id)
				allClaimsByEmployee.add(claim);
		}
		return allClaimsByEmployee;
	}

	public void addClaim(ClaimEntity claim) {
		claimDao.save(claim);
	}

}
