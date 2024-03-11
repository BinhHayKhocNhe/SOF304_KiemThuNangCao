package Tinh_giaithua;

public class MathFunc {

	static int calls = 0;

	public int getCalls() {
		return calls;
	}

	public static long giaiThua(int number) {
		calls++;
		if (number > 1) {
			return number * giaiThua(number - 1);
		}
		return 1;
	}

	public static long plus(int num1, int num2) {
		calls++;
		return num1 + num2;
	}

	public static void main(String[] args) {
		System.out.println("Ket qua: " + giaiThua(5));
		System.out.println("Ket qua: " + plus(1, 5));
	}

}
