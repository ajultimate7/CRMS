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
import com.neptune.crms.dao.ClaimHasParticipantsDAO;
import com.neptune.crms.dao.SimpleClaimDAO;
import com.neptune.crms.dto.SimpleClaimDTO;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.entity.SimpleClaimEntity;
import com.neptune.crms.enums.ClaimStatus;
import com.neptune.crms.exceptions.BadRequestException;
import com.neptune.crms.exceptions.NoSuchEmployeeExceptions;
import com.neptune.crms.exceptions.NotFoundException;
import com.neptune.crms.indto.SimpleClaimInDTO;
import com.neptune.crms.mapper.CategoryMapper;
import com.neptune.crms.mapper.ClaimHasParticipantsMapper;
import com.neptune.crms.mapper.EmployeeMapper;
import com.neptune.crms.mapper.SimpleClaimMapper;

@Service
public class SimpleClaimServiceImpl implements SimpleClaimService {

	@Autowired
	private SimpleClaimDAO simpleClaimDao;

	@Autowired
	private ClaimHasParticipantsDAO claimHasParticipantsDao;

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
	private ClaimHasParticipantsMapper claimHasParticipantsMapper;

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
	public SimpleClaimDTO getByClaimId(int id) {
		SimpleClaimEntity claimEntity = simpleClaimDao.findById(id).orElse(null);
		if (claimEntity == null)
			throw new NotFoundException("No claim not found by the given id");
		SimpleClaimDTO simpleClaimDTO = simpleClaimMapper.entityToDTO(claimEntity);

		simpleClaimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));
		return simpleClaimDTO;
	}

	@Override
	public List<SimpleClaimDTO> getByEmployeeId(int id) {
		List<SimpleClaimDTO> claimDTOList = simpleClaimDao.findAllByApplicant(id).stream()
				.map(simpleClaimMapper::entityToDTO).collect(Collectors.toList());
		if (claimDTOList.isEmpty())
			throw new NotFoundException("No claims raised by this employee");
		return claimDTOList;
	}

	@Override
	public SimpleClaimDTO addClaim(SimpleClaimInDTO claimInDTO) {
		boolean hasAuthortiy = employeeService.checkAuthority(claimInDTO.getEmployeeId());
		if (hasAuthortiy == false)
			throw new NoSuchEmployeeExceptions("The employee id " + claimInDTO.getEmployeeId() + " is not active");
		SimpleClaimEntity claimEntity = simpleClaimMapper.inDTOToEntity(claimInDTO);
		claimEntity.setCategory(categoryMapper.dtoToEntity(categoryService.getById(claimInDTO.getCategory())));
		claimEntity.setApplicant(employeeMapper.DTOToEntity(employeeService.getById((claimInDTO.getEmployeeId()))));
		claimEntity.setStatus(ClaimStatus.Submitted);
		claimIdGenerator.generateClaimId(claimEntity);

		List<ClaimHasParticipantsEntity> claimHasParticipantsList = new ArrayList<>();
		if (claimInDTO.getParticipantIds() != null) {
			claimInDTO.getParticipantIds().add(claimInDTO.getEmployeeId());
			claimHasParticipantsList = claimHasParticipantsService.addParticipants(claimInDTO.getParticipantIds(),
					claimEntity);
		}

		if (claimHasParticipantsList == null) {
			throw new BadRequestException(
					"All the passed participant employees are not valid employees, can not raise the claim. Retry");
		} else {
			claimEntity = simpleClaimDao.save(claimEntity);
			claimHasParticipantsDao.saveAll(claimHasParticipantsList);
		}

		claimEntity.setClaimHasParticipants(claimHasParticipantsList);
		SimpleClaimDTO simpleClaimDTO = simpleClaimMapper.entityToDTO(claimEntity);
		simpleClaimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));
		return simpleClaimDTO;

	}

	@Override
	public SimpleClaimDTO updateClaim(int id, SimpleClaimInDTO claimInDTO) {
		if (simpleClaimDao.existsById(id) == false)
			throw new NotFoundException("No claim exist by given id");
		boolean hasAuthortiy = employeeService.checkAuthority(claimInDTO.getEmployeeId());
		if (hasAuthortiy == false)
			throw new NoSuchEmployeeExceptions("The employee id " + claimInDTO.getEmployeeId() + " is not active");
		SimpleClaimEntity claimEntity = simpleClaimMapper.inDTOToEntity(claimInDTO);
		claimEntity.setCategory(categoryMapper.dtoToEntity(categoryService.getById(claimInDTO.getCategory())));
		claimEntity.setApplicant(employeeMapper.DTOToEntity(employeeService.getById((claimInDTO.getEmployeeId()))));
		claimEntity.setStatus(ClaimStatus.Submitted);
		claimEntity.setId(id);

		List<ClaimHasParticipantsEntity> claimHasParticipantsList = new ArrayList<>();
		if (claimInDTO.getParticipantIds() != null) {
			claimInDTO.getParticipantIds().add(claimInDTO.getEmployeeId());
			claimHasParticipantsList = claimHasParticipantsService.addParticipants(claimInDTO.getParticipantIds(),
					claimEntity);
		}

		if (claimHasParticipantsList == null) {
			throw new BadRequestException(
					"All the passed participant employees are not valid employees, can not raise the claim. Retry");
		} else {
			claimEntity = simpleClaimDao.save(claimEntity);
			claimHasParticipantsDao.saveAll(claimHasParticipantsList);
		}

		claimEntity.setClaimHasParticipants(claimHasParticipantsList);

		// claimEntity = simpleClaimDao.save(claimEntity);

		SimpleClaimDTO simpleClaimDTO = simpleClaimMapper.entityToDTO(claimEntity);
		simpleClaimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));
		return simpleClaimDTO;
	}

}
