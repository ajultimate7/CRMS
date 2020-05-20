package com.neptune.crms.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neptune.crms.dao.EventDAO;
import com.neptune.crms.entity.EventEntity;

@Service
public class EventService {

	@Autowired
	private EventDAO eventDao;

	public List<EventEntity> getAll() {
		List<EventEntity> events = new ArrayList<>();
		eventDao.findAll().forEach(events::add);
		return events;
	}

	public EventEntity getById(int id) {
		return eventDao.findById(id).get();
	}

	public void addEvent(EventEntity event) {
		eventDao.save(event);
	}

}
