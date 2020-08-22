package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NeoHifiPage extends BasePage {

	CartPage cartPage = new CartPage();

	public NeoHifiPage() {
		PageFactory.initElements(driver, this);
		// waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='right_box']//button[text()='ADD TO CART']")
	public WebElement btnAddToCart;
	
	
	@FindBy(how = How.XPATH, using = "//button[text()='GET YOUR RATE']")
	public WebElement hifiGetYourRate;
	
	@FindBy(how = How.XPATH, using = "//div[@id='bread-checkout-btn']")
	public WebElement hifiCheckYourRate;
	

	public CartPage click_add_to_cart() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
		Thread.sleep(3000);

		return cartPage;
	}
	
	
	public void hifi_get_your_rate() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(hifiGetYourRate)).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", hifiCheckYourRate);
//		hifiCheckYourRate.click();
		wait.until(ExpectedConditions.elementToBeClickable(hifiCheckYourRate)).click();
		Thread.sleep(3000);
		
	}

}
