package com.te.lms.enums;

public enum ContactType {

	PRIMARY("PRIMARY"), EMERGENCY("EMERGENCY"), WHATSAPP("WHATSAPP");

	private final String ContactType;

	private ContactType(String contactType) {
		ContactType = contactType;
	}

	public String getContactType() {
		return ContactType;
	}

}
