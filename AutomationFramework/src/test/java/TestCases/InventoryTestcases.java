package TestCases;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Baselibraries.STAF_Web_Helper;

public class InventoryTestcases extends STAF_Web_Helper {
	Logger log = Logger.getLogger(this.getClass().getSimpleName());

	// ===========>INVENTORY TESTCASES<====================

	// ===============>Validating the BackPack item<===========================

	@Test(priority = 1)
	public void validateBackPack() {
//		test = extent.createTest("Validate SwaglabsBackpack functionality").assignAuthor("Lakshmi")
//				.assignCategory("Functionality testing");
		log.info("Inventory Test started");
		inventory.backPack();
		log.info("click on backpack item");
		waitTime();
		inventory.clickOnbackPackCart();
		waitTime();
		Reporter.log("Backpack");
		inventory.gobackProducts();
		log.info("goback to the products page");
		waitTime();
//		test.log(Status.PASS, "Successfully moves to the prodcuts page");
	}

	// =====================>Validating the T-Shirt item<==========================
	@Test(priority = 2)
	public void shirt() {
//		test = extent.createTest("Validate T-Shirt functionality").assignAuthor("Lakshmi")
//				.assignCategory("Functionality testing");
		inventory.tShirt();
		log.info("click on T-Shirt item");
		waitTime();
		inventory.tShirtCart();
		waitTime();
//		test.log(Status.PASS, "T-Shirt added successfully to the cart");
	}

	// =============>Validating the cart items<================
	@Test(priority = 3)
	public void cartItem() {
//		test = extent.createTest("Validation of CartItems").assignAuthor("Lakshmi")
//				.assignCategory("Functionality testing");
		inventory.clickOnCartIcon();
		waitTime();
		log.info("Click on Cart Icon");
		inventory.clickOnCheckout();
		waitTime();
		inventory.checkOutDeatils();
		waitTime();
		log.info("Click on checkout");
		inventory.continueButton();
		inventory.finshOrder();
		waitTime();
		log.info("Click on finish order");
//		test.log(Status.PASS, "Ordered Successfully");
		log.info("Inventory Test closed");

	}

}
