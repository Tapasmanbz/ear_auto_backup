package com.eargo.automation.pages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	private boolean isBreadPaymentMethodDisplayed;
	String couponErrorMessage;
	String enteredCustomerEmailID;
	public String expectedDeliveryDate; 
	
	ReviewPage salesforcePage = new ReviewPage();
	ReviewPage reviewPage = new ReviewPage();

	@FindBy(name = "email")
	WebElement inputAccountEmail;

	@FindBy(how = How.NAME, using = "first_name1")
	public WebElement inputAccountFirstName;

	@FindBy(how = How.NAME, using = "last_name1")
	public WebElement inputAccountLastName;

	@FindBy(how = How.NAME, using = "tel")
	public WebElement inputAccountPhoneNumber;

	@FindBy(how = How.XPATH, using = "//label[@id='phone']/span")
	public WebElement invalidPhoneNumberErrorMSG;

	// Shipping to
	@FindBy(how = How.NAME, using = "first_name2")
	public WebElement inputShippingFirstName;

	@FindBy(how = How.NAME, using = "last_name2")
	public WebElement inputShippingLastName;

	@FindBy(how = How.NAME, using = "address1")
	public WebElement inputShippingAddress;

	@FindBy(how = How.NAME, using = "city")
	public WebElement inputShippingCity;

	// @FindBy(how = How.XPATH, using =
	// "//label[contains(@class,'shipAddress')]/div")
	// public WebElement dropdownShippingState;

	@FindBy(xpath = "//label[contains(@class,'shipAddress')]/div")
	WebElement dropdownShippingState;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[1]")
	public WebElement dropdownStateOptionAlbama;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[2]")
	public WebElement dropdownStateOptionAlaska;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[3]")
	public WebElement dropdownStateOptionArizona;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[4]")
	public WebElement dropdownStateOptionArkansas;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[5]")
	public WebElement dropdownStateOptionCalifornia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[6]")
	public WebElement dropdownStateOptionColorado;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[7]")
	public WebElement dropdownStateOptionConnecticut;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[8]")
	public WebElement dropdownStateOptionDelaware;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[9]")
	public WebElement dropdownStateOptionDistrictOfColumbia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[10]")
	public WebElement dropdownStateOptionFlorida;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[11]")
	public WebElement dropdownStateOptionGeorgia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[12]")
	public WebElement dropdownStateOptionHawaii;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[13]")
	public WebElement dropdownStateOptionIdaho;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[14]")
	public WebElement dropdownStateOptionIllinois;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[15]")
	public WebElement dropdownStateOptionIndiana;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[16]")
	public WebElement dropdownStateOptionIowa;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[17]")
	public WebElement dropdownStateOptionKansas;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[18]")
	public WebElement dropdownStateOptionKentucky;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[19]")
	public WebElement dropdownStateOptionLouisiana;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[20]")
	public WebElement dropdownStateOptionMaine;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[21]")
	public WebElement dropdownStateOptionMaryland;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[22]")
	public WebElement dropdownStateOptionMassachusetts;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[23]")
	public WebElement dropdownStateOptionMichigan;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[24]")
	public WebElement dropdownStateOptionMinnesota;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[25]")
	public WebElement dropdownStateOptionMississippi;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[26]")
	public WebElement dropdownStateOptionMissouri;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[27]")
	public WebElement dropdownStateOptionMontana;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[28]")
	public WebElement dropdownStateOptionNebraska;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[29]")
	public WebElement dropdownStateOptionNevada;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[30]")
	public WebElement dropdownStateOptionNewhampshire;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[31]")
	public WebElement dropdownStateOptionNewjersey;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[32]")
	public WebElement dropdownStateOptionNewmexico;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[33]")
	public WebElement dropdownStateOptionNewyork;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[34]")
	public WebElement dropdownStateOptionNorthcarolina;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[35]")
	public WebElement dropdownStateOptionNorthdakota;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[36]")
	public WebElement dropdownStateOptionOhio;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[37]")
	public WebElement dropdownStateOptionOklahoma;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[38]")
	public WebElement dropdownStateOptionOregon;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[39]")
	public WebElement dropdownStateOptionPennsylvania;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[40]")
	public WebElement dropdownStateOptionRhodeisland;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[41]")
	public WebElement dropdownStateOptionSouthcarolina;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[42]")
	public WebElement dropdownStateOptionSouthdakota;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[43]")
	public WebElement dropdownStateOptionTennessee;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[44]")
	public WebElement dropdownStateOptionTexas;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[45]")
	public WebElement dropdownStateOptionUtah;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[46]")
	public WebElement dropdownStateOptionVermont;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[47]")
	public WebElement dropdownStateOptionVirginia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[48]")
	public WebElement dropdownStateOptionWashington;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[49]")
	public WebElement dropdownStateOptionWestvirginia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[50]")
	public WebElement dropdownStateOptionWisconsin;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[51]")
	public WebElement dropdownStateOptionWyoming;

	@FindBy(how = How.XPATH, using = "//*[@id='zipcode']/input")
	public WebElement dropdownShippingZipCode;

	@FindBy(how = How.XPATH, using = "//label[@id='zipcode']/span")
	public WebElement invalidStateZipCodeErrorMSG;

	// Delivery Method
	@FindBy(how = How.XPATH, using = "//button[@type='button' and contains(text(),'1-2 Business Days')]")
	public WebElement tabAcceleratedShipping;

	@FindBy(how = How.XPATH, using = "//button[@type='button' and contains(text(),'3-5 Business Days')]")
	public WebElement tabNormalShipping;

	// Different Billing Address
	@FindBy(how = How.XPATH, using = "//label[@class='radioButton body1 bold']//span[contains(@class,'lazy-load-image-background blur lazy-load-image-loaded')]")
	public WebElement selectDifferentBillingAddress;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']//div//div//div//div[@class='oneline']//label[@id='firstname']")
	public WebElement inputDiffShippingFirstName;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']//div//div//div//div[@class='oneline']//label[@id='lastname']")
	public WebElement inputDiffShippingLastName;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']//div//div//div//label[@id='address1']")
	public WebElement inputDiffShippingAddress;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']//div//div//div//div[@class='oneline']//label[@id='city']")
	public WebElement inputDiffShippingCity;

	@FindBy(xpath = "//label[contains(@class,'billAddress')]//div")
	WebElement dropdownBillingState;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'yourAccount')]//div//div//div//div[contains(@class,'oneline')]//label[@id='zipcode']")
	public WebElement dropdownBillingZipCode;

	// I'm paying with
	@FindBy(how = How.ID, using = "payment_section")
	public WebElement sectionPayment;

	@FindBy(how = How.NAME, using = "full_name")
	public WebElement inputPaymentFullName;

	@FindBy(how = How.XPATH, using = "//iframe[contains(@title,'card number')]")
	public WebElement iFrameStripeCardNumber;

	@FindBy(how = How.NAME, using = "cardnumber")
	public WebElement inputPaymentCardNumber;

	@FindBy(how = How.XPATH, using = "//iframe[contains(@title,'expiration date')]")
	public WebElement iFrameStripeCardExpiration;

	@FindBy(how = How.NAME, using = "exp-date")
	public WebElement inputPaymentCardExpiration;

	@FindBy(how = How.XPATH, using = "//iframe[contains(@title,'CVC')]")
	public WebElement iFrameStripeCardCVC;

	@FindBy(how = How.NAME, using = "cvc")
	public WebElement inputPaymentCardCVC;

	@FindBy(how = How.XPATH, using = "//label[@id='name']/following-sibling::label/span")
	public WebElement invalidCardErrorMsg;

	@FindBy(how = How.XPATH, using = "//label[@id='name']/following-sibling::div/label[1]/span")
	public WebElement expiredCardErrorMsg;

	// Medical Waiver
	@FindBy(how = How.ID, using = "waiver_section")
	public WebElement sectionMedicalWaiver;

	@FindBy(how = How.XPATH, using = "//label[@class='waiver_radioButton bold waiver_agree']//img")
	public WebElement radioBtnAcceptWaiver;

	@FindBy(how = How.ID, using = "continue-to-review-button")
	public WebElement btnContinueToReview;

	@FindBy(how = How.XPATH, using = "//div[@id='bread-button']//button[@class='unselectedButton regular bold center-flex']")
	public WebElement breadFinancing;

	@FindBy(how = How.XPATH, using = "//div[@id='paypal-button']//img[@class='circleImage']")
	public WebElement paypalRadioButton;

	@FindBy(how = How.XPATH, using = "//div[@id='credit-card-button']//img[@class='circleImage']")
	public WebElement creditCardRadioButton;

	@FindBy(how = How.CLASS_NAME, using = "coupon_error")
	public WebElement invalidCouponErrorMSG;

	public void enterEmail() {

		wait.until(ExpectedConditions.visibilityOf(inputAccountEmail));
		inputAccountEmail.sendKeys(prop.getProperty("defaultEmail"));
		setEnteredCustomerEmailID(prop.getProperty("defaultEmail"));
	}

	public void enterFirstName() {

		inputAccountFirstName.sendKeys(prop.getProperty("firstName"));
	}

	public void enterLastName() {

		inputAccountLastName.sendKeys(prop.getProperty("lastName"));
	}

	public void enterPhoneNumber() {

		inputAccountPhoneNumber.sendKeys(prop.getProperty("Phone"));
	}

	public void enterInvalidPhoneNumber(String phoneNumber) {

		inputAccountPhoneNumber.sendKeys(phoneNumber);
	}

	public void enterShippingFirstName() {

		inputShippingFirstName.sendKeys(prop.getProperty("shippingFirstName"));

	}

	public void enterShippingLastName() {

		inputShippingLastName.sendKeys(prop.getProperty("shippingLastName"));

	}

	public void enterShippingStreet() {

		inputShippingAddress.sendKeys(prop.getProperty("shippingStreetAddress"));

	}

	public void enterShippingCity() {

		inputShippingCity.sendKeys(prop.getProperty("shippingCity"));
	}

	public void enterShippingZipCode(String zipCode) {

		dropdownShippingZipCode.sendKeys(zipCode);
	}

	public void enterBillingZipCode(String zipCode) {

		dropdownBillingZipCode.sendKeys(zipCode);
	}

	public void enterMasterCardFullName() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(inputPaymentFullName));
		inputPaymentFullName.clear();
		Thread.sleep(500);
		inputPaymentFullName.sendKeys(prop.getProperty("masterCardFullName"));
	}

	public void enterInvalidCardNumber() throws InterruptedException {

		inputPaymentCardNumber.click();
		Thread.sleep(500);
		inputPaymentCardNumber.clear();
		((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ",
				prop.getProperty("invalidCardNumber"), inputPaymentCardNumber);
	}

	public void enterMasterCardNumber() throws InterruptedException {

		inputPaymentCardNumber.click();
		Thread.sleep(500);
		inputPaymentCardNumber.clear();
		((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ",
				prop.getProperty("masterCardNumber"), inputPaymentCardNumber);
	}

	public void enterJCBCardNumber() throws InterruptedException {

		inputPaymentCardNumber.click();
		Thread.sleep(500);
		inputPaymentCardNumber.clear();
		((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ",
				prop.getProperty("jcbCardNumber"), inputPaymentCardNumber);
	}

	public void enterAmexCardNumber() throws InterruptedException {
		inputPaymentCardNumber.click();
		Thread.sleep(500);
		inputPaymentCardNumber.clear();
		((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ",
				prop.getProperty("amexCardNumber"), inputPaymentCardNumber);
	}

	public void enterExpiredCardExpirationYear() {

		inputPaymentCardExpiration.sendKeys(prop.getProperty("expiredCardExpirationDate"));
	}

	public void enterMasterCardExpirationYear() {

		inputPaymentCardExpiration.sendKeys(prop.getProperty("masterCardExpirationDate"));
	}

	public void enterMasterCardCVC() {

		inputPaymentCardCVC.sendKeys(prop.getProperty("masterCardCVC"));
	}

	public void enterAmexCardCVC() {

		inputPaymentCardCVC.sendKeys(prop.getProperty("amexCardCVC"));
	}

	public void enterPersonalDeatils() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(inputAccountEmail));

		// Entering Personal Details for the User
		enterEmail();
		enterFirstName();
		enterLastName();
		enterPhoneNumber();

	}

	public void clickShippingStateDropdown() throws InterruptedException {
		scrollToElement(dropdownShippingState);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownShippingState)).click();
	}

	/**
	 * This method will enter shipping details
	 * 
	 * @author TM
	 * @param state
	 * @param zipCode
	 * @throws InterruptedException
	 */
	public void enterShippingDetails(String state, String zipCode) throws InterruptedException {

		// Enter Shipping Details
		enterShippingFirstName();
		enterShippingLastName();
		enterShippingStreet();
		enterShippingCity();
		clickShippingStateDropdown();
		selectState(state);
		enterShippingZipCode(zipCode);

	}

	public void enterEditedShippingDetails(String state, String zipCode) throws InterruptedException {

		// Enter edited Shipping Details
		inputShippingFirstName.clear();
		Thread.sleep(500);
		inputShippingFirstName.sendKeys(prop.getProperty("editedShippingFirstName"));

		inputShippingLastName.clear();
		Thread.sleep(500);
		inputShippingLastName.sendKeys(prop.getProperty("editedShippingLastName"));

		inputShippingAddress.clear();
		Thread.sleep(500);
		inputShippingAddress.sendKeys(prop.getProperty("editedShippingStreetAddress"));

		inputShippingCity.clear();
		Thread.sleep(500);
		inputShippingCity.sendKeys(prop.getProperty("editedShippingCity"));

		clickShippingStateDropdown();
		selectState(state);

		dropdownShippingZipCode.clear();
		Thread.sleep(1000);
		dropdownShippingZipCode.sendKeys(zipCode);

	}

	/**
	 * This method will enter billing details
	 * 
	 * @author TM
	 * @param state
	 * @param zipCode
	 * @throws InterruptedException
	 */
	public void enterBillingDeatils(String state, String zipCode) throws InterruptedException {

		System.out.println("inside enterBillingDetails");
		selectDifferentBillingAddress.click();
		inputDiffShippingFirstName.sendKeys("TestBillingFirst");
		inputDiffShippingLastName.sendKeys("TestBillingLast");
		inputDiffShippingAddress.sendKeys("295 N Bernardo Ave Suite 100");
		inputDiffShippingCity.sendKeys("Mountain View");

		clickBillingStateDropdown();
		System.out.println("clicked on dropdown");
		selectState(state);
		enterBillingZipCode(zipCode);
	}

	public void clickBillingStateDropdown() throws InterruptedException {
		scrollToElement(dropdownBillingState);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownBillingState)).click();
	}

	public void enterPaymentDetails(String cardType) throws InterruptedException {

		// Enter Payment Details
		System.out.println("card type = " + cardType);

		enterMasterCardFullName();

		scrollToElement(iFrameStripeCardNumber);
		driver.switchTo().frame(iFrameStripeCardNumber);

		// inputPaymentCardNumber.clear();
		// Thread.sleep(1000);

		switch (cardType.toLowerCase()) {
		case "invalid card":
			System.out.println("inside invalid card");
			enterInvalidCardNumber();
			break;
		case "master card":
			enterMasterCardNumber();
			break;
		case "jcb":
			enterJCBCardNumber();
			break;
		case "amex":
		case "american express":
			System.out.println("inside amex");
			enterAmexCardNumber();
			break;
		case "visa":
		default:
			inputPaymentCardNumber.click();
			Thread.sleep(500);
			inputPaymentCardNumber.clear();
			((JavascriptExecutor) driver).executeScript("arguments[1].value = arguments[0]; ",
					prop.getProperty("visaCardNumber"), inputPaymentCardNumber);
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iFrameStripeCardExpiration);

		switch (cardType.toLowerCase()) {
		case "expired card":
			enterExpiredCardExpirationYear();
			break;
		default:
			enterMasterCardExpirationYear();
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame(iFrameStripeCardCVC);

		switch (cardType.toLowerCase()) {
		case "amex":
		case "american express":
			enterAmexCardCVC();
			break;
		default:
			enterMasterCardCVC();
		}

		driver.switchTo().defaultContent();

	}

	public void selectAcceleratedShipping() throws InterruptedException {
		scrollToElement(tabAcceleratedShipping);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(tabAcceleratedShipping)).click();
		Thread.sleep(1000);
	}

	public void selectNormalShipping() throws InterruptedException {
		scrollToElement(tabNormalShipping);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(tabNormalShipping)).click();
		Thread.sleep(1000);
	}

	public void acceptMedicalWaiver() throws InterruptedException {

		scrollToElement(sectionMedicalWaiver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(radioBtnAcceptWaiver)).click();
	}

	public ReviewPage clickContinueToReviewButton() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueToReview)).click();

		return reviewPage;
	}

	private void selectState(String state) throws InterruptedException {

		// Thread.sleep(1500);
		WebDriverWait stateWait = new WebDriverWait(driver, Duration.ofSeconds(3));

		switch (state.toUpperCase()) {

		case "AL":
		case "ALABAMA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionAlbama)).click();
			break;

		case "AK":
		case "ALASKA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionAlaska)).click();
			break;

		case "AZ":
		case "ARIZONA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionArizona)).click();
			break;

		case "AR":
		case "ARKANSAS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionArkansas)).click();
			break;

		case "CA":
		case "CALIFORNIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionCalifornia)).click();
			break;

		case "CO":
		case "COLORADO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionColorado)).click();
			break;

		case "CT":
		case "CONNECTICUT":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionConnecticut)).click();
			break;

		case "DE":
		case "DELAWARE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionDelaware)).click();
			break;

		case "DC":
		case "DISTRICT OF COLUMBIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionDistrictOfColumbia)).click();
			break;

		case "FL":
		case "FLORIDA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionFlorida)).click();
			break;

		case "GA":
		case "GEORGIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionGeorgia)).click();
			break;

		case "HI":
		case "HAWAII":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionHawaii)).click();
			break;

		case "ID":
		case "IDAHO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionIdaho)).click();
			break;

		case "IL":
		case "ILLINOIS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionIllinois)).click();
			break;

		case "IN":
		case "INDIANA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionIndiana)).click();
			break;

		case "IA":
		case "IOWA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionIowa)).click();
			break;

		case "KS":
		case "KANSAS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionKansas)).click();
			break;

		case "KY":
		case "KENTUCKY":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionKentucky)).click();
			break;

		case "LA":
		case "LOUISIANA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionLouisiana)).click();
			break;

		case "ME":
		case "MAINE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMaine)).click();
			break;

		case "MD":
		case "MARYLAND":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMaryland)).click();
			break;

		case "MA":
		case "MASSACHUSETTS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMassachusetts)).click();
			break;

		case "MI":
		case "MICHIGAN":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMichigan)).click();
			break;

		case "MN":
		case "MINNESOTA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMinnesota)).click();
			break;

		case "MS":
		case "MISSISSIPPI":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMississippi)).click();
			break;

		case "MO":
		case "MISSOURI":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMissouri)).click();
			break;

		case "MT":
		case "MONTANA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionMontana)).click();
			break;

		case "NE":
		case "NEBRASKA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNebraska)).click();
			break;

		case "NV":
		case "NEVADA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNevada)).click();
			break;

		case "NH":
		case "NEW HAMPSHIRE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNewhampshire)).click();
			break;

		case "NJ":
		case "NEW JERSEY":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNewjersey)).click();
			break;

		case "NM":
		case "NEW MEXICO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNewmexico)).click();
			break;

		case "NY":
		case "NEW YORK":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNewyork)).click();
			break;

		case "NC":
		case "NORTH CAROLINA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNorthcarolina)).click();
			break;

		case "ND":
		case "NORTH DAKOTA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionNorthdakota)).click();
			break;

		case "OH":
		case "OHIO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionOhio)).click();
			break;

		case "OK":
		case "OKLAHOMA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionOklahoma)).click();
			break;

		case "OR":
		case "OREGON":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionOregon)).click();
			break;

		case "PA":
		case "PENNSYLVANIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionPennsylvania)).click();
			break;

		case "RI":
		case "RHODE ISLAND":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionRhodeisland)).click();
			break;

		case "SC":
		case "SOUTH CAROLINA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionSouthcarolina)).click();
			break;

		case "SD":
		case "SOUTH DAKOTA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionSouthdakota)).click();
			break;

		case "TN":
		case "TENNESSEE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionTennessee)).click();
			break;

		case "TX":
		case "TEXAS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionTexas)).click();
			break;

		case "UT":
		case "UTAH":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionUtah)).click();
			break;

		case "VT":
		case "VERMONT":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionVermont)).click();
			break;

		case "VA":
		case "VIRGINIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionVirginia)).click();
			break;

		case "WA":
		case "WASHINGTON":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionWashington)).click();
			break;

		case "WV":
		case "WEST VIRGINIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionWestvirginia)).click();
			break;

		case "WI":
		case "WISCONSIN":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionWisconsin)).click();
			break;

		case "WY":
		case "WYOMING":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownStateOptionWyoming)).click();
			break;

		}

	}

	public void enterEditedEmail() {

		wait.until(ExpectedConditions.visibilityOf(inputAccountEmail));
		inputAccountEmail.clear();
		inputAccountEmail.sendKeys(prop.getProperty("EditedEmail"));
		setEnteredCustomerEmailID(prop.getProperty("EditedEmail"));
	}

	public void editPersonalDeatils() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(inputAccountEmail));

		// Entering Personal Details for the User
		enterEditedEmail();

		// Will develop when required

		// enterEditedFirstName();
		// enterEditedLastName();
		// enterEditedPhoneNumber();

	}

	public void selectBreadFinancing() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(breadFinancing));
		scrollToElement(breadFinancing);
		System.out.println("after scroll to finance button");
		wait.until(ExpectedConditions.elementToBeClickable(breadFinancing)).click();

	}

	public void selectPaypalFinancing() throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(paypalRadioButton));
		scrollToElement(paypalRadioButton);

		System.out.println("after scroll to paypal radio button");
		wait.until(ExpectedConditions.elementToBeClickable(paypalRadioButton)).click();

	}

	public void selectCreditCardPayment() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", creditCardRadioButton);

		Thread.sleep(1000);
		System.out.println("after scroll to creditcard radio button");
		creditCardRadioButton.click();

	}

	private String GivenPaymentMethod;

	public void setGivenPaymentMethod(String givenpaymentMethod) {
		System.out.println("given payment is = " + givenpaymentMethod + "is inside setGivenPaymentMethod");
		this.GivenPaymentMethod = givenpaymentMethod;

	}

	public String getGivenPaymentMethod() {
		System.out.println("getGivenPaymentMethod = " + GivenPaymentMethod);
		return this.GivenPaymentMethod;
	}

	public void selectPaymentDetails(String paymentMethod) throws InterruptedException {

		System.out.println("inside select paymentdetails =" + paymentMethod);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(inputAccountEmail));

		switch (paymentMethod.toUpperCase()) {
		case "BREAD":
			System.out.println("inside selectpaymentdetails - for BREAD");
			selectBreadFinancing();
			System.out.println("After selecting BREAD radiobutton");
			break;
		case "PAYPAL":
			System.out.println("inside selectpaymentdetails - for PAYPAL");
			selectPaypalFinancing();
			System.out.println("After selecting PAYPAL radiobutton");
			break;
		case "INVALID CARD":
			selectCreditCardPayment();
			System.out.println("Inside select payment details visa / master / amex / creditcard = " + paymentMethod);
			enterPaymentDetails(paymentMethod);
			break;
		case "WRONG CVC":
			break;
		case "VISA":
		case "MASTER CARD":
		case "AMEX":
		case "CREDIT CARD":
		case "DEBIT CARD":
		case "JCB":
		default:
			selectCreditCardPayment();
			System.out.println("Inside select payment details visa / master / amex / creditcard = " + paymentMethod);
			enterPaymentDetails(paymentMethod);
			break;
		}

		// reviewPage = clickContinueToReviewButton();

	}

	public String getInvalidCardPaymentErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		return invalidCardErrorMsg.getText();
	}

	public String getExpiredCardPaymentErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		return expiredCardErrorMsg.getText();
	}

	public void enterPersonalDeatilsWithInvalidPhone(String phoneNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(inputAccountEmail));

		// Entering Personal Details for the User
		enterEmail();
		enterFirstName();
		enterLastName();
		enterInvalidPhoneNumber(phoneNumber);
	}

	public String getInvalidPhoneNumberErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		return invalidPhoneNumberErrorMSG.getText();
	}

	public String getInvalidStateZipCodeComboErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		return invalidStateZipCodeErrorMSG.getText();
	}

	public void setIsBreadPaymentMethodDisplayed() throws InterruptedException {
		// TODO Auto-generated method stub
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", creditCardRadioButton);

		Thread.sleep(1000);

		try {

			this.isBreadPaymentMethodDisplayed = breadFinancing.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Bread Payment isn't displayed.");
			this.isBreadPaymentMethodDisplayed = false;
		}

	}

	public boolean getIsBreadPaymentMethodDisplayed() {
		return this.isBreadPaymentMethodDisplayed;
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

	public void setEnteredCustomerEmailID(String emailID) {
		this.enteredCustomerEmailID = emailID ;
	}
	
	public String getEnteredCustomerEmailID() {
		return enteredCustomerEmailID;
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		System.out.println("setexpectedDeliveryDate = " + expectedDeliveryDate);
		this.expectedDeliveryDate = expectedDeliveryDate;
	}
	
	public String getExpectedDeliveryDate() {
		System.out.println("getexpectedDeliveryDate = " + expectedDeliveryDate);
		return expectedDeliveryDate;
	}
	
	public void calculateEstimatedDeliveryDate(String deliveryBy) throws InterruptedException {
				
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE, MMMMM d, yyyy");
		Calendar cal = Calendar.getInstance();
		
		
		if(deliveryBy.equalsIgnoreCase("1-2 business days")) {
			
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			System.out.println("dayOfWeek =" +dayOfWeek);
			
				if(dayOfWeek > 4 ) {
					
					cal.add(Calendar.DAY_OF_MONTH, 4);  
					
					//Date after adding 4 day to the current date
					String newDate = sdf.format(cal.getTime());  
					
					//Displaying the new Date after addition of 1 Day
					System.out.println("Date after adding 4 day to the current date = "+newDate);
					
					setExpectedDeliveryDate(newDate);
					
				}else if(dayOfWeek <= 4 ) {
					
					cal.add(Calendar.DAY_OF_MONTH, 3);  
					
					//Date after adding 3 day to the current date
					String newDate = sdf.format(cal.getTime());  
					
					//Displaying the new Date after addition of 1 Day
					System.out.println("Date after adding 3 day to the current date = "+newDate);
					
					setExpectedDeliveryDate(newDate);
				
				}
			
		}else {
			
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			
			if(dayOfWeek > 2 ) {
				
				cal.add(Calendar.DATE, 6);
				
				//Date after adding 6 day to the current date
				String newDate = sdf.format(cal.getTime());  
				
				//Displaying the new Date after addition of 1 Day
				System.out.println("Date after adding 6 day to the current date = "+newDate);
				
				setExpectedDeliveryDate(newDate);
				
			}else if(dayOfWeek <= 2 ) {
				
				cal.add(Calendar.DATE, 5);
				//Date after adding 5 day to the current date
				String newDate = sdf.format(cal.getTime());  
				
				//Displaying the new Date after addition of 1 Day
				System.out.println("Date after adding 5 day to the current date = "+newDate);
				
				setExpectedDeliveryDate(newDate);
				
			}
			
				
		}
	
	}
}
