package admin;

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

public class AirportGroup extends BaseInit {

	@Test
	public void airportGroup() throws InterruptedException, IOException {

		System.out.println("--------------Testing AIRPORT GROUP---------------");
		logs.info("--------------Testing AIRPORT GROUP---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Admin
		WebElement Admin = isElementPresent("Admin_xpath");
		highLight(Admin, driver);
		js.executeScript("arguments[0].click();", Admin);
		System.out.println("Clicked on the admin");
		logs.info("Clicked on the admin");
		getScreenshot("Admindiv_", "AirportGroup", driver);

		// AirportGroup SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();

			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// AirportGroup
			if (headervalue.equalsIgnoreCase("Airport Group")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on AirportGroup");
				logs.info("Clicked on AirportGroup");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("AirportGroupScreen_", "AirportGroup", driver);

				// ---------Create-------Back---------------
				highLight(isElementPresent("APGCreate_xpath"), driver);
				isElementPresent("APGCreate_xpath").click();
				System.out.println("Clicked on the Create button");
				logs.info("Clicked on the create button");
				waitForPageLoad();
				getScreenshot("AirportGroupEditor_", "AirportGroup", driver);
				// Back
				highLight(isElementPresent("ApGpBack_id"), driver);
				isElementPresent("ApGpBack_id").click();
				System.out.println("Clicked on the Back button");
				logs.info("Clicked on Back Button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// ----Search-Edit AIrportGroup------------
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("APGSearch_id"), driver);
				isElementPresent("APGSearch_id").sendKeys("GROUND_TestAuto");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterSearch", "AirportGroup", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				try {
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");
					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
						// Edit
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						Thread.sleep(2000);
						getScreenshot("APGEditor", "AirportGroup", driver);
						wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ApGpBack_id")));

						// Back
						/*
						 * Thread.sleep(2000); highLight(isElementPresent("ApGpBack_id"), driver);
						 * isElementPresent("ApGpBack_id").click();
						 * System.out.println("Clicked on the Back button");
						 * logs.info("Clicked on Back Button"); waitForPageLoad();
						 * wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						 */
						// GroupName
						highLight(isElementPresent("APGName_id"), driver);
						isElementPresent("APGName_id").clear();
						isElementPresent("APGName_id").sendKeys("GROUND_TestAuto");
						System.out.println("Entered value in the GroupName");
						logs.info("Entered value in the GroupName");
						// Description
						highLight(isElementPresent("APGDesc_id"), driver);
						isElementPresent("APGDesc_id").clear();
						isElementPresent("APGDesc_id").sendKeys("Testing Airport Group Creation");
						System.out.println("Entered value in the Description");
						logs.info("Entered value in the Description");
						// ValidTo
						highLight(isElementPresent("APGValidTo_id"), driver);
						WebElement ValidTo = isElementPresent("APGValidTo_id");
						wait.until(ExpectedConditions.elementToBeClickable(ValidTo));
						js.executeScript("arguments[0].scrollIntoView();", ValidTo);
						ValidTo.clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 10);
						String newDate = dateFormat.format(cal.getTime());
						highLight(isElementPresent("APGValidTo_id"), driver);
						isElementPresent("APGValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,10 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						// Remove selected Airport
						highLight(isElementPresent("APGRemoveAp_xpath"), driver);
						isElementPresent("APGRemoveAp_xpath").click();
						System.out.println("Removed Selected value from the dropdown");
						logs.info("Removed Selected value from the dropdown");
						getScreenshot("APAFterRemove", "AirportGroup", driver);

						// AirportList
						highLight(isElementPresent("APGApList_id"), driver);
						WebElement APList = isElementPresent("APGApList_id");
						js.executeScript("arguments[0].scrollIntoView();", APList);
						isElementPresent("APGApList_id").sendKeys("ANY");
						System.out.println("Entered value in AirportGroup List");
						logs.info("Entered value in AirportGroup List");
						Thread.sleep(2000);
						isElementPresent("APGApList_id").sendKeys(Keys.DOWN);
						isElementPresent("APGApList_id").sendKeys(Keys.DOWN);
						isElementPresent("APGApList_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from the dropdown");
						logs.info("Selected value from the dropdown");
						getScreenshot("AirportGroupEditorwithdata_", "AirportGroup", driver);

						// Remove selected Airport
						highLight(isElementPresent("APGRemoveAp_xpath"), driver);
						isElementPresent("APGRemoveAp_xpath").click();
						System.out.println("Removed Selected value from the dropdown");
						logs.info("Removed Selected value from the dropdown");
						getScreenshot("APAFterRemove", "AirportGroup", driver);

						// --------AirportList search------Cancel-------
						highLight(isElementPresent("APGApSearch_id"), driver);
						isElementPresent("APGApSearch_id").click();
						System.out.println("Clicked on the Search button of AirportList");
						logs.info("Clicked on the Search button of AirportList");
						Thread.sleep(1000);
						getScreenshot("AirportListPopUp_", "AirportGroup", driver); // Cancel
						highLight(isElementPresent("APGAPSearchCancl_id"), driver);
						isElementPresent("APGAPSearchCancl_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"form-filed\"]")));

						// ----------AirportList search------Close-----------
						highLight(isElementPresent("APGApSearch_id"), driver);
						isElementPresent("APGApSearch_id").click();
						System.out.println("Clicked on the Search button of AirportList");
						logs.info("Clicked on the Search button of AirportList");
						Thread.sleep(1000);
						// Close
						highLight(isElementPresent("Close_xpath"), driver);
						WebElement close = isElementPresent("Close_xpath");
						js.executeScript("arguments[0].click();", close);
						System.out.println("Clicked on the Close button");
						logs.info("Clicked on Close Button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"form-filed\"]")));

						// -------AirportList search--------Submit-----------
						highLight(isElementPresent("APGApSearch_id"), driver);
						isElementPresent("APGApSearch_id").click();
						System.out.println("Clicked on the Search button of AirportList");
						logs.info("Clicked on the Search button of AirportList");
						Thread.sleep(1000);
						// PageSize
						WebElement pager = isElementPresent("pagerDiv_xpath");
						js.executeScript("arguments[0].scrollIntoView();", pager);
						pageSize("AirportGroup");
						// Pagination
						pagination("AirportGroup");
						// Additional Filter
						highLight(isElementPresent("APGAddFil_id"), driver);
						isElementPresent("APGAddFil_id").click();
						System.out.println("Clicked on the additional filter");
						logs.info("Clicked on the additional filter");
						getScreenshot("AirportListAddFilter_", "AirportGroup", driver);
						// Less Filter
						highLight(isElementPresent("APGLessFil_id"), driver);
						isElementPresent("APGLessFil_id").click();
						System.out.println("Clicked on the less filter");
						logs.info("Clicked on the less filter");
						getScreenshot("AirportListLessFilter_", "AirportGroup", driver); // AirportID
						highLight(isElementPresent("APGAPID_id"), driver);
						isElementPresent("APGAPID_id").sendKeys("ANY1");
						System.out.println("Entered value in AirportID");
						logs.info("Entered value in AirportID");
						// AirportName
						highLight(isElementPresent("APGApName_id"), driver);
						isElementPresent("APGApName_id").sendKeys("Anthony Municipal Airport Updated");
						System.out.println("Entered value in AirportName");
						logs.info("Entered value in AirportName");
						// Search
						highLight(isElementPresent("APGAPSearchAfFilter_id"), driver);
						isElementPresent("APGAPSearchAfFilter_id").click();
						System.out.println("Clicked on the search button");
						logs.info("Clicked on the search button");
						Thread.sleep(2000);
						getScreenshot("AirportListSearch_", "AirportGroup", driver);
						System.out
								.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
						logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
						ImageFile = isElementPresent("ApNoDataImage_xpath");
						if (ImageFile.isDisplayed()) {
							System.out.println("There is not any data related enetered search parameters");
							logs.info("There is not any data related enetered search parameters");
						} else {
							System.out.println("Data is present related enetered search parameters");
							logs.info("Data is present related enetered search parameters");
						}
						// select the airport
						highLight(isElementPresent("ApGLApSelect_xpath"), driver);
						isElementPresent("ApGLApSelect_xpath").click();
						System.out.println(
								"Selected the search airport" + isElementPresent("ApGLApSelect_xpath").isSelected());
						logs.info("Selected the search airport" + isElementPresent("ApGLApSelect_xpath").isSelected());
						getScreenshot("Apselected_", "AirportGroup", driver);
						// Submit-AIrportList Popup
						highLight(isElementPresent("APGApSubmit_id"), driver);
						isElementPresent("APGApSubmit_id").click();
						System.out.println("Clicked on SUbmit button");
						logs.info("Clicked on SUbmit button");
						getScreenshot("SelectedAP_", "AirportGroup", driver);
						if (isElementPresent("APGAListVal_xpath").isDisplayed()) {
							System.out.println("Airport is selected in AirportList");
							logs.info("Airport is selected in AirportList");
						} else {
							System.out.println("Airport is not selected in AirportList");
							logs.info("Airport is not selected in AirportList");
						}

						// Submit
						highLight(isElementPresent("APGPSubmit_id"), driver);
						isElementPresent("APGPSubmit_id").click();
						System.out.println("Clicked on SUbmit button");
						logs.info("Clicked on SUbmit button");
						waitForPageLoad();

					}
				} catch (org.openqa.selenium.StaleElementReferenceException ex) {
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");
					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
						// Edit
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						Thread.sleep(2000);
						getScreenshot("APGEditor", "AirportGroup", driver);
						wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ApGpBack_id")));

						// Back
						/*
						 * Thread.sleep(2000); highLight(isElementPresent("ApGpBack_id"), driver);
						 * isElementPresent("ApGpBack_id").click();
						 * System.out.println("Clicked on the Back button");
						 * logs.info("Clicked on Back Button"); waitForPageLoad();
						 * wait.until(ExpectedConditions
						 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
						 * ))); wait.until(ExpectedConditions.invisibilityOfElementLocated(
						 * By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						 */
						// GroupName
						highLight(isElementPresent("APGName_id"), driver);
						isElementPresent("APGName_id").clear();
						isElementPresent("APGName_id").sendKeys("GROUND_TestAuto");
						System.out.println("Entered value in the GroupName");
						logs.info("Entered value in the GroupName");
						// Description
						highLight(isElementPresent("APGDesc_id"), driver);
						isElementPresent("APGDesc_id").clear();
						isElementPresent("APGDesc_id").sendKeys("Testing Airport Group Creation");
						System.out.println("Entered value in the Description");
						logs.info("Entered value in the Description");
						// ValidTo
						highLight(isElementPresent("APGValidTo_id"), driver);
						WebElement ValidTo = isElementPresent("APGValidTo_id");
						wait.until(ExpectedConditions.elementToBeClickable(ValidTo));
						js.executeScript("arguments[0].scrollIntoView();", ValidTo);
						ValidTo.clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 10);
						String newDate = dateFormat.format(cal.getTime());
						highLight(isElementPresent("APGValidTo_id"), driver);
						isElementPresent("APGValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,10 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						// Remove selected Airport
						highLight(isElementPresent("APGRemoveAp_xpath"), driver);
						isElementPresent("APGRemoveAp_xpath").click();
						System.out.println("Removed Selected value from the dropdown");
						logs.info("Removed Selected value from the dropdown");
						getScreenshot("APAFterRemove", "AirportGroup", driver);

						// AirportList
						highLight(isElementPresent("APGApList_id"), driver);
						WebElement APList = isElementPresent("APGApList_id");
						js.executeScript("arguments[0].scrollIntoView();", APList);
						isElementPresent("APGApList_id").sendKeys("ANY");
						System.out.println("Entered value in AirportGroup List");
						logs.info("Entered value in AirportGroup List");
						Thread.sleep(2000);
						isElementPresent("APGApList_id").sendKeys(Keys.DOWN);
						isElementPresent("APGApList_id").sendKeys(Keys.DOWN);
						isElementPresent("APGApList_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from the dropdown");
						logs.info("Selected value from the dropdown");
						getScreenshot("AirportGroupEditorwithdata_", "AirportGroup", driver);

						// Remove selected Airport
						highLight(isElementPresent("APGRemoveAp_xpath"), driver);
						isElementPresent("APGRemoveAp_xpath").click();
						System.out.println("Removed Selected value from the dropdown");
						logs.info("Removed Selected value from the dropdown");
						getScreenshot("APAFterRemove", "AirportGroup", driver);

						// --------AirportList search------Cancel-------
						highLight(isElementPresent("APGApSearch_id"), driver);
						isElementPresent("APGApSearch_id").click();
						System.out.println("Clicked on the Search button of AirportList");
						logs.info("Clicked on the Search button of AirportList");
						Thread.sleep(1000);
						getScreenshot("AirportListPopUp_", "AirportGroup", driver); // Cancel
						highLight(isElementPresent("APGAPSearchCancl_id"), driver);
						isElementPresent("APGAPSearchCancl_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"form-filed\"]")));

						// ----------AirportList search------Close-----------
						highLight(isElementPresent("APGApSearch_id"), driver);
						isElementPresent("APGApSearch_id").click();
						System.out.println("Clicked on the Search button of AirportList");
						logs.info("Clicked on the Search button of AirportList");
						Thread.sleep(1000);
						// Close
						highLight(isElementPresent("Close_xpath"), driver);
						WebElement close = isElementPresent("Close_xpath");
						js.executeScript("arguments[0].click();", close);
						System.out.println("Clicked on the Close button");
						logs.info("Clicked on Close Button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"form-filed\"]")));

						// -------AirportList search--------Submit-----------
						highLight(isElementPresent("APGApSearch_id"), driver);
						isElementPresent("APGApSearch_id").click();
						System.out.println("Clicked on the Search button of AirportList");
						logs.info("Clicked on the Search button of AirportList");
						Thread.sleep(1000);
						// PageSize
						WebElement pager = isElementPresent("pagerDiv_xpath");
						js.executeScript("arguments[0].scrollIntoView();", pager);
						pageSize("AirportGroup");
						// Pagination
						pagination("AirportGroup");
						// Additional Filter
						highLight(isElementPresent("APGAddFil_id"), driver);
						isElementPresent("APGAddFil_id").click();
						System.out.println("Clicked on the additional filter");
						logs.info("Clicked on the additional filter");
						getScreenshot("AirportListAddFilter_", "AirportGroup", driver);
						// Less Filter
						highLight(isElementPresent("APGLessFil_id"), driver);
						isElementPresent("APGLessFil_id").click();
						System.out.println("Clicked on the less filter");
						logs.info("Clicked on the less filter");
						getScreenshot("AirportListLessFilter_", "AirportGroup", driver); // AirportID
						highLight(isElementPresent("APGAPID_id"), driver);
						isElementPresent("APGAPID_id").sendKeys("ANY1");
						System.out.println("Entered value in AirportID");
						logs.info("Entered value in AirportID");
						// AirportName
						highLight(isElementPresent("APGApName_id"), driver);
						isElementPresent("APGApName_id").sendKeys("Anthony Municipal Airport Updated");
						System.out.println("Entered value in AirportName");
						logs.info("Entered value in AirportName");
						// Search
						highLight(isElementPresent("APGAPSearchAfFilter_id"), driver);
						isElementPresent("APGAPSearchAfFilter_id").click();
						System.out.println("Clicked on the search button");
						logs.info("Clicked on the search button");
						Thread.sleep(2000);
						getScreenshot("AirportListSearch_", "AirportGroup", driver);
						System.out
								.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
						logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
						ImageFile = isElementPresent("ApNoDataImage_xpath");
						if (ImageFile.isDisplayed()) {
							System.out.println("There is not any data related enetered search parameters");
							logs.info("There is not any data related enetered search parameters");
						} else {
							System.out.println("Data is present related enetered search parameters");
							logs.info("Data is present related enetered search parameters");
						}
						// select the airport
						highLight(isElementPresent("ApGLApSelect_xpath"), driver);
						isElementPresent("ApGLApSelect_xpath").click();
						System.out.println(
								"Selected the search airport" + isElementPresent("ApGLApSelect_xpath").isSelected());
						logs.info("Selected the search airport" + isElementPresent("ApGLApSelect_xpath").isSelected());
						getScreenshot("Apselected_", "AirportGroup", driver);
						// Submit-AIrportList Popup
						highLight(isElementPresent("APGApSubmit_id"), driver);
						isElementPresent("APGApSubmit_id").click();
						System.out.println("Clicked on SUbmit button");
						logs.info("Clicked on SUbmit button");
						getScreenshot("SelectedAP_", "AirportGroup", driver);
						if (isElementPresent("APGAListVal_xpath").isDisplayed()) {
							System.out.println("Airport is selected in AirportList");
							logs.info("Airport is selected in AirportList");
						} else {
							System.out.println("Airport is not selected in AirportList");
							logs.info("Airport is not selected in AirportList");
						}

						// Submit
						highLight(isElementPresent("APGPSubmit_id"), driver);
						isElementPresent("APGPSubmit_id").click();
						System.out.println("Clicked on SUbmit button");
						logs.info("Clicked on SUbmit button");
						waitForPageLoad();

					}
				}
				// ----Search-Delete AIrportGroup------------
				highLight(isElementPresent("APGSearch_id"), driver);
				isElementPresent("APGSearch_id").sendKeys("GROUND_TestAuto");
				isElementPresent("APGSearch_id").sendKeys(Keys.ENTER);
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterSearch", "AirportGroup", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					Thread.sleep(1000);
					// Expand
					highLight(isElementPresent("APGExp_xpath"), driver);
					isElementPresent("APGExp_xpath").click();
					System.out.println("Clicked on expand button of searched Airport");
					logs.info("Clicked on expand button of searched Airport");
					// ---- Delete-AIrportGroup-----------
					// Delete-KeepIt
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@src=\"/assets/img/delete-icon-dark.svg\"]")));
					highLight(isElementPresent("Del_xpath"), driver);
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("AltAPDelete_", "AirportGroup", driver);
					// Keep it
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					isElementPresent("DelKeepIt_xpath").click();
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("AltAPKeepIt_", "AirportGroup", driver);

					// Delete-DeleteIt
					waitForPageLoad();
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
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("AltAPDeleteIT_", "Airport", driver);

				}
				// Search-Clear
				highLight(isElementPresent("APGSearch_id"), driver);
				isElementPresent("APGSearch_id").clear();
				isElementPresent("APGSearch_id").sendKeys(Keys.ENTER);
				System.out.println("Cleared the entered search criteria");
				logs.info("Cleared the entered search criteria");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterClear", "AirportGroup", driver);

				// Show-InActive-Checked
				highLight(isElementPresent("APGpShwInAct_id"), driver);
				isElementPresent("APGpShwInAct_id").click();
				System.out.println("Click on Show InActive checkbox");
				logs.info("Click on Show InActive checkbox");
				Thread.sleep(2000);
				System.out.println(
						"Show InActive checkbox is checked==" + isElementPresent("APGpShwInAct_id").isSelected());
				logs.info("Show InActive checkbox is checked==" + isElementPresent("APGpShwInAct_id").isSelected());
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("ShowInActive", "AirportGroup", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Show-InActive-UnChecked
				highLight(isElementPresent("APGpShwInAct_id"), driver);
				isElementPresent("APGpShwInAct_id").click();
				System.out.println("Click on Show InActive checkbox");
				logs.info("Click on Show InActive checkbox");
				Thread.sleep(2000);
				System.out.println(
						"Show InActive checkbox is checked==" + isElementPresent("APGpShwInAct_id").isSelected());
				logs.info("Show InActive checkbox is checked==" + isElementPresent("APGpShwInAct_id").isSelected());
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("ShowInActive", "AirportGroup", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Active the deleted record
				System.out.println("---------ACtivate the deleted record---------");
				logs.info("-------------ACtivate the deleted record------------");
				highLight(isElementPresent("APGSearch_id"), driver);
				isElementPresent("APGSearch_id").sendKeys("GROUND_TestAuto");

				isElementPresent("APGSearch_id").sendKeys(Keys.ENTER);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//dx-data-grid[@id=\"gridContainer\"]")));
				WebElement SHwInAct = isElementPresent("APGpShwInAct_id");
				highLight(SHwInAct, driver);
				js.executeScript("arguments[0].click();", SHwInAct);
				System.out.println("Clicked on Show InACtive checkbox");
				System.out.println("Show InACtive is selected=="
						+ isElementPresent("APGpShwInAct_id").getAttribute("aria-checked"));
				logs.info("Clicked on Show InACtive checkbox");
				logs.info("Show InACtive is selected=="
						+ isElementPresent("APGpShwInAct_id").getAttribute("aria-checked"));
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				WebElement pagerdiv = isElementPresent("pagerDiv_xpath");
				js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
				System.out.println("scroll down");
				WebElement pagesize50n = isElementPresent("APPagesize50_xpath");
				pagesize50n = isElementPresent("APPagesize50_xpath");
				wait.until(ExpectedConditions.visibilityOf(pagesize50n));
				highLight(isElementPresent("APPagesize50_xpath"), driver);
				act.moveToElement(pagesize50n).click().perform();
				System.out.println("clicked on pagesize 50");
				logs.info("clicked on pagesize 50");
				Thread.sleep(2000);
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("AccSearchResultGrid_", "Account", driver);
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
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					getScreenshot("APGEditor", "AirportGroup", driver);
					Thread.sleep(3000);
					// ValidTo
					WebElement ValidTo = isElementPresent("APGValidTo_id");
					wait.until(ExpectedConditions.elementToBeClickable(ValidTo));
					js.executeScript("arguments[0].scrollIntoView();", ValidTo);
					highLight(isElementPresent("APGValidTo_id"), driver);
					ValidTo.clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					highLight(isElementPresent("APGValidTo_id"), driver);
					isElementPresent("APGValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// Submit
					highLight(isElementPresent("APGPSubmit_id"), driver);
					isElementPresent("APGPSubmit_id").click();
					System.out.println("Clicked on SUbmit button");
					logs.info("Clicked on SUbmit button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// PageSize
				pageSize("AirportGroup");

				// Pagination
				pagination("AirportGroup");

				js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				// NormalView
				normalView("AirportGroup");

				// Columns
				columns("AirportGroup");

				break;
			} else {
				System.out.println("AirportGroup is not exist in Admin menu");
				logs.info("AirportGroup is not exist in Admin menu");
			}
		}

	}
}
