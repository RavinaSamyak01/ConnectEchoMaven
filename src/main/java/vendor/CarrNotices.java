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

public class CarrNotices extends BaseInit {

	@Test
	public void carrNotices() throws InterruptedException, IOException {
		System.out.println("--------------Testing CARRIER-NOTICES---------------");
		logs.info("--------------Testing CARRIER-NOTICES---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Main Vendor menu
		highLight(isElementPresent("MainVendor_xpath"), driver);
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		logs.info("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"sidenav\"]/ul/li")));
		getScreenshot("MainVendorMenu", "Notice", driver);
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
				getScreenshot("Carrier_", "Notice", driver);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				waitForPageLoad();
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
				getScreenshot("SearchData_", "Notice", driver);
				// SearchBTN
				WebElement Search = isElementPresent("VCorSearch_xpath");
				highLight(isElementPresent("VCorSearch_xpath"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Notice", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					waitForPageLoad();

					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					getScreenshot("CarrEditor_", "Notice", driver);

					// Notices
					highLight(isElementPresent("Notices_xpath"), driver);
					isElementPresent("Notices_xpath").click();
					System.out.println("Clicked on Notices menu");
					logs.info("Clicked on Notices menu");
					waitForPageLoad();
					getScreenshot("NoticeScreen_", "Notice", driver);

					// Create-Cancel
					System.out.println("--------Testing Create-Cancel--------");
					logs.info("------Testing Create-Cancel---------");
					highLight(isElementPresent("Notices_xpath"), driver);
					isElementPresent("NoticesCreate_id").click();
					System.out.println("Clicked on Create button");
					logs.info("Clicked on Create button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Cancel\"]")));

					System.out.println("Title of the popup is==" + isElementPresent("NoCrePuHeading_xpath").getText());
					logs.info("Title of the popup is==" + isElementPresent("NoCrePuHeading_xpath").getText());

