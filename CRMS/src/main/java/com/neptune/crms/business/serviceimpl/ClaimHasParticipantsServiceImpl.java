package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.ClaimHasParticipantsService;
import com.neptune.crms.dao.ClaimHasParticipantsDAO;
import com.neptune.crms.dto.ClaimHasParticipantsDTO;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.mapper.ClaimHasParticipantsMapper;
import com.neptune.crms.mapper.EmployeeMapper;

@Service
public class ClaimHasParticipantsServiceImpl implements ClaimHasParticipantsService {

	@Autowired
	private ClaimHasParticipantsDAO claimHasParticipantsDao;

//	@Autowired
//	private ClaimServiceImpl claimService;

	@Autowired
	private EmployeeServiceImpl employeeService;

//	@Autowired
//	private ClaimServiceImpl claimService;

	@Autowired
	private ClaimHasParticipantsMapper mapper;

	@Autowired
	private EmployeeMapper employeeMapper;

//	@Autowired
//	private SimpleClaimMapper simpleClaimMapper;

	@Override
	public List<ClaimHasParticipantsDTO> getByClaimId(int claimId) {
		List<ClaimHasParticipantsEntity> allParticipants = new ArrayList<>();
		System.out.println("Fetching all CHP_entities by claim id");
		// claimService.getById(claimId).forEach(allParticipants::add);
		System.out.println("Done fetching all CHP_entities by claim id");
		return allParticipants.stream().map(mapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public List<ClaimHasParticipantsDTO> getByEmployeeId(int employeeId) {
		List<ClaimHasParticipantsEntity> allParticipants = new ArrayList<>();
		claimHasParticipantsDao.findByEmployeeId(employeeId).forEach(allParticipants::add);
		return allParticipants.stream().map(mapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public void addParticipants(List<Integer> participantIds, ClaimEntity claimEntity) {
		for (int id : participantIds) {
			ClaimHasParticipantsEntity claimHasParticipantsentity = new ClaimHasParticipantsEntity();
			claimHasParticipantsentity.setId(claimEntity);
			claimHasParticipantsentity.setEmployeeId(employeeMapper.DTOToEntity(employeeService.getEmployee(id)));
			claimHasParticipantsDao.save(claimHasParticipantsentity);
		}

	}

}
