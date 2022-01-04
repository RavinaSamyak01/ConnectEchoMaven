package vendor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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

public class VenFacilityMaintenance extends BaseInit {

	@Test
	public void venTransportServices() throws InterruptedException, ParseException, IOException {
		System.out.println("--------------Testing VENDOR-VFacilityMaintenance---------------");
		logs.info("--------------Testing VENDOR-VFacilityMaintenance---------------");
		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

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
			if (IName.equalsIgnoreCase("Vendor")) {
				highLight(vendItem.get(count), driver);
				vendItem.get(count).click();
				System.out.println("clicked on Vendor");
				logs.info("clicked on Vendor");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				waitForPageLoad();
				getScreenshot("Vendor_", "VFacilityMaintenance", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VFacilityMaintenance", driver);
				WebElement Search = isElementPresent("Search_id");
				highLight(isElementPresent("Search_id"), driver);
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VFacilityMaintenance", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "VFacilityMaintenance", driver);

					// VFacilityMaintenance
					WebElement FMaintenance = isElementPresent("VFMaintenance_xpath");
					highLight(isElementPresent("VFMaintenance_xpath"), driver);
					act.moveToElement(FMaintenance).click().perform();
					System.out.println("Clicked on VFacilityMaintenance menu");
					logs.info("Clicked on VFacilityMaintenance menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendVFacilityMaintenanceScreen_", "VFacilityMaintenance", driver);

					// -------- Create-Submit--------
					highLight(isElementPresent("VFMSubmit_id"), driver);
					isElementPresent("VFMSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					getScreenshot("CreateScreen_", "VFacilityMaintenance", driver);

					// Search
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VFMSearch_id"), driver);
					isElementPresent("VFMSearch_id").sendKeys("A/C CONTRACTOR");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VFacilityMaintenance", driver);
					isElementPresent("VFMSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VFacilityMaintenance", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Cancel-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VFacilityMaintenance", driver);
						Thread.sleep(2000);

						// Cancel
						highLight(isElementPresent("VFMECancel_id"), driver);
						isElementPresent("VFMECancel_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// ---Edit-Save-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VFacilityMaintenance", driver);
						Thread.sleep(2000);

						// Save
						highLight(isElementPresent("VFMESave_id"), driver);
						isElementPresent("VFMESave_id").click();
						System.out.println("Clicked on Save button");
						logs.info("Clicked on Save button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VFacilityMaintenance", driver);
					}
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VFMSearch_id"), driver);
					isElementPresent("VFMSearch_id").clear();
					isElementPresent("VFMSearch_id").sendKeys("A/C CONTRACTOR");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VFacilityMaintenance", driver);
					isElementPresent("VFMSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VFacilityMaintenance", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Delete
						WebElement del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						js.executeScript("arguments[0].click();", del);
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VFacilityMaintenance", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// Keep it
						highLight(isElementPresent("DelKeepIt_xpath"), driver);
						isElementPresent("DelKeepIt_xpath").click();
						System.out.println("Clicked on Keep It button");
						logs.info("Clicked on Keep It button");
						getScreenshot("DeleteKeepIT_", "VFacilityMaintenance", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// Delete
						del = isElementPresent("Del_xpath");
						highLight(isElementPresent("Del_xpath"), driver);
						js.executeScript("arguments[0].click();", del);
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VFacilityMaintenance", driver);
						System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
						logs.info("Clicked on Delete button");
						logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
						logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

						// DeleteIt
						highLight(isElementPresent("Delbtn_xpath"), driver);
						isElementPresent("Delbtn_xpath").click();
						System.out.println("Clicked on Delete It button");
						logs.info("Clicked on Delete It button");
						getScreenshot("DeleteDeleteIT_", "VFacilityMaintenance", driver);
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					}

					// -----ShowDeleted-Checked--Activate deleted Record------------
					highLight(isElementPresent("VFMSearch_id"), driver);
					isElementPresent("VFMSearch_id").clear();
					isElementPresent("VFMSearch_id").sendKeys("A/C CONTRACTOR");
					System.out.println("Entered value in Searchbox");
					logs.info("Entered value in Searchbox");
					// ShowDeleted
					highLight(isElementPresent("VFMShwDeleted_id"), driver);
					isElementPresent("VFMShwDeleted_id").click();
					System.out.println("Clicked on ShowDeleted checkbox");
					logs.info("Clicked on ShowDeleted checkbox");
					Thread.sleep(1000);
					getScreenshot("ShowDeleted_", "VFacilityMaintenance", driver);
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VFMShwDeleted_id").getAttribute("aria-checked"));
					logs.info("Show InActive is selected=="
							+ isElementPresent("VFMShwDeleted_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveChecked_", "VFacilityMaintenance", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VFacilityMaintenance", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Submit-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						Thread.sleep(2000);

						// ValidTo
						highLight(isElementPresent("VFMEValidTo_id"), driver);
						isElementPresent("VFMEValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VFMEValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("AddressEdWithData1_", "VFacilityMaintenance", driver);

						// Save
						highLight(isElementPresent("VFMESave_id"), driver);
						isElementPresent("VFMESave_id").click();
						System.out.println("Clicked on Save button");
						logs.info("Clicked on Save button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						System.out.println("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Save Message=" + isElementPresent("NoMsg_xpath").getText());
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VFacilityMaintenance", driver);

					}

					// ----Filter-ShowDeleted-UnChecked------------
					highLight(isElementPresent("VFMSearch_id"), driver);
					isElementPresent("VFMSearch_id").clear();
					// ShowDeleted
					highLight(isElementPresent("VFMShwDeleted_id"), driver);
					isElementPresent("VFMShwDeleted_id").click();
					System.out.println("Clicked on ShowDeleted checkbox");
					logs.info("Clicked on ShowDeleted checkbox");
					Thread.sleep(1000);
					getScreenshot("ShowDeleted_", "VFacilityMaintenance", driver);
					System.out.println("Show Deleted is selected=="
							+ isElementPresent("VFMShwDeleted_id").getAttribute("aria-checked"));
					logs.info("Show Deleted is selected=="
							+ isElementPresent("VFMShwDeleted_id").getAttribute("aria-checked"));
					getScreenshot("ShwDeletedChecked_", "VFacilityMaintenance", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VFacilityMaintenance", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// PageSize
					pageSize("VFacilityMaintenance");

					// pagination
					pagination("VFacilityMaintenance");

					// normalView
					normalView("VFacilityMaintenance");

					break;
				}

			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}

		}

	}
}
