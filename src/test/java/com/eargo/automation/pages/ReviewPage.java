package com.eargo.automation.pages;

import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
	String enteredCustomerName = null;
	String enteredPhoneNumber = null;
	String enteredEmailID = null;
	String enteredStreetAddress = null;
	String enteredBillingStreetAddress = null;
	String expectedDeliveryDate = null;
	String customerPaymentType = null;

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

	@FindBy(how = How.XPATH, using = "//div[@id='card-element']/div/iframe")
	public WebElement iFrameCardNumberBread;

	@FindBy(how = How.NAME, using = "cardnumber")
	public WebElement inputCardNumberBread;

	@FindBy(how = How.NAME, using = "exp-date")
	public WebElement inputCardExpDateBread;

	@FindBy(how = How.NAME, using = "cvc")
	public WebElement inputCardCVCBread;

	@FindBy(how = How.NAME, using = "postal")
	public WebElement inputZipCodeBread;

	@FindBy(how = How.ID, using = "submit-payment-button")
	public WebElement btnAddtionalPaymentCheckout;

	@FindBy(how = How.XPATH, using = "//div[@class='checkout_form_left']/div[1]/div[1]/button[1]")
	public WebElement editAccountInfo;

	// @FindBy(how = How.XPATH, using =
	// "//div[@class='paymentContainer']/div[1]/button[1]")
	// public WebElement editPaymentInfo;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I would like to pay with')]//parent::div//child::button[contains(text(),'Edit')]")
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

	// @FindBy(how = How.ID, using = "page-checkout-confirmation-standard")
	// public WebElement breadPurchaseConfirmationPopUp;

	public static String paymentMethod;

	public OrderConfirmationPage clickCompleteOrderButton() {

		setPaymentMethod("Credit Card");

		System.out.println("Inside clickcomplete button");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			System.out.println("before clicking on complete order");
			wait.until(ExpectedConditions.elementToBeClickable(visaOrderComplete)).click();
			Thread.sleep(1000);
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

		setPaymentMethod("PayPal");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("inside payPalPayment method");

		wait.until(ExpectedConditions.visibilityOf(paypalCompleteOrderiFrame));
		driver.switchTo().frame(paypalCompleteOrderiFrame);
		Thread.sleep(2500);
		wait.until(ExpectedConditions.elementToBeClickable(payPalOrderComplete)).click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Thread.sleep(3000);

		String reviewPageMainWindow = driver.getWindowHandle();

		switchToPayPalWindow();

		wait.until(ExpectedConditions.invisibilityOf(paypalSpinnerImg));
		wait.until(ExpectedConditions.visibilityOf(inputPayPalEmail)).sendKeys(prop.getProperty("PaypalUserID"));

		wait.until(ExpectedConditions.elementToBeClickable(nextToPassword)).click();

		wait.until(ExpectedConditions.visibilityOf(inputPayPalPassword));
		inputPayPalPassword.sendKeys(prop.getProperty("PayPalPassword"));

		wait.until(ExpectedConditions.elementToBeClickable(PayPalLogin)).click();

		Thread.sleep(3500);
		wait.until(ExpectedConditions.visibilityOf(payPalLogo));

		wait.until(ExpectedConditions.visibilityOf(btnPayNow));
		// scrollToElement(btnPayNow);
		//
		// Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(linkAddDebitOrCreditCard));
		scrollToElement(btnPayNow);
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

		setPaymentMethod("Bread Financing");

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

		breadEmail.sendKeys("brandon2003@eargo.com");
		nextToPhone.click();

		// breadPhone.sendKeys("6509999778");
		breadPhone.sendKeys(generatePhoneNumber());
		viewFinancingOptions.click();

		niceToMeetYouCode.sendKeys("1234");
		submitToken.click();

		wait.until(ExpectedConditions.visibilityOf(address)).sendKeys("1234 Oakland road");
		// addressUnit.sendKeys("12");
		zipCode.sendKeys("95112");
		birthDate.sendKeys("10101977");
		sSN.sendKeys("8800");
		wait.until(ExpectedConditions.elementToBeClickable(submitAndContinue)).click();

		Thread.sleep(2000);
		selectTwelveMonths.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", breadContinueToCheckout);
		wait.until(ExpectedConditions.elementToBeClickable(breadContinueToCheckout)).click();

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", termsAndConditions);
		wait.until(ExpectedConditions.elementToBeClickable(termsAndConditions)).click();

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", acceptAndCheckout);
		wait.until(ExpectedConditions.elementToBeClickable(acceptAndCheckout)).click();

		if (isAdditionalPaymentRequired()) {
			makeAdditionalPayment();
		}

		driver.switchTo().defaultContent();

		Thread.sleep(7000);

		return orderConfirmationPage;

	}

	public boolean isAdditionalPaymentRequired() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {

			wait.until(ExpectedConditions.visibilityOf(iFrameCardNumberBread));
			return iFrameCardNumberBread.isDisplayed();

		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public void makeAdditionalPayment() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameCardNumberBread));
		wait.until(ExpectedConditions.elementToBeClickable(inputCardNumberBread)).click();
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ",
				prop.getProperty("visaCardNumber"), inputCardNumberBread);
		wait.until(ExpectedConditions.visibilityOf(inputCardExpDateBread))
				.sendKeys(prop.getProperty("visaCardExpirationDate"));
		wait.until(ExpectedConditions.visibilityOf(inputCardCVCBread)).sendKeys(prop.getProperty("visaCardCVC"));
		wait.until(ExpectedConditions.visibilityOf(inputZipCodeBread)).sendKeys("95112");
		driver.switchTo().parentFrame();
		wait.until(ExpectedConditions.elementToBeClickable(btnAddtionalPaymentCheckout)).click();
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

		try {
			wait.until(ExpectedConditions.invisibilityOfAllElements(paypalSpinnerImg));
		} catch (TimeoutException e) {
			wait.until(ExpectedConditions.visibilityOf(inputPayPalEmail)).sendKeys(prop.getProperty("PaypalUserID"));
		}

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
		wait.until(ExpectedConditions.visibilityOf(editPaymentInfo));
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

	public String getPaymentMethod() {
		System.out.println("getPaymentMethod:" + paymentMethod);
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		System.out.println("setPaymentMethod:" + paymentMethod);
		this.paymentMethod = paymentMethod;
	}

	// -----------03/09/2020-------------------

	@FindBy(how = How.ID, using = "//div[@class='yourAccount']/div[1]/div[1]/label[1]")
	public WebElement customerFirstName;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[1]/div[1]/label[2]")
	public WebElement customerSecondName;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[1]/label[1]")
	public WebElement customerPhoneNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[1]/label[2]")
	public WebElement customerEmailID;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[2]/div[2]/label[1]")
	public WebElement customerStreetAddress;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[2]/div[3]/div[@class='review_section']/label[1]")
	public WebElement customerBillingStreetAddress;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Estimated Delivery Date')]//following::label[1]")
	public WebElement customerEstimatedDevliverDate;

	@FindBy(how = How.XPATH, using = "//div[@class='paypal_text_container']/img[1]")
	public WebElement paypalPaymentType;

	@FindBy(how = How.XPATH, using = "//div[@class='bread_text_container']/img[1]")
	public WebElement breadPaymentType;

	public String getCustomerName() {
		enteredCustomerName = customerFirstName.getText() + " " + customerSecondName.getText();
		System.out.println("enteredCustomerName = " + enteredCustomerName);
		return this.enteredCustomerName;
	}

	public String getPhoneNumber() {
		enteredPhoneNumber = customerPhoneNumber.getText();
		enteredPhoneNumber = enteredPhoneNumber.replaceAll("(-)", " ");
		System.out.println("enteredPhoneNumber = " + enteredPhoneNumber);
		return this.enteredPhoneNumber;
	}

	public String getEnteredEmailID() {
		enteredEmailID = customerEmailID.getText();
		System.out.println("enteredEmailID = " + enteredEmailID);
		return this.enteredEmailID;
	}

	public String getEnteredStreetAddress() {
		enteredStreetAddress = customerStreetAddress.getText();
		System.out.println("enteredStreetAddress = " + enteredStreetAddress);
		return this.enteredStreetAddress;
	}

	public String getEnteredBillingStreetAddress() {
		enteredBillingStreetAddress = customerBillingStreetAddress.getText();
		System.out.println("enteredBillingStreetAddress = " + enteredBillingStreetAddress);
		return this.enteredBillingStreetAddress;
	}

	public String getDeliveryDate() {
		expectedDeliveryDate = customerEstimatedDevliverDate.getText();
		System.out.println("expectedDeliveryDate = " + expectedDeliveryDate);
		return this.expectedDeliveryDate;
	}

	public String getPaymentType() {
		if (paypalPaymentType.isDisplayed()) {
			customerPaymentType = "PayPal";
			System.out.println("customerPaymentType = " + customerPaymentType);

		} else if (breadPaymentType.isDisplayed()) {
			customerPaymentType = "Bread";
			System.out.println("customerPaymentType = " + customerPaymentType);

		} else {
			customerPaymentType = "Credit Card";
			System.out.println("customerPaymentType = " + customerPaymentType);

		}

		return this.customerPaymentType;

	}

	public void verifyDetailsOnReviewPage() throws InterruptedException {
		
//		Validating "Account Info"		
		Thread.sleep(10000);
//		Assert.assertEquals("User Name doesn't matched", "TestAccountFirst TestAccountLast", getCustomerName());
//		Thread.sleep(2000);
		Assert.assertEquals("User Phone Number doesn't matched", prop.getProperty("Phone"),  getPhoneNumber());
		Thread.sleep(2000);
		
		Assert.assertEquals("User Eamil doesn't matched", prop.getProperty("EditedEmail"), getEnteredEmailID());
//		Thread.sleep(2000);		

		//Validating "Shipping Address"
		
//		Assert.assertEquals("Shipping street doesn't matched", prop.getProperty("shippingStreetAddress"),getEnteredStreetAddress());
		Thread.sleep(2000);
				
		
		//Validating "Billing Address"	
		
		Assert.assertEquals("Billing street doesn't matched", prop.getProperty("editedShippingStreetAddress"), getEnteredBillingStreetAddress());
		Thread.sleep(2000);

		//Validating "Estimated Delivery Date"
		
//		Assert.assertEquals("Estimated Delivery Date doesn't matched",checkoutPage.getExpectedDeliveryDate(), getDeliveryDate());
//		Thread.sleep(2000);		
		//Validating "Payment type"
		
//		Assert.assertEquals("Payment type doesn't matched",getPaymentMethod(), getPaymentType());
		Thread.sleep(2000);		
		//Validating "Order Summary"
		// Need to discuss with tapas as this requires the array-list way of validating

	}

}
