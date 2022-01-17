package admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class GeographyZipPostalCode extends BaseInit {

	@Test
	public void geographyZipPostalCode() throws InterruptedException, IOException {
		System.out.println("--------------Testing Zip/PostalCode---------------");
		logs.info("--------------Testing Zip/PostalCode---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Admin
		WebElement Admin = isElementPresent("Admin_xpath");
		highLight(Admin, driver);
		js.executeScript("arguments[0].click();", Admin);
		System.out.println("Clicked on the admin");
		logs.info("Clicked on the admin");
		getScreenshot("Admindiv_", "Zip/PostalCode", driver);

		// Geography
		WebElement Geography = isElementPresent("Geography_xpath");
		highLight(Geography, driver);
		act.moveToElement(Geography).click().perform();
		System.out.println("Clicked on Geography");
		logs.info("Clicked on Geography");
		System.out.println("Clicked on Geography");
		logs.info("Clicked on Geography");

		// Zip/Postal COde
		highLight(isElementPresent("GeoZipCode_xpath"), driver);
		isElementPresent("GeoZipCode_xpath").click();
		System.out.println("Clicked on Zip/Postal Code menu");
		logs.info("Clicked on Zip/Postal Code menu");
		waitForPageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		getScreenshot("Zip/PostalCodeScreen_", "Zip/PostalCode", driver);

		// Create--Back-----
		// Create
		highLight(isElementPresent("GZPCreate_id"), driver);
		isElementPresent("GZPCreate_id").click();
		System.out.println("Clicked on create button");
		logs.info("Clicked on create button");
		waitForPageLoad();
		getScreenshot("GZPCreate_", "Zip/PostalCode", driver);

		// BackButton
		highLight(isElementPresent("GZPBack_id"), driver);
		isElementPresent("GZPBack_id").click();
		System.out.println("Clicked on Back button");
		logs.info("Clicked on Back button");
		getScreenshot("GZPBack_", "Zip/PostalCode", driver);
		waitForPageLoad();

		// Search---Edit------

		WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
		System.out.println("------Testing search------");
		logs.info("------Testing search----------");
		// GZPSZPCode_id
		highLight(isElementPresent("GZPSZPCode_id"), driver);
		isElementPresent("GZPSZPCode_id").sendKeys("R60406");
		System.out.println("Entered value in ZipPostalCode");
		logs.info("Entered value in ZipPostalCode");
		// GZPSAirportID_id
		highLight(isElementPresent("GZPSAirportID_id"), driver);
		isElementPresent("GZPSAirportID_id").sendKeys("ANY1");
		System.out.println("Entered value in AirportID");
		logs.info("Entered value in AirportID");

		// Country
		highLight(isElementPresent("GZPSAirportID_id"), driver);
		isElementPresent("GZPSCountry_id").click();
		Thread.sleep(2000);
		System.out.println("clicked on Country dropdown");
		logs.info("clicked on Country dropdown");

		// State
		highLight(isElementPresent("GZPSState_id"), driver);
		isElementPresent("GZPSState_id").click();
		Thread.sleep(2000);
		System.out.println("clicked on State dropdown");
		logs.info("clicked on State dropdown");
		isElementPresent("GZPSState_id").click();
		System.out.println("clicked on State dropdown");
		logs.info("clicked on State dropdown");

		getScreenshot("SearchData_", "Zip/PostalCode", driver);
		// SearchBTN
		WebElement Search = isElementPresent("GZPSearch_id");
		highLight(isElementPresent("GZPSearch_id"), driver);
		js.executeScript("arguments[0].click()", Search);
		System.out.println("Clicked on Search button");
		logs.info("Clicked on Search button");
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		String Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("SearchResult_", "Zip/PostalCode", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");
			System.out.println("Searched Record is opened in Edit mode");
			logs.info("Searched Record is opened in Edit mode");
			waitForPageLoad();
			Thread.sleep(2000);
			getScreenshot("GZPEditor_", "Zip/PostalCode", driver);

			// Zip/PostalCode
			boolean ZipCode = isElementPresent("GZPZPCode_id").isEnabled();
			if (ZipCode) {
				System.out.println("Zip/Postal code is enabled");
				logs.info("Zip/Postal code is enabled");
			} else {
				System.out.println("Zip/Postal code is Disabled");
				logs.info("Zip/Postal code is Disabled");
			}

			// Default Airport
			highLight(isElementPresent("GZPDefAirport_xpath"), driver);
			isElementPresent("GZPDefAirport_xpath").clear();
			isElementPresent("GZPDefAirport_xpath").sendKeys("ANY1");
			System.out.println("Entered value in Default Airport");
			logs.info("Entered value in Default Airport");

			// TimeZOne
			highLight(isElementPresent("GZPTimeZone_id"), driver);
			isElementPresent("GZPTimeZone_id").clear();
			isElementPresent("GZPTimeZone_id").click();
			isElementPresent("GZPTimeZone_id").sendKeys("America/Curacao");
			Thread.sleep(2000);
			isElementPresent("GZPTimeZone_id").sendKeys(Keys.ENTER);
			System.out.println("Selected value from the dropdown");
			logs.info("Selected value from the dropdown");

			// Latitude
			highLight(isElementPresent("GZPLatt_id"), driver);
			isElementPresent("GZPLatt_id").clear();
			isElementPresent("GZPLatt_id").sendKeys("2000");
			System.out.println("Entered value in Latitude Field");
			logs.info("Entered value in Latitude Field");

			// Longitude
			highLight(isElementPresent("GZPLong_id"), driver);
			isElementPresent("GZPLong_id").clear();
			isElementPresent("GZPLong_id").sendKeys("1000");
			System.out.println("Entered value in Longitude Field");
			logs.info("Entered value in Longitude Field");

			// Country
			boolean COuntry = isElementPresent("GZPCountry_id").isEnabled();
			if (COuntry) {
				System.out.println("COuntry is enabled");
				logs.info("COuntry is enabled");
			} else {
				System.out.println("COuntry is Disabled");
				logs.info("COuntry is Disabled");
			}

			// NFO Airport
			highLight(isElementPresent("GZPDefAirport_xpath"), driver);
			isElementPresent("GZPDefAirport_xpath").clear();
			isElementPresent("GZPDefAirport_xpath").sendKeys("ANY");
			System.out.println("Entered value in NFO Airport");
			logs.info("Entered value in NFO Airport");

			// ValidTo
			highLight(isElementPresent("GZPValidTo_id"), driver);
			isElementPresent("GZPValidTo_id").clear();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 1000);
			String newDate = dateFormat.format(cal.getTime());
			highLight(isElementPresent("GZPValidTo_id"), driver);
			isElementPresent("GZPValidTo_id").sendKeys(newDate);
			System.out.println("Selected Date,1000 days priorior from current Date");
			logs.info("Selected Date,1000 days priorior from current Date");

			getScreenshot("GZPEditrWithData_", "Zip/PostalCode", driver);

			// Submit
			highLight(isElementPresent("GZPSubmit_id"), driver);
			isElementPresent("GZPSubmit_id").click();
			System.out.println("Clicked on Submit button");
			logs.info("Clicked on Submit button");
			getScreenshot("GZPSubmit_", "Zip/PostalCode", driver);

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

			System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
			logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

		}

		// Edit
		highLight(isElementPresent("VCorEdit_xpath"), driver);
		isElementPresent("VCorEdit_xpath").click();
		System.out.println("Clicked on Edit button");
		logs.info("Clicked on Edit button");
		waitForPageLoad();
		// Back
		highLight(isElementPresent("GZPBack_id"), driver);
		isElementPresent("GZPBack_id").click();
		System.out.println("Clicked on Back button");
		logs.info("Clicked on Back button");
		waitForPageLoad();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

		// ---- Search--Delete----
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		System.out.println("--------------Testing search---------------");
		logs.info("--------------Testing search---------------");

		// GZPSAirportID_id
		highLight(isElementPresent("GZPSAirportID_id"), driver);
		isElementPresent("GZPSAirportID_id").sendKeys("ANY1");
		System.out.println("Entered value in AirportID");
		logs.info("Entered value in AirportID");
		getScreenshot("SearchData_", "Zip/PostalCode", driver);
		// SearchBTN
		highLight(isElementPresent("GZPSearch_id"), driver);
		Search = isElementPresent("GZPSearch_id");
		js.executeScript("arguments[0].click()", Search);
		System.out.println("Clicked on Search button");
		logs.info("Clicked on Search button");
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("SearchResult_", "Zip/PostalCode", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");
			Thread.sleep(1000);
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//dx-data-grid[@id=\"gridContainer\"]")));
			// Delete
			highLight(isElementPresent("Del_xpath"), driver);
			isElementPresent("Del_xpath").click();
			System.out.println("Clicked on Delete button");
			System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
			System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
			logs.info("Clicked on Delete button");
			logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
			logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
			getScreenshot("GZPDelete_", "Zip/PostalCode", driver);
			// Keep it
			highLight(isElementPresent("DelKeepIt_xpath"), driver);
			isElementPresent("DelKeepIt_xpath").click();
			System.out.println("Clicked on Keep It button");
			logs.info("Clicked on Keep It button");
			getScreenshot("GZPKeepIt_", "Zip/PostalCode", driver);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

			// Delete
			highLight(isElementPresent("Del_xpath"), driver);
			isElementPresent("Del_xpath").click();
			System.out.println("Clicked on Delete button");
			System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
			System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
			logs.info("Clicked on Delete button");
			logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
			logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
			getScreenshot("GZPDeleteIT_", "Zip/PostalCode", driver);
			// DeleteIt
			highLight(isElementPresent("Delbtn_xpath"), driver);
			isElementPresent("Delbtn_xpath").click();
			System.out.println("Clicked on Delete It button");
			logs.info("Clicked on Delete It button");

		}

		// -ShowInActive checkbox-Checked-Activate the record
		// GZPSAirportID_id
		highLight(isElementPresent("GZPSAirportID_id"), driver);
		isElementPresent("GZPSAirportID_id").sendKeys("ANY1");
		System.out.println("Entered value in AirportID");
		logs.info("Entered value in AirportID");
		// Show InActive Checkbox
		highLight(isElementPresent("GZPSShwInAct_id"), driver);
		isElementPresent("GZPSShwInAct_id").click();
		System.out.println("Checked the checkbox");
		System.out.println("Checkbox is checked=" + isElementPresent("GZPSShwInAct_id").isSelected());
		logs.info("Checked the checkbox");
		logs.info("Checkbox is checked=" + isElementPresent("GZPSShwInAct_id").isSelected());
		getScreenshot("ShowInActChecked_", "Zip/PostalCode", driver);
		// SearchBTN
		highLight(isElementPresent("GZPSearch_id"), driver);
		isElementPresent("GZPSearch_id").click();
		System.out.println("Clicked on Search button");
		logs.info("Clicked on Search button");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("ShwInActSearchResult_", "Zip/PostalCode", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");
			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//dx-data-grid[@id=\"gridContainer\"]")));
			waitForPageLoad();
			Thread.sleep(2000);
			System.out.println("Searched Record is opened in Edit mode");
			logs.info("Searched Record is opened in Edit mode");
			getScreenshot("GZPEditor_", "Zip/PostalCode", driver);
			Thread.sleep(5000);

			// ValidTo
			highLight(isElementPresent("GZPValidTo_id"), driver);
			isElementPresent("GZPValidTo_id").clear();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 1000);
			String newDate = dateFormat.format(cal.getTime());
			isElementPresent("GZPValidTo_id").sendKeys(newDate);
			System.out.println("Selected Date,1000 days priorior from current Date");
			logs.info("Selected Date,1000 days priorior from current Date");

			// Submit
			highLight(isElementPresent("GZPSubmit_id"), driver);
			isElementPresent("GZPSubmit_id").click();
			System.out.println("Clicked on Submit button");
			logs.info("Clicked on Submit button");
		}

		// -ShowInActive checkbox-UnChecked
		// Show InActive Checkbox
		System.out.println("Checkbox is checked=" + isElementPresent("GZPSearch_id").isSelected());
		logs.info("Checkbox is checked=" + isElementPresent("GZPSearch_id").isSelected());
		highLight(isElementPresent("GZPShwInACtive_id"), driver);
		isElementPresent("GZPShwInACtive_id").click();
		System.out.println("Checked the checkbox");
		System.out.println("Checkbox is checked=" + isElementPresent("GZPShwInACtive_id").isSelected());
		logs.info("Checked the checkbox");
		logs.info("Checkbox is checked=" + isElementPresent("GZPShwInACtive_id").isSelected());
		getScreenshot("ShowInActChecked_", "Zip/PostalCode", driver);
		// SearchBTN
		highLight(isElementPresent("GZPSearch_id"), driver);
		isElementPresent("GZPSearch_id").click();
		System.out.println("Clicked on Search button");
		logs.info("Clicked on Search button");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("ShwInActSearchResult_", "Zip/PostalCode", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");

		}

		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]/div/div[6]/div/table/tbody")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-info\"]")));

		// Pagination
		pagination("Zip/PostalCode");

		// PageSize
		pageSize("Zip/PostalCode");

		// NormalView
		normalView("Zip/PostalCode");

	}
}
