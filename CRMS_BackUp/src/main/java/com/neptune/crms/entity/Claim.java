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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name="claimType",discriminatorType = DiscriminatorType.INTEGER
		)
@DiscriminatorValue("0")
// Discriminator Value "0" defines SingleClaim, it is of integer type
public class Claim {
	
	@Id
	private String claimId;
	@ManyToOne
	private Category refCategory;
	private int amount;
	private String city;
	private String country;
	private Date creationDate;
	private String bill_no;
	@Column(name="bill_attachment")
	private String billAttachmentFilePath;
	private String description;
	@ManyToOne
	private Employee employeeId;
	private ClaimStatusEnum refStatus;
	private String approverRemarks;
	private String processedBy;
	
	
}
