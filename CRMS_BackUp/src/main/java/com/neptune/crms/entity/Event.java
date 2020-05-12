package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@Column(name="id")
	private int eventId;
	@Column(name="name")
	private String eventName;
}
