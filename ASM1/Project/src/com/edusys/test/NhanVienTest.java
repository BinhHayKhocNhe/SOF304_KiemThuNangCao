package com.edusys.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.entity.NhanVien;

public class NhanVienTest {
	private NhanVien instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new NhanVien();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testSetMaNV_ValidInput() {
		String validMaNV = "NV001";
		instance.setMaNV(validMaNV);

		assertEquals(validMaNV, instance.getMaNV());
	}

	@Test
	public void testSetMaNV_NullInput() {
		try {
			instance.setMaNV(null);
			System.out.println("Có ngoại lệ");
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			// Kiểm tra ngoại lệ và thông báo rằng test case đã thành công
			assertEquals("maNV cannot be null", e.getMessage());
			System.out.println("Không có ngoại lệ");
		}
	}

	@Test
	public void testSetMaNV_EmptyInput() {
		try {
			instance.setMaNV("");
			System.out.println("Có ngoại lệ");
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals("maNV cannot be empty", e.getMessage());
			System.out.println("Không có ngoại lệ");
		}
	}

	@Test
	public void testSetMatKhau_ValidInput() {
		String validMatKhau = "password123";
		instance.setMatKhau(validMatKhau);
		assertEquals(validMatKhau, instance.getMatKhau());
	}

	@Test
	public void testSetMatKhau_BeHon8KiTu() {
		String validMatKhau = "1234";
		instance.setMatKhau(validMatKhau);
		int length = instance.getMatKhau().length();
		assertTrue(length < 8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMatKhau_NullInput() {
		instance.setMatKhau(null);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMatKhau_EmptyInput() {
		instance.setMatKhau("");
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHoTen_NullInput() {
		instance.setHoTen(null);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHoTen_EmptyInput() {
		instance.setHoTen("");
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHoTen_ContainsDigit() {
		String invalidHoTen = "John123";
		instance.setHoTen(invalidHoTen);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetHoTen_ValidInput() {
		String validHoTen = "John Doe";
		instance.setHoTen(validHoTen);
		assertEquals(validHoTen, instance.getHoTen());
	}

}
