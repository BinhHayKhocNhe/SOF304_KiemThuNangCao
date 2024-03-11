package Bai_2;

public class JUnitMessage {
	private String message;

	public JUnitMessage(String message) {
		this.message = message;
	}

	public String outputMessage(String message) {
		System.out.println(message);
		return message;
	}

	public String outputMessage1(String message) {
		message = "Hello " + message;
		System.out.println(message);
		return message;
	}
}
