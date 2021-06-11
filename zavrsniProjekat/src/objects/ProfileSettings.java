package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProfileSettings {
	
	public static final String OPEN_SETTINGS_XPATH = "//*[@id=\"wrap_us_menu\"]/i";
	public static final String SETTINGS_XPATH = "//*[@id=\"userm\"]/div/a[2]";
	public static final String UPLOAD_PIC_ID = "fileupload";
	public static final String PIC_PATH = "C:\\Users\\LENOVO\\eclipse-workspace\\zavrsni_projekat\\zavrsniProjekat\\ja.jpg";
	public static final String MONTHLY_OVERTIME_ID = "monthly_overtime";
	public static final String MONTHLY_OVERTIME_21_ID = "//*[@id=\"monthly_overtime\"]/option[23]";
	public static final String SUBMIT_XPATH = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[42]/td/input";
	public static final String CHECK_1_XPATH = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[10]/td[2]/input[1]";
	public static final String CHECK_2_XPATH = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[10]/td[2]/input[2]";
	
	public static void changePic(WebDriver driver) {
		
		driver.findElement(By.xpath(OPEN_SETTINGS_XPATH)).click();
		driver.findElement(By.xpath(SETTINGS_XPATH)).click();
		WebElement chooseFile = driver.findElement(By.id(UPLOAD_PIC_ID));
		chooseFile.sendKeys(PIC_PATH);
		
	}
	
	public static void changeMonthlyOvertime(WebDriver driver) {
		
		Actions actions = new Actions(driver);
		
		driver.findElement(By.id(MONTHLY_OVERTIME_ID)).click();
		driver.findElement(By.id(MONTHLY_OVERTIME_ID)).sendKeys("21");
		
		actions.moveToElement(driver.findElement(By.xpath(SUBMIT_XPATH))).click();
		actions.perform();
		

	}
	
	public static void privacySettingsUncheck(WebDriver driver) {
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath(CHECK_1_XPATH)));
		actions.perform();
		driver.findElement(By.xpath(CHECK_1_XPATH)).click();
		actions.moveToElement(driver.findElement(By.xpath(CHECK_2_XPATH)));
		actions.perform();
		driver.findElement(By.xpath(CHECK_2_XPATH)).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		actions.moveToElement(driver.findElement(By.xpath(SUBMIT_XPATH))).click();
		actions.perform();
	}
}
