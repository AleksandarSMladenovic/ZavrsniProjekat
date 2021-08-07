package test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
		AboutUs.scrShoot(driver, AboutUs.PATH_FILES + "aboutUs.jpg");
		File tempFile = new File(AboutUs.PATH_FILES + "aboutUs.jpg");
		Assert.assertTrue(tempFile.exists());
	}
	
	@AfterClass
	public void closeAll() {
		driver.quit();
	}
}