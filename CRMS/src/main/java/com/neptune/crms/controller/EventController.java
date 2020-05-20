package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.EventService;
import com.neptune.crms.entity.EventEntity;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping("/events")
	public List<EventEntity> getAll() {
		return eventService.getAll();
	}

	@PostMapping("/events")
	public void addCategory(@RequestBody EventEntity event) {
		eventService.addEvent(event);
	}

}
