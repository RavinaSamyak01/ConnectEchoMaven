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

public class CourServiceAreas extends BaseInit {

	@Test
	public void courServiceAreas() throws InterruptedException, IOException {
		System.out.println("--------------Testing COURIER-SERVICE AREAS---------------");
		logs.info("--------------Testing COURIER-SERVICE AREAS---------------");

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
				getScreenshot("Courier_", "CourierServiceAreas", driver);

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
				getScreenshot("CourierEditor_", "CourierServiceAreas", driver);

				// ServiceAreas
				highLight(isElementPresent("CourSA_xpath"), driver);
				isElementPresent("CourSA_xpath").click();
				System.out.println("Clicked on Service Areas menu");
				logs.info("Clicked on Service Areas menu");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("ServAreasScreen_", "CourierServiceAreas", driver);

				// Create
				System.out.println("------------------------Testing Create------------------------");
				logs.info("------------------------Testing Create------------------------");
				highLight(isElementPresent("CourSACreate_id"), driver);
				isElementPresent("CourSACreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("ServAreasCreate_", "CourierServiceAreas", driver);

				// Back
				highLight(isElementPresent("CourSBack_id"), driver);
				isElementPresent("CourSBack_id").click();
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourSASearch_xpath"), driver);
				isElementPresent("CourSASearch_xpath").sendKeys("Ravina Prajapati");
				isElementPresent("CourSASearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered value in Searchbox");
				logs.info("Entered value in Searchbox");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				/*
				 * js.executeScript("arguments[0].scrollIntoView();",
				 * isElementPresent("GridRecord_xpath"));
				 * getScreenshot("ServAreasGridAFSearch_", "ServiceAreas", driver);
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
					getScreenshot("ServAreasEdit_", "CourierServiceAreas", driver);

					// Area Type
					highLight(isElementPresent("CourSAreaType_xpath"), driver);
					isElementPresent("CourSAreaType_xpath").click();
					isElementPresent("CourSAreaType_xpath").clear();
					isElementPresent("CourSAreaType_xpath").sendKeys(Keys.DOWN);
					isElementPresent("CourSAreaType_xpath").sendKeys(Keys.ENTER);
					System.out.println("Selected AReaType");
					logs.info("Selected AReaType");

					// AirportID
					highLight(isElementPresent("CourSAAipID_xpath"), driver);
					isElementPresent("CourSAAipID_xpath").sendKeys("ANY1");
					System.out.println("Entered AirportID");
					logs.info("Entered AirportID");

					// Account
					highLight(isElementPresent("CourSAAc_xpath"), driver);
					isElementPresent("CourSAAc_xpath").sendKeys("999073");
					System.out.println("Entered Account");
					logs.info("Entered Account");

					// To Date
					highLight(isElementPresent("CourSAValidTo_xpath"), driver);
					isElementPresent("CourSAValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CourSAValidTo_xpath").sendKeys(newDate);
					Thread.sleep(500);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("ServAreasEdtrwithData_", "CourierServiceAreas", driver);

					// SUbmit
					highLight(isElementPresent("CourSACreate_id"), driver);
					isElementPresent("CourSACreate_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Filter-Edit-Back
				highLight(isElementPresent("CourSASearch_xpath"), driver);
				isElementPresent("CourSASearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Filter-Day
				highLight(isElementPresent("CourSFilter_id"), driver);
				isElementPresent("CourSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				Thread.sleep(1000);
				getScreenshot("ServAreasFilter_", "CourierServiceAreas", driver);
				highLight(isElementPresent("CourSFCustName_xpath"), driver);
				isElementPresent("CourSFCustName_xpath").sendKeys("Ravina Prajapati");
				WebElement ApFi = isElementPresent("CourSAppFil_id");
				highLight(isElementPresent("CourSAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				getScreenshot("ServAreasFilterData_", "CourierServiceAreas", driver);
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
					highLight(isElementPresent("CourSBack_id"), driver);
					isElementPresent("CourSBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Filter-ShwInACtive-checked
				highLight(isElementPresent("CourSFilter_id"), driver);
				isElementPresent("CourSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				Thread.sleep(1000);
				WebElement clear = isElementPresent("CourSClearFil_id");
				highLight(isElementPresent("CourSClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("CourSShwInActv_id"), driver);
				isElementPresent("CourSShwInActv_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("CourSShwInActv_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("CourSShwInActv_id").isSelected());
				getScreenshot("ServAreasShwInActive_", "CourierServiceAreas", driver);
				ApFi = isElementPresent("CourSAppFil_id");
				highLight(isElementPresent("CourSAppFil_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("ServAreasShwInActData_", "CourierServiceAreas", driver);
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
				highLight(isElementPresent("CourSFilter_id"), driver);
				isElementPresent("CourSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				Thread.sleep(1000);
				clear = isElementPresent("CourSClearFil_id");
				highLight(isElementPresent("CourSClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				ApFi = isElementPresent("CourSAppFil_id");
				highLight(isElementPresent("CourSAppFil_id"), driver);
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
				getScreenshot("ServAreasGridAFClearF_", "CourierServiceAreas", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Filter-Cancel
				highLight(isElementPresent("CourSFilter_id"), driver);
				isElementPresent("CourSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				Thread.sleep(1000);
				clear = isElementPresent("CourSClearFil_id");
				highLight(isElementPresent("CourSClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				WebElement Cancl = isElementPresent("CourSCancFil_id");
				highLight(isElementPresent("CourSCancFil_id"), driver);
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search Delete
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourSASearch_xpath"), driver);
				isElementPresent("CourSASearch_xpath").sendKeys("Ravina Prajapati");
				isElementPresent("CourSASearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered value in Searchbox");
				logs.info("Entered value in Searchbox");
				getScreenshot("ServAreasGridAFSearch_", "CourierServiceAreas", driver);
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
					getScreenshot("ServAreasDelete_", "CourierServiceAreas", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("ServAreasDltKeepIt_", "CourierServiceAreas", driver);
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
					getScreenshot("ServAreasDeleteDltIT_", "CourierServiceAreas", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Back
					highLight(isElementPresent("CourSBack_id"), driver);
					isElementPresent("CourSBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Activate the deleted record
				waitForPageLoad();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CourSASearch_xpath"), driver);
				isElementPresent("CourSASearch_xpath").sendKeys("Ravina Prajapati");
				isElementPresent("CourSASearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered value in Searchbox");
				logs.info("Entered value in Searchbox");
				highLight(isElementPresent("CourSFilter_id"), driver);
				isElementPresent("CourSFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				Thread.sleep(1000);
				highLight(isElementPresent("CourSShwInActv_id"), driver);
				isElementPresent("CourSShwInActv_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("CourSShwInActv_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("CourSShwInActv_id").isSelected());
				getScreenshot("ServAreasShwInActive_", "CourierServiceAreas", driver);
				ApFi = isElementPresent("CourSShwInActv_id");
				highLight(isElementPresent("CourSShwInActv_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("ServAreasEdit_", "ServiceAreas", driver);
				Thread.sleep(2000);

				// To Date
				highLight(isElementPresent("CourSAValidTo_xpath"), driver);
				isElementPresent("CourSAValidTo_xpath").clear();
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, 1000);
				String newDate = dateFormat.format(cal.getTime());
				isElementPresent("CourSAValidTo_xpath").sendKeys(newDate);
				Thread.sleep(500);
				System.out.println("Selected Date,1000 days priorior from current Date");
				logs.info("Selected Date,1000 days priorior from current Date");

				getScreenshot("ServAreasEdtrwithData_", "CourierServiceAreas", driver);

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
				pageSize("CourierServiceAreas");

				// Pagination
				pagination("CourierServiceAreas");

				// NormalView
				normalView("CourierServiceAreas");

				// click on columns
				columns("CourierServiceAreas");

				break;
			} else {
				System.out.println("Courier is not exist");
				logs.info("Courier is not exist");
			}

		}

	}

}
