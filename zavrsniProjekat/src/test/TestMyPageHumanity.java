package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.AboutUs;
import objects.Home;
import objects.LoginPage;
import objects.MyPageHumanity;
import objects.WebDriverCreator;

public class TestMyPageHumanity {

	private static WebDriver driver;

	@BeforeClass
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}

	@Test
	public void testDash() {
		SoftAssert sa = new SoftAssert();
		WebDriverWait sacekaj = new WebDriverWait(driver, 5);
		WebDriverWait sacekajDuze = new WebDriverWait(driver, 10);
		driver.navigate().to(Home.HOME);
		AboutUs.closePopUp(driver);
		driver.findElement(By.xpath(Home.LOGIN_BTN_XPATH)).click();
		LoginPage.logIn(driver);
		driver.manage().window().maximize();
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.LOGIN_TUT_WAIT_XPATH)));

		// Dashboard button test
		driver.findElement(By.xpath(MyPageHumanity.DASHBOARD_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.DASHBOARD_URL);

		// Shift button test
		driver.findElement(By.xpath(MyPageHumanity.SHIFT_PL_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.SHIFT_PL_URL);

		// Time clock button test
		driver.findElement(By.xpath(MyPageHumanity.TIME_CLOCK_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.TIME_CLOCK_URL);

		// Leave button test
		driver.findElement(By.xpath(MyPageHumanity.LEAVE_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.LEAVE_URL);

		// Training button test
		driver.findElement(By.xpath(MyPageHumanity.TRAINING_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.TRAINING_URL);

		// Staff button test
		driver.findElement(By.xpath(MyPageHumanity.STAFF_BTN_XPATH)).click();
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyPageHumanity.STAFF_WAIT)));
		// driver.findElement(By.xpath(MyPageHumanity.ADD_STAFF_CLOSE_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.STAFF_URL);

		// Availability button test
		driver.findElement(By.xpath(MyPageHumanity.AVAILABILITY_XPATH)).click();
		sacekajDuze.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyPageHumanity.PAYROL_BTN_XPATH)));
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.AVAILABILITY_URL);

		// Payroll button test
		driver.findElement(By.xpath(MyPageHumanity.PAYROL_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.PAYROLL_URL);
		// Payroll button test
		driver.findElement(By.xpath(MyPageHumanity.REPORTS_BTN_XPATH)).click();
		sa.assertEquals(driver.getCurrentUrl().toString(), MyPageHumanity.REPORTS_URL);

		sa.assertAll();
		driver.quit();
	}

}
