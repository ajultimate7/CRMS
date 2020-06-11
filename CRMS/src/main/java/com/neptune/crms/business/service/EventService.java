package com.neptune.crms.business.service;

import java.util.List;

import com.neptune.crms.dto.EventDTO;
import com.neptune.crms.indto.EventInDTO;

public interface EventService {

	List<EventDTO> getAll();

	void addEvent(EventInDTO event);

	EventDTO getById(int id);

	void deleteById(int id);

}
