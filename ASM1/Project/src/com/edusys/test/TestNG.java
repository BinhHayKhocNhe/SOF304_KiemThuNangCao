package com.edusys.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.edusys.dao.ChuyenDeDAO;
import com.edusys.dao.NguoiHocDAO;
import com.edusys.dao.NhanVienDAO;
import com.edusys.entity.ChuyenDe;
import com.edusys.entity.NguoiHoc;
import com.edusys.entity.NhanVien;

public class TestNG {

	@Test
	public void TestNhanVien() {
		NhanVien nhanVien = new NhanVien();
		NhanVienDAO instance = new NhanVienDAO();

		// Set up test data
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
	public void testInsertNguoiHoc() {
		NguoiHoc nguoiHoc = new NguoiHoc();
		NguoiHocDAO instance = new NguoiHocDAO();
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
    public void testSelectAll() {
        ChuyenDeDAO instance = new ChuyenDeDAO();
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
}
