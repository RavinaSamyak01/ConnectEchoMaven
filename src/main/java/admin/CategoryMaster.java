package admin;

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

public class CategoryMaster extends BaseInit {
	@Test
	public void categoryMaster() throws InterruptedException, IOException {
		System.out.println("--------------Testing CategoryMaster---------------");
		logs.info("--------------Testing CategoryMaster---------------");

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
		getScreenshot("Admindiv_", "CategoryMaster", driver);

		// CategoryMaster SubMenu
		WebElement Header = isElementPresent("AdminDiv_xpath");
		System.out.println("stored xpath of header");
		List<WebElement> HeaderItem = Header.findElements(By.className("dx-button-content"));
		System.out.println("stored all the HeaderItem");

		for (int count = 0; count < HeaderItem.size(); count++) {
			String headervalue = HeaderItem.get(count).getText();
			System.out.println("value of header item is" + "=" + HeaderItem.get(count).getText());
			// CategoryMaster
			if (headervalue.equalsIgnoreCase("Category Master")) {
				WebElement Hiteam = HeaderItem.get(count);
				highLight(Hiteam, driver);
				act.moveToElement(Hiteam).click().perform();
				System.out.println("Clicked on CategoryMaster");
				logs.info("Clicked on CategoryMaster");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				getScreenshot("CategoryMasterScreen_", "CategoryMaster", driver);

				// Create
				highLight(isElementPresent("CMCreate_xpath"), driver);
				isElementPresent("CMCreate_xpath").click();
				System.out.println("Click on Create button");
				logs.info("Click on Create button");

				// CategoryName
				highLight(isElementPresent("CMCatName_id"), driver);
				isElementPresent("CMCatName_id").sendKeys("Automation Category");
				System.out.println("Entered Category Name");
				logs.info("Entered Category Name");

				// Description
				highLight(isElementPresent("CMCatDesc_id"), driver);
				isElementPresent("CMCatDesc_id").sendKeys("This is for automation testing");
				System.out.println("Entered Description");
				logs.info("Entered Description");

				// Submit
				highLight(isElementPresent("CMSubmit_id"), driver);
				isElementPresent("CMSubmit_id").click();
				System.out.println("Click on Submit button");
				logs.info("Click on Submit button");

				// Back
				highLight(isElementPresent("CMBack_id"), driver);
				isElementPresent("CMBack_id").click();
				System.out.println("Click on Back button");
				logs.info("Click on Back button");

				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				// Search
				highLight(isElementPresent("CMCatName_id"), driver);
				isElementPresent("CMCatName_id").sendKeys("Automation Category");
				System.out.println("Entered Category Name");
				logs.info("Entered Category Name");
				isElementPresent("APSearch_id").sendKeys(Keys.ENTER);
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterSearch", "CategoryMaster", driver);

				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					waitForPageLoad();
					Thread.sleep(2000);
					System.out.println("Record is opened in the edit mode");
					logs.info("Record is opened in the edit mode");

					// Back
					highLight(isElementPresent("CMBack_id"), driver);
					isElementPresent("CMBack_id").click();
					System.out.println("Click on Back button");
					logs.info("Click on Back button");

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Search-Clear
				highLight(isElementPresent("CMCatName_id"), driver);
				isElementPresent("CMCatName_id").clear();
				isElementPresent("CMCatName_id").sendKeys(Keys.ENTER);
				System.out.println("Cleared the entered search criteria");
				logs.info("Cleared the entered search criteria");
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterClear", "CategoryMaster", driver);

				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
				}

				// ---Search--edit
				highLight(isElementPresent("CMCatName_id"), driver);
				isElementPresent("CMCatName_id").sendKeys("Automation");
				System.out.println("Entered Category Name");
				logs.info("Entered Category Name");
				isElementPresent("APSearch_id").sendKeys(Keys.ENTER);
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterSearch", "CategoryMaster", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");
				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

					// Edit
					highLight(isElementPresent("Edit_xpath"), driver);
					WebElement Edit = isElementPresent("Edit_xpath");
					js.executeScript("arguments[0].click();", Edit);
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					Thread.sleep(2000);
					getScreenshot("Editor_", "CategoryMaster", driver);

					// CategoryName
					boolean CatName = isElementPresent("CMCatName_id").isEnabled();
					if (CatName) {
						System.out.println("Category Name is enabled");
						logs.info("Category Name is enabled");
					} else {
						System.out.println("Category Name is Disabled");
						logs.info("Category Name is Disabled");
					}

					// Description
					highLight(isElementPresent("CMCatDesc_id"), driver);
					isElementPresent("CMCatDesc_id").clear();
					isElementPresent("CMCatDesc_id").sendKeys("This is for automation Testing");
					System.out.println("Entered description");
					logs.info("Entered description");

					// Submit
					highLight(isElementPresent("CMSubmit_id"), driver);
					isElementPresent("CMSubmit_id").click();
					System.out.println("Clicked on the submit button");
					logs.info("Clicked on the submit button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));

					System.out.println("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("SuccessfullMessage=" + isElementPresent("NoMsg_xpath").getText());

					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));

					// Back
					highLight(isElementPresent("CMBack_id"), driver);
					isElementPresent("CMBack_id").click();
					System.out.println("Click on Back button");
					logs.info("Click on Back button");

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// ---Search--Delete
				highLight(isElementPresent("CMCatName_id"), driver);
				isElementPresent("CMCatName_id").sendKeys("Automation");
				System.out.println("Entered Category Name");
				logs.info("Entered Category Name");
				isElementPresent("APSearch_id").sendKeys(Keys.ENTER);
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				System.out.println("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				logs.info("Records in the grid are==" + isElementPresent("GridRecord_xpath").getText());
				getScreenshot("GridAfterSearch", "CategoryMaster", driver);
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
					logs.info("Clicked on Delete button");
					getScreenshot("CategoryMasterDelete_", "CategoryMaster", driver);
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());

					// Keep it
					highLight(isElementPresent("DelKeepIt_xpath"), driver);
					isElementPresent("DelKeepIt_xpath").click();
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					getScreenshot("CategoryMasterKeepIT_", "CategoryMaster", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

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
					WebElement DelIT = isElementPresent("Delbtn_xpath");
					js.executeScript("arguments[0].click();", DelIT);
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					getScreenshot("CategoryMasterDeleteIT_", "CategoryMaster", driver);
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

					// Back
					highLight(isElementPresent("CMBack_id"), driver);
					isElementPresent("CMBack_id").click();
					System.out.println("Click on Back button");
					logs.info("Click on Back button");

					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// PageSize
				pageSize("CategoryMaster");

				// Pagination
				pagination("CategoryMaster");

				// NormalView
				normalView("CategoryMaster");

				// Columns
				columns("CategoryMaster");

				break;
			} else {
				System.out.println("CategoryMaster is not exist in Admin menu");
				logs.info("CategoryMaster is not exist in Admin menu");
			}
		}

	}

}
