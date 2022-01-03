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

import samyak_BasePackage.BaseInit;

public class GeographyCountry extends BaseInit {

	@Test
	public void geographyCountry() throws InterruptedException, IOException {

		System.out.println("--------------Testing GEOGRAPHY COUNTRY---------------");
		logs.info("--------------Testing GEOGRAPHY COUNTRY---------------");
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
		getScreenshot("Admindiv_", "Country", driver);

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
				highLight(isElementPresent("GeoCntry_xpath"), driver);
				isElementPresent("GeoCntry_xpath").click();
				System.out.println("Clicked on Country menu");
				logs.info("Clicked on Country menu");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("Countrycreen_", "Country", driver);

				// -------- Create-Back--------
				highLight(isElementPresent("GeoCCreate_id"), driver);
				isElementPresent("GeoCCreate_id").click();
				System.out.println("Clicked on create button");
				logs.info("Clicked on create button");
				wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("GeoCBack_id")));
				getScreenshot("CreateScreen_", "Country", driver);

				// Back
				highLight(isElementPresent("GeoCBack_id"), driver);
				isElementPresent("GeoCBack_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				highLight(isElementPresent("GeoCSearch_id"), driver);
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
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
					highLight(isElementPresent("Edit_xpath"), driver);
					WebElement Edit = isElementPresent("Edit_xpath");
					js.executeScript("arguments[0].click();", Edit);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "Country", driver);

					// Continent
					highLight(isElementPresent("GeoCContinent_id"), driver);
					isElementPresent("GeoCContinent_id").clear();
					isElementPresent("GeoCContinent_id").click();
					isElementPresent("GeoCContinent_id").sendKeys("North America");
					Thread.sleep(2000);
					isElementPresent("GeoCContinent_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");

					// Country Code
					boolean cntryCode = isElementPresent("GeoCCntryCode_id").isEnabled();
					if (cntryCode) {
						System.out.println("Country code is enabled");
						logs.info("Country code is enabled");
					} else {
						System.out.println("Country code is Disabled");
						logs.info("Country code is Disabled");
					}

					// Country Name
					highLight(isElementPresent("GeoCCntryName_id"), driver);
					isElementPresent("GeoCCntryName_id").clear();
					isElementPresent("GeoCCntryName_id").sendKeys("Automation USA");
					System.out.println("Entered value in Country Name");
					logs.info("Entered value in Country Name");

					// Country IATA Code
					highLight(isElementPresent("GeoCCntryIATA_id"), driver);
					isElementPresent("GeoCCntryIATA_id").clear();
					isElementPresent("GeoCCntryIATA_id").sendKeys("AC1");
					System.out.println("Entered value in Country IATA Code");
					logs.info("Entered value in Country IATA Code");

					// Country Calling Code
					highLight(isElementPresent("GeoCCallCode_id"), driver);
					isElementPresent("GeoCCallCode_id").clear();
					isElementPresent("GeoCCallCode_id").sendKeys("1");
					System.out.println("Entered value in Country Calling Code");
					logs.info("Entered value in Country Calling Code");

					// TimeZOne
					highLight(isElementPresent("GeoCTimeZon_id"), driver);
					isElementPresent("GeoCTimeZon_id").clear();
					isElementPresent("GeoCTimeZon_id").click();
					isElementPresent("GeoCTimeZon_id").sendKeys("america/nome");
					Thread.sleep(2000);
					isElementPresent("GeoCTimeZon_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");

					// Currency
					highLight(isElementPresent("GeoCCurrency_id"), driver);
					isElementPresent("GeoCCurrency_id").clear();
					isElementPresent("GeoCCurrency_id").click();
					isElementPresent("GeoCCurrency_id").sendKeys("US Dollars");
					Thread.sleep(2000);
					isElementPresent("GeoCCurrency_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");

					// Embargo
					highLight(isElementPresent("GeoCEmbargo_id"), driver);
					isElementPresent("GeoCEmbargo_id").click();
					System.out.println("Clicked on Embargo checkbox");
					logs.info("Clicked on Embargo checkbox");
					System.out.println(
							"Embargo checkbox is selected==" + isElementPresent("GeoCEmbargo_id").isSelected());
					logs.info("Embargo checkbox==" + isElementPresent("GeoCEmbargo_id").isSelected());

					// submit
					highLight(isElementPresent("GeoCSubmi_id"), driver);
					WebElement Sub = isElementPresent("GeoCSubmi_id");
					js.executeScript("arguments[0].click();", Sub);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

				}

				// Filter
				highLight(isElementPresent("GeoCSearch_id"), driver);
				isElementPresent("GeoCSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				isElementPresent("GeoCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("GeoCntryFilter_", "Country", driver);

				// Country Code
				highLight(isElementPresent("GeoCFCntryCode_id"), driver);
				isElementPresent("GeoCFCntryCode_id").sendKeys("AC");
				System.out.println("Entered value in County Code");
				logs.info("Entered value in County Code");

				// Country Name
				highLight(isElementPresent("GeoCFCntryCode_id"), driver);
				isElementPresent("GeoCFCntryCode_id").sendKeys("Automation USA");
				System.out.println("Entered value in Country Name");
				logs.info("Entered value in Country Name");

				// Country IATA Code
				highLight(isElementPresent("GeoCFIATACode_id"), driver);
				isElementPresent("GeoCFIATACode_id").sendKeys("AC1");
				System.out.println("Entered value in Category");
				logs.info("Entered value in Category");

				// TimeZOne
				highLight(isElementPresent("GeoCFTimeZone_id"), driver);
				isElementPresent("GeoCFTimeZone_id").clear();
				isElementPresent("GeoCFTimeZone_id").click();
				isElementPresent("GeoCFTimeZone_id").sendKeys("america/nome");
				Thread.sleep(2000);
				isElementPresent("GeoCFTimeZone_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from the dropdown");
				logs.info("Selected value from the dropdown");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				WebElement ApFi = isElementPresent("GeoCAppFilter_id");
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
					highLight(isElementPresent("GeoCBack_id"), driver);
					isElementPresent("GeoCBack_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// --Filter--Embargo-checked--
				highLight(isElementPresent("GeoCSearch_id"), driver);
				isElementPresent("GeoCSearch_id").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("GeoCFilter_id"), driver);
				isElementPresent("GeoCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("GeoCFEmbargo_id"), driver);
				isElementPresent("GeoCFEmbargo_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("GeoCFEmbargo_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("GeoCFEmbargo_id").isSelected());
				getScreenshot("GeoCntryShwInActive_", "Country", driver);
				ApFi = isElementPresent("GeoCAppFilter_id");
				highLight(isElementPresent("GeoCAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("GeoCntryEdit_", "Country", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// --Filter--Embargo-Unchecked--
				highLight(isElementPresent("GeoCSearch_id"), driver);
				isElementPresent("GeoCSearch_id").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("GeoCFilter_id"), driver);
				isElementPresent("GeoCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("GeoCFEmbargo_id"), driver);
				isElementPresent("GeoCFEmbargo_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("GeoCFEmbargo_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("GeoCFEmbargo_id").isSelected());
				getScreenshot("GeoCntryShwInActive_", "Country", driver);
				highLight(isElementPresent("GeoCAppFilter_id"), driver);
				ApFi = isElementPresent("GeoCAppFilter_id");
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("GeoCntryEdit_", "Country", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// Filter-Clear Filter-
				highLight(isElementPresent("GeoCFilter_id"), driver);
				isElementPresent("GeoCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("GeoCClearFil_id"), driver);
				WebElement clear = isElementPresent("GeoCClearFil_id");
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("GeoCAppFilter_id"), driver);
				ApFi = isElementPresent("GeoCAppFilter_id");
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("GeoCntryGridAFClearF_", "Country", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// Filter-Cancel
				highLight(isElementPresent("GeoCFilter_id"), driver);
				isElementPresent("GeoCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				// Clear filter not exist
				highLight(isElementPresent("GeoCClearFil_id"), driver);
				clear = isElementPresent("GeoCClearFil_id");
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("GeoCFCancel_id"), driver);
				WebElement Cancl = isElementPresent("GeoCFCancel_id");
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");

				// PageSize
				pageSize("Country");

				// pagination
				pagination("Country");

				// normalView
				normalView("Country");

				// columns
				columns("Country");

				break;
			} else {
				System.out.println("GEOGRAPHY COUNTRY is not exist");
				logs.info("GEOGRAPHY COUNTRY is not exist");
			}

		}

	}
}
