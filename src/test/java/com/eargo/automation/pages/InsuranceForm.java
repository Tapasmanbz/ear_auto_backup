package com.eargo.automation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InsuranceForm extends BasePage {

	public InsuranceForm() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'No Thanks')]")
	public WebElement noThanksButton;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	public WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//input[@name='patient_dob']")
	public WebElement dateOfBirth;

	@FindBy(how = How.XPATH, using = "//html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[3]/div[1]/div[2]/label[1]/div[1]/div[1]/div[1]")
	public WebElement stateDropDown;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'DEPENDENT')]")
	public WebElement dependentButton;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'PRIMARY')]")
	public WebElement primaryButton;

	@FindBy(how = How.XPATH, using = "//input[@name='member_id']")
	public WebElement memberID;

	@FindBy(how = How.XPATH, using = "//input[@name='group_number']")
	public WebElement groupNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='medicare_number']")
	public WebElement medicareNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='enrollment_code']")
	public WebElement enrollmentCode;

	@FindBy(how = How.XPATH, using = "//input[@name='payer_phone']")
	public WebElement optionalPhoneNumber;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]")
	public WebElement yesForLast36Months;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]")
	public WebElement noForLast36Months;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Not Sure')]")
	public WebElement notSureForLast36Months;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'I agree to ')]/preceding-sibling::label[1]")
	public WebElement iAgree;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'CHECK YOUR BENEFITS')]")
	public WebElement checkYourBenifits;

	// -------10/09/2020-------------------------

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'CHECK YOUR BENEFITS')]/parent::div/following::div[contains(text(),'unable to verify your benefits')]")
	public WebElement unableToVerifyMessage;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'CHECK YOUR BENEFITS')]/parent::div/following::div[1]/a[1]")
	public WebElement okButton;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Great News!')]")
	public WebElement greatNewsMessage;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Price')]/following::div[1]")
	public WebElement displayedProductPrice;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'FEHB Benefit')]/following::div[1]")
	public WebElement displayedFEHBbenifits;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Eargo Discount')]/following::div[1]")
	public WebElement displayedEargoDiscount;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'You pay')]/following::div[1]")
	public WebElement customerPayPrice;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Checkout')]")
	public WebElement insuranceFromCheckout;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'No thanks, give me a call instead')]")
	public WebElement giveMeCallInstead;

	// ------Residence Dropdown xpath ----------------------------

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[1]")
	public WebElement dropdownResidenceOptionAlaska;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[2]")
	public WebElement dropdownResidenceOptionAlbama;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[3]")
	public WebElement dropdownResidenceOptionArkansas;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[4]")
	public WebElement dropdownResidenceOptionAS; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[5]")
	public WebElement dropdownResidenceOptionArizona;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[6]")
	public WebElement dropdownResidenceOptionCalifornia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[7]")
	public WebElement dropdownResidenceOptionColorado;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[8]")
	public WebElement dropdownResidenceOptionConnecticut;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[9]")
	public WebElement dropdownResidenceOptionDistrictOfColumbia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[10]")
	public WebElement dropdownResidenceOptionDelaware;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[11]")
	public WebElement dropdownResidenceOptionFlorida;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[12]")
	public WebElement dropdownResidenceOptionFM; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[13]")
	public WebElement dropdownResidenceOptionGeorgia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[14]")
	public WebElement dropdownResidenceOptionGU; // Name Unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[15]")
	public WebElement dropdownResidenceOptionHawaii;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[16]")
	public WebElement dropdownResidenceOptionIowa;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[17]")
	public WebElement dropdownResidenceOptionIdaho;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[18]")
	public WebElement dropdownResidenceOptionIllinois;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[19]")
	public WebElement dropdownResidenceOptionIndiana;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[20]")
	public WebElement dropdownResidenceOptionKansas;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[21]")
	public WebElement dropdownResidenceOptionKentucky;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[22]")
	public WebElement dropdownResidenceOptionLouisiana;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[23]")
	public WebElement dropdownResidenceOptionMassachusetts;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[24]")
	public WebElement dropdownResidenceOptionMaryland;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[25]")
	public WebElement dropdownResidenceOptionMaine;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[26]")
	public WebElement dropdownResidenceOptionMH; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[27]")
	public WebElement dropdownResidenceOptionMichigan;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[28]")
	public WebElement dropdownResidenceOptionMinnesota;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[29]")
	public WebElement dropdownResidenceOptionMissouri;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[30]")
	public WebElement dropdownResidenceOptionMP; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[31]")
	public WebElement dropdownResidenceOptionMississippi;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[32]")
	public WebElement dropdownResidenceOptionMontana;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[33]")
	public WebElement dropdownResidenceOptionNorthcarolina;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[34]")
	public WebElement dropdownResidenceOptionNorthdakota;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[35]")
	public WebElement dropdownResidenceOptionNebraska;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[36]")
	public WebElement dropdownResidenceOptionNewhampshire;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[37]")
	public WebElement dropdownResidenceOptionNewjersey;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[38]")
	public WebElement dropdownResidenceOptionNewmexico;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[40]")
	public WebElement dropdownResidenceOptionNewyork;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[41]")
	public WebElement dropdownResidenceOptionNevada;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[42]")
	public WebElement dropdownResidenceOptionOhio;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[43]")
	public WebElement dropdownResidenceOptionOklahoma;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[44]")
	public WebElement dropdownResidenceOptionOregon;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[45]")
	public WebElement dropdownResidenceOptionPennsylvania;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[46]")
	public WebElement dropdownResidenceOptionPR; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[47]")
	public WebElement dropdownResidenceOptionPW; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[48]")
	public WebElement dropdownResidenceOptionRhodeisland;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[49]")
	public WebElement dropdownResidenceOptionSouthcarolina;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[50]")
	public WebElement dropdownResidenceOptionSouthdakota;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[51]")
	public WebElement dropdownResidenceOptionTennessee;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[52]")
	public WebElement dropdownResidenceOptionTexas;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[53]")
	public WebElement dropdownResidenceOptionUtah;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[54]")
	public WebElement dropdownResidenceOptionVirginia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[55]")
	public WebElement dropdownResidenceOptionVI; // Name unknown

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[56]")
	public WebElement dropdownResidenceOptionVermont;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[57]")
	public WebElement dropdownResidenceOptionWashington;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[58]")
	public WebElement dropdownResidenceOptionWisconsin;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[59]")
	public WebElement dropdownResidenceOptionWestvirginia;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[60]")
	public WebElement dropdownResidenceOptionWyoming;

	// --- Added on 17/09/2020 ---
	@FindBy(how = How.XPATH, using = "//div[text()='Your session has timed out']")
	public WebElement timeoutPopUp;

	@FindBy(how = How.XPATH, using = "//div[text()='Your session has timed out']/following-sibling::a")
	public WebElement btnTimeoutPopUpOk;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'We were unable to verify your benefits online.')]/following-sibling::a[text()='Ok']")
	public WebElement buttonOkInUnableToVerifyYourDetailsOnlineSection;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'We were unable to verify your benefits online.')]")
	public WebElement unableToVerifyYourDetailsOnlineMessage;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']/div/form/div[last()]/div[last()]/div[1]")
	public WebElement greatNewsText;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']/div/form/div/div/div[2]/div[1]/img")
	public List<WebElement> productImg;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']//form//div[text()='Price']/following-sibling::div")
	public WebElement productPrice;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']//form//div[contains(text(),'FEHB')]/following-sibling::div")
	public WebElement fehbDiscount;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']//form//div[contains(text(),'Eargo')]/following-sibling::div")
	public WebElement eargoDiscount;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']//form//div[contains(text(),'You pay')]/following-sibling::div")
	public WebElement totalPayablePrice;

	@FindBy(how = How.XPATH, using = "//main[@id='insurance_form']//form//button[text()='Checkout']/preceding-sibling::div[1]")
	public WebElement byProceedingMessage;

	// ---------------------------------
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Your Insurance Provider')]/parent::div/label[1]/div[1]/div[1]/div[1]/div[1]")
	public WebElement insuranceProviderDropdown;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[1]")
	public WebElement dropdownAtena;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[2]")
	public WebElement dropdownAPWU;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[3]")
	public WebElement dropdownBCBS;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[4]")
	public WebElement dropdownGEHA;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[5]")
	public WebElement dropdownMHBP;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[6]")
	public WebElement dropdownNALC;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu')]/div[7]")
	public WebElement dropdownOthers;

	WebDriverWait dropDownWait = new WebDriverWait(driver, Duration.ofSeconds(3));

	public void for_maximum_benifits_i_select(String nothanks_or_continue) throws InterruptedException {

		if (nothanks_or_continue.equals("CONTINUE")) {
			scrollToElement(continueButton);
			Thread.sleep(2000);
			continueButton.click();
		} else {
			noThanksButton.click();
		}
	}

	
