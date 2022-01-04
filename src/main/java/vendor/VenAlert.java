package vendor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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

public class VenAlert extends BaseInit {

	@Test
	public void venAlert() throws InterruptedException, ParseException, IOException {
		System.out.println("--------------Testing VENDOR-Alert---------------");
		logs.info("--------------Testing VENDOR-Alert---------------");
		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

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
				getScreenshot("Vendor_", "VAlert", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VAlert", driver);
				WebElement Search = isElementPresent("Search_id");
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VAlert", driver);
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
					getScreenshot("Editor_", "VAlert", driver);

					// VAlert
					WebElement FHandling = isElementPresent("VAlert_xpath");
					highLight(isElementPresent("VAlert_xpath"), driver);
					act.moveToElement(FHandling).click().perform();
					System.out.println("Clicked on VAlert menu");
					logs.info("Clicked on VAlert menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendVAlertScreen_", "VAlert", driver);

					// -------- Create-Submit--------
					highLight(isElementPresent("VAlertSubmit_id"), driver);
					isElementPresent("VAlertSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					getScreenshot("CreateScreen_", "VAlert", driver);

					// Search
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VAlSearch_id"), driver);
					isElementPresent("VAlSearch_id").sendKeys("TSer10 (AutomationTestService)");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VAlert", driver);
					isElementPresent("VAlSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VAlert", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Cancel-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VAlert", driver);
						Thread.sleep(2000);

						// Cancel
						highLight(isElementPresent("VAlECancel_id"), driver);
						isElementPresent("VAlECancel_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// ---Edit-Save-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VAlert", driver);
						Thread.sleep(2000);

						// Save
						highLight(isElementPresent("VAlertSubmit_id"), driver);
						isElementPresent("VAlertSubmit_id").click();
						System.out.println("Clicked on Save button");
						logs.info("Clicked on Save button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VAlert", driver);
					}

					// Filter-ShwInACtive-checked
					highLight(isElementPresent("VAlSearch_id"), driver);
					isElementPresent("VAlSearch_id").clear();
					highLight(isElementPresent("VAlFilter_id"), driver);
					isElementPresent("VAlFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					WebElement clear = isElementPresent("VAlClearF_id");
					highLight(isElementPresent("VAlClearF_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					highLight(isElementPresent("VAlFShwInAct_id"), driver);
					isElementPresent("VAlFShwInAct_id").click();
					System.out
							.println("Show InActive is selected==" + isElementPresent("VAlFShwInAct_id").isSelected());
					logs.info("Show InActive is selected==" + isElementPresent("VAlFShwInAct_id").isSelected());
					getScreenshot("VAlertShwInActive_", "VendorTypeSubType", driver);
					WebElement ApFi = isElementPresent("VAlApFilter_id");
					highLight(isElementPresent("VAlApFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					getScreenshot("VAlertShwInActData_", "VendorTypeSubType", driver);
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-Clear Filter
					highLight(isElementPresent("VAlFilter_id"), driver);
					isElementPresent("VAlFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("VAlClearF_id");
					highLight(isElementPresent("VAlClearF_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					ApFi = isElementPresent("VAlApFilter_id");
					highLight(isElementPresent("VAlApFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("VAlertGridAFClearF_", "VendorTypeSubType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}
					// Filter-Cancel
					highLight(isElementPresent("VAlFilter_id"), driver);
					isElementPresent("VAlFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("VAlClearF_id");
					highLight(isElementPresent("VAlClearF_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					WebElement Cancl = isElementPresent("VAlCancelF_id");
					highLight(isElementPresent("VAlCancelF_id"), driver);
					js.executeScript("arguments[0].click();", Cancl);
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");

					// Search-Delete
					System.out.println("--------------Testing Delete---------------");
					highLight(isElementPresent("VAlSearch_id"), driver);
					isElementPresent("VAlSearch_id").clear();
					isElementPresent("VAlSearch_id").sendKeys("TSer10 (AutomationTestService)");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VAlert", driver);
					isElementPresent("VAlSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VAlert", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Delete
						WebElement del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						js.executeScript("arguments[0].click();", del);
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VAlert", driver);
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
						getScreenshot("DeleteKeepIT_", "VAlert", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// Delete
						del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						js.executeScript("arguments[0].click();", del);
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VAlert", driver);
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
						getScreenshot("DeleteDeleteIT_", "VAlert", driver);
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

					// -----ShowInActive-Checked--Activate deleted Record------------
					highLight(isElementPresent("VAlSearch_id"), driver);
					isElementPresent("VAlSearch_id").clear();
					isElementPresent("VAlSearch_id").sendKeys("TSer10 (AutomationTestService)");
					System.out.println("Entered value in Searchbox");
					logs.info("Entered value in Searchbox");
					highLight(isElementPresent("VAlFilter_id"), driver);
					isElementPresent("VAlFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("VAlClearF_id");
					highLight(isElementPresent("VAlClearF_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					isElementPresent("VAlFShwInAct_id").click();
					System.out
							.println("Show InActive is selected==" + isElementPresent("VAlFShwInAct_id").isSelected());
					logs.info("Show InActive is selected==" + isElementPresent("VAlFShwInAct_id").isSelected());
					getScreenshot("VAlertShwInActive_", "VendorTypeSubType", driver);
					ApFi = isElementPresent("VAlApFilter_id");
					highLight(isElementPresent("VAlApFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					getScreenshot("ShwInActiveChecked_", "VAlert", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VAlert", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Submit-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);
						WebElement Sname = isElementPresent("VAlSName_id");
						wait.until(ExpectedConditions.textToBePresentInElementValue(Sname, "TSer10"));

						// ValidTo
						highLight(isElementPresent("VAlCValidTo_id"), driver);
						isElementPresent("VAlCValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VAlCValidTo_id").sendKeys(newDate);
						// js.executeScript("arguments[0].value='" + newDate + "';", VTo);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,1000 days priorior from current Date");

						getScreenshot("AddressEdWithData1_", "VAlert", driver);

						// Save
						highLight(isElementPresent("VAlertSubmit_id"), driver);
						isElementPresent("VAlertSubmit_id").click();
						System.out.println("Clicked on Save button");
						logs.info("Clicked on Save button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VAlert", driver);

					}

					// ----Filter-ShowInActive-UnChecked------------
					highLight(isElementPresent("VAlSearch_id"), driver);
					isElementPresent("VAlSearch_id").clear();
					// ShowInActive
					highLight(isElementPresent("VAlFilter_id"), driver);
					isElementPresent("VAlFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("VAlClearF_id");
					highLight(isElementPresent("VAlClearF_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					ApFi = isElementPresent("VAlApFilter_id");
					highLight(isElementPresent("VAlApFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					getScreenshot("ShwInActiveChecked_", "VAlert", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VAlert", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// PageSize
					pageSize("VAlert");

					// pagination
					pagination("VAlert");

					// normalView
					normalView("VAlert");

					break;
				}

			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}

		}

	}
}
