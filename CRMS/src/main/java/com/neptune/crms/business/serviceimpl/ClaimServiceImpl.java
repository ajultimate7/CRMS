package com.neptune.crms.business.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.ClaimService;
import com.neptune.crms.dao.ClaimDao;
import com.neptune.crms.entity.ClaimEntity;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimDao claimDao;

	@Override
	public ClaimEntity getById(int id) {
		return claimDao.findById(id).get();
	}

}
