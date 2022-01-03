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

public class CarrNotes extends BaseInit {
	@Test
	public void carrNotes() throws InterruptedException, IOException {
		System.out.println("--------------Testing CARRIER-NOTES---------------");
		logs.info("--------------Testing CARRIER-NOTES---------------");

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
		for (int count1 = 0; count1 < vendItem.size(); count1++) {
			String IName = vendItem.get(count1).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			logs.info("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Carrier")) {
				highLight(vendItem.get(count1), driver);
				vendItem.get(count1).click();
				System.out.println("clicked on Carrier");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				waitForPageLoad();

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
				getScreenshot("SearchData_", "Notes", driver);
				// SearchBTN
				WebElement Search = isElementPresent("VCorSearch_xpath");
				highLight(isElementPresent("VCorSearch_xpath"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Notes", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					waitForPageLoad();

					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					getScreenshot("CarrEditor_", "Notes", driver);

					// Notes
					highLight(isElementPresent("Notes_xpath"), driver);
					isElementPresent("Notes_xpath").click();
					System.out.println("Clicked on Notes menu");
					logs.info("Clicked on Notes menu");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					waitForPageLoad();
					getScreenshot("Notes_", "Notes", driver);

					// Create-Submit
					/*
					 * System.out.
					 * println("------------------------Testing Create------------------------");
					 * logs.info("------------------------Testing Create------------------------");
					 * isElementPresent("NoteCreate_id").click();
					 * System.out.println("Clicked on Create button");
					 * System.out.println("Title of the popup is==" +
					 * isElementPresent("NoCrePuHeading_xpath").getText());
					 * logs.info("Clicked on Create button"); logs.info("Title of the popup is==" +
					 * isElementPresent("NoCrePuHeading_xpath").getText());
					 * 
					 * getScreenshot("NotesEditor_", "Notes", driver); Thread.sleep(1000);
					 * 
					 * // Notes isElementPresent("NoNotes_xpath").click();
					 * isElementPresent("NoNotes_xpath").sendKeys("This is Testing Note");
					 * System.out.println("Entered value in Notes");
					 * logs.info("Entered value in Notes"); // ValidTo DateFormat dateFormat = new
					 * SimpleDateFormat("MM/dd/yyyy"); Calendar cal = Calendar.getInstance();
					 * cal.setTime(new Date()); cal.add(Calendar.DATE, 10); String newDate =
					 * dateFormat.format(cal.getTime());
					 * isElementPresent("NoteValidTo_id").sendKeys(newDate);
					 * System.out.println("Selected Date,10 days priorior from current Date");
					 * logs.info("Selected Date,10 days priorior from current Date");
					 * 
					 * getScreenshot("NotedEdwithData_", "Notes", driver);
					 * 
					 * // Submit isElementPresent("NoteSubmit_id").click();
					 * System.out.println("Clicked on Submit button");
					 * 
					 * System.out.println("SuccessfullMessage=" +
					 * isElementPresent("NoMsg_xpath").getText());
					 * 
					 * logs.info("Clicked on Submit button");
					 * 
					 * logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
					 * 
					 * wait.until(ExpectedConditions .invisibilityOfElementLocated(By.
					 * xpath("//*[@class=\"success dx-template-wrapper\"]")));
					 * 
					 * wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
					 * "//*[@class=\"dx-datagrid-content\"]/table")));
					 * 
					 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					 * "//*[@aria-label=\"Create\"]"))); getScreenshot("NotesGridAFterCreate_",
					 * "Notes", driver);
					 */
					// Create-Cancel
					System.out.println("------------------------Testing Create-Cancel------------------------");
					logs.info("------------------------Testing Create-Cancel------------------------");
					isElementPresent("NoteCreate_id").click();
					System.out.println("Clicked on Create button");
					logs.info("Clicked on Create button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label=\"Cancel\"]")));

					System.out.println("Title of the popup is==" + isElementPresent("NoCrePuHeading_xpath").getText());
					logs.info("Title of the popup is==" + isElementPresent("NoCrePuHeading_xpath").getText());

					// Cancel
					wait.until(ExpectedConditions.elementToBeClickable(By.id("btnnotecancel")));
					highLight(isElementPresent("NoteCancel_id"), driver);
					WebElement Cancl = isElementPresent("NoteCancel_id");
					js.executeScript("arguments[0].click();", Cancl);
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					getScreenshot("NotesCancel_", "Notes", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Create-Close
					System.out.println("------------------------Testing Create-Close------------------------");
					logs.info("------------------------Testing Create-Close------------------------");
					highLight(isElementPresent("NoteCreate_id"), driver);
					isElementPresent("NoteCreate_id").click();
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
					getScreenshot("NotesClose_", "Notes", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Search
					highLight(isElementPresent("NoteSearch_id"), driver);
					isElementPresent("NoteSearch_id").sendKeys("This is Testing Note");
					getScreenshot("SearchData_", "Notes", driver);
					isElementPresent("NoteSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Entered Notes value in Searchbox");
					logs.info("Entered Notes value in Searchbox");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "Notes", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						System.out.println("------------------------Testing Edit------------------------");
						logs.info("------------------------Testing Edit------------------------");
						highLight(isElementPresent("VCorEdit_xpath"), driver);
						isElementPresent("VCorEdit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						getScreenshot("NotesEditMode_", "Notes", driver);

						// Notes
						highLight(isElementPresent("NoNotes_xpath"), driver);
						isElementPresent("NoNotes_xpath").clear();
						isElementPresent("NoNotes_xpath").click();
						isElementPresent("NoNotes_xpath").sendKeys("This is Testing Note");
						System.out.println("Entered value in Notes");
						logs.info("Entered value in Notes");

						// ValidTo
						highLight(isElementPresent("NoteValidTo_id"), driver);
						isElementPresent("NoteValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("NoteValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,10 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("NotedEdwithData_", "Notes", driver);

						// SUbmit
						WebElement sub = isElementPresent("NoteSubmit_id");
						highLight(isElementPresent("NoteSubmit_id"), driver);
						js.executeScript("arguments[0].click();", sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));

						waitForPageLoad();

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");

						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");

						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						getScreenshot("NotesDelete_", "Notes", driver);

						// Keep it
						WebElement KeeptIT = isElementPresent("DelKeepIt_xpath");
						highLight(isElementPresent("DelKeepIt_xpath"), driver);
						js.executeScript("arguments[0].click();", KeeptIT);
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
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

						getScreenshot("NotesKeepIt_", "Notes", driver);

						// DeleteIt
						WebElement DeleteIT = isElementPresent("Delbtn_xpath");
						highLight(isElementPresent("Delbtn_xpath"), driver);
						js.executeScript("arguments[0].click();", DeleteIT);
						getScreenshot("NotesDeleteIT_", "Notes", driver);

						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");

						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					}
					// Clear
					highLight(isElementPresent("NoteSearch_id"), driver);
					isElementPresent("NoteSearch_id").clear();
					isElementPresent("NoteSearch_id").sendKeys(Keys.ENTER);
					getScreenshot("NotesClearSearch_", "Notes", driver);
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
					getScreenshot("SearchResult_", "Notes", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// Filter-ShwInACtive-Checked
					highLight(isElementPresent("NoteShwInActive_id"), driver);
					isElementPresent("NoteShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					getScreenshot("ShowInACtive_", "Notes", driver);

					System.out.println("Show InActive is selected=="
							+ isElementPresent("NoteShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("NoteShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "Notes", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// Filter-ShwInACtive-UnChecked
					highLight(isElementPresent("NoteShwInActive_id"), driver);
					isElementPresent("NoteShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					getScreenshot("ShowInACtive_", "Notes", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("NoteShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("NoteShwInActive_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "Notes", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// Activate the deleted record
					highLight(isElementPresent("NoteSearch_id"), driver);
					isElementPresent("NoteSearch_id").sendKeys("This is Testing Note");
					getScreenshot("SearchData_", "Notes", driver);
					highLight(isElementPresent("NoteShwInActive_id"), driver);
					isElementPresent("NoteShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					getScreenshot("ShowInACtive_", "Notes", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("NoteShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("NoteShwInActive_id").getAttribute("aria-checked"));

					System.out.println("Entered Notes value in Searchbox");
					logs.info("Entered Notes value in Searchbox");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "Notes", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						System.out.println("------------------------Testing Edit------------------------");
						logs.info("------------------------Testing Edit------------------------");
						highLight(isElementPresent("VCorEdit_xpath"), driver);
						isElementPresent("VCorEdit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("NotesEditMode_", "Notes", driver);
						Thread.sleep(2000);
						// Notes
						highLight(isElementPresent("NoNotes_xpath"), driver);
						isElementPresent("NoNotes_xpath").clear();
						isElementPresent("NoNotes_xpath").click();
						isElementPresent("NoNotes_xpath").sendKeys("This is Testing Note");
						System.out.println("Entered value in Notes");
						logs.info("Entered value in Notes");

						// ValidTo
						highLight(isElementPresent("NoteValidTo_id"), driver);
						isElementPresent("NoteValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("NoteValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,10 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("NotedEdwithData_", "Notes", driver);

						// SUbmit
						WebElement sub = isElementPresent("NoteSubmit_id");
						highLight(isElementPresent("NoteSubmit_id"), driver);
						js.executeScript("arguments[0].click();", sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));

					}

					// PageSize
					pageSize("Notes");

					// Pagination
					pagination("Notes");

					// NormalView
					normalView("Notes");

					// columns
					columns("Notes");

					break;
				}
			} else {
				System.out.println("Carrier is not exist");
				logs.info("Carrier is not exist");
			}
		}

	}
}