					// Cancel
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label=\"Cancel\"]")));
					WebElement Cancl = isElementPresent("NoticeCancel_id");
					highLight(isElementPresent("NoticeCancel_id"), driver);
					js.executeScript("arguments[0].click();", Cancl);
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					waitForPageLoad();
					getScreenshot("CreateCancel_", "Notice", driver);

					// Create-Close
					System.out.println("------------------------Testing Create-Close------------------------");
					logs.info("------------------------Testing Create-Close------------------------");
					highLight(isElementPresent("NoticesCreate_id"), driver);
					isElementPresent("NoticesCreate_id").click();
					System.out.println("Clicked on Create button");
					logs.info("Clicked on Create button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"close\"]")));

					System.out.println("Title of the popup is==" + isElementPresent("NoCrePuHeading_xpath").getText());
					logs.info("Title of the popup is==" + isElementPresent("NoCrePuHeading_xpath").getText());
					// Close
					WebElement Close = isElementPresent("NoClose_xpath");
					highLight(isElementPresent("NoClose_xpath"), driver);
					js.executeScript("arguments[0].click();", Close);
					System.out.println("Clicked on Close button");
					logs.info("Clicked on Close button");
					waitForPageLoad();
					getScreenshot("CreateClose_", "Notice", driver);

					// Search
					highLight(isElementPresent("NoticeSearch_id"), driver);
					isElementPresent("NoticeSearch_id").sendKeys(Keys.ENTER);
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
					getScreenshot("SearchResultGrid_", "Notice", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						System.out.println("--------Testing Edit------------");
						logs.info("---------Testing Edit------------");
						WebElement Edit = isElementPresent("Edit_xpath");
						highLight(isElementPresent("Edit_xpath"), driver);
						js.executeScript("arguments[0].click();", Edit);
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						getScreenshot("Editor_", "Notice", driver);

						// ValidTo
						highLight(isElementPresent("NoticeValidTo_id"), driver);
						isElementPresent("NoticeValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("NoticeValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,10 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						// Notes
						highLight(isElementPresent("NotiNotes_xpath"), driver);
						isElementPresent("NotiNotes_xpath").clear();
						isElementPresent("NotiNotes_xpath").sendKeys("This is Testing Notice for Automation");
						System.out.println("Entered value in Notes");
						logs.info("Entered value in Notes");

						getScreenshot("CreateData_", "Notice", driver);

						// SUbmit
						highLight(isElementPresent("NoticeSubmit_id"), driver);
						isElementPresent("NoticeSubmit_id").click();
						// js.executeScript("arguments[0].click();", sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");
						logs.info("Clicked on Delete button");
						getScreenshot("NoticeDelete_", "Notice", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// Keep it
						highLight(isElementPresent("DelKeepIt_xpath"), driver);
						isElementPresent("DelKeepIt_xpath").click();
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("NoticeKeepIT_", "Notice", driver);
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// DeleteIt
						WebElement DelIT = isElementPresent("Delbtn_xpath");
						highLight(isElementPresent("Delbtn_xpath"), driver);
						js.executeScript("arguments[0].click();", DelIT);
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("NoticeDeleteIT_", "Notice", driver);
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					}
				}

				// Clear Search
				highLight(isElementPresent("NoticeSearch_id"), driver);
				isElementPresent("NoticeSearch_id").clear();
				isElementPresent("NoticeSearch_id").sendKeys(Keys.ENTER);
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
				getScreenshot("SearchResultGrid_", "Notice", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Filter-ShwInACtive-Checked
				highLight(isElementPresent("NoticeShwInActive_id"), driver);
				isElementPresent("NoticeShwInActive_id").click();
				System.out.println("Clicked on ShowInActive checkbox");
				logs.info("Clicked on ShowInActive checkbox");
				System.out.println("Show InActive is selected=="
						+ isElementPresent("NoticeShwInActive_id").getAttribute("aria-checked"));
				logs.info("Show InActive is selected=="
						+ isElementPresent("NoticeShwInActive_id").getAttribute("aria-checked"));
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultGrid_", "Notice", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}
				// Filter-ShwInACtive-UnChecked
				highLight(isElementPresent("NoticeShwInActive_id"), driver);
				isElementPresent("NoticeShwInActive_id").click();
				System.out.println("Clicked on ShowInActive checkbox");
				System.out.println("Show InActive is selected=="
						+ isElementPresent("NoticeShwInActive_id").getAttribute("aria-checked"));
				logs.info("Clicked on ShowInActive checkbox");
				logs.info("Show InActive is selected=="
						+ isElementPresent("NoticeShwInActive_id").getAttribute("aria-checked"));
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultGrid_", "Notice", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Activate the deleted record
				highLight(isElementPresent("NoticeSearch_id"), driver);
				isElementPresent("NoticeSearch_id").clear();
				isElementPresent("NoticeSearch_id").sendKeys("ANY1");
				System.out.println("Entered value in Searchbox");
				logs.info("Entered value in Searchbox");
				highLight(isElementPresent("NoticeShwInActive_id"), driver);
				isElementPresent("NoticeShwInActive_id").click();
				System.out.println("Clicked on ShowInActive checkbox");
				System.out.println("Show InActive is selected=="
						+ isElementPresent("NoticeShwInActive_id").getAttribute("aria-checked"));
				logs.info("Clicked on ShowInActive checkbox");
				logs.info("Show InActive is selected=="
						+ isElementPresent("NoticeShwInActive_id").getAttribute("aria-checked"));
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultGrid_", "Notice", driver);
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
					getScreenshot("Editor_", "Notice", driver);
					Thread.sleep(2000);
					// ValidTo
					highLight(isElementPresent("NoticeValidTo_id"), driver);
					isElementPresent("NoticeValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("NoticeValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,10 days priorior from current Date");

					// Notes
					highLight(isElementPresent("NotiNotes_xpath"), driver);
					isElementPresent("NotiNotes_xpath").clear();
					isElementPresent("NotiNotes_xpath").sendKeys("This is Testing Notice for Automation");
					System.out.println("Entered value in Notes");
					logs.info("Entered value in Notes");

					getScreenshot("CreateData_", "Notice", driver);

					// SUbmit
					highLight(isElementPresent("NoticeSubmit_id"), driver);
					isElementPresent("NoticeSubmit_id").click();
					// js.executeScript("arguments[0].click();", sub);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					waitForPageLoad();

				}

				// PageSize
				pageSize("Notice");

				// Pagination
				pagination("Notice");

				// NormalView
				normalView("Notice");

				// Columns
				columns("Notice");

				break;
			} else {
				System.out.println("Carrier is not exist");
				logs.info("Carrier is not exist");
			}

		}

	}

}
