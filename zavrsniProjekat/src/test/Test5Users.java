package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.AddUser;
import objects.SetStafList;
import objects.WebDriverCreator;

public class Test5Users {

	private static WebDriver driver;

	@BeforeClass
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}

	@Test
	public void testAdd5User() {
		File data = new File("data2.xlsx");
		SoftAssert sa = new SoftAssert();
		
		SetStafList.inputExcelStaf(driver, data);
		WebDriverWait sacekaj = new WebDriverWait(driver, 5);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SetStafList.ADD_EMPL_XPATH)));

		driver.findElement(By.xpath(SetStafList.ADD_EMPL_XPATH)).click();
		sacekaj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SetStafList.STAFF_BTN_XPATH)));
		driver.findElement(By.id(AddUser.SAVE_EMPL_BTN_ID)).click();
		
		driver.navigate().refresh();
		
		sa.assertTrue(driver.getPageSource().contains("Sasa"));
		sa.assertTrue(driver.getPageSource().contains("Zika"));
		sa.assertTrue(driver.getPageSource().contains("Branka"));
		sa.assertTrue(driver.getPageSource().contains("Marija"));
		sa.assertTrue(driver.getPageSource().contains("Ana"));
				
		sa.assertAll();
		
		driver.quit();
	}
}
