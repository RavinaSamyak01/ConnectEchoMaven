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

public class Services extends BaseInit {
//-----ChangesRemaining because ID is not there-------
	@Test
	public void services() throws InterruptedException, IOException {
		System.out.println("--------------Testing SERVICES---------------");
		logs.info("--------------Testing SERVICES---------------");

		// Services From Navigation Bar
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Admin
		WebElement Admin = isElementPresent("Admin_xpath");
		highLight(Admin, driver);
		js.executeScript("arguments[0].click();", Admin);
		System.out.println("Clicked on the admin");
		test.log(LogStatus.INFO, "Clicked on the admin");
		logs.info("Clicked on the admin");
		getScreenshot("Admindiv_", "Services", driver);

		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			logs.info("value of header item is" + "=" + HeaderItem.get(count).getText());

			if (headervalue.equalsIgnoreCase("Services")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on Services");
				logs.info("Clicked on Services");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				Thread.sleep(1000);
				getScreenshot("Services_", "Services", driver);

				// Create button
				highLight(Hiteam, driver);
				isElementPresent("SerCreate_xpath").click();
				System.out.println("Click on Create button");
				logs.info("Click on Create button");
				waitForPageLoad();
				getScreenshot("Create_", "Services", driver);
				// Back button
				isElementPresent("SerEditback_xpath").click();
				System.out.println("clicked on Back button");
				logs.info("clicked on Back button");
				waitForPageLoad();

				// ------------Search--------------
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				isElementPresent("Sercode_xpath").sendKeys("TSer10");
				isElementPresent("SerName_xpath").sendKeys("AutomationTestService");
				System.out.println("entered Service Name");
				getScreenshot("SearchData_", "Services", driver);
				// SearchBTN
				isElementPresent("Search_xpath").click();
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
					getScreenshot("ServEditor_", "Services", driver);
					// Edit
					// Service code disable or not
					System.out.println(
							"Service code textbox is Enabled==" + isElementPresent("SerEditSerCode_xpath").isEnabled());

					// Service Name disable or not
					System.out.println(
							"Service Name textbox is Enabled==" + isElementPresent("SerName_xpath").isEnabled());
					// Description
					isElementPresent("SerEditDes_xpath").clear();
					isElementPresent("SerEditDes_xpath").sendKeys("It is testing service");
					System.out.println("Entered Description");
					logs.info("Entered Description");

					// Company Dropdown
					isElementPresent("SerEditCmp_xpath").click();
					System.out.println("Clicked on Company dropdown");
					logs.info("Clicked on Company dropdown");
					isElementPresent("SerEditCmp_xpath").click();

					// Transport Mode
					isElementPresent("SerEditTram_xpath").click();
					System.out.println("Clicked on TransportMode dropdown");
					logs.info("Clicked on TransportMode dropdown");
					isElementPresent("SerEditTram_xpath").sendKeys("Ground");
					Thread.sleep(1000);
					isElementPresent("SerEditTram_xpath").sendKeys(Keys.DOWN);
					isElementPresent("SerEditTram_xpath").sendKeys(Keys.ENTER);
					System.out.println("Selected Ground Transport Mode");
					logs.info("Selected Ground Transport Mode");

					// Drop LockOut Time
					isElementPresent("SerEditDlt_xpath").clear();
					isElementPresent("SerEditDlt_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");
					// Recover LockOut Time
					isElementPresent("SerEditRlt_xpath").clear();
					isElementPresent("SerEditRlt_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");
					// Sequence For Validation
					isElementPresent("SerEditsFv_xpath").click();
					isElementPresent("SerEditsFv_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");

					// Deadline Calculation By
					/*
					 * WebElement DCB = isElementPresent("SerEditDCB_xpath"); DCB.click();
					 * System.out.println("Clicked on Deadline Calculation By dropdown");
					 * logs.info("Clicked on Deadline Calculation By dropdown");
					 * DCB.sendKeys(Keys.DOWN); DCB.sendKeys(Keys.ENTER);
					 * System.out.println("Selected value in dropdown");
					 * logs.info("Selected value in dropdown");
					 */

					// Due Minimum
					WebElement DM = isElementPresent("SerEditDmin_xpath");
					js.executeScript("arguments[0].scrollIntoView();", DM);
					DM.clear();
					System.out.println("cleared value");
					logs.info("cleared value");
					isElementPresent("SerEditDmin_xpath").sendKeys("12");
					System.out.println("entered Numeric value in Due Minimum");
					logs.info("entered Numeric value in Due minimum");

					// Category
					/*
					 * isElementPresent("SerEditCat_xpath").click();
					 * System.out.println("Clicked on category dropdown");
					 * logs.info("Clicked on category dropdown");
					 * isElementPresent("SerEditCat_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("SerEditCat_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected category"); logs.info("Selected category");
					 */

					// Min stem mile
					WebElement MSM = isElementPresent("SerEditMSM_xpath");
					js.executeScript("arguments[0].click();", MSM);
					wait.until(ExpectedConditions.elementToBeClickable(MSM));
					act.moveToElement(MSM).click().perform();
					System.out.println("checkbox is checked==" + isElementPresent("SerEditMSM_xpath").isSelected());
					logs.info("checkbox is checked==" + isElementPresent("SerEditMSM_xpath").isSelected());

					// Flash services
					WebElement FlasS = isElementPresent("SerEditFS_xpath");
					act.moveToElement(FlasS).perform();
					js.executeScript("arguments[0].click();", FlasS);
					System.out.println("checkbox is checked");
					logs.info("checkbox is checked");

					// TSA Required
					WebElement TSA = isElementPresent("SerEditTQ_xpath");
					act.moveToElement(TSA).perform();
					js.executeScript("arguments[0].click();", TSA);
					System.out.println("checkbox is checked");
					logs.info("checkbox is checked");

					getScreenshot("EditorData_", "Services", driver);

					// Customer Stem Miles
					isElementPresent("SerEditCSM_xpath").clear();
					System.out.println("cleared value");
					logs.info("cleared value");
					isElementPresent("SerEditCSM_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");

					// Courier Stem Miles
					isElementPresent("SerEditCrSM_xpath").clear();
					System.out.println("cleared value");
					logs.info("cleared value");
					isElementPresent("SerEditCrSM_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");

					// Valid To
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 10);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("SerEditVT_xpath").sendKeys(newDate);
					System.out.println("Selected Date,10 days priorior from current Date");
					logs.info("Selected Date,10 days priorior from current Date");

					// After Hours Start
					isElementPresent("SerEditAHS_xpath").clear();
					System.out.println("cleared value");
					logs.info("cleared value");
					isElementPresent("SerEditAHS_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");

					// After Hours End
					isElementPresent("SerEditAHE_xpath").clear();
					System.out.println("cleared value");
					logs.info("cleared value");
					isElementPresent("SerEditAHE_xpath").sendKeys("12");
					System.out.println("entered Numeric value");
					logs.info("entered Numeric value");
					getScreenshot("EditorData2_", "Services", driver);

					// ----------------- Attribute Grid-----------------
					// pageSize
					pageSize("Services");

					// Pagination
					pagination("Services");

					// ---------Attribute type----------Unable to handle dropdown becauuse there is
					// nothing unique
					// Add Attribute button
					/*
					 * isElementPresent("SerEditAdAt_xpath").click();
					 * System.out.println("clicked on Add Attribute linktext");
					 * System.out.println("title of the popup is==" +
					 * isElementPresent("AdAtpu_xpath").getText());
					 * logs.info("clicked on Add Attribute linktext");
					 * logs.info("title of the popup is==" +
					 * isElementPresent("AdAtpu_xpath").getText());
					 * isElementPresent("AdAtAtdp_xpath").click();
					 * System.out.println("Clicked on Attribute dropdown");
					 * logs.info("Clicked on Attribute dropdown"); Thread.sleep(2000); WebElement
					 * AttributList= isElementPresent("");
					 * isElementPresent("AdAtAtdp_xpath").sendKeys(Keys.DOWN);
					 * isElementPresent("AdAtAtdp_xpath").sendKeys(Keys.ENTER);
					 * System.out.println("Selected value from dropdown");
					 * logs.info("Selected value from dropdown");
					 */

					// Submit button
					isElementPresent("SerEditSbm_xpath").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					getScreenshot("Submit_", "Services", driver);

					// Back button
					isElementPresent("SerEditback_xpath").click();
					System.out.println("clicked on Back button");
					logs.info("clicked on Back button");
					waitForPageLoad();

				}

