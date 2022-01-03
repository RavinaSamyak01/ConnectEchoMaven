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

import samyak_BasePackage.BaseInit;

public class Commodity extends BaseInit {
	@Test
	public void commodity() throws InterruptedException, IOException {
		System.out.println("--------------Testing COMMODITY---------------");
		logs.info("--------------Testing COMMODITY---------------");

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
		getScreenshot("Admindiv_", "Commodity", driver);

		// CategoryMaster SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// CategoryMaster
			if (headervalue.equalsIgnoreCase("Commodity")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on Commodity");
				logs.info("Clicked on Commodity");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("ComScreen_", "Commodity", driver);

				// Create
				System.out.println("--Testing Create------");
				logs.info("----------Testing Create-------");
				highLight(isElementPresent("ComCreate_id"), driver);
				isElementPresent("ComCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("ComCreate_", "Commodity", driver);

				// Cancel
				highLight(isElementPresent("ComCancel_id"), driver);
				isElementPresent("ComCancel_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ComSearch_xpath"), driver);
				isElementPresent("ComSearch_xpath").sendKeys("Yes");
				isElementPresent("ComSearch_xpath").sendKeys(Keys.ENTER);
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
				// Filter
				highLight(isElementPresent("ComSearch_xpath"), driver);
				isElementPresent("ComSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ComFilter_id"), driver);
				isElementPresent("ComFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("ComFilter_", "Commodity", driver);
				highLight(isElementPresent("ComFName_id"), driver);
				isElementPresent("ComFName_id").sendKeys("Automation Commodity");
				System.out.println("Entered value in name");
				logs.info("Entered value in name");
				WebElement ApFi = isElementPresent("ComAppFilter_id");
				highLight(isElementPresent("ComAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ComFilterData_", "Commodity", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					// Edit
					highLight(isElementPresent("Edit_xpath"), driver);
					WebElement Edit = isElementPresent("Edit_xpath");
					js.executeScript("arguments[0].click();", Edit);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "Commodity", driver);

					// Name
					highLight(isElementPresent("ComCName_id"), driver);
					isElementPresent("ComCName_id").clear();
					isElementPresent("ComCName_id").sendKeys("Automation Commodity");
					System.out.println("Entered value in Name field");
					logs.info("Entered value in Name field");

					// Instruction
					highLight(isElementPresent("ComCInst_id"), driver);
					isElementPresent("ComCInst_id").clear();
					isElementPresent("ComCInst_id").sendKeys("This is For Automation");
					System.out.println("Entered value in Instruction field");
					logs.info("Entered value in Instruction field");

					// UN
					highLight(isElementPresent("ComCUN_id"), driver);
					isElementPresent("ComCUN_id").clear();
					isElementPresent("ComCUN_id").sendKeys("AutoTD001");
					System.out.println("Entered value in Name field");
					logs.info("Entered value in Name field");

					// Class
					highLight(isElementPresent("ComCClass_id"), driver);
					isElementPresent("ComCClass_id").clear();
					isElementPresent("ComCClass_id").sendKeys("AutoClass");
					System.out.println("Entered value in Name field");
					logs.info("Entered value in Name field");

					// Dangerous Good
					highLight(isElementPresent("ComCDangGud_id"), driver);
					isElementPresent("ComCDangGud_id").click();
					System.out.println("Clicked on Dangerous Goods checkbox");
					logs.info("Clicked on Dangerous Goods checkbox");
					System.out.println(
							"Dangerous Goods checkbox is selected==" + isElementPresent("ComCDangGud_id").isSelected());
					logs.info("Dangerous Goods checkbox==" + isElementPresent("ComCDangGud_id").isSelected());

					// Device Type
					highLight(isElementPresent("ComCDeviceType_xpath"), driver);
					isElementPresent("ComCDeviceType_xpath").click();
					isElementPresent("ComCDeviceType_xpath").sendKeys("Automation Test Device");
					Thread.sleep(2000);
					isElementPresent("ComCDeviceType_xpath").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the device type");
					logs.info("Selected value from the device type");

					// Device Configuration
					highLight(isElementPresent("ComCDevCnfgID_xpath"), driver);
					isElementPresent("ComCDevCnfgID_xpath").click();
					isElementPresent("ComCDevCnfgID_xpath").sendKeys("Automation Configuration");
					Thread.sleep(2000);
					isElementPresent("ComCDevCnfgID_xpath").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the device Configuration");
					logs.info("Selected value from the device Configuration");
					getScreenshot("CommEditorwithdata_", "Commodity", driver);

					// submit
					highLight(isElementPresent("ComSubmit_id"), driver);
					WebElement Sub = isElementPresent("ComSubmit_id");
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

				// -------- Search------- Delete-----------
				highLight(isElementPresent("ComSearch_xpath"), driver);
				isElementPresent("ComSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ComFilter_id"), driver);
				isElementPresent("ComFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("ComFilter_", "Commodity", driver);
				highLight(isElementPresent("ComFName_id"), driver);
				isElementPresent("ComFName_id").sendKeys("Automation Commodity");
				System.out.println("Entered value in name");
				logs.info("Entered value in name");
				ApFi = isElementPresent("ComAppFilter_id");
				highLight(isElementPresent("ComAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ComFilterData_", "Commodity", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Delete
					highLight(isElementPresent("Del_xpath"), driver);
					WebElement Del = isElementPresent("Del_xpath");
					Del.click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("ComDelete_", "Commodity", driver);

					// Keep it
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("ComDltKeepIt_", "Commodity", driver);

					// Delete
					highLight(isElementPresent("Del_xpath"), driver);
					Del = isElementPresent("Del_xpath");
					Del.click();
					System.out.println("Clicked on Delete button");
					logs.info("Clicked on Delete button");
					Thread.sleep(1000);

					// DeleteIt
					highLight(isElementPresent("Delbtn_xpath"), driver);
					WebElement DltIt = isElementPresent("Delbtn_xpath");
					wait.until(ExpectedConditions.elementToBeClickable(Del));
					js.executeScript("arguments[0].click();", DltIt);
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					getScreenshot("ComDeleteDltIT_", "Commodity", driver);
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}
				// --Filter--ShowInActive-checked--Activate the deleted record
				highLight(isElementPresent("ComSearch_xpath"), driver);
				isElementPresent("ComSearch_xpath").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("ComFilter_id"), driver);
				isElementPresent("ComFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("ComFShwInActive_id"), driver);
				isElementPresent("ComFShwInActive_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("ComFShwInActive_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("ComFShwInActive_id").isSelected());
				getScreenshot("ComShwInActive_", "Commodity", driver);
				highLight(isElementPresent("ComAppFilter_id"), driver);
				ApFi = isElementPresent("ComAppFilter_id");
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("ComEdit_", "Commodity", driver);
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

					// Edit
					highLight(isElementPresent("Edit_xpath"), driver);
					isElementPresent("Edit_xpath").click();
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					Thread.sleep(2000);

					// --Valid to is not available---
					getScreenshot("ComEdtrwithData_", "Commodity", driver);

					// SUbmit
					highLight(isElementPresent("ComSubmit_id"), driver);
					WebElement Sub = isElementPresent("ComSubmit_id");
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
				// Filter-ShwInACtive-Unchecked
				highLight(isElementPresent("ComFilter_id"), driver);
				isElementPresent("ComFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("ComClearFilter_id"), driver);
				WebElement clear = isElementPresent("ComClearFilter_id");
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("ComFShwInActive_id"), driver);
				isElementPresent("ComFShwInActive_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("ComFShwInActive_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("ComFShwInActive_id").isSelected());
				getScreenshot("ComShwInActive_", "Commodity", driver);
				ApFi = isElementPresent("ComAppFilter_id");
				highLight(isElementPresent("ComAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("ComShwInActData_", "Commodity", driver);
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
				highLight(isElementPresent("ComFilter_id"), driver);
				isElementPresent("ComFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("ComClearFilter_id");
				highLight(isElementPresent("ComClearFilter_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				ApFi = isElementPresent("ComAppFilter_id");
				highLight(isElementPresent("ComAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ComGridAFClearF_", "Commodity", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Filter-Cancel
				highLight(isElementPresent("ComFilter_id"), driver);
				isElementPresent("ComFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("ComClearFilter_id");
				highLight(isElementPresent("ComClearFilter_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				WebElement Cancl = isElementPresent("ComFCancel_id");
				highLight(isElementPresent("ComFCancel_id"), driver);
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");

				// NormalView
				normalView("Commodity");

				// PageSize
				pageSize("Commodity");

				// Pagination
				pagination("Commodity");

				break;
			} else {
				System.out.println("Commodity is not exist");
				logs.info("Commodity is not exist");
			}

		}

	}
}
