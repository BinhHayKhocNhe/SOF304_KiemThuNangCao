package com.edusys.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.entity.KhoaHoc;

public class KhoaHocTest {
	private KhoaHoc instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new KhoaHoc();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testSetMaKH() {
		int expectedMaKH = 1234;
		instance.setMaKH(expectedMaKH);
		assertEquals(expectedMaKH, instance.getMaKH());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaKH_BeHonHoacBang0() {
		instance.setMaKH(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaKH_NhoHon0() {
		instance.setMaKH(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaNH_NullInput() {
		String invalidMaKH = null;
		instance.setMaKH(Integer.parseInt(invalidMaKH));
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetMaNH_EmptyInput() {
		String emptyMaKH = "";
		instance.setMaKH(Integer.parseInt(emptyMaKH));
		assertEquals(Integer.parseInt(emptyMaKH), instance.getMaKH());
	}

	@Test(expected = NumberFormatException.class)
	public void testSetKH_InvalidInput1() {
		String invalidDiem = "abc";
		instance.setMaKH(Integer.parseInt(invalidDiem));
		fail("Expected NumberFormatException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaCD_NullInput() {
		String invalidMaCD = null;
		instance.setMaCD(invalidMaCD);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaCD_EmptyInput() {
		String emptyMaCD = "";
		instance.setMaCD(emptyMaCD);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetMaCD_ValidInput() {
		String validMaCD = "CD123";
		instance.setMaCD(validMaCD);
		assertEquals(validMaCD, instance.getMaCD());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHocPhi_NullInput() {
		Double invalidHocPhi = null;
		instance.setHocPhi(invalidHocPhi);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHocPhi_EmptyInput() {
		Double emptyHocPhi = 0.0;
		instance.setHocPhi(emptyHocPhi);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHocPhi_NegativeInput() {
		Double negativeHocPhi = -100.0;
		instance.setHocPhi(negativeHocPhi);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHocPhi_NonNumericInput() {
		String nonNumericHocPhi = "abc";
		instance.setHocPhi(Double.parseDouble(nonNumericHocPhi));
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHocPhi_EmptyInput1() {
		String emptyHocPhi = "";
		instance.setHocPhi(Double.parseDouble(emptyHocPhi));
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetHocPhi_ValidInput() {
		double validHocPhi = 1000.0;
		instance.setHocPhi(validHocPhi);
		assertEquals(validHocPhi, instance.getHocPhi(), 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHocPhi_LonHon100M() {
		double hocPhi = 150000000.0; // Giả sử học phí là 150 triệu VND
		instance.setHocPhi(hocPhi);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_Am() {
		int thoiLuong = -10;
		instance.setThoiLuong(thoiLuong);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_BangKhong() {
		int thoiLuong = 0;
		instance.setThoiLuong(thoiLuong);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_LonHon100() {
		int thoiLuong = 150;
		instance.setThoiLuong(thoiLuong);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_NullInput() {
		Integer invalidThoiLuong = null;
		instance.setThoiLuong(invalidThoiLuong);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_StringInput() {
		String stringThoiLuong = "invalid";
		instance.setThoiLuong(Integer.parseInt(stringThoiLuong));
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_WhiteSpaceInput() {
		String whiteSpaceThoiLuong = "";
		instance.setThoiLuong(Integer.parseInt(whiteSpaceThoiLuong));
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test
	public void testSetThoiLuong_ValidInput() {
		int validThoiLuong = 10; // Giả sử thời lượng là 10
		instance.setThoiLuong(validThoiLuong);
		assertEquals(validThoiLuong, instance.getThoiLuong());
	}

	@Test
	public void testSetNgayKG_ValidDate() {
		Date validNgayKG = new Date();
		instance.setNgayKG(validNgayKG);
		assertEquals(validNgayKG, instance.getNgayKG());
	}

	@Test
	public void testSetNgayKG_NullInput() {
		instance.setNgayKG(null);
		assertNull(instance.getNgayKG());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNgayKG_InvalidDate() {
		Date invalidNgayKG = new Date(System.currentTimeMillis() + 86400000); // Ngày trong tương lai
		instance.setNgayKG(invalidNgayKG);
	}

	@Test
	public void testSetNgayTao_ValidDate() {
		Date validNgayTao = new Date();
		instance.setNgayTao(validNgayTao);
		assertEquals(validNgayTao, instance.getNgayTao());
	}

	@Test
	public void testSetNgayTao_NullInput() {
		instance.setNgayTao(null);
		assertNull(instance.getNgayTao());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetNgayTao_InvalidDate() {
		Date invalidNgayTao = new Date(System.currentTimeMillis() + 86400000); // Ngày trong tương lai
		instance.setNgayTao(invalidNgayTao);
	}

	@Test
	public void testSetMaNV_ValidInput() {
		String validMaNV = "NV123";
		instance.setMaNV(validMaNV);
		assertEquals(validMaNV, instance.getMaNV());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaNV_NullInput() {
		instance.setMaNV(null);
		fail("Expected IllegalArgumentException to be thrown");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMaNV_EmptyInput() {
		instance.setMaNV("");
		fail("Expected IllegalArgumentException to be thrown");
	}
}
