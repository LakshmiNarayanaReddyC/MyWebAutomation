package Baselibraries;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import ModulePages.LoginScreen_Locators;
import ModulePages.InventoryScreen_Locators;
import ModulePages.LogoutScreen_Locators;

public class STAF_Web_Helper {

	public Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;

	public static com.aventstack.extentreports.ExtentReports extent;
	public static com.aventstack.extentreports.ExtentTest test;
	public static ExtentSparkReporter sparkReporter;
	protected static ModulePages.LoginScreen_Locators loginPage;
	protected static ModulePages.InventoryScreen_Locators inventory;
	protected static ModulePages.LogoutScreen_Locators logoutPage;

	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getSimpleName());

	public STAF_Web_Helper() {
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(
					"C:\\Users\\lchitla\\eclipse-workspace\\AutomationFramework\\src\\main\\resources\\Configurations\\config.properties");
			prop.load(fip);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	// -----USE TESTNG ANNOTATIONS------------
	@BeforeTest
	@Parameters({ "BrowserName" })
	public void launchBrowser(String BrowserName) {
//		extent = new ExtentReports();
//		sparkReporter = new ExtentSparkReporter("./ExtentReports/WebAutomation.html");
//		extent.attachReporter(sparkReporter);
		switch (BrowserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			log.info("ChromeBrowser Launched");
			break;
		case "Edge":
			driver = WebDriverManager.edgedriver().create();
			driver.manage().window().maximize();
			log.info("EdgeBrowser Launched");
			break;
		case "Firefox":
			driver = WebDriverManager.firefoxdriver().create();
			driver.manage().window().maximize();
			log.info("FirefoxBrowser Launched");
			break;
		default:
			break;
		}

	}

	// ====== INITLIZING THE PAGE CLASSES====//
	@BeforeClass
	public void init() {
		loginPage = new LoginScreen_Locators(driver);
		inventory = new InventoryScreen_Locators(driver);
		logoutPage = new LogoutScreen_Locators(driver);

	}

	@AfterTest
	public void closeBroeswer() {
		log.info("Closing the tabs");
//		extent.flush();
		driver.quit();
	}
	// =============>METHOD FOR SUSPEND FOR SOMETIME<=====================

	public void waitTime() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//		Wait for the element to be visible ignoring the StaleElementReferenceException

	public void waitForElementVisible(WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			Reporter.log(e.toString());
			log.info(e.toString());
			Assert.fail();
		}
	}
//	   Wait for the element to be clickable ignoring the StaleElementReferenceException

	public void waitForElementClickable(WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception e) {
			Reporter.log(e.toString());
			log.info(e.toString());
			Assert.fail();
		}
	}

	public boolean isElementVisisble(WebElement webElement) {
		return webElement.isDisplayed();
	}

	public void selectItemByText(WebElement webElement, String itemName) {
		try {
			Select select = new Select(webElement);
			select.selectByVisibleText(itemName);
		} catch (Exception e) {
			Reporter.log(e.toString());
			log.info(e.toString());
			Assert.fail();
		}
	}

	public void selectItemByIndex(WebElement webElement, int itemIndex) {
		try {
			Select select = new Select(webElement);
			select.selectByIndex(itemIndex);
		} catch (Exception e) {
			Reporter.log(e.toString());
			log.info(e.toString());
			Assert.fail();
		}
	}

	public void selectItemByValue(WebElement webElement, String itemValue) {
		try {
			Select select = new Select(webElement);
			select.selectByValue(itemValue);
		} catch (Exception e) {
			Reporter.log(e.toString());
			log.info(e.toString());
			Assert.fail();
		}
	}

	public void Sleep(long milli) {
		try {
			Thread.sleep(milli);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
