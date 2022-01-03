package vendor;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class Courier extends BaseInit {

	@Test
	public void courier() throws InterruptedException, IOException {
		System.out.println("--------------Testing COURIER---------------");
		logs.info("--------------Testing COURIER---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Actions act = new Actions(driver);

		// Main Vendor menu
		highLight(isElementPresent("MainVendor_xpath"), driver);
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		logs.info("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"sidenav\"]/ul/li")));
		getScreenshot("mainVendor_", "VendCourier", driver);

		WebElement vendordiv = isElementPresent("VCorDiv_xpath");
		List<WebElement> vendItem = vendordiv.findElements(By.className("dx-button-content"));
		for (int count1 = 0; count1 < vendItem.size(); count1++) {
			String IName = vendItem.get(count1).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			logs.info("Vendor Menu item name is==" + IName);

			if (IName.equalsIgnoreCase("Courier")) {
				highLight(vendItem.get(count1), driver);
				vendItem.get(count1).click();
				System.out.println("clicked on Courier");
				logs.info("clicked on Courier");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("Courier_", "VendCourier", driver);

				// ---------Create-----Back---------
				highLight(isElementPresent("CourCreate_id"), driver);
				isElementPresent("CourCreate_id").click();
				System.out.println("Clicked on create button");
				logs.info("Clicked on create button");
				waitForPageLoad();
				getScreenshot("CourierEditor_", "VendCourier", driver);
				// BackButton
				highLight(isElementPresent("CourBack_id"), driver);
				isElementPresent("CourBack_id").click();
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("CourierGrid_", "VendCourier", driver);

				// -----------Search-----------------------
				waitForPageLoad();
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Name
				highLight(isElementPresent("CourSName_xpath"), driver);
				isElementPresent("CourSName_xpath").sendKeys("Ravina Prajapati");
				System.out.println("Entered value in Name");
				logs.info("Entered value in Name");
				// AgentCode
				highLight(isElementPresent("CourSAgCode_xpath"), driver);
				isElementPresent("CourSAgCode_xpath").sendKeys("R100");
				System.out.println("Entered value in AgentCode");
				logs.info("Entered value in AgentCode");
				getScreenshot("SearchCriteria_", "VendCourier", driver);
				// SearchBTN
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				WebElement Search = isElementPresent("CourSearch_id");
				highLight(isElementPresent("CourSearch_id"), driver);
				js.executeScript("arguments[0].click()", Search);
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				js.executeScript("arguments[0].scrollIntoView();", isElementPresent("GridRecord_xpath"));
				getScreenshot("CourGridAFSearch_", "VendCourier", driver);
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					WebElement Acode = isElementPresent("VCorCrAgCode_xpath");
					wait.until(ExpectedConditions.textToBePresentInElementValue(Acode, "R100"));
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					getScreenshot("CourEditrAFSearch_", "VendCourier", driver);
					// Submit
					highLight(isElementPresent("CourSubmit_id"), driver);
					isElementPresent("CourSubmit_id").click();
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					// Back
					highLight(isElementPresent("CourBack_id"), driver);
					isElementPresent("CourBack_id").click();
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();
					getScreenshot("CourGRidAFEdit_", "VendCourier", driver);

				}

				// -------------- Additional Filter------------------
				highLight(isElementPresent("CourAddFilter_id"), driver);
				isElementPresent("CourAddFilter_id").click();
				System.out.println("clicked on Additional Filter");
				logs.info("clicked on Additional Filter");
				getScreenshot("AddFilter", "VendCourier", driver);
				// Country
				highLight(isElementPresent("VCorCountry_xpath"), driver);
				isElementPresent("VCorCountry_xpath").click();
				isElementPresent("VCorCountry_xpath").sendKeys("United States");
				Thread.sleep(2000);
				System.out.println("clicked on Country dropdown");
				logs.info("clicked on Country dropdown");
				isElementPresent("VCorCountry_xpath").sendKeys(Keys.TAB);
				// Zip/PostalCode
				highLight(isElementPresent("VCorZipC_xpath"), driver);
				isElementPresent("VCorZipC_xpath").sendKeys("60406");
				System.out.println("Entered value in Zip/PostalCode Field");
				logs.info("Entered value in Zip/PostalCode Field");
				// City
				highLight(isElementPresent("VCorCity_xpath"), driver);
				isElementPresent("VCorCity_xpath").sendKeys("BLUE ISLAND");
				System.out.println("Entered value in City");
				logs.info("Entered value in City");
				getScreenshot("AddFilWithData_", "VendCourier", driver);

				// State/Province
				boolean StateProv = isElementPresent("VCorState_xpath").isEnabled();
				if (StateProv) {
					System.out.println("State/Province is Enabled");
					logs.info(" State/Province is Enabled");

				} else {
					System.out.println("State/Province is Disabled");
					logs.info("State/Province is Disabled");
				}

				// AreaType-already default value selected
				/*
				 * isElementPresent("VCorAreaType_xpath").sendKeys("");
				 * System.out.println("clicked on AreaType dropdown");
				 */
				
				/*
				 * // AreaCode isElementPresent("VCorAreaCode_xpath").sendKeys("");
				 * System.out.println("Entered value in AreaCode");
				 * 
				 * // VehicleType isElementPresent("VCorVehType_xpath").sendKeys("");
				 * Thread.sleep(2000); System.out.println("clicked on VehicleType dropdown");
				 * isElementPresent("VCorVehType_xpath").sendKeys(Keys.TAB);
				 * 
				 * // Type isElementPresent("VCorFoCnType_xpath").sendKeys("Agent");
				 * Thread.sleep(2000); System.out.println("clicked on Type dropdown");
				 * isElementPresent("VCorFoCnType_xpath").sendKeys(Keys.TAB);
				 * 
				 * // Phone
				 * 
				 * isElementPresent("VCorPhnNo_xpath").sendKeys("1234567891");
				 * System.out.println("Entered value in PhoneNo");
				 */
				
				
				// LessFilter
				highLight(isElementPresent("VCorLessFil_xpath"), driver);
				isElementPresent("VCorLessFil_xpath").click();
				System.out.println("clicked on Less Filter popup");
				logs.info("clicked on Less Filter popup");
				getScreenshot("LessFilter_", "VendCourier", driver);
				// SearchBTN
				highLight(isElementPresent("CourSearch_id"), driver);
				isElementPresent("CourSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				js.executeScript("arguments[0].scrollIntoView();", isElementPresent("GridRecord_xpath"));
				Data = isElementPresent("GridRecord_xpath").getText();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("GridAfAddFilSearch_", "VendCourier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// ----------- Additional Filter--TSACertified Checkbox------------------
				js.executeScript("window.scrollBy(0, -250)", "");
				highLight(isElementPresent("CourAddFilter_id"), driver);
				isElementPresent("CourAddFilter_id").click();
				System.out.println("clicked on Additional Filter popup");
				logs.info("clicked on Additional Filter popup");
				// TSACertified Checkbox
				highLight(isElementPresent("CourFTSA_id"), driver);
				isElementPresent("CourFTSA_id").click();
				System.out.println("Checkbox is checked=" + isElementPresent("VCorTSACer_xpath").isSelected());
				logs.info("Checkbox is checked=" + isElementPresent("VCorTSACer_xpath").isSelected());
				System.out.println("Checked the checkbox");
				logs.info("Checked the checkbox");
				getScreenshot("TSACertiCheckBx_", "VendCourier", driver);
				// SearchBTN
				highLight(isElementPresent("CourSearch_id"), driver);
				isElementPresent("CourSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// js.executeScript("arguments[0].scrollIntoView();",
				// isElementPresent("GridRecord_xpath"));
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("GridAfTSAChbChecked_", "VendCourier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// LessFilter
				js.executeScript("window.scrollBy(0, -250)", "");
				highLight(isElementPresent("VCorLessFil_xpath"), driver);
				isElementPresent("VCorLessFil_xpath").click();
				System.out.println("clicked on Less Filter popup");
				logs.info("clicked on Less Filter popup");

				// ----------Additional Filter----FDX TSA Checkbox-----
				js.executeScript("window.scrollBy(0, -250)", "");
				highLight(isElementPresent("CourAddFilter_id"), driver);
				isElementPresent("CourAddFilter_id").click();
				System.out.println("clicked on Additional Filter popup");
				logs.info("clicked on Additional Filter popup");
				// FDX TSA Checkbox
				highLight(isElementPresent("CourFDX_id"), driver);
				isElementPresent("CourFDX_id").click();
				System.out.println("Checkbox is checked=" + isElementPresent("CourFDX_id").isSelected());
				logs.info("Checkbox is checked=" + isElementPresent("CourFDX_id").isSelected());
				System.out.println("Checked the checkbox");
				logs.info("Checked the checkbox");
				getScreenshot("FDXTSAChkbxChecked_", "VendCourier", driver);
				// SearchBTN
				highLight(isElementPresent("CourSearch_id"), driver);
				isElementPresent("CourSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// js.executeScript("arguments[0].scrollIntoView();",
				// isElementPresent("GridRecord_xpath"));
				// Thread.sleep(1000);
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("GridAfFDXChbChecked_", "VendCourier", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// LessFilter
				js.executeScript("window.scrollBy(0, -250)", "");
				highLight(isElementPresent("VCorLessFil_xpath"), driver);
				isElementPresent("VCorLessFil_xpath").click();
				System.out.println("clicked on Less Filter popup");
				logs.info("clicked on Less Filter popup");

				// Additional Filter
				js.executeScript("window.scrollBy(0, -250)", "");
				highLight(isElementPresent("CourAddFilter_id"), driver);
				isElementPresent("CourAddFilter_id").click();
				System.out.println("clicked on Additional Filter popup");
				logs.info("clicked on Additional Filter popup");
				// Show InActive Checkbox
				highLight(isElementPresent("CourFShwInAct_id"), driver);
				isElementPresent("CourFShwInAct_id").click();
				System.out.println("Checkbox is checked=" + isElementPresent("CourFShwInAct_id").isSelected());
				logs.info("Checkbox is checked=" + isElementPresent("CourFShwInAct_id").isSelected());
				System.out.println("Checked the checkbox");
				logs.info("Checked the checkbox");
				getScreenshot("ShwInActCHbxChecked_", "VendCourier", driver);

				// SearchBTN
				highLight(isElementPresent("CourSearch_id"), driver);
				isElementPresent("CourSearch_id").click();
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
				getScreenshot("GridAFShInAcchecked_", "VendCourier", driver);

				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// LessFilter
				js.executeScript("window.scrollBy(0, -250)", "");
				highLight(isElementPresent("VCorLessFil_xpath"), driver);
				isElementPresent("VCorLessFil_xpath").click();
				System.out.println("clicked on Less Filter popup");
				logs.info("clicked on Less Filter popup");
				Thread.sleep(2000);
				waitForPageLoad();

				// Pagination
				pagination("VendCourier");

				// PageSize
				pageSize("VendCourier");

				// NormalView
				normalView("VendCourier");

				// columns
				columns("VendCourier");

				break;
			} else {
				System.out.println("Courier is not exist");
				logs.info("Courier is not exist");
			}
		}

	}

}
