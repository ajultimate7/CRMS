package com.neptune.crms.dto;

import java.time.LocalDate;
import java.util.List;

import com.neptune.crms.enumref.ClaimStatusEnum;

import lombok.Data;

@Data
public class SimpleClaimDTO {

	private String claimId;

	private String category;

	private int amount;

	private String city;

	private String country;

	private LocalDate billDate;

	private String bill_no;

	private String billAttachmentFilePath;

	private String description;

	private int employeeId;

	private List<Integer> participants;

	private String assignedTo;

	private ClaimStatusEnum status;

}
