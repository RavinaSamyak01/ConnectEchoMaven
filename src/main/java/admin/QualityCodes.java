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

public class QualityCodes extends BaseInit {

	@Test
	public void qualityCodes() throws InterruptedException, IOException {

		System.out.println("--------------Testing QUALITY CODES---------------");
		logs.info("--------------Testing QUALITY CODES---------------");
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
		getScreenshot("Admindiv_", "QualityCodes", driver);

		// CategoryMaster SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// CategoryMaster
			if (headervalue.equalsIgnoreCase("Quality Codes")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on Quality Codes");
				logs.info("Clicked on Quality Codes");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("QualityCodeScreen_", "QualityCodes", driver);

				// -------- Create-Back--------
				highLight(isElementPresent("QCodesCreate_id"), driver);
				isElementPresent("QCodesCreate_id").click();
				System.out.println("Clicked on create button");
				logs.info("Clicked on create button");
				wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("QCodesBack_id")));
				getScreenshot("CreateScreen_", "QualityCodes", driver);

				// Back
				highLight(isElementPresent("QCodesBack_id"), driver);
				isElementPresent("QCodesBack_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("QCodesBack_id"), driver);
				isElementPresent("QCodesSearch_xpath").sendKeys("3P CARRIER");
				isElementPresent("QCodesSearch_xpath").sendKeys(Keys.ENTER);
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

				// --- Filter--expand/Collapse
				highLight(isElementPresent("QCodesSearch_xpath"), driver);
				isElementPresent("QCodesSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("QCodesFilter_id"), driver);
				isElementPresent("QCodesFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("QCodesFilter_", "QualityCodes", driver);
				highLight(isElementPresent("QCodesFCate_id"), driver);
				isElementPresent("QCodesFCate_id").sendKeys("AutoCategory");
				System.out.println("Entered value in Category");
				logs.info("Entered value in Category");
				WebElement ApFi = isElementPresent("QCodesAppFilter_id");
				highLight(isElementPresent("QCodesAppFilter_id"), driver);
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
				getScreenshot("QCodesFilterData_", "QualityCodes", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Expand
					highLight(isElementPresent("QCodesExpand_xpath"), driver);
					isElementPresent("QCodesExpand_xpath").click();
					System.out.println("Clicked on Expand button");
					logs.info("Clicked on Expand button");
					Thread.sleep(2000);
					getScreenshot("Expand_", "QualityCodes", driver);

					// Collapse
					WebElement COll = isElementPresent("QCodesCollapse_xpath");
					highLight(isElementPresent("QCodesCollapse_xpath"), driver);
					js.executeScript("arguments[0].click();", COll);
					System.out.println("Clicked on Collapse button");
					logs.info("Clicked on Collapse button");
					getScreenshot("Collapse_", "QualityCodes", driver);

				}
				// Filter
				highLight(isElementPresent("QCodesSearch_xpath"), driver);
				isElementPresent("QCodesSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("QCodesFilter_id"), driver);
				isElementPresent("QCodesFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("QCodesFilter_", "QualityCodes", driver);
				highLight(isElementPresent("QCodesFCate_id"), driver);
				isElementPresent("QCodesFCate_id").sendKeys("Automation QualityCodes");
				System.out.println("Entered value in Category");
				logs.info("Entered value in Category");
				ApFi = isElementPresent("QCodesAppFilter_id");
				highLight(isElementPresent("QCodesAppFilter_id"), driver);
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
				getScreenshot("QCodesFilterData_", "QualityCodes", driver);
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
					getScreenshot("Editor_", "QualityCodes", driver);

					// Issue Name
					highLight(isElementPresent("QCodesIsName_id"), driver);
					isElementPresent("QCodesIsName_id").clear();
					isElementPresent("QCodesIsName_id").click();
					isElementPresent("QCodesIsName_id").sendKeys(Keys.DOWN);
					Thread.sleep(2000);
					isElementPresent("QCodesIsName_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");

					// Category
					highLight(isElementPresent("QCodesCateg_id"), driver);
					isElementPresent("QCodesCateg_id").clear();
					isElementPresent("QCodesCateg_id").sendKeys("Automation QualityCodes");
					System.out.println("Entered value in Category field");
					logs.info("Entered value in Category field");

					// ValidTo
					highLight(isElementPresent("QCodesValidTo_xpath"), driver);
					isElementPresent("QCodesValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("QCodesValidTo_xpath").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// Description
					highLight(isElementPresent("QCodesDesc_id"), driver);
					isElementPresent("QCodesDesc_id").clear();
					isElementPresent("QCodesDesc_id").sendKeys("This is for Automation Testing");
					System.out.println("Entered value in Description field");
					logs.info("Entered value in Description field");

					// Controllable
					highLight(isElementPresent("QCodesCntrcb_xpath"), driver);
					isElementPresent("QCodesCntrcb_xpath").click();
					System.out.println("Clicked on Controllable checkbox");
					logs.info("Clicked on Controllable checkbox");
					System.out.println("Controllable checkbox is selected=="
							+ isElementPresent("QCodesCntrcb_xpath").isSelected());
					logs.info("Controllable checkbox==" + isElementPresent("QCodesCntrcb_xpath").isSelected());

					// Client Failure
					highLight(isElementPresent("QCodesCFailcb_xpath"), driver);
					isElementPresent("QCodesCFailcb_xpath").click();
					System.out.println("Clicked on Client Failure checkbox");
					logs.info("Clicked on Client Failure checkbox");
					System.out.println("Client Failure checkbox is selected=="
							+ isElementPresent("QCodesCFailcb_xpath").isSelected());
					logs.info("Client Failure checkbox==" + isElementPresent("QCodesCFailcb_xpath").isSelected());

					// QC-TQM Ticket
					highLight(isElementPresent("QCodesTqmcb_xpath"), driver);
					isElementPresent("QCodesTqmcb_xpath").click();
					System.out.println("Clicked on QC-TQM Ticket checkbox");
					logs.info("Clicked on QC-TQM Ticket checkbox");
					System.out.println("QC-TQM Ticket checkbox is selected=="
							+ isElementPresent("QCodesTqmcb_xpath").isSelected());
					logs.info("QC-TQM Ticket checkbox==" + isElementPresent("QCodesTqmcb_xpath").isSelected());

					// submit
					WebElement Sub = isElementPresent("QCodesSubmit_id");
					highLight(isElementPresent("QCodesSubmit_id"), driver);
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

				// -------- Search------- Delete-----------
				highLight(isElementPresent("QCodesSearch_xpath"), driver);
				isElementPresent("QCodesSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("QCodesFilter_id"), driver);
				isElementPresent("QCodesFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("QCodesFilter_", "QualityCodes", driver);
				highLight(isElementPresent("QCodesFCate_id"), driver);
				isElementPresent("QCodesFCate_id").sendKeys("Automation QualityCodes");
				System.out.println("Entered value in Category");
				logs.info("Entered value in Category");
				ApFi = isElementPresent("QCodesAppFilter_id");
				highLight(isElementPresent("QCodesAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("QCodesFilterData_", "QualityCodes", driver);
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
					getScreenshot("QCodesDelete_", "QualityCodes", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("QCodesDltKeepIt_", "QualityCodes", driver);

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
					getScreenshot("QCodesDeleteDltIT_", "QualityCodes", driver);
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

				highLight(isElementPresent("QCodesSearch_xpath"), driver);
				isElementPresent("QCodesSearch_xpath").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("QCodesFilter_id"), driver);
				isElementPresent("QCodesFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("QCodesFInACtive_xpath"), driver);
				isElementPresent("QCodesFInACtive_xpath").click();
				System.out.println(
						"Show InActive is selected==" + isElementPresent("QCodesFInACtive_xpath").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("QCodesFInACtive_xpath").isSelected());
				getScreenshot("QCodesShwInActive_", "QualityCodes", driver);
				ApFi = isElementPresent("QCodesAppFilter_id");
				highLight(isElementPresent("QCodesAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("QCodesEdit_", "QualityCodes", driver);
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
					highLight(isElementPresent("QCodesValidTo_xpath"), driver);
					isElementPresent("QCodesValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("QCodesValidTo_xpath").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// SUbmit
					WebElement Sub = isElementPresent("QCodesSubmit_id");
					highLight(isElementPresent("QCodesSubmit_id"), driver);
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
				highLight(isElementPresent("QCodesFilter_id"), driver);
				isElementPresent("QCodesFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				// clear filter not exist
				/*
				 * WebElement clear = isElementPresent("QCodesClearFilter_id");
				 * js.executeScript("arguments[0].click();", clear);
				 * System.out.println("Clicked on Clear Filter button");
				 * logs.info("Clicked on Clear Filter button");
				 */isElementPresent("QCodesFInACtive_xpath").click();
				System.out.println(
						"Show InActive is selected==" + isElementPresent("QCodesFInACtive_xpath").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("QCodesFInACtive_xpath").isSelected());
				getScreenshot("QCodesShwInActive_", "QualityCodes", driver);
				ApFi = isElementPresent("QCodesAppFilter_id");
				highLight(isElementPresent("QCodesAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("QCodesShwInActData_", "QualityCodes", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// Filter-Clear Filter-not exist
				/*
				 * isElementPresent("QCodesFilter_id").click();
				 * System.out.println("Clicked on Filter button");
				 * logs.info("Clicked on Filter button"); clear =
				 * isElementPresent("QCodesClearFilter_id");
				 * js.executeScript("arguments[0].click();", clear);
				 * System.out.println("Clicked on Clear Filter button");
				 * logs.info("Clicked on Clear Filter button"); ApFi =
				 * isElementPresent("QCodesAppFilter_id");
				 * js.executeScript("arguments[0].click();", ApFi);
				 * System.out.println("Clicked on Apply Filter button");
				 * logs.info("Clicked on Apply Filter button"); ImageFile =
				 * isElementPresent("ApNoDataImage_xpath"); Data =
				 * isElementPresent("GridRecord_xpath").getText();
				 * System.out.println("searched data is" + " " + Data);
				 * logs.info("searched data is" + " " + Data);
				 * getScreenshot("QCodesGridAFClearF_", "QualityCodes", driver); if
				 * (ImageFile.isDisplayed()) {
				 * System.out.println("There is not any data related enetered search parameters"
				 * ); logs.info("There is not any data related enetered search parameters");
				 * 
				 * } else {
				 * System.out.println("Data is present related enetered search parameters");
				 * logs.info("Data is present related enetered search parameters");
				 * 
				 * }
				 */
				// Filter-Cancel
				highLight(isElementPresent("QCodesFilter_id"), driver);
				isElementPresent("QCodesFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				// Clear filter not exist
				/*
				 * clear = isElementPresent("QCodesClearFilter_id");
				 * js.executeScript("arguments[0].click();", clear);
				 * System.out.println("Clicked on Clear Filter button");
				 * logs.info("Clicked on Clear Filter button");
				 */
				WebElement Cancl = isElementPresent("QCodesFCancel_id");
				highLight(isElementPresent("QCodesFCancel_id"), driver);
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");

				// PageSize
				pageSize("QualityCodes");

				// pagination
				pagination("QualityCodes");

				// normalView
				normalView("QualityCodes");

				break;
			} else {
				System.out.println("Quality Codes is not exist");
				logs.info("Quality Codes is not exist");
			}

		}

	}
}
