package com.te.lms.enums;

public enum BatchStatus {

	IN_PROGRESS("IN_PROGRESS"), COMPLETED("COMPLETED"), TO_BE_STARTED("TO_BE_STARTED");

	private final String BatchStatus;

	private BatchStatus(String batchStatus) {
		BatchStatus = batchStatus;
	}

	public String getBatchStatus() {
		return BatchStatus;
	}

}
