package com.edusys.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.entity.HocVien;

public class HocVienTest {
	private HocVien instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Chuẩn bị môi trường chung cho tất cả các test case trong class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Dọn dẹp môi trường sau khi tất cả các test case trong class đã hoàn thành");
	}

	@Before
	public void setUp() throws Exception {
		instance = new HocVien();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testGetMaHV() {
		int expectedMaHV = 1234;
		instance.setMaHV(expectedMaHV);
		assertEquals(expectedMaHV, instance.getMaHV());
	}

	@Test
	public void testGetMaHV_0() {
		int expResult = 0;
		instance.setMaHV(5);
		assertTrue(instance.getMaHV() > expResult);
	}

	@Test()
	public void testGetMaHV_NgoaiLe() {
		try {
			String maHV = "kkkk";
			instance.setMaHV(Integer.parseInt(maHV));
			assertEquals(113113, instance.getMaHV());
		} catch (NumberFormatException e) {
			// Ngoại lệ được bắt và xử lý ở đây
			System.out.println("Caught NumberFormatException: " + e.getMessage());
		}
	}

	@Test
	public void testSetMaHV_ValidInput() {
		int maHV = 1234;
		instance.setMaHV(maHV);
		assertEquals(maHV, instance.getMaHV());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaHV_InvalidInput() {
		String invalidMaHV = "abc";

		instance.setMaHV(Integer.parseInt(invalidMaHV));

		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testGetMaKH() {
		int expectedMaKH = 1234;
		instance.setMaKH(expectedMaKH);
		assertEquals(expectedMaKH, instance.getMaKH());
	}

	@Test
	public void testSetMaKH() {
		int maKH = 5678;
		instance.setMaKH(maKH);
		assertEquals(maKH, instance.getMaKH());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaKH_InvalidInput() {
		String invalidMaKH = "abc";
		instance.setMaKH(Integer.parseInt(invalidMaKH));
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testGetMaNH() {
		String expectedMaNH = "ABC123";
		instance.setMaNH(expectedMaNH);
		assertEquals(expectedMaNH, instance.getMaNH());
	}

	@Test
	public void testSetMaNH() {
		String maNH = "XYZ789";
		instance.setMaNH(maNH);
		assertEquals(maNH, instance.getMaNH());
	}

	// Lỗi sẽ ở đây
	@Test(expected = IllegalArgumentException.class)
	public void testSetMaNH_NullInput() {
		String invalidMaNH = null;
		instance.setMaNH(invalidMaNH);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetMaNH_EmptyInput() {
		String emptyMaNH = "";
		instance.setMaNH(emptyMaNH);
		assertEquals(emptyMaNH, instance.getMaNH());
	}

	@Test
	public void testSetDiem_ValidInput() {
		double validDiem = 8.5;
		instance.setDiem(validDiem);
		assertEquals(validDiem, instance.getDiem(), 0.01);
	}

	@Test
	public void testSetDiem_LowerBound() {
		double lowerBoundDiem = 0;
		instance.setDiem(lowerBoundDiem);
		assertEquals(lowerBoundDiem, instance.getDiem(), 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDiem_NegativeInput() {
		double negativeDiem = -5;
		instance.setDiem(negativeDiem);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetDiem_UpperBound() {
		double upperBoundDiem = 10;
		instance.setDiem(upperBoundDiem);
		assertEquals(upperBoundDiem, instance.getDiem(), 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDiem_InvalidInput() {
		double invalidDiem = 15;
		instance.setDiem(invalidDiem);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDiem_InvalidInput1() {
		String invalidDiem = "abc";
		instance.setDiem(Double.parseDouble(invalidDiem));
		fail("Expected IllegalArgumentException to be thrown");
	}
}
