package com.neptune.crms.predicates;

import org.springframework.stereotype.Component;

import com.neptune.crms.entity.QEmployeeEntity;
import com.neptune.crms.enums.EmployeeStatus;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.Data;

@Data
@Component
public class EmployeePredicate {

	private static QEmployeeEntity qEntity = QEmployeeEntity.employeeEntity;

	public static BooleanExpression firstNameEq(String firstName) {
		return qEntity.firstName.eq(firstName);
	}

	public static BooleanExpression lastNameEq(String lastName) {
		return qEntity.lastName.eq(lastName);
	}

	public static BooleanExpression statusEq(EmployeeStatus status) {
		return qEntity.status.eq(status);
	}

	public static BooleanExpression idEq(int id) {
		return qEntity.id.eq(id);
	}

}
