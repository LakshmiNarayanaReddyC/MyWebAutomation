package ModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryScreen_Locators {

	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getSimpleName());
	
	WebDriver driver;
	// ==========>LOCATERS FOR FINDING ELEMENTS<============
	// ----FOR BACKPACK BAG-------
	By bags = By.className("inventory_item_name");
	// ----FOR BACKPACK ADD TO CART------
	By backpackCart = By.id("add-to-cart-sauce-labs-backpack");
	// ----FOR GO BACK TO PRODUCTS-----
	By backToProducts = By.cssSelector("#back-to-products");
	// ----FOR CART ICON-------
	By cartIcon = By.cssSelector(".shopping_cart_link");
	// -----FOR T-SHIRT-----
	By tShirt = By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']");
	// ------FOR T-SHIRT ADD TO CART------
	By tShirtCart = By.xpath("//button[text()='Add to cart']");
	// ------FOR CHECKOUT THE ITEMS--------
	By checkOut = By.name("checkout");
	// -------FOR FIRST_NAME------
	By firstName = By.id("first-name");
	// -------FOR LAST_NAME-----
	By lastName = By.id("last-name");
	// ------FOR ZIP CODE-------------
	By zipCode = By.id("postal-code");
	// ------FOR CONTINUE-------
	By continueOrder = By.name("continue");
	// -------FOR FINISH THE ORDER------
	By finshOrder = By.cssSelector("#finish");

	// =========INIT THE CONSTRUCTOR==========
	public InventoryScreen_Locators(WebDriver driver) {
		this.driver = driver;
	}

	// ============>CREATING METHODS<============

	// =============>METHOD FOR BACKPACK PRODUCT<============
	public void backPack() {
		driver.findElement(bags).click();
		log.info("clicked on bags");
	}

	// ===========>METHOD FOR ADD TO CART(BACKPACK ITEM)<=============
	public void clickOnbackPackCart() {
		driver.findElement(backpackCart).click();
		log.info("Item add to cart");
	}

	// =======>METHOD FOR CREATING TO GO BACK TO PRODUCTS<============
	public void gobackProducts() {
		driver.findElement(backToProducts).click();
		log.info("Goback to the products page");
	}

	// ===========>METHOD FOR T-SHIRT<=============
	public void tShirt() {
		driver.findElement(tShirt).click();
		log.info("click on the T-Shirt");
	}

	// =============>METHOD FOR T-SHIRT ADD TO CART<==============
	public void tShirtCart() {
		driver.findElement(tShirtCart).click();
		log.info("click on the T-Shirt cart");
	}

	// ============>METHOD FOR CLICK ON THE CART ICON<============
	public void clickOnCartIcon() {
		driver.findElement(cartIcon).click();
		log.info("click on the cart icon");
	}

	// ========>METHOD FOR CHECKOUT<============
	public void clickOnCheckout() {
		driver.findElement(checkOut).click();
		log.info("Click on the checkout button");
	}

	// ==========>METHOD FOR ENTERING THE CHECKOUT DETAILS<============
	public void checkOutDeatils() {
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys("Swamy");
		log.info("Enter the firstname as Swamy");
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys("Chittidi");
		log.info("Enter the lastname is Chittidi");
		driver.findElement(zipCode).clear();
		driver.findElement(zipCode).sendKeys("534330");
		log.info("Enter the Zipcode as 534330");
	}

	// =========>METHOD FOR CONTINUE BUTTON<===============
	public void continueButton() {
		driver.findElement(continueOrder).click();
		log.info("click on continue button");
	}

	// ==========>METHOD FOR FINSH THE ORDER<===============
	public void finshOrder() {
		driver.findElement(finshOrder).click();
		log.info("Click on finshorder button");
	}

}
