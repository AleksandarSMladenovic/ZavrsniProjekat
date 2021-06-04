package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.AboutUs;

public class TestAboutUs {

	private static WebDriver driver;
	
	@BeforeClass	
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testAboutUs() {
		driver.navigate().to(AboutUs.URL);
		AboutUs.closePopUp(driver);
		AboutUs.openAboutUs(driver);
		AboutUs.scrShoot(driver);	

		
	}	
}