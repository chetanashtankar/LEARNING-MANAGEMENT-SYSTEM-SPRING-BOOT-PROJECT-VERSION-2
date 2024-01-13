package com.te.lms.enums;

public enum AccountType {

	EMPLOYEE("EMPLOYEE"), MENTOR("MENTOR"), ADMIN("ADMIN");

	private final String AccountType;

	private AccountType(String accountType) {
		AccountType = accountType;
	}

	public String getAccountType() {
		return AccountType;
	}

}
