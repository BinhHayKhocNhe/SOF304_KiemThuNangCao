package com.edusys.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.dao.HocVienDAO;
import com.edusys.entity.ChuyenDe;
import com.edusys.entity.HocVien;

public class HocVienDAOTest {

	private HocVien hocVien;
	private HocVienDAO instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new HocVienDAO();
		hocVien = new HocVien();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		hocVien = null;
	}

	@Test
	public void testInsert_ValidData() {
		hocVien.setMaKH(1);
		hocVien.setMaNH("NH001");
		hocVien.setDiem(8.5);

		try {
			instance.insert(hocVien);
		} catch (Exception e) {
			fail("Error occurred while inserting HocVien: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateHocVien() {
		hocVien.setMaHV(1);
		hocVien.setMaKH(1);
		hocVien.setMaNH("NH001");
		hocVien.setDiem(8.5);

		try {
			instance.update(hocVien);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteInteger() {
		int MaHV = 1;
		try {
			instance.delete(MaHV);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSelectAll() {
		List<HocVien> hocVienList = instance.selectAll();
		assertNotNull(hocVienList);
		assertFalse(hocVienList.isEmpty());
	}

	@Test
	public void testSelectById_ValidId() {
		int validMaHV = 1;
		hocVien = instance.selectById(validMaHV);
		assertNotNull(hocVien);
		assertEquals(validMaHV, hocVien.getMaHV());

	}

	@Test
	public void testSelectById_InvalidId() {
		int invalidMaHV = -1;
		hocVien = instance.selectById(invalidMaHV);
		assertNull(hocVien);
	}

	@Test
	public void testSelectBySqlStringObjectArray() {
		List<HocVien> hocVienList = instance.selectAll();
	    assertNotNull(hocVienList);
	}
}
