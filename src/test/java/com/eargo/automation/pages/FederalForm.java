package com.eargo.automation.pages;

import java.time.Duration;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FederalForm extends BasePage{
	
	SalesforcePage salesforcePage = new SalesforcePage();
	
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
	public WebElement  insuranceProviderDropDown;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[1]")
	public WebElement dropdownAtena;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[2]")
	public WebElement dropdownAPWU;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[3]")
	public WebElement dropdownBCBS;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[4]")
	public WebElement dropdownGEHA;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[5]")
	public WebElement dropdownMHBP;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[6]")
	public WebElement dropdownNALC;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'react-select__menu-list')]/div[7]")
	public WebElement dropdownOthers;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]")
	public WebElement YesUsedHearingAid;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]")
	public WebElement  NotUsedHearingAid;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement  GetStartedButton;
	
	
	public void navigateToFedform() {
		driver.get("https://web-staging2.eargo.com/fedform");
	}
	
	public void fillFedForm (String insuranceProvider,String usedHearingAid) throws InterruptedException {
		
	// Enter Patient Name 
		//patientFullName.sendKeys(salesforcePage.getPatientName());
		patientFullName.sendKeys("Geha Test");
		
		
	// Enter Patient Phone number
	
		patientPhone.sendKeys(prop.getProperty("patientPhoneNumber"));
				
	// Enter Patient Zipcode	
			
		patientZipcode.sendKeys(prop.getProperty("patientZipCode"));
					
		
		Thread.sleep(2000);
	// 	Enter Patient Email
		
		switch (insuranceProvider.toLowerCase()) {
		
		case "bcbs":
			patientEmail.click();
			
			patientEmail.sendKeys(prop.getProperty("bcbsEmail"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownBCBS)).click();
			
			break;
		case "geha":
			patientEmail.click();
			
			patientEmail.sendKeys(prop.getProperty("gehaEamil"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownGEHA)).click();
			Thread.sleep(1000);
			
			break;
			
		case "nalc":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("nalcEmail"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownNALC)).click();
			break;
		
		case "aetna":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("aetnaEmail"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownAtena)).click();
			break;
		
		case "apwu health plan":
			patientEmail.sendKeys(prop.getProperty("apwuEmail"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownAPWU)).click();
			break;
		
		case "mhbp":
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("mhbpEmail"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownMHBP)).click();
			break;	
		default:
			patientEmail.click();
			patientEmail.sendKeys(prop.getProperty("othersEmail"));
			Thread.sleep(1000);
			
			insuranceProviderDropDown.click();
			Thread.sleep(1000);
			
			dropDownWait.until(ExpectedConditions.elementToBeClickable(dropdownOthers)).click();
		}
		
	
	// Select Insurance Provider
		
		// Need to be developed	
		
	// Have you ever used hearing aids?
		 if(usedHearingAid.equals("YES")) {
			 
			 YesUsedHearingAid.click();
			 
		 }else {
			 
			 NotUsedHearingAid.click();
			 
		 }
		
	// Click on Get Started
		 
		 GetStartedButton.click(); 
		
	}
	
}
