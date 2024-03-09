package TinhChanLe;

import static org.junit.Assert.*;

import org.junit.Test;

import Demo_1.Demo_1;

public class ChanLeTest {

	@Test
	public void testIsEventNumber() {
		int a = 0;
		boolean acture = ChanLe.isEventNumber(a);
		boolean expection = true;
		assertEquals(expection, acture);
	}

}
