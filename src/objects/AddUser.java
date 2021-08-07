package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUser {

	public static final String SAVE_EMPLOYEE_XPATH = "//*[@id=\"_as_save_multiple\"]";
	public static final String NEW_EM_URL = "https://firmica.humanity.com/app/staff/assignstaff&new=1&first=6365444/";
	public static final String ALL_STAFF_BTN_XPATH = "//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a";
	public static final String CHECK_MAIL_XPATH = "//*[@id=\"7\"]/a";
	public static final String EMAIL = "pericaperic@gmail.com";
	public static final String FIRST_NAME = "Pera";
	public static final String LAST_NAME = "Peric";
	public static final String CLOSE_XPATH = "//*[@id=\"StaffSchedules\"]/ul[1]/li[1]/a";
	public static final String STAFF_BTN_XPATH = "//*[@id=\"sn_staff\"]/span";
	public static final String SELECT_USER_XPATH = "//*[@id=\"staff-list-container\"]/div[2]/div[1]/div[1]/label/img";
	public static final String BULK_EDIT_BTN_XPATH = "//*[@id=\"_topnav\"]/button[2]";
	public static final String MANAGE_USER_ACC_XPATH = "//*[@id=\"manageAccount\"]/label/input";
	public static final String NEXT_STEP_BTN_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div/form/button";
	public static final String CONFIRM_BTN_XPATH = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[39]/td/input";// *[@id="NewEmployeeForm"]/table/tbody/tr[39]/td/input
	public static final String FKNG_USER_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/table/tbody/tr/td[2]/div[2]/div/table/tbody/tr[3]/td[1]";
	public static final String EMPLOYEE_SELECT_XPATH = "//*[@id=\"7\"]/a";
	public static final String EMPL_EDIT_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String EMPL_NAME_TXT_FIELD_XPATH = "//*[@id=\"first_name\"]";
	public static final String SAVE_EMPL_BTN_XPATH = "//*[@id=\"NewEmployeeForm\"]/table/tbody/tr[39]/td/input";
	public static final String UPLOAD_PIC_XPATH = "//*[@id=\"in-btn\"]";
	public static final String USER_SETTINGS_XPATH = "//*[@id=\"7\"]/a";
	public static final String USER_EDIT_XPATH = "//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]";
	public static final String USER_UPL_PIC_XPATH = "//*[@id=\"fileupload\"]";
	public static final String UPLOAD_PIC_ID = "fileupload";
	public static final String PIC_PATH = "C:\\Users\\LENOVO\\eclipse-workspace\\zavrsni_projekat\\zavrsniProjekat\\pera.jpg";
	public static final String SAVE_EMPL_BTN_ID = "_as_save_multiple";

	public static void addUser(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		LoginPage.logInMethod(driver);

		driver.findElement(By.xpath(MyPageHumanity.STAFF_BTN_XPATH)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyPageHumanity.STAFF_WAIT)));
		driver.findElement(By.id("act_primary")).click();

		driver.findElement(By.id("_asf1")).sendKeys(FIRST_NAME);
		driver.findElement(By.id("_asl1")).sendKeys(LAST_NAME);
		driver.findElement(By.id("_ase1")).sendKeys(EMAIL);
		driver.findElement(By.xpath(SAVE_EMPLOYEE_XPATH)).click();
	}

	public static void addUser(WebDriver driver, String firstName, String lastName, String email) {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		LoginPage.logInMethod(driver);

		driver.findElement(By.xpath(MyPageHumanity.STAFF_BTN_XPATH)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyPageHumanity.STAFF_WAIT)));
		driver.findElement(By.id("act_primary")).click();

		driver.findElement(By.id("_asf1")).sendKeys(firstName);
		driver.findElement(By.id("_asl1")).sendKeys(lastName);
		driver.findElement(By.id("_ase1")).sendKeys(email);
		// driver.findElement(By.xpath(AddUser.UPLOAD_PIC_XPATH)).click();

		// driver.findElement(By.xpath(SAVE_EMPLOYEE_XPATH)).click();

	}

	public static void addPic(WebDriver driver) {
		driver.findElement(By.xpath(USER_SETTINGS_XPATH)).click();
		driver.findElement(By.xpath(USER_EDIT_XPATH)).click();
		WebElement chooseFile = driver.findElement(By.id(UPLOAD_PIC_ID));
		chooseFile.sendKeys(PIC_PATH);
	}
}
