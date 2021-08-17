package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.AboutUs;
import objects.ChangeLang;
import objects.Home;
import objects.LoginPage;
import objects.WebDriverCreator;

public class TestChangeLang {

private static WebDriver driver;
	
	@BeforeClass	
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	private void changeLang() {
		WebDriverWait sacekaj = new WebDriverWait(driver, 5);
		driver.navigate().to(Home.HOME);
		AboutUs.closePopUp(driver);
		driver.findElement(By.xpath(Home.LOGIN_BTN_XPATH)).click();
		LoginPage.logIn(driver);
		driver.manage().window().maximize();
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.LOGIN_TUT_WAIT_XPATH)));
		
		driver.findElement(By.xpath(ChangeLang.SETTINGS_BTN_XPATH)).click();
		driver.findElement(By.xpath(ChangeLang.DEFAULT_LANG_XPATH)).sendKeys("s");
		driver.findElement(By.xpath(ChangeLang.DEFAULT_LANG_SER_XPATH)).click();
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ChangeLang.SAVE_SETTINGS_XPATH)));
		driver.findElement(By.xpath(ChangeLang.SAVE_SETTINGS_XPATH)).click();
	}
	
	@Test (priority = 2)
	private void uncheckAll() {
		ChangeLang.findUnCheck(driver, ChangeLang.VIA_EMAIL_CHK_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.VIA_SMS_CHK_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.VIA_MOBILE_PUSH_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.TRAINING_SETTINGS_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.CAN_VIEW_REP_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.CAN_EDIT_PROFILE_REP_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.CAN_VIEW_STAFF_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.CAN_VIEW_STAFF_CONTACT_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.CAN_VIEW_WOOS_ON_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.MESSAGE_WALL_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.STAFF_LEAVE_COMM_XPATH);
		ChangeLang.findUnCheck(driver, ChangeLang.MESSAGING_MODULE_XPATH);

	}
}
