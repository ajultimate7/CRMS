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
import com.neptune.crms.entity.EventClaimEntity;
import com.neptune.crms.enumref.ClaimStatusEnum;
import com.neptune.crms.indto.EventClaimInDTO;
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
	private EventService eventService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ClaimHasParticipantsServiceImpl claimhasParticipantsService;

	@Autowired
	private ClaimIdGenerator claimIdGenerator;

	@Override
	public List<EventClaimDTO> getAllEventClaims() {
		List<EventClaimEntity> eventClaims = new ArrayList<>();
		eventClaimDao.findAll().forEach(eventClaims::add);
		return eventClaims.stream().map(eventClaimMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public EventClaimDTO getById(int id) {
		return eventClaimMapper.entityToDTO(eventClaimDao.findById(id).get());
	}

	@Override
	public void addEventClaim(EventClaimInDTO eventClaim) {
		EventClaimEntity eventClaimEntity = new EventClaimEntity();
		eventClaimEntity = eventClaimMapper.inDTOToentity(eventClaim);
		eventClaimEntity.setEvent(eventMapper.dtoToEntity(eventService.getById(eventClaim.getEvent())));
		eventClaimEntity
				.setApplicant(employeeMapper.DTOToEntity(employeeService.getEmployee(eventClaim.getEmployeeId())));
		claimIdGenerator.generateClaimId(eventClaimEntity);
		eventClaimEntity.setStatus(ClaimStatusEnum.Submitted);
		eventClaimDao.save(eventClaimEntity);

		if (eventClaim.getParticipantIds() != null) {
			claimhasParticipantsService.addParticipants(eventClaim.getParticipantIds(), eventClaimEntity);
		}

	}

}