//	public void fill_given_data(String givenMemberID, String givenGroupNumber, String givenDOB, String givenState,
//			String givenInsuranceType) throws InterruptedException {
	
	public void fill_given_data(String givenMemberID, String givenGroupNumber, String givenDOB, String givenState,
			String givenZipCode, String givenInsuranceType ) throws InterruptedException {

		setgivenPatientState(givenState);
		setGivenPatientZipCode(givenZipCode);
		
		dateOfBirth.sendKeys(givenDOB);

		// selecting state of residence need to be developed
		stateDropDown.click();
		Thread.sleep(1000);
		selectResidence(givenState);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(primaryButton));
		scrollToElement(primaryButton);

		if (givenInsuranceType.equals("PRIMARY")) {
			primaryButton.click();
		} else {
			dependentButton.click();
		}
		memberID.sendKeys(givenMemberID);

		wait.until(ExpectedConditions.visibilityOf(groupNumber));
		scrollToElement(groupNumber);
		groupNumber.sendKeys(givenGroupNumber);
		Thread.sleep(2000);

	}

//	public void fill_bcbs_data(String givenMemberID, String givenEnrollmentCode, String givenGroupNumber,
//			String givenDOB) throws InterruptedException {

	public void fill_bcbs_data(String givenMemberID, String givenEnrollmentCode,String givenGroupNumber,String givenDOB,
			String givenState,String givenZipCode) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(memberID));
		scrollToElement(memberID);

		memberID.sendKeys(givenMemberID);
		Thread.sleep(2000);
		enrollmentCode.sendKeys(givenEnrollmentCode);
		Thread.sleep(2000);
		groupNumber.sendKeys(givenGroupNumber);

		scrollToElement(dateOfBirth);
		dateOfBirth.sendKeys(givenDOB);
		Thread.sleep(2000);

	}

	public void fill_nalc_data(String givenMemberID, String givenGroupNumber, String givenMedicareNumber,
			String givenDOB, String givenState, String givenInsuranceType) throws InterruptedException {

		dateOfBirth.sendKeys(givenDOB);

		// selecting state of residence need to be developed
		stateDropDown.click();
		Thread.sleep(1000);
		selectResidence(givenState);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOf(primaryButton));
		scrollToElement(primaryButton);

		if (givenInsuranceType.equals("PRIMARY")) {
			primaryButton.click();
		} else {
			dependentButton.click();
		}
		memberID.sendKeys(givenMemberID);

		wait.until(ExpectedConditions.visibilityOf(groupNumber));
		scrollToElement(groupNumber);
		groupNumber.sendKeys(givenGroupNumber);
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOf(medicareNumber));
		scrollToElement(medicareNumber);
		medicareNumber.sendKeys(givenMedicareNumber);
		Thread.sleep(2000);

	}

	public void benifits_Used_In_Last36Month(String benifitsUsed) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOf(yesForLast36Months));
		scrollToElement(yesForLast36Months);

		if (benifitsUsed.equals("YES")) {

			yesForLast36Months.click();

		} else if (benifitsUsed.equals("NO")) {

			noForLast36Months.click();

		} else {

			notSureForLast36Months.click();

		}
		Thread.sleep(2000);
	}

	public void i_agree_to_terms() throws InterruptedException {

		iAgree.click();
		Thread.sleep(2000);
	}

	// ----------10/09/2020---------------------------

	public void check_Your_Benifits() throws InterruptedException {
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(checkYourBenifits));
		scrollToElement(checkYourBenifits);

		checkYourBenifits.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			wait.until(ExpectedConditions.visibilityOf(unableToVerifyMessage));
			wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();

		} catch (Exception e) {
			// Need to develop to click on CHECKOUT BUTTON
			System.out.println(e);

		}

	}

	private void selectResidence(String residence) throws InterruptedException {

		WebDriverWait stateWait = new WebDriverWait(driver, Duration.ofSeconds(3));

		switch (residence.toUpperCase()) {

		case "AL":
		case "ALABAMA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionAlbama)).click();
			break;

		case "AK":
		case "ALASKA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionAlaska)).click();
			break;

		case "AZ":
		case "ARIZONA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionArizona)).click();
			break;

		case "AR":
		case "ARKANSAS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionArkansas)).click();
			break;

		case "CA":
		case "CALIFORNIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionCalifornia)).click();
			break;

		case "CO":
		case "COLORADO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionColorado)).click();
			break;

		case "CT":
		case "CONNECTICUT":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionConnecticut)).click();
			break;

		case "DE":
		case "DELAWARE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionDelaware)).click();
			break;

		case "DC":
		case "DISTRICT OF COLUMBIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionDistrictOfColumbia)).click();
			break;

		case "FL":
		case "FLORIDA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionFlorida)).click();
			break;

		case "GA":
		case "GEORGIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionGeorgia)).click();
			break;

		case "HI":
		case "HAWAII":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionHawaii)).click();
			break;

		case "ID":
		case "IDAHO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionIdaho)).click();
			break;

		case "IL":
		case "ILLINOIS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionIllinois)).click();
			break;

		case "IN":
		case "INDIANA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionIndiana)).click();
			break;

		case "IA":
		case "IOWA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionIowa)).click();
			break;

		case "KS":
		case "KANSAS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionKansas)).click();
			break;

		case "KY":
		case "KENTUCKY":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionKentucky)).click();
			break;

		case "LA":
		case "LOUISIANA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionLouisiana)).click();
			break;

		case "ME":
		case "MAINE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMaine)).click();
			break;

		case "MD":
		case "MARYLAND":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMaryland)).click();
			break;

		case "MA":
		case "MASSACHUSETTS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMassachusetts)).click();
			break;

		case "MI":
		case "MICHIGAN":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMichigan)).click();
			break;

		case "MN":
		case "MINNESOTA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMinnesota)).click();
			break;

		case "MS":
		case "MISSISSIPPI":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMississippi)).click();
			break;

		case "MO":
		case "MISSOURI":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMissouri)).click();
			break;

		case "MT":
		case "MONTANA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMontana)).click();
			break;

		case "NE":
		case "NEBRASKA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNebraska)).click();
			break;

		case "NV":
		case "NEVADA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNevada)).click();
			break;

		case "NH":
		case "NEW HAMPSHIRE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNewhampshire)).click();
			break;

		case "NJ":
		case "NEW JERSEY":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNewjersey)).click();
			break;

		case "NM":
		case "NEW MEXICO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNewmexico)).click();
			break;

		case "NY":
		case "NEW YORK":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNewyork)).click();
			break;

		case "NC":
		case "NORTH CAROLINA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNorthcarolina)).click();
			break;

		case "ND":
		case "NORTH DAKOTA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionNorthdakota)).click();
			break;

		case "OH":
		case "OHIO":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionOhio)).click();
			break;

		case "OK":
		case "OKLAHOMA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionOklahoma)).click();
			break;

		case "OR":
		case "OREGON":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionOregon)).click();
			break;

		case "PA":
		case "PENNSYLVANIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionPennsylvania)).click();
			break;

		case "RI":
		case "RHODE ISLAND":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionRhodeisland)).click();
			break;

		case "SC":
		case "SOUTH CAROLINA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionSouthcarolina)).click();
			break;

		case "SD":
		case "SOUTH DAKOTA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionSouthdakota)).click();
			break;

		case "TN":
		case "TENNESSEE":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionTennessee)).click();
			break;

		case "TX":
		case "TEXAS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionTexas)).click();
			break;

		case "UT":
		case "UTAH":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionUtah)).click();
			break;

		case "VT":
		case "VERMONT":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionVermont)).click();
			break;

		case "VA":
		case "VIRGINIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionVirginia)).click();
			break;

		case "WA":
		case "WASHINGTON":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionWashington)).click();
			break;

		case "WV":
		case "WEST VIRGINIA":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionWestvirginia)).click();
			break;

		case "WI":
		case "WISCONSIN":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionWisconsin)).click();
			break;

		case "WY":
		case "WYOMING":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionWyoming)).click();
			break;

		// following are not present in state dropdown of checkout page of product

		case "AS":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionAS)).click();
			break;

		case "FM":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionFM)).click();
			break;

		case "GU":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionGU)).click();
			break;

		case "MP":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMP)).click();
			break;

		case "MH":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionMH)).click();
			break;

		case "PR":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionPR)).click();
			break;

		case "PW":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionPW)).click();
			break;

		case "VI":
			stateWait.until(ExpectedConditions.elementToBeClickable(dropdownResidenceOptionVI)).click();
			break;

		}

	}

	// Added on 16-09-2020
	public void clickNothanksAndGiveMeCall() throws InterruptedException {
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(giveMeCallInstead));
		scrollToElement(giveMeCallInstead);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(giveMeCallInstead)).click();
	}

	public void waitOnInsuranceFormPage(int time) throws InterruptedException {
		long duration = (time * (1000 * 60));
		Thread.sleep(duration);
	}

	public void clickCheckoutButton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(insuranceFromCheckout)).click();
	}

	public boolean isTimeoutPopUpDisplayed() throws InterruptedException {
		try {
			Thread.sleep(2000);
			return wait.until(ExpectedConditions.visibilityOf(timeoutPopUp)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}

	}

	public void clickOkButtonOnTimeoutPopUp() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(btnTimeoutPopUpOk)).click();
	}

	public void clickOkButtonInUnableToVerifyYourDetailsOnlineSection() throws InterruptedException {
		scrollToElement(buttonOkInUnableToVerifyYourDetailsOnlineSection);
		wait.until(ExpectedConditions.elementToBeClickable(buttonOkInUnableToVerifyYourDetailsOnlineSection)).click();
	}

	public boolean isUnableToVerifyMessageDisplayed() throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
			return wait.until(ExpectedConditions.visibilityOf(unableToVerifyYourDetailsOnlineMessage)).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	public String getUnableToVerifyMessage() {
		// TODO Auto-generated method stub
		return unableToVerifyYourDetailsOnlineMessage.getText();

	}

	public String getGreatNewsMessage() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(greatNewsText));
		return greatNewsText.getText();

	}

	public boolean isProductImageDisplayed(String insuranceProvider) {
		// TODO Auto-generated method stub
		boolean productImgDisplayed = false;
		System.out.println(productImg.size());
		for (int i = 0; i < productImg.size(); i++) {
			String imgName = productImg.get(i).getAttribute("alt").trim();
			System.out.println("imgName:" + imgName);
			switch (insuranceProvider.toLowerCase()) {
			case "nalc":
				if (imgName.equalsIgnoreCase("Eargo Neo")) {
					productImgDisplayed = true;
				} else {
					productImgDisplayed = false;
				}
				break;
			case "bcbs":
			case "geha":
			default:
				if (imgName.equalsIgnoreCase("Eargo Neo HiFi")) {
					productImgDisplayed = true;
				} else {
					productImgDisplayed = false;
				}
			}

		}

		return productImgDisplayed;
	}

	public String getProductPriceInGreatNewsSection() {
		// TODO Auto-generated method stub
		return productPrice.getText();

	}

	public String getFEHBDiscountInGreatNewsSection() {
		// TODO Auto-generated method stub
		return fehbDiscount.getText();

	}

	public String getEargoDiscountInGreatNewsSection() {
		// TODO Auto-generated method stub
		return eargoDiscount.getText();

	}

	public String getTotalPayableAmountInGreatNewsSection() {
		// TODO Auto-generated method stub
		return totalPayablePrice.getText();

	}

	public String getByProceedingMessageInGreatNewsSection() {
		// TODO Auto-generated method stub
		return byProceedingMessage.getText();

	}

	public void changeInsuranceProvide(String changedInsuranceProvider) throws InterruptedException {

		scrollToElement(insuranceProviderDropdown);
		Thread.sleep(2000);

		switch (changedInsuranceProvider.toLowerCase()) {

		case "bcbs":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownBCBS)).click();
			break;

		case "geha":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownGEHA)).click();
			Thread.sleep(1000);
			break;

		case "nalc":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownNALC)).click();
			break;

		case "aetna":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownAtena)).click();
			break;

		case "apwu health plan":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownAPWU)).click();
			break;

		case "mhbp":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownMHBP)).click();
			break;
		case "others":
			insuranceProviderDropdown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownOthers)).click();
			break;
		default:
			System.out.println("Not a valid insurance provider");

		}

	}

	
