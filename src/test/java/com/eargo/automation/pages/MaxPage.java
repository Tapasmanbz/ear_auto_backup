package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaxPage extends BasePage {
	CartPage cartPage = new CartPage();

	public MaxPage() {
		PageFactory.initElements(driver, this);
		// waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='right_box']//button[text()='ADD TO CART']")
	public WebElement btnAddToCart;
	
	@FindBy(how = How.XPATH, using = "//button[text()='GET YOUR RATE']")
	public WebElement maxGetYourRate;
	
	@FindBy(how = How.XPATH, using = "//div[@id='bread-checkout-btn']")
	public WebElement maxCheckYourRate;

	public CartPage click_add_to_cart() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
		Thread.sleep(3000);

		return cartPage;
	}
	
	public void max_get_your_rate() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(maxGetYourRate)).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", maxCheckYourRate);
		wait.until(ExpectedConditions.elementToBeClickable(maxCheckYourRate)).click();
		Thread.sleep(3000);

		
	}
}
