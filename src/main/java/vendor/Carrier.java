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

public class Carrier extends BaseInit {
	@Test
	public void vendCarrier() throws InterruptedException, IOException {
		System.out.println("--------------Testing CARRIER---------------");
		logs.info("--------------Testing CARRIER---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Main Vendor menu
		highLight(isElementPresent("MainVendor_xpath"), driver);
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"sidenav\"]/ul/li")));

		WebElement vendordiv = isElementPresent("VCorDiv_xpath");
		List<WebElement> vendItem = vendordiv.findElements(By.className("dx-button-content"));
		for (int count1 = 0; count1 < vendItem.size(); count1++) {
			String IName = vendItem.get(count1).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Carrier")) {
				highLight(vendItem.get(count1), driver);
				vendItem.get(count1).click();
				System.out.println("clicked on Carrier");
				logs.info("clicked on Carrier");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("CarrierScreen_", "Carrier", driver);

				// Create--Back-----
				// Create
				highLight(isElementPresent("CarrCreate_id"), driver);
				isElementPresent("CarrCreate_id").click();
				System.out.println("Clicked on create button");
				logs.info("Clicked on create button");
				waitForPageLoad();
				getScreenshot("CarrCreate_", "Carrier", driver);

				// BackButton
				highLight(isElementPresent("CarrBack_id"), driver);
				isElementPresent("CarrBack_id").click();
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				getScreenshot("CarrBack_", "Carrier", driver);
				waitForPageLoad();

				// Search---Edit------
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				System.out.println("------Testing search------");
				logs.info("------Testing search----------");
				// Name
				highLight(isElementPresent("CarrAirName_id"), driver);
				isElementPresent("CarrAirName_id").sendKeys("Air US");
				System.out.println("Entered value in Name");
				logs.info("Entered value in Name");
				// OAGID
				highLight(isElementPresent("CarrOAGID_id"), driver);
				isElementPresent("CarrOAGID_id").sendKeys("OAG10");
				System.out.println("Entered value in OAGID");
				logs.info("Entered value in OAGID");
				getScreenshot("SearchData_", "Carrier", driver);
				// SearchBTN
				WebElement Search = isElementPresent("CarrSearchBfAddFil_id");
				highLight(isElementPresent("CarrSearchBfAddFil_id"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Carrier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("CarrEditor_", "Carrier", driver);

					// Carrier/Airline Name
					highLight(isElementPresent("CarrEdAirline_id"), driver);
					isElementPresent("CarrEdAirline_id").clear();
					isElementPresent("CarrEdAirline_id").sendKeys("Air US");
					System.out.println("Entered value in Carrier/Airline Name Field");
					logs.info("Entered value in Carrier/Airline Name Field");

					// OAG ID
					highLight(isElementPresent("CarrEOAGID_id"), driver);
					isElementPresent("CarrEOAGID_id").clear();
					isElementPresent("CarrEOAGID_id").sendKeys("OAG10");
					System.out.println("Entered value in OAG ID");
					logs.info("Entered value in OAG ID");

					// FAA ID
					highLight(isElementPresent("CarrEFAA_id"), driver);
					isElementPresent("CarrEFAA_id").clear();
					isElementPresent("CarrEFAA_id").sendKeys("FAAR");
					System.out.println("Entered value in FAAID Field");
					logs.info("Entered value in FAAID Field");

					// ValidTo
					highLight(isElementPresent("CarrEValidTo_id"), driver);
					isElementPresent("CarrEValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CarrEValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// Country
					highLight(isElementPresent("CarrECntry_id"), driver);
					isElementPresent("CarrECntry_id").clear();
					System.out.println("value is cleared");
					logs.info("value is cleared");
					isElementPresent("CarrECntry_id").click();
					isElementPresent("CarrECntry_id").sendKeys("United States");
					Thread.sleep(2000);
					isElementPresent("CarrECntry_id").sendKeys(Keys.ARROW_DOWN);
					isElementPresent("CarrECntry_id").sendKeys(Keys.ENTER);
					System.out.println("clicked on Country dropdown");
					logs.info("clicked on Country dropdown");
					isElementPresent("CarrECntry_id").sendKeys(Keys.TAB);

					// Zip/PostalCode
					highLight(isElementPresent("CarrEZip_id"), driver);
					isElementPresent("CarrEZip_id").clear();
					isElementPresent("CarrEZip_id").sendKeys("60406");
					System.out.println("Entered value in Zip/PostalCode Field");
					logs.info("Entered value in Zip/PostalCode Field");
					isElementPresent("CarrEZip_id").sendKeys(Keys.TAB);
					Thread.sleep(2000);

					// City
					highLight(isElementPresent("CarrECity_id"), driver);
					isElementPresent("CarrECity_id").clear();
					isElementPresent("CarrECity_id").sendKeys("BLUE ISLAND");
					Thread.sleep(2000);
					isElementPresent("CarrECity_id").sendKeys(Keys.ARROW_DOWN);
					isElementPresent("CarrECity_id").sendKeys(Keys.ARROW_DOWN);
					isElementPresent("CarrECity_id").sendKeys(Keys.ENTER);
					System.out.println("Entered value in City");
					logs.info("Entered value in City");

					// State/Province-Enable or disabled
					highLight(isElementPresent("VCorCrState_xpath"), driver);
					boolean StateProv = isElementPresent("VCorCrState_xpath").isEnabled();
					if (StateProv) {
						System.out.println("Create button is Enabled");
						logs.info("Create button is Enabled");

					} else {
						System.out.println("Create button is Disabled");
						logs.info("Create button is Disabled");
					}
					// AddressLine1
					highLight(isElementPresent("CarrEAddline_id"), driver);
					isElementPresent("CarrEAddline_id").clear();
					isElementPresent("CarrEAddline_id").sendKeys("14101 Seeley Ave.");
					System.out.println("Entered value in AddressLine1");
					logs.info("Entered value in AddressLine1");
					getScreenshot("CarrEditrWithData_", "Carrier", driver);

					// Submit
					highLight(isElementPresent("CarrSubmit_id"), driver);
					isElementPresent("CarrSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					getScreenshot("CarrSubmit_", "Carrier", driver);

					// BackButton
					highLight(isElementPresent("CarrBack_id"), driver);
					isElementPresent("CarrBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					getScreenshot("CarrBack_", "Carrier", driver);
					waitForPageLoad();

					// Edit
					highLight(isElementPresent("VCorEdit_xpath"), driver);
					isElementPresent("VCorEdit_xpath").click();
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					// Back
					highLight(isElementPresent("CarrBack_id"), driver);
					isElementPresent("CarrBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Search--Delete----
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CarrAddFil_id"), driver);
				isElementPresent("CarrAddFil_id").click();
				System.out.println("clicked on Additional Filter popup");
				logs.info("clicked on Additional Filter popup");
				getScreenshot("AddFilter_", "Carrier", driver);
				Thread.sleep(2000);
				// VendorDropdown
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname=\"vendorGUID\"]")));
				highLight(isElementPresent("CarrVendDrop_xpath"), driver);
				isElementPresent("CarrVendDrop_xpath").click();
				System.out.println("Clicked on Vendor dropdown");
				logs.info("Clicked on Vendor dropdown");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("/html/body/div[3]//div[@class=\"dx-popup-content\"]")));
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("/html/body/div[3]//div[@class=\"dx-popup-content\"]")));
				Thread.sleep(5000);
				highLight(isElementPresent("CarrVendDrop_xpath"), driver);
				isElementPresent("CarrVendDrop_xpath").click();
				Thread.sleep(2000);
				highLight(isElementPresent("CarrVendDrop_xpath"), driver);
				isElementPresent("CarrVendDrop_xpath").click();
				System.out.println("Clicked on Vendor dropdown");
				logs.info("Clicked on Vendor dropdown");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("/html/body/div[3]//div[@class=\"dx-popup-content\"]")));
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("/html/body/div[3]//div[@class=\"dx-popup-content\"]")));
				Thread.sleep(15000);

				highLight(isElementPresent("CarrVendDrop_id"), driver);
				isElementPresent("CarrVendDrop_id").sendKeys("AutoVen01");
				Thread.sleep(1000);
				isElementPresent("CarrVendDrop_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value of vendor dropdown");
				logs.info("Selected value of vendor dropdown");
				// SearchBTN
				Search = isElementPresent("CarrSearchAfAddFil_id");
				highLight(isElementPresent("CarrSearchAfAddFil_id"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Carrier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					Thread.sleep(1000);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//dx-data-grid[@id=\"gridContainer\"]")));
					// Delete
					highLight(isElementPresent("Del_xpath"), driver);
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("CarrDelete_", "Carrier", driver);
					// Keep it
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					isElementPresent("DelKeepIt_xpath").click();
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("CarrKeepIt_", "Carrier", driver);
					wait.until(ExpectedConditions
							.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

					// Delete
					highLight(isElementPresent("Del_xpath"), driver);
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("CarrDeleteIT_", "Carrier", driver);
					// DeleteIt
					highLight(isElementPresent("Delbtn_xpath"), driver);
					isElementPresent("Delbtn_xpath").click();
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					// Back
					Thread.sleep(2000);
					highLight(isElementPresent("CarrBack_id"), driver);
					isElementPresent("CarrBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					waitForPageLoad();

				}

				// Additional Filter-ShowInActive checkbox-Checked
				highLight(isElementPresent("CarrAddFil_id"), driver);
				isElementPresent("CarrAddFil_id").click();
				System.out.println("clicked on Additional Filter popup");
				logs.info("clicked on Additional Filter popup");
				getScreenshot("AddFilter_", "Carrier", driver);
				// Show InActive Checkbox
				System.out.println("Checkbox is checked=" + isElementPresent("CarrShwInAc_xpath").isSelected());
				logs.info("Checkbox is checked=" + isElementPresent("CarrShwInAc_xpath").isSelected());
				highLight(isElementPresent("CarrShwInACtive_id"), driver);
				isElementPresent("CarrShwInACtive_id").click();
				System.out.println("Checked the checkbox");
				System.out.println("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				logs.info("Checked the checkbox");
				logs.info("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				getScreenshot("ShowInActChecked_", "Carrier", driver);
				// SearchBTN
				highLight(isElementPresent("CarrSearchAfAddFil_id"), driver);
				isElementPresent("CarrSearchAfAddFil_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ShwInActSearchResult_", "Carrier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//dx-data-grid[@id=\"gridContainer\"]")));
				}

				// Additional Filter-ShowInActive checkbox-UnChecked
				// Show InActive Checkbox
				System.out.println("Checkbox is checked=" + isElementPresent("CarrSearchAfAddFil_id").isSelected());
				logs.info("Checkbox is checked=" + isElementPresent("CarrSearchAfAddFil_id").isSelected());
				highLight(isElementPresent("CarrShwInACtive_id"), driver);
				isElementPresent("CarrShwInACtive_id").click();
				System.out.println("Checked the checkbox");
				System.out.println("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				logs.info("Checked the checkbox");
				logs.info("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				getScreenshot("ShowInActChecked_", "Carrier", driver);
				// SearchBTN
				highLight(isElementPresent("CarrSearchAfAddFil_id"), driver);
				isElementPresent("CarrSearchAfAddFil_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ShwInActSearchResult_", "Carrier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//dx-data-grid[@id=\"gridContainer\"]")));
				}

				// LessFilter
				highLight(isElementPresent("CarrLessFil_id"), driver);
				isElementPresent("CarrLessFil_id").click();
				System.out.println("clicked on Less Filter popup");
				logs.info("clicked on Less Filter popup");
				getScreenshot("LessFilter_", "Carrier", driver);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//*[@id=\"gridContainer\"]/div/div[6]/div/table/tbody")));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-info\"]")));

				// Activate the deleted record
				// Name
				highLight(isElementPresent("CarrAirName_id"), driver);
				isElementPresent("CarrAirName_id").sendKeys("Air US");
				System.out.println("Entered value in Name");
				logs.info("Entered value in Name");
				// OAGID
				highLight(isElementPresent("CarrOAGID_id"), driver);
				isElementPresent("CarrOAGID_id").sendKeys("OAG10");
				System.out.println("Entered value in OAGID");
				logs.info("Entered value in OAGID");
				getScreenshot("SearchData_", "Carrier", driver);
				// Additional Filter-ShowInActive checkbox
				highLight(isElementPresent("CarrAddFil_id"), driver);
				isElementPresent("CarrAddFil_id").click();
				System.out.println("clicked on Additional Filter popup");
				logs.info("clicked on Additional Filter popup");
				getScreenshot("AddFilter_", "Carrier", driver);
				// Show InActive Checkbox
				System.out.println("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				logs.info("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				highLight(isElementPresent("CarrShwInACtive_id"), driver);
				isElementPresent("CarrShwInACtive_id").click();
				System.out.println("Checked the checkbox");
				System.out.println("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				logs.info("Checked the checkbox");
				logs.info("Checkbox is checked=" + isElementPresent("CarrShwInACtive_id").isSelected());
				// SearchBTN
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Search = isElementPresent("CarrSearchAfAddFil_id");
				highLight(isElementPresent("CarrSearchAfAddFil_id"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResult_", "Carrier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					waitForPageLoad();
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					WebElement Tab = driver.findElement(By.xpath("//*[@role=\"tab\"]"));
					wait.until(ExpectedConditions.attributeToBe(Tab, "aria-selected", "true"));
					getScreenshot("CarrEditor_", "Carrier", driver);
					Thread.sleep(5000);
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					highLight(isElementPresent("CarrEValidTo_id"), driver);
					isElementPresent("CarrEValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// Submit
					highLight(isElementPresent("CarrSubmit_id"), driver);
					isElementPresent("CarrSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");

					// Back
					highLight(isElementPresent("CarrBack_id"), driver);
					isElementPresent("CarrBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();

				}

				// Pagination
				pagination("Carrier");

				// PageSize
				pageSize("Carrier");

				// NormalView
				normalView("Carrier");

				// columns
				columns("Carrier");

				break;
			} else {
				System.out.println("Carrier is not exist");
				logs.info("Carrier is not exist");
			}
		}

	}
}
