package com.edusys.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.edusys.dao.NhanVienDAO;
import com.edusys.entity.NhanVien;

public class NhanVienDAOTest {
	private NhanVien nhanVien;
	private NhanVienDAO instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		nhanVien = new NhanVien();
		instance = new NhanVienDAO();
	}

	@After
	public void tearDown() throws Exception {
		nhanVien = null;
		instance = null;
	}

	@Test
	public void testInsertNhanVien() {
		nhanVien.setMaNV("NV001");
		nhanVien.setMatKhau("password123");
		nhanVien.setHoTen("Bình");
		nhanVien.setVaiTro(true);
		try {
			instance.insert(nhanVien);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateNhanVien() {
		nhanVien.setMaNV("NV001");
		nhanVien.setMatKhau("12345678");
		nhanVien.setHoTen("Minh Bình");
		nhanVien.setVaiTro(false);

		try {
			instance.update(nhanVien);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteString() {
		String maNV = "NV001";
		try {
			instance.delete(maNV);
		} catch (Exception e) {
			fail("Unexpected SQLException occurred: " + e.getMessage());
		}
	}

	public void testSelectAll() {
		List<NhanVien> result = null;
		try {
			result = instance.selectAll();
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	public void testSelectByIdString() {
		String maNV = "LongNDH";
		try {
			nhanVien = instance.selectById(maNV);
			assertNotNull(nhanVien);
			assertEquals(maNV, nhanVien.getMaNV());
		} catch (Exception e) {
			fail("Unexpected exception occurred with invalid MaKH: " + e.getMessage());
		}
	}

	@Test
	public void testSelectBySqlStringObjectArray() {
		try {
			List<NhanVien> result = instance.selectAll();
			assertNotNull(result);
			assertFalse(result.isEmpty());
		} catch (Exception e) {
			fail("Unexpected exception occurred with valid MaCD: " + e.getMessage());
		}
	}

}
