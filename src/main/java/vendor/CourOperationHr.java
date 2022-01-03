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

public class CourOperationHr extends BaseInit {

	@Test
	public void courierOperHour() throws InterruptedException, IOException {
		System.out.println("--------------Testing COURIER-OPERATION HOUR---------------");
		logs.info("--------------Testing COURIER-OPERATION HOUR---------------");

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
		for (int count = 0; count < vendItem.size(); count++) {
			String IName = vendItem.get(count).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Courier")) {
				highLight(vendItem.get(count), driver);
				vendItem.get(count).click();
				System.out.println("clicked on Courier");
				logs.info("clicked on Courier");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				waitForPageLoad();
				getScreenshot("Courier_", "CourierOperationHour", driver);

				// CourierID
				System.out.println("--------------Testing search---------------");
				logs.info("--------------Testing search---------------");
				// AgentCode
				highLight(isElementPresent("VCorAgeCode_xpath"), driver);
				isElementPresent("VCorAgeCode_xpath").sendKeys("R100");
				System.out.println("Entered value in AgentCode");
				logs.info("Entered value in AgentCode");
				// SearchBTN
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("btncouriersSearch")));
				WebElement Search = isElementPresent("CourSearch_id");
				highLight(isElementPresent("CourSearch_id"), driver);
				Search.click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				waitForPageLoad();

				System.out.println("Searched Record is opened in Edit mode");
				logs.info("Searched Record is opened in Edit mode");
				getScreenshot("CourierEditor_", "CourierOperationHour", driver);

				// OperationHour
				highLight(isElementPresent("CourOpH_xpath"), driver);
				isElementPresent("CourOpH_xpath").click();
				System.out.println("Clicked on Operation Hour menu");
				logs.info("Clicked on Operation Hour menu");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("OpHrScreen_", "CourierOperationHour", driver);

