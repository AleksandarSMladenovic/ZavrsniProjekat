package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static final String LOGIN_EMAIL_XPATH = "//*[@id=\"email\"]";
	public static final String LOGIN_PW_XPATH = "//*[@id=\"password\"]";
	public static final String LOGIN_BTN_XPATH = "//*[@id=\"LoginForm\"]/div[3]/div/button[1]";
	public static final String LOGIN_TUT_WAIT_XPATH = "//*[@id=\"_nav\"]/div[1]/img";
	public static final String LOGIN_EMAIL = "sasa@nomail.com";
	public static final String LOGIN_PASSWORD = "12sasa12";
	
	public static void logIn(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_EMAIL_XPATH)).sendKeys(LOGIN_EMAIL);
		driver.findElement(By.xpath(LOGIN_PW_XPATH)).sendKeys(LOGIN_PASSWORD);
		driver.findElement(By.xpath(LOGIN_BTN_XPATH)).click();
		
	}

	public static void logInMethod(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.navigate().to(Home.HOME);
		AboutUs.closePopUp(driver);
		driver.findElement(By.xpath(Home.LOGIN_BTN_XPATH)).click();
		
		driver.findElement(By.xpath(LOGIN_EMAIL_XPATH)).sendKeys(LOGIN_EMAIL);
		driver.findElement(By.xpath(LOGIN_PW_XPATH)).sendKeys(LOGIN_PASSWORD);
		driver.findElement(By.xpath(LOGIN_BTN_XPATH)).click();
		
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.LOGIN_TUT_WAIT_XPATH)));
	}

}
