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

public class CountryState extends BaseInit {

	@Test
	public void countryState() throws InterruptedException, IOException {
		System.out.println("--------------Testing CountryState---------------");
		logs.info("--------------Testing CountryState---------------");

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
		getScreenshot("Admindiv_", "CountryState", driver);

		// Admin SubMenu
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

				getScreenshot("Countrycreen_", "CountryState", driver);

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
					getScreenshot("Editor_", "CountryState", driver);

					// State/Province
					highLight(isElementPresent("GCStateProv_xpath"), driver);
					isElementPresent("GCStateProv_xpath").click();
					System.out.println("Clicked on the State/Province");
					logs.info("Clicked on the State/Province");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("State/ProvEditor_", "CountryState", driver);

					// Create
					System.out.println("--Testing Create------");
					logs.info("----------Testing Create-------");
					highLight(isElementPresent("GCSPCreate_id"), driver);
					isElementPresent("GCSPCreate_id").click();
					System.out.println("Clicked on Create button");
					logs.info("Clicked on Create button");
					waitForPageLoad();
					getScreenshot("CountryStateCreate_", "CountryState", driver);

					// Cancel
					highLight(isElementPresent("GCSPCancel_id"), driver);
					isElementPresent("GCSPCancel_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Search
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("GCSPSearch_id"), driver);
					isElementPresent("GCSPSearch_id").sendKeys("AutoState");
					isElementPresent("GCSPSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Searchbox");
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
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}
					// Filter
					highLight(isElementPresent("GCSPSearch_id"), driver);
					isElementPresent("GCSPSearch_id").clear();
					System.out.println("Cleared the search criteria");
					logs.info("Cleared the search criteria");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("GCSPFilter_xpath"), driver);
					isElementPresent("GCSPFilter_xpath").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					getScreenshot("CountryStateFilter_", "CountryState", driver);
					highLight(isElementPresent("GCSPFName_id"), driver);
					isElementPresent("GCSPFName_id").sendKeys("AutoState");
					System.out.println("Entered value in Name");
					logs.info("Entered value in Name");
					WebElement ApFi = isElementPresent("GCSPAppFil_id");
					highLight(isElementPresent("GCSPAppFil_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("FilterData_", "CountryState", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
						// Edit
						Edit = isElementPresent("Edit_xpath");
						highLight(isElementPresent("Edit_xpath"), driver);
						js.executeScript("arguments[0].click();", Edit);
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						Thread.sleep(2000);
						getScreenshot("Editor_", "CountryState", driver);

						// Name
						highLight(isElementPresent("GCSPName_id"), driver);
						isElementPresent("GCSPName_id").clear();
						isElementPresent("GCSPName_id").sendKeys("AutoState");
						System.out.println("entered Name");
						logs.info("entered Name");

						// Country
						boolean Country = isElementPresent("GCSPCountry_id").isEnabled();
						if (Country) {
							System.out.println("Country is enabled");
							logs.info("Country is enabled");
						} else {
							System.out.println("Country is Disabled");
							logs.info("Country is Disabled");
						}

						// Code
						boolean Code = isElementPresent("GCSPCode_id").isEnabled();
						if (Code) {
							System.out.println("Code is enabled");
							logs.info("Code is enabled");
						} else {
							System.out.println("Code is Disabled");
							logs.info("Code is Disabled");
						}

						getScreenshot("Editorwithdata_", "CountryState", driver);

						// submit
						WebElement Sub = isElementPresent("GCSPSave_id");
						highLight(isElementPresent("GCSPSave_id"), driver);
						js.executeScript("arguments[0].click();", Sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					}

					// Filter-Clear Filter
					highLight(isElementPresent("GCSPFilter_xpath"), driver);
					isElementPresent("GCSPFilter_xpath").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					WebElement clear = isElementPresent("GCSPClearFil_id");
					highLight(isElementPresent("GCSPClearFil_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					ApFi = isElementPresent("GCSPAppFil_id");
					highLight(isElementPresent("GCSPAppFil_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("CountryStateGridAFClearF_", "CountryState", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}
					// Filter-Cancel
					highLight(isElementPresent("GCSPFilter_xpath"), driver);
					isElementPresent("GCSPFilter_xpath").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("GCSPClearFil_id");
					highLight(isElementPresent("GCSPClearFil_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					WebElement Cancl = isElementPresent("GCSPFCancel_id");
					highLight(isElementPresent("GCSPFCancel_id"), driver);
					js.executeScript("arguments[0].click();", Cancl);
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");

					// PageSize
					pageSize("CountryState");

					// Pagination
					pagination("CountryState");

					// NormalView
					normalView("CountryState");

					break;
				}

			} else {
				System.out.println("Geography is not exist");
				logs.info("Geography is not exist");
			}

		}

	}
}
