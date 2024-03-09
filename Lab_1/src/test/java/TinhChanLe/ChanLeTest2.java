package TinhChanLe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Demo_1.Demo_1;

public class ChanLeTest2 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		int a = 10;
        boolean result = ChanLe.isEventNumber(a);
        assertFalse(result);
	}

	@After
	public void tearDown() throws Exception {
		int a = 10;
        boolean result = ChanLe.isEventNumber(a);
        assertFalse(result);
	}

	@Test
	public void test() {
		int a = 9;
        boolean actual = ChanLe.isEventNumber(a);
        assertTrue(actual);
	}

}
