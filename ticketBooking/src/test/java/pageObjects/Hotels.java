
package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class Hotels extends BaseClass {
	
	WebDriverWait wait = new WebDriverWait(driver, 15);

	@FindBy(xpath = "//li[@data-cy='menu_Hotels']")
	WebElement Hotels;

	@FindBy(xpath = "//input[@id='guest']")
	WebElement Guests;

	@FindBy(xpath = "//select[@class='ageSelectBox']")
	WebElement ageSelectBox;

	@FindBy(xpath = "//button[normalize-space()='APPLY']")
	WebElement applyGuests;

	@FindBy(xpath = "//button[@id='hsw_search_button']")
	WebElement searchButton;

	@FindBy(xpath = "//p[contains(@data-cy,'checkInDate')]")
	WebElement checkIn;

	@FindBy(xpath = "//div[contains(@class,'makeFlex column defaultCursor')]")
	WebElement logInPopUp;

	@FindBy(xpath = "//div[@class='loginModal displayBlock modalLogin dynHeight personal']")
	WebElement logInOrCreateAccount;

	@FindBy(xpath = "//label[@for='city']")
	WebElement City;

	@FindBy(xpath = "//input[@placeholder='Enter city/ Hotel/ Area/ Building']")
	WebElement insertCity;

	@FindBy(xpath = "//p[normalize-space()='Bangalore, Karnataka, India']")
	WebElement bangloreCity;

	@FindBy(xpath = "//li[@id='react-autowhatever-1-section-0-item-0']")
	WebElement firstOptionOfCity;
	
	public void clickHotels() {
		Hotels.click();
	}

	public void clickGuests() {
		Guests.click();
	}

	public void clickSeatch() {
		searchButton.click();
	}

	public void clickApplyButtonInGuests() {
		applyGuests.click();
	}

	public void clickCheckIn() {
		checkIn.click();
	}

	public void chooseAdults(int adultAge) {
		driver.findElement(By.xpath("//ul[@data-cy='adultCount']//li[" + adultAge + "]")).click();
	}

	public void chooseNumberOfChilder(int numberOfChildern) {
		numberOfChildern = numberOfChildern+1;
		driver.findElement(By.xpath("//p[@data-cy='childrenRange']//following-sibling::ul[1]//li[" + numberOfChildern + "]")).click();
	}

	public void selectAgeOfChildren(String age) {
		Select s = new Select(ageSelectBox);
		s.selectByVisibleText(age);
	}

	public void selectDate(String date) {
		driver.findElement(By.xpath("//div[@aria-label='" + date + "']")).click();
	}

	public void closLogInPopUpIfPresent() {
		if (logInPopUp.isEnabled()) {
			logInOrCreateAccount.click();
		}
	}

	public void selectFirstCityOpition(String city) {
		wait.until(ExpectedConditions.elementToBeClickable(City));
		City.click();
		wait.until(ExpectedConditions.elementToBeClickable(insertCity));
		insertCity.sendKeys(city);
		wait.until(ExpectedConditions.visibilityOf(bangloreCity));
		firstOptionOfCity.click();
	}

	public Hotels() {
		PageFactory.initElements(driver, this);
	}

}
