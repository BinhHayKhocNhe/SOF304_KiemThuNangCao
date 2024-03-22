package com.edusys.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.entity.NguoiHoc;

public class NguoiHocTest {
	private NguoiHoc instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new NguoiHoc();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testGetMaNH() {
		try {
			// Khởi tạo giá trị maNH là null
			String maNH = null;

			// Set giá trị maNH cho instance
			instance.setMaNH(maNH);

			// Kiểm tra rằng phương thức getMaNH() sẽ ném ra NullPointerException
			assertThrows(NullPointerException.class, () -> {
				instance.getMaNH();
			});
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSetMaNH() {
		try {
			String maNH = "";
			instance.setMaNH(maNH);
			assertNull(instance.getMaNH());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetHoTen() {
		try {
			String hoTen = null;
			instance.setHoTen(hoTen);
			assertThrows(NullPointerException.class, () -> {
				instance.getHoTen();
			});
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSetHoTen() {
		try {
			String hoTen = "Hyn Nhi";
			instance.setHoTen(hoTen);
			assertNotNull(instance.getHoTen());
			assertEquals(hoTen, instance.getHoTen());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetNgaySinh() {
		try {
			Date ngaySinh = null;
			instance.setNgaySinh(ngaySinh);
			assertThrows(NullPointerException.class, () -> {
				instance.getNgaySinh();
			});
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSetNgaySinh() {
		try {
			Date ngaySinh = new Date();
			instance.setNgaySinh(ngaySinh);
			assertNotNull(instance.getNgaySinh());
			assertEquals(ngaySinh, instance.getNgaySinh());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testGetGioiTinh() {
		// Khởi tạo giá trị gioiTinh
		boolean gioiTinh = "Nam" != null;

		// Set giá trị gioiTinh cho instance
		instance.setGioiTinh(gioiTinh);

		// Kiểm tra rằng phương thức getGioiTinh() trả về giá trị đã set
		assertEquals(gioiTinh, instance.getGioiTinh());
	}

	@Test
	public void testSetGioiTinh() {
		// Khởi tạo giá trị gioiTinh
		boolean gioiTinh = "Nữ" != null;

		// Set giá trị gioiTinh
		instance.setGioiTinh(gioiTinh);

		// Kiểm tra rằng giá trị gioiTinh đã được set
		assertSame(gioiTinh, instance.getGioiTinh());
	}

	@Test
	public void testGetDienThoai() {
		String dienThoai = "0386706328";
		instance.setDienThoai(dienThoai);
		assertEquals(dienThoai, instance.getDienThoai());
	}

	@Test
	public void testSetDienThoai() {
		String dienThoaiBanDau = instance.getDienThoai();
		String dienThoaiMoi = "0987654321";
		instance.setDienThoai(dienThoaiMoi);
		assertNotEquals(dienThoaiBanDau, instance.getDienThoai());
		assertEquals(dienThoaiMoi, instance.getDienThoai());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDienThoai_Null() {
		String dienThoai = null;
		instance.setDienThoai(dienThoai);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDienThoai_Empty() {
		String dienThoai = "";
		instance.setDienThoai(dienThoai);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetDienThoai_ExceedMaxLength() {
		String dienThoai = "01234567891";
		instance.setDienThoai(dienThoai);
	}

	@Test
	public void testGetEmail() {
		String email = "example@example.com";
		instance.setEmail(email);
		assertEquals(email, instance.getEmail());
	}

	@Test
	public void testSetEmail() {
		String emailBanDau = instance.getEmail();
		String emailMoi = "new@example.com";
		instance.setEmail(emailMoi);
		assertNotEquals(emailBanDau, instance.getEmail());
		assertEquals(emailMoi, instance.getEmail());
		// Test null email
		try {
			instance.setEmail(null);
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals(emailMoi, instance.getEmail()); // Make sure email is not changed
		}
		// Test empty email
		try {
			instance.setEmail("");
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals(emailMoi, instance.getEmail()); // Make sure email is not changed
		}
		// Test invalid email format
		try {
			instance.setEmail("invalid_email");
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals(emailMoi, instance.getEmail()); // Make sure email is not changed
		}
	}

	@Test
	public void testGetGhiChu() {
		String ghiChu = "Ghi chú người học";
		instance.setGhiChu(ghiChu);
		assertEquals(ghiChu, instance.getGhiChu());
	}

	@Test
	public void testSetGhiChu() {
		String ghiChuBanDau = instance.getGhiChu();
		String ghiChuMoi = "Ghi chú mới";
		instance.setGhiChu(ghiChuMoi);
		assertNotEquals(ghiChuBanDau, instance.getGhiChu());
		assertEquals(ghiChuMoi, instance.getGhiChu());
	}

	@Test
	public void testGetMaNV() {
		String maNV = "NV001";
		instance.setMaNV(maNV);
		assertEquals(maNV, instance.getMaNV());
	}

	@Test
	public void testSetMaNV() {
		// Test valid MaNV
		String maNVBanDau = instance.getMaNV();
		String maNVMoi = "NV002";
		instance.setMaNV(maNVMoi);
		assertNotEquals(maNVBanDau, instance.getMaNV());
		assertEquals(maNVMoi, instance.getMaNV());
		// Test null MaNV
		try {
			instance.setMaNV(null);
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals(maNVMoi, instance.getMaNV()); // Make sure MaNV is not changed
		}
		// Test empty MaNV
		try {
			instance.setMaNV("");
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertEquals(maNVMoi, instance.getMaNV()); // Make sure MaNV is not changed
		}
	}

	@Test
	public void testSetNgayDK() {
		// Test null NgayDK
		try {
			instance.setNgayDK(null);
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertNull(instance.getNgayDK()); // Make sure NgayDK is not set
		}

		// Test empty NgayDK
		try {
			instance.setNgayDK(new Date());
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertNull(instance.getNgayDK()); // Make sure NgayDK is not set
		}

		// Set a valid NgaySinh
		LocalDate ngaySinh = LocalDate.of(2004, 9, 12);
		Date ngaySinhDate = Date.from(ngaySinh.atStartOfDay(ZoneId.systemDefault()).toInstant());
		instance.setNgaySinh(ngaySinhDate);

		// Test invalid NgayDK (less than NgaySinh + 6 years)
		try {
			LocalDate ngayDKKhongHopLe = ngaySinh.plusYears(5); // NgayDK < NgaySinh + 6 years
			Date ngayDKKhongHopLeDate = Date.from(ngayDKKhongHopLe.atStartOfDay(ZoneId.systemDefault()).toInstant());
			instance.setNgayDK(ngayDKKhongHopLeDate);
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
			assertNull(instance.getNgayDK()); // Make sure NgayDK is not set
		}

		// Test valid NgayDK (greater than NgaySinh + 6 years)
		LocalDate ngayDKHopLe = ngaySinh.plusYears(7); // NgayDK > NgaySinh + 6 years
		Date ngayDKHopLeDate = Date.from(ngayDKHopLe.atStartOfDay(ZoneId.systemDefault()).toInstant());
		instance.setNgayDK(ngayDKHopLeDate);
		assertNotNull(instance.getNgayDK());
		assertEquals(ngayDKHopLeDate, instance.getNgayDK());
	}

	@Test
	public void testToString() {
		// Test when all fields are null or empty
		String expectedString = "NguoiHoc{hoTen='', ngaySinh=null, ngayDK=null}";
		assertEquals(expectedString, instance.toString());

		// Set values for the instance
		instance.setHoTen("Hyn Nhi");
		instance.setNgaySinh(Date.from(LocalDate.of(2004, 9, 12).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		instance.setNgayDK(Date.from(LocalDate.of(2023, 10, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		// Test when all fields are filled
		String expectedString1 = "NguoiHoc{hoTen='Hyn Nhi', ngaySinh=Sep 12 2004, ngayDK=Oct 03 2023}";
		assertEquals(expectedString1, instance.toString());

		// Test when some fields are null or empty
		instance.setHoTen("");
		instance.setNgaySinh(null);
		instance.setNgayDK(null);
		expectedString1 = "NguoiHoc{hoTen='', ngaySinh=null, ngayDK=null}";
		assertEquals(expectedString1, instance.toString());
	}
}
