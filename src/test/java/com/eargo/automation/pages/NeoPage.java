package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NeoPage extends BasePage {

	CartPage cartPage = new CartPage();

	public NeoPage() {
		PageFactory.initElements(driver, this);
		// waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='right_box']//button[text()='ADD TO CART']")
	public WebElement btnAddToCart;
	
	@FindBy(how = How.XPATH, using = "//button[text()='GET YOUR RATE']")
	public WebElement neoGetYourRate;
	
	@FindBy(how = How.XPATH, using = "//div[@id='bread-checkout-btn']")
	public WebElement neoCheckYourRate;

	public CartPage click_add_to_cart() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
		Thread.sleep(3000);

		return cartPage;
	}
	
	
	public void neo_get_your_rate() throws InterruptedException {

		System.out.println("inside neo get your rate");	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(neoGetYourRate)).click();
		Thread.sleep(3000);
		waitForPageLoad();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", neoCheckYourRate);
		wait.until(ExpectedConditions.elementToBeClickable(neoCheckYourRate)).click();
		Thread.sleep(3000);
		
		
	}

}
