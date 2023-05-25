package com.random;

import org.apache.commons.lang.RandomStringUtils;

public class DataGeneration {
	public String generateAlphaNumericData(int limit) {
		String random = RandomStringUtils.randomAlphanumeric(limit);
		System.out.println("Random alphanumeric String: " + random);
		return random;
	}

	public String generateNumericData(int limit) {
		String random = RandomStringUtils.randomNumeric(limit);
		System.out.println("Random numeric String: " + random);
		return random;
	}

	public String generateAlphabeticData(int limit) {
		String random = RandomStringUtils.randomAlphabetic(limit);
		System.out.println("Random alpha String: " + random);
		return random;
	}
}
