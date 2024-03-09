package PhuongTrinhBac2;

public class PhuongTrinh {
	private double a, b, c;

	public PhuongTrinh(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public PhuongTrinh() {

	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public String checkDenta() {
		if (Math.pow(b, 2) - (4 * a * c) < 0)
			return "Phuong trinh vo nghiem";
		else if (Math.pow(b, 2) - (4 * a * c) == 0)
			return "Phuong trinh co no kep";
		else
			return "Phuong trinh co 2no phan biet";
	}

	public double tinhNghiem1() {
		return (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
	}

	public double tinhNghiem2() {
		return (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
	}
}
