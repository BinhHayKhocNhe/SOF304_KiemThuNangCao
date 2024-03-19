package Bai_4;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import Utlis.exportExcel;
import junit.framework.TestSuite;

public class TestRunner {

	public static void main(String[] args) {
		
		JUnitCore jUnitCore = new JUnitCore();
		Result result = jUnitCore.run(TestSuite.class);
		System.out.println("Run tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Success test: " + result.wasSuccessful());
		try {
			exportExcel.writeResultsToExcel(result, "test_results.xls");
			System.out.println("Test results exported to Excel successfully.");
		} catch (IOException e) {
			System.out.println("Failed to export test results to Excel: " + e.getMessage());
		}
	}

}
