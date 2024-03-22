package com.edusys.test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.edusys.entity.ChuyenDe;

public class ChuyenDeTest {

	private ChuyenDe instance;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		instance = new ChuyenDe();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test
	public void testToString() {
		instance.setMaCD("CD001");
		instance.setTenCD("Kiểm thử nâng cao");
		instance.setHocPhi(1000.0);
		instance.setThoiLuong(20);
		instance.setHinh("INMA.jpg");
		instance.setMoTa("Chuyên đề về kiểm thử nâng cao");
		String expectedToString = "Kiểm thử nâng cao";
		assertEquals(expectedToString, instance.toString());
	}

	@Test(expected = StackOverflowError.class)
	public void testEquals_StackOverflowError() {
		instance.equals(instance);
	}

	@Test
	public void testGetMaCD() {

		instance.setMaCD("JAV05");
		String expectedMaCD = "JAV05";
		assertEquals(expectedMaCD, instance.getMaCD());

		// Kiểm tra ngoại lệ null
		instance.setMaCD(null);
		try {
			instance.getMaCD();
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
		}

		// Kiểm tra ngoại lệ rỗng
		instance.setMaCD("");
		try {
			instance.getMaCD();
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}

		// Kiểm tra ngoại lệ kiểu dữ liệu khác
		instance.setMaCD("123");
		try {
			instance.getMaCD();
			fail("Expected CustomException");
		} catch (Exception e) {
		}

	}

	@Test
	public void testSetMaCD() {
		// Kiểm tra thiết lập maCD hợp lệ
		String validMaCD = "JAV05";
		instance.setMaCD(validMaCD);
		assertEquals(validMaCD, instance.getMaCD());

		// Kiểm tra thiết lập maCD null
		String nullMaCD = null;
		instance.setMaCD(nullMaCD);
		assertNull(instance.getMaCD());

		// Kiểm tra thiết lập maCD rỗng
		String emptyMaCD = "";
		instance.setMaCD(emptyMaCD);
		assertEquals(emptyMaCD, instance.getMaCD());

		// Kiểm tra thiết lập maCD với kiểu dữ liệu khác
		String invalidMaCD = "123";
		try {
			instance.setMaCD(invalidMaCD);
			fail("Expected CustomException");
		} catch (Exception e) {
			// Ngoại lệ được ném khi đặt maCD với kiểu dữ liệu không hợp lệ
		}
	}

