package com.te.lms.enums;

public enum EmployeeStatus {

	ABSCONDED("ABSCONDED"), TERMINATED("TERMINATED"), ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

	private final String EmployeeStatus;

	private EmployeeStatus(String employeeStatus) {
		EmployeeStatus = employeeStatus;
	}

	public String getEmployeeStatus() {
		return EmployeeStatus;
	}

}
