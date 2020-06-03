package com.neptune.crms.dto;

import java.time.LocalDate;

import com.neptune.crms.enumref.ClaimStatusEnum;

import lombok.Data;

@Data
public class EventClaimDTO {

	private String claimId;

	private String event;

	private int amount;

	private String city;

	private String country;

	private LocalDate billDate;

	private String bill_no;

	private String billAttachmentFilePath;

	private String description;

	private int employeeId;

	private String assignedTo;

	private ClaimStatusEnum status;

}