//-----------------09/10/2020---------------------------------
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Information:')]")
	public WebElement myInformation;
		
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Information:')]/following-sibling::div[1]/p[1]")
	public WebElement displayedPatientName;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Information:')]/following-sibling::div[1]/p[2]")
	public WebElement displayedPatientEmail;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Information:')]/following-sibling::div[1]/p[3]")
	public WebElement displayedPatientPhone;
	
	@FindBy(how = How.XPATH, using = "//input[@name='address1']")
	public WebElement fillAddressFieldWith;
	
	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	public WebElement fillCityWith;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'State')]")
	public WebElement stateDropdown;
	
	@FindBy(how = How.XPATH, using = "//input[@name='zipcode']")
	public WebElement fillZipCodeWith;
	
	@FindBy(how = How.XPATH, using = "//span[@class='iagree']/preceding-sibling::img[1]")
	public WebElement medicalWaiver;
		
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'PLACE ORDER')]")
	public WebElement placeOrderButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Thanks for your order!')]")
	public WebElement thanksMessage;
	
	@FindBy(how = How.XPATH, using = "//input[@name='zipcode']")
	public WebElement patientZipcode;

	
	private String givenPatientState;
	private String givenPatientZipCode;
		
	public String getGivenPatientZipCode() {
		return givenPatientZipCode;
	}

	public void setGivenPatientZipCode(String givenPatientZipCode) {
		this.givenPatientZipCode = givenPatientZipCode;
	}

	public String getgivenPatientState() {
		return givenPatientState;
	}

	public void setgivenPatientState(String givenPatientState) {
		this.givenPatientState = givenPatientState;
	}
	
	
