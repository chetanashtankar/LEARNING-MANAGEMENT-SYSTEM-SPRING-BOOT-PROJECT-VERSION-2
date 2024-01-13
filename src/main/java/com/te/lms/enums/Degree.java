package com.te.lms.enums;

public enum Degree {

	BE_CSE("BE_CSE"), BE_NON_CSE("BE_NON_CSE"), PG("PG"), PHD("PHD");

	private final String Degree;

	private Degree(String degree) {
		Degree = degree;
	}

	public String getDegree() {
		return Degree;
	}

}
