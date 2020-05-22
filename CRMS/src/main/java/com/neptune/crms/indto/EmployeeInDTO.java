package com.neptune.crms.indto;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class EmployeeInDTO {

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private Long contactNo;

}
