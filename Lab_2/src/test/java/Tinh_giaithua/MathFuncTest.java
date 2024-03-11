package Tinh_giaithua;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MathFuncTest {
	private MathFunc math;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		math = new MathFunc();
	}

	@After
	public void tearDown() throws Exception {
		math = null;
	}

	@Test
	public void testGetCalls() {
		assertEquals(0, math.getCalls());
		
		math.giaiThua(1);
		assertEquals(1, math.getCalls());
		
		math.giaiThua(1);
		assertEquals(2, math.getCalls());
	}

	@Test
	public void testGiaiThua() {
		assertTrue(math.giaiThua(0) == 1);
		assertTrue(math.giaiThua(1) == 1);
		assertTrue(math.giaiThua(5) == 120);
	}

	@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void factorialNegative() {
		math.giaiThua(-1);
	}

	@Ignore
	@Test
	public void testPlus() {
		assertTrue(math.plus(1, 1) == 3);
	}

}
