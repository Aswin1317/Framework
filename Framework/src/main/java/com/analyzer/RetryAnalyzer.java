package com.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retrylimit = 4;

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (counter < retrylimit) {
				counter = counter + 1;
				return true;
			}
		}
		return false;
	}
}
