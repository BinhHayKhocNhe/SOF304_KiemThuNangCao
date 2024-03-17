package Bai_3;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorExample {
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void test() {
		collector.addError(new Throwable("Lỗi ở dòng 1"));
		collector.addError(new Throwable("Lỗi ở dòng 2"));
		System.out.println("Hello");
		try {
			assertTrue("A" == "B");
		} catch (Throwable e) {
			collector.addError(e);
		}
		System.out.println("PS32770 - Dương Minh Bình");
	}

}
