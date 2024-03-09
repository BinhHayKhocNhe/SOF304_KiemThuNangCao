package TinhChanLe;

public class ChanLe {
	public static boolean isEventNumber(int number) {
		return number % 2 == 0;
	}

	public static void main(String[] args) {
		int num = 10;
		System.out.println(isEventNumber(num) ? "Chẵn" : "Lẻ");
	}
}
