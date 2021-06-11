package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objects.AddUser;
import objects.WebDriverCreator;

public class TestAddUser {

	private static WebDriver driver;

	@BeforeClass
	public void crtDriver() {
		WebDriverCreator.createDriver(driver);
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testAddUser() {
		AddUser.addUser(driver);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AddUser.FKNG_USER_XPATH)));

		driver.findElement(By.xpath(AddUser.STAFF_BTN_XPATH)).click();
		Assert.assertTrue(driver.getPageSource().contains(AddUser.FIRST_NAME), "Nema ga");
	}
	
	@Test(priority = 2)
	public void testChangeName() {
		
		driver.findElement(By.xpath(AddUser.EMPLOYEE_SELECT_XPATH)).click();
		driver.findElement(By.xpath(AddUser.EMPL_EDIT_XPATH)).click();
		
		driver.findElement(By.xpath(AddUser.EMPL_NAME_TXT_FIELD_XPATH)).clear();
		driver.findElement(By.xpath(AddUser.EMPL_NAME_TXT_FIELD_XPATH)).sendKeys("Perica");
		driver.findElement(By.xpath(AddUser.EMPL_NAME_TXT_FIELD_XPATH)).sendKeys(Keys.ENTER);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(AddUser.CONFIRM_BTN_XPATH)).click();

		driver.findElement(By.xpath(AddUser.STAFF_BTN_XPATH)).click();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		Assert.assertTrue(driver.getPageSource().contains("pericaperic@gmail.com"));
		
	}
	
	@Test(priority = 3)
	public void addPic() {

		AddUser.addPic(driver);
		
	
	}
}
