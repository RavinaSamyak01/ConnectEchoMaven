package rate;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class CostTemplate extends BaseInit {

	@Test
	public void costTemplate() throws InterruptedException, IOException {
		System.out.println("--------------Testing CostTemplate---------------");
		logs.info("--------------Testing CostTemplate---------------");

		// Rate From Navigation Bar
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Rate
		highLight(isElementPresent("Rate_xpath"), driver);
		isElementPresent("Rate_xpath").click();
		System.out.println("Clicked on the Rate module");
		logs.info("Clicked on the Rate module");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//nav[@class=\"sidenav\"]")));

		// ExpandButton Of Rate
		highLight(isElementPresent("RateExpand_xpath"), driver);
		isElementPresent("RateExpand_xpath").click();
		System.out.println("Clicked on the expand button of Rate module");
		logs.info("Clicked on the expand button of Rate module");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//dx-accordion//dxi-item")));

		WebElement RateList = isElementPresent("Ratelist_xpath");
		System.out.println("stored xpath of RateList");
		List<WebElement> RateItem = RateList.findElements(By.className("dx-button-content"));
		System.out.println("stored all the RateItem");

		for (int count = 0; count < RateItem.size(); count++) {
			String headervalue = RateItem.get(count).getText();
			System.out.println("value of header item is" + "=" + RateItem.get(count).getText());
			logs.info("value of header item is" + "=" + RateItem.get(count).getText());

			if (headervalue.equalsIgnoreCase("Cost Template")) {
				WebElement Hiteam = RateItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on CostTemplate");
				logs.info("Clicked on CostTemplate");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("CostTemplate_", "CostTemplate", driver);

				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// ---Create---Close---
				/*
				 * highLight(isElementPresent("RCTCreate_id"), driver);
				 * isElementPresent("RCTCreate_id").click();
				 * System.out.println("clicked on Create button");
				 * logs.info("clicked on Create button"); Thread.sleep(1000);
				 * getScreenshot("CostTempCreate_", "CostTemplate", driver);
				 */

				// Close
				/*
				 * highLight(isElementPresent("Close_xpath"), driver); WebElement Close =
				 * isElementPresent("Close_xpath"); js.executeScript("arguments[0].click();",
				 * Close); act.moveToElement(Close).click().perform();
				 * System.out.println("clicked on Close button");
				 * logs.info("clicked on Close button"); wait.until(ExpectedConditions
				 * .visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]"
				 * ))); wait.until(ExpectedConditions .invisibilityOfElementLocated(By.xpath(
				 * "//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				 */
				// ---Create---Cancel---
				highLight(isElementPresent("RCTCreate_id"), driver);
				isElementPresent("RCTCreate_id").click();
				System.out.println("clicked on Create button");
				logs.info("clicked on Create button");
				Thread.sleep(1500);
				getScreenshot("CostTempCreate_", "CostTemplate", driver);

				// VendorType
				highLight(isElementPresent("RCTVendType_id"), driver);
				isElementPresent("RCTVendType_id").click();
				Thread.sleep(2000);
				isElementPresent("RCTVendType_id").sendKeys("Courier");
				Thread.sleep(1000);
				isElementPresent("RCTVendType_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Vendor Type dropdown");
				logs.info("Selected value from Vendor Type dropdown");

				// Name
				highLight(isElementPresent("RCTName_id"), driver);
				isElementPresent("RCTName_id").sendKeys("AutomationCostTemplate");
				System.out.println("Entered Name");
				logs.info("Entered Name");

				// Description
				highLight(isElementPresent("RCTDesc_id"), driver);
				isElementPresent("RCTDesc_id").sendKeys("This is for Automation Testing");
				System.out.println("Entered Description");
				logs.info("Entered Description");

				// Currency
				highLight(isElementPresent("RCTCurrency_id"), driver);
				isElementPresent("RCTCurrency_id").click();
				Thread.sleep(2000);
				isElementPresent("RCTCurrency_id").sendKeys("US Dollars");
				Thread.sleep(1000);
				isElementPresent("RCTCurrency_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Currency dropdown");
				logs.info("Selected value from Currency dropdown");

				// Tax%
				highLight(isElementPresent("RCTTax_id"), driver);
				isElementPresent("RCTTax_id").sendKeys("45");
				System.out.println("Entered Tax");
				logs.info("Entered Tax");

				// Status
				highLight(isElementPresent("RCTStatus_id"), driver);
				isElementPresent("RCTStatus_id").click();
				Thread.sleep(2000);
				isElementPresent("RCTStatus_id").sendKeys("Approved");
				Thread.sleep(1000);
				isElementPresent("RCTStatus_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Status dropdown");
				logs.info("Selected value from Status dropdown");

				getScreenshot("CreateData_", "CostTemplate", driver);

				// Cancel
				highLight(isElementPresent("RCTCancel_id"), driver);
				isElementPresent("RCTCancel_id").click();
				System.out.println("clicked on Cancel button");
				logs.info("clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// ------------Search--------------
				// VendorType
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("RCTSVendType_id"), driver);
				isElementPresent("RCTSVendType_id").click();
				Thread.sleep(2000);
				highLight(isElementPresent("RCTSVendType_id"), driver);
				isElementPresent("RCTSVendType_id").sendKeys("Courier");
				Thread.sleep(1000);
				isElementPresent("RCTSVendType_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Vendor Type dropdown");
				logs.info("Selected value from Vendor Type dropdown");
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").sendKeys("AutomationCostTemplate");
				System.out.println("Entered Name");
				logs.info("Entered Name");
				// Status
				highLight(isElementPresent("RCTSStatus_id"), driver);
				isElementPresent("RCTSStatus_id").click();
				Thread.sleep(2000);
				isElementPresent("RCTSStatus_id").sendKeys("Approved");
				Thread.sleep(1000);
				isElementPresent("RCTSStatus_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Status dropdown");
				logs.info("Selected value from Status dropdown");
				getScreenshot("SearchData_", "CostTemplate", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				String Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "CostTemplate", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
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
					getScreenshot("Editor_", "BagType", driver);

					// VendorType

					boolean VendType = isElementPresent("RCTVendType_id").isEnabled();
					Assert.assertFalse(VendType, "VendorType is Disabled");

					if (VendType) {
						System.out.println("VendorType is Enabled");
						logs.info("VendorType is Enabled");

					} else {
						System.out.println("VendorType is Disabled");
						logs.info("VendorType is Disabled");
					}

					// Name
					highLight(isElementPresent("RCTName_id"), driver);
					isElementPresent("RCTName_id").clear();
					isElementPresent("RCTName_id").sendKeys("AutomationCostTemplate");
					System.out.println("Entered Name");
					logs.info("Entered Name");

					// Description

					highLight(isElementPresent("RCTDesc_id"), driver);
					isElementPresent("RCTDesc_id").clear();
					isElementPresent("RCTDesc_id").sendKeys("This is for Automation Testing");
					System.out.println("Entered Description");
					logs.info("Entered Description");

					// Currency
					boolean Currency = isElementPresent("RCTCurrency_id").isEnabled();
					if (Currency) {
						System.out.println("Currency is Enabled");
						logs.info("Currency is Enabled");

					} else {
						System.out.println("Currency is Disabled");
						logs.info("Currency is Disabled");
					}

					// Tax%
					boolean Tax = isElementPresent("RCTTax_id").isEnabled();
					if (Tax) {
						System.out.println("Tax is Enabled");
						logs.info("Tax is Enabled");

					} else {
						System.out.println("Tax is Disabled");
						logs.info("Tax is Disabled");
					}

					// Status
					highLight(isElementPresent("RCTStatus_id"), driver);
					isElementPresent("RCTStatus_id").clear();
					isElementPresent("RCTStatus_id").click();
					Thread.sleep(2000);
					isElementPresent("RCTStatus_id").sendKeys("Approved");
					Thread.sleep(1000);
					isElementPresent("RCTStatus_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from Status dropdown");
					logs.info("Selected value from Status dropdown");

					getScreenshot("Editorwithdata_", "BagType", driver);

					// submit
					WebElement Sub = isElementPresent("RCTSubmit_id");
					highLight(isElementPresent("RCTSubmit_id"), driver);
					js.executeScript("arguments[0].click();", Sub);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("Submit Message=" + isElementPresent("SubMsg_xpath").getText());
					logs.info("Submit Message=" + isElementPresent("SubMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

				}

				// cleared the search parameters
				// Clear
				highLight(isElementPresent("RCTClear_xpath"), driver);
				isElementPresent("RCTClear_xpath").click();
				System.out.println("Clicked on Clear button");
				logs.info("Clicked on Clear button");
				getScreenshot("ClearedSearch_", "CostTemplate", driver);

				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				js.executeScript("arguments[0].scrollIntoView();", isElementPresent("GridRecord_xpath"));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultAfterClear_", "CostTemplate", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// ------------Search--AddCostType--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// ScrollUp
				act.sendKeys(Keys.HOME).build().perform();
				js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				// VendorType
				highLight(isElementPresent("RCTSVendType_id"), driver);
				isElementPresent("RCTSVendType_id").click();
				Thread.sleep(2000);
				highLight(isElementPresent("RCTSVendType_id"), driver);
				isElementPresent("RCTSVendType_id").sendKeys("Courier");
				Thread.sleep(1000);
				isElementPresent("RCTSVendType_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Vendor Type dropdown");
				logs.info("Selected value from Vendor Type dropdown");
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").sendKeys("AutomationCostTemplate");
				System.out.println("Entered Name");
				logs.info("Entered Name");
				getScreenshot("SearchData_", "CostTemplate", driver);
				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "CostTemplate", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// ---AddCostType---Cancel----
					highLight(isElementPresent("Add_xpath"), driver);
					isElementPresent("Add_xpath").click();
					System.out.println("Clicked on the AddCostType button");
					logs.info("Clicked on the AddCostType button");
					Thread.sleep(1000);
					getScreenshot("AddCostTypeScreen_", "CTAddCostType", driver);

					// Add
					highLight(isElementPresent("RCTCostTypeAdd_id"), driver);
					isElementPresent("RCTCostTypeAdd_id").click();
					System.out.println("Clicked on the Add button AddCostType");
					logs.info("Clicked on the Add button AddCostType");

					// Cancel
					highLight(isElementPresent("RCostTCancel_id"), driver);
					isElementPresent("RCostTCancel_id").click();
					System.out.println("Clicked on the Cancel button");
					logs.info("Clicked on the Cancel button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// ---AddCostType---Submit
					// Add
					highLight(isElementPresent("RCTCostTypeAdd_id"), driver);
					isElementPresent("RCTCostTypeAdd_id").click();
					System.out.println("Clicked on the Add button AddCostType");
					logs.info("Clicked on the Add button AddCostType");

					// CostType
					highLight(isElementPresent("RCostType_id"), driver);
					isElementPresent("RCostType_id").click();
					Thread.sleep(2000);
					isElementPresent("RCostType_id").sendKeys("AutomationCost");
					Thread.sleep(1000);
					isElementPresent("RCostType_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from CostType dropdown");
					logs.info("Selected value from CostType dropdown");

					// Apply When
					highLight(isElementPresent("RCostTApplyWhen_id"), driver);
					isElementPresent("RCostTApplyWhen_id").clear();
					isElementPresent("RCostTApplyWhen_id").click();
					Thread.sleep(2000);
					isElementPresent("RCostTApplyWhen_id").sendKeys("AutomationCharge");
					Thread.sleep(1000);
					isElementPresent("RCostTApplyWhen_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from ApplyWhen dropdown");
					logs.info("Selected value from ApplyWhen dropdown");

					// Calculation Method
					highLight(isElementPresent("RCostTCalcMethod_id"), driver);
					isElementPresent("RCostTCalcMethod_id").clear();
					isElementPresent("RCostTCalcMethod_id").click();
					Thread.sleep(2000);
					isElementPresent("RCostTCalcMethod_id").sendKeys("PERCENT");
					Thread.sleep(1000);
					isElementPresent("RCostTCalcMethod_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from CalculationMethod dropdown");
					logs.info("Selected value from CalculationMethod dropdown");

					// Percentage
					highLight(isElementPresent("RCostTCalPer_id"), driver);
					isElementPresent("RCostTCalPer_id").sendKeys("20");
					System.out.println("Entered value in Percentage");
					logs.info("Entered value in Percentage");

					getScreenshot("AddCostTypeData_", "CTAddCostType", driver);

					// Submit
					highLight(isElementPresent("RCostTSubmit_id"), driver);
					isElementPresent("RCostTSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					getScreenshot("SearchResult_", "CostTemplate", driver);
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
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
						Thread.sleep(2000);

						// Cost Type
						boolean CostType = isElementPresent("RCostType_id").isEnabled();
						if (CostType) {
							System.out.println("CostType is Enabled");
							logs.info("CostType is Enabled");

						} else {
							System.out.println("CostType is Disabled");
							logs.info("CostType is Disabled");
						}

						// Apply When
						highLight(isElementPresent("RCostTApplyWhen_id"), driver);
						isElementPresent("RCostTApplyWhen_id").clear();
						isElementPresent("RCostTApplyWhen_id").click();
						Thread.sleep(2000);
						isElementPresent("RCostTApplyWhen_id").sendKeys("AutomationCharge");
						Thread.sleep(1000);
						isElementPresent("RCostTApplyWhen_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from ApplyWhen dropdown");
						logs.info("Selected value from ApplyWhen dropdown");

						// Calculation Method
						highLight(isElementPresent("RCostTCalcMethod_id"), driver);
						isElementPresent("RCostTCalcMethod_id").clear();
						isElementPresent("RCostTCalcMethod_id").click();
						Thread.sleep(2000);
						isElementPresent("RCostTCalcMethod_id").sendKeys("PERCENT");
						Thread.sleep(1000);
						isElementPresent("RCostTCalcMethod_id").sendKeys(Keys.ENTER);
						System.out.println("Selected value from CalculationMethod dropdown");
						logs.info("Selected value from CalculationMethod dropdown");

						// Percentage
						highLight(isElementPresent("RCostTCalPer_id"), driver);
						isElementPresent("RCostTCalPer_id").clear();
						isElementPresent("RCostTCalPer_id").sendKeys("20");
						System.out.println("Entered value in Percentage");
						logs.info("Entered value in Percentage");

						getScreenshot("AddCostTypeData_", "CTAddCostType", driver);

						// Submit
						highLight(isElementPresent("RCostTSubmit_id"), driver);
						isElementPresent("RCostTSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// pageSize
						pageSize("CTAddCostType");

						// pagination
						pagination("CTAddCostType");

						// NormalView
						normalView("CTAddCostType");

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
						getScreenshot("CostTemplateDelete_", "CostTemplate", driver);

						// Keep it
						WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
						highLight(isElementPresent("DelKeepIt_xpath"), driver);
						js.executeScript("arguments[0].click();", KeepIt);
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("CostTemplateDltKeepIt_", "CostTemplate", driver);

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
						getScreenshot("CostTemplateDeleteDltIT_", "CostTemplate", driver);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Delete Message=" + isElementPresent("SubMsg_xpath").getText());
						logs.info("Delete Message=" + isElementPresent("SubMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// Columns
						columns("CTAddCostType");

						// Navigate to Cost Template
						highLight(isElementPresent("RCTNav_xpath"), driver);
						isElementPresent("RCTNav_xpath").click();
						System.out.println("Clicked on Cost template from navigation bar");
						logs.info("Clicked on Cost template from navigation bar");
						waitForPageLoad();

					}
				}

				// ------------Search--Copy--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").clear();
				isElementPresent("RCTSName_id").sendKeys("AutomationCostTemplate");
				System.out.println("Entered Name");
				logs.info("Entered Name");
				getScreenshot("SearchData_", "CostTemplate", driver);
				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "CostTemplate", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// ----Copy---Skip-----
					highLight(isElementPresent("Copy_xpath"), driver);
					isElementPresent("Copy_xpath").click();
					System.out.println("Clicked on the Copy button");
					logs.info("Clicked on the Copy button");
					Thread.sleep(1000);

					// Skip
					WebElement Skip = isElementPresent("CostTempCopySkip_id");
					highLight(isElementPresent("CostTempCopySkip_id"), driver);
					js.executeScript("arguments[0].click();", Skip);
					System.out.println("Clicked on Skip button");
					logs.info("Clicked on Skip button");
					getScreenshot("CostTempCopySkip__", "CostTemplate", driver);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("Record after Skip Copy " + " " + Data);
					logs.info("Record after Skip copy" + " " + Data);

					// ----Copy---OK----
					highLight(isElementPresent("Copy_xpath"), driver);
					isElementPresent("Copy_xpath").click();
					System.out.println("Clicked on the Copy button");
					logs.info("Clicked on the Copy button");
					Thread.sleep(1000);

					// OK
					WebElement OK = isElementPresent("CostTempCopyOk_id");
					highLight(isElementPresent("CostTempCopyOk_id"), driver);
					js.executeScript("arguments[0].click();", OK);
					System.out.println("Clicked on OK button");
					logs.info("Clicked on OK button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("CostTempCopyOK__", "CostTemplate", driver);
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("Record after copy " + " " + Data);
					logs.info("Record after copy" + " " + Data);
				}

				// ------------Search--Delete--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").clear();
				System.out.println("Cleared Name");
				logs.info("Cleared Name");
				isElementPresent("RCTSName_id").sendKeys("AutomationCostTemplate");
				System.out.println("Entered Name");
				logs.info("Entered Name");
				getScreenshot("SearchData_", "CostTemplate", driver);
				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "CostTemplate", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

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
					getScreenshot("BagTypeDelete_", "BagType", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("BagTypeDltKeepIt_", "BagType", driver);

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
					getScreenshot("BagTypeDeleteDltIT_", "BagType", driver);
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					System.out.println("Delete Message=" + isElementPresent("SubMsg_xpath").getText());
					logs.info("Delete Message=" + isElementPresent("SubMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				}

				// ------------Search--Active the record--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").clear();
				System.out.println("Cleared Name");
				logs.info("Cleared Name");
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").sendKeys("AutomationCostTemplate");
				System.out.println("Entered Name");
				logs.info("Entered Name");

				// Status
				highLight(isElementPresent("RCTSStatus_id"), driver);
				isElementPresent("RCTSStatus_id").click();
				Thread.sleep(2000);
				isElementPresent("RCTSStatus_id").sendKeys("Deleted");
				Thread.sleep(1000);
				isElementPresent("RCTSStatus_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Status dropdown");
				logs.info("Selected value from Status dropdown");

				getScreenshot("SearchData_", "CostTemplate", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "CostTemplate", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
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
					getScreenshot("Editor_", "BagType", driver);

					// Status
					highLight(isElementPresent("RCTStatus_id"), driver);
					isElementPresent("RCTStatus_id").click();
					Thread.sleep(2000);
					isElementPresent("RCTStatus_id").sendKeys("Approved");
					Thread.sleep(1000);
					isElementPresent("RCTStatus_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from Status dropdown");
					logs.info("Selected value from Status dropdown");

					getScreenshot("Editorwithdata_", "BagType", driver);

					// submit
					WebElement Sub = isElementPresent("RCTSubmit_id");
					highLight(isElementPresent("RCTSubmit_id"), driver);
					js.executeScript("arguments[0].click();", Sub);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("Submit Message=" + isElementPresent("SubMsg_xpath").getText());
					logs.info("Submit Message=" + isElementPresent("SubMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

				}
				// ---Clear search------
				// Name
				highLight(isElementPresent("RCTSName_id"), driver);
				isElementPresent("RCTSName_id").clear();
				System.out.println("Cleared Name");
				logs.info("Cleared Name");
				// Status
				highLight(isElementPresent("RCTSStatus_id"), driver);
				isElementPresent("RCTSStatus_id").clear();
				System.out.println("Cleared Status");
				logs.info("Cleared Status");
				getScreenshot("ClearedSearch_", "CostTemplate", driver);

				// SearchBTN
				highLight(isElementPresent("RCTSearch_id"), driver);
				isElementPresent("RCTSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				js.executeScript("arguments[0].scrollIntoView();", isElementPresent("GridRecord_xpath"));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultAfterClear_", "CostTemplate", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// pageSize
				pageSize("CostTemplate");

				// pagination
				pagination("CostTemplate");

				// NormalView
				normalView("CostTemplate");

				// Columns
				columns("CostTemplate");

				break;

			} else {
				System.out.println("CostTemplate is not exist");
				logs.info("CostTemplate is not exist");
			}

		}

	}

}
