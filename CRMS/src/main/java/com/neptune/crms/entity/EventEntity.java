package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="event")
public class EventEntity {

	@Id
	@Column(name="id",nullable = false)
	private int eventId;
	
	@Column(name="value",nullable = false)
	private String eventName;
}
