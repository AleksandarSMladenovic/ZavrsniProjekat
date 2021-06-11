package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.AboutUs;
import objects.Home;
import objects.LoginPage;
import objects.WebDriverCreator;

public class TestLogIn {

private static WebDriver driver;
	
	@BeforeClass	
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}
	
	@Test
	private void logIn() {
		WebDriverWait sacekaj = new WebDriverWait(driver, 5);
		driver.navigate().to(Home.HOME);
		AboutUs.closePopUp(driver);
		driver.findElement(By.xpath(Home.LOGIN_BTN_XPATH)).click();
		LoginPage.logIn(driver);
		driver.manage().window().maximize();
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.LOGIN_TUT_WAIT_XPATH)));
		
		String actualRs = driver.getCurrentUrl().toString();
		String expectedRs = "https://firmica.humanity.com/app/dashboard/";
		
		Assert.assertEquals(actualRs, expectedRs);
		
		driver.quit();

	}
}
