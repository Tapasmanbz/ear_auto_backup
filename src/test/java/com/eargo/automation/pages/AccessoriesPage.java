package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessoriesPage extends BasePage {

	CartPage cartPage = new CartPage();

	public AccessoriesPage() {
		PageFactory.initElements(driver, this);
		// waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//h2[text()='Flexis']")
	public WebElement sectionFlexis;

	@FindBy(how = How.XPATH, using = "//div[@id='root']/div[2]/div[2]/div[3]/div[2]/div[1]/button[1]")
	public WebElement btnAddToCartWax;

	// -------- Radio buttons ---------------

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi TetraPalms']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[1]")
	public WebElement btnRegularTetraPalms;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi TetraPalms']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[2]")
	public WebElement btnLargeTetraPalms;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi TetraPalms']/following-sibling::div/div[2]/div[@class='add_to_cart_button_container']/button")
	public WebElement btnAddToCartTetraPalms;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Palms']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[1]")
	public WebElement btnRegularPalms;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Palms']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[2]")
	public WebElement btnLargePalms;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Palms']/following-sibling::div/div[2]/div[@class='add_to_cart_button_container']/button")
	public WebElement btnAddToCartPalms;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Fibers']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[1]")
	public WebElement btnRegularFibers;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Fibers']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[2]")
	public WebElement btnLargeFibers;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Fibers']/following-sibling::div/div[2]/div[@class='add_to_cart_button_container']/button")
	public WebElement btnAddToCartFibers;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Domes']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[1]")
	public WebElement btnRegularDomes;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Domes']/following-sibling::div/div[2]/div[@class='flexis-buttons_container']/button[2]")
	public WebElement btnLargeDomes;

	@FindBy(how = How.XPATH, using = "//span[text()='Flexi Domes']/following-sibling::div/div[2]/div[@class='add_to_cart_button_container']/button")
	public WebElement btnAddToCartDomes;

	public CartPage click_add_Flexi_to_cart(String accessories, String size) throws InterruptedException {

		CartPage cartPage = new CartPage();
		scrollToElement(sectionFlexis);

		switch (accessories.toUpperCase()) {

		case "FLEXI TETRAPALMS":
			click_add_FlexiTetraPalms_to_cart(size);
			break;

		case "FLEXI PALMS":
			if (cartPage.isCartOpen()) {
				cartPage.closeCart();
			}
			click_add_FlexiPalms_to_cart(size);
			break;

		case "FLEXI FIBERS":
			// if (cartPage.isCartOpen()) {
			// cartPage.closeCart();
			// }
			click_add_FlexiFibers_to_cart(size);
			break;

		case "FLEXI DOMES":
			if (cartPage.isCartOpen()) {
				cartPage.closeCart();
			}
			click_add_FlexiDomes_to_cart(size);
			break;

		case "WAX":
		default:
			if (cartPage.isCartOpen()) {
				cartPage.closeCart();
			}
			click_add_Wax_to_cart();
			break;
		}

		return cartPage;
	}

	public void click_add_FlexiTetraPalms_to_cart(String size) throws InterruptedException {

		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeTetraPalms)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularTetraPalms)).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartTetraPalms)).click();
	}

	public void click_add_FlexiPalms_to_cart(String size) throws InterruptedException {

		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargePalms)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularPalms)).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartPalms)).click();
	}

	public void click_add_FlexiFibers_to_cart(String size) throws InterruptedException {

		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeFibers)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularFibers)).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartFibers)).click();
	}

	public void click_add_FlexiDomes_to_cart(String size) throws InterruptedException {

		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeDomes)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularDomes)).click();
		}

		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartDomes)).click();

	}

	private void click_add_Wax_to_cart() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartWax)).click();
		Thread.sleep(500);
	}

}
