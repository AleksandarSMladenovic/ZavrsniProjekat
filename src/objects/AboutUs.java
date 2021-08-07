package objects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class AboutUs {

	public static final String URL = "https://www.humanity.com/";
	public static final String ANNOUNCEMENT_CLOSE_XPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
	public static final String ABOUT_US_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ABOUT_US_CHOOSE_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a/p[1]";
	public static final String COOKIES_XPATH = "//*[@id=\"cf-root\"]/div/div/div/div[2]/div[2]/div[1]/button/span";
	public static final String CHAT_XPATH = "//*[@id=\"intercom-container\"]/div/div/div[2]/div/div/div[1]/div/div[1]/div/div[1]/div/div[2]/div[1]";
	public static final String CHAT_CLOSE_XPATH = "//*[@id=\"intercom-container\"]/div/iframe";
	public static final String PATH_FILES = System.getProperty("user.dir") + "\\src\\screenshot\\";
	
	public static void closePopUp(WebDriver driver) {
		
		try {
			driver.manage().window().maximize();
			driver.findElement(By.xpath(COOKIES_XPATH)).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ANNOUNCEMENT_CLOSE_XPATH)).click();
			driver.findElement(By.xpath(CHAT_XPATH));
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath(ABOUT_US_CHOOSE_XPATH)).click();
			driver.findElement(By.xpath(CHAT_CLOSE_XPATH));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void openAboutUs(WebDriver driver) {
		driver.findElement(By.xpath(ABOUT_US_XPATH)).click();
		driver.findElement(By.xpath(ABOUT_US_CHOOSE_XPATH)).click();
	}
	
	public static void scrShoot(WebDriver driver, String filename) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screenshot = new File(filename);
			try {
				FileHandler.copy(scrFile, screenshot);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
