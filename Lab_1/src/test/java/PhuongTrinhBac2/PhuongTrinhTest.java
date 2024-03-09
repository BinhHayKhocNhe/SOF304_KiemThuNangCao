package PhuongTrinhBac2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhuongTrinhTest {
	@Test
	public void testCheckDentaVoNghiem() {
		PhuongTrinh pt = new PhuongTrinh(1, 2, 3);
		String expected = "Phuong trinh vo nghiem";
		assertEquals(expected, pt.checkDenta());
		assertEquals(Double.NaN, pt.tinhNghiem1(), 0.0001);
        assertEquals(Double.NaN, pt.tinhNghiem2(), 0.0001); 
	}

	@Test
	public void testCheckDentaCoNghiemKep() {
		PhuongTrinh pt = new PhuongTrinh(1, 2, 1);
		String expected = "Phuong trinh co no kep";
		assertEquals(expected, pt.checkDenta());
		assertEquals(-1, pt.tinhNghiem1(), 0.0001);
        assertEquals(-1, pt.tinhNghiem2(), 0.0001);
	}

	@Test
	public void testCheckDentaCo2NghiemPhanBiet() {
		PhuongTrinh pt = new PhuongTrinh(1, -3, 2);
		String expected = "Phuong trinh co 2no phan biet";
		assertEquals(expected, pt.checkDenta());
		assertEquals(2, pt.tinhNghiem1(), 0.0001);
        assertEquals(1, pt.tinhNghiem2(), 0.0001);
	}

}
