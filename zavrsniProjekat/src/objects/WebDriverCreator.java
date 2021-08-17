package objects;

import org.openqa.selenium.WebDriver;

public class WebDriverCreator {
	
	public static final String PATH_CHROME_DRIVER = System.getProperty("user.dir") + "\\src\\drivers\\";
		
	public static void createDriver(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER + "chromedriver.exe");
	}
}
