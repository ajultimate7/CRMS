package com.neptune.crms.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
//Discriminator Value "1" defines EventClaim, it is of integer type
public class EventClaim extends Claim{
	
	@OneToOne
	private Event refEvent;

	public EventClaim(String claimId, Category refCategory, int amount, String city, String country, Date creationDate,
			String bill_no, String billAttachmentFilePath, String description, int employeeId, int refStatus,
			String approverRemarks, String processedBy, Event refEvent) {
		super(claimId, refCategory, amount, city, country, creationDate, bill_no, billAttachmentFilePath, description,
				employeeId, refStatus, approverRemarks, processedBy);
		this.refEvent = refEvent;
	}
	
	
	
}
