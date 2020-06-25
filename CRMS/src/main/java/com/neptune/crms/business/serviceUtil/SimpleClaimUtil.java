package com.neptune.crms.business.serviceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neptune.crms.dao.SimpleClaimDAO;
import com.neptune.crms.entity.SimpleClaimEntity;
import com.neptune.crms.exceptions.NotFoundException;

import lombok.Data;

@Data
@Component
public class SimpleClaimUtil {

	@Autowired
	private SimpleClaimDAO simpleClaimDao;

	public SimpleClaimEntity getById(int id) {
		SimpleClaimEntity claimEntity = simpleClaimDao.findById(id).orElse(null);
		if (claimEntity == null)
			throw new NotFoundException("No claim found by the given id");
		return claimEntity;
	}

}
