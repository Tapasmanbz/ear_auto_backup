package com.eargo.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

	public CartPage() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	String couponErrorMessage;

	CheckoutPage checkoutPage = new CheckoutPage();
	MentionMePage mentionMe = new MentionMePage();

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cartContainer')]/parent::div")
	public WebElement scrollCartContainer;

	@FindBy(how = How.XPATH, using = "//h1[contains(@class,'productName')]")
	public List<WebElement> allCartProduct;

	@FindBy(how = How.XPATH, using = "//div[@class='cart_header_container']//button")
	public WebElement btnCloseCart;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'+')]")
	public WebElement btnAddCoupon;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Apply')]")
	public WebElement btnApplyCoupon;

	@FindBy(how = How.XPATH, using = "//input[@id='coupon-value']")
	public WebElement inputCoupon;

	// @FindBy(how = How.XPATH, using =
	// "//div[@class='circle']//button[contains(text(),'X')]")
	// public WebElement btnRemoveCoupon;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'REMOVE')]")
	public WebElement btnRemoveCoupon;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Apply')]")
	public WebElement btnApplyVisible;

	@FindBy(how = How.CLASS_NAME, using = "coupon_error")
	public WebElement invalidCouponErrorMSG;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Referred by a friend?')]")
	public WebElement linkReferredByFriend;

	@FindBy(how = How.XPATH, using = "//button[text()='CHECKOUT']")
	public WebElement btnCheckout;

	@FindBy(how = How.XPATH, using = "//output[contains(text(),'2')]")
	public WebElement prodAfterIncrement;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Other Available Discounts')]")
	public WebElement linkOtherAvailableDiscounts;

	public CheckoutPage clickCheckoutButton() throws InterruptedException {

		scrollToCartBottom();
		Thread.sleep(3000);
		btnCheckout.click();
		Thread.sleep(3000);

		return checkoutPage;

	}

	public ArrayList<String> getAllCartProductName() throws InterruptedException {

		ArrayList<String> allProductName = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfAllElements(allCartProduct));
		for (WebElement product : allCartProduct) {
			allProductName.add(product.getText());
		}

		return allProductName;
	}

	public boolean isCartOpen() throws InterruptedException {
		try {
			return wait.until(ExpectedConditions.visibilityOf(scrollCartContainer)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}

	}

	public void closeCart() throws InterruptedException {

		btnCloseCart.click();
		Thread.sleep(2000);

	}
	
	public boolean checkDefaultCouponApplied() throws InterruptedException {
		boolean appliedCoupon;
		appliedCoupon = btnApplyVisible.isDisplayed();
		Thread.sleep(1000);
		if(appliedCoupon==true) {
			System.out.println("No Default coupon is applied");
		}else {
			System.out.println("Default coupon is applied");
		}
		return appliedCoupon;
	}
	
	public boolean removeCoupon() throws InterruptedException {

		scrollToCartBottom();
		btnRemoveCoupon.click();
		Thread.sleep(1000);
		return true;
	}

	public void applyCoupon(String couponCode) throws InterruptedException {

		// btnAddCoupon.click();
		System.out.println("#" + inputCoupon.getText());
		inputCoupon.click();
		inputCoupon.clear();
		Thread.sleep(500);
		inputCoupon.sendKeys(couponCode);
		btnApplyCoupon.click();
		Thread.sleep(3000);

	}

	public MentionMePage clickReferByFriend() throws InterruptedException {
	    
	    scrollToElement(linkOtherAvailableDiscounts);
	    // click on refer friend code
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.elementToBeClickable(linkOtherAvailableDiscounts)).click();
	    Thread.sleep(2000);
	    wait.until(ExpectedConditions.elementToBeClickable(linkReferredByFriend)).click();
	    return mentionMe;
	  }

	public String afterIncrement() throws InterruptedException {

		Thread.sleep(3000);

		return (prodAfterIncrement.getText());

	}

	public void scrollToCartBottom() throws InterruptedException {
		String script_string = "arguments[0].scrollTo(0, arguments[0].scrollHeight);";
		((JavascriptExecutor) driver).executeScript(script_string, scrollCartContainer);
		Thread.sleep(1000);

	}

	public boolean isCouponApplied() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);

		try {

			return btnRemoveCoupon.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Coupon applied.");
			return false;
		}

	}

	public void setCouponErrorMessage() throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(1000);

		try {

			this.couponErrorMessage = invalidCouponErrorMSG.getText();
		} catch (NoSuchElementException e) {
			System.out.println("Coupon error message isn't displayed.");
			this.couponErrorMessage = "";
		}

	}

	public String getCouponErrorMessage() {
		return this.couponErrorMessage;
	}
}
