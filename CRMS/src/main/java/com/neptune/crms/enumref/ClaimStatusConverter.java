package com.neptune.crms.enumref;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ClaimStatusConverter implements AttributeConverter<ClaimStatusEnum, Integer> {
	
	@Override
	public Integer convertToDatabaseColumn(ClaimStatusEnum status) {
		if(status==null)
			return 4;
		return status.getCode();
			
	}
	
	@Override
	public ClaimStatusEnum convertToEntityAttribute(Integer dbData) {
		if(dbData==null)
			return ClaimStatusEnum.NotSupported;
		return Stream.of(ClaimStatusEnum.values()).filter(c -> c.getCode()==dbData).findFirst().orElse(ClaimStatusEnum.NotSupported);
	}
	
}
