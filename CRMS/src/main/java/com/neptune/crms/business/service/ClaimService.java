package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.ClaimDTO;

public interface ClaimService {
//
	ClaimDTO getById(int id);

	void deleteById(int id);

	List<ClaimDTO> getAll();
//
//	int getEmployeeId(ClaimEntity claim);

}
