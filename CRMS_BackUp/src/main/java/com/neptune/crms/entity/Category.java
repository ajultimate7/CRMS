package com.neptune.crms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String categoryName;
}
