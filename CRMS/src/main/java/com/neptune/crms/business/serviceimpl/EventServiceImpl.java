package com.neptune.crms.business.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.business.service.EventService;
import com.neptune.crms.dao.EventDAO;
import com.neptune.crms.dto.EventDTO;
import com.neptune.crms.entity.EventEntity;
import com.neptune.crms.indto.EventInDTO;
import com.neptune.crms.mapper.EventMapper;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDao;

	@Autowired
	private EventMapper eventMapper;

	@Override
	public List<EventDTO> getAll() {
		List<EventEntity> events = new ArrayList<>();
		eventDao.findAll().forEach(events::add);
		return events.stream().map(eventMapper::entityToDTO).collect(Collectors.toList());
	}

	@Override
	public EventDTO getById(int id) {
		return eventMapper.entityToDTO(eventDao.findById(id).get());
	}

	@Override
	public void addEvent(EventInDTO event) {
		eventDao.save(eventMapper.inDTOToEntity(event));
	}

}
