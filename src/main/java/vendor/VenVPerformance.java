package vendor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;

import samyak_BasePackage.BaseInit;

public class VenVPerformance extends BaseInit {

	@Test
	public void venPerformance() throws InterruptedException, ParseException, IOException {
		System.out.println("--------------Testing VENDOR-VendorPerformance---------------");
		logs.info("--------------Testing VENDOR-VendorPerformance---------------");
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
				getScreenshot("Vendor_", "VendorPerformance", driver);
				// String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VendorPerformance", driver);
				WebElement Search = isElementPresent("Search_id");
				highLight(isElementPresent("Search_id"), driver);
				Search.click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VendorPerformance", driver);
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
					getScreenshot("Editor_", "VendorPerformance", driver);

					// VendorPerformance
					highLight(isElementPresent("VendPerf_xpath"), driver);
					isElementPresent("VendPerf_xpath").click();
					System.out.println("Clicked on VendorPerformance menu");
					logs.info("Clicked on VendorPerformance menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendVendorPerformanceScreen_", "VendorPerformance", driver);

					// -------- Create-Submit--------
					highLight(isElementPresent("VPerfSubmit_id"), driver);
					isElementPresent("VPerfSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					getScreenshot("CreateScreen_", "VendorPerformance", driver);

					// Search
					System.out.println("--------------Testing search---------------");
					isElementPresent("VPerfSearch_xpath").sendKeys("22");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VendorPerformance", driver);
					highLight(isElementPresent("VPerfSearch_xpath"), driver);
					isElementPresent("VPerfSearch_xpath").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("SearchResult_", "VendorPerformance", driver);
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
						getScreenshot("Editor_", "VendorPerformance", driver);
						Thread.sleep(2000);

						// Cancel
						highLight(isElementPresent("VPerfCancel_id"), driver);
						isElementPresent("VPerfCancel_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

						// ---Edit-Submit-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VendorPerformance", driver);
						Thread.sleep(2000);

						// Vendor Marketing Rating
						highLight(isElementPresent("VPerVMRating_id"), driver);
						isElementPresent("VPerVMRating_id").clear();
						isElementPresent("VPerVMRating_id").sendKeys("10");
						System.out.println("Entered value in Vendor Marketing Rating");
						logs.info("Entered value in Vendor Marketing Rating");

						// OriginOTP
						highLight(isElementPresent("VPerfOOTP_id"), driver);
						isElementPresent("VPerfOOTP_id").clear();
						isElementPresent("VPerfOOTP_id").sendKeys("123");
						System.out.println("Entered Origin OTP");
						logs.info("Entered Origin OTP");

						// TransitOTP
						highLight(isElementPresent("VPerfTOTP_id"), driver);
						isElementPresent("VPerfTOTP_id").clear();
						isElementPresent("VPerfTOTP_id").sendKeys("231");
						System.out.println("Entered Transit OTP");
						logs.info("Entered Transit OTP");

						// DestinationOTP
						highLight(isElementPresent("VPerfDest_id"), driver);
						isElementPresent("VPerfDest_id").clear();
						isElementPresent("VPerfDest_id").sendKeys("321");
						System.out.println("Entered Destination OTP");
						logs.info("Entered Destination OTP");

						// VendorOTP
						highLight(isElementPresent("VPerfVOTP_id"), driver);
						isElementPresent("VPerfVOTP_id").clear();
						isElementPresent("VPerfVOTP_id").sendKeys("213");
						System.out.println("Entered Vendor OTP");
						logs.info("Entered Vendor OTP");

						getScreenshot("VendorPerformanceEdWithData1_", "VendorPerformance", driver);

						// Submit
						highLight(isElementPresent("VPerfSubmit_id"), driver);
						isElementPresent("VPerfSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VendorPerformance", driver);
					}
					// Search
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VPerfSearch_xpath"), driver);
					isElementPresent("VPerfSearch_xpath").clear();
					highLight(isElementPresent("VPerfYrList_id"), driver);
					isElementPresent("VPerfYrList_id").clear();
					isElementPresent("VPerfYrList_id").sendKeys("2021");
					System.out.println("Entered value in YearList");
					logs.info("Entered value in YearList");
					Thread.sleep(1000);
					isElementPresent("VPerfYrList_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the dropdown");
					logs.info("Selected value from the dropdown");
					getScreenshot("SearchData_", "VendorPerformance", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("SearchResult_", "VendorPerformance", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					}

					// normalView
					// normalView("VendorPerformance");

					break;
				}

			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}

		}
	}

}
