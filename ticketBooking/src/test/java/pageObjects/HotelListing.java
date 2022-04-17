
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.BaseClass;

public class HotelListing extends BaseClass {

	WebDriverWait wait = new WebDriverWait(driver, 15);

	@FindBy(css = "#Listing_hotel_0")
	WebElement firstListedHotel;

	@FindBy(xpath = "//div[@class='priceBucketFilter']/ul/li[1]/span/label")
	WebElement firstPriceOption;

	@FindBy(xpath = "//a[normalize-space()='Clear']")
	WebElement clearAllFilters;

	public void clickFirstListedHotel() {
		wait.until(ExpectedConditions.visibilityOf(firstListedHotel));
		firstListedHotel.click();
	}

	public void clickFirstPriceOption() {
		if (!firstPriceOption.isSelected()) {
			firstPriceOption.click();
		}
	}

	public void clickLastPopularFiltersOption() {
		List<WebElement> allPopularFiltersOptions = driver.findElements(By.xpath("//span[text()='Popular with Tourists']/parent::p/following-sibling::ul//li"));
		allPopularFiltersOptions.size();
		driver.findElement(By.xpath("//span[text()='Popular with Tourists']/parent::p/following-sibling::ul//li[" + allPopularFiltersOptions.size() + "]/span/label")).click();
	}

	public void clickClearAllFilters() {
		clearAllFilters.click();
	}

	public HotelListing() {
		PageFactory.initElements(driver, this);
	}

}
