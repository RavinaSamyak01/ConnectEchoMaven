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

public class IntegratorMaster extends BaseInit {
//-------------Remaining because ID is not there------------
	@Test
	public void venIntegratorMaster() throws InterruptedException, IOException {
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

		WebElement vendordiv = isElementPresent("VCorDiv_xpath");
		List<WebElement> vendItem = vendordiv.findElements(By.className("dx-button-content"));
		for (int count1 = 0; count1 < vendItem.size(); count1++) {
			String IName = vendItem.get(count1).getText();
			System.out.println("Vendor Menu item name is==" + IName);
			logs.info("Vendor Menu item name is==" + IName);
			if (IName.equalsIgnoreCase("Integrator Master")) {
				highLight(vendItem.get(count1), driver);
				vendItem.get(count1).click();
				System.out.println("clicked on Integrator Master");
				logs.info("clicked on Integrator Master");
				waitForPageLoad();
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
				wait.until(ExpectedConditions
						.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
				getScreenshot("IntegratorMaster_", "IntegratorMaster", driver);

				// Create-Back
				System.out.println("------------------------Testing Create-Cancel------------------------");
				logs.info("------------------------Testing Create-Cancel------------------------");
				wait.until(ExpectedConditions.visibilityOf(isElementPresent("IMCreate_id")));
				highLight(isElementPresent("IMCreate_id"), driver);
				isElementPresent("IMCreate_id").click();
				System.out.println("Clicked on Create button");
				logs.info("Clicked on Create button");
				waitForPageLoad();
				getScreenshot("IntegratorMasterCreate_", "IntegratorMaster", driver);

				// Back
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label=\"Back\"]")));
				WebElement Back = isElementPresent("Back_xpath");
				highLight(isElementPresent("Back_xpath"), driver);
				js.executeScript("arguments[0].click();", Back);
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				getScreenshot("IntegratorMasterCreateBack_", "IntegratorMaster", driver);
				waitForPageLoad();

				// Create-Submit
				/*
				 * System.out.
				 * println("------------------------Testing Create-Close------------------------"
				 * ); logs.
				 * info("------------------------Testing Create-Close------------------------");
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				 * "//*[@aria-label=\"Create\"]"))); isElementPresent("IMCreate_id").click();
				 * System.out.println("Clicked on Create button");
				 * logs.info("Clicked on Create button"); waitForPageLoad();
				 * 
				 * // IMName isElementPresent("IMName_xpath").click();
				 * System.out.println("Clicked on IMName"); logs.info("Clicked on IMName");
				 * isElementPresent("IMNameIt_xpath").click();
				 * System.out.println("Selected 1st value"); logs.info("Selected 1st value"); //
				 * IMAccount isElementPresent("IMAC_xpath").sendKeys("IMAC01");
				 * System.out.println("enetered value in IM Account");
				 * logs.info("enetered value in IM Account"); // IM Internal Name
				 * isElementPresent("IMInName_xpath").sendKeys("MNX RJ");
				 * System.out.println("enetered value in IM Internal Name");
				 * logs.info("enetered value in IM Internal Name"); // ValidTo DateFormat
				 * dateFormat = new SimpleDateFormat("MM/dd/yyyy"); Calendar cal =
				 * Calendar.getInstance(); cal.setTime(new Date()); cal.add(Calendar.DATE, 10);
				 * String newDate = dateFormat.format(cal.getTime());
				 * isElementPresent("IMValidTo_xpath").sendKeys(newDate);
				 * System.out.println("Selected Date,10 days priorior from current Date");
				 * logs.info("Selected Date,10 days priorior from current Date");
				 * 
				 * // IntMNXFirstName WebElement InName = isElementPresent("IMINFName_xpath");
				 * js.executeScript("arguments[0].scrollIntoView(0);", InName);
				 * InName.sendKeys("IntRavina"); InName.sendKeys(Keys.ENTER);
				 * System.out.println("enetered value in Internal FirstName");
				 * logs.info("enetered value in Internal FirstName");
				 * 
				 * // ExternalFirstName WebElement ExName = isElementPresent("IMEXFName_xpath");
				 * js.executeScript("arguments[0].scrollIntoView(0);", ExName);
				 * ExName.sendKeys("ExtRavina"); ExName.sendKeys(Keys.ENTER);
				 * System.out.println("enetered value in External FirstName");
				 * logs.info("enetered value in External FirstName");
				 * 
				 * getScreenshot("IntMasterWithData_", "IntegratorMaster", driver);
				 * 
				 * // Submit WebElement Submit = isElementPresent("Submit_xpath");
				 * js.executeScript("arguments[0].click();", Submit);
				 * System.out.println("Clicked on Submit button");
				 * logs.info("Clicked on Submit button"); getScreenshot("IntMSubmit_",
				 * "IntegratorMaster", driver);
				 * 
				 * // MSG wait.until(ExpectedConditions .visibilityOfElementLocated(By.
				 * xpath("//*[@class=\"success dx-template-wrapper\"]")));
				 * isElementPresent("SubMsgHeader_xpath").getText();
				 * System.out.println("Header of the message is==" +
				 * isElementPresent("SubMsgHeader_xpath").getText());
				 * isElementPresent("SubMsg_xpath").getText(); System.out.println("Message is=="
				 * + isElementPresent("SubMsg_xpath").getText()); wait.until(ExpectedConditions
				 * .invisibilityOfElementLocated(By.
				 * xpath("//*[@class=\"success dx-template-wrapper\"]")));
				 * getScreenshot("IntMasterSUbmit", "IntegratorMaster", driver);
				 * 
				 * // Back wait.until(ExpectedConditions .elementToBeClickable(By.xpath(
				 * "//*[@class=\"bottom-action-bar-section\"]/dx-button"))); Back =
				 * isElementPresent("Back_xpath"); js.executeScript("arguments[0].click();",
				 * Back); System.out.println("Clicked on Back button");
				 * logs.info("Clicked on Back button"); waitForPageLoad();
				 */

				// Search
				WebElement ImageFile = isElementPresent("ApNoDataImage_xpath");
				// Internal MNX Name
				highLight(isElementPresent("Back_xpath"), driver);
				isElementPresent("IMSMNXIntName_xpath").sendKeys("MNX RJ");
				System.out.println("Entered value in Internal MNX Name");
				logs.info("Entered value in Internal MNX Name");
				// Account
				highLight(isElementPresent("Back_xpath"), driver);
				isElementPresent("IMSACNo_xpath").sendKeys("IMAC01");
				System.out.println("Entered value in Account");
				logs.info("Entered value in Account");
				getScreenshot("IntMSearchData_", "IntegratorMaster", driver);

				// SearchBTN
				isElementPresent("IMSearch_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				String Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("IntMSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					waitForPageLoad();
					getScreenshot("IntMEditMode_", "IntegratorMaster", driver);

					// IMAccount
					isElementPresent("IMAC_xpath").clear();
					isElementPresent("IMAC_xpath").sendKeys("IMAC01");
					System.out.println("enetered value in IM Account");
					logs.info("enetered value in IM Account");
					// IM Internal Name
					/*
					 * isElementPresent("IMInName_xpath").clear();
					 * isElementPresent("IMInName_xpath").sendKeys("MNX RJ");
					 * System.out.println("enetered value in IM Internal Name");
					 * logs.info("enetered value in IM Internal Name");
					 */
					// ValidTo
					isElementPresent("IMValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("IMValidTo_xpath").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// IntMNXFirstName
					WebElement InName = isElementPresent("IMINFName_xpath");
					js.executeScript("arguments[0].scrollIntoView(0);", InName);
					InName.clear();
					InName.sendKeys("IntRavina");
					InName.sendKeys(Keys.ENTER);
					System.out.println("enetered value in Internal FirstName");
					logs.info("enetered value in Internal FirstName");

					// ExternalFirstName
					WebElement ExName = isElementPresent("IMEXFName_xpath");
					js.executeScript("arguments[0].scrollIntoView(0);", ExName);
					ExName.clear();
					ExName.sendKeys("ExtRavina");
					ExName.sendKeys(Keys.ENTER);
					System.out.println("enetered value in External FirstName");
					logs.info("enetered value in External FirstName");

					getScreenshot("IntMasterWithData_", "IntegratorMaster", driver);

					// Submit
					WebElement Submit = isElementPresent("Submit_xpath");
					js.executeScript("arguments[0].click();", Submit);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");

					// Back
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@class=\"bottom-action-bar-section\"]/dx-button")));
					Back = isElementPresent("Back_xpath");
					js.executeScript("arguments[0].click();", Back);
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));

				}

				// Additional Filter
				isElementPresent("IMAddFilter_xpath").click();
				System.out.println("Clicked on Additional Filter button");
				logs.info("Clicked on Additional Filter button");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//*[@class=\"dx-field-value\"]/dx-check-box[@formcontrolname=\"showInactive\"]")));
				getScreenshot("IntMAdditionalFilter_", "IntegratorMaster", driver);

				// ShowInactive-checked
				isElementPresent("IMShwInAct_xpath").click();
				System.out.println("Click on Show InActive Checkbox");
				System.out.println("Checkbox of Show InActive is Checked=="
						+ isElementPresent("IMShwInAct_xpath").getAttribute("aria-checked"));
				logs.info("Click on Show InActive Checkbox");
				logs.info("Checkbox of Show InActive is Checked=="
						+ isElementPresent("IMShwInAct_xpath").getAttribute("aria-checked"));
				getScreenshot("IntMShwInActiveChecked_", "IntegratorMaster", driver);
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				isElementPresent("IMSearch_xpath").click();
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
				getScreenshot("ShwInActCheckedSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// ShowInactive-Unchecked
				isElementPresent("IMShwInAct_xpath").click();
				System.out.println("Click on Show InActive Checkbox");
				logs.info("Click on Show InActive Checkbox");
				Thread.sleep(1000);
				System.out.println("Checkbox of Show InActive is Checked=="
						+ isElementPresent("IMShwInAct_xpath").getAttribute("aria-checked"));
				logs.info("Checkbox of Show InActive is Checked=="
						+ isElementPresent("IMShwInAct_xpath").getAttribute("aria-checked"));
				getScreenshot("IntMShwInActiveUnChecked_", "IntegratorMaster", driver);
				isElementPresent("IMSearch_xpath").click();
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
				getScreenshot("ShwInActUncheckedSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");

				}

				// LessFilter
				isElementPresent("IMLessFil_xpath").click();
				System.out.println("Clicked on Less Filter button");
				logs.info("Clicked on Less Filter button");
				getScreenshot("IntMaLessFilter_", "IntegratorMaster", driver);

				// Search----Edit-
				// Internal MNX Name
				isElementPresent("IMSMNXIntName_xpath").sendKeys("MNX RJ");
				System.out.println("Entered value in Internal MNX Name");
				logs.info("Entered value in Internal MNX Name");
				// SearchBTN
				isElementPresent("IMSearch_xpath").click();
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
				getScreenshot("IntMSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					// Edit
					isElementPresent("Edit_xpath").click();
					System.out.println("Clicked on Edit button");
					logs.info("Clicked on Edit button");
					waitForPageLoad();
					getScreenshot("IntMaEditor_", "IntegratorMaster", driver);

					Back = isElementPresent("Back_xpath");
					js.executeScript("arguments[0].click();", Back);
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					waitForPageLoad();

				}

				// Search----Delete-
				// Internal MNX Name
				isElementPresent("IMSMNXIntName_xpath").sendKeys("MNX RJ");
				System.out.println("Entered value in Internal MNX Name");
				logs.info("Entered value in Internal MNX Name");
				// SearchBTN
				isElementPresent("IMSearch_xpath").click();
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
				getScreenshot("IntMSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					// Delete
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@src=\"/assets/img/delete-icon-dark.svg\"]")));
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");
					logs.info("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					getScreenshot("IntMDelete_", "IntegratorMaster", driver);

					// Keep it
					isElementPresent("DelKeepIt_xpath").click();
					System.out.println("Clicked on Keep It button");
					logs.info("Clicked on Keep It button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					getScreenshot("IntMKeepIt_", "IntegratorMaster", driver);

					// Delete
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-datagrid-content\"]/table")));
					isElementPresent("Del_xpath").click();
					System.out.println("Clicked on Delete button");
					System.out.println("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					System.out.println("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					logs.info("Clicked on Delete button");
					logs.info("Header of the pop up is=" + isElementPresent("Delhed_xpath").getText());
					logs.info("Message of the pop up is=" + isElementPresent("Delmsg_xpath").getText());
					// DeleteIt
					isElementPresent("Delbtn_xpath").click();
					System.out.println("Clicked on Delete It button");
					logs.info("Clicked on Delete It button");
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]/p")));
					System.out.println("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
					logs.info("Delete Message=" + isElementPresent("NoMsg_xpath").getText());
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"success dx-template-wrapper\"]")));
					getScreenshot("IntMDeleteIT_", "IntegratorMaster", driver);

					// Back
					Back = isElementPresent("Back_xpath");
					js.executeScript("arguments[0].click();", Back);
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					waitForPageLoad();

				}

				// Activate deleted record-------
				// Internal MNX Name
				isElementPresent("IMSMNXIntName_xpath").sendKeys("MNX RJ");
				System.out.println("Entered value in Internal MNX Name");
				logs.info("Entered value in Internal MNX Name");
				// Account
				isElementPresent("IMSACNo_xpath").sendKeys("IMAC01");
				System.out.println("Entered value in Account");
				logs.info("Entered value in Account");
				// AddFilter
				isElementPresent("IMAddFilter_xpath").click();
				System.out.println("Clicked on Additional Filter button");
				logs.info("Clicked on Additional Filter button");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//*[@class=\"dx-field-value\"]/dx-check-box[@formcontrolname=\"showInactive\"]")));
				getScreenshot("IntMAdditionalFilter_", "IntegratorMaster", driver);
				// ShowInactive-checked
				isElementPresent("IMShwInAct_xpath").click();
				System.out.println("Click on Show InActive Checkbox");
				System.out.println("Checkbox of Show InActive is Checked=="
						+ isElementPresent("IMShwInAct_xpath").getAttribute("aria-checked"));
				logs.info("Click on Show InActive Checkbox");
				logs.info("Checkbox of Show InActive is Checked=="
						+ isElementPresent("IMShwInAct_xpath").getAttribute("aria-checked"));
				getScreenshot("IntMSearchData_", "IntegratorMaster", driver);

				// SearchBTN
				isElementPresent("IMSearch_xpath").click();
				System.out.println("Clicked on Search button");
				logs.info("Clicked on Search button");
				ImageFile = isElementPresent("ApNoDataImage_xpath");
				Data = isElementPresent("GridRecord_xpath").getText();
				System.out.println("searched data is" + " " + Data);
				logs.info("searched data is" + " " + Data);
				getScreenshot("IntMSearchResult_", "IntegratorMaster", driver);
				if (ImageFile.isDisplayed()) {
					System.out.println("There is not any data related enetered search parameters");
					logs.info("There is not any data related enetered search parameters");

				} else {
					System.out.println("Data is present related enetered search parameters");
					logs.info("Data is present related enetered search parameters");
					System.out.println("Searched Record is opened in Edit mode");
					logs.info("Searched Record is opened in Edit mode");
					waitForPageLoad();
					getScreenshot("IntMEditMode_", "IntegratorMaster", driver);
					Thread.sleep(2000);
					// ValidTo
					isElementPresent("IMValidTo_xpath").clear();
					DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Calendar cal = Calendar.getInstance();
					cal.setTime(new Date());
					cal.add(Calendar.DATE, 1000);
					String newDate = dateFormat.format(cal.getTime());
					isElementPresent("IMValidTo_xpath").sendKeys(newDate);
					System.out.println("Selected Date,1000 days priorior from current Date");
					logs.info("Selected Date,1000 days priorior from current Date");

					// Submit
					WebElement Submit = isElementPresent("Submit_xpath");
					js.executeScript("arguments[0].click();", Submit);
					System.out.println("Clicked on Submit button");
					logs.info("Clicked on Submit button");
					Thread.sleep(1000);
					getScreenshot("IMActivate_", "IntegratorMaster", driver);

					// Back
					wait.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//*[@class=\"bottom-action-bar-section\"]/dx-button")));
					Back = isElementPresent("Back_xpath");
					js.executeScript("arguments[0].click();", Back);
					System.out.println("Clicked on Back button");
					logs.info("Clicked on Back button");
					wait.until(ExpectedConditions
							.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-label=\"Data grid\"]")));
					wait.until(ExpectedConditions
							.invisibilityOfElementLocated(By.xpath("//*[@class=\"dx-loadpanel-content-wrapper\"]")));
					waitForPageLoad();

				}

				// More-Edit
				isElementPresent("More_xpath").click();
				System.out.println("Clicked on More  button");
				logs.info("Clicked on More  button");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//*[@class=\"popup-inner-box dx-template-wrapper\"]")));
				getScreenshot("IntMMore_", "IntegratorMaster", driver);

				// Edit
				WebElement Edit = isElementPresent("Edit_xpath");
				js.executeScript("arguments[0].click()", Edit);
				System.out.println("Clicked on Edit button");
				logs.info("Clicked on Edit button");
				getScreenshot("IntMMoreEdit_", "IntegratorMaster", driver);

				waitForPageLoad();
				Back = isElementPresent("Back_xpath");
				js.executeScript("arguments[0].click();", Back);
				System.out.println("Clicked on Back button");
				logs.info("Clicked on Back button");
				waitForPageLoad();

				// More-Close
				isElementPresent("More_xpath").click();
				System.out.println("Clicked on More  button");
				logs.info("Clicked on More  button");
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
						By.xpath("//*[@class=\"popup-inner-box dx-template-wrapper\"]")));

				// Close
				WebElement Close = isElementPresent("Close_xpath");
				js.executeScript("arguments[0].click();", Close);
				System.out.println("Clicked on Closed button");
				logs.info("Clicked on Closed button");
				getScreenshot("IntMMoreClose_", "IntegratorMaster", driver);

				// PageSize
				pageSize("IntegratorMaster");

				// Pagination
				pagination("IntegratorMaster");

				// Normalview
				normalView("IntegratorMaster");

				// Columns
				columns("IntegratorMaster");

				break;
			} else {
				System.out.println("Integrator Master is not exist");
				logs.info("Integrator Master is not exist");
			}
		}

	}

}
