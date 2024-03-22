package com.edusys.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.dao.ChuyenDeDAO;
import com.edusys.entity.ChuyenDe;

public class ChuyenDeDAOTest {
	private ChuyenDeDAO instance;
	private ChuyenDe chuyenDe;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new ChuyenDeDAO();
		chuyenDe = new ChuyenDe();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		chuyenDe =null;
	}

	@Test
	public void testInsertChuyenDe() {
		chuyenDe.setMaCD("CD100");
		chuyenDe.setTenCD("Test ChuyenDe");
		chuyenDe.setHocPhi(1000000);
		chuyenDe.setThoiLuong(30);
		chuyenDe.setHinh("test.jpg");
		chuyenDe.setMoTa("Test description");

		try {
			instance.insert(chuyenDe);
		} catch (Exception e) {
			fail("Error occurred while inserting ChuyenDe: " + e.getMessage());
		}
	}

	@Test
	public void testUpdateChuyenDe() {
		chuyenDe.setMaCD("CD001");
		chuyenDe.setTenCD("Chuyên đề mới");
		chuyenDe.setHocPhi(2000000);
		chuyenDe.setThoiLuong(30);
		chuyenDe.setHinh("new_image.jpg");
		chuyenDe.setMoTa("Mô tả chuyên đề mới");

		try {
			instance.update(chuyenDe);
		} catch (Exception e) {
			fail("Unexpected exception occurred: " + e.getMessage());
		}
	}

	@Test
	public void testDeleteString() {
		chuyenDe.setMaCD("CD001");
		chuyenDe.setTenCD("Chuyên đề mới");
		chuyenDe.setHocPhi(2000000);
		chuyenDe.setThoiLuong(30); 
		chuyenDe.setHinh("new_image.jpg");
		chuyenDe.setMoTa("Mô tả chuyên đề mới");

		// Thêm ChuyenDe mới vào cơ sở dữ liệu
		instance.insert(chuyenDe);
		
		try {
			instance.delete("CD001");
	    } catch (Exception e) {
	        // Nếu phương thức delete ném ra ngoại lệ, test case sẽ thất bại
	        fail("Unexpected exception occurred: " + e.getMessage());
	    }
	}

	@Test
	public void testSelectAll() {
		List<ChuyenDe> chuyenDeList = null;
	    try {
	        chuyenDeList = instance.selectAll();
	    } catch (Exception e) {
	        fail("Unexpected exception occurred: " + e.getMessage());
	    }
	 // Kiểm tra xem danh sách chuyên đề có null không
	    assertNotNull(chuyenDeList);

	    // Kiểm tra xem danh sách chuyên đề có ít nhất một phần tử không
	    assertFalse(chuyenDeList.isEmpty());
	}

	@Test
	public void testSelectByIdString() {
		String id = "CD001";
	    chuyenDe = instance.selectById(id);
	    assertNotNull(chuyenDe);
	    assertEquals(id, chuyenDe.getMaCD());
	}

	@Test
	public void testSelectBySqlStringObjectArray() {
		List<ChuyenDe> chuyenDeList = instance.selectAll();
	    // Assert
	    assertNotNull(chuyenDeList);
	}

}
