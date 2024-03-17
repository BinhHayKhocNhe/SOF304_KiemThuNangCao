package Bai_1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitMessageTest {
	private String message = "PS32770";
	JunitMessage junitMessage;

	@Before
	public void setUp() throws Exception {
		junitMessage = new JunitMessage(message);
	}

	@After
	public void tearDown() throws Exception {
		junitMessage = new JunitMessage(null);
	}

	@Test(expected = ArithmeticException.class)
	public void testPrintMessage() throws Exception {
		System.out.println("FPT JUnit Message exception is printing");
		junitMessage.printMessage();
	}

	@Test
	public void testPrintHiMessage() throws Exception {
		message = "Hi! " + message;
		System.out.println("FPT JUnit Message is printing");
		assertEquals(message, junitMessage.printHiMessage());
	}

}
