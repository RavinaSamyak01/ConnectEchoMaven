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

public class CustomAirportZipCode extends BaseInit {

	@Test
	public void CustomAPZipCode() throws InterruptedException, IOException {
		System.out.println("--------------Testing CustomAPZipCode---------------");
		logs.info("--------------Testing CustomAPZipCode---------------");

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
		getScreenshot("Admindiv_", "CustomAPZipCode", driver);

		// Admin SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// Customs Airport/Zipcode
			if (headervalue.equalsIgnoreCase("Customs Airport/Zipcode")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on CustomAPZipCode");
				logs.info("Clicked on CustomAPZipCode");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("ComScreen_", "CustomAPZipCode", driver);

				// Create
				System.out.println("--Testing Create------");
				logs.info("----------Testing Create-------");
				highLight(isElementPresent("CAZCCreate_id"), driver);
				isElementPresent("CAZCCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("ComCreate_", "CustomAPZipCode", driver);

				// Cancel
				highLight(isElementPresent("CAZCCancel_id"), driver);
				isElementPresent("CAZCCancel_id").click();
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CAZCSearch_xpath"), driver);
				isElementPresent("CAZCSearch_xpath").sendKeys("Zip/Postal Code");
				isElementPresent("CAZCSearch_xpath").sendKeys(Keys.ENTER);
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
				highLight(isElementPresent("CAZCSearch_xpath"), driver);
				isElementPresent("CAZCSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CAZCFilter_id"), driver);
				isElementPresent("CAZCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("ComFilter_", "CustomAPZipCode", driver);
				highLight(isElementPresent("CAZCFZPCodeAP_id"), driver);
				isElementPresent("CAZCFZPCodeAP_id").sendKeys("R60406");
				System.out.println("Entered value in Zip/PostalCode/Airport");
				logs.info("Entered value in Zip/PostalCode/Airport");
				WebElement ApFi = isElementPresent("CAZCAppFilter_id");
				highLight(isElementPresent("CAZCAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ComFilterData_", "CustomAPZipCode", driver);
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
					getScreenshot("Editor_", "CustomAPZipCode", driver);

					// Area Type
					highLight(isElementPresent("CAZCAreaType_id"), driver);
					isElementPresent("CAZCAreaType_id").clear();
					isElementPresent("CAZCAreaType_id").click();
					isElementPresent("CAZCAreaType_id").sendKeys("Zip/Postal Code");
					Thread.sleep(2000);
					isElementPresent("CAZCAreaType_id").sendKeys(Keys.ENTER);
					System.out.println("Selected value from the device type");
					logs.info("Selected value from the device type");

					// Country
					highLight(isElementPresent("CAZCCountry_id"), driver);
					isElementPresent("CAZCCountry_id").clear();
					System.out.println("value is cleared");
					logs.info("value is cleared");
					isElementPresent("CAZCCountry_id").click();
					Thread.sleep(2000);
					System.out.println("clicked on Country dropdown");
					logs.info("clicked on Country dropdown");

					// Zip/Postal code Search
					highLight(isElementPresent("CAZCZipCodeSearch_id"), driver);
					isElementPresent("CAZCZipCodeSearch_id").click();
					System.out.println("Clicked on Search button of ZipCode");
					logs.info("Clicked on Search button of ZipCode");

					// ZipPostalcode
					highLight(isElementPresent("CAZCZpSZpCode_xpath"), driver);
					isElementPresent("CAZCZpSZpCode_xpath").sendKeys("R60406");
					System.out.println("entered ZipCode");
					logs.info("entered ZipCode");
					// search button
					highLight(isElementPresent("CAZCZpSSearch_id"), driver);
					isElementPresent("CAZCZpSSearch_id").click();
					System.out.println("Clicked on Search button of Search ZipCode");
					logs.info("Clicked on Search button of Search ZipCode");
					getScreenshot("SearchZipCode_", "CustomAPZipCode", driver);

					// Clear button
					highLight(isElementPresent("CAZCZpSClear_id"), driver);
					isElementPresent("CAZCZpSClear_id").click();
					System.out.println("Clicked on Clear button of Search ZipCode");
					logs.info("Clicked on Clear button of Search ZipCode");
					getScreenshot("SearchZipCodeClear_", "CustomAPZipCode", driver);

					// ZipPostalcode
					highLight(isElementPresent("CAZCZpSZpCode_xpath"), driver);
					isElementPresent("CAZCZpSZpCode_xpath").sendKeys("R60406");
					System.out.println("entered ZipCode");
					logs.info("entered ZipCode");
					// search button
					highLight(isElementPresent("CAZCZpSSearch_id"), driver);
					isElementPresent("CAZCZpSSearch_id").click();
					System.out.println("Clicked on Search button of Search ZipCode");
					logs.info("Clicked on Search button of Search ZipCode");
					getScreenshot("SearchZipCode_", "CustomAPZipCode", driver);

					// select record
					highLight(isElementPresent("CAZCSelect_xpath"), driver);
					isElementPresent("CAZCSelect_xpath").click();
					System.out.println("Selected the record");
					logs.info("Selected the record");
					getScreenshot("SelectedRecord_", "CustomAPZipCode", driver);

					// Warning
					highLight(isElementPresent("CAZCWarning_id"), driver);
					isElementPresent("CAZCWarning_id").clear();
					isElementPresent("CAZCWarning_id").sendKeys("This is For Automation");
					System.out.println("Entered value in Warning field");
					logs.info("Entered value in Warning field");

					// ValidTo
					highLight(isElementPresent("CAZCValidTo_id"), driver);
					isElementPresent("CAZCValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CAZCValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("Editorwithdata_", "CustomAPZipCode", driver);

					// submit
					WebElement Sub = isElementPresent("CAZCSubmit_id");
					highLight(isElementPresent("CAZCSubmit_id"), driver);
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
				highLight(isElementPresent("CAZCSearch_xpath"), driver);
				isElementPresent("CAZCSearch_xpath").clear();
				System.out.println("Cleared the search criteria");
				logs.info("Cleared the search criteria");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CAZCFilter_id"), driver);
				isElementPresent("CAZCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				getScreenshot("ComFilter_", "CustomAPZipCode", driver);
				highLight(isElementPresent("CAZCFZPCodeAP_id"), driver);
				isElementPresent("CAZCFZPCodeAP_id").sendKeys("R60406");
				System.out.println("Entered value in name");
				logs.info("Entered value in name");
				ApFi = isElementPresent("CAZCAppFilter_id");
				highLight(isElementPresent("CAZCAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ComFilterData_", "CustomAPZipCode", driver);
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
					getScreenshot("ComDelete_", "CustomAPZipCode", driver);

					// Keep it
					WebElement KeepIt = isElementPresent("DelKeepIt_xpath");
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					js.executeScript("arguments[0].click();", KeepIt);
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("ComDltKeepIt_", "CustomAPZipCode", driver);

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
					getScreenshot("ComDeleteDltIT_", "CustomAPZipCode", driver);
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

				highLight(isElementPresent("CAZCSearch_xpath"), driver);
				isElementPresent("CAZCSearch_xpath").clear();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CAZCFilter_id"), driver);
				isElementPresent("CAZCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				highLight(isElementPresent("CAZCShwInAct_id"), driver);
				isElementPresent("CAZCShwInAct_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("CAZCShwInAct_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("CAZCShwInAct_id").isSelected());
				getScreenshot("ComShwInActive_", "CustomAPZipCode", driver);
				ApFi = isElementPresent("CAZCAppFilter_id");
				highLight(isElementPresent("CAZCAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				getScreenshot("ComEdit_", "CustomAPZipCode", driver);
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
					highLight(isElementPresent("CAZCValidTo_id"), driver);
					isElementPresent("CAZCValidTo_id").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("CAZCValidTo_id").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					getScreenshot("ComEdtrwithData_", "CustomAPZipCode", driver);

					// SUbmit
					WebElement Sub = isElementPresent("CAZCSubmit_id");
					highLight(isElementPresent("CAZCSubmit_id"), driver);
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
				highLight(isElementPresent("CAZCFilter_id"), driver);
				isElementPresent("CAZCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				WebElement clear = isElementPresent("CAZCClearFil_id");
				highLight(isElementPresent("CAZCClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				highLight(isElementPresent("CAZCShwInAct_id"), driver);
				isElementPresent("CAZCShwInAct_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("CAZCShwInAct_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("CAZCShwInAct_id").isSelected());
				getScreenshot("ComShwInActive_", "CustomAPZipCode", driver);
				ApFi = isElementPresent("CAZCAppFilter_id");
				highLight(isElementPresent("CAZCAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("ComShwInActData_", "CustomAPZipCode", driver);
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
				highLight(isElementPresent("CAZCFilter_id"), driver);
				isElementPresent("CAZCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("CAZCClearFil_id");
				highLight(isElementPresent("CAZCClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				ApFi = isElementPresent("CAZCAppFilter_id");
				highLight(isElementPresent("CAZCAppFilter_id"), driver);
				js.executeScript("arguments[0].click();", ApFi);
				System.out.println("Clicked on Apply Filter button");
				logs.info("Clicked on Apply Filter button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("ComGridAFClearF_", "CustomAPZipCode", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Filter-Cancel
				highLight(isElementPresent("CAZCFilter_id"), driver);
				isElementPresent("CAZCFilter_id").click();
				System.out.println("Clicked on Filter button");
				logs.info("Clicked on Filter button");
				clear = isElementPresent("CAZCClearFil_id");
				highLight(isElementPresent("CAZCClearFil_id"), driver);
				js.executeScript("arguments[0].click();", clear);
				System.out.println("Clicked on Clear Filter button");
				logs.info("Clicked on Clear Filter button");
				WebElement Cancl = isElementPresent("CAZFCancel_id");
				js.executeScript("arguments[0].click();", Cancl);
				System.out.println("Clicked on Cancel button");
				logs.info("Clicked on Cancel button");

				// PageSize
				pageSize("CustomAPZipCode");

				// Pagination
				pagination("CustomAPZipCode");

				// NormalView
				normalView("CustomAPZipCode");

				// columns
				columns("CustomAPZipCode");

				break;
			} else {
				System.out.println("CustomAPZipCode is not exist");
				logs.info("CustomAPZipCode is not exist");
			}

		}

	}

}