				// cleared the search parameters
				isElementPresent("Sercode_xpath").clear();
				System.out.println("Cleared Service code");
				logs.info("Cleared Service code");

				isElementPresent("SerName_xpath").clear();
				System.out.println("Cleared Service Name");
				logs.info("Cleared Service Name");

				isElementPresent("Company_xpath").clear();
				System.out.println("Cleared Company");
				logs.info("Cleared Company");

				getScreenshot("ClearedSearch_", "Services", driver);

				// SearchBTN
				isElementPresent("Search_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				js.executeScript("arguments[0].scrollIntoView();", isElementPresent("GridRecord_xpath"));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultAfterClear_", "Services", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// -------- Additional Filter--------------
				js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				isElementPresent("Addfilter_xpath").click();
				System.out.println("Clicked on Additional Filter link text");
				logs.info("Clicked on Additional Filter link text");
				// ShowInActive-Checked
				isElementPresent("ShwInac_xpath").click();
				System.out.println("Clicked on Show InActive Checkbox");
				logs.info("Clicked on Show InActive Checkbox");
				getScreenshot("ShowInact_checked_", "Services", driver);

				// SearchBTN
				isElementPresent("Searchbtn_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultShwInact_", "Services", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// ShowInActive-UnChecked
				isElementPresent("ShwInac_xpath").click();
				System.out.println("Clicked on Show InActive Checkbox");
				logs.info("Clicked on Show InActive Checkbox");
				// TransportMode
				isElementPresent("Tranmode_xpath").click();
				System.out.println("Clicked on Transport Mode dropdown");
				logs.info("Clicked on Transport Mode dropdown");
				isElementPresent("Tranmode_xpath").sendKeys("Ground");
				Thread.sleep(1000);
				isElementPresent("Tranmode_xpath").sendKeys(Keys.DOWN);
				isElementPresent("Tranmode_xpath").sendKeys(Keys.ENTER);
				System.out.println("Selected transport mode");
				logs.info("Selected transport mode");
				getScreenshot("SearchData_", "Services", driver);

				// SearchBTN
				isElementPresent("Searchbtn_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultTraMode_", "Services", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// LessFilter
				isElementPresent("LessFilt_xpath").click();
				System.out.println("Clicked on show Less Filter button");
				logs.info("Clicked on show Less Filter button");
				getScreenshot("LessFil_", "Services", driver);

				// pageSize
				pageSize("Services");

				// pagination
				pagination("Services");

				// NormalView
				normalView("Services");

				// Columns
				columns("Services");

				break;

			} else {
				System.out.println("Services is not exist");
				logs.info("Services is not exist");
			}

		}

	}
}
