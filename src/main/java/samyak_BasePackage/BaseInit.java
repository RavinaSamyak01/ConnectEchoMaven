package samyak_BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseInit {

	public static Properties storage = null;
	public static WebDriver driver;
	public static Logger logs;
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeSuite
	public void startUp() throws Exception {
		startTest();
		if (driver == null) {
			// Initialize Logs
			logs = Logger.getLogger("devpinoyLogger");
			logs.info("initialization of the log is done");

			// Initialization and Load Properties File
			logs.info("initialization of the properties file");

			storage = new Properties();
			FileInputStream fi = new FileInputStream(
					".\\src\\main\\resources\\samyak_PropertiesData\\ObjectStorage.properties");
			storage.load(fi);
			logs.info("initialization of the properties file is done");

			// Launch the browser
			logs.info("Launching the browser");
			String browserkey = storage.getProperty("browser");
			if (browserkey.equalsIgnoreCase("firefox")) {
				/*
				 * System.setProperty("webdriver.gecko.driver",
				 * ".\\src\\main\\resources\\geckodriver.exe"); driver = new FirefoxDriver();
				 */
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logs.info("Firefox Browser is launched");

			}
			if (browserkey.equalsIgnoreCase("firefox Headless")) {
				/*
				 * System.setProperty("webdriver.gecko.driver",
				 * ".\\src\\main\\resources\\geckodriver.exe"); driver = new FirefoxDriver();
				 */
				FirefoxOptions options = new FirefoxOptions();
				options.setHeadless(true);

				// pass the options parameter in the Firefox driver declaration
				driver = new FirefoxDriver(options);
				logs.info("Firefox Browser is launched");

			}
			if (browserkey.equalsIgnoreCase("chrome headless")) {
				/*
				 * System.setProperty("webdriver.gecko.driver",
				 * ".\\src\\main\\resources\\geckodriver.exe"); driver = new FirefoxDriver();
				 */
				DesiredCapabilities capabilities = new DesiredCapabilities();
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("--incognito");
				options.addArguments("--test-type");
				options.addArguments("--no-proxy-server");
				options.addArguments("--proxy-bypass-list=*");
				options.addArguments("--disable-extensions");
				options.addArguments("--no-sandbox");
				options.addArguments("--headless");
				options.addArguments("window-size=1366x768");
				capabilities.setPlatform(Platform.ANY);
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);

			} else if (browserkey.equalsIgnoreCase("chrome")) {
				/*
				 * ChromeOptions chromeOptions = new ChromeOptions(); chromeOptions.
				 * setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
				 * System.setProperty("webdriver.chrome.driver",
				 * ".\\src\\main\\resources\\chromedriver.exe"); driver = new
				 * ChromeDriver(chromeOptions);
				 */
				WebDriverManager.chromedriver().setup();
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("--incognito");
				options1.addArguments("--test-type");
				options1.addArguments("--disable-extensions");
				options1.addArguments("window-size=1920,1080");
				driver = new ChromeDriver(options1);
				logs.info("Chrome Browser is launched");
				System.out.println("Chrome Browser is launched");
			} else {
				System.out.println("Browser is not defined");
				logs.info("Browser is not defined");
				System.out.println("Browser is not defined");
			}
			// Maximize the browser
			/*
			 * driver.manage().window().maximize(); // logs.info("windows is maximized");
			 * 
			 * System.out.println(driver.manage().window().getSize());
			 * logs.info(driver.manage().window().getSize()); // Create object of Dimensions
			 * class
			 * 
			 * Dimension d = new Dimension(1366,728); // Resize the current window to the
			 * given dimension driver.manage().window().setSize(d);
			 * System.out.println("Resize the browser window");
			 * logs.info("Resize the browser window");
			 */
			// define timeout
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logs.info("timeout is defined");

			// delete the cookies
			driver.manage().deleteAllCookies();
			logs.info("Cookies are deleted");

			// Object of the ExcelFileReader Class
			/*
			 * data = new ExcelFileReader();
			 * logs.info("initialization of the excelfilereader Class is done");
			 */
		}

	}

	@BeforeTest
	public void login() throws InterruptedException {
		driver.get("http://10.227.8.4:9082/auth/login");
		waitForPageLoad();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@formcontrolname=\"email\"]")));
		highLight(isElementPresent("Email_xpath"), driver);
		isElementPresent("Email_xpath").sendKeys("Superadmin");
		highLight(isElementPresent("Next_xpath"), driver);
		isElementPresent("Next_xpath").click();
		highLight(isElementPresent("Password_xpath"), driver);
		isElementPresent("Password_xpath").sendKeys("Welcome@1234");
		highLight(isElementPresent("subbmit_xpath"), driver);
		isElementPresent("subbmit_xpath").click();
		logs.info("Login done");
		waitForPageLoad();

	}

	@AfterTest
	public void logOut() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"client-img\"]")));
		highLight(isElementPresent("logOut_xpath"), driver);
		isElementPresent("logOut_xpath").click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//dx-button[@aria-label=\"Logout\"]")));
		highLight(isElementPresent("logOutbtn_xpath"), driver);
		isElementPresent("logOutbtn_xpath").click();
		Thread.sleep(2000);

	}

	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);

		// try {
		driver.close();

		System.out.println("Browser closed");
		logs.info("Browser closed");

		report.flush();

		// catch won't be executed
		/*
		 * catch (NullPointerException e) { System.out.println(e); }
		 */
		// executed regardless of exception occurred or not
		/*
		 * finally { driver.close();
		 * 
		 * System.out.println("Browser closed"); logs.info("Browser closed");
		 * 
		 * report.flush(); }
		 */
	}

	@BeforeMethod
	public void testMethodName(Method method) {

		String testName = method.getName();
		test = report.startTest(testName);

	}

	public static void startTest() {
		report = new ExtentReports("./ExtentReport/ExtentReportResults.html", true);
		// test = report.startTest();
	}

	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	public static String getFailScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is " +
			// result.getThrowable().getMessage());
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this mehtod in to the extent reports using
			// "logger.addScreenCapture" method.
			String screenshotPath = BaseInit.getFailScreenshot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Case Pass is " + result.getName());

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
	}

	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	public WebElement isElementPresent(String propkey) {

		try {

			if (propkey.contains("xpath")) {

				return driver.findElement(By.xpath(storage.getProperty(propkey)));

			} else if (propkey.contains("id")) {

				return driver.findElement(By.id(storage.getProperty(propkey)));

			} else if (propkey.contains("name")) {

				return driver.findElement(By.name(storage.getProperty(propkey)));

			} else if (propkey.contains("linkText")) {

				return driver.findElement(By.linkText(storage.getProperty(propkey)));

			} else if (propkey.contains("className")) {

				return driver.findElement(By.className(storage.getProperty(propkey)));

			}
			if (propkey.contains("cssSelector")) {

				return driver.findElement(By.cssSelector(storage.getProperty(propkey)));
			}

			else {

				System.out.println("propkey is not defined");

				logs.info("prop key is not defined");
			}

		} catch (Exception e) {

		}
		return null;

	}

	public static void highLight(WebElement element, WebDriver driver) {
		// for (int i = 0; i < 2; i++) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: black; border: 4px solid red;");
			Thread.sleep(500);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// }

	}

	public void wait(String parameter) {
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(parameter)));
	}

	public void action(WebElement parameter) {
		Actions act = new Actions(driver);
		act.moveToElement(parameter).click().perform();
	}

	public void javaScrExec(WebElement parameter) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", parameter);
	}

	public void pageSize(String FName) throws InterruptedException, IOException {
		// Page size click events
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);

		System.out.println("--------------Testing PageSize---------------");

		// Airport grid data count
		WebElement ApdivID = isElementPresent("APgridcontainer_id");
		List<WebElement> ApDataCount = ApdivID
				.findElements(By.xpath("//*[@id=\"gridContainer\"]/div/div[6]/div/table/tbody/tr[@aria-rowindex]"));

		ApDataCount.size();
		System.out.println("no.of rows are==" + ApDataCount.size());
		int Rcount = ApDataCount.size();
		System.out.println("row count is==" + Rcount);
		logs.info("row count is==" + Rcount);

		if (Rcount == 10) {
			System.out.println("row count is selected as 10");
			logs.info("row count is selected as 10");
		} else if (Rcount == 20) {
			System.out.println("row count is selected as 20");
			logs.info("row count is selected as 20");
		} else if (Rcount == 30) {
			System.out.println("row count is selected as 30");
			logs.info("row count is selected as 30");
		} else if (Rcount == 40) {
			System.out.println("row count is selected as 40");
			logs.info("row count is selected as 40");
		} else if (Rcount == 50) {
			System.out.println("row count is selected as 50");
			logs.info("row count is selected as 50");
		} else {
			System.out.println("there is no data");
			logs.info("there is no data");

		}
		WebElement pagerdiv = isElementPresent("pagerDiv_xpath");
		try {
			WebElement pagesize10 = isElementPresent("APPagesize10_xpath");
			System.out.println("page size for pagesize10 is==" + pagesize10.getText());
			logs.info("page size for pagesize10 is==" + pagesize10.getText());
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
			System.out.println("scroll down");
			highLight(pagesize10, driver);
			act.moveToElement(pagesize10).click().perform();
			System.out.println("clicked on pagesize 10");
			logs.info("clicked on pagesize 10");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("PageSize 10 is not exist");
			logs.info("PageSize 10 is not exist");
		}
		try {
			WebElement pagesize20 = isElementPresent("APPagesize20_xpath");
			System.out.println("page size for pagesize20 is==" + pagesize20.getText());
			logs.info("page size for pagesize20 is==" + pagesize20.getText());
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
			System.out.println("scroll down");
			getScreenshot("PageSize10_", FName, driver);
			highLight(pagesize20, driver);
			act.moveToElement(pagesize20).click().perform();
			System.out.println("clicked on pagesize 20");
			logs.info("clicked on pagesize 20");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("PageSize 20 is not exist");
			logs.info("PageSize 20 is not exist");
		}
		try {
			WebElement pagesize30 = isElementPresent("APPagesize30_xpath");
			System.out.println("page size for pagesize30 is==" + pagesize30.getText());
			logs.info("page size for pagesize30 is==" + pagesize30.getText());
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
			System.out.println("scroll down");
			getScreenshot("PageSize20_", FName, driver);
			highLight(pagesize30, driver);
			act.moveToElement(pagesize30).click().perform();
			System.out.println("clicked on pagesize 30");
			logs.info("clicked on pagesize 30");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("PageSize 30 is not exist");
			logs.info("PageSize 30 is not exist");
		}
		try {
			WebElement pagesize40 = isElementPresent("APPagesize40_xpath");
			System.out.println("page size for pagesize40 is==" + pagesize40.getText());
			logs.info("page size for pagesize40 is==" + pagesize40.getText());
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
			System.out.println("scroll down");
			getScreenshot("PageSize30_", FName, driver);
			WebElement pagesize40n = isElementPresent("APPagesize40_xpath");
			highLight(pagesize40n, driver);
			act.moveToElement(pagesize40n).click().perform();
			System.out.println("clicked on pagesize 40");
			logs.info("clicked on pagesize 40");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("PageSize 40 is not exist");
			logs.info("PageSize 40 is not exist");
		}
		try {
			WebElement pagesize50 = isElementPresent("APPagesize50_xpath");
			System.out.println("page size for pagesize50 is==" + pagesize50.getText());
			logs.info("page size for pagesize50 is==" + pagesize50.getText());
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
			System.out.println("scroll down");
			getScreenshot("PageSize40_", FName, driver);
			WebElement pagesize50n = isElementPresent("APPagesize50_xpath");
			highLight(pagesize50n, driver);
			act.moveToElement(pagesize50n).click().perform();
			System.out.println("clicked on pagesize 50");
			logs.info("clicked on pagesize 50");
			Thread.sleep(2000);
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
			Thread.sleep(1000);
			getScreenshot("PageSize50_", FName, driver);
		} catch (Exception e) {
			System.out.println("PageSize 50 is not exist");
			logs.info("PageSize 50 is not exist");
		}

	}

	public void pagination(String FName) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act = new Actions(driver);
		// Pagination
		System.out.println("-----Testing Pagination--------");
		logs.info("------Testing Pagination-----");

		List<WebElement> pagination = driver.findElements(
				By.xpath("//*[@id=\"gridContainer\"]/div/div[11]/div[2]/div[contains(@aria-label,'Page')]"));
		System.out.println("size of pagination is==" + pagination.size());
		logs.info("size of pagination is==" + pagination.size());

		if (pagination.size() > 0) {
			WebElement pageinfo = isElementPresent("ApgridpageInfo_xpath");
			System.out.println("page info is==" + pageinfo.getText());
			WebElement pagerdiv = isElementPresent("pagerDiv_xpath");
			WebElement secndpage = isElementPresent("Page2_xpath");
			WebElement prevpage = isElementPresent("PrevPage_xpath");
			WebElement nextpage = isElementPresent("NextPage_xpath");

			// Scroll
			js.executeScript("arguments[0].scrollIntoView();", pagerdiv);

			if (pagination.size() > 1) {
				// click on page 2
				js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
				secndpage = isElementPresent("Page2_xpath");
				highLight(secndpage, driver);
				act.moveToElement(secndpage).click().perform();
				System.out.println("Clicked on page 2");
				logs.info("Clicked on page 2");
				Thread.sleep(2000);

				// click on previous button
				prevpage = isElementPresent("PrevPage_xpath");
				js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
				getScreenshot("Page2_", FName, driver);
				prevpage = isElementPresent("PrevPage_xpath");
				highLight(prevpage, driver);
				act.moveToElement(prevpage).click().perform();
				System.out.println("clicked on previous page");
				logs.info("Clicked on Previous page");
				Thread.sleep(2000);

				// click on next button
				nextpage = isElementPresent("NextPage_xpath");
				js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
				getScreenshot("Page1(Previous)_", FName, driver);
				nextpage = isElementPresent("NextPage_xpath");
				highLight(nextpage, driver);
				act.moveToElement(nextpage).click().perform();
				System.out.println("clicked on next page");
				logs.info("Clicked on Nextpage");
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView();", pagerdiv);
				getScreenshot("Page2(Next)_", FName, driver);

			} else {
				System.out.println("Only 1 page is exist");
			}

		} else {
			System.out.println("pagination is not exist");
		}
	}

	public void normalView(String FName) throws InterruptedException, IOException {
		System.out.println("-----Testing Normal View-------");
		logs.info("------Testing Normal View-------");
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// click on normal view
		WebElement Normal = isElementPresent("VCorNormal_xpath");
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		highLight(Normal, driver);
		act.moveToElement(Normal).click().perform();

		System.out.println("clicked on Normal view");
		logs.info("clicked on Normal view");
		Thread.sleep(2000);
		getScreenshot("ViewDropdown_", FName, driver);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"dx-scrollview-content\"]")));
		// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class=\"dx-scrollview-content\"]")));

		WebElement listdiv = isElementPresent("NormalView_xpath");
		System.out.println("Items in list are==" + listdiv);
		List<WebElement> viewlist = listdiv.findElements(By.tagName("div"));
		System.out.println("size of Views list are==" + viewlist.size());

		for (int count = 0; count < viewlist.size(); count++) {
			String viewname = viewlist.get(count).getText();
			System.out.println("Name of the view is==" + viewname);

			if (viewname.equalsIgnoreCase("Compact")) {
				highLight(viewlist.get(count), driver);
				viewlist.get(count).click();
				System.out.println("clicked on=" + viewlist.get(count).getText() + "view");
				logs.info("clicked on=" + viewlist.get(count).getText() + "view");
				Thread.sleep(2000);
				getScreenshot("CompactView_", FName, driver);

				Normal = isElementPresent("VCorNormal_xpath");
				highLight(Normal, driver);
				Normal.click();
				System.out.println("clicked on Normal view");
				logs.info("clicked on Normal view");
			} else if (viewname.equalsIgnoreCase("Normal")) {
				highLight(viewlist.get(count), driver);
				viewlist.get(count).click();
				System.out.println("clicked on=" + viewlist.get(count).getText() + "view");
				Thread.sleep(2000);
				getScreenshot("NormalView_", FName, driver);

				Normal = isElementPresent("VCorNormal_xpath");
				highLight(Normal, driver);
				Normal.click();
				System.out.println("clicked on Normal view");
				logs.info("clicked on Normal view");

			} else if (viewname.equalsIgnoreCase("Tall")) {
				highLight(viewlist.get(count), driver);
				viewlist.get(count).click();
				System.out.println("clicked on=" + viewlist.get(count).getText() + "view");
				logs.info("clicked on=" + viewlist.get(count).getText() + "view");
				Thread.sleep(2000);
				getScreenshot("TallView_", FName, driver);

			} else {
				System.out.println("views are not available");
				logs.info("views are not available");
			}

		}
	}

	public void columns(String FName) throws IOException {
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		System.out.println("-------Testing Columns-------");
		logs.info("------Testing Columns------");
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		WebElement col = isElementPresent("VCorCol_xpath");
		highLight(col, driver);
		act.moveToElement(col).click().perform();
		System.out.println("clicked on columns");
		getScreenshot("Columns", FName, driver);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]")));

		WebElement coltable = isElementPresent("ApColtableTR_xpath");
		System.out.println("stored columns table");

		List<WebElement> columns = coltable.findElements(By.tagName("td"));
		System.out.println("stored all the td of columnns");
		int ActualCol = columns.size();
		System.out.println("Default columns value is==" + ActualCol);
		logs.info("Default columns value is==" + ActualCol);

		WebElement listdiv = isElementPresent("apcolmain_xpath");
		System.out.println("Items in list are==" + listdiv);
		List<WebElement> collist = listdiv.findElements(By.tagName("li"));
		System.out.println("size of columns list are==" + collist.size());
		logs.info("size of columns list are==" + collist.size());

		for (int count = 0; count < collist.size() - 3; count++) {

			String itemvalue = collist.get(count).getAttribute("aria-selected");
			System.out.println("item is selected==" + itemvalue);
			logs.info("item is selected==" + itemvalue);
			WebElement It = collist.get(count);
			highLight(It, driver);
			act.moveToElement(It).click().perform();
			System.out.println("Clicked on Col");
			logs.info("Clicked on Col");
			getScreenshot("RemovedColumn_", FName, driver);

			coltable = isElementPresent("ApColtableTR_xpath");
			columns = coltable.findElements(By.tagName("td"));

			int ChangeCol = columns.size();
			System.out.println("After removed column, columns value is==" + ChangeCol);
			logs.info("After removed column, columns value is==" + ChangeCol);

			if (ActualCol != ChangeCol) {
				System.out.println("Pass=column is removed");
				logs.info("Pass=column is removed");
			} else {
				System.out.println("Fail=column is not removed");
				logs.info("Fail=column is not removed");
			}

		}

	}

	/*
	 * public String getScreenshot(String screenshotName, String MName, WebDriver
	 * driver) throws IOException {
	 * 
	 * String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 * TakesScreenshot ts = (TakesScreenshot) driver; File scrFile =
	 * ts.getScreenshotAs(OutputType.FILE); String destination =
	 * System.getProperty("user.dir") + "./src/main/resources/screenshots/" +
	 * screenshotName + dateName + ".png"; if (MName.equals("Airport")) {
	 * destination = System.getProperty("user.dir") +
	 * "./src/main/resources/screenshots/Airport/" + screenshotName + dateName +
	 * ".png"; File finalDestination = new File(destination);
	 * FileUtils.copyFile(scrFile, finalDestination); return destination; } else if
	 * (MName.equals("AirportGroup")) { destination = System.getProperty("user.dir")
	 * + "./src/main/resources/screenshots/AirportGroup/" + screenshotName +
	 * dateName + ".png"; File finalDestination = new File(destination);
	 * FileUtils.copyFile(scrFile, finalDestination); return destination; } else {
	 * System.out.println("Module name is not getting"); return destination; } }
	 */

	public void getScreenshot(String imagename, String MName, WebDriver driver) throws IOException {

		try {

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

			File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

			String logFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());

			if (MName.equals("Airport")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Airport/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("AirportGroup")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/AirportGroup/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendCourier")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Courier/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Carrier")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Carrier/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Services")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Services/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Vendor")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Vendor/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CourierOperationHour")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CourOperationHour/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CourierDriver")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CourDriver/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CourierNotes")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CourierNotes/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CourierServiceAreas")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CourierServiceAreas/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Account")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CarrAccounts/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));
			} else if (MName.equals("Notes")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CarrNotes/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Notice")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CarrNotices/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Location")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CarrLocation/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("IntegratorMaster")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/IntegratorMaster/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("IntMServiceZone")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/IMServiceZone/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("IntMIntegratorService")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/IMIntegratorService/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendorTypeSubType")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VendorTypeSubType/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendorAddress")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VendorAddress/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendorDocument")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VendorDocument/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendServiceAreaType")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VendServiceAreaType/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendorVehicleType")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VendorVehicleType/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VendorPerformance")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VendorPerformance/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VTransportationServices")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VTransporatationServices/"
						+ imagename + logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VTranspServLevel")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VTranspServLevel/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VFacilityAttributes")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VFacilityAttributes/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VAlert")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VAlert/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("VCompliance")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/VCompliance/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CategoryMaster")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CategoryMaster/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Commodity")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Commodity/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("QualityCodes")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/QualityCodes/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Country")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Country/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("Zip/PostalCode")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/ZipPostalCode/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CustomAPZipCode")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/CustomAPZipCode/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("BagType")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/BagType/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("AutoDispatchSetUp")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/AutoDispatchSetUp/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("DocumentType")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/DocumentType/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CountryState")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Geography/CountryState/"
						+ imagename + logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CountryCity")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Geography/CountryCity/"
						+ imagename + logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("LMZoneSetUp")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Rate/LMZoneSetUp/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CostTemplate")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Rate/CostTemplate/" + imagename
						+ logFileName + System.currentTimeMillis() + ".png"));

			} else if (MName.equals("CTAddCostType")) {
				FileUtils.copyFile(scrFile, new File("./src/main/resources/screenshots/Rate/CostTemplate/CTAddCostType/"
						+ imagename + logFileName + System.currentTimeMillis() + ".png"));

			}

			System.out.println(
					"Printing screen shot taken for className " + imagename + logFileName + System.currentTimeMillis());
			logs.info(
					"Printing screen shot taken for className " + imagename + logFileName + System.currentTimeMillis());

		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
			logs.info("Exception while taking screenshot " + e.getMessage());
		}

		/*
		 * try { Screenshot screenshot = new
		 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
		 * .takeScreenshot(driver); if (MName.equals("Airport")) {
		 * ImageIO.write(screenshot.getImage(), "PNG" + System.currentTimeMillis(), new
		 * File("./src/main/resources/screenshots/Airport/")); } else if
		 * (MName.equals("AirportGroup")) { ImageIO.write(screenshot.getImage(), "PNG" +
		 * System.currentTimeMillis(), new
		 * File("./src/main/resources/screenshots/AirportGroup/")); }
		 * 
		 * System.out.println("Printing screen shot taken for className " + imagename +
		 * System.currentTimeMillis()); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 * }
		 */

		/*
		 * @DataProvider public Object[][] gettestData() { return
		 * MyLibrary.getTestData(data, "Contact"); }
		 */

	}
}
