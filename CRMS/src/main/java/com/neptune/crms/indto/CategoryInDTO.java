package com.neptune.crms.indto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CategoryInDTO {

	@NotBlank
	private String name;

}