	@Test
	public void testGetTenCD() {

		instance.setTenCD(null);
		try {
			instance.getTenCD();
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {
		}

		instance.setTenCD("");
		try {
			instance.getTenCD();
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}

		instance.setTenCD("123");
		try {
			instance.getTenCD();
			fail("Expected CustomException");
		} catch (Exception e) {

		}
	}

	@Test
	public void testSetTenCD() {

		try {
			instance.setTenCD(null);
			fail("Expected NullPointerException");
		} catch (NullPointerException e) {

		}

		try {
			instance.setTenCD("");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}

		try {
			instance.setTenCD("123");
			fail("Expected CustomException");
		} catch (Exception e) {

		}
	}

	@Test(expected = NullPointerException.class)
	public void testGetHocPhi_Null() {
		instance.getHocPhi();
	}

	@Test
	public void testGetHocPhi_Empty() {
		instance.setHocPhi(0); // Đặt trường HocPhi thành giá trị 0.0
		assertEquals(0, instance.getHocPhi(), 0.0);
	}

	@Test
	public void testGetHocPhi_InvalidDataType() {
		instance.setHocPhi(10); // Đặt trường HocPhi thành một kiểu dữ liệu khác (ở đây là số nguyên)
		assertEquals(10.0, instance.getHocPhi(), 0.0);
	}

	@Test
	public void testGetHocPhi_LessThanOrEqualZero() {
		instance.setHocPhi(-100.0); // Đặt trường HocPhi thành một số nhỏ hơn hoặc bằng 0
		assertEquals(-100.0, instance.getHocPhi(), 0.0);
	}

	@Test(expected = NullPointerException.class)
	public void testSetHocPhi_Null() {
		instance.setHocPhi((Double) null); // Đặt trường HocPhi thành null
	}

	@Test
	public void testSetHocPhi_InvalidDataType() {
		instance.setHocPhi(10); // Đặt trường HocPhi thành một kiểu dữ liệu khác (ở đây là số nguyên)
		assertEquals(10.0, instance.getHocPhi(), 0.0);
	}

	@Test
	public void testSetHocPhi_LessThanOrEqualZero() {
		instance.setHocPhi(-100.0); // Đặt trường HocPhi thành một số nhỏ hơn hoặc bằng 0
		assertEquals(-100.0, instance.getHocPhi(), 0.0);
	}

	@Test(expected = NullPointerException.class)
	public void testGetThoiLuong_Null() {
		instance.getThoiLuong();
	}

	@Test
	public void testGetThoiLuong_ValidValue() {
		instance.setThoiLuong(60); // Đặt trường ThoiLuong thành giá trị hợp lệ (ở đây là số nguyên)
		assertEquals(60, instance.getThoiLuong());
	}

	@Test
	public void testSetThoiLuong_ValidValue() {
		instance.setThoiLuong(90); // Đặt trường ThoiLuong thành giá trị hợp lệ (ở đây là số nguyên)
		assertEquals(90, instance.getThoiLuong());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetThoiLuong_InvalidValue() {
		instance.setThoiLuong(-10); // Đặt trường ThoiLuong thành giá trị không hợp lệ (ở đây là số nguyên âm)
	}

	@Test(expected = NullPointerException.class)
	public void testGetHinh_Null() {
		instance.getHinh();
	}

	@Test
	public void testGetHinh_ValidValue() {
		instance.setHinh("INMA.jpg"); // Đặt trường Hinh thành đường dẫn hợp lệ cho hình ảnh
		assertEquals("INMA.jpg", instance.getHinh());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHinh_Null() {
		instance.setHinh(null); // Đặt trường Hinh thành null
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHinh_InvalidImageFormat() {
		instance.setHinh("INMA.txt"); // Đặt trường Hinh thành đường dẫn không hợp lệ cho hình ảnh (định dạng không
										// phải là hình ảnh)
	}

	@Test
	public void testSetHinh_ValidValue() {
		instance.setHinh("INMA.jpg"); // Đặt trường Hinh thành đường dẫn hợp lệ cho hình ảnh
		assertEquals("INMA.jpg", instance.getHinh());
	}

	@Test
	public void testSetHinh_GetImageSize() {
		String imagePath = "INMA.jpg";
		instance.setHinh(imagePath);

		try {
			File file = new File(imagePath);
			long fileSize = file.length();
			long fileSizeInKB = fileSize / 1024; // Chuyển kích thước sang đơn vị KB

			assertTrue("Image size should be less than or equal to 100KB", fileSizeInKB <= 100);

			BufferedImage image = ImageIO.read(file);
			int expectedWidth = image.getWidth();
			int expectedHeight = image.getHeight();

			assertEquals(expectedWidth, instance.getHinh());
			assertEquals(expectedHeight, instance.getHinh());
		} catch (IOException e) {
			fail("Sai định dạng hay kích thước dữ liệu ảnh: " + e.getMessage());
		}
	}

	@Test
	public void testGetMoTa_Null() {
		instance.setMoTa(null);
		assertNull(instance.getMoTa());
	}

	@Test
	public void testGetMoTa_NotNull() {
		String mota = "Chuyên đề về kiểm thử nâng cao";
		instance.setMoTa(mota);
		assertEquals(mota, instance.getMoTa());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMoTa_Null() {
		instance.setMoTa(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetMoTa_Empty() {
		instance.setMoTa("");
	}

	@Test
	public void testSetMoTa_ValidValue() {
		String mota = "Chuyên đề về kiểm thử nâng cao";
		instance.setMoTa(mota);
		assertEquals(mota, instance.getMoTa());
	}

}
