package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FederalForm extends BasePage {

	SalesforcePage salesforcePage = new SalesforcePage();
	private String patientName;
	private String patientEmailAddress;
	private String patientPhoneNumber;

	WebDriverWait dropDownWait = new WebDriverWait(driver, Duration.ofSeconds(3));

	public FederalForm() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	public WebElement patientFullName;

	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	public WebElement patientEmail;

	@FindBy(how = How.XPATH, using = "//input[@name='phone']")
	public WebElement patientPhone;

	@FindBy(how = How.XPATH, using = "//input[@name='zip_code']")
	public WebElement patientZipcode;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[3]/div[1]/label[1]/div[1]/div[1]")
	public WebElement insuranceProviderDropDown;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[contains(text(),'Aetna')]")
	public WebElement dropdownAtena;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[contains(text(),'APWU')]")
	public WebElement dropdownAPWU;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[text() ='Blue Cross / Blue Shield FEP']")
	public WebElement dropdownBCBSFEP;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[contains(text(),'GEHA')]")
	public WebElement dropdownGEHA;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[contains(text(),'MHBP')]")
	public WebElement dropdownMHBP;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[contains(text(),'NALC')]")
	public WebElement dropdownNALC;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[contains(text(),'Other')]")
	public WebElement dropdownOthers;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]")
	public WebElement YesUsedHearingAid;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]")
	public WebElement NotUsedHearingAid;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement GetStartedButton;

	public void navigateToFedform() {
		driver.get("https://web-staging2.eargo.com/fedform");
	}

	public void fillFedForm(String patientName, String insuranceProvider, String usedHearingAid)
			throws InterruptedException {

		// Enter Patient Name
		patientFullName.sendKeys(patientName);
		setPatientName(patientName);

		// Enter Patient Phone number
		patientPhone.sendKeys(prop.getProperty("patientPhoneNumber"));
		setPatientPhoneNumber(prop.getProperty("patientPhoneNumber"));

		// Enter Patient Zipcode
		patientZipcode.sendKeys(prop.getProperty("patientZipCode"));

		// Enter Patient Email
		switch (insuranceProvider.toLowerCase()) {

		case "bcbs":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("bcbsEmail"));
			setPatientEmailAddress(prop.getProperty("bcbsEmail"));
			Thread.sleep(1000);
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownBCBSFEP)).click();

			break;
		case "geha":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("gehaEamil"));
			setPatientEmailAddress(prop.getProperty("gehaEamil"));
			Thread.sleep(1000);
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownGEHA)).click();
			Thread.sleep(1000);

			break;

		case "nalc":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("nalcEmail"));
			setPatientEmailAddress(prop.getProperty("nalcEmail"));
			Thread.sleep(1000);
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownNALC)).click();
			break;

		case "aetna":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("aetnaEmail"));
			setPatientEmailAddress(prop.getProperty("aetnaEmail"));
			Thread.sleep(1000);
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownAtena)).click();
			break;

		case "apwu health plan":
			patientEmail.sendKeys(prop.getProperty("apwuEmail"));
			setPatientEmailAddress(prop.getProperty("apwuEmail"));
			Thread.sleep(1000);
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownAPWU)).click();
			break;

		case "mhbp":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("mhbpEmail"));
			setPatientEmailAddress(prop.getProperty("mhbpEmail"));
			Thread.sleep(1000);
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownMHBP)).click();
			break;
			
		default:
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("othersEmail"));
			setPatientEmailAddress(prop.getProperty("othersEmail"));
			Thread.sleep(1000);

			insuranceProviderDropDown.click();
			Thread.sleep(1000);

			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownOthers)).click();
		}

		// Select Insurance Provider

		// Need to be developed

		// Have you ever used hearing aids?
		if (usedHearingAid.equals("YES")) {

			YesUsedHearingAid.click();

		} else {

			NotUsedHearingAid.click();

		}

		// Click on Get Started

		GetStartedButton.click();

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
