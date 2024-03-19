package Bai_3;

import java.io.IOException;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import Utlis.exportExcel;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestAnnotationsTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Result == " + result.wasSuccessful());
		
		try {
			exportExcel.writeResultsToExcel(result, "test_results.xls");
			System.out.println("Test results exported to Excel successfully.");
		} catch (IOException e) {
			System.out.println("Failed to export test results to Excel: " + e.getMessage());
		}
	}

}
