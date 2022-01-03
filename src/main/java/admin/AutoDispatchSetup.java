package admin;

import java.io.IOException;
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

public class AutoDispatchSetup extends BaseInit {

	@Test
	public void AutoDispatchSetUp() throws InterruptedException, IOException {

		System.out.println("--------------Testing Auto Dispatch SetUp---------------");
		logs.info("--------------Testing Auto Dispatch SetUp---------------");
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
		getScreenshot("Admindiv_", "AutoDispatchSetUp", driver);

		// AutoDispatchSetUp SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// Auto Dispatch Setup
			if (headervalue.equalsIgnoreCase("Auto Dispatch Setup")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on Auto Dispatch SetUp");
				logs.info("Clicked on Auto Dispatch SetUp");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("AutoDispatchSetUpcreen_", "AutoDispatchSetUp", driver);

				// -------- Create-Back--------
				highLight(isElementPresent("ADSCreate_id"), driver);
				isElementPresent("ADSCreate_id").click();
				System.out.println("Clicked on create button");
				logs.info("Clicked on create button");
				wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("ADSBack_id")));
				getScreenshot("CreateScreen_", "AutoDispatchSetUp", driver);

				// Back
				highLight(isElementPresent("ADSBack_id"), driver);
				isElementPresent("ADSBack_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ADSSearch_id"), driver);
				isElementPresent("ADSSearch_id").sendKeys("3DP");
				isElementPresent("ADSSearch_id").sendKeys(Keys.ENTER);
				System.out.println("Enteredvalue in Searchbox");
				logs.info("Entered value in Searchbox");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// --- Filter--
				highLight(isElementPresent("ADSSearch_id"), driver);
				isElementPresent("ADSSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ADSFilter_id"), driver);
				isElementPresent("ADSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("AutoDSUpFilter_", "AutoDispatchSetUp", driver);
				// AgentID
				highLight(isElementPresent("ADSFAgentID_id"), driver);
				isElementPresent("ADSFAgentID_id").sendKeys("107066");
				System.out.println("Entered value in AgentID");
				logs.info("Entered value in AgentID");

				// Market Airport
				highLight(isElementPresent("ADSFMarkAp_id"), driver);
				isElementPresent("ADSFMarkAp_id").sendKeys("ANY1");
				System.out.println("Entered value in Market Airport");
				logs.info("Entered value in Market Airport");

				// Service
				highLight(isElementPresent("ADSFSericeID_id"), driver);
				isElementPresent("ADSFSericeID_id").click();
				Thread.sleep(1000);
				isElementPresent("ADSFSericeID_id").sendKeys("TSer10");
				isElementPresent("ADSFSericeID_id").sendKeys(Keys.ENTER);
				System.out.println("Entered value in Service");
				logs.info("Entered value in Service");

				// Apply Filter
				WebElement ApFi = isElementPresent("ADSAppFil_id");
				highLight(isElementPresent("ADSAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("AutoDSUpFilterData_", "AutoDispatchSetUp", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					WebElement Edit = isElementPresent("Edit_xpath");
					highLight(isElementPresent("Edit_xpath"), driver);
					js.executeScript("arguments[0].click();", Edit);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "AutoDispatchSetUp", driver);

					// AgentID
					highLight(isElementPresent("ADSAgentID_id"), driver);
					isElementPresent("ADSAgentID_id").clear();
					isElementPresent("ADSAgentID_id").sendKeys("107066");
					System.out.println("Entered value in Category field");
					logs.info("Entered value in Category field");

					// Name
					boolean Name = isElementPresent("ADSName_id").isEnabled();
					if (Name) {
						System.out.println("Name field is enabled");
						logs.info("Name field is enabled");
					} else {
						System.out.println("Name field is disabled");
						logs.info("Name field is disabled");
					}

					// Type
					highLight(isElementPresent("ADSType_id"), driver);
					isElementPresent("ADSType_id").clear();
					isElementPresent("ADSType_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSType_id").sendKeys(Keys.DOWN);
					isElementPresent("ADSType_id").sendKeys(Keys.DOWN);
					isElementPresent("ADSType_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");
					Thread.sleep(2000);

					// Airport
					highLight(isElementPresent("ADSAirport_id"), driver);
					isElementPresent("ADSAirport_id").clear();
					isElementPresent("ADSAirport_id").sendKeys("ANY1");
					System.out.println("Entered value in Airport field");
					logs.info("Entered value in Airport field");

					// ---Airport search--Cancel
					highLight(isElementPresent("ADSAirpSearch_id"), driver);
					isElementPresent("ADSAirpSearch_id").click();
					System.out.println("Clicked on the Search button of AirportList");
					logs.info("Clicked on the Search button of AirportList");
					Thread.sleep(1000);

					// Cancel
					highLight(isElementPresent("ADSApSCancel_id"), driver);
					isElementPresent("ADSApSCancel_id").click();
					System.out.println("Clicked on the Cancel button of AirportList");
					logs.info("Clicked on the Cancel button of AirportList");
					Thread.sleep(1000);

					// ---Airport search--close
					highLight(isElementPresent("ADSAirpSearch_id"), driver);
					isElementPresent("ADSAirpSearch_id").click();
					System.out.println("Clicked on the Search button of AirportList");
					logs.info("Clicked on the Search button of AirportList");
					Thread.sleep(1000);

					// Close
					highLight(isElementPresent("Close_xpath"), driver);
					isElementPresent("Close_xpath").click();
					System.out.println("Clicked on the Close button of AirportList");
					logs.info("Clicked on the Close button of AirportList");
					Thread.sleep(1000);

					// ---Airport search--Submit
					highLight(isElementPresent("ADSAirpSearch_id"), driver);
					isElementPresent("ADSAirpSearch_id").click();
					System.out.println("Clicked on the Search button of AirportList");
					logs.info("Clicked on the Search button of AirportList");
					Thread.sleep(1000);

					// PageSize
					WebElement pager = isElementPresent("pagerDiv_xpath");
					js.executeScript("arguments[0].scrollIntoView();", pager);
					// pageSize
					pageSize("AutoDispatchSetUp");
					// Pagination
					pagination("AutoDispatchSetUp");
					// Additional Filter
					highLight(isElementPresent("ADSApSAddFilter_id"), driver);
					isElementPresent("ADSApSAddFilter_id").click();
					System.out.println("Clicked on the additional filter");
					logs.info("Clicked on the additional filter");
					getScreenshot("AirportListAddFilter_", "AutoDispatchSetUp", driver); // Less
					// Less Filter
					highLight(isElementPresent("ADSApSLessFil_id"), driver);
					isElementPresent("ADSApSLessFil_id").click();
					System.out.println("Clicked on the less filter");
					logs.info("Clicked on the less filter");
					getScreenshot("AirportListLessFilter_", "AutoDispatchSetUp", driver); // AirportID
					highLight(isElementPresent("ADSApSAPID_id"), driver);
					isElementPresent("ADSApSAPID_id").sendKeys("ANY1");
					System.out.println("Entered value in AirportID");
					logs.info("Entered value in AirportID"); // AirportName
					// Search
					highLight(isElementPresent("ADSApSearch_id"), driver);
					isElementPresent("ADSApSearch_id").click();
					System.out.println("Clicked on the search button");
					logs.info("Clicked on the search button");
					Thread.sleep(2000);
					getScreenshot("AirportListSearch_", "AutoDispatchSetUp", driver);
					System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
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
					getScreenshot("Apselected_", "AutoDispatchSetUp", driver);
					// Submit-AIrportListPopup
					highLight(isElementPresent("ADSApSSubmit_id"), driver);
					isElementPresent("ADSApSSubmit_id").click();
					System.out.println("Clicked on SUbmit button");
					logs.info("Clicked on SUbmit button");
					getScreenshot("SelectedAP_", "AutoDispatchSetUp", driver);

					// ServiceID
					highLight(isElementPresent("ADSServiceID_id"), driver);
					isElementPresent("ADSServiceID_id").clear();
					isElementPresent("ADSServiceID_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSServiceID_id").sendKeys("TSer10");
					isElementPresent("ADSServiceID_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Service");
					logs.info("Entered value in Service");

					// Vehicle
					highLight(isElementPresent("ADSVehicle_id"), driver);
					isElementPresent("ADSVehicle_id").clear();
					isElementPresent("ADSVehicle_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSVehicle_id").sendKeys("CAR");
					isElementPresent("ADSVehicle_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Vehicle");
					logs.info("Entered value in Vehicle");

					// Priority Index
					highLight(isElementPresent("ADSPrioIndex_id"), driver);
					isElementPresent("ADSPrioIndex_id").clear();
					isElementPresent("ADSPrioIndex_id").sendKeys("1");
					System.out.println("Entered value in Priority Index field");
					logs.info("Entered value in Priority Index field");

					// Agent Capacity
					highLight(isElementPresent("ADSAgentCap_id"), driver);
					isElementPresent("ADSAgentCap_id").clear();
					isElementPresent("ADSAgentCap_id").sendKeys("10");
					System.out.println("Entered value in Agent Capacity field");
					logs.info("Entered value in Agent Capacity field");

					// Account
					highLight(isElementPresent("ADSAccount_id"), driver);
					isElementPresent("ADSAccount_id").clear();
					isElementPresent("ADSAccount_id").sendKeys("999073");
					System.out.println("Entered value in Account field");
					logs.info("Entered value in Account field");

					// AUto Dispatch
					highLight(isElementPresent("ADSAutoDispatch_id"), driver);
					isElementPresent("ADSAutoDispatch_id").click();
					System.out.println("Clicked on Auto Dispatch checkbox");
					logs.info("Clicked on Auto Dispatch checkbox");
					System.out.println("Auto Dispatch checkbox is selected=="
							+ isElementPresent("ADSAutoDispatch_id").isSelected());
					logs.info("Auto Dispatch checkbox==" + isElementPresent("ADSAutoDispatch_id").isSelected());

					// AUto Dispatch AFter Hour
					highLight(isElementPresent("ADSAutoDisAfHr_id"), driver);
					isElementPresent("ADSAutoDisAfHr_id").click();
					System.out.println("Clicked on Auto Dispatch After Hour checkbox");
					logs.info("Clicked on Auto Dispatch After Hour checkbox");
					System.out.println("Auto Dispatch After Hour checkbox is selected=="
							+ isElementPresent("ADSAutoDisAfHr_id").isSelected());
					logs.info(
							"Auto Dispatch After Hour checkbox==" + isElementPresent("ADSAutoDisAfHr_id").isSelected());

					// submit
					WebElement Sub = isElementPresent("ADSSubmit_id");
					highLight(isElementPresent("ADSSubmit_id"), driver);
					js.executeScript("arguments[0].click();", Sub);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

				}
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// --- Filter--
				highLight(isElementPresent("ADSSearch_id"), driver);
				isElementPresent("ADSSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ADSFilter_id"), driver);
				isElementPresent("ADSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("AutoDSUpFilter_", "AutoDispatchSetUp", driver);
				// AgentID
				highLight(isElementPresent("ADSFAgentID_id"), driver);
				isElementPresent("ADSFAgentID_id").sendKeys("107066");
				System.out.println("Entered value in AgentID");
				logs.info("Entered value in AgentID");

				// ZoneNAme
				highLight(isElementPresent("ADSFZoneName_id"), driver);
				isElementPresent("ADSFZoneName_id").click();
				Thread.sleep(1000);
				isElementPresent("ADSFZoneName_id").sendKeys("FLASH-ATL");
				Thread.sleep(1000);
				isElementPresent("ADSFZoneName_id").sendKeys(Keys.ENTER);
				System.out.println("selected value from Zone Name");
				logs.info("selected value from Zone Name");

				// Apply Filter
				ApFi = isElementPresent("ADSAppFil_id");
				highLight(isElementPresent("ADSAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("AutoDSUpFilterData_", "AutoDispatchSetUp", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					WebElement Edit = isElementPresent("Edit_xpath");
					highLight(isElementPresent("Edit_xpath"), driver);
					js.executeScript("arguments[0].click();", Edit);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "AutoDispatchSetUp", driver);

					// AgentID
					highLight(isElementPresent("ADSAgentID_id"), driver);
					isElementPresent("ADSAgentID_id").clear();
					isElementPresent("ADSAgentID_id").sendKeys("107066");
					System.out.println("Entered value in Category field");
					logs.info("Entered value in Category field");

					// Name
					boolean Name = isElementPresent("ADSName_id").isEnabled();
					if (Name) {
						System.out.println("Name field is enabled");
						logs.info("Name field is enabled");
					} else {
						System.out.println("Name field is disabled");
						logs.info("Name field is disabled");
					}

					// Type
					highLight(isElementPresent("ADSType_id"), driver);
					isElementPresent("ADSType_id").clear();
					isElementPresent("ADSType_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSType_id").sendKeys(Keys.DOWN);
					isElementPresent("ADSType_id").sendKeys(Keys.DOWN);
					isElementPresent("ADSType_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");
					Thread.sleep(2000);

					// ZoneNAme
					highLight(isElementPresent("ADSFZoneName_id"), driver);
					isElementPresent("ADSFZoneName_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSFZoneName_id").sendKeys("FLASH-ATL");
					Thread.sleep(1000);
					isElementPresent("ADSFZoneName_id").sendKeys(Keys.ENTER);
					System.out.println("selected value from Zone Name");
					logs.info("selected value from Zone Name");

					// ServiceID
					highLight(isElementPresent("ADSServiceID_id"), driver);
					isElementPresent("ADSServiceID_id").clear();
					isElementPresent("ADSServiceID_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSServiceID_id").sendKeys("TSer10");
					isElementPresent("ADSServiceID_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Service");
					logs.info("Entered value in Service");

					// Vehicle
					highLight(isElementPresent("ADSVehicle_id"), driver);
					isElementPresent("ADSVehicle_id").clear();
					isElementPresent("ADSVehicle_id").click();
					Thread.sleep(1000);
					isElementPresent("ADSVehicle_id").sendKeys("CAR");
					isElementPresent("ADSVehicle_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in Vehicle");
					logs.info("Entered value in Vehicle");

					// Priority Index
					highLight(isElementPresent("ADSPrioIndex_id"), driver);
					isElementPresent("ADSPrioIndex_id").clear();
					isElementPresent("ADSPrioIndex_id").sendKeys("2");
					System.out.println("Entered value in Priority Index field");
					logs.info("Entered value in Priority Index field");

					// Agent Capacity
					highLight(isElementPresent("ADSAgentCap_id"), driver);
					isElementPresent("ADSAgentCap_id").clear();
					isElementPresent("ADSAgentCap_id").sendKeys("5");
					System.out.println("Entered value in Agent Capacity field");
					logs.info("Entered value in Agent Capacity field");

					// Account
					highLight(isElementPresent("ADSAccount_id"), driver);
					isElementPresent("ADSAccount_id").clear();
					isElementPresent("ADSAccount_id").sendKeys("999073");
					System.out.println("Entered value in Account field");
					logs.info("Entered value in Account field");

					// AUto Dispatch
					highLight(isElementPresent("ADSAutoDispatch_id"), driver);
					isElementPresent("ADSAutoDispatch_id").click();
					System.out.println("Clicked on Auto Dispatch checkbox");
					logs.info("Clicked on Auto Dispatch checkbox");
					System.out.println("Auto Dispatch checkbox is selected=="
							+ isElementPresent("ADSAutoDispatch_id").isSelected());
					logs.info("Auto Dispatch checkbox==" + isElementPresent("ADSAutoDispatch_id").isSelected());

					// AUto Dispatch AFter Hour
					highLight(isElementPresent("ADSAutoDisAfHr_id"), driver);
					isElementPresent("ADSAutoDisAfHr_id").click();
					System.out.println("Clicked on Auto Dispatch After Hour checkbox");
					logs.info("Clicked on Auto Dispatch After Hour checkbox");
					System.out.println("Auto Dispatch After Hour checkbox is selected=="
							+ isElementPresent("ADSAutoDisAfHr_id").isSelected());
					logs.info(
							"Auto Dispatch After Hour checkbox==" + isElementPresent("ADSAutoDisAfHr_id").isSelected());

					// submit
					WebElement Sub = isElementPresent("ADSSubmit_id");
					highLight(isElementPresent("ADSSubmit_id"), driver);
					js.executeScript("arguments[0].click();", Sub);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

				}
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// PageSize
				pageSize("AutoDispatchSetUp");

				// pagination
				pagination("AutoDispatchSetUp");

				// normalView
				normalView("AutoDispatchSetUp");

				// columns
				columns("AutoDispatchSetUp");

				break;
			} else {
				System.out.println("Auto Dispatch SetUp is not exist");
				logs.info("Auto Dispatch SetUp is not exist");
			}

		}

	}

}
