package com.te.lms.enums;

public enum AddressType {

	PERMANAT("PERMANAT"), TEMPORARY("TEMPARORY");

	private final String AddressType;

	private AddressType(String addressType) {
		AddressType = addressType;
	}

	public String getAddressType() {
		return AddressType;
	}

}