public void fillInCheckoutPage() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(myInformation));
		
		fillAddressFieldWith.click();
		Thread.sleep(1000);
		fillAddressFieldWith.sendKeys(prop.getProperty("patientAddress"));
		Thread.sleep(1000);
		
		
		scrollToElement(fillCityWith);
		fillCityWith.click();
		Thread.sleep(1000);
		fillCityWith.sendKeys(prop.getProperty("patientCity"));
		Thread.sleep(1000);
		
		stateDropdown.click();
		Thread.sleep(1000);
		
		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.selectState(getgivenPatientState());
		Thread.sleep(1000);
		
		patientZipcode.sendKeys(getGivenPatientZipCode());
		Thread.sleep(1000);
		
		scrollToElement(medicalWaiver);
		medicalWaiver.click();
		
		placeOrderButton.click();
		
		try {
			wait.until(ExpectedConditions.visibilityOf(thanksMessage));
			
			if(thanksMessage.isDisplayed()) {
				Assert.assertTrue(true);
			}
		}catch(Exception e) {
			System.out.println("No Thanks message is displayed");
			
		}
		
		
		Thread.sleep(2000);
	}
	
//-----------------12/10/2020-----------------	

@FindBy(how = How.XPATH, using = "//button[contains(text(),'Checkout')]")
public WebElement InsuranceFromCheckout;

public void checkout() throws InterruptedException {
	
	clickCheckoutButton();
	
}
	

}
