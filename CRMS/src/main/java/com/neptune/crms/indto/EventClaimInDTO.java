package com.neptune.crms.indto;

import java.time.LocalDate;
import java.util.List;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class EventClaimInDTO {

	@NotNull
	private int event;

	@NotNull
	private int amount;

	@NotNull
	private String city;

	@NotNull
	private String country;

	@NotNull
	private LocalDate billDate;

	@NotNull
	private String bill_no;

	@NotNull
	private String billAttachmentFilePath;

	@NotNull
	private String description;

	@NotNull
	private int employeeId;

	private List<Integer> participantIds;

}
