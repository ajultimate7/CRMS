package com.neptune.crms.enums;

public enum EmployeeStatus {

	Active(0), Inactive(1);

	private int code;

	private EmployeeStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
