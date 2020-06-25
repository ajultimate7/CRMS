package com.neptune.crms.enums;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ClaimStatusConverter implements AttributeConverter<ClaimStatus, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(ClaimStatus status) {
		if(status==null)
			return 4;
		return status.getCode();
			
	}
	
	@Override
	public ClaimStatus convertToEntityAttribute(Integer dbData) {
		if(dbData==null)
			return ClaimStatus.NotSupported;
		return Stream.of(ClaimStatus.values()).filter(c -> c.getCode()==dbData).findFirst().orElse(ClaimStatus.NotSupported);
	}
	
}
