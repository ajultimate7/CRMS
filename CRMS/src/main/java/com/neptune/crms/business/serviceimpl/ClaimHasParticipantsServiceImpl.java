package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.ClaimHasParticipantsService;
import com.neptune.crms.business.service.ClaimService;
import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.business.serviceUtil.EmployeeUtil;
import com.neptune.crms.dao.ClaimHasParticipantsDAO;
import com.neptune.crms.dto.ClaimHasParticipantsDTO;
import com.neptune.crms.entity.ClaimEntity;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.entity.QClaimHasParticipantsEntity;
import com.neptune.crms.mapper.ClaimHasParticipantsMapper;
import com.neptune.crms.mapper.EmployeeMapper;
import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public class ClaimHasParticipantsServiceImpl implements ClaimHasParticipantsService {

	@Autowired
	private ClaimHasParticipantsDAO claimHasParticipantsDao;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClaimHasParticipantsMapper claimHasParticipantsMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private ClaimService claimService;

	@Autowired
	private EmployeeUtil employeeUtil;

	@Override
	public List<ClaimHasParticipantsDTO> getByClaimEntity(ClaimEntity claimEntity) {
		List<ClaimHasParticipantsEntity> entities = new ArrayList<>();
		entities = claimHasParticipantsDao.findAllByClaimEntity(claimEntity);
		QClaimHasParticipantsEntity claimHasParticipantsEntity = QClaimHasParticipantsEntity.claimHasParticipantsEntity;
		BooleanExpression hasClaim = claimHasParticipantsEntity.claimEntity.eq(claimEntity);
		List<ClaimHasParticipantsEntity> testList = new ArrayList<>();
		claimHasParticipantsDao.findAll(hasClaim).forEach(testList::add);
		System.out.println(testList.size());
		return entities.stream().map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList());
		// .forEach(claimHasParticipantsmapper::entityToDTO);
	}

	@Override
	public List<ClaimHasParticipantsEntity> findByClaimEntity(ClaimEntity claimEntity) {
		return claimHasParticipantsDao.findAllByClaimEntity(claimEntity);
	}

	@Override
	public List<ClaimHasParticipantsEntity> addParticipants(List<Integer> participantIds, ClaimEntity claimEntity) {
		List<ClaimHasParticipantsEntity> claimHasParticipantsList = claimEntity.getClaimHasParticipants();
		System.out.println("Fetched the list of chpList and showing");
		if (claimHasParticipantsList == null || claimHasParticipantsList.isEmpty()) {
			claimHasParticipantsList = new ArrayList<>();
			for (int id : participantIds) {
				if (employeeService.checkAuthority(id)) {
					ClaimHasParticipantsEntity claimHasParticipantsentity = new ClaimHasParticipantsEntity();
					claimHasParticipantsentity.setClaimEntity(claimEntity);
					claimHasParticipantsentity.setEmployeeEntity(employeeUtil.getById(id));
					claimHasParticipantsList.add(claimHasParticipantsentity);
				}
			}
			return claimHasParticipantsList;
		}

		else {
			System.out.println("Inside else as the list is not empty");
			for (int i = 0; i < claimHasParticipantsList.size(); i++) {
				claimHasParticipantsDao.deleteById(claimHasParticipantsList.get(i).getId());
				claimEntity.getClaimHasParticipants().remove(i);
				System.out.println("size of list is " + claimEntity.getClaimHasParticipants().size());
			}
			return addParticipants(participantIds, claimEntity);
		}
	}
}
