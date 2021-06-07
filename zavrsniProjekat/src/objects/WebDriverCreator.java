package objects;

import org.openqa.selenium.WebDriver;

public class WebDriverCreator {
		
	public static void createDriver(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
}
