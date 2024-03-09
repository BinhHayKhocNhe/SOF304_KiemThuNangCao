package Tinh_giaithua;

public class Bai_1 {
	public static long giaiThua(int number) {
		if (number > 1) {
			return number * giaiThua(number - 1);
		}
		return 1;
	}

	public static long plus(int num1, int num2) {
		return num1 + num2;
	}

	public static void main(String[] args) {
		System.out.println("Ket qua: " + giaiThua(5));
		System.out.println("Ket qua: " + plus(1, 5));
	}

}
