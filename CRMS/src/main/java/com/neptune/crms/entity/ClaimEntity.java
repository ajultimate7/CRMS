package com.neptune.crms.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.neptune.crms.enums.ClaimStatus;

import lombok.Data;

@Data
@Entity(name = "claim")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "claim_type", discriminatorType = DiscriminatorType.INTEGER)
public class ClaimEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = true, nullable = false, updatable = false)
	private int id;

	@Column(name = "claim_type", insertable = false, nullable = false, updatable = false)
	private int claimType;

	@Column(name = "amount", nullable = false)
	private int amount;
	// BigDecimal

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
	// billNo

	@Column(name = "bill_attachment", nullable = false)
	private String billAttachmentFilePath;

	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "ref_employee", nullable = false)
	private EmployeeEntity applicant;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "claimEntity")
	private List<ClaimHasParticipantsEntity> claimHasParticipants;

	@Column(name = "status")
	private ClaimStatus status;

	@Column(name = "approver_remarks")
	private String approverRemarks;

	@ManyToOne
	@JoinColumn(name = "ref_processed_by_employee")
	private EmployeeEntity processedBy;

	@Column(name = "claim_id", nullable = true, updatable = false)
	private String claimId;

}
