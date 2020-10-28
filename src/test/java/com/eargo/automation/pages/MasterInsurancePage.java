package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MasterInsurancePage extends BasePage {

	SalesforcePage salesforcePage = new SalesforcePage();
	private String patientName;
	private String patientEmailAddress;
	private String patientPhoneNumber;

	WebDriverWait dropDownWait = new WebDriverWait(driver, Duration.ofSeconds(3));

	public MasterInsurancePage() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]")
	public WebElement sectionCommonInsurance;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Aetna')]")
	public WebElement commonInsuranceAetna;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Cigna')]")
	public WebElement commonInsuranceCigna;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'United Healthcare')]")
	public WebElement commonInsuranceUnitedHealthcare;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Blue Cross / Blue Shield Non-Federal Plans')]")
	public WebElement commonInsuranceBCBSNFEP;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Anthem')]")
	public WebElement commonInsuranceAnthem;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Medicare Advantage Plans')]")
	public WebElement commonInsuranceMedicareAdvantagePlans;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Trade or Union Health Benefit Plans')]")
	public WebElement commonInsuranceTradeOrUnionHealthBenefitPlans;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'COMMON INSURANCE PLANS')]/following-sibling::div/div[contains(text(),'Other')]")
	public WebElement commonInsuranceOther;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	public WebElement patientFullName;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement patientEmail;

	@FindBy(how = How.XPATH, using = "//input[@name='phone']")
	public WebElement patientPhone;

	@FindBy(how = How.XPATH, using = "//input[@name='zip_code']")
	public WebElement patientZipcode;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement btnSubmitContactInfo;

	public void navigateToInsurancePage() {
		driver.get("https://web-staging2.eargo.com/insurance");
	}

	public void selectMasterInsurance(String insuranceCategory, String insuranceProvider) throws Exception {

		switch (insuranceCategory.toLowerCase()) {

		case "federal":
			selectFederalEmployeeInsurance(insuranceProvider);
			break;

		case "common":
			scrollToElement(sectionCommonInsurance);
			selectCommonInsurance(insuranceProvider);
			break;

		case "other":
			selectOtherInsurance(insuranceProvider);
			break;

		default:
			throw new Exception("Insurance Category doesn't matched.");
		}

		Thread.sleep(500);

	}

	private void selectFederalEmployeeInsurance(String insuranceProvider) throws InterruptedException {

	}

	private void selectCommonInsurance(String insuranceProvider) throws InterruptedException {

		switch (insuranceProvider.toLowerCase()) {

		case "aetna":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceAetna)).click();
			break;

		case "cigna":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceCigna)).click();
			break;

		case "united healthcare":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceUnitedHealthcare)).click();
			break;

		case "bcbs non-federal plans":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceBCBSNFEP)).click();
			break;

		case "anthem":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceAnthem)).click();
			break;

		case "medicare advantage plans":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceMedicareAdvantagePlans)).click();
			break;

		case "trade or union health benefit plans":
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceTradeOrUnionHealthBenefitPlans)).click();
			break;

		default:
			wait.until(ExpectedConditions.elementToBeClickable(commonInsuranceOther)).click();
		}

	}

	private void selectOtherInsurance(String insuranceProvider) throws InterruptedException {

	}

	public void submitContactInfo(String patientName, String insuranceProvider) throws InterruptedException {

		// Enter Patient Name
		patientFullName.sendKeys(patientName);
		setPatientName(patientName);

		// Enter Patient Phone number
		patientPhone.sendKeys(prop.getProperty("patientPhoneNumber"));
		setPatientPhoneNumber(prop.getProperty("patientPhoneNumber"));

		// Enter Patient Zipcode
		patientZipcode.sendKeys(prop.getProperty("patientZipCode"));

		// Enter Patient Email
		patientEmail.click();

		switch (insuranceProvider.toLowerCase()) {

		case "bcbs":
			patientEmail.sendKeys(prop.getProperty("bcbsEmail"));
			setPatientEmailAddress(prop.getProperty("bcbsEmail"));
			break;
		case "geha":
			patientEmail.sendKeys(prop.getProperty("gehaEamil"));
			setPatientEmailAddress(prop.getProperty("gehaEamil"));
			break;

		case "nalc":
			patientEmail.sendKeys(prop.getProperty("nalcEmail"));
			setPatientEmailAddress(prop.getProperty("nalcEmail"));
			break;

		case "aetna":
			patientEmail.sendKeys(prop.getProperty("aetnaEmail"));
			setPatientEmailAddress(prop.getProperty("aetnaEmail"));
			break;

		case "apwu health plan":
			patientEmail.sendKeys(prop.getProperty("apwuEmail"));
			setPatientEmailAddress(prop.getProperty("apwuEmail"));
			break;

		case "mhbp":
			patientEmail.sendKeys(prop.getProperty("mhbpEmail"));
			setPatientEmailAddress(prop.getProperty("mhbpEmail"));
			break;

		default:
			patientEmail.sendKeys(prop.getProperty("othersEmail"));
			setPatientEmailAddress(prop.getProperty("othersEmail"));
		}

		// Click Submit button
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmitContactInfo)).click();
		
		Thread.sleep(2500);

	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmailAddress() {
		return patientEmailAddress;
	}

	public void setPatientEmailAddress(String patientEmailAddress) {
		this.patientEmailAddress = patientEmailAddress;
	}

	public String getPatientPhoneNumber() {
		return patientPhoneNumber;
	}

	public void setPatientPhoneNumber(String patientPhoneNumber) {
		this.patientPhoneNumber = patientPhoneNumber;
	}
}
