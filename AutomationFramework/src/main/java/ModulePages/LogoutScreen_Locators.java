package ModulePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutScreen_Locators {

	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getSimpleName());
	WebDriver driver;

	// ========>LOCATERS FOR ELEMENTS<=============

	// ========>Locater for Menu element<===============
	By MenuIcon = By.cssSelector("#react-burger-menu-btn");

	// ========>Locater for Logout<==========
	By logout = By.xpath("//a[text()='Logout']");

	// =============>INIT THE CONSTRUCTOR<=============
	public LogoutScreen_Locators(WebDriver driver) {
		this.driver = driver;
	}

	// ============>CREATE A METHOD FOR CLICK ON MENU ICON<========
	public void clickOnMenu() {
		driver.findElement(MenuIcon).click();
		log.info("Click on the MenuIcon");
	}

	// ============>CREATE A METHOD FOR CLICK ON LOGOUT ICON<===========
	public void clickOnLogout() {
		WebDriverWait t = new WebDriverWait(driver, Duration.ofSeconds(30));
		t.until(ExpectedConditions.elementToBeClickable(logout));
		driver.findElement(logout).click();
		log.info("Click on the Logout button");
	}

}
