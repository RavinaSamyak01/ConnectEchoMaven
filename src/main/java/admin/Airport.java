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
import com.relevantcodes.extentreports.LogStatus;

import samyak_BasePackage.BaseInit;

public class Airport extends BaseInit {

	@Test
	public void airport() throws InterruptedException, IOException {

		System.out.println("--------------Testing AIRPORT---------------");
		logs.info("--------------Testing AIRPORT---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Admin
		WebElement Admin = isElementPresent("Admin_xpath");
		highLight(Admin, driver);
		js.executeScript("arguments[0].click();", Admin);
		System.out.println("Clicked on the admin");
		test.log(LogStatus.INFO, "Clicked on the admin");
		logs.info("Clicked on the admin");
		getScreenshot("Admindiv_", "Airport", driver);

		// Airport SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// Airport
			if (headervalue.equalsIgnoreCase("Airport")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on Airport");
				test.log(LogStatus.INFO, "Clicked on Airport");
				logs.info("Clicked on Airport");
				waitForPageLoad();
				getScreenshot("AirportScreen_", "Airport", driver);

				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				// Search
				WebElement ApSearch = isElementPresent("APSearch_id");
				highLight(ApSearch, driver);
				ApSearch.click();
				ApSearch.sendKeys("US");
				ApSearch.sendKeys(Keys.ENTER);
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				test.log(LogStatus.INFO, "Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterSearch", "Airport", driver);

				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					test.log(LogStatus.INFO, "There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					test.log(LogStatus.INFO, "Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Search-Clear
				highLight(ApSearch, driver);
				ApSearch.clear();
				ApSearch.sendKeys(Keys.ENTER);
				System.out.println("Cleared the entered search criteria");
				test.log(LogStatus.INFO, "Cleared the entered search criteria");
				logs.info("Cleared the entered search criteria");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				test.log(LogStatus.INFO, "Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterClear", "Airport", driver);

				// Filter-ApplyFilter
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				WebElement Filter = isElementPresent("APFilter_id");
				highLight(Filter, driver);
				Filter.click();
				String Title = isElementPresent("APFilterPUTitle_xpath").getText();
				System.out.println("Title of the pop up is==" + Title);
				test.log(LogStatus.INFO, "Title of the pop up is==" + Title);
				logs.info("Title of the pop up is==" + Title);
				Thread.sleep(1000);
				getScreenshot("FilterPopup_", "Airport", driver);
				// AirportName
				WebElement ApName = isElementPresent("ApApName_id");
				highLight(ApName, driver);
				ApName.sendKeys("Th");
				System.out.println("Entered AirportName");
				WebElement AplyFil = isElementPresent("ApApplyFil_id");
				highLight(AplyFil, driver);
				js.executeScript("arguments[0].focus();", AplyFil);
				js.executeScript("arguments[0].click();", AplyFil);
				System.out.println("Clicked on Apply Filter Button");
				test.log(LogStatus.INFO, "Clicked on Apply Filter Button");
				logs.info("Clicked on Apply Filter Button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				test.log(LogStatus.INFO, "Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("ApplyFilter_", "Airport", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					test.log(LogStatus.INFO, "There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					test.log(LogStatus.INFO, "Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Filter-ClearFilter
				Filter = isElementPresent("APFilter_id");
				highLight(Filter, driver);
				Filter.click();
				Title = isElementPresent("APFilterPUTitle_xpath").getText();
				System.out.println("Title of the pop up is==" + Title);
				Thread.sleep(1000);
				getScreenshot("FilterPopup_", "Airport", driver);

				WebElement Clear = isElementPresent("ApClearFilter_id");
				highLight(Clear, driver);
				js.executeScript("arguments[0].click();", Clear);
				System.out.println("Clicked on Clear button");
				test.log(LogStatus.INFO, "Clicked on Clear button");
				logs.info("Clicked on Clear button");
				Thread.sleep(1000);
				AplyFil = isElementPresent("ApApplyFil_id");
				highLight(AplyFil, driver);
				js.executeScript("arguments[0].focus();", AplyFil);
				js.executeScript("arguments[0].click();", AplyFil);
				System.out.println("Clicked on Apply Filter Button");
				test.log(LogStatus.INFO, "Clicked on Apply Filter Button");
				logs.info("Clicked on Apply Filter Button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				test.log(LogStatus.INFO, "Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("ClearFilter_", "Airport", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					test.log(LogStatus.INFO, "There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					test.log(LogStatus.INFO, "Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// Filter-Cancel
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Filter = isElementPresent("APFilter_id");
				highLight(Filter, driver);
				Filter.click();
				Title = isElementPresent("APFilterPUTitle_xpath").getText();
				System.out.println("Title of the pop up is==" + Title);
				Thread.sleep(1000);
				getScreenshot("FilterPopup_", "Airport", driver);
				WebElement Cancel = isElementPresent("ApCancel_id");
				highLight(Cancel, driver);
				js.executeScript("arguments[0].click();", Cancel);
				System.out.println("Clicked on Cancel button");
				test.log(LogStatus.INFO, "Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				test.log(LogStatus.INFO, "Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("CancelFilter", "Airport", driver);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search-Filter-Edit-Back
				Filter = isElementPresent("APFilter_id");
				highLight(Filter, driver);
				Filter.click();
				test.log(LogStatus.INFO, "Clicked on Filter Button");
				logs.info("Clicked on Filter Button");
				Title = isElementPresent("APFilterPUTitle_xpath").getText();
				System.out.println("Title of the pop up is==" + Title);
				getScreenshot("FilterPopup_", "Airport", driver);
				WebElement ApID = isElementPresent("APApID_id");
				highLight(ApID, driver);
				ApID.sendKeys("ANY1");
				System.out.println("Entered Airport ID");
				test.log(LogStatus.INFO, "Entered Airport ID");
				logs.info("Entered Airport ID");
				AplyFil = isElementPresent("ApApplyFil_id");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(AplyFil, driver);
				js.executeScript("arguments[0].focus();", AplyFil);
				js.executeScript("arguments[0].click();", AplyFil);
				System.out.println("Clicked on Apply Filter Button");
				test.log(LogStatus.INFO, "Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					test.log(LogStatus.INFO, "There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					test.log(LogStatus.INFO, "Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					waitForPageLoad();
					Thread.sleep(2000);

					WebElement Back = isElementPresent("ApBack_id");
					highLight(Back, driver);
					Back.click();
					System.out.println("Clicked on the Back button");
					test.log(LogStatus.INFO, "Clicked on Back Button");
					logs.info("Clicked on Back Button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Search-Filter-Edit Name and ValidTo

				Filter = isElementPresent("APFilter_id");
				highLight(Filter, driver);
				Filter.click();
				test.log(LogStatus.INFO, "Clicked on Filter Button");
				logs.info("Clicked on Filter Button");
				Title = isElementPresent("APFilterPUTitle_xpath").getText();
				System.out.println("Title of the pop up is==" + Title);
				Thread.sleep(1000);
				getScreenshot("FilterPopup_", "Airport", driver);
				ApID = isElementPresent("APApID_id");
				highLight(ApID, driver);
				ApID.sendKeys("ANY1");
				System.out.println("Entered Airport ID");
				test.log(LogStatus.INFO, "Entered Airport ID");
				logs.info("Entered Airport ID");
				AplyFil = isElementPresent("ApApplyFil_id");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(AplyFil, driver);
				js.executeScript("arguments[0].focus();", AplyFil);
				js.executeScript("arguments[0].click();", AplyFil);
				System.out.println("Clicked on Apply Filter Button");
				test.log(LogStatus.INFO, "Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					test.log(LogStatus.INFO, "There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					test.log(LogStatus.INFO, "Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					waitForPageLoad();
					Thread.sleep(1000);
					System.out.println("Searched Record is opened in Edit mode");
					test.log(LogStatus.INFO, "Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					getScreenshot("AirportEditor_", "Airport", driver);

					// Edit-Name-ValidTo
					WebElement AName = isElementPresent("APEApName_id");
					wait.until(ExpectedConditions.elementToBeClickable(AName));
					highLight(AName, driver);
					isElementPresent("APEApName_id").clear();
					isElementPresent("APEApName_id").sendKeys("Anthony Municipal Airport Updated");
					System.out.println("Updated the value of Airport Name");
					test.log(LogStatus.INFO, "Updated the value of Airport Name");
					logs.info("Updated the value of Airport Name");
					// ValidTo
					WebElement ValidTo = isElementPresent("APVaidTo_xpath");
					wait.until(ExpectedConditions.elementToBeClickable(ValidTo));
					js.executeScript("arguments[0].scrollIntoView();", ValidTo);
					highLight(ValidTo, driver);
					ValidTo.clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					highLight(ValidTo, driver);
					isElementPresent("APEValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					test.log(LogStatus.INFO, "Selected Date,10 days priorior from current Date");
					logs.info("Selected Date,10 days priorior from current Date");

					// Alternative Airport-Cancel
					WebElement AlAP = isElementPresent("APAlAp_xpath");
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					highLight(AlAP, driver);
					AlAP.click();
					System.out.println("Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					test.log(LogStatus.INFO,
							"Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					logs.info("Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					getScreenshot("AltAirport_", "Airport", driver);
					// Cancel
					WebElement AACancel = isElementPresent("APAltApCancl_id");
					highLight(AACancel, driver);
					AACancel.click();
					System.out.println("Clicked on Cancel button");
					test.log(LogStatus.INFO, "Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]")));
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					getScreenshot("AltApCancel_", "Airport", driver);

					// Alternative Airport-Close
					AlAP = isElementPresent("APAlAp_xpath");
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					highLight(AlAP, driver);
					AlAP.click();
					System.out.println("Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					test.log(LogStatus.INFO,
							"Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					logs.info("Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					// Close
					WebElement close = isElementPresent("APALACls_xpath");
					highLight(close, driver);
					js.executeScript("arguments[0].click();", close);
					System.out.println("Clicked on Close button");
					test.log(LogStatus.INFO, "Clicked on Close button");
					logs.info("Clicked on Close button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]")));
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					getScreenshot("AltApClose_", "Airport", driver);

					// Alternative Airport-Submit
					AlAP = isElementPresent("APAlAp_xpath");
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					highLight(AlAP, driver);
					AlAP.click();
					System.out.println("Title of the popup is==" + isElementPresent("APALHeader_xpath").getText());
					// Entered value in AirportID
					WebElement AApID = isElementPresent("APALAPID_xpath");
					highLight(AApID, driver);
					AApID.click();
					AApID.sendKeys("00");
					Thread.sleep(2000);
					AApID.sendKeys(Keys.DOWN);
					AApID.sendKeys(Keys.ENTER);
					System.out.println("selected the AirportID");
					test.log(LogStatus.INFO, "selected the AirportID");
					logs.info("selected the AirportID");
					// Submit
					WebElement AAPSubmit = isElementPresent("APAltAPSub_id");
					highLight(AAPSubmit, driver);
					AAPSubmit.click();
					System.out.println("Clicked on Submit button");
					test.log(LogStatus.INFO, "Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]")));
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					getScreenshot("AltAPSubmit_", "Airport", driver);

					// Alternative Airport Grid-Edit
					// Edit
					WebElement Edt = isElementPresent("Edit_xpath");
					js.executeScript("arguments[0].scrollIntoView();", Edt);
					highLight(Edt, driver);
					Edt.click();
					System.out.println("Clicked on Edit button");
					test.log(LogStatus.INFO, "Clicked on Edit button");
					logs.info("Clicked on Edit button");
					getScreenshot("AltAPEdit_", "Airport", driver);
					// Close
					close = isElementPresent("APALACls_xpath");
					highLight(close, driver);
					js.executeScript("arguments[0].click();", close);
					System.out.println("Clicked on Close button");
					test.log(LogStatus.INFO, "Clicked on Close button");
					logs.info("Clicked on Close button");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]")));
					js.executeScript("arguments[0].scrollIntoView();", AlAP);

					// Delete-KeepIt
					js.executeScript("arguments[0].scrollIntoView();", Edt);
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@src=\"/assets/img/delete-icon-dark.svg\"]")));
					WebElement Del = isElementPresent("Del_xpath");
					highLight(Del, driver);
					Del.click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					test.log(LogStatus.INFO, "Clicked on Delete button");
					test.log(LogStatus.INFO, "Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					test.log(LogStatus.INFO, "Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("AltAPDelete_", "Airport", driver);
					// Keep it
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					isElementPresent("DelKeepIt_xpath").click();
					System.out.println("Clicked on Keep It button");
					test.log(LogStatus.INFO, "Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					getScreenshot("AltAPKeepIt_", "Airport", driver);

					// Delete-DeleteIt
					js.executeScript("arguments[0].scrollIntoView();", Edt);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					Del = isElementPresent("Del_xpath");
					highLight(Del, driver);
					Del.click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					test.log(LogStatus.INFO, "Clicked on Delete button");
					test.log(LogStatus.INFO, "Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					test.log(LogStatus.INFO, "Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					// DeleteIt
					highLight(isElementPresent("Delbtn_xpath"), driver);
					isElementPresent("Delbtn_xpath").click();
					System.out.println("Clicked on Delete It button");
					test.log(LogStatus.INFO, "Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					js.executeScript("arguments[0].scrollIntoView();", AlAP);
					getScreenshot("AltAPDeleteIT_", "Airport", driver);

					// Submit
					WebElement Submit = isElementPresent("ApSubmit_id");
					highLight(Submit, driver);
					Submit.click();
					System.out.println("Clicked on SUbmit button");
					// MSG
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
					isElementPresent("SubMsgHeader_xpath").getText();
					System.out
							.println("Message of the Header  is==" + isElementPresent("SubMsgHeader_xpath").getText());
					test.log(LogStatus.INFO,
							"Message of the Header  is==" + isElementPresent("SubMsgHeader_xpath").getText());
					logs.info("Message of the Header  is==" + isElementPresent("SubMsgHeader_xpath").getText());
					isElementPresent("SubMsg_xpath").getText();
					System.out.println("Message is==" + isElementPresent("SubMsg_xpath").getText());
					test.log(LogStatus.INFO, "Message is==" + isElementPresent("SubMsg_xpath").getText());
					logs.info("Message is==" + isElementPresent("SubMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					waitForPageLoad();

					// Search-Filter-Edit Zipcode with multipleCity
					Filter = isElementPresent("APFilter_id");
					highLight(Filter, driver);
					Filter.click();
					test.log(LogStatus.INFO, "Clicked on Filter Button");
					logs.info("Clicked on Filter Button");
					Title = isElementPresent("APFilterPUTitle_xpath").getText();
					System.out.println("Title of the pop up is==" + Title);
					Thread.sleep(1000);
					getScreenshot("FilterPopup_", "Airport", driver);
					ApID = isElementPresent("APApID_id");
					highLight(ApID, driver);
					ApID.sendKeys("ANY1");
					System.out.println("Entered Airport ID");
					test.log(LogStatus.INFO, "Entered Airport ID");
					logs.info("Entered Airport ID");
					AplyFil = isElementPresent("ApApplyFil_id");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					highLight(AplyFil, driver);
					js.executeScript("arguments[0].focus();", AplyFil);
					js.executeScript("arguments[0].click();", AplyFil);
					System.out.println("Clicked on Apply Filter Button");
					test.log(LogStatus.INFO, "Clicked on Apply Filter button");
					logs.info("Clicked on Apply Filter button");
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						test.log(LogStatus.INFO, "There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");
					} else {
						System.out.println("Data is present related enetered search parameters");
						test.log(LogStatus.INFO, "Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
						waitForPageLoad();
						Thread.sleep(2000);
						System.out.println("Searched Record is opened in Edit mode");
						test.log(LogStatus.INFO, "Searched Record is opened in Edit mode");
						logs.info("Searched Record is opened in Edit mode");
						getScreenshot("AirportEditor_", "Airport", driver);

						// Edit-Multiple City
						// Zip/PostalCode
						WebElement PostCode = isElementPresent("ApEZipCode_id");
						wait.until(ExpectedConditions.elementToBeClickable(PostCode));
						highLight(PostCode, driver);
						isElementPresent("ApEZipCode_id").clear();
						isElementPresent("ApEZipCode_id").sendKeys("77058");
						System.out.println("Entered value in Zip/PostalCode Field");
						test.log(LogStatus.INFO, "Entered value in Zip/PostalCode Field");
						logs.info("Entered value in Zip/PostalCode Field");
						isElementPresent("ApEZipCode_id").sendKeys(Keys.TAB);
						Thread.sleep(2000);
						// City
						WebElement City = isElementPresent("ApECity_id");
						highLight(City, driver);
						City.click();
						System.out.println("Clicked on City dropdown");
						test.log(LogStatus.INFO, "Clicked on City dropdown");
						logs.info("Clicked on City dropdown");
						Thread.sleep(2000);
						getScreenshot("MultipleCity_", "Airport", driver);
						isElementPresent("ApECity_id").sendKeys(Keys.DOWN);
						isElementPresent("ApECity_id").sendKeys(Keys.ENTER);
						System.out.println("Selected 1st value from the city dropdown");
						test.log(LogStatus.INFO, "Selected 1st value from the city dropdown");
						logs.info("Selected 1st value from the city dropdown");
						// Submit
						Submit = isElementPresent("ApSubmit_id");
						highLight(Submit, driver);
						Submit.click();
						System.out.println("Clicked on SUbmit button");
						test.log(LogStatus.INFO, "Clicked on SUbmit button");
						logs.info("Clicked on SUbmit button");
						// MSG
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
						isElementPresent("SubMsgHeader_xpath").getText();
						System.out.println(
								"Message of the Header  is==" + isElementPresent("SubMsgHeader_xpath").getText());
						test.log(LogStatus.INFO,
								"Message of the Header ==" + isElementPresent("SubMsgHeader_xpath").getText());
						logs.info("Message of the Header  is==" + isElementPresent("SubMsgHeader_xpath").getText());
						isElementPresent("SubMsg_xpath").getText();
						System.out.println("Message is==" + isElementPresent("SubMsg_xpath").getText());
						test.log(LogStatus.INFO, "Message is==" + isElementPresent("SubMsg_xpath").getText());
						logs.info("Message is==" + isElementPresent("SubMsg_xpath").getText());
						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
						waitForPageLoad();
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// PageSize
						pageSize("Airport");

						// Pagination
						pagination("Airport");

						// NormalView
						normalView("Airport");

						// Columns
						columns("Airport");

						break;
					}
				}

			} else {
				System.out.println("Airport is not exist in Admin menu");
				test.log(LogStatus.INFO, "Airport is not exist in Admin menu");
				logs.info("Airport is not exist in Admin menu");
			}

		}
	}

}
