package com.neptune.crms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name="claimType",discriminatorType = DiscriminatorType.STRING
		)
public class Claim {
	
	@Id
	private String claimId;
	private int refCategory;
	private int amount;
	private String city;
	private String country;
	private Date creationDate;
	private String bill_no;
	@Column(name="bill_attachment")
	private String billAttachmentFilePath;
	private String description;
	private int employeeId;
	private int refStatus;
	private String approverRemarks;
	private String processedBy;
	
}
