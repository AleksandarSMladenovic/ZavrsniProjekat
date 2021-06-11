package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.DeleteUser;
import objects.LoginPage;
import objects.MyPageHumanity;
import objects.WebDriverCreator;

public class TestDeleteUser {

	private static WebDriver driver;

	@BeforeClass
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}

	@Test
	public void deleteProfile() {

		LoginPage.logInMethod(driver);

		driver.findElement(By.xpath(MyPageHumanity.STAFF_BTN_XPATH)).click();
		DeleteUser.deleteUser(driver);
		
		driver.quit();
		
	}
}
