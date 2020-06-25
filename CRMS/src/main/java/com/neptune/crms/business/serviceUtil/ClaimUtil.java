package com.neptune.crms.business.serviceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neptune.crms.dao.ClaimDao;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.exceptions.NotFoundException;

import lombok.Data;

@Data
@Component
public class ClaimUtil {

	@Autowired
	private ClaimDao claimDao;

	public ClaimEntity getById(int id) {
		return claimDao.findById(id).orElseThrow(() -> new NotFoundException("No claim exist by the given id"));
	}

}
