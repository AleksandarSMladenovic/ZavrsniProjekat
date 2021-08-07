package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteUser {

	public static void deleteUser(WebDriver driver) {

		driver.findElement(By.xpath(AddUser.SELECT_USER_XPATH)).click();
		driver.findElement(By.xpath(AddUser.BULK_EDIT_BTN_XPATH)).click();
		driver.findElement(By.xpath(AddUser.MANAGE_USER_ACC_XPATH)).click();
		driver.findElement(By.xpath(AddUser.NEXT_STEP_BTN_XPATH)).click();
		driver.findElement(By.xpath(AddUser.CONFIRM_BTN_XPATH)).click();
		driver.switchTo().alert().accept();

	}
}
