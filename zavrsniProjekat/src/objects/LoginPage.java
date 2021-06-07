package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static final String LOGIN_EMAIL_XPATH = "//*[@id=\"email\"]";
	public static final String LOGIN_PW_XPATH = "//*[@id=\"password\"]";
	public static final String LOGIN_BTN_XPATH = "//*[@id=\"LoginForm\"]/div[3]/div/button[1]";
	public static final String LOGIN_TUT_WAIT_XPATH = "//*[@id=\"_nav\"]/div[1]/img";
	
	public static void logIn(WebDriver driver) {
		driver.findElement(By.xpath(LOGIN_EMAIL_XPATH)).sendKeys("sasa@robot.com");
		driver.findElement(By.xpath(LOGIN_PW_XPATH)).sendKeys("12sasa12");
		driver.findElement(By.xpath(LOGIN_BTN_XPATH)).click();
	}


}
