
package testScripts;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import pageObjects.Home;
import utility.BaseClass;
import utility.ExcelUtility;

public class Login extends BaseClass {

	@Test
	public void logIn() throws InterruptedException, AWTException, IOException {

		Home homePage = new Home();
		ExcelUtility execlUtility = new ExcelUtility();
		
		homePage.clickGoogleAccountLogIn();
		
		String emailId = execlUtility.getCellValue(0, 1, 0);
		String password = execlUtility.getCellValue(0, 1, 1);

		Set<String> s = driver.getWindowHandles();
		String subWindowHandler = null;

		Iterator<String> iterator = s.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);

		homePage.enterEmailId(emailId);
		homePage.clickNext();
		homePage.enterPassword(password);
		homePage.clickNext();
		homePage.closeMobileNumberPopUp();

	}
}
