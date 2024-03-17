package TinhChanLe;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChanLeTest {

	@Test
	public void testIsEventNumber() {
		int a = 2;
		boolean acture = ChanLe.isEventNumber(a);
		boolean expection = true;
		assertEquals(expection, acture);
	}
	@Test
	public void testIsEventNumber1() {
		int a = 3;
		boolean acture = ChanLe.isEventNumber(a);
		boolean expection = true;
		assertEquals(expection, acture);
	}

}
