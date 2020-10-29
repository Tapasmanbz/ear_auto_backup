package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsuranceCheckoutPage extends BasePage {

	public InsuranceCheckoutPage() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	SalesforcePage salesforcePage = new SalesforcePage();
	ReviewPage reviewPage = new ReviewPage();

	// My Information
	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[1]/p[1]")
	public WebElement accountName;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[1]/p[2]")
	public WebElement accountEmail;

	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']/div[1]/p[3]")
	public WebElement accountPhoneNumber;

	// Shipping my Eargo to
	@FindBy(how = How.XPATH, using = "//div[@class='yourAccount']//span[text()='Name']/following-sibling::p")
	public WebElement shippingName;

	@FindBy(how = How.ID, using = "address1")
	public WebElement inputShippingAddress;

	@FindBy(how = How.ID, using = "address2")
	public WebElement inputShippingAptSuite;

	@FindBy(how = How.ID, using = "city")
	public WebElement inputShippingCity;

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

	// Delivery Method
	@FindBy(how = How.XPATH, using = "//button[@type='button' and contains(text(),'1-2 Business Days')]")
	public WebElement tabAcceleratedShipping;

	// Covered By
	@FindBy(how = How.XPATH, using = "//span[text()='Covered by']/following-sibling::div/div")
	public WebElement coveredBy;

	// Medical Waiver
	@FindBy(how = How.ID, using = "waiver_section")
	public WebElement sectionMedicalWaiver;

	@FindBy(how = How.XPATH, using = "//label[@class='waiver_radioButton bold waiver_agree']//img")
	public WebElement radioBtnAcceptWaiver;

	@FindBy(how = How.ID, using = "continue-to-review-button")
	public WebElement btnPlaceOrder;

	// Order Summary
	@FindBy(how = How.XPATH, using = "//div[@id='fixed']//div[text()='Order Summary']")
	public WebElement sectionOrderSummary;

	@FindBy(how = How.XPATH, using = "//h1[contains(@class,'productName')]")
	public WebElement productName;

	@FindBy(how = How.XPATH, using = "//label[text()='Subtotal']/parent::div")
	public WebElement productSubTotal;

	@FindBy(how = How.XPATH, using = "//label[text()='Discount']/parent::div")
	public WebElement eargoDiscount;

	@FindBy(how = How.XPATH, using = "//label[text()='FEHB Benefit']/parent::div")
	public WebElement fehbBenefit;

	@FindBy(how = How.XPATH, using = "//label[text()='Shipping']/parent::div")
	public WebElement shippingCharges;

	@FindBy(how = How.XPATH, using = "//label[text()='Tax']/parent::div")
	public WebElement taxApplied;

	@FindBy(how = How.XPATH, using = "//label[text()='Estimated Total']/parent::div")
	public WebElement estimatedTotal;

	@FindBy(how = How.XPATH, using = "//button[@id='continue-to-review-button']/following-sibling::div/div/div[1]")
	public WebElement packageContains;

	@FindBy(how = How.XPATH, using = "//button[@id='continue-to-review-button']/following-sibling::div/div/div[2]")
	public WebElement returnDuration;

	@FindBy(how = How.XPATH, using = "//button[@id='continue-to-review-button']/following-sibling::div/div/div[3]")
	public WebElement productWarranty;

	@FindBy(how = How.XPATH, using = "//button[@id='continue-to-review-button']/following-sibling::div/div/div[4]")
	public WebElement productSupport;

	public String getAcccountName() {

		wait.until(ExpectedConditions.visibilityOf(accountName));
		return accountName.getText();
	}

	public String getAccountEmail() {

		wait.until(ExpectedConditions.visibilityOf(accountEmail));
		return accountEmail.getText();
	}

	public String getAccountPhoneNumber() {

		wait.until(ExpectedConditions.visibilityOf(accountPhoneNumber));
		return accountPhoneNumber.getText();
	}

	public String getShippingName() {

		wait.until(ExpectedConditions.visibilityOf(shippingName));
		return shippingName.getText();

	}

	public boolean isShippingStreetDisplayed() {
		return inputShippingAddress.isDisplayed();
	}

	public void enterShippingStreet() {

		inputShippingAddress.sendKeys(prop.getProperty("shippingStreetAddress"));

	}

	public boolean isShippingAptSuiteDisplayed() {
		return inputShippingAptSuite.isDisplayed();
	}


	public boolean isShippingCityDisplayed() {
		return inputShippingCity.isDisplayed();
	}

	public void enterShippingCity() {

		inputShippingCity.sendKeys(prop.getProperty("shippingCity"));
	}

	public boolean isShippingZipcodeDisplayed() {
		return dropdownShippingZipCode.isDisplayed();
	}

	public void enterShippingZipCode(String zipCode) {

		dropdownShippingZipCode.sendKeys(zipCode);
	}

	public boolean isShippingStateDropDownDisplayed() {
		return dropdownShippingState.isDisplayed();
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
		enterShippingStreet();
		enterShippingCity();
		clickShippingStateDropdown();
		selectState(state);
		enterShippingZipCode(zipCode);

	}

	public boolean isAcceleratedShippingDisplayed() {
		try {
			return tabAcceleratedShipping.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isCoveredByDisplayed(String insuranceProvider) {
		boolean isCoveredByDisplayed = false;
		try {
			scrollToElement(coveredBy);
			System.out.println("coveredBy:" + coveredBy.getText());
			switch (insuranceProvider.toLowerCase()) {

			case "bcbs":
				isCoveredByDisplayed = coveredBy.getText().contains("Blue Cross / Blue Shield FEP");
				break;
			default:
				isCoveredByDisplayed = coveredBy.getText().contains(insuranceProvider);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return isCoveredByDisplayed;
	}

	public boolean isMedicalWaiverDisplayed() {
		try {
			scrollToElement(sectionMedicalWaiver);
			return radioBtnAcceptWaiver.isDisplayed();
		} catch (NoSuchElementException e) {

		} catch (InterruptedException e) {

		}
		return false;

	}

	public void acceptMedicalWaiver() throws InterruptedException {

		scrollToElement(sectionMedicalWaiver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(radioBtnAcceptWaiver)).click();
	}

	public ReviewPage clickPlaceOrderButton() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(btnPlaceOrder)).click();

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

	// Order Summary
	public boolean isOrderSummarySectionDisplayed() {
		return sectionOrderSummary.isDisplayed();
	}

	public String getProduct() {
		return productName.getText();
	}

	public String getProductSubTotal() {
		return productSubTotal.getText().split("\n")[1];
	}

	public boolean isEargoDiscountPresent() {
		return eargoDiscount.isDisplayed();
	}

	public String getFEHBDiscount() {
		return fehbBenefit.getText().split("\n")[1];
	}

	public boolean isTaxPresent() {
		return taxApplied.isDisplayed();
	}

	public String getEstimatedTotal() {
		return estimatedTotal.getText().split("\n")[1];
	}

}
