package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.AboutUs;
import objects.WebDriverCreator;

public class TestAboutUs {

	private static WebDriver driver;
	
	@BeforeClass	
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
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