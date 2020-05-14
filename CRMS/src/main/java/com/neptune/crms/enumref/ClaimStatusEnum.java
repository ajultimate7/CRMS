package com.neptune.crms.enumref;

import java.util.stream.Stream;

public enum ClaimStatusEnum {
	
	Submitted(0),
	InProgress(1),
	Approved(2),
	Rejected(3),
	NotSupported(4);
	
	private int code;
	
	private ClaimStatusEnum(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	
}
