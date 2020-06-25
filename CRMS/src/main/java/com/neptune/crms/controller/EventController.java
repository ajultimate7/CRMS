package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.EventService;
import com.neptune.crms.dto.EventDTO;
import com.neptune.crms.indto.EventInDTO;

@RestController
@RequestMapping("/api/events/")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping
	public List<EventDTO> getAll() {
		return eventService.getAll();
	}

	@GetMapping("{id}")
	public EventDTO getById(@PathVariable int id) {
		return eventService.getById(id);
	}

	@PostMapping
	public void add(@RequestBody EventInDTO category) {
		eventService.addEvent(category);
	}

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable int id) {
		eventService.deleteById(id);
	}

}
