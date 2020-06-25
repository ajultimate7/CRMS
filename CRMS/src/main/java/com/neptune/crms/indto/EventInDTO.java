package com.neptune.crms.indto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EventInDTO {

	@NotBlank
	private String name;

}
