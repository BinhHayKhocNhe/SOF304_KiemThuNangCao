package MayTinh;

import static org.junit.Assert.*;

import org.junit.Test;

public class MayTinhTest {
	MayTinh mt = new MayTinh();

	@Test
	public void testCong() {
		int a = 5, b = 10;
		int actual = mt.Cong(a, b);
		int expectation = 15;
		assertEquals(expectation, actual);
	}

	@Test
	public void testTru() {
		int a = 5, b = 10;
		int actual = mt.Tru(a, b);
		int expectation = -5;
		assertEquals(expectation, actual);
	}

	@Test
	public void testNhan() {
		int a = 5, b = 10;
		int actual = mt.Nhan(a, b);
		int expectation = 50;
		assertEquals(expectation, actual);
	}

	@Test
	public void testChia() {
		int a = 10, b = 5;
		int actual = mt.Chia(a, b);
		int expectation = 2;
		assertEquals(expectation, actual);
	}

	@Test
	public void testLuyThua() {
		int a = 7, b = 2;
		int actual = mt.LuyThua(a, b);
		int expectation = 49;
		assertEquals(expectation, actual);
	}

	@Test
	public void testCanBac2() {
		double a = 49;
		double actual = mt.CanBac2(a);
		double expectation = 7;
		double delta = 0.0001; // Đặt sai số cho phép
		assertEquals(expectation, actual, delta);
	}
}
