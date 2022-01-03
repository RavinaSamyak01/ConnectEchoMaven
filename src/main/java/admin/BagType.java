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

public class BagType extends BaseInit {

	@Test
	public void bagType() throws InterruptedException, IOException {
		System.out.println("--------------Testing BagType---------------");
		logs.info("--------------Testing BagType---------------");

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
		getScreenshot("Admindiv_", "BagType", driver);

		// Admin
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// BagType
			if (headervalue.equalsIgnoreCase("Bag Type")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on BagType");
				logs.info("Clicked on BagType");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("BagTypeScreen_", "BagType", driver);

				// Create
				System.out.println("--Testing Create------");
				logs.info("----------Testing Create-------");
				highLight(isElementPresent("BTCreate_id"), driver);
				isElementPresent("BTCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("BagTypeCreate_", "BagType", driver);

				// Cancel
				highLight(isElementPresent("BTCancel_id"), driver);
				isElementPresent("BTCancel_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("BTSearch_id"), driver);
				isElementPresent("BTSearch_id").sendKeys("Automation Bag");
				isElementPresent("BTSearch_id").sendKeys(Keys.ENTER);
				System.out.println("Entered value in Searchbox");
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
				highLight(isElementPresent("BTSearch_id"), driver);
				isElementPresent("BTSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("BTFilter_id"), driver);
				isElementPresent("BTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("BagTypeFilter_", "BagType", driver);
				highLight(isElementPresent("BTFName_id"), driver);
				isElementPresent("BTFName_id").sendKeys("Automation Bag");
				System.out.println("Entered value in Name");
				logs.info("Entered value in Name");
				WebElement ApFi = isElementPresent("BTFAppFil_id");
				highLight(isElementPresent("BTFName_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("FilterData_", "BagType", driver);
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
					getScreenshot("Editor_", "BagType", driver);

					// Name
					highLight(isElementPresent("BTName_id"), driver);
					isElementPresent("BTName_id").clear();
					isElementPresent("BTName_id").sendKeys("Automation Bag");
					System.out.println("entered Name");
					logs.info("entered Name");

					// Description
					highLight(isElementPresent("BTDescription_id"), driver);
					isElementPresent("BTDescription_id").clear();
					isElementPresent("BTDescription_id").sendKeys("This is for Automation Testing");
					System.out.println("entered Description");
					logs.info("entered Description");

					// Documents
					highLight(isElementPresent("BTDocument_id"), driver);
					isElementPresent("BTDocument_id").click();
					System.out.println("Document is selected==" + isElementPresent("BTDocument_id").isSelected());
					logs.info("Document is selected==" + isElementPresent("BTDocument_id").isSelected());
					getScreenshot("BagTypeDoc_", "BagType", driver);

					// ValidTo
					highLight(isElementPresent("BTValidTo_id"), driver);
					isElementPresent("BTValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("BTValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("Editorwithdata_", "BagType", driver);

					// submit
					highLight(isElementPresent("BTSubmit_id"), driver);
					WebElement Sub = isElementPresent("BTSubmit_id");
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
				highLight(isElementPresent("BTSearch_id"), driver);
				isElementPresent("BTSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("BTFilter_id"), driver);
				isElementPresent("BTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("BagTypeFilter_", "BagType", driver);
				highLight(isElementPresent("BTFName_id"), driver);
				isElementPresent("BTFName_id").sendKeys("Automation Bag");
				System.out.println("Entered value in name");
				logs.info("Entered value in name");
				ApFi = isElementPresent("BTFAppFil_id");
				highLight(isElementPresent("BTFAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("BagTypeFilterData_", "BagType", driver);
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
					getScreenshot("BagTypeDelete_", "BagType", driver);

					// Keep it
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("BagTypeDltKeepIt_", "BagType", driver);

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
					getScreenshot("BagTypeDeleteDltIT_", "BagType", driver);
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
				highLight(isElementPresent("BTSearch_id"), driver);
				isElementPresent("BTSearch_id").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("BTFilter_id"), driver);
				isElementPresent("BTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("BTFShwInAct_id"), driver);
				isElementPresent("BTFShwInAct_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("BTFShwInAct_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("BTFShwInAct_id").isSelected());
				getScreenshot("BagTypeShwInActive_", "BagType", driver);
				highLight(isElementPresent("BTFAppFil_id"), driver);
				ApFi = isElementPresent("BTFAppFil_id");
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("BagTypeEdit_", "BagType", driver);
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

					// ValidTo
					highLight(isElementPresent("BTValidTo_id"), driver);
					isElementPresent("BTValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("BTValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("BagTypeEdtrwithData_", "BagType", driver);

					// SUbmit
					WebElement Sub = isElementPresent("BTSubmit_id");
					highLight(isElementPresent("BTSubmit_id"), driver);
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
				highLight(isElementPresent("BTFilter_id"), driver);
				isElementPresent("BTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				WebElement clear = isElementPresent("BTFClearFil_id");
				highLight(isElementPresent("BTFClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("BTFShwInAct_id"), driver);
				isElementPresent("BTFShwInAct_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("BTFShwInAct_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("BTFShwInAct_id").isSelected());
				getScreenshot("BagTypeShwInActive_", "BagType", driver);
				ApFi = isElementPresent("BTFAppFil_id");
				highLight(isElementPresent("BTFAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("BagTypeShwInActData_", "BagType", driver);
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
				highLight(isElementPresent("BTFilter_id"), driver);
				isElementPresent("BTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("BTFClearFil_id");
				highLight(isElementPresent("BTFClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				ApFi = isElementPresent("BTFAppFil_id");
				highLight(isElementPresent("BTFAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("BagTypeGridAFClearF_", "BagType", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Filter-Cancel
				highLight(isElementPresent("BTFilter_id"), driver);
				isElementPresent("BTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("BTFClearFil_id");
				highLight(isElementPresent("BTFClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				WebElement Cancl = isElementPresent("BTFCancel_id");
				highLight(isElementPresent("BTFCancel_id"), driver);
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");

				// PageSize
				pageSize("BagType");

				// Pagination
				pagination("BagType");

				// NormalView
				normalView("BagType");

				break;
			} else {
				System.out.println("BagType is not exist");
				logs.info("BagType is not exist");
			}

		}

	}

}
