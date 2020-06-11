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
import com.neptune.crms.exceptions.BadRequestException;
import com.neptune.crms.exceptions.NotFoundException;
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
	public void addEvent(EventInDTO event) {
		if (eventDao.findByNameIgnoreCase(event.getName()) == null)
			eventDao.save(eventMapper.inDTOToEntity(event));
		else
			throw new BadRequestException("Event already exist");
	}

	@Override
	public EventDTO getById(int id) {
		return eventMapper.entityToDTO(
				eventDao.findById(id).orElseThrow(() -> new NotFoundException("No event found by the given id")));
	}

	@Override
	public void deleteById(int id) {
		if (eventDao.existsById(id))
			eventDao.deleteById(id);
		else
			throw new NotFoundException("No event found for the given id");
	}

}