				// Create
				System.out.println("------------------------Testing Create------------------------");
				logs.info("------------------------Testing Create------------------------");
				highLight(isElementPresent("CourOpHCreate_id"), driver);
				isElementPresent("CourOpHCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("OpHrCreate_", "CourierOperationHour", driver);

				// Back
				highLight(isElementPresent("OprationHrBack_id"), driver);
				isElementPresent("OprationHrBack_id").click();
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourOpHSearch_xpath"), driver);
				isElementPresent("CourOpHSearch_xpath").sendKeys("Monday");
				isElementPresent("CourOpHSearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered Day value in Searchbox");
				logs.info("Entered Day value in Searchbox");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				/*
				 * js.executeScript("arguments[0].scrollIntoView();",
				 * isElementPresent("GridRecord_xpath")); getScreenshot("OpHrGridAFSearch_",
				 * "OperationHour", driver);
				 */
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
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
					getScreenshot("OpHrEdit_", "CourierOperationHour", driver);

					// From Hr
					highLight(isElementPresent("CourOpHFrom_xpath"), driver);
					isElementPresent("CourOpHFrom_xpath").sendKeys("1100");
					System.out.println("Entered From Hour");
					logs.info("Entered From Hour");

					// To Hr
					highLight(isElementPresent("CourOpHTo_xpath"), driver);
					isElementPresent("CourOpHTo_xpath").sendKeys("0700");
					System.out.println("Entered From Hour");
					logs.info("Entered From Hour");

					// To Date
					highLight(isElementPresent("CourOpHValidto_xpath"), driver);
					isElementPresent("CourOpHValidto_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CourOpHValidto_xpath").sendKeys(newDate);
					Thread.sleep(500);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("OpHrEdtrwithData_", "CourierOperationHour", driver);

					// SUbmit
					highLight(isElementPresent("OpHSubmit_id"), driver);
					isElementPresent("OpHSubmit_id").click();
					isElementPresent("OpHSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Filter-Edit-Back
				highLight(isElementPresent("CourOpHSearch_xpath"), driver);
				isElementPresent("CourOpHSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Filter-Day
				highLight(isElementPresent("OpHFilter_id"), driver);
				isElementPresent("OpHFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("OpHrFilter_", "CourierOperationHour", driver);
				highLight(isElementPresent("CourOpHFDay_xpath"), driver);
				isElementPresent("CourOpHFDay_xpath").click();
				isElementPresent("CourOpHFDay_xpath").sendKeys("Monday");
				Thread.sleep(1000);
				isElementPresent("CourOpHFDay_xpath").sendKeys(Keys.ENTER);
				System.out.println("Selected Monday from day dropdown");
				logs.info("Selected Monday from day dropdown");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				getScreenshot("OpHrFilterData_", "CourierOperationHour", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					waitForPageLoad();
					System.out.println("Record is opened in Edit mode");
					logs.info("Record is opened in Edit mode");

					// Back
					highLight(isElementPresent("OprationHrBack_id"), driver);
					isElementPresent("OprationHrBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Filter-ShwInACtive-checked
				highLight(isElementPresent("OpHFilter_id"), driver);
				isElementPresent("OpHFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				WebElement clear = isElementPresent("FilClearFil_id");
				highLight(isElementPresent("FilClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				highLight(isElementPresent("FilSHwInACtive_id"), driver);
				isElementPresent("FilSHwInACtive_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("FilSHwInACtive_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("FilSHwInACtive_id").isSelected());
				getScreenshot("OpHrShwInActive_", "CourierOperationHour", driver);
				WebElement ApFi = isElementPresent("FilApplyFil_id");
				highLight(isElementPresent("FilApplyFil_id"), driver);
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
				getScreenshot("OpHrShwInActData_", "CourierOperationHour", driver);

				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// Filter-Clear Filter
				highLight(isElementPresent("OpHFilter_id"), driver);
				isElementPresent("OpHFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("FilClearFil_id");
				highLight(isElementPresent("FilClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				ApFi = isElementPresent("FilApplyFil_id");
				highLight(isElementPresent("FilApplyFil_id"), driver);
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
				getScreenshot("OpHrGridAFClearF_", "CourierOperationHour", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Filter-Cancel
				highLight(isElementPresent("OpHFilter_id"), driver);
				isElementPresent("OpHFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("FilClearFil_id");
				highLight(isElementPresent("FilClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				WebElement Cancl = isElementPresent("FilCancel_id");
				highLight(isElementPresent("FilCancel_id"), driver);
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search Delete
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourOpHSearch_xpath"), driver);
				isElementPresent("CourOpHSearch_xpath").sendKeys("Monday");
				isElementPresent("CourOpHSearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered Day value in Searchbox");
				logs.info("Entered Day value in Searchbox");
				getScreenshot("OpHrGridAFSearch_", "CourierOperationHour", driver);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
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

					// Delete
					highLight(isElementPresent("Del_xpath"), driver);
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");

					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

					logs.info("Clicked on Delete button");

					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());

					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("OpHrDelete_", "CourierOperationHour", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("OpHrDltKeepIt_", "CourierOperationHour", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Delete
					highLight(isElementPresent("Del_xpath"), driver);
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");
					logs.info("Clicked on Delete button");

					// DeleteIt
					WebElement DltIt = isElementPresent("Delbtn_xpath");
					highLight(isElementPresent("Delbtn_xpath"), driver);
					js.executeScript("arguments[0].click();", DltIt);
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					getScreenshot("OpHrDeleteDltIT_", "CourierOperationHour", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Activate the deleted record
				waitForPageLoad();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourOpHSearch_xpath"), driver);
				isElementPresent("CourOpHSearch_xpath").clear();
				isElementPresent("CourOpHSearch_xpath").sendKeys("Monday");
				isElementPresent("CourOpHSearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered Day value in Searchbox");
				logs.info("Entered Day value in Searchbox");
				highLight(isElementPresent("OpHFilter_id"), driver);
				isElementPresent("OpHFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				Thread.sleep(1000);
				highLight(isElementPresent("FilSHwInACtive_id"), driver);
				isElementPresent("FilSHwInACtive_id").click();
				wait.until(ExpectedConditions.attributeToBe(isElementPresent("FilSHwInACtive_id"), "aria-checked",
						"true"));
				System.out.println("Show InActive is selected==" + isElementPresent("FilSHwInACtive_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("FilSHwInACtive_id").isSelected());
				getScreenshot("OpHrShwInActive_", "CourierOperationHour", driver);
				ApFi = isElementPresent("FilApplyFil_id");
				highLight(isElementPresent("FilApplyFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				waitForPageLoad();
				getScreenshot("OpHrEdit_", "CourierOperationHour", driver);
				Thread.sleep(2000);

				// To Date
				highLight(isElementPresent("CourOpHValidto_xpath"), driver);
				isElementPresent("CourOpHValidto_xpath").clear();
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, 1000);
				String newDate = dateFormat.format(cal.getTime());
				isElementPresent("CourOpHValidto_xpath").sendKeys(newDate);
				Thread.sleep(500);
				System.out.println("Selected Date,1000 days priorior from current Date");
				logs.info("Selected Date,1000 days priorior from current Date");

				getScreenshot("OpHrEdtrwithData_", "CourierOperationHour", driver);

				// SUbmit
				highLight(isElementPresent("OpHSubmit_id"), driver);
				isElementPresent("OpHSubmit_id").click();
				isElementPresent("OpHSubmit_id").click();
				System.out.println("Clicked on Submit button");
				logs.info("Clicked on Submit button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// PageSize
				pageSize("CourierOperationHour");

				// Pagination
				pagination("CourierOperationHour");

				// NormalView
				normalView("CourierOperationHour");

				// click on columns
				columns("CourierOperationHour");

				break;
			} else {
				System.out.println("Courier is not exist");
				logs.info("Courier is not exist");
			}

		}

	}

}
