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

public class CourCourierNote extends BaseInit {

	@Test
	public void courierNotes() throws InterruptedException, IOException {
		System.out.println("--------------Testing COURIER-Courier Note---------------");
		logs.info("--------------Testing COURIER-Courier Note---------------");

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
				getScreenshot("Courier_", "CourierNotes", driver);

				// CourierID
				System.out.println("------Testing search----------");
				logs.info("------Testing search--------");
				// AgentCode
				highLight(isElementPresent("VCorAgeCode_xpath"), driver);
				isElementPresent("VCorAgeCode_xpath").sendKeys("R100");
				System.out.println("Entered value in AgentCode");
				logs.info("Entered value in AgentCode");
				// SearchBTN
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourSearch_id"), driver);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("btncouriersSearch")));
				WebElement Search = isElementPresent("CourSearch_id");
				Search.click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				waitForPageLoad();

				System.out.println("Searched Record is opened in Edit mode");
				logs.info("Searched Record is opened in Edit mode");
				getScreenshot("CourierEditor_", "CourierNotes", driver);

				// CourierNotes
				highLight(isElementPresent("CourNote_xpath"), driver);
				isElementPresent("CourNote_xpath").click();
				System.out.println("Clicked on Courier Note menu");
				logs.info("Clicked on Courier Note menu");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("CourNote_", "CourierNotes", driver);

				// Create
				System.out.println("------------------------Testing Create------------------------");
				logs.info("------------------------Testing Create------------------------");
				highLight(isElementPresent("CNCreate_id"), driver);
				isElementPresent("CNCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("CourNoteCreate_", "CourierNotes", driver);

				// Back
				highLight(isElementPresent("CNBack_id"), driver);
				isElementPresent("CNBack_id").click();
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CNSearch_xpath"), driver);
				isElementPresent("CNSearch_xpath").sendKeys("Automation Testing Note");
				isElementPresent("CNSearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered Day value in Searchbox");
				logs.info("Entered Day value in Searchbox");
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

					// Edit
					WebElement Edt = isElementPresent("VCorEdit_xpath");
					highLight(isElementPresent("VCorEdit_xpath"), driver);
					js.executeScript("arguments[0].click();", Edt);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					getScreenshot("CourNoteEdit_", "CourierNotes", driver);

					// Note
					highLight(isElementPresent("CNENote_xpath"), driver);
					isElementPresent("CNENote_xpath").clear();
					isElementPresent("CNENote_xpath").sendKeys("Automation Testing Note");
					System.out.println("Entered Notes");
					logs.info("Entered Notes");

					// Valid To Date
					highLight(isElementPresent("CNEValidTo_xpath"), driver);
					isElementPresent("CNEValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CNEValidTo_xpath").sendKeys(newDate);
					Thread.sleep(500);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("CourNoteEdtrwithData_", "CourierNotes", driver);

					// SUbmit
					highLight(isElementPresent("CNSubmit_id"), driver);
					isElementPresent("CNSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// ShwInACtive-checked
				highLight(isElementPresent("CNShwInact_id"), driver);
				isElementPresent("CNShwInact_id").click();
				System.out.println(
						"Show InActive is selected==" + isElementPresent("CNShwInact_id").getAttribute("aria-checked"));
				logs.info(
						"Show InActive is selected==" + isElementPresent("CNShwInact_id").getAttribute("aria-checked"));
				getScreenshot("CourNoteShwInActive_", "CourierNotes", driver);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("CourNoteShwInActData_", "CourierNotes", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// ShwInACtive-Unchecked
				highLight(isElementPresent("CNShwInact_id"), driver);
				isElementPresent("CNShwInact_id").click();
				System.out.println(
						"Show InActive is selected==" + isElementPresent("CNShwInact_id").getAttribute("aria-checked"));
				logs.info(
						"Show InActive is selected==" + isElementPresent("CNShwInact_id").getAttribute("aria-checked"));
				getScreenshot("CourNoteShwInActive_", "CourierNotes", driver);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("CourNoteShwInActData_", "CourierNotes", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// Search-- Delete
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CNSearch_xpath"), driver);
				isElementPresent("CNSearch_xpath").sendKeys("Automation Testing Note");
				isElementPresent("CNSearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered Day value in Searchbox");
				logs.info("Entered Day value in Searchbox");
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
					WebElement Dlt = isElementPresent("Del_xpath");
					highLight(isElementPresent("Del_xpath"), driver);
					js.executeScript("arguments[0].click();", Dlt);
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("CourNoteDelete_", "CourierNotes", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("CourNoteDltKeepIt_", "CourierNotes", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Delete
					Dlt = isElementPresent("Del_xpath");
					highLight(isElementPresent("Del_xpath"), driver);
					js.executeScript("arguments[0].click();", Dlt);
					System.out.println("Clicked on Delete button");
					logs.info("Clicked on Delete button");

					// DeleteIt
					WebElement DltIt = isElementPresent("Delbtn_xpath");
					highLight(isElementPresent("Delbtn_xpath"), driver);
					js.executeScript("arguments[0].click();", DltIt);
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					getScreenshot("CourNoteDeleteDltIT_", "CourierNotes", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Activate the deleted record
				waitForPageLoad();
				highLight(isElementPresent("CNShwInact_id"), driver);
				isElementPresent("CNShwInact_id").click();
				System.out.println(
						"Show InActive is selected==" + isElementPresent("CNShwInact_id").getAttribute("aria-checked"));
				logs.info(
						"Show InActive is selected==" + isElementPresent("CNShwInact_id").getAttribute("aria-checked"));
				getScreenshot("CourNoteShwInActive_", "CourierNotes", driver);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("CourNoteShwInActData_", "CourierNotes", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					WebElement Edt = isElementPresent("VCorEdit_xpath");
					highLight(isElementPresent("VCorEdit_xpath"), driver);
					js.executeScript("arguments[0].click();", Edt);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					getScreenshot("CourNoteEdit_", "CourierNotes", driver);
					Thread.sleep(5000);

					// Valid To Date
					highLight(isElementPresent("CNEValidTo_xpath"), driver);
					isElementPresent("CNEValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CNEValidTo_xpath").sendKeys(newDate);
					Thread.sleep(500);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("CourNoteEdtrwithData_", "CourierNotes", driver);

					// SUbmit
					highLight(isElementPresent("CNSubmit_id"), driver);
					isElementPresent("CNSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}
				// PageSize
				pageSize("CourierNotes");

				// Pagination
				pagination("CourierNotes");

				// NormalView
				normalView("CourierNotes");

				// click on columns
				columns("CourierNotes");

				break;
			} else {
				System.out.println("Courier is not exist");
				logs.info("Courier is not exist");
			}

		}

	}
}
