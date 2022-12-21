package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Baselibraries.STAF_Web_Helper;

public class LoginTestcases extends STAF_Web_Helper {
	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getSimpleName());

	// ============>Launch the URL<==============
	@Test(priority = 1)
	public void launchURL() {
//		test = extent.createTest("Check the URL").assignAuthor("Lakshmi").assignCategory("Functionality testing");
		String url = prop.getProperty("baseurl");
		driver.get(url);
		log.info("URL Launched");
//		test.log(Status.PASS, "Naviagte to the url");
		Reporter.log(url);
	}
	// ==========>VALIDATING THE LOGIN<====================

	// ===============>Validating the Login with valid credtinals<==============

	@Test(priority = 4)
	public void validate_loginpage() {
//		test = extent.createTest("Validate Login Functionality with valid Credtinals").assignAuthor("Lakshmi")
//				.assignCategory("Functionality testing");
		log.info("Enter valid username");
		loginPage.userName();
		log.info("Enter valid password");
		loginPage.passWord();
		log.info("Click on login button");
		loginPage.loginButton();
//		test.log(Status.PASS, "Login successfully");
		Reporter.log("Login successfully");
	}

	// ============>Validating the Login with Invalid Credtinals<============
	@Test(priority = 2)
	public void validate_loginpageWithInvalidCredtianals() {
//		test = extent.createTest("validate the Login with invalid username and valid password").assignAuthor("Lakshmi")
//				.assignCategory("Functionality testing");
		log.info("Enter invalid username");
		loginPage.invalidUsername();
		waitTime();
		log.info("Enter valid password");
		loginPage.passWord();
		waitTime();
		log.info("Click on login button");
		loginPage.loginButton();
		loginPage.errorMessage();
		String msg = loginPage.getErrorMessage();
//		test.log(Status.INFO, msg);
//		test.log(Status.PASS, "Login failed due to incorrect details");
		Reporter.log(msg);
	}

	// ============>Validating the login with valid username and invalid
	// password<=========

	@Test(priority = 3)
	public void validate_loginWithValidEmailAndInvalidPassword() {
//		test = extent.createTest("Validate the login with valid username and invalid password").assignAuthor("Lakshmi")
//				.assignCategory("Functionality testing");
		log.info("Enter valid username");
		loginPage.userName();
		waitTime();
		log.info("Enter invalid password");
		loginPage.invalidPassword();
		waitTime();
		log.info("Click on login button");
		loginPage.loginButton();
		loginPage.errorMessage();
		String msg = loginPage.getErrorMessage();
//		test.log(Status.INFO, msg);
//		test.log(Status.PASS, "Login failed due to invalid credtainals");
		Reporter.log(msg);

	}

	// ============>URL validation for inverntory module<===============

	@Test(priority = 5)
	public void validate_url() {
//		test = extent.createTest("URL Validadtion").assignAuthor("Lakshmi").assignCategory("Functionality testing");
		String actualString = driver.getCurrentUrl();
		log.info(actualString);
		String expectedString = "https://www.saucedemo.com/inventory.html";
		log.info(expectedString);
		Assert.assertEquals(actualString, expectedString);
		log.info("Both are same so testclass passed");
//		test.log(Status.PASS, expectedString);

	}

}
