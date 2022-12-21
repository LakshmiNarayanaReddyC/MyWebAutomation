package ModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Baselibraries.STAF_Web_Helper;

public class LoginScreen_Locators extends STAF_Web_Helper {

	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getSimpleName());

	WebDriver driver;
	// -----------LOCATERS FOR THE LOGIN OF SWAG-LABS---------
	// ------FOR USERNAME TEXTBOX------
	By username = By.id("user-name");
	// ------FOR PASSWORD TEXTBOX--------
	By password = By.id("password");
	// ------FOR LOGIN BUTTON---------
	By login = By.id("login-button");
	// -----------FOR ERROR MESSAGE--------
	By error = By.cssSelector("[data-test='error']");

	// INIT THE CONSTRCTOR
	public LoginScreen_Locators(WebDriver driver) {
		this.driver = driver;
	}

	// ---CREATING METHODS FOR THE WEBELEMENTS-----------

	// ---------VALID USERNAME-----------
	public void userName() {
		driver.findElement(username).clear();
		String uname = prop.getProperty("Username");
		driver.findElement(username).sendKeys(uname);
		log.info("Username Textbox");
	}

	// ---------INVALID USERNAME--------------
	public void invalidUsername() {
		driver.findElement(username).clear();
		String invaliduname = prop.getProperty("InvalidUsername");
		driver.findElement(username).sendKeys(invaliduname);
		log.info("Entering the invalid username");
	}

	// ---------VALID PASSWORD------------
	public void passWord() {
		driver.findElement(password).clear();
		String pwd = prop.getProperty("Password");
		driver.findElement(password).sendKeys(pwd);
		log.info("Password textbox");
	}

	// --------------INVALID PASSWORD--------------
	public void invalidPassword() {
		driver.findElement(password).clear();
		String Invalidpwd = prop.getProperty("InvalidPassword");
		driver.findElement(password).sendKeys(Invalidpwd);
		log.info("Entering the invalid password");

	}

	// -------METHOD FOR LOGIN BUTTON----------
	public void loginButton() {
		driver.findElement(login).click();
		log.info("click on login button");
	}

	// -----------METHOD FOR ERROR MESSAGE--------------
	public void errorMessage() {
		boolean errormessage = driver.findElement(error).isDisplayed();
		log.info("Error message should be displayed");
	}

	public String getErrorMessage() {
		String errormesssage = driver.findElement(error).getText();
		log.info(errormesssage);
		return errormesssage;
	}

}
