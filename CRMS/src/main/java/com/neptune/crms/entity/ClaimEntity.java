package com.neptune.crms.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.neptune.crms.enumref.ClaimStatusEnum;

import lombok.Data;

@Data
@Entity(name = "claim")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ClaimEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private int id;

	@Column(name = "amount", nullable = false)
	private int amount;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "country", nullable = false)
	private String country;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "date_created", nullable = false, updatable = false)
	private Date creationDate;

	@Column(name = "bill_date", nullable = false)
	private LocalDate billDate;

	@Column(name = "bill_no", nullable = false)
	private String bill_no;

	@Column(name = "bill_attachment", nullable = false)
	private String billAttachmentFilePath;

	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "ref_employee", nullable = false)
	private EmployeeEntity applicant;

//	@Column(name = "claim_has_participants", nullable = false)
//	private int claimHasParticipants;

//	@Column(name = "participants", nullable = false)
//	private List<ClaimHasParticipantsEntity> participants;

	@Column(name = "status")
	private ClaimStatusEnum Status;

	@Column(name = "approver_remarks")
	private String approverRemarks;

	@ManyToOne
	@JoinColumn(name = "ref_processed_by_employee")
	private EmployeeEntity processedBy;

	@Column(name = "claim_id", nullable = true, updatable = false)
	private String claimId;

}
