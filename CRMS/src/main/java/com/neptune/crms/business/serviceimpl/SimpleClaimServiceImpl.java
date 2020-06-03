package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.CategoryService;
import com.neptune.crms.business.service.ClaimHasParticipantsService;
import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.business.service.SimpleClaimService;
import com.neptune.crms.customgenerators.ClaimIdGenerator;
import com.neptune.crms.dao.SimpleClaimDAO;
import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.entity.SimpleClaimEntity;
import com.neptune.crms.enumref.ClaimStatusEnum;
import com.neptune.crms.indto.SimpleClaimInDTO;
import com.neptune.crms.mapper.CategoryMapper;
import com.neptune.crms.mapper.EmployeeMapper;
import com.neptune.crms.mapper.SimpleClaimMapper;

@Service
public class SimpleClaimServiceImpl implements SimpleClaimService {

	@Autowired
	private SimpleClaimDAO simpleClaimDao;

	@Autowired
	private SimpleClaimMapper simpleClaimMapper;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private ClaimHasParticipantsService claimHasParticipantsService;

	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ClaimIdGenerator claimIdGenerator;

	@Override
	public List<SimpleClaimDTO> getAllClaims() {
		List<SimpleClaimEntity> claims = new ArrayList<>();
		simpleClaimDao.findAll().forEach(claims::add);
		return claims.stream().map(simpleClaimMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public SimpleClaimDTO getById(int id) {

		return simpleClaimMapper.entityToDTO(simpleClaimDao.findById(id).get());
	}

	@Override
	public List<SimpleClaimDTO> getByEmployeeId(int id) {
		// List<SimpleClaimDTO> simpleClaim =
		// simpleClaimDao.findAllByApplicant(id).stream()
		// .map(simpleClaimMapper::entityToDTO).collect(Collectors.toList());
		return simpleClaimDao.findAllByApplicant(id).stream().map(simpleClaimMapper::entityToDTO)
				.collect(Collectors.toList());

	}

	@Override
	public void addClaim(SimpleClaimInDTO claim) {
		SimpleClaimEntity claimEntity = new SimpleClaimEntity();
		claimEntity = simpleClaimMapper.inDTOToEntity(claim);
		claimEntity.setCategory(categoryMapper.dtoToEntity(categoryService.getById(claim.getCategory())));
		claimEntity.setApplicant(employeeMapper.DTOToEntity(employeeService.getEmployee(claim.getEmployeeId())));
		claimEntity.setStatus(ClaimStatusEnum.Submitted);
		claimIdGenerator.generateClaimId(claimEntity);
		simpleClaimDao.save(claimEntity);

		if (claim.getParticipantIds() != null) {
			claim.getParticipantIds().add(claim.getEmployeeId());
			claimHasParticipantsService.addParticipants(claim.getParticipantIds(), claimEntity);
		}

	}

}
