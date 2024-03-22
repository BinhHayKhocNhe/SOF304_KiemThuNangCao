package com.edusys.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.dao.NguoiHocDAO;
import com.edusys.entity.NguoiHoc;
import java.util.Date;
import java.util.List;

public class NguoiHocDAOTest {

	private NguoiHoc nguoiHoc;
	private NguoiHocDAO instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		nguoiHoc = new NguoiHoc();
		instance = new NguoiHocDAO();
	}

	@After
	public void tearDown() throws Exception {
		nguoiHoc = null;
		instance = null;
	}

	@Test
	public void testInsertNguoiHoc() {
		nguoiHoc.setMaNH("NH001");
		nguoiHoc.setHoTen("Người Học Test");
		nguoiHoc.setNgaySinh(new Date());
		nguoiHoc.setGioiTinh(true);
		nguoiHoc.setDienThoai("0123456789");
		nguoiHoc.setEmail("test@example.com");
		nguoiHoc.setGhiChu("Test GhiChu");
		nguoiHoc.setMaNV("PS01");

		try {
			instance.insert(nguoiHoc);
		} catch (Exception e) {
			fail("Unexpected exception occurred with valid data: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateNguoiHoc() {
		nguoiHoc.setMaNH("NH001");
		nguoiHoc.setHoTen("Người Học Cập Nhật");
		nguoiHoc.setNgaySinh(new Date());
		nguoiHoc.setGioiTinh(false);
		nguoiHoc.setDienThoai("0987654321");
		nguoiHoc.setEmail("updated@example.com");
		nguoiHoc.setGhiChu("Updated GhiChu");
		nguoiHoc.setMaNV("PS01");

		try {
			instance.update(nguoiHoc);
		} catch (Exception e) {
			fail("Unexpected exception occurred with valid data: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteString() {
		String validId = "NH001";
		try {
			instance.delete(validId);
		} catch (Exception e) {
			fail("Unexpected exception occurred with valid ID: " + e.getMessage());
		}
	}

	@Test
	public void testSelectAll() {
		List<NguoiHoc> result = null;
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
		String maNH = "PS12512";
		nguoiHoc = instance.selectById(maNH);
		assertNotNull(nguoiHoc);
		assertEquals(maNH, nguoiHoc.getMaNH());
	}

	@Test
	public void testSelectBySqlStringObjectArray() {
		List<NguoiHoc> result = null;
		try {
			result = instance.selectAll();
			assertNotNull(result);
			assertFalse(result.isEmpty());
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testSelectByKeyword() {
		String keyword = "NGUYỄN HOÀNG THIÊN PHƯỚC";
		List<NguoiHoc> resultList = instance.selectByKeyword(keyword);

		assertFalse(resultList.isEmpty());
		for (NguoiHoc nguoiHoc : resultList) {
			assertTrue(nguoiHoc.getHoTen().contains(keyword)); // Kiểm tra xem từ khóa có trong tên người học hay không
		}
	}
}
