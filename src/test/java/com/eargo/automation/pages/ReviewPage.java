package com.eargo.automation.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPage extends BasePage {

	public ReviewPage() {

		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	String couponErrorMessage;

	OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

	@FindBy(how = How.XPATH, using = "//div[@class='left_container']/div[2]/div[2]/div[1]/button[1]")
	public WebElement editShipMyEargoTO;

	// Order Summary - Complete Order
	@FindBy(how = How.XPATH, using = "//button[@type='submit' and text()='COMPLETE ORDER']")
	public WebElement visaOrderComplete;

	@FindBy(how = How.ID, using = "bread-checkout-btn")
	public WebElement breadOrderComplete;

	@FindBy(how = How.ID, using = "firstName")
	public WebElement breadFirstName;

	// @FindBy(how = How.XPATH, using = "//button[@type='submit' and class =
	// 'cta-row-container__next-button']")
	// public WebElement nextToButton;

	@FindBy(how = How.ID, using = "button-submit-pp1-ui-flow-v1-variant-c-firstName")
	public WebElement nextToButton;

	@FindBy(how = How.ID, using = "button-submit-pp1-ui-flow-v1-variant-c-lastName")
	public WebElement nextToEmail;

	@FindBy(how = How.ID, using = "button-submit-pp1-ui-flow-v1-variant-c-email")
	public WebElement nextToPhone;

	@FindBy(how = How.ID, using = "lastName")
	public WebElement breadLastName;

	@FindBy(how = How.ID, using = "email")
	public WebElement breadEmail;

	@FindBy(how = How.ID, using = "phone")
	public WebElement breadPhone;

	@FindBy(how = How.ID, using = "button-register")
	public WebElement viewFinancingOptions;

	@FindBy(how = How.ID, using = "code")
	public WebElement niceToMeetYouCode;

	@FindBy(how = How.ID, using = "authorizeButton")
	public WebElement submitToken;

	@FindBy(how = How.ID, using = "address")
	public WebElement address;

	@FindBy(how = How.ID, using = "address2")
	public WebElement addressUnit;

	@FindBy(how = How.ID, using = "zip")
	public WebElement zipCode;

	@FindBy(how = How.ID, using = "birthDate")
	public WebElement birthDate;

	@FindBy(how = How.ID, using = "ssn")
	public WebElement sSN;

	@FindBy(how = How.ID, using = "button-register")
	public WebElement submitAndContinue;

	@FindBy(how = How.ID, using = "confirmBtn")
	public WebElement breadContinueToCheckout;

	@FindBy(how = How.ID, using = "review-terms-agreement")
	public WebElement termsAndConditions;

	@FindBy(how = How.ID, using = "bread-review-submit-button")
	public WebElement acceptAndCheckout;

	@FindBy(how = How.XPATH, using = "//div[@class='checkout_form_left']/div[1]/div[1]/button[1]")
	public WebElement editAccountInfo;

	@FindBy(how = How.XPATH, using = "//div[@class='paymentContainer']/div[1]/button[1]")
	public WebElement editPaymentInfo;

	@FindBy(how = How.ID, using = "radio-2")
	public WebElement selectTwelveMonths;

	@FindBy(how = How.CLASS_NAME, using = "modal-close")
	public WebElement closePaymentBox1;

	@FindBy(how = How.ID, using = "button-form-submit")
	public WebElement seeIfYouQualify;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Apply')]")
	public WebElement btnApplyCoupon;

	@FindBy(how = How.XPATH, using = "//input[@id='coupon-value']")
	public WebElement inputCoupon;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'REMOVE')]")
	public WebElement btnRemoveCoupon;

	@FindBy(how = How.CLASS_NAME, using = "coupon_error")
	public WebElement invalidCouponErrorMSG;

	@FindBy(how = How.XPATH, using = "//iframe[@title='PayPal']")
	public WebElement paypalCompleteOrderiFrame;

	@FindBy(how = How.XPATH, using = "//div[@id='buttons-container']/div/div/div[@role='button']")
	public WebElement payPalOrderComplete;

	// Paypal related xpaths
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'spinner')]")
	public WebElement paypalSpinnerImg;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	public WebElement inputPayPalEmail;

	@FindBy(how = How.XPATH, using = "//button[@id='btnNext']")
	public WebElement nextToPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	public WebElement inputPayPalPassword;

	@FindBy(how = How.XPATH, using = "//button[@id='btnLogin']")
	public WebElement PayPalLogin;

	@FindBy(how = How.XPATH, using = "//img[@data-testid='header-logo' and @alt='PayPal']")
	public WebElement payPalLogo;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add debit or credit card')]")
	public WebElement linkAddDebitOrCreditCard;

	@FindBy(how = How.XPATH, using = "//button[@id='payment-submit-btn']")
	public WebElement btnPayNow;

	public OrderConfirmationPage clickCompleteOrderButton() {

		System.out.println("Inside clickcomplete button");
		try {
			// Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println("before clicking on complete order");
			wait.until(ExpectedConditions.elementToBeClickable(visaOrderComplete)).click();

			System.out.println("Clicked on complete order button");

		} catch (Exception e) {

			System.out.println(e);
		}

		return orderConfirmationPage;

	}

	public void debitCardPayment() throws InterruptedException {

		visaOrderComplete.click();
	}

	public OrderConfirmationPage payPalPayment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("inside payPalPayment method");

		wait.until(ExpectedConditions.visibilityOf(paypalCompleteOrderiFrame));
		driver.switchTo().frame(paypalCompleteOrderiFrame);
		wait.until(ExpectedConditions.elementToBeClickable(payPalOrderComplete)).click();

		Thread.sleep(5000);

		String reviewPageMainWindow = driver.getWindowHandle();

		switchToPayPalWindow();

		wait.until(ExpectedConditions.invisibilityOf(paypalSpinnerImg));
		wait.until(ExpectedConditions.visibilityOf(inputPayPalEmail)).sendKeys(prop.getProperty("PaypalUserID"));

		wait.until(ExpectedConditions.elementToBeClickable(nextToPassword)).click();

		wait.until(ExpectedConditions.visibilityOf(inputPayPalPassword));
		inputPayPalPassword.sendKeys(prop.getProperty("PayPalPassword"));

		wait.until(ExpectedConditions.elementToBeClickable(PayPalLogin)).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(payPalLogo));

		wait.until(ExpectedConditions.visibilityOf(btnPayNow));
		scrollToElement(btnPayNow);

		// Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(linkAddDebitOrCreditCard));
		wait.until(ExpectedConditions.elementToBeClickable(btnPayNow)).click();

		Thread.sleep(3000);

		driver.switchTo().window(reviewPageMainWindow);

		// switchToMainWindow();

		return orderConfirmationPage;

	}

	/**
	 *
	 */

	private void switchToPayPalWindow() {

		System.out.println("WindowHandle Before switch to paypal : " + driver.getWindowHandle());
		System.out.println("Title Before switch to paypal : " + driver.getTitle());
		Set<String> allWindow = driver.getWindowHandles();
		for (String window : allWindow) {
			driver.switchTo().window(window);
		}
		System.out.println("Title After switch to paypal : " + driver.getTitle());
		System.out.println("WindowHandle Before switch to paypal : " + driver.getWindowHandle());
	}

	/**
	 * 
	 */
	private void switchToMainWindow() {

		// System.out.println("switchToMainWindow");
		driver.switchTo().window("CDwindow-2CF02D1DB3BAD51C0B372E56891F0EB1");
		// driver.getWindowHandle();
		System.out.println("***************Title After switch back to main window : " + driver.getTitle());
		System.out.println("***************WindowHandle After switch back to main window: " + driver.getWindowHandle());
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());

		// Set<String> allWindow = driver.getWindowHandles();
		// for (String window : allWindow) {
		// driver.switchTo().window(window);
		// break;
		// }
	}

	public OrderConfirmationPage breadPayment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("before clicking on bread complete order");
		wait.until(ExpectedConditions.elementToBeClickable(breadOrderComplete)).click();

		// breadOrderComplete.click();
		Thread.sleep(3000);

		driver.switchTo().frame("bread-modal");
		breadFirstName.sendKeys("Brandon");
		Thread.sleep(3000);
		nextToButton.click();

		breadLastName.sendKeys("Thai");
		nextToEmail.click();

		breadEmail.sendKeys("test2107@eargo.com");
		nextToPhone.click();

		breadPhone.sendKeys("6509999778");
		viewFinancingOptions.click();

		niceToMeetYouCode.sendKeys("1234");
		submitToken.click();

		// if(address.isDisplayed()) {
		// address.sendKeys("Address1");
		// addressUnit.sendKeys("1");
		// zipCode.sendKeys("90201");
		// birthDate.sendKeys("12/12/1990");
		// sSN.sendKeys("8800");
		// Thread.sleep(3000);
		// submitAndContinue.click();
		// }

		Thread.sleep(2000);
		selectTwelveMonths.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", breadContinueToCheckout);
		breadContinueToCheckout.click();

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", termsAndConditions);
		termsAndConditions.click();

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", acceptAndCheckout);
		acceptAndCheckout.click();

		driver.switchTo().defaultContent();

		Thread.sleep(3000);

		return orderConfirmationPage;

	}

	public void breadPaymentCancel() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("before clicking on bread complete order");
		wait.until(ExpectedConditions.elementToBeClickable(breadOrderComplete)).click();
		Thread.sleep(3000);
		driver.switchTo().frame("bread-modal");
		breadFirstName.sendKeys("Brandon");
		Thread.sleep(2000);
		closePaymentBox1.click();
		// wait.until(ExpectedConditions.elementToBeClickable(closePaymentBox1)).click();
		Thread.sleep(3000);
		// closePaymentBox2.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", seeIfYouQualify);
		// wait.until(ExpectedConditions.elementToBeClickable(closePaymentBox2)).click();
		Thread.sleep(3000);
		closePaymentBox1.click();

		driver.switchTo().defaultContent();

		Thread.sleep(3000);

	}

	public void paypalPaymentCancel() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("inside payPalPayment method");

		String reviewPageMainWindow = driver.getWindowHandle();

		wait.until(ExpectedConditions.visibilityOf(paypalCompleteOrderiFrame));
		driver.switchTo().frame(paypalCompleteOrderiFrame);
		wait.until(ExpectedConditions.elementToBeClickable(payPalOrderComplete)).click();
		Thread.sleep(5000);

		switchToPayPalWindow();

		wait.until(ExpectedConditions.invisibilityOfAllElements(paypalSpinnerImg));
		wait.until(ExpectedConditions.visibilityOf(inputPayPalEmail)).sendKeys(prop.getProperty("PaypalUserID"));
		driver.close();

		driver.switchTo().window(reviewPageMainWindow);
		System.out.println("main window vaule now : " + reviewPageMainWindow);

		// switchToMainWindow();

	}

	public CheckoutPage editAccountInfo() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(editAccountInfo));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editAccountInfo);

		CheckoutPage checkoutPage = new CheckoutPage();
		return checkoutPage;

	}

	public CheckoutPage editShippingInfo() throws InterruptedException {

		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editShipMyEargoTO);

		CheckoutPage checkoutPage = new CheckoutPage();
		return checkoutPage;

	}

	public CheckoutPage editPaymentInfo() throws InterruptedException {
		CheckoutPage checkoutPage = new CheckoutPage();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", editPaymentInfo);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editPaymentInfo);
		// editPaymentInfo.click();
		Thread.sleep(3000);

		return checkoutPage;

	}

	public void removeCoupon() throws InterruptedException {

		btnRemoveCoupon.click();
		Thread.sleep(1000);

	}

	public void clearCouponField() throws InterruptedException {

		if (getOS() == OS.MAC) {
			inputCoupon.sendKeys(Keys.chord(Keys.COMMAND, "a"));
		} else {
			inputCoupon.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		}
		inputCoupon.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(500);
	}

	public void applyCoupon(String couponCode) throws InterruptedException {

		clearCouponField();
		inputCoupon.sendKeys(couponCode);
		btnApplyCoupon.click();
		Thread.sleep(2000);

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
