package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.LoginPage;
import objects.ProfileSettings;
import objects.WebDriverCreator;

public class TestProfileSettings {

private static WebDriver driver;
	
	@BeforeClass	
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}
	
	@Test
	public void testProfile() {

		LoginPage.logInMethod(driver);
		ProfileSettings.changePic(driver);
		ProfileSettings.changeMonthlyOvertime(driver);
		ProfileSettings.privacySettingsUncheck(driver);
	}
}
