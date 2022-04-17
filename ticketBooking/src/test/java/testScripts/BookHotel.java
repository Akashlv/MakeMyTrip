
package testScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

import pageObjects.HotelListing;
import pageObjects.Hotels;
import utility.BaseClass;
import utility.ExcelUtility;

public class BookHotel extends BaseClass {

	@Test
	public void logIn() throws InterruptedException, AWTException, IOException {

		Hotels hotelPage = new Hotels();
		HotelListing hotelListingPage = new HotelListing();
		ExcelUtility execlUtility = new ExcelUtility();
		
		int numberOfAdults = Float.valueOf(execlUtility.getCellValue(1, 1, 0)).intValue();
		int numberOfChildren = Float.valueOf(execlUtility.getCellValue(1, 1, 1)).intValue();
		String ageOfChild = Integer.toString(Float.valueOf(execlUtility.getCellValue(1, 1, 2)).intValue());

		hotelPage.closLogInPopUpIfPresent();
		System.out.println("1. Clicking on Hotels section");
		hotelPage.clickHotels();

		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 7);
		String checkInDate = formatter.format(cal.getTime());
		System.out.println("Hotel Check in day is 7th Day from Today i.e " + checkInDate);
		cal.add(Calendar.DATE, 1);

		String checkOutDate = formatter.format(cal.getTime());
		System.out.println("Hotel Check out day is 8th Day from Today i.e " + checkOutDate);

		hotelPage.clickCheckIn();
		System.out.println("2. Selecting CheckIn Date");
		hotelPage.selectDate(checkInDate);
		System.out.println("3. Selecting CheckOut Date");
		hotelPage.selectDate(checkOutDate);

		hotelPage.clickGuests();
		System.out.println("4. Selecting Number Of Adults");
		hotelPage.chooseAdults(numberOfAdults);
		System.out.println("5. Selecting Number Of Children");
		hotelPage.chooseNumberOfChilder(numberOfChildren);
		System.out.println("6. Selecting Age of Child");
		hotelPage.selectAgeOfChildren(ageOfChild);
		System.out.println("7. Clicking Apply button in Guests Page");
		hotelPage.clickApplyButtonInGuests();
		System.out.println("8. Selecting City as Banglore");
		hotelPage.selectFirstCityOpition("Banglore");

		System.out.println("9. Searching the Hotels");
		hotelPage.clickSeatch();

		System.out.println("10. Selecting the First Listed Hotel");
		hotelListingPage.clickFirstListedHotel();

		System.out.println("11. Selecting the First PriceList Option");
		hotelListingPage.clickFirstPriceOption();

		System.out.println("12. Swictching Back to Previous Window");
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);

		System.out.println("13. Clearing all the Applied Filters");
		hotelListingPage.clickClearAllFilters();

		System.out.println("14. Selecting the Last PriceList Option");
		hotelListingPage.clickLastPopularFiltersOption();

		System.out.println("15. Selecting the First PriceList Option");
		hotelListingPage.clickFirstListedHotel();

	}
}
