package com.edusys.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {

	public static void main(String[] args) {
		JUnitCore jUnitCore = new JUnitCore();
		Result result = jUnitCore.run(AllTests.class);
		System.out.println("Run tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Passed tests: " + (result.getRunCount() - result.getFailureCount()));
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Success test: " + result.wasSuccessful());
	}

}
