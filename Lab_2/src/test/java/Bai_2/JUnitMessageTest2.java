package Bai_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitMessageTest2 {

	private String message = "FPT Poly";
	JUnitMessage mess = new JUnitMessage(message);

	@Test
	public void test() {
		assertEquals(message, mess.outputMessage1(message));
	}
}