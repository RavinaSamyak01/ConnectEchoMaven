package admin;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import samyak_BasePackage.BaseInit;

public class CountryCity extends BaseInit {

	@Test
	public void countryCity() throws InterruptedException, IOException {

		System.out.println("--------------Testing CountryCityCity---------------");
		logs.info("--------------Testing CountryCityCity---------------");
		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Admin
		WebElement Admin = isElementPresent("Admin_xpath");
		highLight(Admin, driver);
		js.executeScript("arguments[0].click();", Admin);
		System.out.println("Clicked on the admin");
		test.log(LogStatus.INFO, "Clicked on the admin");
		logs.info("Clicked on the admin");
		getScreenshot("Admindiv_", "CountryCity", driver);

		// Admin Menu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());

			// Geography
			if (headervalue.equalsIgnoreCase("Geography")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on Geography");
				logs.info("Clicked on Geography");

				// Country
				highLight(isElementPresent("CntryCity_xpath"), driver);
				isElementPresent("CntryCity_xpath").click();
				System.out.println("Clicked on Country menu");
				logs.info("Clicked on Country menu");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("Countryscreen_", "CountryCity", driver);

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("GeoCSearch_id"), driver);
				isElementPresent("GeoCSearch_id").sendKeys("Automation USA");
				isElementPresent("GeoCSearch_id").sendKeys(Keys.ENTER);
				System.out.println("Enteredvalue in Searchbox");
				logs.info("Entered value in Searchbox");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					WebElement Edit = isElementPresent("Edit_xpath");
					highLight(isElementPresent("Edit_xpath"), driver);
					js.executeScript("arguments[0].click();", Edit);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "CountryCity", driver);

					// CountryCity
					highLight(isElementPresent("GCCity_xpath"), driver);
					isElementPresent("GCCity_xpath").click();
					System.out.println("Clicked on the City");
					logs.info("Clicked on the City");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("CityEditor_", "CountryCity", driver);

