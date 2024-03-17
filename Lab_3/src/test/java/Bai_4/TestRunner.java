package Bai_4;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import junit.framework.TestSuite;

public class TestRunner {

	public static void main(String[] args) {
		
		JUnitCore jUnitCore = new JUnitCore();
		Result result = jUnitCore.run(TestSuite.class);
		System.out.println("Run tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Success test: " + result.wasSuccessful());
		
	}

}
