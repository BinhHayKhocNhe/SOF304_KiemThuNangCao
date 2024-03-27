package Bai_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test2 {
	@Test
	public void veryfiTitlePage() {
		System.getProperty("webdriver.chrome.driver", "D:\\Kiem_Thu_Nang_Cao\\Bai_Lab\\Lab_5\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://lms.poly.edu.vn/";
		String tilteWeb = "FPT Polytechnic";
		String expected = "FPT Polytechnic";
		driver.get(url);

		expected = driver.getTitle();
		if (expected.contentEquals(tilteWeb)) {
			System.out.println("Test pass !");
			return;
		}
		System.out.println("Test fail !");
		driver.close();
	}
}
