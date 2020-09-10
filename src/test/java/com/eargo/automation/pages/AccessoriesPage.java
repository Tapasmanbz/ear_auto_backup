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

	@FindBy(how = How.XPATH, using = "//div[@id='root']/div[2]/div[2]/div[2]/div[3]/button[1]")
	public WebElement btnAddToCartFlexis;

	@FindBy(how = How.XPATH, using = "//div[@id='root']/div[2]/div[2]/div[3]/div[2]/div[1]/button[1]")
	public WebElement btnAddToCartWax;

	// -------- Radio buttons ---------------

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flexi TetraPalms')]/preceding-sibling::span/img[@class='check_image']")
	public WebElement radioBtnTetraPalms;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flexi Palms')]/preceding-sibling::span/img[@class='check_image']")
	public WebElement radioBtnFlexiPalms;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flexi Fibers')]/preceding-sibling::span/img[@class='check_image']")
	public WebElement radioBtnFlexiFibers;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flexi Domes')]/preceding-sibling::span/img[@class='check_image']")
	public WebElement radioBtnFlexiDomes;

	// ------Regular & Large ------------------

	@FindBy(how = How.XPATH, using = "//button[@type='button' and text()='Regular']")
	public WebElement btnRegularFlexiFibers;

	@FindBy(how = How.XPATH, using = "//button[@type='button' and text()='Large']")
	public WebElement btnLargeFlexiFibers;

	public CartPage click_add_Flexi_to_cart(String accessories, String size) throws InterruptedException {

		CartPage cartPage = new CartPage();
		scrollToElement(sectionFlexis);

		switch (accessories.toUpperCase()) {

		case "FLEXI TETRAPALMS":
			click_add_FlexiTetraPalms_to_cart(size);
			break;

		case "FLEXI PALMS":
			click_add_FlexiPalms_to_cart(size);
			break;

		case "FLEXI FIBERS":
			if (cartPage.isCartOpen()) {
				cartPage.closeCart();
			}
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

		wait.until(ExpectedConditions.elementToBeClickable(radioBtnTetraPalms)).click();
		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeFlexiFibers)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularFlexiFibers)).click();
		}
		click_add_Flexis_to_cart();
	}

	public void click_add_FlexiPalms_to_cart(String size) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(radioBtnFlexiPalms)).click();
		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeFlexiFibers)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularFlexiFibers)).click();
		}
		click_add_Flexis_to_cart();
	}

	public void click_add_FlexiFibers_to_cart(String size) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(radioBtnFlexiFibers)).click();

		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeFlexiFibers)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularFlexiFibers)).click();
		}

		click_add_Flexis_to_cart();
	}

	public void click_add_FlexiDomes_to_cart(String size) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(radioBtnFlexiDomes)).click();

		if (size.equalsIgnoreCase("large")) {
			wait.until(ExpectedConditions.elementToBeClickable(btnLargeFlexiFibers)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(btnRegularFlexiFibers)).click();
		}

		click_add_Flexis_to_cart();

	}

	private void click_add_Flexis_to_cart() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartFlexis)).click();
		Thread.sleep(500);
	}

	private void click_add_Wax_to_cart() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartWax)).click();
		Thread.sleep(500);
	}

}
