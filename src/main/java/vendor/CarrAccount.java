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

public class CarrAccount extends BaseInit {

	@Test
	public void carrAccount() throws InterruptedException, IOException {
		System.out.println("--------------Testing CARRIER-ACCOUNT---------------");
		logs.info("--------------Testing CARRIER-ACCOUNT---------------");

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
			if (IName.equalsIgnoreCase("Carrier")) {
				highLight(vendItem.get(count1), driver);
				vendItem.get(count1).click();
				System.out.println("clicked on Carrier");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
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
				getScreenshot("SearchData_", "Account", driver);
				// SearchBTN
				WebElement Search = isElementPresent("VCorSearch_xpath");
				highLight(isElementPresent("VCorSearch_xpath"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Account", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					waitForPageLoad();

					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					getScreenshot("CarrEditor_", "Account", driver);

					// Account
					highLight(isElementPresent("Acc_xpath"), driver);
					isElementPresent("Acc_xpath").click();
					System.out.println("Clicked on Account menu");
					logs.info("Clicked on Account menu");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("Accountcreen_", "Account", driver);

					// Create-Back
					highLight(isElementPresent("ACCreate_id"), driver);
					isElementPresent("ACCreate_id").click();
					System.out.println("Clicked on Create button");
					System.out.println("Title of the page is==" + isElementPresent("CreateTitle_xpath").getText());
					logs.info("Clicked on Create button");
					logs.info("Title of the page is==" + isElementPresent("CreateTitle_xpath").getText());
					getScreenshot("AccountCreate_", "Account", driver);

					// Back
					WebElement back = isElementPresent("AcCarrBack_id");
					highLight(isElementPresent("AcCarrBack_id"), driver);
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
					 * isElementPresent("ACCreate_id").click();
					 * System.out.println("Clicked on Create button");
					 * logs.info("Clicked on Create button"); wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.
					 * xpath("//*[@class=\"card mb-20 filter_box\"]")));
					 * 
					 * // Vendor Dropdown isElementPresent("ACVendDrop_id").click();
					 * System.out.println("Clicked on Vendor Dropdown"); Thread.sleep(2000);
					 * isElementPresent("ACVendDrop_id").sendKeys(Keys.DOWN);
					 * isElementPresent("ACVendDrop_id").sendKeys(Keys.ENTER); //
					 * isElementPresent("VendItem_xpath").click();
					 * System.out.println("Selected 1st value"); logs.info("Selected 1st value");
					 * 
					 * // Account isElementPresent("ACAccount_id").sendKeys("01AC");
					 * System.out.println("Enter Account"); logs.info("Enter Account");
					 * 
					 * // Name isElementPresent("ACName_id").sendKeys("AutoTester");
					 * System.out.println("Enter Name"); logs.info("Enter Name");
					 * 
					 * // Note
					 * isElementPresent("AddNote_xpath").sendKeys("Hi this is testing account");
					 * System.out.println("Enter Account"); logs.info("Enter Account");
					 * 
					 * // ValidTo DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					 * Calendar cal = Calendar.getInstance(); cal.setTime(new Date());
					 * cal.add(Calendar.DATE, 10); String newDate =
					 * dateFormat.format(cal.getTime());
					 * isElementPresent("ACValidTo_id").sendKeys(newDate);
					 * System.out.println("Selected Date,10 days priorior from current Date");
					 * logs.info("Selected Date,10 days priorior from current Date");
					 * 
					 * getScreenshot("AccountEdWithData", "Account", driver);
					 * 
					 * // ---------Add Office------------ WebElement AddOffice =
					 * isElementPresent("AddOffice_xpath");
					 * js.executeScript("arguments[0].scrollIntoView();", AddOffice);
					 * AddOffice.click(); System.out.println("Clicked on Add Office Link");
					 * logs.info("Clicked on Add Office Link"); getScreenshot("AddOffice_",
					 * "Account", driver); // AddOffice-Cancel WebElement Can =
					 * isElementPresent("ACCrtOffCancl_id");
					 * js.executeScript("arguments[0].click();", Can);
					 * System.out.println("Clicked on Cancel button of Add Office");
					 * getScreenshot("AddOfficeCancel_", "Account", driver);
					 * 
					 * // Add Office isElementPresent("AddOffice_xpath").click();
					 * System.out.println("Clicked on Add Office Link"); // AddOffice-close
					 * WebElement close = isElementPresent("AddOfClose_xpath");
					 * js.executeScript("arguments[0].click();", close);
					 * System.out.println("Clicked on Close button of Add Office");
					 * getScreenshot("AddOfficeClose_", "Account", driver);
					 * 
					 * // Add Office-Submit isElementPresent("AddOffice_xpath").click();
					 * System.out.println("Clicked on Add Office Link"); Thread.sleep(1000);
					 * isElementPresent("OfficeCode_xpath").sendKeys("Of"); Thread.sleep(2000);
					 * isElementPresent("OfficeCode_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("OfficeCode_xpath").sendKeys(Keys.ENTER); // Submit
					 * isElementPresent("ACCrtOffSubmit_id").click();
					 * System.out.println("Clicked on SUbmit button of Add Office");
					 * wait.until(ExpectedConditions
					 * .visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-page-sizes\"]")))
					 * ; System.out.println("waiting for pagesize div");
					 * 
					 * // PageSize pageSize("AddOffice"); // pagination pagination("AddOffice");
					 * 
					 * // Delete-OfficeGrid WebElement pageinfo =
					 * isElementPresent("ApgridpageInfo_xpath"); System.out.println("page info is=="
					 * + pageinfo.getText()); logs.info("page info is==" + pageinfo.getText()); if
					 * (pageinfo.getText().contains("0")) {
					 * System.out.println("There is not data present in the grid");
					 * logs.info("There is not data present in the grid");
					 * 
					 * } else { System.out.println("Data is available in the grid");
					 * logs.info("Data is available in the grid"); // Delete
					 * isElementPresent("Del_xpath").click();
					 * System.out.println("Clicked on Delete button");
					 * getScreenshot("AddOffDelete_", "Account", driver);
					 * 
					 * System.out.println("Header of the pop up is=" +
					 * isElementPresent("Delhed_xpath").getText());
					 * 
					 * System.out.println("Message of the pop up is=" +
					 * isElementPresent("Delmsg_xpath").getText());
					 * 
					 * logs.info("Clicked on Delete button");
					 * 
					 * logs.info("Header of the pop up is=" +
					 * isElementPresent("Delhed_xpath").getText());
					 * 
					 * logs.info("Message of the pop up is=" +
					 * isElementPresent("Delmsg_xpath").getText());
					 * 
					 * // Keep it isElementPresent("DelKeepIt_xpath").click();
					 * System.out.println("Clicked on Keep It button");
					 * logs.info("Clicked on Keep It button"); getScreenshot("AddOfficekeepIT_",
					 * "Account", driver); wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.xpath("	//tbody[@role=\"presentation\"]"
					 * )));
					 * 
					 * // Delete isElementPresent("Del_xpath").click();
					 * System.out.println("Clicked on Delete button");
					 * 
					 * System.out.println("Header of the pop up is=" +
					 * isElementPresent("Delhed_xpath").getText());
					 * 
					 * System.out.println("Message of the pop up is=" +
					 * isElementPresent("Delmsg_xpath").getText());
					 * 
					 * logs.info("Clicked on Delete button");
					 * 
					 * logs.info("Header of the pop up is=" +
					 * isElementPresent("Delhed_xpath").getText());
					 * 
					 * logs.info("Message of the pop up is=" +
					 * isElementPresent("Delmsg_xpath").getText());
					 * 
					 * // DeleteIt isElementPresent("Delbtn_xpath").click();
					 * System.out.println("Clicked on Delete It button");
					 * logs.info("Clicked on Delete It button"); getScreenshot("AddOfficeDeleteIt_",
					 * "Account", driver); wait.until(ExpectedConditions
					 * .visibilityOfElementLocated(By.
					 * xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					 * 
					 * System.out.println("Delete Message=" +
					 * isElementPresent("NoMsg_xpath").getText()); logs.info("Delete Message=" +
					 * isElementPresent("NoMsg_xpath").getText());
					 * wait.until(ExpectedConditions.invisibilityOfElementLocated(
					 * By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					 * 
					 * wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.xpath("	//tbody[@role=\"presentation\"]"
					 * ))); }
					 * 
					 * wait.until(ExpectedConditions
					 * .presenceOfAllElementsLocatedBy(By.xpath("	//tbody[@role=\"presentation\"]"
					 * )));
					 * 
					 * // Submit-Account isElementPresent("ACSubmit_id").click();
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
					 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					 * "//*[@aria-label=\"Create\"]")));
					 */
					// Search=AccountNo
					highLight(isElementPresent("ACSearch_id"), driver);
					isElementPresent("ACSearch_id").sendKeys("01AC");
					System.out.println("Entered AccountNo in Searchbox");
					logs.info("Entered AccountNo in Searchbox");
					getScreenshot("AccSearch_", "Account", driver);
					isElementPresent("ACSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("AccSearchResultGrid_", "Account", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						highLight(isElementPresent("VCorEdit_xpath"), driver);
						isElementPresent("VCorEdit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						Thread.sleep(3000);
						getScreenshot("AccountEditor_", "Account", driver);

						// Vendor Dropdown
						highLight(isElementPresent("ACVendDrop_id"), driver);
						isElementPresent("ACVendDrop_id").clear();
						Thread.sleep(1000);
						isElementPresent("ACVendDrop_id").click();
						System.out.println("Clicked on Vendor Dropdown");
						Thread.sleep(2000);
						isElementPresent("ACVendDrop_id").sendKeys("AutoVen01");
						Thread.sleep(2000);
						isElementPresent("ACVendDrop_id").sendKeys(Keys.DOWN);
						isElementPresent("ACVendDrop_id").sendKeys(Keys.ENTER);
						// isElementPresent("VendItem_xpath").click();
						System.out.println("Selected 1st value");
						logs.info("Selected 1st value");

						// Account
						highLight(isElementPresent("ACAccount_id"), driver);
						isElementPresent("ACAccount_id").clear();
						isElementPresent("ACAccount_id").sendKeys("01AC");
						System.out.println("Enter Account");
						logs.info("Enter Account");

						// Name
						highLight(isElementPresent("ACName_id"), driver);
						isElementPresent("ACName_id").clear();
						isElementPresent("ACName_id").sendKeys("AutoTester");
						System.out.println("Enter Name");
						logs.info("Enter Name");

						// Note
						highLight(isElementPresent("AddNote_xpath"), driver);
						isElementPresent("AddNote_xpath").clear();
						isElementPresent("AddNote_xpath").sendKeys("Hi this is testing account");
						System.out.println("Enter Account");
						logs.info("Enter Account");

						// ValidTo
						highLight(isElementPresent("ACValidTo_id"), driver);
						isElementPresent("ACValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("ACValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("AccountEdWithData", "Account", driver);

						// ---------Add Office------------
						WebElement AddOffice = isElementPresent("AddOffice_xpath");
						js.executeScript("arguments[0].scrollIntoView();", AddOffice);
						highLight(isElementPresent("AddOffice_xpath"), driver);
						AddOffice.click();
						System.out.println("Clicked on Add Office Link");
						logs.info("Clicked on Add Office Link");
						getScreenshot("AddOffice_", "Account", driver);
						// AddOffice-Cancel
						WebElement Can = isElementPresent("ACCrtOffCancl_id");
						highLight(isElementPresent("ACCrtOffCancl_id"), driver);
						js.executeScript("arguments[0].click();", Can);
						System.out.println("Clicked on Cancel button of Add Office");
						getScreenshot("AddOfficeCancel_", "Account", driver);

						// Add Office
						highLight(isElementPresent("AddOffice_xpath"), driver);
						isElementPresent("AddOffice_xpath").click();
						System.out.println("Clicked on Add Office Link");
						// AddOffice-close
						WebElement close = isElementPresent("AddOfClose_xpath");
						highLight(isElementPresent("AddOfClose_xpath"), driver);
						js.executeScript("arguments[0].click();", close);
						System.out.println("Clicked on Close button of Add Office");
						getScreenshot("AddOfficeClose_", "Account", driver);

						// Add Office-Submit
						highLight(isElementPresent("AddOffice_xpath"), driver);
						isElementPresent("AddOffice_xpath").click();
						System.out.println("Clicked on Add Office Link");
						Thread.sleep(1000);
						isElementPresent("OfficeCode_xpath").sendKeys("Of");
						Thread.sleep(2000);
						isElementPresent("OfficeCode_xpath").sendKeys(Keys.DOWN);
						isElementPresent("OfficeCode_xpath").sendKeys(Keys.ENTER);
						// Submit
						highLight(isElementPresent("ACCrtOffSubmit_id"), driver);
						isElementPresent("ACCrtOffSubmit_id").click();
						System.out.println("Clicked on SUbmit button of Add Office");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-page-sizes\"]")));
						System.out.println("waiting for pagesize div");

						// PageSize
						pageSize("AddOffice");
						// pagination
						pagination("AddOffice");

						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// Delete-OfficeGrid
						WebElement pageinfo = isElementPresent("ApgridpageInfo_xpath");
						js.executeScript("arguments[0].scrollIntoView();", pageinfo);
						System.out.println("page info is==" + pageinfo.getText());
						logs.info("page info is==" + pageinfo.getText());
						ImageFile = isElementPresent("ApNoDataImage_xpath");
						if (ImageFile.isDisplayed()) {
							System.out.println("There is not any data related enetered search parameters");
							logs.info("There is not any data related enetered search parameters");

						} else {
							System.out.println("Data is present related enetered search parameters");
							logs.info("Data is present related enetered search parameters");
							// Delete
							highLight(isElementPresent("Del_xpath"), driver);
							isElementPresent("Del_xpath").click();
							System.out.println("Clicked on Delete button");
							getScreenshot("AddOffDelete_", "Account", driver);

							System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

							System.out
									.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

							logs.info("Clicked on Delete button");

							logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

							logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

							// Keep it
							highLight(isElementPresent("DelKeepIt_xpath"), driver);
							isElementPresent("DelKeepIt_xpath").click();
							System.out.println("Clicked on Keep It button");
							logs.info("Clicked on Keep It button");
							getScreenshot("AddOfficekeepIT_", "Account", driver);
							waitForPageLoad();

							// Delete
							highLight(isElementPresent("Del_xpath"), driver);
							isElementPresent("Del_xpath").click();
							System.out.println("Clicked on Delete button");

							System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

							System.out
									.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

							logs.info("Clicked on Delete button");

							logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

							logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

							// DeleteIt
							highLight(isElementPresent("Delbtn_xpath"), driver);
							isElementPresent("Delbtn_xpath").click();
							System.out.println("Clicked on Delete It button");
							logs.info("Clicked on Delete It button");
							getScreenshot("AddOfficeDeleteIt_", "Account", driver);
							wait.until(ExpectedConditions.visibilityOfElementLocated(
									By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

							System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
							logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
							wait.until(ExpectedConditions.invisibilityOfElementLocated(
									By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

							waitForPageLoad();

						}
						// Submit-Account
						highLight(isElementPresent("ACSubmit_id"), driver);
						isElementPresent("ACSubmit_id").click();
						System.out.println("Clicked on Submit button");
						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Clicked on Submit button");
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));

						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						Thread.sleep(5000);

					}
					// Search=AccountNo
					System.out.println("-----Testing Delete---------");
					logs.info("--------Testing Delete---------");
					highLight(isElementPresent("ACSearch_id"), driver);
					isElementPresent("ACSearch_id").sendKeys("01AC");
					System.out.println("Entered AccountNo in Searchbox");
					logs.info("Entered AccountNo in Searchbox");
					getScreenshot("AccSearch_", "Account", driver);
					isElementPresent("ACSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("AccSearchResultGrid_", "Account", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");
						getScreenshot("AccDelete_", "Account", driver);
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
						getScreenshot("AccDeleteKeepIT_", "Account", driver);
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

						// DeleteIt
						highLight(isElementPresent("Delbtn_xpath"), driver);
						isElementPresent("Delbtn_xpath").click();
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("AccDeleteDeleteIT_", "Account", driver);
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
						waitForPageLoad();

					}
					// Clear Search
					highLight(isElementPresent("ACSearch_id"), driver);
					isElementPresent("ACSearch_id").clear();
					isElementPresent("ACSearch_id").sendKeys(Keys.ENTER);
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
					getScreenshot("AccSearchResultGrid_", "Account", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-SHWDeleted-Checked
					highLight(isElementPresent("ACShwDeleted_id"), driver);
					isElementPresent("ACShwDeleted_id").click();
					System.out.println("Clicked on Show Deleted checkbox");
					System.out.println("Show Deleted is selected=="
							+ isElementPresent("ACShwDeleted_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show Deleted checkbox");
					logs.info("Show Deleted is selected=="
							+ isElementPresent("ACShwDeleted_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("AccSearchResultGrid_", "Account", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-ShwDeleted-UnChecked
					highLight(isElementPresent("ACShwDeleted_id"), driver);
					isElementPresent("ACShwDeleted_id").click();
					System.out.println("Clicked on Show Deleted checkbox");
					System.out.println("Show Deleted is selected=="
							+ isElementPresent("ACShwDeleted_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show Deleted checkbox");
					logs.info("Show Deleted is selected=="
							+ isElementPresent("ACShwDeleted_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("AccSearchResultGrid_", "Account", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}
					// Active the deleted record
					System.out.println("-----------------------ACtivate the deleted record------------------------");
					logs.info("------------------------ACtivate the deleted record------------------------");
					highLight(isElementPresent("ACSearch_id"), driver);
					isElementPresent("ACSearch_id").sendKeys("01AC");
					System.out.println("Entered AccountNo in Searchbox");
					logs.info("Entered AccountNo in Searchbox");
					highLight(isElementPresent("ACShwDeleted_id"), driver);
					isElementPresent("ACShwDeleted_id").click();
					System.out.println("Clicked on Show Deleted checkbox");
					System.out.println("Show Deleted is selected=="
							+ isElementPresent("ACShwDeleted_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show Deleted checkbox");
					logs.info("Show Deleted is selected=="
							+ isElementPresent("ACShwDeleted_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("AccSearchResultGrid_", "Account", driver);
					waitForPageLoad();
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
						getScreenshot("AccountEditor_", "Account", driver);
						Thread.sleep(3000);
						// ValidTo
						highLight(isElementPresent("ACValidTo_id"), driver);
						isElementPresent("ACValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("ACValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("AccountEdWithData", "Account", driver);

						// Submit-Account
						highLight(isElementPresent("ACSubmit_id"), driver);
						isElementPresent("ACSubmit_id").click();
						System.out.println("Clicked on Submit button");
						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Clicked on Submit button");
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						Thread.sleep(3000);
					}

					// PageSize
					pageSize("Account");

					// Pagination
					pagination("Account");

					// NormalView
					normalView("Account");

					// click on columns
					columns("Account");

					break;
				}
			} else {
				System.out.println("Carrier is not exist");
				logs.info("Carrier is not exist");
			}

		}
	}
}
