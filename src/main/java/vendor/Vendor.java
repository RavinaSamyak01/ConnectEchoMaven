package vendor;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class Vendor extends BaseInit {

	@Test
	public void vendor() throws InterruptedException, IOException {

		// Login
		login();

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		// Main Vendor menu
		highLight(isElementPresent("MainVendor_xpath"), driver);
		isElementPresent("MainVendor_xpath").click();
		System.out.println("clicked on main Vendor menu");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id=\"single-spa-application:mnx-ui-userrole\"]/app-root/div/app-main-layout/div/app-sidebar/aside/div[2]/div/nav")));

		// Vendor menu
		highLight(isElementPresent("vendor_xpath"), driver);
		isElementPresent("vendor_xpath").click();
		System.out.println("clicked on Vendor submenu");
		waitForPageLoad();
		getScreenshot("VendorScreen_", "Vendor", driver);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

		// -------------Search--------------
		String Data = isElementPresent("GridRecord_xpath").getText();
		WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
		// Company Name
		highLight(isElementPresent("Company_id"), driver);
		isElementPresent("Company_id").sendKeys("Samyak Automation");
		System.out.println("Entered Company Name");
		getScreenshot("SearchData_", "Vendor", driver);
		WebElement Search = isElementPresent("Search_id");
		highLight(isElementPresent("Search_id"), driver);
		Search.click();
		System.out.println("clicked on Search button");
		/*
		 * js.executeScript("arguments[0].scrollIntoView();", Search);
		 * act.moveToElement(Search).click().perform();
		 * System.out.println("clicked on Search button");
		 */
		getScreenshot("SearchResult_", "Vendor", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");

			waitForPageLoad();
			// Edit
			System.out.println("Searched Record is opened in Edit mode");
			logs.info("Searched Record is opened in Edit mode");
			getScreenshot("Editor_", "Vendor", driver);

			// -------- Add Contact linkText------Cancel
			WebElement AddConatct = isElementPresent("AddContact_id");
			wait.until(ExpectedConditions.elementToBeClickable(AddConatct));
			js.executeScript("arguments[0].scrollIntoView();", AddConatct);
			highLight(isElementPresent("AddContact_id"), driver);
			js.executeScript("arguments[0].click();", AddConatct);
			System.out.println("clicked on Add Contact LinkText");
			logs.info("clicked on Add Contact LinkText");
			getScreenshot("AddContact_", "Vendor", driver);
			// Cancel
			highLight(isElementPresent("ContactCancel_id"), driver);
			isElementPresent("ContactCancel_id").click();
			System.out.println("Clicked on Cancel button");
			logs.info("Clicked on Cancel button");
			getScreenshot("ContactCancel_", "Vendor", driver);

			// -------- Add Contact linkText------Submit
			AddConatct = isElementPresent("AddContact_id");
			wait.until(ExpectedConditions.elementToBeClickable(AddConatct));
			js.executeScript("arguments[0].scrollIntoView();", AddConatct);
			highLight(isElementPresent("AddContact_id"), driver);
			js.executeScript("arguments[0].click();", AddConatct);
			System.out.println("clicked on Add Contact LinkText");
			logs.info("clicked on Add Contact LinkText");
			getScreenshot("AddContact_", "Vendor", driver);
			// ContactType
			highLight(isElementPresent("ContactType_id"), driver);
			isElementPresent("ContactType_id").click();
			System.out.println("Clicked on ContactType dropdown");
			Thread.sleep(1000);
			isElementPresent("ContactType_id").sendKeys(Keys.DOWN);
			isElementPresent("ContactType_id").sendKeys(Keys.ENTER);
			System.out.println("selected contact type");
			logs.info("selected contact type");
			// FirstName
			highLight(isElementPresent("FirstName_id"), driver);
			isElementPresent("FirstName_id").sendKeys("Rp");
			System.out.println("Entered FirstName");
			logs.info("Entered FirstName");
			// LastName
			highLight(isElementPresent("LastName_id"), driver);
			isElementPresent("LastName_id").sendKeys("Oza");
			System.out.println("Entered LastName");
			logs.info("Entered LastName");
			// Department
			highLight(isElementPresent("Department_id"), driver);
			isElementPresent("Department_id").sendKeys("Corporate");
			System.out.println("Entered Department");
			logs.info("Entered Department");
			// Email
			highLight(isElementPresent("Email_id"), driver);
			isElementPresent("Email_id").sendKeys("Rp@gmail.com");
			System.out.println("Entered EmailID");
			logs.info("Entered EmailID");
			// Mobile
			highLight(isElementPresent("Mobile_id"), driver);
			isElementPresent("Mobile_id").sendKeys("1234567899");
			System.out.println("Entered Mobile");
			logs.info("Entered Mobile");

			// Phone
			highLight(isElementPresent("Phone_id"), driver);
			isElementPresent("Phone_id").sendKeys("123456789");
			System.out.println("Entered PhoneNo");
			logs.info("Entered PhoneNo");
			getScreenshot("AddContactWithData_", "Vendor", driver);
			isElementPresent("Phone_id").sendKeys(Keys.TAB);
			Thread.sleep(1000);

			// Contact Submit
			WebElement CSub = isElementPresent("VenAddContactSUb_xpath");
			highLight(isElementPresent("VenAddContactSUb_xpath"), driver);
			js.executeScript("arguments[0].click();", CSub);
			System.out.println("Clicked on Submit button");
			logs.info("Clicked on Submit button");
			getScreenshot("ContactSubmit_", "Vendor", driver);

			// Submit
			highLight(isElementPresent("Submit_id"), driver);
			isElementPresent("Submit_id").click();
			System.out.println("Clicked on Submit button");
			logs.info("Clicked on Submit button");
			getScreenshot("Submit_", "Vendor", driver);

			// Back
			highLight(isElementPresent("Back_id"), driver);
			isElementPresent("Back_id").click();
			System.out.println("Clicked on Back button");
			logs.info("Clicked on Back button");
			waitForPageLoad();
			getScreenshot("SubmitBack_", "Vendor", driver);
			wait.until(
					ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

		}

		// -----------Additional Filter------------------
		highLight(isElementPresent("AdditionalFilter_id"), driver);
		isElementPresent("AdditionalFilter_id").click();
		System.out.println("Clicked on Additional Filter button");
		getScreenshot("AdditionalFil_", "Vendor", driver);
		// AutoVendor001
		highLight(isElementPresent("VendorCode_id"), driver);
		isElementPresent("VendorCode_id").sendKeys("AutoVen01");
		System.out.println("Entered Vendor Code");
		getScreenshot("SearchData_", "Vendor", driver);
		Search = isElementPresent("SearchAddFil_id");
		// js.executeScript("arguments[0].scrollIntoView();", Search);
		highLight(isElementPresent("SearchAddFil_id"), driver);
		act.moveToElement(Search).click().perform();
		System.out.println("clicked on Search button");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("SearchResult_", "Vendor", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");

		}

		// Additional Filter-InActive-Checked
		highLight(isElementPresent("VendorCode_id"), driver);
		isElementPresent("VendorCode_id").clear();
		isElementPresent("ShowInActive_id").click();
		System.out.println("Checked Show InActive checkbox");
		getScreenshot("ShwInActiveChecked_", "Vendor", driver);
		Search = isElementPresent("SearchAddFil_id");
		// js.executeScript("arguments[0].scrollIntoView();", Search);
		highLight(isElementPresent("SearchAddFil_id"), driver);
		act.moveToElement(Search).click().perform();
		System.out.println("clicked on Search button");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("SearchResult_", "Vendor", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");

		}

		// ShowInActive-Unchecked
		highLight(isElementPresent("ShowInActive_id"), driver);
		isElementPresent("ShowInActive_id").click();
		System.out.println("UnChecked Show InActive checkbox");
		getScreenshot("ShwInActiveUnchecked_", "Vendor", driver);
		Search = isElementPresent("SearchAddFil_id");
		highLight(isElementPresent("SearchAddFil_id"), driver);
		js.executeScript("arguments[0].scrollIntoView();", Search);
		act.moveToElement(Search).click().perform();
		System.out.println("clicked on Search button");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
		ImageFile = isElementPresent("ApNoDataImage_xpath");
		Data = isElementPresent("GridRecord_xpath").getText();
		System.out.println("searched data is" + " " + Data);
		logs.info("searched data is" + " " + Data);
		getScreenshot("SearchResult_", "Vendor", driver);
		if (ImageFile.isDisplayed()) {
			System.out.println("There is not any data related enetered search parameters");
			logs.info("There is not any data related enetered search parameters");

		} else {
			System.out.println("Data is present related enetered search parameters");
			logs.info("Data is present related enetered search parameters");

		}

		waitForPageLoad();
		// LessFilter
		WebElement lessfil = isElementPresent("LessFilter_id");
		highLight(isElementPresent("LessFilter_id"), driver);
		act.moveToElement(lessfil).click().perform();
		js.executeScript("arguments[0].click();", lessfil);
		System.out.println("Clicked on Less Filter button");
		getScreenshot("LessFilter_", "Vendor", driver);

		// PageSize
		pageSize("Vendor");

		// pagination
		pagination("Vendor");

		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		// NormalView
		normalView("Vendor");

	}

}
