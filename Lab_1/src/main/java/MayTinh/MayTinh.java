package MayTinh;

import java.util.Iterator;

public class MayTinh {
	public int Cong(int a, int b) {
		return a + b;
	}

	public int Tru(int a, int b) {
		return a - b;
	}

	public int Nhan(int a, int b) {
		return a * b;
	}

	public int Chia(int a, int b) {
		return a / b;
	}

	public int LuyThua(int a, int b) {
//		int result = 1;
//		for (int i = 1; i <= b; i++) {
//			result *= a;
//		}
//		return result;
		return (int) Math.pow(a, b);
	}

	public double CanBac2(double a) {
		return Math.sqrt(a);
	}
}
