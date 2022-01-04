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

public class IntMIntegratorService extends BaseInit {
	//-------------Remaining because ID is not there------------

	@Test
	public void intMIntegratorService() throws InterruptedException, IOException {
		System.out.println("--------------Testing IntMaster-Integrator Services---------------");
		logs.info("--------------Testing IntMaster-Integrator Services---------------");
		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Actions act = new Actions(driver);

		// Main Vendor menu
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		logs.info("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"sidenav\"]/ul/li")));

		WebElement vendordiv = isElementPresent("VCorDiv_xpath");
		List<WebElement> vendItem = vendordiv.findElements(By.className("dx-button-content"));
		for (int count1 = 0; count1 < vendItem.size(); count1++) {
			String IName = vendItem.get(count1).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			logs.info("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Integrator Master")) {
				vendItem.get(count1).click();
				System.out.println("clicked on Integrator Master");
				logs.info("clicked on Integrator Master");
				waitForPageLoad();
				getScreenshot("IntegratorMaster_", "IntegratorMaster", driver);

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Internal MNX Name
				isElementPresent("IMSMNXIntName_xpath").sendKeys("MNX RJ");
				System.out.println("Entered value in Internal MNX Name");
				logs.info("Entered value in Internal MNX Name");
				// Account
				isElementPresent("IMSACNo_xpath").sendKeys("IMAC01");
				System.out.println("Entered value in Account");
				logs.info("Entered value in Account");
				getScreenshot("IntMSearchData_", "IntegratorMaster", driver);

				// SearchBTN
				isElementPresent("IMSearch_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("IntMSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					waitForPageLoad();
					getScreenshot("IntMEditMode_", "IntegratorMaster", driver);

					// Integrator Services
					isElementPresent("IMIService_xpath").click();
					System.out.println("Clicked on Integrator Services menu");
					logs.info("Clicked on Integrator Services menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendIntegrator ServicesScreen_", "IntMIntServices", driver);

					// -------- Create-Back--------
					isElementPresent("VAddCreate_id").click();
					System.out.println("Clicked on create button");
					logs.info("Clicked on create button");
					wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("VAddBack_id")));
					getScreenshot("CreateScreen_", "IntMIntServices", driver);

					// Back
					isElementPresent("VAddBack_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// -------- Create-Submit--------
					/*
					 * isElementPresent("VAddCreate_id").click();
					 * System.out.println("Clicked on create button");
					 * logs.info("Clicked on create button");
					 * 
					 * // Integrator ServicesType isElementPresent("VAddType_id").click();
					 * System.out.println("clicked on Integrator ServicesType Dropdown");
					 * logs.info("clicked on Integrator ServicesType Dropdown"); Thread.sleep(1000);
					 * isElementPresent("VAddType_id").sendKeys(Keys.DOWN);
					 * isElementPresent("VAddType_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected Integrator Services Type");
					 * logs.info("Selected Integrator Services Type");
					 * 
					 * // Country Dropdown
					 * isElementPresent("VAddCountry_id").sendKeys("United States");
					 * System.out.println("Enter value in COuntry dropdown"); Thread.sleep(2000);
					 * isElementPresent("VAddCountry_id").sendKeys(Keys.DOWN);
					 * isElementPresent("VAddCountry_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected United States value");
					 * logs.info("Selected United States value");
					 * 
					 * // Zip/PostalCode isElementPresent("VAddZipCode_id").clear();
					 * isElementPresent("VAddZipCode_id").sendKeys("60406");
					 * System.out.println("Entered value in Zip/PostalCode Field");
					 * logs.info("Entered value in Zip/PostalCode Field");
					 * isElementPresent("VAddZipCode_id").sendKeys(Keys.TAB); Thread.sleep(2000);
					 * 
					 * // City isElementPresent("VAddCity_id").clear();
					 * isElementPresent("VAddCity_id").click(); Thread.sleep(2000);
					 * isElementPresent("VAddCity_id").sendKeys(Keys.ARROW_DOWN);
					 * isElementPresent("VAddCity_id").sendKeys(Keys.ENTER);
					 * System.out.println("Entered value in City");
					 * logs.info("Entered value in City");
					 * 
					 * // Integrator ServicesLine1 isElementPresent("VAddLine1_id").clear();
					 * isElementPresent("VAddLine1_id").sendKeys("14101 Seeley Ave.");
					 * System.out.println("Entered value in Integrator ServicesLine1");
					 * logs.info("Entered value in Integrator ServicesLine1");
					 * 
					 * // ValidTo DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					 * Calendar cal = Calendar.getInstance(); cal.setTime(new Date());
					 * cal.add(Calendar.DATE, 10); String newDate =
					 * dateFormat.format(cal.getTime());
					 * isElementPresent("VAddValidTo_id").sendKeys(newDate);
					 * System.out.println("Selected Date,10 days priorior from current Date");
					 * logs.info("Selected Date,10 days priorior from current Date");
					 * 
					 * getScreenshot("Integrator ServicesEdWithData1_", "IntMIntServices", driver);
					 * 
					 * // Submit isElementPresent("VAddSubmit_id").click();
					 * System.out.println("Clicked on Submit button");
					 * logs.info("Clicked on Submit button"); wait.until(
					 * ExpectedConditions.visibilityOfElementLocated(By.
					 * xpath("//*[@aria-label=\"Data grid\"]")));
					 * 
					 * getScreenshot("Submit_", "IntMIntServices", driver);
					 */

					// Search
					System.out.println("--------------Testing search---------------");
					isElementPresent("VAddSearch_id").sendKeys("60406");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "IntMIntServices", driver);
					isElementPresent("VAddSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "IntMIntServices", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Back-----
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "IntMIntServices", driver);
						Thread.sleep(2000);
						// Back
						isElementPresent("VAddBack_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						getScreenshot("SubmitCancel_", "IntMIntServices", driver);

						// ---Edit-Submit-----
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);

						// Integrator ServicesType
						isElementPresent("VAddType_id").clear();
						isElementPresent("VAddType_id").click();
						System.out.println("clicked on Integrator ServicesType Dropdown");
						logs.info("clicked on Integrator ServicesType Dropdown");
						Thread.sleep(1000);
						isElementPresent("VAddType_id").sendKeys(Keys.DOWN);
						isElementPresent("VAddType_id").sendKeys(Keys.ENTER);
						System.out.println("Selected Integrator Services Type");
						logs.info("Selected Integrator Services Type");

						// Country Dropdown
						isElementPresent("VAddCountry_id").clear();
						isElementPresent("VAddCountry_id").sendKeys("United States");
						System.out.println("Enter value in COuntry dropdown");
						Thread.sleep(2000);
						isElementPresent("VAddCountry_id").sendKeys(Keys.DOWN);
						isElementPresent("VAddCountry_id").sendKeys(Keys.ENTER);
						System.out.println("Selected United States value");
						logs.info("Selected United States value");

						// Zip/PostalCode
						isElementPresent("VAddZipCode_id").clear();
						isElementPresent("VAddZipCode_id").sendKeys("60406");
						System.out.println("Entered value in Zip/PostalCode Field");
						logs.info("Entered value in Zip/PostalCode Field");
						isElementPresent("VAddZipCode_id").sendKeys(Keys.TAB);
						Thread.sleep(2000);

						// City
						isElementPresent("VAddCity_id").clear();
						isElementPresent("VAddCity_id").click();
						Thread.sleep(2000);
						isElementPresent("VAddCity_id").sendKeys(Keys.ARROW_DOWN);
						isElementPresent("VAddCity_id").sendKeys(Keys.ENTER);
						System.out.println("Entered value in City");
						logs.info("Entered value in City");

						// Integrator ServicesLine1
						isElementPresent("VAddLine1_id").clear();
						isElementPresent("VAddLine1_id").sendKeys("14101 Seeley Ave.");
						System.out.println("Entered value in Integrator ServicesLine1");
						logs.info("Entered value in Integrator ServicesLine1");

						// ValidTo
						isElementPresent("VAddValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VAddValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("Integrator ServicesEdWithData1_", "IntMIntServices", driver);

						// Submit
						isElementPresent("VAddSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "IntMIntServices", driver);

						// Delete
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "IntMIntServices", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// Keep it
						isElementPresent("DelKeepIt_xpath").click();
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("DeleteKeepIT_", "IntMIntServices", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// Delete
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "IntMIntServices", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// DeleteIt
						isElementPresent("Delbtn_xpath").click();
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("DeleteDeleteIT_", "IntMIntServices", driver);
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
					isElementPresent("VAddSearch_id").clear();
					isElementPresent("VAddFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					getScreenshot("Filter_", "IntMIntServices", driver);

					// Cancel
					isElementPresent("VAddFCancel_id").click();
					System.out.println("clicked on Cancel button");
					logs.info("clicked on Cancel button");
					getScreenshot("FilterCancel_", "IntMIntServices", driver);

					// ----Filter-ApplyFilter------------
					/*
					 * isElementPresent("VAddFilter_id").click();
					 * System.out.println("clicked on Filter popup");
					 * logs.info("clicked on Filter popup");
					 * 
					 * // Integrator ServicesType isElementPresent("VAddFAddType_id").click();
					 * System.out.println("clicked on Integrator ServicesType Dropdown");
					 * logs.info("clicked on Integrator ServicesType Dropdown"); Thread.sleep(1000);
					 * isElementPresent("VAddFAddType_id").sendKeys(Keys.DOWN);
					 * isElementPresent("VAddFAddType_id").sendKeys(Keys.ENTER);
					 * System.out.println("Selected Integrator Services Type");
					 * logs.info("Selected Integrator Services Type");
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
					 * getScreenshot("FilterData_", "IntMIntServices", driver);
					 * 
					 * // ApplyFilter isElementPresent("VAddApplyFil_id").click();
					 * System.out.println("Clicked on ApplyFilter");
					 * logs.info("Clicked on ApplyFilter"); getScreenshot("ApplyFilter_",
					 * "IntMIntServices", driver); ImageFile =
					 * isElementPresent("ApNoDataImage_xpath"); wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")))
					 * ; wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
					 * "//*[@class=\"dx-datagrid-content\"]/table"))); Data =
					 * isElementPresent("GridRecord_xpath").getText();
					 * System.out.println("searched data is" + " " + Data);
					 * logs.info("searched data is" + " " + Data); getScreenshot("SearchResult_",
					 * "IntMIntServices", driver); if (ImageFile.isDisplayed()) {
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
					 * "IntMIntServices", driver); // ApplyFilter
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
					 * "IntMIntServices", driver); if (ImageFile.isDisplayed()) {
					 * System.out.println("There is not any data related enetered search parameters"
					 * ); logs.info("There is not any data related enetered search parameters");
					 * 
					 * } else {
					 * System.out.println("Data is present related enetered search parameters");
					 * logs.info("Data is present related enetered search parameters"); }
					 */

					// ----Filter-ShowInActive-Checked--Activate deleted Record------------
					isElementPresent("VAddFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					Thread.sleep(1000);
					// ShowInACtive
					isElementPresent("VAddFShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					Thread.sleep(1000);
					getScreenshot("ShowInACtive_", "IntMIntServices", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveChecked_", "IntMIntServices", driver);
					// ApplyFilter
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
					getScreenshot("SearchResult_", "IntMIntServices", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Submit-----
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);

						// ValidTo
						isElementPresent("VAddValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VAddValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("Integrator ServicesEdWithData1_", "IntMIntServices", driver);

						// Submit
						isElementPresent("VAddSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "IntMIntServices", driver);

					}

					// ----Filter-ShowInActive-UnChecked------------
					isElementPresent("VAddFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					// ShowInACtive
					isElementPresent("VAddFShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					getScreenshot("ShowInACtive_", "IntMIntServices", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("VAddFShwInActive_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveUnchecked_", "IntMIntServices", driver);
					// ApplyFilter
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
					getScreenshot("SearchResult_", "IntMIntServices", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// PageSize
					pageSize("IntMIntServices");

					// pagination
					pagination("IntMIntServices");

					// normalView
					normalView("IntMIntServices");

					break;
				}

			} else {
				System.out.println("IntMaster is not exist");
				logs.info("IntMaster is not exist");
			}

		}
	}

}
