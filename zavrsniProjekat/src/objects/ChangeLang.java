package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeLang {

	public static final String SETTINGS_BTN_XPATH = "//*[@id=\"sn_admin\"]";
	public static final String DEFAULT_LANG_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select";
	public static final String DEFAULT_LANG_SER_XPATH = "//*[@id=\"adminSettingsForm\"]/div[1]/table/tbody/tr[3]/td[2]/select/option[37]";
	public static final String SAVE_SETTINGS_XPATH = "//*[@id=\"act_primary\"]";
	public static final String VIA_EMAIL_CHK_XPATH = "//*[@id=\"pref_pref_email\"]";
	public static final String VIA_SMS_CHK_XPATH = "//*[@id=\"pref_pref_sms\"]";
	public static final String VIA_MOBILE_PUSH_XPATH = "//*[@id=\"pref_pref_mobile_push\"]";
	public static final String TRAINING_SETTINGS_XPATH = "//*[@id=\"pref_pref_training\"]";
	public static final String CAN_VIEW_REP_XPATH = "//*[@id=\"pref_pref_reports\"]";
	public static final String CAN_EDIT_PROFILE_REP_XPATH = "//*[@id=\"pref_pref_edit_profile\"]";
	public static final String CAN_VIEW_STAFF_XPATH = "//*[@id=\"pref_pref_visible_staff\"]";
	public static final String CAN_VIEW_STAFF_CONTACT_XPATH = "//*[@id=\"pref_pref_visible_staff_details\"]";
	public static final String CAN_VIEW_WOOS_ON_XPATH = "//*[@id=\"pref_pref_on_now\"]";
	public static final String MESSAGE_WALL_XPATH = "//*[@id=\"pref_pref_message_wall_on\"]";
	public static final String STAFF_LEAVE_COMM_XPATH = "//*[@id=\"pref_pref_message_wall_comments\"]";
	public static final String MESSAGING_MODULE_XPATH = "//*[@id=\"pref_pref_messaging_module\"]";
	
	public static void findUnCheck(WebDriver driver, String string) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath(string));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		if (driver.findElement(By.xpath(string)).isSelected()) {
			driver.findElement(By.xpath(string)).sendKeys(Keys.SPACE);

			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(string)));
		}
	}
}
