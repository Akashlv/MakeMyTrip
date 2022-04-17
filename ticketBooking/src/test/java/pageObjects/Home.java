
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.BaseClass;

public class Home extends BaseClass {

	@FindBy(xpath = "//div[@class='makeFlex googleLoginBtn flexOne paddingR10']")
	WebElement googleAccountLogIn;

	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement emailId;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	WebElement next;

	@FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
	WebElement mobileNumberPopUpClose;
	
	public void clickGoogleAccountLogIn() {
		googleAccountLogIn.click();
	}

	public void enterEmailId(String EmailId) {
		emailId.sendKeys(EmailId);
	}

	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}

	public void clickNext() {
		next.click();
	}
	
	public void closeMobileNumberPopUp() {
		mobileNumberPopUpClose.click();
	}

	public Home() {
		PageFactory.initElements(driver, this);
	}

}
