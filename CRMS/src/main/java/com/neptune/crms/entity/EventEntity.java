package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "event")
public class EventEntity {

	@Id
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;
}
