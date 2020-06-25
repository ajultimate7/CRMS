package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.business.service.EventClaimService;
import com.neptune.crms.business.service.EventService;
import com.neptune.crms.customgenerators.ClaimIdGenerator;
import com.neptune.crms.dao.EventClaimDAO;
import com.neptune.crms.dto.EventClaimDTO;
import com.neptune.crms.entity.ClaimHasParticipantsEntity;
import com.neptune.crms.entity.EventClaimEntity;
import com.neptune.crms.enums.ClaimStatus;
import com.neptune.crms.exceptions.NoSuchEmployeeExceptions;
import com.neptune.crms.exceptions.NotFoundException;
import com.neptune.crms.indto.EventClaimInDTO;
import com.neptune.crms.mapper.ClaimHasParticipantsMapper;
import com.neptune.crms.mapper.EmployeeMapper;
import com.neptune.crms.mapper.EventClaimMapper;
import com.neptune.crms.mapper.EventMapper;

@Service
public class EventClaimServiceImpl implements EventClaimService {

	@Autowired
	private EventClaimDAO eventClaimDao;

	@Autowired
	private EventClaimMapper eventClaimMapper;

	@Autowired
	private EventMapper eventMapper;

	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	private ClaimHasParticipantsMapper claimHasParticipantsMapper;

	@Autowired
	private EventService eventService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClaimHasParticipantsServiceImpl claimHasParticipantsService;

	@Autowired
	private ClaimIdGenerator claimIdGenerator;

	@Override
	public List<EventClaimDTO> getAllClaims() {
		List<EventClaimEntity> claims = new ArrayList<>();
		eventClaimDao.findAll().forEach(claims::add);
		return claims.stream().map(eventClaimMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public EventClaimDTO getByClaimId(int id) {
		EventClaimEntity claimEntity = eventClaimDao.findById(id).orElse(null);
		if (claimEntity == null)
			throw new NotFoundException("Claim not found by the given id");
		EventClaimDTO eventClaimDTO = eventClaimMapper.entityToDTO(claimEntity);

		eventClaimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));

		return eventClaimDTO;
	}

	@Override
	public List<EventClaimDTO> getByEmployeeId(int id) {
		List<EventClaimDTO> claimDTOList = eventClaimDao.findAllByApplicant(id).stream()
				.map(eventClaimMapper::entityToDTO).collect(Collectors.toList());
		if (claimDTOList.isEmpty())
			throw new NotFoundException("No claims raised by this employee");
		return claimDTOList;
	}

	@Override
	public EventClaimDTO addClaim(EventClaimInDTO claimInDTO) {
		boolean hasAuthortiy = employeeService.checkAuthority(claimInDTO.getEmployeeId());
		if (hasAuthortiy == false)
			throw new NoSuchEmployeeExceptions("The employee id " + claimInDTO.getEmployeeId() + " is not active");
		EventClaimEntity claimEntity = eventClaimMapper.inDTOToEntity(claimInDTO);
		claimEntity.setEvent(eventMapper.dtoToEntity(eventService.getById(claimInDTO.getEvent())));
		claimEntity.setApplicant(employeeMapper.DTOToEntity(employeeService.getById((claimInDTO.getEmployeeId()))));
		claimEntity.setStatus(ClaimStatus.Submitted);
		claimEntity = eventClaimDao.save(claimEntity);
		claimIdGenerator.generateClaimId(claimEntity);

		List<ClaimHasParticipantsEntity> claimHasParticipantsList = new ArrayList<>();
		if (claimInDTO.getParticipantIds() != null) {
			claimInDTO.getParticipantIds().add(claimInDTO.getEmployeeId());
			claimHasParticipantsList = claimHasParticipantsService.addParticipants(claimInDTO.getParticipantIds(),
					claimEntity);
		}

		claimEntity.setClaimHasParticipants(claimHasParticipantsList);

		EventClaimDTO eventClaimDTO = eventClaimMapper.entityToDTO(claimEntity);
		eventClaimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));
		return eventClaimDTO;

	}

	@Override
	public EventClaimDTO updateClaim(int id, EventClaimInDTO claimInDTO) {
		if (eventClaimDao.existsById(id) == false)
			throw new NotFoundException("No claim exist by given id");
		boolean hasAuthortiy = employeeService.checkAuthority(claimInDTO.getEmployeeId());
		if (hasAuthortiy == false)
			throw new NoSuchEmployeeExceptions("The employee id " + claimInDTO.getEmployeeId() + " is not active");
		EventClaimEntity claimEntity = eventClaimMapper.inDTOToEntity(claimInDTO);
		claimEntity.setEvent(eventMapper.dtoToEntity(eventService.getById(claimInDTO.getEvent())));
		claimEntity.setApplicant(employeeMapper.DTOToEntity(employeeService.getById((claimInDTO.getEmployeeId()))));

		claimEntity.setStatus(ClaimStatus.Submitted);
		claimEntity.setId(id);
		claimEntity = eventClaimDao.save(claimEntity);

		List<ClaimHasParticipantsEntity> claimHasParticipantsList = new ArrayList<>();
		if (claimInDTO.getParticipantIds() != null) {
			claimInDTO.getParticipantIds().add(claimInDTO.getEmployeeId());
			claimHasParticipantsList = claimHasParticipantsService.addParticipants(claimInDTO.getParticipantIds(),
					claimEntity);
		}

		claimEntity.setClaimHasParticipants(claimHasParticipantsList);

		EventClaimDTO eventClaimDTO = eventClaimMapper.entityToDTO(claimEntity);
		eventClaimDTO.setClaimHasParticipants(claimEntity.getClaimHasParticipants().stream()
				.map(claimHasParticipantsMapper::entityToDTO).collect(Collectors.toList()));
		return eventClaimDTO;
	}

}
