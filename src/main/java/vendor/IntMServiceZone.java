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

public class IntMServiceZone extends BaseInit {
	//-------------Remaining because ID is not there------------

	@Test
	public  void intMServiceZone() throws InterruptedException, IOException {
		// Login
		login();

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

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
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]")));
				getScreenshot("IntMServiceZone_", "IntMServiceZone", driver);

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Integrator
				isElementPresent("IMSIntg_xpath").click();
				System.out.println("Clicked on Integrator Dropdown");
				logs.info("Clicked on Integrator Dropdown");
				isElementPresent("IMSIngItem_xpath").click();
				System.out.println("Selected 1st Item from the list");
				logs.info("Selected 1st Item from the list");
				// Internal MNX Name
				isElementPresent("IMSMNXIntName_xpath").sendKeys("MNX RJ");
				System.out.println("Entered value in Internal MNX Name");
				logs.info("Entered value in Internal MNX Name");
				// Account
				isElementPresent("IMSACNo_xpath").sendKeys("IMAC01");
				System.out.println("Entered value in Account");
				logs.info("Entered value in Account");

				getScreenshot("IntMSearchData_", "IntMServiceZone", driver);

				// SearchBTN
				isElementPresent("IMSearch_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");

				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("IntMSearchResult_", "IntMServiceZone", driver);

				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters" + ImageFile.isDisplayed());
					logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());

					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");

					getScreenshot("IntMEditMode_", "IntMServiceZone", driver);

					// Service Zone
					isElementPresent("IMServZone_xpath").click();
					System.out.println("Clicked on Service Zone menu");
					logs.info("Clicked on Service Zone menu");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]")));
					getScreenshot("IntMServiceZoneScreen_", "IntMServiceZone", driver);

					// ----------- Create-Back----------------
					isElementPresent("Create_xpath").click();
					System.out.println("Clicked on Create button");
					logs.info("Clicked on Create button");

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"card mb-20\"]")));
					getScreenshot("ServiceZoneCreate_", "IntMServiceZone", driver);

					// Back
					isElementPresent("BtmBack_xpath").click();
					// js.executeScript("arguments[0].click();", sub);
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					getScreenshot("ServiceZoneCreateBack_", "IntMServiceZone", driver);

					// ----------- Create-Submit----------------
					/*
					 * isElementPresent("Create_xpath").click();
					 * System.out.println("Clicked on Create button");
					 * logs.info("Clicked on Create button"); Thread.sleep(2000);
					 * wait.until(ExpectedConditions
					 * .visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"card mb-20\"]")));
					 * 
					 * // Service Display Name isElementPresent("IMServDisplayName_xpath").click();
					 * Thread.sleep(2000);
					 * isElementPresent("IMServDisplayName_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMServDisplayName_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected Service"); logs.info("Selected Service");
					 * 
					 * // ValidTO DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					 * Calendar cal = Calendar.getInstance(); cal.setTime(new Date());
					 * cal.add(Calendar.DATE, 10); String newDate =
					 * dateFormat.format(cal.getTime());
					 * isElementPresent("IMValidTo_xpath").sendKeys(newDate);
					 * System.out.println("Selected Date,10 days priorior from current Date");
					 * logs.info("Selected Date,10 days priorior from current Date");
					 * 
					 * getScreenshot("ServiceZoneCreateData_", "IntMServiceZone", driver);
					 * 
					 * // -------------AddLink-Close-----------
					 * isElementPresent("Addlink_xpath").click();
					 * System.out.println("Clicked on Add Link"); logs.info("Clicked on Add Link");
					 * Thread.sleep(1000); getScreenshot("ServiceZoneAddLink_", "IntMServiceZone",
					 * driver);
					 * 
					 * // Close WebElement Close = isElementPresent("NoClose_xpath");
					 * js.executeScript("arguments[0].click();", Close);
					 * System.out.println("Clicked on Close button");
					 * logs.info("Clicked on Close button"); getScreenshot("ServiceZoneAddClose_",
					 * "IntMServiceZone", driver);
					 * 
					 * // -----------AddLink-Cancel-------------
					 * isElementPresent("Addlink_xpath").click();
					 * System.out.println("Clicked on Add Link"); logs.info("Clicked on Add Link");
					 * Thread.sleep(1000);
					 * 
					 * // Cancel isElementPresent("IMCancel_xpath").click();
					 * System.out.println("Clicked on Cancel button");
					 * logs.info("Clicked on Cancel button"); getScreenshot("ServiceZoneAddCancel_",
					 * "IntMServiceZone", driver);
					 * 
					 * // ------AddLink-Submit-------- isElementPresent("Addlink_xpath").click();
					 * System.out.println("Clicked on Add Link"); logs.info("Clicked on Add Link");
					 * Thread.sleep(1000);
					 * 
					 * // OriginZone isElementPresent("IMSZOriginZone_xpath").click();
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys("0"); Thread.sleep(2000);
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected OriginZOne"); logs.info("Selected OriginZOne");
					 * 
					 * // DestinationZone isElementPresent("IMDestZone_xpath").click();
					 * isElementPresent("IMDestZone_xpath").sendKeys("1"); Thread.sleep(2000);
					 * isElementPresent("IMDestZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMDestZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMDestZone_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected DestZOne"); logs.info("Selected DestZOne");
					 * 
					 * getScreenshot("ServiceZoneAddData_", "IntMServiceZone", driver);
					 * 
					 * // Submit WebElement AddSub = isElementPresent("IMSubmit_xpath");
					 * js.executeScript("arguments[0].click();", AddSub); //
					 * act.moveToElement(AddSub).click().perform();
					 * 
					 * System.out.println("Clicked on Submit button");
					 * logs.info("Clicked on Submit button");
					 * 
					 * wait.until(ExpectedConditions
					 * .visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]")));
					 * getScreenshot("ServiceZoneAddGrid_", "IntMServiceZone", driver);
					 * 
					 * // ------- Edit-AddZOne--------Submit System.out.
					 * println("------------------------Testing Edit------------------------");
					 * logs.info("------------------------Testing Edit------------------------");
					 * WebElement Edit = isElementPresent("Edit_xpath");
					 * js.executeScript("arguments[0].click();", Edit);
					 * System.out.println("Clicked on Edit button");
					 * logs.info("Clicked on Edit button"); Thread.sleep(2000);
					 * getScreenshot("Editor_", "Notice", driver); getScreenshot("AddLinkEdit_",
					 * "IntMServiceZone", driver);
					 * 
					 * // SUbmit AddSub = isElementPresent("IMSubmit_xpath");
					 * js.executeScript("arguments[0].click();", AddSub);
					 * js.executeScript("arguments[0].click();", AddSub);
					 * System.out.println("Clicked on Submit button");
					 * logs.info("Clicked on Submit button");
					 * wait.until(ExpectedConditions.visibilityOfElementLocated(
					 * By.xpath("//*[@class=\"dx-row dx-data-row dx-column-lines\"]")));
					 * 
					 * // ------- Delete-------------- WebElement AddDelete =
					 * isElementPresent("Del_xpath");
					 * wait.until(ExpectedConditions.elementToBeClickable(AddDelete));
					 * AddDelete.click(); System.out.println("Clicked on Delete button");
					 * logs.info("Clicked on Delete button"); getScreenshot("AddLinkDelete_",
					 * "IntMServiceZone", driver);
					 * 
					 * // ------AddLink-Submit-------- isElementPresent("Addlink_xpath").click();
					 * System.out.println("Clicked on Add Link"); logs.info("Clicked on Add Link");
					 * Thread.sleep(1000);
					 * 
					 * // OriginZone isElementPresent("IMSZOriginZone_xpath").click();
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys("0"); Thread.sleep(2000);
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected OriginZOne"); logs.info("Selected OriginZOne");
					 * 
					 * // DestinationZone isElementPresent("IMDestZone_xpath").click();
					 * isElementPresent("IMDestZone_xpath").sendKeys("1"); Thread.sleep(2000);
					 * isElementPresent("IMDestZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMDestZone_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("IMDestZone_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected DestZOne"); logs.info("Selected DestZOne");
					 * 
					 * getScreenshot("ServiceZoneAddData_", "IntMServiceZone", driver);
					 * 
					 * // Submit AddSub = isElementPresent("IMSubmit_xpath");
					 * js.executeScript("arguments[0].click();", AddSub); //
					 * act.moveToElement(AddSub).click().perform();
					 * 
					 * System.out.println("Clicked on Submit button");
					 * logs.info("Clicked on Submit button");
					 * 
					 * wait.until(ExpectedConditions
					 * .visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]")));
					 * getScreenshot("ServiceZoneAddGrid_", "IntMServiceZone", driver);
					 * 
					 * // SUbmit-ServiceZone isElementPresent("IMSZSubmit_xpath").click(); //
					 * js.executeScript("arguments[0].click();", sub);
					 * System.out.println("Clicked on Submit button");
					 * logs.info("Clicked on Submit button"); getScreenshot("ServiceZoneSubmit_",
					 * "IntMServiceZone", driver); wait.until(ExpectedConditions
					 * .visibilityOfElementLocated(By.
					 * xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					 * 
					 * System.out.println("SuccessfullMessage=" +
					 * isElementPresent("NoMsg_xpath").getText()); logs.info("SuccessfullMessage=" +
					 * isElementPresent("NoMsg_xpath").getText());
					 * 
					 * wait.until(ExpectedConditions .invisibilityOfElementLocated(By.
					 * xpath("//*[@class=\"success dx-template-wrapper\"]")));
					 * 
					 * wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
					 * "//*[@class=\"dx-datagrid-content\"]/table")));
					 */
					// ------Search-Edit-Submit---------
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));
					Thread.sleep(1000);
					System.out.println("------------------------Testing Search------------------------");
					logs.info("------------------------Testing Search------------------------");
					isElementPresent("IMSZSearch_xpath").sendKeys("AutoServiceForServiceZone");
					getScreenshot("ServiceZoneSearchData_", "IntMServiceZone", driver);
					isElementPresent("IMSZSearch_xpath").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Searchbox");
					logs.info("Entered value in Searchbox");
					Thread.sleep(2000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("ServiceZoneSearchResult_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());

						// ------- Edit--------Submit
						System.out.println("------------------------Testing Edit------------------------");
						logs.info("------------------------Testing Edit------------------------");
						WebElement Edit = isElementPresent("Edit_xpath");
						js.executeScript("arguments[0].click();", Edit);
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]")));
						Thread.sleep(2000);
						getScreenshot("ServiceZoneEditor_", "IntMServiceZone", driver);

						// SUbmit
						WebElement SZSub = isElementPresent("IMSZSubmit_xpath");
						wait.until(ExpectedConditions.elementToBeClickable(SZSub));
						js.executeScript("arguments[0].click();", SZSub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
								By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
								By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));

					}

					// PageSize
					pageSize("IMServiceZone");

					// Pagination
					pagination("IMServiceZone");

					// ------Search-Expand-Collapse--------
					System.out.println("------------------------Testing Search------------------------");
					logs.info("------------------------Testing Search------------------------");
					isElementPresent("IMSZSearch_xpath").sendKeys("AutoServiceForServiceZone");
					isElementPresent("IMSZSearch_xpath").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Searchbox");
					logs.info("Entered value in Searchbox");
					Thread.sleep(2000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("ServiceZoneSearchResult_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());

						// Expand
						isElementPresent("IMExpand_xpath").click();
						System.out.println("Clicked on Expand button");
						logs.info("Clicked on Expand button");
						Thread.sleep(1000);
						getScreenshot("OriginGrid_", "IntMServiceZone", driver);

						wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
								By.xpath("//td/div[@class=\"dx-template-wrapper\"]")));

						// -------------AddLink-Close-----------
						/*
						 * isElementPresent("Addlink_xpath").click();
						 * System.out.println("Clicked on Add Link"); logs.info("Clicked on Add Link");
						 * Thread.sleep(1000); getScreenshot("AddLinkEditor_", "IntMServiceZone",
						 * driver);
						 * 
						 * // Close WebElement Close = isElementPresent("NoClose_xpath");
						 * js.executeScript("arguments[0].click();", Close);
						 * System.out.println("Clicked on Close button");
						 * logs.info("Clicked on Close button"); getScreenshot("AddEditorClose_",
						 * "IntMServiceZone", driver);
						 */

						// -----------AddLink-Cancel-------------
						isElementPresent("Addlink_xpath").click();
						System.out.println("Clicked on Add Link");
						logs.info("Clicked on Add Link");
						Thread.sleep(1000);

						// Cancel
						isElementPresent("IMCancel_xpath").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						getScreenshot("AddEditorCancel_", "IntMServiceZone", driver);

						// ------AddLink-Submit--------
						isElementPresent("Addlink_xpath").click();
						System.out.println("Clicked on Add Link");
						logs.info("Clicked on Add Link");
						Thread.sleep(1000);

						// OriginZone
						isElementPresent("IMSZOriginZone_xpath").click();
						isElementPresent("IMSZOriginZone_xpath").sendKeys("0");
						Thread.sleep(2000);
						isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.DOWN);
						isElementPresent("IMSZOriginZone_xpath").sendKeys(Keys.ENTER);
						System.out.println("Selected OriginZOne");
						logs.info("Selected OriginZOne");

						// DestinationZone
						isElementPresent("IMDestZone_xpath").click();
						isElementPresent("IMDestZone_xpath").sendKeys("1");
						Thread.sleep(2000);
						isElementPresent("IMDestZone_xpath").sendKeys(Keys.DOWN);
						isElementPresent("IMDestZone_xpath").sendKeys(Keys.ENTER);
						System.out.println("Selected DestZOne");
						logs.info("Selected DestZOne");
						getScreenshot("AddEditorwithData_", "IntMServiceZone", driver);

						// Submit
						WebElement AddSub = isElementPresent("IMSubmit_xpath");
						js.executeScript("arguments[0].click();", AddSub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");

						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]")));
						getScreenshot("AddEditorSubmit_", "IntMServiceZone", driver);

						// ------- Edit-AddZOne--------Submit
						System.out.println("------------------------Testing Edit------------------------");
						logs.info("------------------------Testing Edit------------------------");
						WebElement CEdit = isElementPresent("ChildgridEdit_xpath");
						js.executeScript("arguments[0].click();", CEdit);
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);
						getScreenshot("AddEditor_", "IntMServiceZone", driver);

						// SUbmit
						AddSub = isElementPresent("IMSubmit_xpath");
						js.executeScript("arguments[0].click();", AddSub);
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						getScreenshot("AddEditorSub_", "IntMServiceZone", driver);

						// PageSize
						pageSize("IMServiceZone");

						// Pagination
						pagination("IMServiceZone");

						// ------- Delete-KeeptIT-------------
						WebElement AddDelete = isElementPresent("ChildgridDelete_xpath");
						wait.until(ExpectedConditions.elementToBeClickable(AddDelete));
						AddDelete.click();
						System.out.println("Clicked on Delete button");
						logs.info("Clicked on Delete button");
						getScreenshot("AddLinkDelete_", "IntMServiceZone", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// Keep it
						isElementPresent("DelKeepIt_xpath").click();
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("AddLinkDeleteKeepIT_", "IntMServiceZone", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// --------------- Delete-DeleteIT-----------
						AddDelete = isElementPresent("ChildgridDelete_xpath");
						wait.until(ExpectedConditions.elementToBeClickable(AddDelete));
						AddDelete.click();
						System.out.println("Clicked on Delete button");
						logs.info("Clicked on Delete button");
						getScreenshot("AddLinkDelete_", "IntMServiceZone", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// DeleteIt
						WebElement DelIT = isElementPresent("Delbtn_xpath");
						js.executeScript("arguments[0].click();", DelIT);
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("AddLinkDeleteDeleteIT_", "IntMServiceZone", driver);

						// Collapse
						isElementPresent("IMCollapse_xpath").click();
						System.out.println("Clicked on Collapse button");
						logs.info("Clicked on Collapse button");
						Thread.sleep(1000);
						getScreenshot("OriginDestCollapse_", "IntMServiceZone", driver);

					}

					// ------- Filter--Cancel-----
					isElementPresent("IMSZFilter_xpath").click();
					System.out.println("Click on Filter button");
					logs.info("Click on Filter button");
					getScreenshot("ServiceZoneFilter_", "IntMServiceZone", driver);
					// Cancel
					isElementPresent("IMSZCancel_xpath").click();
					System.out.println("Click on Cancel button");
					logs.info("Click on Cancel button");
					getScreenshot("ServiceZoneFilterCancel_", "IntMServiceZone", driver);
					Thread.sleep(1000);

					// ------- Filter--ApplyFilter-----
					isElementPresent("IMSZFilter_xpath").click();
					System.out.println("Click on Filter button");
					logs.info("Click on Filter button");
					getScreenshot("ServiceZoneFilter_", "IntMServiceZone", driver);
					// Service Display Name
					isElementPresent("IMSZSDName_xpath").click();
					Thread.sleep(1000);
					isElementPresent("IMSZSDName_xpath").sendKeys(Keys.DOWN);
					isElementPresent("IMSZSDName_xpath").sendKeys(Keys.ENTER);
					System.out.println("Selected Service");
					logs.info("Selected Service");
					getScreenshot("ServiceZoneFilterData_", "IntMServiceZone", driver);

					// ApplyFilter
					isElementPresent("IMSZApplyFil_xpath").click();
					System.out.println("Click on Apply Filter button");
					logs.info("Click on Apply Filter button");
					getScreenshot("ServiceZoneFilterAPFil_", "IntMServiceZone", driver);

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));
					Thread.sleep(1000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("ApplyFilter", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());
					}

					// ---------Filter-ClearFilter------------
					isElementPresent("IMSZFilter_xpath").click();
					System.out.println("Click on Filter button");
					logs.info("Click on Filter button");
					getScreenshot("ServiceZoneFilter_", "IntMServiceZone", driver);
					// ClearFilter
					isElementPresent("IMSZClearFil_xpath").click();
					System.out.println("Click on Clear Filter button");
					logs.info("Click on Clear Filter button");
					getScreenshot("ServiceZoneFilterClearFil_", "IntMServiceZone", driver);
					// ApplyFilter
					isElementPresent("IMSZApplyFil_xpath").click();
					System.out.println("Click on Apply Filter button");
					logs.info("Click on Apply Filter button");
					getScreenshot("FilterAPFilter_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));
					Thread.sleep(1000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("CLearFilter_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());
					}

					// ---------Filter-ShowInActive-Checked-----------
					isElementPresent("IMSZFilter_xpath").click();
					System.out.println("Click on Filter button");
					logs.info("Click on Filter button");
					getScreenshot("ServiceZoneFilter_", "IntMServiceZone", driver);
					// ShowInActive
					isElementPresent("IMSZShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("IMSZShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("IMSZShwInActive_id").getAttribute("aria-checked"));
					// ApplyFilter
					isElementPresent("IMSZApplyFil_xpath").click();
					System.out.println("Click on Apply Filter button");
					logs.info("Click on Apply Filter button");
					getScreenshot("FilterAPFilter_", "IntMServiceZone", driver);

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));
					Thread.sleep(1000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("FilShowInActiveChecked_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());
					}

					// ---------Filter-ShowInActive-Unchecked------------
					isElementPresent("IMSZFilter_xpath").click();
					System.out.println("Click on Filter button");
					logs.info("Click on Filter button");
					getScreenshot("ServiceZoneFilter_", "IntMServiceZone", driver);
					// ShowInActive
					isElementPresent("IMSZShwInActive_id").click();
					System.out.println("Clicked on ShowInActive checkbox");
					logs.info("Clicked on ShowInActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("IMSZShwInActive_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("IMSZShwInActive_id").getAttribute("aria-checked"));
					// ApplyFilter
					isElementPresent("IMSZApplyFil_xpath").click();
					System.out.println("Click on Apply Filter button");
					logs.info("Click on Apply Filter button");
					getScreenshot("FilterAPFilter_", "IntMServiceZone", driver);

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));
					Thread.sleep(1000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("FilShowInActiveUnChecked_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());
					}

					// ------Search-Delete----------
					System.out.println("------------------------Testing Search------------------------");
					logs.info("------------------------Testing Search------------------------");
					isElementPresent("IMSZSearch_xpath").sendKeys("AutoServiceForServiceZone");
					isElementPresent("IMSZSearch_xpath").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Searchbox");
					logs.info("Entered value in Searchbox");
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
							By.xpath("//*[@class=\"dx-datagrid-rowsview dx-datagrid-nowrap\"]")));
					Thread.sleep(1000);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("ServiceZoneSearchResult_", "IntMServiceZone", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println(
								"There is not any data related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("There is not any data related enetered search parameters" + ImageFile.isDisplayed());

					} else {
						System.out.println(
								"Data is present related enetered search parameters" + ImageFile.isDisplayed());
						logs.info("Data is present related enetered search parameters" + ImageFile.isDisplayed());

						// ------- Delete-KeeptIT-------------
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");
						logs.info("Clicked on Delete button");
						getScreenshot("ServiceZoneDelete_", "IntMServiceZone", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// Keep it
						isElementPresent("DelKeepIt_xpath").click();
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("ServiceZoneDeleteKeepIT_", "IntMServiceZone", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// --------------- Delete-DeleteIT-----------
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// DeleteIt
						WebElement DelIT = isElementPresent("Delbtn_xpath");
						js.executeScript("arguments[0].click();", DelIT);
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("ServiceZoneDeleteIT_", "IntMServiceZone", driver);

					}

					// NormalView
					normalView("IMServiceZone");

					// Columns
					columns("IMServiceZone");

					break;
				}

			} else {
				System.out.println("Integrator Master is not exist");
			}
		}
		Thread.sleep(5000);
		driver.close();
		System.out.println("Browser closed");
	}
}
