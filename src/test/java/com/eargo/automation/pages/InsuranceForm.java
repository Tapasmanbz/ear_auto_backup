package com.eargo.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InsuranceForm extends BasePage{
	
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

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'DEPENDENT')]")
	public WebElement dependentButton;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'PRIMARY')]")
	public WebElement primaryButton;
	
	@FindBy(how = How.XPATH, using = "//input[@name='member_id']")
	public WebElement memberID;
	
	@FindBy(how = How.XPATH, using = "//input[@name='group_number']")
	public WebElement groupNumber;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Enrollment Code')]")
	public WebElement enrollmentCode;
	
	@FindBy(how = How.XPATH, using = "//input[@name='payer_phone']")
	public WebElement optionalPhoneNumber;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]")
	public WebElement yesForLast36Months;

	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[3]/div[5]/div[1]/div[2]/label[1]")
	public WebElement noForLast36Months;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Not Sure')]")
	public WebElement notSureForLast36Months;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/main[1]/div[1]/form[1]/div[3]/div[6]/div[1]/div[1]/label[1]")
	public WebElement iAgree;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'CHECK YOUR BENEFITS')]")
	public WebElement checkYourBenifits;
	
	
	public void for_maximum_benifits_i_select(String nothanks_or_continue) {
		
		if(nothanks_or_continue.equals("CONTINUE")) {
			
			continueButton.click();
			
		}else {
			
			noThanksButton.click();
			
		}
		
	}
	
	
	
}
