package rate;

import java.io.IOException;
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

public class LMZoneSetup extends BaseInit {

	@Test
	public void lmZoneSetUp() throws InterruptedException, IOException {
		System.out.println("--------------Testing LMZoneSetUp---------------");
		logs.info("--------------Testing LMZoneSetUp---------------");

		// Rate From Navigation Bar
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Rate
		highLight(isElementPresent("Rate_xpath"), driver);
		isElementPresent("Rate_xpath").click();
		System.out.println("Clicked on the Rate module");
		logs.info("Clicked on the Rate module");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//nav[@class=\"sidenav\"]")));

		// ExpandButton Of Rate
		highLight(isElementPresent("Rate_xpath"), driver);
		isElementPresent("RateExpand_xpath").click();
		System.out.println("Clicked on the expand button of Rate module");
		logs.info("Clicked on the expand button of Rate module");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//dx-accordion//dxi-item")));

		WebElement RateList = isElementPresent("Ratelist_xpath");
		System.out.println("stored xpath of RateList");
		List<WebElement> RateItem = RateList.findElements(By.className("dx-button-content"));
		System.out.println("stored all the RateItem");

		for (int count = 0; count < RateItem.size(); count++) {
			String headervalue = RateItem.get(count).getText();
			System.out.println("value of header item is" + "=" + RateItem.get(count).getText());
			logs.info("value of header item is" + "=" + RateItem.get(count).getText());

			if (headervalue.equalsIgnoreCase(" LM Zone Setup")) {
				WebElement Hiteam = RateItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on LMZoneSetUp");
				logs.info("Clicked on LMZoneSetUp");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				Thread.sleep(1000);
				getScreenshot("LMZoneSetUp_", "LMZoneSetUp", driver);

				// ------------Search--------------
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");

				// Account
				highLight(isElementPresent("LMZSAC_id"), driver);
				isElementPresent("LMZSAC_id").sendKeys("120928449");
				System.out.println("Entered account number");
				logs.info("Entered account number");
				// ZoneType
				highLight(isElementPresent("LMZSZoneType_id"), driver);
				isElementPresent("LMZSZoneType_id").click();
				Thread.sleep(2000);
				isElementPresent("LMZSZoneType_id").sendKeys("LMD");
				Thread.sleep(1000);
				isElementPresent("LMZSZoneType_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Zone Type dropdown");
				logs.info("Selected value from Zone Type dropdown");
				getScreenshot("SearchData_", "LMZoneSetUp", driver);
				// SearchBTN
				highLight(isElementPresent("LMZSSearch_id"), driver);
				isElementPresent("LMZSSearch_id").click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "LMZoneSetUp", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// View
					highLight(isElementPresent("LMZSView_xpath"), driver);
					isElementPresent("LMZSView_xpath").click();
					System.out.println("clicked on View button");
					logs.info("clicked on View button");
					waitForPageLoad();
					Thread.sleep(2000);
					System.out.println("Record is open in  view mode");
					logs.info("Record is open in  view mode");

					// Back button
					highLight(isElementPresent("LMZSBack_id"), driver);
					isElementPresent("LMZSBack_id").click();
					System.out.println("clicked on Back button");
					logs.info("clicked on Back button");
					waitForPageLoad();

				}

				// cleared the search parameters
				highLight(isElementPresent("LMZSAC_id"), driver);
				isElementPresent("LMZSAC_id").clear();
				System.out.println("Cleared Account No");
				logs.info("Cleared Account No");

				highLight(isElementPresent("LMZSZoneType_id"), driver);
				isElementPresent("LMZSZoneType_id").clear();
				System.out.println("Cleared ZoneType");
				logs.info("Cleared ZoneType");

				getScreenshot("ClearedSearch_", "LMZoneSetUp", driver);

				// SearchBTN
				highLight(isElementPresent("LMZSSearch_id"), driver);
				isElementPresent("LMZSSearch_id").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				js.executeScript("arguments[0].scrollIntoView();", isElementPresent("GridRecord_xpath"));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("SearchResultAfterClear_", "LMZoneSetUp", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// ------------Search--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// ZoneType
				highLight(isElementPresent("LMZSMarket_id"), driver);
				isElementPresent("LMZSMarket_id").click();
				Thread.sleep(2000);
				highLight(isElementPresent("LMZSMarket_id"), driver);
				isElementPresent("LMZSMarket_id").sendKeys("FLASH-ATL");
				Thread.sleep(1000);
				isElementPresent("LMZSMarket_id").sendKeys(Keys.ENTER);
				System.out.println("Selected value from Market dropdown");
				logs.info("Selected value from Market dropdown");
				getScreenshot("SearchData_", "LMZoneSetUp", driver);
				// SearchBTN
				highLight(isElementPresent("LMZSSearch_id"), driver);
				isElementPresent("LMZSSearch_id").click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("SearchResult_", "LMZoneSetUp", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// ------------Search-ShowInActive-Checked--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				// ZoneType
				highLight(isElementPresent("LMZSMarket_id"), driver);
				isElementPresent("LMZSMarket_id").clear();
				System.out.println("Cleared Market value");
				logs.info("Cleared Market value");
				highLight(isElementPresent("LMZSShwInActive_id"), driver);
				isElementPresent("LMZSShwInActive_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("LMZSShwInActive_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("LMZSShwInActive_id").isSelected());

				getScreenshot("SearchData_", "LMZoneSetUp", driver);
				// SearchBTN
				highLight(isElementPresent("LMZSSearch_id"), driver);
				isElementPresent("LMZSSearch_id").click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("ShwInActCheckedData_", "LMZoneSetUp", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// ------------Search-ShowInActive-Checked--------------
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("LMZSShwInActive_id"), driver);
				isElementPresent("LMZSShwInActive_id").click();
				System.out.println("Show InActive is selected==" + isElementPresent("LMZSShwInActive_id").isSelected());
				logs.info("Show InActive is selected==" + isElementPresent("LMZSShwInActive_id").isSelected());

				getScreenshot("SearchData_", "LMZoneSetUp", driver);
				// SearchBTN
				highLight(isElementPresent("LMZSSearch_id"), driver);
				isElementPresent("LMZSSearch_id").click();
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				getScreenshot("ShwInActUnCheckedData_", "LMZoneSetUp", driver);
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// pageSize
				pageSize("LMZoneSetUp");

				// pagination
				pagination("LMZoneSetUp");

				// NormalView
				normalView("LMZoneSetUp");

				// Columns
				columns("LMZoneSetUp");

				break;

			} else {
				System.out.println("LMZoneSetUp is not exist");
				logs.info("LMZoneSetUp is not exist");
			}

		}

	}

}
