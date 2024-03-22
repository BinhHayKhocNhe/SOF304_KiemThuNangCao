package com.edusys.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;
import java.util.List;

import com.edusys.dao.KhoaHocDAO;
import com.edusys.entity.KhoaHoc;

public class KhoaHocDAOTest {
	private KhoaHoc khoaHoc;
	private KhoaHocDAO instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new KhoaHocDAO();
		khoaHoc = new KhoaHoc();
	}

	@After
	public void tearDown() throws Exception {
		khoaHoc = null;
		instance = null;
	}

	@Test
	public void testInsertKhoaHoc() {
		khoaHoc.setMaCD("PRO02");
		khoaHoc.setHocPhi(1000000);
		khoaHoc.setThoiLuong(30);
		khoaHoc.setNgayKG(new Date());
		khoaHoc.setGhiChu("Test GhiChu");
		khoaHoc.setMaNV("TeoNV");

		try {
			instance.insert(khoaHoc);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateKhoaHoc() {
		khoaHoc.setMaKH(1);
		khoaHoc.setMaCD("PRO02");
		khoaHoc.setHocPhi(1500000);
		khoaHoc.setThoiLuong(40);
		khoaHoc.setNgayKG(new Date());
		khoaHoc.setGhiChu("Test GhiChu");
		khoaHoc.setMaNV("TeoNV");
		try {
			instance.update(khoaHoc);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteInteger() {
		int maKhoaHoc = 1005;

		try {
			instance.delete(maKhoaHoc);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSelectAll() {
		List<KhoaHoc> result = null;
		try {
			result = instance.selectAll();
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	public void testSelectByIdInteger() {
		int validMaKH = 1;
		khoaHoc = instance.selectById(validMaKH);
		assertNotNull(khoaHoc);
		assertEquals(validMaKH, khoaHoc.getMaKH());
	}

	@Test
	public void testSelectById_InvalidMaKH() {
		int invalidMaKH = -1;

		try {
			khoaHoc = instance.selectById(invalidMaKH);
			assertNull(khoaHoc);
		} catch (Exception e) {
			fail("Unexpected exception occurred with invalid MaKH: " + e.getMessage());
		}
	}

	@Test
	public void testSelectBySqlStringObjectArray() {
		List<KhoaHoc> result = null;
		try {
			result = instance.selectAll();
			assertNotNull(result);
			assertFalse(result.isEmpty());
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSelectByChuyenDe() {
		String validMaCD = "PRO04";
		try {
			List<KhoaHoc> result = instance.selectByChuyenDe(validMaCD);

	        assertNotNull(result);
	        assertFalse(result.isEmpty());
		} catch (Exception e) {
			fail("Unexpected exception occurred with valid MaCD: " + e.getMessage());
		}
	}

}
