package com.neptune.crms.enums;

import java.util.stream.Stream;

public enum ClaimStatus {
	
	Submitted(0),
	InProgress(1),
	Approved(2),
	Rejected(3),
	NotSupported(4);
	
	private int code;
	
	private ClaimStatus(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	
}