					// -------- Create-Back--------
					highLight(isElementPresent("GCCCreate_id"), driver);
					isElementPresent("GCCCreate_id").click();
					System.out.println("Clicked on create button");
					logs.info("Clicked on create button");
					wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("GeoCBack_id")));
					getScreenshot("CreateScreen_", "CountryCity", driver);

					// Back
					highLight(isElementPresent("GCCBack_id"), driver);
					isElementPresent("GCCBack_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Search
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("GCCSearch_id"), driver);
					isElementPresent("GCCSearch_id").sendKeys("AutoCity");
					isElementPresent("GCCSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Enteredvalue in Searchbox");
					logs.info("Entered value in Searchbox");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					getScreenshot("Search_", "CountryCity", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						Edit = isElementPresent("GCCSearch_id");
						highLight(isElementPresent("GCCSearch_id"), driver);
						js.executeScript("arguments[0].click();", Edit);
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						Thread.sleep(2000);
						getScreenshot("CityEditor_", "CountryCity", driver);

						// Country
						boolean Country = isElementPresent("GCCContry_id").isEnabled();
						if (Country) {
							System.out.println("Country is enabled");
							logs.info("Country is enabled");
						} else {
							System.out.println("Country is Disabled");
							logs.info("Country is Disabled");
						}

						// State/Province
						highLight(isElementPresent("GCCStateProv_id"), driver);
						isElementPresent("GCCStateProv_id").clear();
						isElementPresent("GCCStateProv_id").click();
						isElementPresent("GCCStateProv_id").sendKeys("AutoState");
						Thread.sleep(2000);
						isElementPresent("GCCStateProv_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from the dropdown");
						logs.info("Selected value from the dropdown");

						// City Name
						highLight(isElementPresent("GCCCity_id"), driver);
						isElementPresent("GCCCity_id").clear();
						isElementPresent("GCCCity_id").sendKeys("AutoCity");
						System.out.println("Entered value in City Name");
						logs.info("Entered value in City Name");

						// ZipCode
						highLight(isElementPresent("GCCZipCOde_id"), driver);
						isElementPresent("GCCZipCOde_id").clear();
						isElementPresent("GCCZipCOde_id").sendKeys("A60406");
						System.out.println("Entered value in ZipCode");
						logs.info("Entered value in ZipCode");
						isElementPresent("GCCZipCOde_id").sendKeys(Keys.TAB);

						// -- ZipCOde search--Close
						System.out.println("----Testing Zipcode search----");
						logs.info("----Testing Zipcode search----");
						highLight(isElementPresent("GCCZipSearch_id"), driver);
						isElementPresent("GCCZipSearch_id").click();
						System.out.println("Clicked on Search button of the ZipCode");
						logs.info("Clicked on Search button of the ZipCode");
						getScreenshot("Zipcodesearch_", "CountryCity", driver);

						// Close
						highLight(isElementPresent("GCCZSClose_id"), driver);
						isElementPresent("GCCZSClose_id").click();
						System.out.println("Clicked on Close button of the ZipCode screen");
						logs.info("Clicked on Close button of the ZipCode screen");
						getScreenshot("ZipCOdeClose_", "CountryCity", driver);

						// -- ZipCOde search--Submit
						System.out.println("----Testing Zipcode search----");
						logs.info("----Testing Zipcode search----");
						highLight(isElementPresent("GCCZipSearch_id"), driver);
						isElementPresent("GCCZipSearch_id").click();
						System.out.println("Clicked on Search button of the ZipCode");
						logs.info("Clicked on Search button of the ZipCode");
						getScreenshot("Zipcodesearch_", "CountryCity", driver);

						// Country
						Country = isElementPresent("GCCZSCountry_id").isEnabled();
						if (Country) {
							System.out.println("Country is enabled");
							logs.info("Country is enabled");
						} else {
							System.out.println("Country is Disabled");
							logs.info("Country is Disabled");
						}

						// ZipCode
						highLight(isElementPresent("GCCZSZipcode_id"), driver);
						isElementPresent("GCCZSZipcode_id").clear();
						isElementPresent("GCCZSZipcode_id").sendKeys("A60406");
						System.out.println("Entered value in ZipCode");
						logs.info("Entered value in ZipCode");
						isElementPresent("GCCZSZipcode_id").sendKeys(Keys.TAB);

						// City Name
						highLight(isElementPresent("GCCZSCity_id"), driver);
						isElementPresent("GCCZSCity_id").clear();
						isElementPresent("GCCZSCity_id").sendKeys("AutoCity");
						System.out.println("Entered value in City Name");
						logs.info("Entered value in City Name");

						// State/Province
						highLight(isElementPresent("GCCZSState_id"), driver);
						isElementPresent("GCCZSState_id").clear();
						isElementPresent("GCCZSState_id").click();
						isElementPresent("GCCZSState_id").sendKeys("AutoState");
						Thread.sleep(2000);
						isElementPresent("GCCZSState_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from the dropdown");
						logs.info("Selected value from the dropdown");

						getScreenshot("Zipcodesearchdata_", "CountryCity", driver);

						// Search
						highLight(isElementPresent("GCCZSSearch_id"), driver);
						isElementPresent("GCCZSSearch_id").click();
						System.out.println("Clicked on Search button of the ZipCode screen");
						logs.info("Clicked on Search button of the ZipCode screen");
						getScreenshot("ZipCOdeSearch_", "CountryCity", driver);

						// SelectRecord
						highLight(isElementPresent("GCCZSSelectItem_"), driver);
						isElementPresent("GCCZSSelectItem_").click();
						System.out.println("Selected the zipcode");
						logs.info("Selected the zipcode");

						// AirportID
						highLight(isElementPresent("GCCAirport_xpath"), driver);
						isElementPresent("GCCAirport_xpath").clear();
						isElementPresent("GCCAirport_xpath").sendKeys("ANY1");
						Thread.sleep(2000);
						isElementPresent("GCCAirport_xpath").sendKeys(Keys.DOWN);
						isElementPresent("GCCAirport_xpath").sendKeys(Keys.ENTER);
						System.out.println("Entered value in AirportID");
						logs.info("Entered value in AirportID");

						// Longitude
						highLight(isElementPresent("GCCLongiTude_id"), driver);
						isElementPresent("GCCLongiTude_id").clear();
						isElementPresent("GCCLongiTude_id").sendKeys("1000");
						System.out.println("Entered value in Longitude");
						logs.info("Entered value in Longitude");

						// Latitude
						highLight(isElementPresent("GCCLatitude_id"), driver);
						isElementPresent("GCCLatitude_id").clear();
						isElementPresent("GCCLatitude_id").sendKeys("1000");
						System.out.println("Entered value in Latitude");
						logs.info("Entered value in Latitude");

						getScreenshot("EditorwithData_", "CountryCity", driver);

						// submit
						WebElement Sub = isElementPresent("GCCLatitude_id");
						highLight(isElementPresent("GCCLatitude_id"), driver);
						js.executeScript("arguments[0].click();", Sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					}

					// Filter
					highLight(isElementPresent("GCCLatitude_id"), driver);
					isElementPresent("GCCLatitude_id").clear();
					System.out.println("Cleared the search criteria");
					logs.info("Cleared the search criteria");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("GCCFilter_id"), driver);
					isElementPresent("GCCFilter_id").clear();
					isElementPresent("GCCFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					getScreenshot("CntryCityFilter_", "CountryCity", driver);

					// CityName
					highLight(isElementPresent("GCCFCityName_id"), driver);
					isElementPresent("GCCFCityName_id").sendKeys("AutoCity");
					System.out.println("Entered value in City Name");
					logs.info("Entered value in City Name");

					// Country
					boolean Country = isElementPresent("GCCFContry_id").isEnabled();
					if (Country) {
						System.out.println("Country is enabled");
						logs.info("Country is enabled");
					} else {
						System.out.println("Country is Disabled");
						logs.info("Country is Disabled");
					}

					// Zip/PostalCOde
					highLight(isElementPresent("GCCFZipPostCode_id"), driver);
					isElementPresent("GCCFZipPostCode_id").sendKeys("A60406");
					System.out.println("Entered value in Zip/Postal Code");
					logs.info("Entered value in Zip/Postal Code");

					// AirportID
					highLight(isElementPresent("GCCFAirport_id"), driver);
					isElementPresent("GCCFAirport_id").sendKeys("ANY1");
					System.out.println("Entered value in AirportID");
					logs.info("Entered value in AirportID");

					/// State/Province
					highLight(isElementPresent("GCCStateProv_id"), driver);
					isElementPresent("GCCStateProv_id").clear();
					isElementPresent("GCCStateProv_id").click();
					isElementPresent("GCCStateProv_id").sendKeys("AutoState");
					Thread.sleep(2000);
					isElementPresent("GCCStateProv_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");

					ImageFile = isElementPresent("ApNoDataImage_xpath");
					WebElement ApFi = isElementPresent("GCCAppFil_id");
					highLight(isElementPresent("GCCAppFil_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						waitForPageLoad();
						Thread.sleep(2000);
						System.out.println("Record is opened in edit mode");
						logs.info("Record is opened in edit mode");

						// Back
						highLight(isElementPresent("GCCBack_id"), driver);
						isElementPresent("GCCBack_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					}

					// Filter-Clear Filter-
					highLight(isElementPresent("GCCFilter_id"), driver);
					isElementPresent("GCCFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					WebElement clear = isElementPresent("GCCClearFil_id");
					highLight(isElementPresent("GCCClearFil_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					ApFi = isElementPresent("GCCAppFil_id");
					highLight(isElementPresent("GCCAppFil_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("CntryCityGridAFClearF_", "CountryCity", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-Cancel
					highLight(isElementPresent("GCCFilter_id"), driver);
					isElementPresent("GCCFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					// Clear filter not exist

					clear = isElementPresent("GCCClearFil_id");
					highLight(isElementPresent("GCCClearFil_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");

					WebElement Cancl = isElementPresent("GCCFCancel_id");
					highLight(isElementPresent("GCCFCancel_id"), driver);
					js.executeScript("arguments[0].click();", Cancl);
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");

					// PageSize
					pageSize("CountryCity");

					// pagination
					pagination("CountryCity");

					// normalView
					normalView("CountryCity");

					// columns
					columns("CountryCity");

					break;
				}

			} else {
				System.out.println("Geography is not exist");
				logs.info("Geography is not exist");
			}

		}

	}
}
