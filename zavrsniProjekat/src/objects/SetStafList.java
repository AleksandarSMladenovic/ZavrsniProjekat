package objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetStafList {

	public static final String ADD_EMP_BTN = "//*[@id=\"act_primary\"]";
	public static final String STAFF_INPUT_LIST_ID = "_asi";
	public static final String STAFF_FNAME_ID = "_asf";
	public static final String STAFF_LNAME_ID = "_asl";
	public static final String STAFF_EMAIL_ID = "_ase";
	public static final String ADD_EMPL_XPATH = "//*[@id=\"_as_save_multiple\"]";
	public static final String STAFF_BTN_XPATH = "//*[@id=\"sn_staff\"]/span";

	public static void inputExcelStaf(WebDriver driver, File data) {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.navigate().to(Home.HOME);
		AboutUs.closePopUp(driver);
		driver.findElement(By.xpath(Home.LOGIN_BTN_XPATH)).click();
		LoginPage.logIn(driver);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPage.LOGIN_TUT_WAIT_XPATH)));
		
		driver.findElement(By.xpath(MyPageHumanity.STAFF_BTN_XPATH)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MyPageHumanity.STAFF_WAIT)));
		driver.findElement(By.xpath(ADD_EMP_BTN)).click();

		
		for (int i = 0; i < 6; i++) {
			try {
				InputStream is = new FileInputStream(data);
				XSSFWorkbook wb = new XSSFWorkbook(is);
				Sheet sheet = wb.getSheetAt(0);
				Row row = sheet.getRow(i);
				if (row != null) {
					String fname = row.getCell(0).toString();
					row = sheet.getRow(i);
					String lastName = row.getCell(1).toString();
					row = sheet.getRow(i);
					String eMail = row.getCell(2).toString();
					row = sheet.getRow(i);
					int j = i + 1;
					
					driver.findElement(By.id(STAFF_FNAME_ID + (j))).sendKeys(fname);
					driver.findElement(By.id(STAFF_LNAME_ID + (j))).sendKeys(lastName);
					driver.findElement(By.id(STAFF_EMAIL_ID + (j))).sendKeys(eMail);
					
					wb.close();
				}
			} catch (IOException e) {

			}
		}
	}
}
