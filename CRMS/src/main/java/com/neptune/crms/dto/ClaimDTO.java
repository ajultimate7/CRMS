package com.neptune.crms.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.neptune.crms.enums.ClaimStatus;

import lombok.Data;

@Data
public class ClaimDTO {

	@NotNull
	private String claimId;

	private String category;

	private String event;

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

	@NotNull
	private String applicantName;

	// @NotNull
	private List<ClaimHasParticipantsDTO> claimHasParticipants;

	@NotNull
	private String assignedTo;

	@NotNull
	private ClaimStatus status;

}
