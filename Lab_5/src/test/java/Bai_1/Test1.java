package Bai_1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

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
