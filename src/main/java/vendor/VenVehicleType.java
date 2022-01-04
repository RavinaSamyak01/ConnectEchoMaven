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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class VenVehicleType extends BaseInit {

	@Test
	public void venVehicleType() throws InterruptedException, IOException {
		System.out.println("--------------Testing VENDOR-VEHICLETYPE---------------");
		logs.info("--------------Testing VENDOR-VEHICLETYPE---------------");

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
				getScreenshot("Vendor_", "VendorVehicleType", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Company Name
				highLight(isElementPresent("Company_id"), driver);
				isElementPresent("Company_id").sendKeys("Samyak Automation");
				System.out.println("Entered Company Name");
				getScreenshot("SearchData_", "VendorVehicleType", driver);
				WebElement Search = isElementPresent("Search_id");
				highLight(isElementPresent("Search_id"), driver);
				Search.click();
				System.out.println("clicked on Search button");
				getScreenshot("SearchResult_", "VendorVehicleType", driver);
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
					getScreenshot("Editor_", "VendorVehicleType", driver);

					// VehicleType
					highLight(isElementPresent("VendVehicleType_xpath"), driver);
					isElementPresent("VendVehicleType_xpath").click();
					System.out.println("Clicked on VehicleType menu");
					logs.info("Clicked on VehicleType menu");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					getScreenshot("VendVehicleTypeScreen_", "VendorVehicleType", driver);

					// -------- Create-Back--------
					highLight(isElementPresent("VVTCreate_id"), driver);
					isElementPresent("VVTCreate_id").click();
					System.out.println("Clicked on create button");
					logs.info("Clicked on create button");
					wait.until(ExpectedConditions.elementToBeClickable(isElementPresent("VVTBack_id")));
					getScreenshot("CreateScreen_", "VendorVehicleType", driver);

					// Back
					highLight(isElementPresent("VVTBack_id"), driver);
					isElementPresent("VVTBack_id").click();
					System.out.println("Clicked on Cancel button");
					logs.info("Clicked on Cancel button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Search
					System.out.println("--------------Testing search---------------");
					highLight(isElementPresent("VVTSearch_id"), driver);
					isElementPresent("VVTSearch_id").sendKeys("ANY1");
					System.out.println("Entered value in searchbox");
					logs.info("Entered value in searchbox");
					getScreenshot("SearchData_", "VendorVehicleType", driver);
					isElementPresent("VVTSearch_id").sendKeys(Keys.ENTER);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorVehicleType", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");

						// ---Edit-Back-----
						highLight(isElementPresent("Edit_xpath"), driver);
						isElementPresent("Edit_xpath").click();
						waitForPageLoad();
						System.out.println("Clicked on Edit button");
						logs.info("Clicked on Edit button");
						getScreenshot("Editor_", "VendorVehicleType", driver);
						Thread.sleep(2000);
						// Back
						highLight(isElementPresent("VVTBack_id"), driver);
						isElementPresent("VVTBack_id").click();
						System.out.println("Clicked on Cancel button");
						logs.info("Clicked on Cancel button");
						getScreenshot("SubmitCancel_", "VendorVehicleType", driver);
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
						Thread.sleep(2000);

						// NoOfVehicle
						highLight(isElementPresent("VVTNOVeh_id"), driver);
						isElementPresent("VVTNOVeh_id").clear();
						isElementPresent("VVTNOVeh_id").sendKeys("25");
						System.out.println("Enter value NoOfVehicle");
						logs.info("Enter value NoOfVehicle");

						// ValidTo
						highLight(isElementPresent("VVTValidTo_id"), driver);
						isElementPresent("VVTValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VVTValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("VehicleTypeEdWithData1_", "VendorVehicleType", driver);

						// Submit
						highLight(isElementPresent("VVTSubmit_id"), driver);
						isElementPresent("VVTSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VendorVehicleType", driver);

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VendorVehicleType", driver);
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
						getScreenshot("DeleteKeepIT_", "VendorVehicleType", driver);
						wait.until(ExpectedConditions
								.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));

						// Delete
						highLight(isElementPresent("Del_xpath"), driver);
						isElementPresent("Del_xpath").click();
						System.out.println("Clicked on delete button");
						getScreenshot("Delete_", "VendorVehicleType", driver);
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
						getScreenshot("DeleteDeleteIT_", "VendorVehicleType", driver);
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

					}
					// ----------Filter-Cancel----------
					highLight(isElementPresent("VVTSearch_id"), driver);
					isElementPresent("VVTSearch_id").clear();
					isElementPresent("VVTFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					getScreenshot("Filter_", "VendorVehicleType", driver);

					// Cancel
					highLight(isElementPresent("VVTFCancel_id"), driver);
					isElementPresent("VVTFCancel_id").click();
					System.out.println("clicked on Cancel button");
					logs.info("clicked on Cancel button");
					getScreenshot("FilterCancel_", "VendorVehicleType", driver);

					// ----Filter-ApplyFilter------------

					highLight(isElementPresent("VVTFilter_id"), driver);
					isElementPresent("VVTFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");

					// ServiceArea
					highLight(isElementPresent("VVTSerArea_id"), driver);
					isElementPresent("VVTSerArea_id").click();
					System.out.println("clicked on ServiceArea Dropdown");
					logs.info("clicked on ServiceArea Dropdown");
					Thread.sleep(1000);
					isElementPresent("VVTSerArea_id").sendKeys(Keys.DOWN);
					isElementPresent("VVTSerArea_id").sendKeys(Keys.ENTER);
					System.out.println("Selected ServiceArea");
					logs.info("Selected ServiceArea");

					// VehicleType
					highLight(isElementPresent("VVTVehType_id"), driver);
					isElementPresent("VVTVehType_id").click();
					isElementPresent("VVTVehType_id").sendKeys("CAR");
					System.out.println("Enter value in VehicleType dropdown");
					Thread.sleep(2000);
					isElementPresent("VVTVehType_id").sendKeys(Keys.ENTER);
					System.out.println("Selected VehicleType value");
					logs.info("Selected VehicleType value");

					getScreenshot("FilterData_", "VendorVehicleType", driver);

					// ApplyFilter
					highLight(isElementPresent("VVTFAppFil_id"), driver);
					isElementPresent("VVTFAppFil_id").click();
					System.out.println("Clicked on ApplyFilter");
					logs.info("Clicked on ApplyFilter");
					getScreenshot("ApplyFilter_", "VendorVehicleType", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					wait.until(ExpectedConditions
							.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorVehicleType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// ----Filter-ClearFilter------------Not implemented clear filter

					highLight(isElementPresent("VVTFilter_id"), driver);
					isElementPresent("VVTFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup"); // ClearFilter
					highLight(isElementPresent("VVTClearF_id"), driver);
					isElementPresent("VVTClearF_id").click();
					System.out.println("Clicked on Clear Filter");
					logs.info("Clicked on Clear Filter");
					getScreenshot("ClearFilter", "VendorVehicleType", driver); // ApplyFilter
					highLight(isElementPresent("VVTFAppFil_id"), driver);
					isElementPresent("VVTFAppFil_id").click();
					System.out.println("Clicked on ApplyFilter");
					logs.info("Clicked on ApplyFilter");
					wait.until(ExpectedConditions
							.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@role=\"presentation\"]")));
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					Data = isElementPresent("GridRecord_xpath").getText();
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorVehicleType", driver);
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// ----Filter-ShowInActive-Checked--Activate deleted Record------------
					highLight(isElementPresent("VVTFilter_id"), driver);
					isElementPresent("VVTFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					Thread.sleep(1000);
					// ShowInACtive
					highLight(isElementPresent("VVTSowDel_id"), driver);
					isElementPresent("VVTSowDel_id").click();
					System.out.println("Clicked on ShowDeleted checkbox");
					logs.info("Clicked on ShowDeleted checkbox");
					Thread.sleep(1000);
					getScreenshot("ShowInACtive_", "VendorVehicleType", driver);
					System.out.println("ShowDeleted is selected=="
							+ isElementPresent("VVTSowDel_id").getAttribute("aria-checked"));
					logs.info("ShowDeleted is selected=="
							+ isElementPresent("VVTSowDel_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveChecked_", "VendorVehicleType", driver);
					// ApplyFilter
					highLight(isElementPresent("VVTFAppFil_id"), driver);
					isElementPresent("VVTFAppFil_id").click();
					System.out.println("Clicked on ApplyFilter");
					logs.info("Clicked on ApplyFilter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorVehicleType", driver);
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
						highLight(isElementPresent("VVTValidTo_id"), driver);
						isElementPresent("VVTValidTo_id").clear();
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.add(Calendar.DATE, 1000);
						String newDate = dateFormat.format(cal.getTime());
						isElementPresent("VVTValidTo_id").sendKeys(newDate);
						System.out.println("Selected Date,1000 days priorior from current Date");
						logs.info("Selected Date,10 days priorior from current Date");

						getScreenshot("VehicleTypeEdWithData1_", "VendorVehicleType", driver);

						// Submit
						highLight(isElementPresent("VVTSubmit_id"), driver);
						isElementPresent("VVTSubmit_id").click();
						System.out.println("Clicked on Submit button");
						logs.info("Clicked on Submit button");
						wait.until(ExpectedConditions
								.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
						wait.until(ExpectedConditions.invisibilityOfElementLocated(
								By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
						getScreenshot("Submit_", "VendorVehicleType", driver);

					}

					// ----Filter-ShowInActive-UnChecked------------
					highLight(isElementPresent("VVTFilter_id"), driver);
					isElementPresent("VVTFilter_id").click();
					System.out.println("clicked on Filter popup");
					logs.info("clicked on Filter popup");
					// ShowInACtive
					highLight(isElementPresent("VVTSowDel_id"), driver);
					isElementPresent("VVTSowDel_id").click();
					System.out.println("Clicked on ShowDeleted checkbox");
					logs.info("Clicked on ShowDeleted checkbox");
					Thread.sleep(1000);
					getScreenshot("ShowInACtive_", "VendorVehicleType", driver);
					System.out.println("ShowDeleted is selected=="
							+ isElementPresent("VVTSowDel_id").getAttribute("aria-checked"));
					logs.info("ShowDeleted is selected=="
							+ isElementPresent("VVTSowDel_id").getAttribute("aria-checked"));
					getScreenshot("ShwInActiveUnchecked_", "VendorVehicleType", driver);
					// ApplyFilter
					highLight(isElementPresent("VVTFAppFil_id"), driver);
					isElementPresent("VVTFAppFil_id").click();
					System.out.println("Clicked on ApplyFilter");
					logs.info("Clicked on ApplyFilter");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					ImageFile = isElementPresent("ApNoDataImage_xpath");
					Data = isElementPresent("GridRecord_xpath").getText();
					System.out.println("searched data is" + " " + Data);
					logs.info("searched data is" + " " + Data);
					getScreenshot("SearchResult_", "VendorVehicleType", driver);
					if (ImageFile.isDisplayed()) {
						System.out.println("There is not any data related enetered search parameters");
						logs.info("There is not any data related enetered search parameters");

					} else {
						System.out.println("Data is present related enetered search parameters");
						logs.info("Data is present related enetered search parameters");
					}

					// PageSize
					pageSize("VendorVehicleType");

					// pagination
					pagination("VendorVehicleType");

					// normalView
					normalView("VendorVehicleType");

					break;
				}

			} else {
				System.out.println("Vendor is not exist");
				logs.info("Vendor is not exist");
			}

		}

	}
}
