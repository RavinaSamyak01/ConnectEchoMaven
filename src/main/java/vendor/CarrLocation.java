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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class CarrLocation extends BaseInit {

	@Test
	public void carrLocation() throws InterruptedException, IOException {
		System.out.println("--------------Testing CARRIER-LOCATION---------------");
		logs.info("--------------Testing CARRIER-LOCATION---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Main Vendor menu
		highLight(isElementPresent("MainVendor_xpath"), driver);
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		logs.info("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"sidenav\"]/ul/li")));
		getScreenshot("MainVendorMenu", "Location", driver);
		WebElement vendordiv = isElementPresent("VCorDiv_xpath");
		List<WebElement> vendItem = vendordiv.findElements(By.className("dx-button-content"));
		for (int count1 = 0; count1 < vendItem.size(); count1++) {
			String IName = vendItem.get(count1).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Carrier")) {
				highLight(vendItem.get(count1), driver);
				vendItem.get(count1).click();
				System.out.println("clicked on Carrier");
				logs.info("clicked on Carrier");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("Carrier_", "Location", driver);

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				System.out.println("--------------Testing search---------------");
				logs.info("--------------Testing search---------------");
				// AWSPrefix
				highLight(isElementPresent("CarrAWSP_xpath"), driver);
				isElementPresent("CarrAWSP_xpath").sendKeys("");
				System.out.println("Entered value in AWSPrefix");
				logs.info("Entered value in AWSPrefix");
				// Name
				highLight(isElementPresent("CarrAirName_xpath"), driver);
				isElementPresent("CarrAirName_xpath").sendKeys("Air US");
				System.out.println("Entered value in Name");
				logs.info("Entered value in Name");
				// OAGID
				highLight(isElementPresent("CarrOAGId_xpath"), driver);
				isElementPresent("CarrOAGId_xpath").sendKeys("OAG10");
				System.out.println("Entered value in OAGID");
				logs.info("Entered value in OAGID");
				getScreenshot("SearchData_", "Location", driver);
				// SearchBTN
				WebElement Search = isElementPresent("VCorSearch_xpath");
				highLight(isElementPresent("VCorSearch_xpath"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Location", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					waitForPageLoad();
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					getScreenshot("CarrEditor_", "Location", driver);

					// Location
					highLight(isElementPresent("Location_xpath"), driver);
					isElementPresent("Location_xpath").click();
					System.out.println("Clicked on Location menu");
					logs.info("Clicked on Location menu");
					waitForPageLoad();
					getScreenshot("Locationcreen_", "Location", driver);

					// Create-Back
					highLight(isElementPresent("LocCreate_id"), driver);
					isElementPresent("LocCreate_id").click();
					System.out.println("Clicked on Create button");
					System.out.println("Title of the page is==" + isElementPresent("CreateTitle_xpath").getText());
					logs.info("Clicked on Create button");
					logs.info("Title of the page is==" + isElementPresent("CreateTitle_xpath").getText());
					getScreenshot("LocationCreate_", "Location", driver);
					waitForPageLoad();

					// Back
					WebElement back = isElementPresent("LocBack_id");
					highLight(isElementPresent("LocBack_id"), driver);
					wait.until(ExpectedConditions.elementToBeClickable(back));
					js.executeScript("arguments[0].click();", back);
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					waitForPageLoad();

					// Create-Submit

					/*
					 * System.out.
					 * println("------------------------Testing Create------------------------");
					 * logs.info("------------------------Testing Create------------------------");
					 * isElementPresent("LocCreate_id").click();
					 * System.out.println("Clicked on Create button");
					 * logs.info("Clicked on Create button"); wait.until(ExpectedConditions
					 * .visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"card mb-20\"]")));
					 * 
					 * // LocatioType Dropdown isElementPresent("LocType_id").click();
					 * System.out.println("Clicked on Location Dropdown"); Thread.sleep(2000);
					 * isElementPresent("LocType_id").sendKeys(Keys.DOWN);
					 * isElementPresent("LocType_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected 1st value"); logs.info("Selected 1st value");
					 * 
					 * // LocationName isElementPresent("LocName_id").sendKeys("AutoLocation");
					 * System.out.println("Enter Location"); logs.info("Enter LocationName");
					 * 
					 * 
					 * // AirportID isElementPresent("LocApID_xpath").sendKeys("ANY1");
					 * Thread.sleep(1000); isElementPresent("LocApID_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("LocApID_xpath").sendKeys(Keys.ENTER);
					 * 
					 * // Contact isElementPresent("LocContact_id").sendKeys("Ravina Prajapati");
					 * System.out.println("Enter Contact"); logs.info("Enter Contact");
					 * 
					 * // Phone isElementPresent("LocPhone_id").sendKeys("1234564564");
					 * System.out.println("Enter Phone"); logs.info("Enter Phone");
					 * 
					 * // Country Dropdown
					 * isElementPresent("LocCountry_id").sendKeys("United States");
					 * System.out.println("Enter value in COuntry dropdown"); Thread.sleep(2000);
					 * isElementPresent("LocCountry_id").sendKeys(Keys.DOWN);
					 * isElementPresent("LocCountry_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected United States value");
					 * logs.info("Selected United States value");
					 * 
					 * // Zip/PostalCode isElementPresent("LocZipCode_id").clear();
					 * isElementPresent("LocZipCode_id").sendKeys("60406");
					 * System.out.println("Entered value in Zip/PostalCode Field");
					 * logs.info("Entered value in Zip/PostalCode Field");
					 * isElementPresent("LocZipCode_id").sendKeys(Keys.TAB); Thread.sleep(2000);
					 * 
					 * // City isElementPresent("LocCity_id").clear();
					 * isElementPresent("LocCity_id").click(); Thread.sleep(2000);
					 * isElementPresent("LocCity_id").sendKeys(Keys.ARROW_DOWN);
					 * isElementPresent("LocCity_id").sendKeys(Keys.ENTER);
					 * System.out.println("Entered value in City");
					 * logs.info("Entered value in City");
					 * 
					 * // AddressLine1 isElementPresent("LocAddLine1_id").clear();
					 * isElementPresent("LocAddLine1_id").sendKeys("14101 Seeley Ave.");
					 * System.out.println("Entered value in AddressLine1");
					 * logs.info("Entered value in AddressLine1");
					 * 
					 * // ValidTo DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					 * Calendar cal = Calendar.getInstance(); cal.setTime(new Date());
					 * cal.add(Calendar.DATE, 10); String newDate =
					 * dateFormat.format(cal.getTime());
					 * isElementPresent("LocValidTo_xpath").sendKeys(newDate);
					 * System.out.println("Selected Date,10 days priorior from current Date");
					 * logs.info("Selected Date,10 days priorior from current Date");
					 * getScreenshot("LocationEdWithData1_", "Location", driver);
					 * 
					 * // AlertNote WebElement AlertNote = isElementPresent("LocAlertNote_id");
					 * js.executeScript("arguments[0].scrollIntoView();", AlertNote);
					 * AlertNote.clear(); isElementPresent("LocAlertNote_id").
					 * sendKeys("Automation Testing Location Alert");
					 * System.out.println("Entered value in AlertNote");
					 * logs.info("Entered value in AlertNote");
					 * 
					 * getScreenshot("LocationEdWithData2_", "Location", driver);
					 * 
					 * // Submit-Location WebElement SUb = isElementPresent("LocSubmit_id");
					 * js.executeScript("arguments[0].click();", SUb);
					 * System.out.println("Clicked on Submit button");
					 * System.out.println("SuccessfullMessage=" +
					 * isElementPresent("NoMsg_xpath").getText());
					 * logs.info("Clicked on Submit button"); logs.info("SuccessfullMessage=" +
					 * isElementPresent("NoMsg_xpath").getText());
					 * 
					 * wait.until(ExpectedConditions .invisibilityOfElementLocated(By.
					 * xpath("//*[@class=\"success dx-template-wrapper\"]")));
					 * 
					 * wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
					 * "//*[@class=\"dx-datagrid-content\"]/table")));
					 * 
					 */
					// Search=LocationName
					System.out.println("------------------------Testing Search------------------------");
					logs.info("------------------------Testing Search------------------------");
					highLight(isElementPresent("LocSearch_id"), driver);
					isElementPresent("LocSearch_id").sendKeys("AutoLocation");
					getScreenshot("LocSearch", "Location", driver);
					isElementPresent("LocSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Entered LocationName in Searchbox");
					logs.info("Entered LocationName in Searchbox");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					getScreenshot("LocSearchResultGrid_", "Location", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						System.out.println("------------------------Testing Edit------------------------");
						logs.info("------------------------Testing Edit------------------------");
						WebElement Edit = isElementPresent("Edit_xpath");
						highLight(isElementPresent("Edit_xpath"), driver);
						js.executeScript("arguments[0].click();", Edit);
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						getScreenshot("LocationEditor_", "Location", driver);

						// LocatioType Dropdown
						highLight(isElementPresent("LocType_id"), driver);
						isElementPresent("LocType_id").clear();
						isElementPresent("LocType_id").click();
						System.out.println("Clicked on Location Dropdown");
						Thread.sleep(2000);
						isElementPresent("LocType_id").sendKeys(Keys.DOWN);
						isElementPresent("LocType_id").sendKeys(Keys.ENTER);
						System.out.println("Selected 1st value");
						logs.info("Selected 1st value");

						// LocationName
						highLight(isElementPresent("LocName_id"), driver);
						isElementPresent("LocName_id").clear();
						isElementPresent("LocName_id").sendKeys("AutoLocation");
						System.out.println("Enter Location");
						logs.info("Enter LocationName");

						// Contact
						highLight(isElementPresent("LocContact_id"), driver);
						isElementPresent("LocContact_id").clear();
						isElementPresent("LocContact_id").sendKeys("Ravina Prajapati");
						System.out.println("Enter Contact");
						logs.info("Enter Contact");

						// Phone
						highLight(isElementPresent("LocPhone_id"), driver);
						isElementPresent("LocPhone_id").clear();
						isElementPresent("LocPhone_id").sendKeys("1234564564");
						System.out.println("Enter Phone");
						logs.info("Enter Phone");

						// Country Dropdown
						highLight(isElementPresent("LocCountry_id"), driver);
						isElementPresent("LocCountry_id").clear();
						isElementPresent("LocCountry_id").sendKeys("United States");
						System.out.println("Enter value in COuntry dropdown");
						Thread.sleep(2000);
						isElementPresent("LocCountry_id").sendKeys(Keys.DOWN);
						isElementPresent("LocCountry_id").sendKeys(Keys.ENTER);
						System.out.println("Selected United States value");
						logs.info("Selected United States value");

						// Zip/PostalCode
						highLight(isElementPresent("LocZipCode_id"), driver);
						isElementPresent("LocZipCode_id").clear();
						isElementPresent("LocZipCode_id").sendKeys("60406");
						System.out.println("Entered value in Zip/PostalCode Field");
						logs.info("Entered value in Zip/PostalCode Field");
						isElementPresent("LocZipCode_id").sendKeys(Keys.TAB);
						Thread.sleep(2000);

						// City
						highLight(isElementPresent("LocCity_id"), driver);
						isElementPresent("LocCity_id").clear();
						isElementPresent("LocCity_id").click();
						Thread.sleep(2000);
						isElementPresent("LocCity_id").sendKeys(Keys.ARROW_DOWN);
						isElementPresent("LocCity_id").sendKeys(Keys.ENTER);
						System.out.println("Entered value in City");
						logs.info("Entered value in City");

						// AddressLine1
						highLight(isElementPresent("LocAddLine1_id"), driver);
						isElementPresent("LocAddLine1_id").clear();
						isElementPresent("LocAddLine1_id").sendKeys("14101 Seeley Ave.");
						System.out.println("Entered value in AddressLine1");
						logs.info("Entered value in AddressLine1");

						// ValidTo
						highLight(isElementPresent("LocValidTo_xpath"), driver);
						isElementPresent("LocValidTo_xpath").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 10);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("LocValidTo_xpath").sendKeys(newDate);
						System.out.println("Selected Date,10 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");
						getScreenshot("LocationEdWithData1_", "Location", driver);

						// AlertNote
						WebElement AlertNote = isElementPresent("LocAlertNote_id");
						highLight(isElementPresent("LocAlertNote_id"), driver);
						js.executeScript("arguments[0].scrollIntoView();", AlertNote);
						AlertNote.clear();
						isElementPresent("LocAlertNote_id").sendKeys("Automation Testing Location Alert");
						System.out.println("Entered value in AlertNote");
						logs.info("Entered value in AlertNote");

						getScreenshot("LocationEdWithData2_", "Location", driver);

						// SUbmit
						WebElement SUb = isElementPresent("LocSubmit_id");
						highLight(isElementPresent("LocSubmit_id"), driver);
						wait.until(ExpectedConditions.elementToBeClickable(SUb));
						act.moveToElement(SUb).click().perform();
						js.executeScript("arguments[0].click();", SUb);
						act.moveToElement(SUb).click().perform();
						System.out.println("Clicked on Submit button");
						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Clicked on Submit button");
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						getScreenshot("LocSubmit", "Location", driver);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));

						waitForPageLoad();
					}
					// Search=LocationNo
					System.out.println("------------------------Testing Search------------------------");
					logs.info("------------------------Testing Search------------------------");
					highLight(isElementPresent("LocSearch_id"), driver);
					isElementPresent("LocSearch_id").clear();
					isElementPresent("LocSearch_id").sendKeys("AutoLocation");
					System.out.println("Entered LocationName in Searchbox");
					logs.info("Entered LocationName in Searchbox");
					getScreenshot("LocSearch", "Location", driver);
					isElementPresent("LocSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					getScreenshot("LocSearchResultGrid_", "Location", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Delete
						WebElement Del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						js.executeScript("arguments[0].click();", Del);
						System.out.println("Clicked on Delete button");
						getScreenshot("LocDelete_", "Location", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						logs.info("Clicked on Delete button");

						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// Keep it
						highLight(isElementPresent("DelKeepIt_xpath"), driver);
						isElementPresent("DelKeepIt_xpath").click();
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("LocDeleteKeepIT_", "Location", driver);
						waitForPageLoad();

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						Del = isElementPresent("Del_xpath");
						js.executeScript("arguments[0].click();", Del);
						System.out.println("Clicked on Delete button");

						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						logs.info("Clicked on Delete button");

						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// DeleteIt
						highLight(isElementPresent("Delbtn_xpath"), driver);
						isElementPresent("Delbtn_xpath").click();
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("LocDeleteDeleteIT_", "Location", driver);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					}
					// Clear Search
					highLight(isElementPresent("LocSearch_id"), driver);
					isElementPresent("LocSearch_id").clear();
					isElementPresent("LocSearch_id").sendKeys(Keys.ENTER);
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
					getScreenshot("SearchResultGrid_", "Location", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-SHWDeleted-Checked
					highLight(isElementPresent("LocShwInActive_id"), driver);
					isElementPresent("LocShwInActive_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InACtive is selected=="
							+ isElementPresent("LocShwInActive_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InACtive is selected=="
							+ isElementPresent("LocShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResultGridAfSHwInActive_", "Location", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-ShwDeleted-UnChecked
					highLight(isElementPresent("LocShwInActive_id"), driver);
					isElementPresent("LocShwInActive_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("LocShwInActive_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("LocShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResultGridShwInActUnchecked_", "Location", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]")));
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Activate the deleted location
					highLight(isElementPresent("LocSearch_id"), driver);
					isElementPresent("LocSearch_id").clear();
					isElementPresent("LocSearch_id").sendKeys("AutoLocation");
					getScreenshot("LocSearch", "Location", driver);
					System.out.println("Entered LocationName in Searchbox");
					logs.info("Entered LocationName in Searchbox");
					highLight(isElementPresent("LocShwInActive_id"), driver);
					isElementPresent("LocShwInActive_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("LocShwInActive_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("LocShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("LocSearchResultGrid_", "Location", driver);
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
						Thread.sleep(2000);
						getScreenshot("LocationEditor_", "Location", driver);

						// ValidTo
						highLight(isElementPresent("LocValidTo_xpath"), driver);
						isElementPresent("LocValidTo_xpath").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("LocValidTo_xpath").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");
						getScreenshot("LocationEdWithData1_", "Location", driver);

						// SUbmit
						WebElement SUb = isElementPresent("LocSubmit_id");
						highLight(isElementPresent("LocSubmit_id"), driver);
						wait.until(ExpectedConditions.elementToBeClickable(SUb));
						act.moveToElement(SUb).click().perform();
						js.executeScript("arguments[0].click();", SUb);
						act.moveToElement(SUb).click().perform();
						System.out.println("Clicked on Submit button");
						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Clicked on Submit button");
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						getScreenshot("LocSubmit", "Location", driver);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
						waitForPageLoad();

					}

				}
				// PageSize
				pageSize("Location");

				// Pagination
				pagination("Location");

				// NormalView
				normalView("Location");

				// click on columns
				columns("Location");

				break;
			} else {
				System.out.println("Carrier is not exist");
				logs.info("Carrier is not exist");
			}
		}

	}

}
