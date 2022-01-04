package vendor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class VenDocument extends BaseInit {

	@Test
	public void venDocument() throws InterruptedException, IOException {
		System.out.println("--------------Testing VENDOR-DOCUMENT---------------");
		logs.info("--------------Testing VENDOR-DOCUMENT---------------");
		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
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
				getScreenshot("Vendor_", "VendorDocument", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VendorDocument", driver);
				WebElement Search = isElementPresent("Search_id");
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VendorDocument", driver);
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
					getScreenshot("Editor_", "VendorDocument", driver);

					// Document
					highLight(isElementPresent("VendDocument_xpath"), driver);
					isElementPresent("VendDocument_xpath").click();
					System.out.println("Clicked on Document menu");
					logs.info("Clicked on Document menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendDocumentScreen_", "VendorDocument", driver);

					// -------- Create-Back--------
					highLight(isElementPresent("VDocCreate_id"), driver);
					isElementPresent("VDocCreate_id").click();
					System.out.println("Clicked on create button");
					logs.info("Clicked on create button");
					wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("VDocBack_id")));
					getScreenshot("CreateScreen_", "VendorDocument", driver);

					// Back
					highLight(isElementPresent("VDocBack_id"), driver);
					isElementPresent("VDocBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// --Search--edit
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VendDocSearch_id"), driver);
					isElementPresent("VendDocSearch_id").sendKeys("Automation Doc");
					System.out.println("Entered value in searchbox");
					isElementPresent("VendDocSearch_id").sendKeys(Keys.ENTER);
					System.out.println("clicked enter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorDocument", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// Edit
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VendorDocument", driver);
						Thread.sleep(2000);

						// Submit
						highLight(isElementPresent("VDocSubmit_id"), driver);
						isElementPresent("VDocSubmit_id").click();
						waitForPageLoad();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Submit Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Submit Message=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					}

					// ------- Search--Delete
					System.out.println("-----Testing Delete---------");
					logs.info("--------Testing Delete---------");
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VendDocSearch_id"), driver);
					isElementPresent("VendDocSearch_id").sendKeys("Automation Doc");
					System.out.println("Entered value in searchbox");
					isElementPresent("VendDocSearch_id").sendKeys(Keys.ENTER);
					System.out.println("clicked enter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendDocument", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
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
						getScreenshot("DocDelete_", "VendDocument", driver);
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
						getScreenshot("DocDeleteKeepIT_", "VendDocument", driver);
						waitForPageLoad();

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on Delete button");
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
						getScreenshot("DocDeleteDeleteIT_", "VendDocument", driver);
						wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

						System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						waitForPageLoad();

					}
					// Clear Search
					highLight(isElementPresent("VendDocSearch_id"), driver);
					isElementPresent("VendDocSearch_id").clear();
					isElementPresent("VendDocSearch_id").sendKeys(Keys.ENTER);
					System.out.println("Cleared the search criteria");
					logs.info("Cleared the search criteria");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendDocument", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-SHWDeleted-Checked
					highLight(isElementPresent("VDocShwInActv_id"), driver);
					isElementPresent("VDocShwInActv_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VDocShwInActv_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("VDocShwInActv_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendDocument", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}

					// Filter-ShwDeleted-UnChecked
					highLight(isElementPresent("VDocShwInActv_id"), driver);
					isElementPresent("VDocShwInActv_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VDocShwInActv_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("VDocShwInActv_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendDocument", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

					}
					// Active the deleted record
					System.out.println("-----------------------ACtivate the deleted record------------------------");
					logs.info("------------------------ACtivate the deleted record------------------------");
					highLight(isElementPresent("VendDocSearch_id"), driver);
					isElementPresent("VendDocSearch_id").sendKeys("Automation Doc");
					System.out.println("Entered value in searchbox");
					isElementPresent("VendDocSearch_id").sendKeys(Keys.ENTER);
					System.out.println("clicked enter");
					highLight(isElementPresent("VDocShwInActv_id"), driver);
					isElementPresent("VDocShwInActv_id").click();
					System.out.println("Clicked on Show InActive checkbox");
					System.out.println("Show InActive is selected=="
							+ isElementPresent("VDocShwInActv_id").getAttribute("aria-checked"));
					logs.info("Clicked on Show InActive checkbox");
					logs.info("Show InActive is selected=="
							+ isElementPresent("VDocShwInActv_id").getAttribute("aria-checked"));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("DocSearchResultGrid_", "VendDocument", driver);
					waitForPageLoad();
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
						// Edit
						System.out.println("-----Testing Edit-----");
						logs.info("-------Testing Edit------------");
						highLight(isElementPresent("VCorEdit_xpath"), driver);
						isElementPresent("VCorEdit_xpath").click();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						waitForPageLoad();
						getScreenshot("VendDocumentEditor_", "VendDocument", driver);
						Thread.sleep(3000);
						// ValidTo
						highLight(isElementPresent("VDocValidTo_id"), driver);
						isElementPresent("VDocValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VDocValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("VendDocumentEdWithData", "VendDocument", driver);

						// Submit-VendDocument
						highLight(isElementPresent("VDocSubmit_id"), driver);
						isElementPresent("VDocSubmit_id").click();
						System.out.println("Clicked on Submit button");
						System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
						logs.info("Clicked on Submit button");
						logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

						wait.until(ExpectedConditions
								.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						Thread.sleep(3000);
					}

					// PageSize
					pageSize("VendDocument");

					// Pagination
					pagination("VendDocument");

					// NormalView
					normalView("VendDocument");

					break;
				}
			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}
		}
	}
}
