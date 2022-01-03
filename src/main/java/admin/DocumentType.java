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

public class DocumentType extends BaseInit {

	@Test
	public void documentType() throws InterruptedException, IOException {
		System.out.println("--------------Testing DocumentType---------------");
		logs.info("--------------Testing DocumentType---------------");

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
		getScreenshot("Admindiv_", "DocumentType", driver);

		// Admin SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// Document Type
			if (headervalue.equalsIgnoreCase("Document Type")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on DocumentType");
				logs.info("Clicked on DocumentType");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("DocumentTypeScreen_", "DocumentType", driver);

				// Create
				System.out.println("--Testing Create------");
				logs.info("----------Testing Create-------");
				highLight(isElementPresent("DTCreate_id"), driver);
				isElementPresent("DTCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("DocumentTypeCreate_", "DocumentType", driver);

				// Cancel
				highLight(isElementPresent("DTCancel_id"), driver);
				isElementPresent("DTCancel_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("DTSearch_id"), driver);
				isElementPresent("DTSearch_id").sendKeys("Automation Document");
				isElementPresent("DTSearch_id").sendKeys(Keys.ENTER);
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
				highLight(isElementPresent("DTSearch_id"), driver);
				isElementPresent("DTSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("DTFilter_id"), driver);
				isElementPresent("DTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("DocumentTypeFilter_", "DocumentType", driver);
				isElementPresent("DTFName_id").sendKeys("Automation Document");
				System.out.println("Entered value in Name");
				logs.info("Entered value in Name");
				WebElement ApFi = isElementPresent("DTAppFil_id");
				highLight(isElementPresent("DTAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("FilterData_", "DocumentType", driver);
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
					getScreenshot("Editor_", "DocumentType", driver);

					// Name
					highLight(isElementPresent("DTName_id"), driver);
					isElementPresent("DTName_id").clear();
					isElementPresent("DTName_id").sendKeys("Automation Document");
					System.out.println("entered Name");
					logs.info("entered Name");

					// Description
					highLight(isElementPresent("DTDesc_id"), driver);
					isElementPresent("DTDesc_id").clear();
					isElementPresent("DTDesc_id").sendKeys("This is for Automation Testing");
					System.out.println("entered Description");
					logs.info("entered Description");

					// ValidTo
					highLight(isElementPresent("DTValidTo_id"), driver);
					isElementPresent("DTValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("DTValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("Editorwithdata_", "DocumentType", driver);

					// submit
					WebElement Sub = isElementPresent("DTSubmit_id");
					highLight(isElementPresent("DTSubmit_id"), driver);
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
				highLight(isElementPresent("DTSearch_id"), driver);
				isElementPresent("DTSearch_id").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("DTFilter_id"), driver);
				isElementPresent("DTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("DocumentTypeFilter_", "DocumentType", driver);
				isElementPresent("DTFName_id").sendKeys("Automation Document");
				System.out.println("Entered value in name");
				logs.info("Entered value in name");
				ApFi = isElementPresent("DTAppFil_id");
				highLight(isElementPresent("DTAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("DocumentTypeFilterData_", "DocumentType", driver);
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
					getScreenshot("DocumentTypeDelete_", "DocumentType", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("DocumentTypeDltKeepIt_", "DocumentType", driver);

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
					highLight(isElementPresent("DltIt"), driver);
					js.executeScript("arguments[0].click();", DltIt);
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					getScreenshot("DocumentTypeDeleteDltIT_", "DocumentType", driver);
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

				highLight(isElementPresent("DTSearch_id"), driver);
				isElementPresent("DTSearch_id").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("DTFilter_id"), driver);
				isElementPresent("DTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("DTFShwDeleted_id"), driver);
				isElementPresent("DTFShwDeleted_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("DTFShwDeleted_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("DTFShwDeleted_id").isSelected());
				getScreenshot("DocumentTypeShwInActive_", "DocumentType", driver);
				ApFi = isElementPresent("DTAppFil_id");
				highLight(isElementPresent("DTAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("DocumentTypeEdit_", "DocumentType", driver);
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
					highLight(isElementPresent("DTValidTo_id"), driver);
					isElementPresent("DTValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("DTValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("DocumentTypeEdtrwithData_", "DocumentType", driver);

					// SUbmit
					WebElement Sub = isElementPresent("DTSubmit_id");
					highLight(isElementPresent("DTSubmit_id"), driver);
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
				highLight(isElementPresent("DTFilter_id"), driver);
				isElementPresent("DTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				WebElement clear = isElementPresent("DTClearFil_id");
				highLight(isElementPresent("DTClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("DTFShwDeleted_id"), driver);
				isElementPresent("DTFShwDeleted_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("DTFShwDeleted_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("DTFShwDeleted_id").isSelected());
				getScreenshot("DocumentTypeShwInActive_", "DocumentType", driver);
				ApFi = isElementPresent("DTAppFil_id");
				highLight(isElementPresent("DTAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("DocumentTypeShwInActData_", "DocumentType", driver);
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
				highLight(isElementPresent("DTFilter_id"), driver);
				isElementPresent("DTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("DTClearFil_id");
				highLight(isElementPresent("DTClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				ApFi = isElementPresent("DTAppFil_id");
				highLight(isElementPresent("DTAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("DocumentTypeGridAFClearF_", "DocumentType", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Filter-Cancel
				highLight(isElementPresent("DTFilter_id"), driver);
				isElementPresent("DTFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("DTClearFil_id");
				highLight(isElementPresent("DTClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				WebElement Cancl = isElementPresent("DTFCancel_id");
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");

				// PageSize
				pageSize("DocumentType");

				// Pagination
				pagination("DocumentType");

				// NormalView
				normalView("DocumentType");

				// Columns
				columns("DocumentType");

				break;
			} else {
				System.out.println("DocumentType is not exist");
				logs.info("DocumentType is not exist");
			}

		}

	}

}
