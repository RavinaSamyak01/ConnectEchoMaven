package vendor;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import samyak_BasePackage.BaseInit;

public class CourDriver extends BaseInit {
	@Test
	public void courierDriver() throws InterruptedException, IOException {
		System.out.println("--------------Testing COURIER-DRIVER---------------");
		logs.info("--------------Testing COURIER-DRIVER---------------");

		// Wait-JS-Action class
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// Actions act = new Actions(driver);
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
				getScreenshot("Courier_", "CourierDriver", driver);

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
				getScreenshot("CourierEditor_", "CourierDriver", driver);

				// Driver
				highLight(isElementPresent("CourDriv_xpath"), driver);
				isElementPresent("CourDriv_xpath").click();
				System.out.println("Clicked on driver menu");

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"gridContainer\"]")));

				// Create-Edit-Delete is not for driver

				// Search
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				highLight(isElementPresent("CDSearch_xpath"), driver);
				isElementPresent("CDSearch_xpath").sendKeys("AutoUser");
				isElementPresent("CDSearch_xpath").sendKeys(Keys.ENTER);
				System.out.println("Entered Day value in Searchbox");
				logs.info("Entered Day value in Searchbox");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("DriverSearchData_", "CourierDriver", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}
				// Pagination
				pagination("CourierDriver");

				// PageSize
				pageSize("CourierDriver");

				// NormalView
				normalView("CourierDriver");

				// click on columns
				columns("CourierDriver");
				break;
			} else {
				System.out.println("Courier is not exist");
			}
		}

	}
}
