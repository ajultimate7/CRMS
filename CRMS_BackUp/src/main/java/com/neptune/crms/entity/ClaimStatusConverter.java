package com.neptune.crms.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ClaimStatusConverter implements AttributeConverter<ClaimStatusEnum, String> {
	
	@Override
	public String convertToDatabaseColumn(ClaimStatusEnum status) {
		switch(status) {
			case Unassigned:
				return "U";
			case InProgress:
				return "I";
			case Approved:
				return "A";
			case Rejected:
				return "R";
			default:
				throw new IllegalArgumentException("Claim Status "+status+" not supported");
		}
	}
	
	@Override
	public ClaimStatusEnum convertToEntityAttribute(String dbData) {
		switch(dbData) {
		case "U":
			return ClaimStatusEnum.Unassigned;
		case "I":
			return ClaimStatusEnum.InProgress;
		case "A":
			return ClaimStatusEnum.Approved;
		case "R":
			return ClaimStatusEnum.Rejected;
		default:
			throw new IllegalArgumentException("Claim Status "+dbData+" not supported");
		
		}
	}
	
}
