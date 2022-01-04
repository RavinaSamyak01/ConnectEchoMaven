package vendor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class VenAddress extends BaseInit {
	@Test
	public void venAddress() throws InterruptedException, IOException {

		System.out.println("--------------Testing VENDOR-ADDRESS---------------");
		logs.info("--------------Testing VENDOR-ADDRESS---------------");
		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
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
				getScreenshot("Vendor_", "VendorAddress", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VendorAddress", driver);
				WebElement Search = isElementPresent("Search_id");
				highLight(isElementPresent("Search_id"), driver);
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VendorAddress", driver);
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
					getScreenshot("Editor_", "VendorAddress", driver);

					// Address
					highLight(isElementPresent("VendAddress_xpath"), driver);
					isElementPresent("VendAddress_xpath").click();
					System.out.println("Clicked on Address menu");
					logs.info("Clicked on Address menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendAddressScreen_", "VendorAddress", driver);

					// -------- Create-Back--------
					highLight(isElementPresent("VAddCreate_id"), driver);
					isElementPresent("VAddCreate_id").click();
					System.out.println("Clicked on create button");
					logs.info("Clicked on create button");
					wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("VAddBack_id")));
					getScreenshot("CreateScreen_", "VendorAddress", driver);

					// Back
					highLight(isElementPresent("VAddBack_id"), driver);
					isElementPresent("VAddBack_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Search
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VAddSearch_id"), driver);
					isElementPresent("VAddSearch_id").sendKeys("60406");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VendorAddress", driver);
					highLight(isElementPresent("VAddSearch_id"), driver);
					isElementPresent("VAddSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorAddress", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Back-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VendorAddress", driver);
						Thread.sleep(2000);
						// Back
						highLight(isElementPresent("VAddBack_id"), driver);
						isElementPresent("VAddBack_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						getScreenshot("SubmitCancel_", "VendorAddress", driver);

						// ---Edit-Submit-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);

						// AddressType
						highLight(isElementPresent("VAddType_id"), driver);
						isElementPresent("VAddType_id").clear();
						isElementPresent("VAddType_id").click();
						System.out.println("clicked on AddressType Dropdown");
						logs.info("clicked on AddressType Dropdown");
						Thread.sleep(1000);
						isElementPresent("VAddType_id").sendKeys(Keys.DOWN);
						isElementPresent("VAddType_id").sendKeys(Keys.ENTER);
						System.out.println("Selected Address Type");
						logs.info("Selected Address Type");

						// Country Dropdown
						highLight(isElementPresent("VAddCountry_id"), driver);
						isElementPresent("VAddCountry_id").clear();
						isElementPresent("VAddCountry_id").sendKeys("United States");
						System.out.println("Enter value in COuntry dropdown");
						Thread.sleep(2000);
						isElementPresent("VAddCountry_id").sendKeys(Keys.DOWN);
						isElementPresent("VAddCountry_id").sendKeys(Keys.ENTER);
						System.out.println("Selected United States value");
						logs.info("Selected United States value");

						// Zip/PostalCode
						highLight(isElementPresent("VAddZipCode_id"), driver);
						isElementPresent("VAddZipCode_id").clear();
						isElementPresent("VAddZipCode_id").sendKeys("60406");
						System.out.println("Entered value in Zip/PostalCode Field");
						logs.info("Entered value in Zip/PostalCode Field");
						isElementPresent("VAddZipCode_id").sendKeys(Keys.TAB);
						Thread.sleep(2000);

						// City
						highLight(isElementPresent("VAddCity_id"), driver);
						isElementPresent("VAddCity_id").clear();
						isElementPresent("VAddCity_id").click();
						Thread.sleep(2000);
						isElementPresent("VAddCity_id").sendKeys(Keys.ARROW_DOWN);
						isElementPresent("VAddCity_id").sendKeys(Keys.ENTER);
						System.out.println("Entered value in City");
						logs.info("Entered value in City");

						// AddressLine1
						highLight(isElementPresent("VAddLine1_id"), driver);
						isElementPresent("VAddLine1_id").clear();
						isElementPresent("VAddLine1_id").sendKeys("14101 Seeley Ave.");
						System.out.println("Entered value in AddressLine1");
						logs.info("Entered value in AddressLine1");

						// ValidTo
						highLight(isElementPresent("VAddValidTo_id"), driver);
						isElementPresent("VAddValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VAddValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("AddressEdWithData1_", "VendorAddress", driver);

						// Submit
						highLight(isElementPresent("VAddSubmit_id"), driver);
						isElementPresent("VAddSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VendorAddress", driver);

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VendorAddress", driver);
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
						getScreenshot("DeleteKeepIT_", "VendorAddress", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VendorAddress", driver);
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
						getScreenshot("DeleteDeleteIT_", "VendorAddress", driver);
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
					// ----------Filter-Cancel----------
					highLight(isElementPresent("VAddSearch_id"), driver);
					isElementPresent("VAddSearch_id").clear();
					isElementPresent("VAddFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					getScreenshot("Filter_", "VendorAddress", driver);

					// Cancel
					highLight(isElementPresent("VAddFCancel_id"), driver);
					isElementPresent("VAddFCancel_id").click();
					System.out.println("clicked on Cancel button");
					logs.info("clicked on Cancel button");
					getScreenshot("FilterCancel_", "VendorAddress", driver);

					// ----Filter-ApplyFilter------------
					/*
					 * isElementPresent("VAddFilter_id").click();
					 * System.out.println("clicked on Filter popup");
					 * logs.info("clicked on Filter popup");
					 * 
					 * // AddressType isElementPresent("VAddFAddType_id").click();
					 * System.out.println("clicked on AddressType Dropdown");
					 * logs.info("clicked on AddressType Dropdown"); Thread.sleep(1000);
					 * isElementPresent("VAddFAddType_id").sendKeys(Keys.DOWN);
					 * isElementPresent("VAddFAddType_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected Address Type");
					 * logs.info("Selected Address Type");
					 * 
					 * // Country Dropdown
					 * isElementPresent("VAddFCountry_id").sendKeys("United States");
					 * System.out.println("Enter value in COuntry dropdown"); Thread.sleep(2000);
					 * isElementPresent("VAddFCountry_id").sendKeys(Keys.DOWN);
					 * isElementPresent("VAddFCountry_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected United States value");
					 * logs.info("Selected United States value");
					 * 
					 * // Zip/PostalCode isElementPresent("VAddFZipCode_id").clear();
					 * isElementPresent("VAddFZipCode_id").sendKeys("60406");
					 * System.out.println("Entered value in Zip/PostalCode Field");
					 * logs.info("Entered value in Zip/PostalCode Field");
					 * isElementPresent("VAddFZipCode_id").sendKeys(Keys.TAB); Thread.sleep(2000);
					 * 
					 * // City isElementPresent("VAddFCity_id").sendKeys("Dixmoor");
					 * System.out.println("Entered value in City");
					 * logs.info("Entered value in City");
					 * 
					 * getScreenshot("FilterData_", "VendorAddress", driver);
					 * 
					 * // ApplyFilter isElementPresent("VAddApplyFil_id").click();
					 * System.out.println("Clicked on ApplyFilter");
					 * logs.info("Clicked on ApplyFilter"); getScreenshot("ApplyFilter_",
					 * "VendorAddress", driver); ImageFile =
					 * isElementPresent("ApNoDataImage_xpath"); wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")))
					 * ; wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
					 * "//*[@class=\"dx-datagrid-content\"]/table"))); Data =
					 * isElementPresent("GridRecord_xpath").getText();
					 * System.out.println("searched data is" + " " + Data);
					 * logs.info("searched data is" + " " + Data); getScreenshot("SearchResult_",
					 * "VendorAddress", driver); if (ImageFile.isDisplayed()) {
					 * System.out.println("There is not any data related enetered search parameters"
					 * ); logs.info("There is not any data related enetered search parameters");
					 * 
					 * } else {
					 * System.out.println("Data is present related enetered search parameters");
					 * logs.info("Data is present related enetered search parameters"); }
					 */
					// ----Filter-ClearFilter------------Not implemented clear filter
					/*
					 * isElementPresent("VAddFilter_id").click();
					 * System.out.println("clicked on Filter popup");
					 * logs.info("clicked on Filter popup"); // ClearFilter
					 * isElementPresent("VTSTClearFilter_id").click();
					 * System.out.println("Clicked on Clear Filter");
					 * logs.info("Clicked on Clear Filter"); getScreenshot("ClearFilter",
					 * "VendorAddress", driver); // ApplyFilter
					 * isElementPresent("VTSTAppFilter_id").click();
					 * System.out.println("Clicked on ApplyFilter");
					 * logs.info("Clicked on ApplyFilter"); ImageFile =
					 * isElementPresent("ApNoDataImage_xpath"); wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")))
					 * ; wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
					 * "//*[@class=\"dx-datagrid-content\"]/table"))); Data =
					 * isElementPresent("GridRecord_xpath").getText();
					 * System.out.println("searched data is" + " " + Data);
					 * logs.info("searched data is" + " " + Data); getScreenshot("SearchResult_",
					 * "VendorAddress", driver); if (ImageFile.isDisplayed()) {
					 * System.out.println("There is not any data related enetered search parameters"
					 * ); logs.info("There is not any data related enetered search parameters");
					 * 
					 * } else {
					 * System.out.println("Data is present related enetered search parameters");
					 * logs.info("Data is present related enetered search parameters"); }
					 */

					// ----Filter-ShowInActive-Checked--Activate deleted Record------------
					highLight(isElementPresent("VAddFilter_id"), driver);
					isElementPresent("VAddFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					Thread.sleep(1000);
					// ShowInACtive
					highLight(isElementPresent("VAddFShwInActive_id"), driver);
					isElementPresent("VAddFShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					Thread.sleep(1000);
					getScreenshot("ShowInACtive_", "VendorAddress", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveChecked_", "VendorAddress", driver);
					// ApplyFilter
					highLight(isElementPresent("VAddApplyFil_id"), driver);
					isElementPresent("VAddApplyFil_id").click();
					System.out.println("Clicked on ApplyFilter");
					logs.info("Clicked on ApplyFilter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorAddress", driver);
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

						// ValidTo
						highLight(isElementPresent("VAddValidTo_id"), driver);
						isElementPresent("VAddValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VAddValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("AddressEdWithData1_", "VendorAddress", driver);

						// Submit
						highLight(isElementPresent("VAddSubmit_id"), driver);
						isElementPresent("VAddSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VendorAddress", driver);

					}

					// ----Filter-ShowInActive-UnChecked------------
					highLight(isElementPresent("VAddFilter_id"), driver);
					isElementPresent("VAddFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					// ShowInACtive
					highLight(isElementPresent("VAddFShwInActive_id"), driver);
					isElementPresent("VAddFShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					getScreenshot("ShowInACtive_", "VendorAddress", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveUnchecked_", "VendorAddress", driver);
					// ApplyFilter
					highLight(isElementPresent("VAddApplyFil_id"), driver);
					isElementPresent("VAddApplyFil_id").click();
					System.out.println("Clicked on ApplyFilter");
					logs.info("Clicked on ApplyFilter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorAddress", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// PageSize
					pageSize("VendorAddress");

					// pagination
					pagination("VendorAddress");

					// normalView
					normalView("VendorAddress");

					break;
				}

			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}

		}

	}
}
