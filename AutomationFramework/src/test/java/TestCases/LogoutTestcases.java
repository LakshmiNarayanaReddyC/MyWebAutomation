package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Baselibraries.STAF_Web_Helper;

public class LogoutTestcases extends STAF_Web_Helper {
	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getSimpleName());

	@Test
	// ========>Create a method for validating the Functions<===================
	public void validateLogout() {
//		test = extent.createTest("Validate the Logout Functionality").assignAuthor("Lakshmi").assignCategory("Functionality testing");
		log.info("Logout Testcase Started");
		logoutPage.clickOnMenu();
		waitTime();
		logoutPage.clickOnLogout();
		waitTime();
//		test.log(Status.PASS, "Logout Successfully");

	}

}
