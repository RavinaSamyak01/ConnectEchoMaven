package vendor;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class VenServiceAreaType extends BaseInit {

	@Test
	public void venServiceAreaType() throws InterruptedException, IOException {

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Actions act = new Actions(driver);

		// Main Vendor menu
		highLight(isElementPresent("MainVendor_xpath"), driver);
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"sidenav\"]/ul/li")));

		WebElement vendordiv = isElementPresent("VCorDiv_xpath");
		List<WebElement> vendItem = vendordiv.findElements(By.className("dx-button-content"));
		for (int count = 0; count < vendItem.size(); count++) {
			String IName = vendItem.get(count).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Vendor")) {
				highLight(vendItem.get(count), driver);
				vendItem.get(count).click();
				System.out.println("clicked on Vendor");
				logs.info("clicked on Vendor");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				waitForPageLoad();
				getScreenshot("Vendor_", "VendorServiceAreaType", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VendorServiceAreaType", driver);
				WebElement Search = isElementPresent("Search_id");
				highLight(isElementPresent("Search_id"), driver);
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VendorServiceAreaType", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "VendorServiceAreaType", driver);

					// ServiceAreaType
					highLight(isElementPresent("VendSAreaType_xpath"), driver);
					isElementPresent("VendSAreaType_xpath").click();
					System.out.println("Clicked on ServiceAreaType menu");
					logs.info("Clicked on ServiceAreaType menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendServiceAreaTypeScreen_", "VendorServiceAreaType", driver);

					// -------- Create-Back--------
					highLight(isElementPresent("VSATCreate_id"), driver);
					isElementPresent("VSATCreate_id").click();
					System.out.println("Clicked on create button");
					logs.info("Clicked on create button");
					wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("VSATBack_id")));
					getScreenshot("CreateScreen_", "VendorServiceAreaType", driver);

					// Back
					highLight(isElementPresent("VSATBack_id"), driver);
					isElementPresent("VSATBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// --Search--edit
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VSATSearch_id"), driver);
					isElementPresent("VSATSearch_id").sendKeys("ANY1");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					isElementPresent("VSATSearch_id").sendKeys(Keys.ENTER);
					System.out.println("clicked enter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorServiceAreaType", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VendorServiceAreaType", driver);
						Thread.sleep(2000);

						// AreaType
						highLight(isElementPresent("VSATSATDrop_id"), driver);
						isElementPresent("VSATSATDrop_id").click();
						isElementPresent("VSATSATDrop_id").clear();
						isElementPresent("VSATSATDrop_id").sendKeys("Airport");
						Thread.sleep(1000);
						isElementPresent("VSATSATDrop_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from the dropdown");
						logs.info("Selected value from the dropdown");

						// AirportID
						highLight(isElementPresent("VSATApIDText_id"), driver);
						isElementPresent("VSATApIDText_id").sendKeys("ANY1");
						System.out.println("Selected value from the dropdown");
						logs.info("Selected value from the dropdown");

						// ValidTo
						highLight(isElementPresent("VSATValidTo_id"), driver);
						isElementPresent("VSATValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VSATValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						// AirportIDSearch
						/*
						 * isElementPresent("VSATAPIDS_id").click();
						 * System.out.println("Clicked on Search button of AirportID");
						 * logs.info("Clicked on Search button of AirportID"); Thread.sleep(2000);
						 */
						/*
						 * // ---Search--Reset APID = isElementPresent("VSATAPSBTN_id");
						 * js.executeScript("arguments[0].click();", APID);
						 * 
						 * System.out.println("Clicked on Search button");
						 * logs.info("Clicked on Search button"); wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]"))); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); Data =
						 * isElementPresent("GridRecord_xpath").getText();
						 * System.out.println("searched data is" + " " + Data);
						 * logs.info("searched data is" + " " + Data); getScreenshot("SearchResult_",
						 * "VendorServiceAreaType", driver); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); if (ImageFile.isDisplayed()) {
						 * System.out.println("There is not any data related enetered search parameters"
						 * ); logs.info("There is not any data related enetered search parameters");
						 * 
						 * } else {
						 * System.out.println("Data is present related enetered search parameters");
						 * logs.info("Data is present related enetered search parameters"); }
						 * 
						 * // Reset isElementPresent("VSATAPReset_id").click();
						 * System.out.println("Clicked on Reset button");
						 * logs.info("Clicked on Reset button"); wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						 * 
						 * // Reset--Search isElementPresent("VSATAPSBTN_id").click();
						 * System.out.println("Clicked on Search button");
						 * logs.info("Clicked on Search button"); wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						 * 
						 * ImageFile = isElementPresent("ApNoDataImage_xpath"); String Data1 =
						 * isElementPresent("GridRecord_xpath").getText();
						 * System.out.println("searched data is" + " " + Data1);
						 * logs.info("searched data is" + " " + Data1); getScreenshot("SearchResult_",
						 * "VendorServiceAreaType", driver); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); if (ImageFile.isDisplayed()) {
						 * System.out.println("There is not any data related enetered search parameters"
						 * ); logs.info("There is not any data related enetered search parameters");
						 * 
						 * } else {
						 * System.out.println("Data is present related enetered search parameters");
						 * logs.info("Data is present related enetered search parameters"); }
						 * 
						 * if (Data != Data1) {
						 * System.out.println("Search is not working after reset button click event ");
						 * logs.info("Search is not working after reset button click event");
						 * 
						 * } else {
						 * System.out.println("Search is working after reset button click event ");
						 * logs.info("Search is working after reset button click event");
						 * 
						 * }
						 */

						// SimpleSearch
						/*
						 * WebElement APID = isElementPresent("VSATAPSBTN_id");
						 * js.executeScript("arguments[0].click();", APID);
						 * System.out.println("Clicked on Search button");
						 * logs.info("Clicked on Search button"); wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]"))); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); Data =
						 * isElementPresent("GridRecord_xpath").getText();
						 * System.out.println("searched data is" + " " + Data);
						 * logs.info("searched data is" + " " + Data); getScreenshot("SearchResult_",
						 * "VendorServiceAreaType", driver); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); if (ImageFile.isDisplayed()) {
						 * System.out.println("There is not any data related enetered search parameters"
						 * ); logs.info("There is not any data related enetered search parameters");
						 * 
						 * } else {
						 * System.out.println("Data is present related enetered search parameters");
						 * logs.info("Data is present related enetered search parameters");
						 * 
						 * // PageSize pageSize("VendServiceAreaType");
						 * 
						 * // Pagination pagination("VendServiceAreaType");
						 * 
						 * }
						 * 
						 * // Particular Data Search APID = isElementPresent("VSATAPSBTN_id");
						 * js.executeScript("arguments[0].click();", APID);
						 * System.out.println("Entered AIrportID"); logs.info("Entered AIrportID");
						 * 
						 * // Search isElementPresent("VSATAPSBTN_id").click();
						 * System.out.println("Clicked on Search button");
						 * logs.info("Clicked on Search button"); wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]"))); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); Data =
						 * isElementPresent("GridRecord_xpath").getText();
						 * System.out.println("searched data is" + " " + Data);
						 * logs.info("searched data is" + " " + Data); getScreenshot("SearchResult_",
						 * "VendorServiceAreaType", driver); ImageFile =
						 * isElementPresent("ApNoDataImage_xpath"); if (ImageFile.isDisplayed()) {
						 * System.out.println("There is not any data related enetered search parameters"
						 * ); logs.info("There is not any data related enetered search parameters");
						 * 
						 * } else {
						 * System.out.println("Data is present related enetered search parameters");
						 * logs.info("Data is present related enetered search parameters");
						 * 
						 * // selectItem isElementPresent("VSATAPIDItem_xpath").click();
						 * System.out.println("Selected the Record"); logs.info("Selected the Record");
						 * Thread.sleep(2000);
						 * 
						 * }
						 */

						// Submit
						highLight(isElementPresent("VSATSubmit_id"), driver);
						isElementPresent("VSATSubmit_id").click();
						waitForPageLoad();
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

					// Clear Search
					highLight(isElementPresent("VSATSearch_id"), driver);
					isElementPresent("VSATSearch_id").clear();
					isElementPresent("VSATSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Cleared the search criteria");
					logs.info("Cleared the search criteria");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendServiceAreaType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-SHWDeleted-Checked
					highLight(isElementPresent("VSATShwInActive_id"), driver);
					isElementPresent("VSATShwInActive_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VSATShwInActive_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("VSATShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendServiceAreaType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-ShwDeleted-UnChecked
					highLight(isElementPresent("VSATShwInActive_id"), driver);
					isElementPresent("VSATShwInActive_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VSATShwInActive_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("VSATShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendServiceAreaType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// PageSize
					pageSize("VendServiceAreaType");

					// Pagination
					pagination("VendServiceAreaType");

					// NormalView
					normalView("VendServiceAreaType");

					// Columns
					columns("VendServiceAreaType");

					break;
				}
			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}
		}
	}

}
