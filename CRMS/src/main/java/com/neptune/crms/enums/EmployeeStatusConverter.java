package com.neptune.crms.enums;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {

	@Override
	public Integer convertToDatabaseColumn(EmployeeStatus status) {
		return status.getCode();
	}

	@Override
	public EmployeeStatus convertToEntityAttribute(Integer dbData) {
		return Stream.of(EmployeeStatus.values()).filter(c -> c.getCode() == dbData).findFirst().get();
	}

}
