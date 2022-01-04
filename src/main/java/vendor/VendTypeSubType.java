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

public class VendTypeSubType extends BaseInit {

	@Test
	public void venTypeSubType() throws InterruptedException, IOException {
		System.out.println("--------------Testing VENDOR-VENDOR TYPE-SUBTYPE---------------");
		logs.info("--------------Testing VENDOR-VENDOR TYPE-SUBTYPE---------------");

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
				getScreenshot("Vendor_", "VendorTypeSubType", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VendorTypeSubType", driver);
				WebElement Search = isElementPresent("Search_id");
				highLight(isElementPresent("Search_id"), driver);
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "Vendor", driver);
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
					getScreenshot("Editor_", "Vendor", driver);

					// VendorTypeSubType
					highLight(isElementPresent("VendTST_xpath"), driver);
					isElementPresent("VendTST_xpath").click();
					System.out.println("Clicked on Vendor Type SubType menu");
					logs.info("Clicked on Vendor Type SubType menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VTSTScreen_", "VendorTypeSubType", driver);

					// Create
					System.out.println("------------------------Testing Create------------------------");
					logs.info("------------------------Testing Create------------------------");
					highLight(isElementPresent("VTSTCreate_id"), driver);
					isElementPresent("VTSTCreate_id").click();
					System.out.println("Clicked on Create button");
					logs.info("Clicked on Create button");
					waitForPageLoad();
					getScreenshot("VTSTCreate_", "VendorTypeSubType", driver);

					// Cancel
					highLight(isElementPresent("VTSTCancel_id"), driver);
					isElementPresent("VTSTCancel_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Search
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("VTSTSearch_id"), driver);
					isElementPresent("VTSTSearch_id").sendKeys("Facility Management");
					isElementPresent("VTSTSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Entered Day value in Searchbox");
					logs.info("Entered Day value in Searchbox");
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

						// Expand
						highLight(isElementPresent("VendTSTExpand_xpath"), driver);
						isElementPresent("VendTSTExpand_xpath").click();
						System.out.println("Clicked on Expand button");
						logs.info("Clicked on Expand button");

						// Edit
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(3000);
						getScreenshot("VTSTEdit_", "VendorTypeSubType", driver);

						// SUbmit
						WebElement Sub = isElementPresent("VTSTSubmit_id");
						wait.until(ExpectedConditions.elementToBeClickable(Sub));
						highLight(isElementPresent("VTSTSubmit_id"), driver);
						js.executeScript("arguments[0].click();", Sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");

						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						// Collapse
						WebElement COll = isElementPresent("VendTSTColla_xpath");
						highLight(isElementPresent("VendTSTColla_xpath"), driver);
						js.executeScript("arguments[0].click();", COll);
						System.out.println("Clicked on Collapse button");
						logs.info("Clicked on Collapse button");

					}
					// Filter
					highLight(isElementPresent("VTSTSearch_id"), driver);
					isElementPresent("VTSTSearch_id").clear();
					System.out.println("Cleared the search criteria");
					logs.info("Cleared the search criteria");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("VTSTFilter_id"), driver);
					isElementPresent("VTSTFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					getScreenshot("VTSTFilter_", "VendorTypeSubType", driver);
					highLight(isElementPresent("VTSTFVendGp_id"), driver);
					isElementPresent("VTSTFVendGp_id").click();
					isElementPresent("VTSTFVendGp_id").sendKeys("Facility Management");
					Thread.sleep(1000);
					isElementPresent("VTSTFVendGp_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from dropdown");
					logs.info("Selected  value from dropdown");
					WebElement ApFi = isElementPresent("VTSTAppFilter_id");
					highLight(isElementPresent("VTSTAppFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("VTSTFilterData_", "VendorTypeSubType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
						waitForPageLoad();

					}

					// Filter-ShwInACtive-checked
					highLight(isElementPresent("VTSTFilter_id"), driver);
					isElementPresent("VTSTFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					WebElement clear = isElementPresent("VTSTClearFilter_id");
					highLight(isElementPresent("VTSTClearFilter_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					isElementPresent("VTSTFShwInActive_id").click();
					System.out.println(
							"Show InActive is selected==" + isElementPresent("VTSTFShwInActive_id").isSelected());
					logs.info("Show InActive is selected==" + isElementPresent("VTSTFShwInActive_id").isSelected());
					getScreenshot("VTSTShwInActive_", "VendorTypeSubType", driver);
					ApFi = isElementPresent("VTSTAppFilter_id");
					highLight(isElementPresent("VTSTAppFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					getScreenshot("VTSTShwInActData_", "VendorTypeSubType", driver);
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
					highLight(isElementPresent("VTSTFilter_id"), driver);
					isElementPresent("VTSTFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("VTSTClearFilter_id");
					highLight(isElementPresent("VTSTClearFilter_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					ApFi = isElementPresent("VTSTAppFilter_id");
					highLight(isElementPresent("VTSTAppFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("VTSTGridAFClearF_", "VendorTypeSubType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}
					// Filter-Cancel
					highLight(isElementPresent("VTSTFilter_id"), driver);
					isElementPresent("VTSTFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					clear = isElementPresent("VTSTClearFilter_id");
					highLight(isElementPresent("VTSTClearFilter_id"), driver);
					js.executeScript("arguments[0].click();", clear);
					System.out.println("Clicked on Clear Filter button");
					logs.info("Clicked on Clear Filter button");
					WebElement Cancl = isElementPresent("VTSTFCancel_id");
					highLight(isElementPresent("VTSTFCancel_id"), driver);
					js.executeScript("arguments[0].click();", Cancl);
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");

					// Search Delete
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(isElementPresent("VTSTSearch_id"), driver);
					isElementPresent("VTSTSearch_id").sendKeys("Facility Management");
					isElementPresent("VTSTSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Searchbox");
					logs.info("Entered value in Searchbox");
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

						// Expand
						highLight(isElementPresent("VendTSTExpand_xpath"), driver);
						isElementPresent("VendTSTExpand_xpath").click();
						System.out.println("Clicked on Expand button");
						logs.info("Clicked on Expand button");

						// Delete
						WebElement Del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						Del.click();
						System.out.println("Clicked on Delete button");
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						getScreenshot("VTSTDelete_", "VendorTypeSubType", driver);

						// Keep it
						WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
						highLight(isElementPresent("DelKeepIt_xpath"), driver);
						js.executeScript("arguments[0].click();", KeepIt);
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("VTSTDltKeepIt_", "VendorTypeSubType", driver);

						// Delete
						Del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						Del.click();
						System.out.println("Clicked on Delete button");
						logs.info("Clicked on Delete button");
						Thread.sleep(1000);

						// DeleteIt
						WebElement DltIt = isElementPresent("Delbtn_xpath");
						wait.until(ExpectedConditions.elementToBeClickable(Del));
						highLight(isElementPresent("Delbtn_xpath"), driver);
						js.executeScript("arguments[0].click();", DltIt);
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("VTSTDeleteDltIT_", "VendorTypeSubType", driver);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					}

					// Activate the deleted record

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					highLight(isElementPresent("VTSTSearch_id"), driver);
					isElementPresent("VTSTSearch_id").clear();
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					isElementPresent("VTSTFilter_id").click();
					System.out.println("Clicked on Filter button");
					logs.info("Clicked on Filter button");
					highLight(isElementPresent("VTSTFShwInActive_id"), driver);
					isElementPresent("VTSTFShwInActive_id").click();
					System.out.println(
							"Show InActive is selected==" + isElementPresent("VTSTFShwInActive_id").isSelected());
					logs.info("Show InActive is selected==" + isElementPresent("VTSTFShwInActive_id").isSelected());
					getScreenshot("VTSTShwInActive_", "VendorTypeSubType", driver);
					ApFi = isElementPresent("VTSTAppFilter_id");
					highLight(isElementPresent("VTSTAppFilter_id"), driver);
					js.executeScript("arguments[0].click();", ApFi);
					System.out.println("Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					getScreenshot("VTSTEdit_", "VendorTypeSubType", driver);
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

						// Expand
						/*
						 * isElementPresent("VendTSTExpand_xpath").click();
						 * System.out.println("Clicked on Expand button");
						 * logs.info("Clicked on Expand button");
						 */

						// Edit
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);

						// To Date
						highLight(isElementPresent("VTSTValidTo_id"), driver);
						isElementPresent("VTSTValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VTSTValidTo_id").sendKeys(newDate);
						Thread.sleep(500);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,1000 days priorior from current Date");

						getScreenshot("VTSTEdtrwithData_", "VendorTypeSubType", driver);

						// SUbmit
						WebElement Sub = isElementPresent("VTSTSubmit_id");
						highLight(isElementPresent("VTSTSubmit_id"), driver);
						js.executeScript("arguments[0].click();", Sub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						// Collapse
						WebElement COll = isElementPresent("VendTSTColla_xpath");
						highLight(isElementPresent("VendTSTColla_xpath"), driver);
						js.executeScript("arguments[0].click();", COll);
						System.out.println("Clicked on Collapse button");
						logs.info("Clicked on Collapse button");

					}

					// NormalView---issue
					// normalView("VendorTypeSubType");

					// PageSize
					pageSize("VendorTypeSubType");

					// Pagination
					pagination("VendorTypeSubType");

					// click on columns
					columns("VendorTypeSubType");

					break;
				}
			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}

		}

	}
}
