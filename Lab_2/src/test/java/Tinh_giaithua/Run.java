package Tinh_giaithua;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;

public class Run {
	public static void main(String[] args) throws Exception {
		JUnitCore runner = new JUnitCore();
		Result result = runner.run(MathFuncTest.class);
		
		System.out.println("Run tests: "+result.getRunCount());
		System.out.println("Failed tests: "+result.getFailureCount());
		System.out.println("Ignored tests: "+result.getIgnoreCount());
		System.out.println("Success tests: "+result.wasSuccessful());
	}
}	
