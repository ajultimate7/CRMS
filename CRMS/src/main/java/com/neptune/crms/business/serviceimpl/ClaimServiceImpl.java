package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.ClaimService;
import com.neptune.crms.business.service.EventClaimService;
import com.neptune.crms.business.service.SimpleClaimService;
import com.neptune.crms.dao.ClaimDao;
import com.neptune.crms.dto.ClaimDTO;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.exceptions.NotFoundException;
import com.neptune.crms.mapper.ClaimHasParticipantsMapper;
import com.neptune.crms.mapper.ClaimMapper;

@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimDao claimDao;

	@Autowired
	private ClaimMapper claimMapper;

	@Autowired
	private ClaimHasParticipantsMapper claimHasParticipantsMapper;

	@Autowired
	private SimpleClaimService simpleClaimService;

	@Autowired
	private EventClaimService eventClaimService;

	@Override
	public ClaimDTO getById(int id) {
		ClaimEntity claimEntity = claimDao.findById(id)
				.orElseThrow(() -> new NotFoundException("No claim found by given id"));
		ClaimDTO claimDTO = claimMapper.entityToDTO(claimEntity);

		// Checking for the claim type
		// 0 is the discriminator value for Simple CLaim and other type is Event Claim
		if (claimEntity.getClaimType() == 0)
			claimDTO.setCategory(simpleClaimService.getByClaimId(id).getCategory());
		else
			claimDTO.setEvent(eventClaimService.getByClaimId(id).getEvent());
		claimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));

		return claimDTO;

	}

	@Override
	public List<ClaimDTO> getAll() {
		List<ClaimEntity> claims = new ArrayList<>();
		claimDao.findAll().forEach(claims::add);
		if (claims.isEmpty())
			throw new NotFoundException("No claims found");
		List<ClaimDTO> claimDTOList = new ArrayList<>();
		for (ClaimEntity entity : claims) {
			ClaimDTO claimDTO = claimMapper.entityToDTO(entity);
			// Checking for claim type, 0 is the type for Simple Claim
			if (entity.getClaimType() == 0)
				claimDTO.setCategory(simpleClaimService.getByClaimId(entity.getId()).getCategory());
			// If not simple, then it will be event type for sure as there are only two
			// types of claim
			else
				claimDTO.setEvent(eventClaimService.getByClaimId(entity.getId()).getEvent());

			claimDTO.setClaimHasParticipants(entity.getClaimHasParticipants().stream()
					.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));

			claimDTOList.add(claimDTO);
		}
		return claimDTOList;
	}

	@Override
	public void deleteById(int id) {
		if (claimDao.existsById(id))
			claimDao.deleteById(id);
		else
			throw new NotFoundException("!No claim exist for the given id!");
	}

}
