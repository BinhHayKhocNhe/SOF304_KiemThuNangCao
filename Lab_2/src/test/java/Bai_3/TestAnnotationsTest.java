package Bai_3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestAnnotationsTest {
	private ArrayList<String> list;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Using @BeforeClass, executed before all test case.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Using @AfterClass, executed after all test case.");
	}

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<String>();
		System.out.println("Using @Before, executed before each test case.");
	}

	@After
	public void tearDown() throws Exception {
		list.clear();
		System.out.println("Using @After, executed after each test case.");
	}

	@Test
	public void test() {
		list.add("test");
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
	}

	@Ignore
	public void test1() {
		System.out.println("Using @Ignore, this execution is ignored.");
	}

	@Test(timeout = 10)
	public void test2() {
		System.out.println("Using @Test(timeout), it can be used to enforce timeout in Junit4 testcase.");
	}

	@Test(expected = NoSuchMethodException.class)
	public void test3() {
		System.out.println("Using @Test(expected), it will check for specified exeption during its exeption.");
	}
}