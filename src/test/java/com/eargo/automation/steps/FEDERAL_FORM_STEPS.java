package com.eargo.automation.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.eargo.automation.base.TestBase;
import com.eargo.automation.pages.AccessoriesPage;
import com.eargo.automation.pages.BasePage;
import com.eargo.automation.pages.CartPage;
import com.eargo.automation.pages.CheckoutPage;
import com.eargo.automation.pages.FederalForm;
import com.eargo.automation.pages.InsuranceCheckoutPage;
import com.eargo.automation.pages.InsuranceForm;
import com.eargo.automation.pages.MaxPage;
import com.eargo.automation.pages.MentionMePage;
import com.eargo.automation.pages.NeoHifiPage;
import com.eargo.automation.pages.NeoPage;
import com.eargo.automation.pages.OrderConfirmationPage;
import com.eargo.automation.pages.ReviewPage;
import com.eargo.automation.pages.SalesforcePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FEDERAL_FORM_STEPS extends TestBase {

	BasePage basePage = null;
	NeoHifiPage neoHifiPage = null;
	NeoPage neoPage = null;
	MaxPage maxPage = null;
	AccessoriesPage accessoriesPage = null;
	CartPage cartPage = null;
	CheckoutPage checkoutPage = null;
	ReviewPage reviewPage = null;
	OrderConfirmationPage orderConfirmationPage = null;
	SalesforcePage salesforcePage = null;
	MentionMePage mentionMe = null;
	FederalForm federalForm = null;
	InsuranceForm insuranceForm = null;
	InsuranceCheckoutPage insuranceCheckoutPage = null;
	boolean isTimeoutPopUpDisplayed = false;
	boolean isUnableToVerifyMessageDisplayed = false;
	String unableToVerifyMessage = null;

	private String givenInsuranceProvider;
	private String newInsuranceProvider;

	public String getGivenInsuranceProvider() {
		return givenInsuranceProvider;
	}

	public void setGivenInsuranceProvider(String givenInsuranceProvider) {
		this.givenInsuranceProvider = givenInsuranceProvider;
	}

	public String getNewInsuranceProvider() {
		return givenInsuranceProvider;
	}

	public void setNewInsuranceProvider(String newInsuranceProvider) {
		this.newInsuranceProvider = newInsuranceProvider;
	}

	@Given("With a patient name {string}")
	public void with_a_patient_name(String patientName) {

		// Need to develop
		salesforcePage = new SalesforcePage();
		salesforcePage.setPatientName(patientName);

	}
	
	@When("I submit the federal form with insurance provider as {string} and for ever used hearing aids option as {string}")
	public void i_submit_the_federal_form_with_insurance_provider_as_and_for_ever_used_hearing_aids_option_as(
			String insuranceProvider, String usedHearingAid) throws InterruptedException {

		// salesforcePage = new SalesforcePage();
		federalForm = new FederalForm();
		String patientName = salesforcePage.getPatientName();
		federalForm.navigateToFedform();
		federalForm.fillFedForm(patientName, insuranceProvider, usedHearingAid);
		salesforcePage.setUsedHearingAid(usedHearingAid);
		salesforcePage.setInsuranceProvider(insuranceProvider);
		
	}


//-----[21-10-2020]---------
			
	private String allow_verify_eligibility;
	
	
	public String getAllow_verify_eligibility() {
		return allow_verify_eligibility;
	}

	public void setAllow_verify_eligibility(String allow_verify_eligibility) {
		this.allow_verify_eligibility = allow_verify_eligibility;
	}

	@When("I select {string} for maximum benefits for health insurance")
	public void i_select_for_maximum_benefits_for_health_insurance(String nothanks_or_continue) throws InterruptedException {

		// Need to develop
		insuranceForm = new InsuranceForm();
		Thread.sleep(2000);
		insuranceForm.for_maximum_benifits_i_select(nothanks_or_continue);	
	
		//21_10_2020
		setAllow_verify_eligibility(nothanks_or_continue);
		
	}

	@Then("Submitted details should be present in Salesforce")
	public void submitted_details_should_be_present_in_Salesforce() throws InterruptedException {
		
		salesforcePage.salesForceLogin();
		
		//15_10_2020
		
		if(allow_verify_eligibility.equals("NO THANKS")) {
			
			salesforcePage.verify_leads_for_pc1();
			
			Thread.sleep(2000);
			
		}else {
			
			salesforcePage.verify_leads_for_pc1();
			Thread.sleep(2000);
			salesforcePage.select_recordFrom_lead_report(federalForm.getTimeStampEmail());
			salesforcePage.validate_lead_info();
			wait.until(ExpectedConditions.visibilityOf(salesforcePage.lead_name));
			
			Assert.assertEquals(salesforcePage.lead_name.getText(), salesforcePage.getPatientName());
			
			Assert.assertEquals(salesforcePage.lead_email.getText(), federalForm.getTimeStampEmail());
			
			Assert.assertEquals(salesforcePage.lead_phoneNumber.getText(), prop.getProperty("patientPhoneNumber"));
			
			switch (salesforcePage.insuranceProvider.toUpperCase()) {
			case "AETNA":
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "Aetna");
				break;
					
			case "APWU HEALTH PLAN":
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "APWU Health Plan");
				break;
				
				
			case "GEHA":
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "GEHA");
				break;
				
			case "MHBP":
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "MHBP");
				break;
				
			case "NALC":
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "NALC Health Benefit Plan");
				break;

			case "OTHERS":
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "Others");
				break;

			case "BCBS":
			default:
				Assert.assertEquals(salesforcePage.lead_insuranceProvider.getText(), "Blue Cross / Blue Shield FEP");
				break;

			}

			Thread.sleep(2000);
//			salesforcePage.validate_preQual_info(benifits_Used);
		
			salesforcePage.validate_preQual_info();
			
			Thread.sleep(5000);
			
//			salesforcePage.select_preQual_id();
			
			Thread.sleep(2000);
			
			if(benifits_Used.equalsIgnoreCase("YES") || benifits_Used.equalsIgnoreCase("NOT SURE") ) {
				
				switch (salesforcePage.insuranceProvider.toUpperCase()) {
				case "BCBS":
				case "GEHA":
				case "NALC":	
					try {
				//		Assert.assertEquals(salesforcePage.preQual_verification_status(federalForm.timeStampEmail), "Processed");
					}catch(Exception e) {
						System.out.println(e);
					}
					
					break;
				
				case "AETNA":
				case "MHBP":
				case "OTHERS":
					try {
						Assert.assertEquals(salesforcePage.preQual_verification_status(federalForm.timeStampEmail), "Unable to Verify");
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
				}
				
			}else{
				switch (salesforcePage.insuranceProvider.toUpperCase()) {
				case "BCBS":
				case "GEHA":
				case "NALC":	
					try {
						Assert.assertEquals(salesforcePage.preQual_verification_status(federalForm.timeStampEmail), "Processed");
					}catch(Exception e) {
						System.out.println(e);
					}					
					break;
					
				case "AETNA":
				case "MHBP":
				case "OTHERS":	
					try {
						Assert.assertEquals(salesforcePage.preQual_verification_status(federalForm.timeStampEmail), "Unable to Verify");
					}catch(Exception e) {
						System.out.println(e);
					}					
					break;
				}
			}
			
//			Assert.assertEquals(preQual_patientFirstName.getText(),"" );
			
//			Assert.assertEquals(preQual_patientLastName.getText(),"" );
			
			salesforcePage.select_preQual_id(federalForm.timeStampEmail);
			
			Assert.assertEquals(salesforcePage.preQual_patientDOB.getText(), salesforcePage.getGiven_DOB());
			
			Assert.assertEquals(salesforcePage.preQual_patientState.getText(),salesforcePage.getGiven_state() );
		
			switch (salesforcePage.insuranceProvider.toUpperCase()) {
			
			case "BCBS":
				Assert.assertEquals(salesforcePage.preQual_payerName.getText(),"Blue Cross / Blue Shield FEP");
				break;
				
			case "GEHA":
				Assert.assertEquals(salesforcePage.preQual_payerName.getText(),"GEHA");
				break;
				
			case "NALC":	
				Assert.assertEquals(salesforcePage.preQual_payerName.getText(),"NALC Health Benefit Plan");
				break;
				
			case "AETNA":
				Assert.assertEquals(salesforcePage.preQual_payerName.getText(),"Aetna");
				break;
				
			case "MHBP":
				Assert.assertEquals(salesforcePage.preQual_payerName.getText(),"MHBP");
				break;
				
			case "OTHERS":
				Assert.assertEquals(salesforcePage.preQual_payerName.getText(),"");
				break;
				
			}
					
			Assert.assertEquals(salesforcePage.preQual_phone.getText(),prop.getProperty("patientPhoneNumber"));
			
			if(benifits_Used.equalsIgnoreCase("YES")) {
				
				Assert.assertEquals(salesforcePage.preQual_verificationStatus.getText(),"YES");
				
			}else if (benifits_Used.equalsIgnoreCase("NO")) {
				
				Assert.assertEquals(salesforcePage.preQual_verificationStatus.getText(),"NO" );
				
			}else {
				
				Assert.assertEquals(salesforcePage.preQual_verificationStatus.getText(),"NOT SURE");
				
			}
			
			Assert.assertEquals(salesforcePage.preQual_memberID.getText(),salesforcePage.getGiven_MemberID());
			
			Assert.assertEquals(salesforcePage.preQual_enrollmentCode.getText(),salesforcePage.getGiven_EnrollmentCode() );
			
			Assert.assertEquals(salesforcePage.preQual_groupNumber.getText(),salesforcePage.getGiven_GroupNumber());
			
			Assert.assertEquals(salesforcePage.preQual_usedBenifits.getText(),salesforcePage.getGiven_BenifitsUsed());
		
			if(!salesforcePage.insuranceProvider.equals("NALC")) {
				Assert.assertEquals(salesforcePage.preQual_patientZipCode.getText(),salesforcePage.getGiven_ZipCode());  //not for NALC		
			}
			
			if(!salesforcePage.insuranceProvider.equals("BCBS")) {
					Assert.assertEquals(salesforcePage.preQual_primaryOrDependent.getText(),salesforcePage.getGiven_PrimaryOrDependent() ); //not for bcbs
			}
		
			if(salesforcePage.insuranceProvider.equals("NALC")) {
					Assert.assertEquals(salesforcePage.preQual_medicalCare.getText(),salesforcePage.getGiven_MedicalCare()); // available for NALC		
			}
			
			
			
			}
			
		}
		

	// -----------Newly added--------------------------------
//	@When("I enter Member ID as {string}, Enrollment code as {string}, Group Number as {string}, Date of Birth as {string} State of resident as {string} and Insurance type as {string}")
	@When("I enter Member ID as {string}, Enrollment code as {string}, Group Number as {string}, Medicare Number as {string}, Date of Birth as {string} State of resident as {string} with zipcode {string} and Insurance type as {string}")
	public void i_enter_Member_ID_as_Enrollment_code_as_Group_Number_as_Date_of_Birth_as_and_State_of_resident_as(
			String givenMemberID, String givenEnrollmentCode, String givenGroupNumber, String givenMedicareNumber,
			String givenDOB, String givenState,String givenZipCode, String givenInsuranceType) throws InterruptedException {

//---[22-10-2020]------		
		
		salesforcePage.setGiven_DOB(givenDOB);
		salesforcePage.setGiven_MemberID(givenMemberID);
		salesforcePage.setGiven_EnrollmentCode(givenEnrollmentCode);
		salesforcePage.setGiven_GroupNumber(givenGroupNumber);
		salesforcePage.setGiven_ZipCode(givenZipCode);
		salesforcePage.setGiven_PrimaryOrDependent(givenInsuranceType);
		salesforcePage.setGiven_MedicalCare(givenMedicareNumber);
		salesforcePage.setGiven_state(givenState);
		
		
		// Need to develop
		// salesforcePage = new SalesforcePage();
		insuranceForm = new InsuranceForm();

		givenInsuranceProvider = salesforcePage.getInsuranceProvider();
		
		System.out.println("givenInsuranceProvider");

		switch (givenInsuranceProvider.toUpperCase()) {
		case "AETNA":
		case "APWU HEALTH PLAN":
		case "GEHA":
		case "MHBP":
//			insuranceForm.fill_given_data(givenMemberID, givenGroupNumber, givenDOB, givenState, givenInsuranceType);
			insuranceForm.fill_given_data(givenMemberID,givenGroupNumber, givenDOB, givenState, givenZipCode,givenInsuranceType);

			break;

		case "NALC":
			insuranceForm.fill_nalc_data(givenMemberID, givenGroupNumber, givenMedicareNumber, givenDOB, givenState,givenInsuranceType);
			break;

		case "OTHERS":
			// Need to develop
			break;

		case "BCBS":
		default:
//			insuranceForm.fill_bcbs_data(givenMemberID, givenEnrollmentCode, givenGroupNumber, givenDOB);
			insuranceForm.fill_bcbs_data(givenMemberID, givenEnrollmentCode, givenGroupNumber, givenDOB , givenState, givenZipCode);
			
			break;

		}

	}

	
// ----------[21-10-2020]--------	
	public String benifits_Used;
	
	public String getBenifits_Used() {
		return benifits_Used;
	}

	public void setBenifits_Used(String benifits_Used) {
		this.benifits_Used = benifits_Used;
	}

	@When("I select {string} for using Hearing Aid insurance benefits in last {int} months")
	public void i_select_for_using_Hearing_Aid_insurance_benefits_in_last_months(String yes_no_notsure, Integer int1)
			throws InterruptedException {

		// Need to develop
		insuranceForm.benifits_Used_In_Last36Month(yes_no_notsure);
		
// [21-10-2020]	
		setBenifits_Used(yes_no_notsure);
		salesforcePage.setGiven_BenifitsUsed(yes_no_notsure);
		
	}

	@When("I agree to trems and conditions and click on check you benifits")
	public void i_agree_to_trems_and_conditions_and_click_on_check_you_benifits() throws InterruptedException {

		insuranceForm.i_agree_to_terms();
		insuranceForm.check_Your_Benifits();

	}

//	@Then("Submitted details should be present in Salesforce #\\(if No on 36month question then order will be placed)")
//	public void submitted_details_should_be_present_in_Salesforce_if_No_on_36month_question_then_order_will_be_placed() {
//
//		// Need to develop
//
//	}
	
	
	@When("I click on No thanks,give me a call instead")
	public void i_click_on_No_thanks_give_me_a_call_instead() throws InterruptedException {

		insuranceForm.clickNothanksAndGiveMeCall();

	}

	@When("I wait for more than {int} mins on insurance form page")
	public void i_wait_on_insurance_form_page(int minutes) throws InterruptedException {

		insuranceForm.waitOnInsuranceFormPage(minutes);

	}

	@When("I click on Checkout button")
	public void i_click_on_checkout_button() throws InterruptedException {

		insuranceForm.clickCheckoutButton();
		isTimeoutPopUpDisplayed = insuranceForm.isTimeoutPopUpDisplayed();
		if (isTimeoutPopUpDisplayed) {
			insuranceForm.clickOkButtonOnTimeoutPopUp();
		}
	}

	@When("I click on Ok button in Unable to verify your details online section")
	public void i_click_on_Ok_button_in_unable_to_verify_your_details_online_section() throws InterruptedException {

		isUnableToVerifyMessageDisplayed = insuranceForm.isUnableToVerifyMessageDisplayed();
		unableToVerifyMessage = insuranceForm.getUnableToVerifyMessage();
		System.out.println("unableToVerifyMessage:" + unableToVerifyMessage);

		insuranceForm.clickOkButtonInUnableToVerifyYourDetailsOnlineSection();

	}

	@Then("Timeout popup should be displayed on insurance form page")
	public void verify_timeout_popup_displayed_on_insurance_form_page() {

		// Need to develop
		Assert.assertTrue(isTimeoutPopUpDisplayed, "Session Time Out Pop up not displayed.");
		Assert.assertEquals(driver.getCurrentUrl(), "https://web-staging2.eargo.com/federalthankyou-apqto",
				"User doesnot navigate to 'https://web-staging2.eargo.com/federalthankyou-apqto' url.");
	}

	@Then("{string} message should on insurance form page")
	public void verify_unable_to_verify_your_benefits_online_message_display_on_insurance_form_page() {

		// Need to develop
		Assert.assertTrue(isUnableToVerifyMessageDisplayed,
				"Unable to verify your details online message not displayed.");
		Assert.assertEquals(unableToVerifyMessage,
				"We were unable to verify your benefits online. An Eargo specialist will be in touch with you within 1 business day to assist with completing your order.",
				"Unable to verify your details online message doesn't matched.");

	}

	@Then("Great news! sub-section should display for insurance {string}")
	public void verify_Great_news_sub_section(String insuranceProvider) {

		switch (insuranceProvider.toLowerCase()) {

		case "nalc":
			// Great News Message
			Assert.assertEquals(insuranceForm.getGreatNewsMessage(),
					"Great News!\n" + "You’re covered for an Eargo Neo .\n"
							+ "Eargo will also discount your order so that you pay $0",
					"Great News message doesn't matched.");

			// FEHB Discount
			Assert.assertEquals(insuranceForm.getFEHBDiscountInGreatNewsSection(), "-$2,000",
					"FEHB discount amount doesn't matched.");

			// Eargo Discount
			Assert.assertEquals(insuranceForm.getEargoDiscountInGreatNewsSection(), "-$400",
					"Eargo discount amount doesn't matched.");

			break;
		case "bcbs":
		case "geha":
		default:
			// Great News Message
			Assert.assertEquals(insuranceForm.getGreatNewsMessage(),
					"Great News!\n" + "You’re covered for an Eargo Neo HiFi.\n"
							+ "Eargo will also discount your order so that you pay $0",
					"Great News message doesn't matched.");

			// FEHB Discount
			Assert.assertEquals(insuranceForm.getFEHBDiscountInGreatNewsSection(), "-$2,400",
					"FEHB discount amount doesn't matched.");

			// Eargo Discount
			Assert.assertEquals(insuranceForm.getEargoDiscountInGreatNewsSection(), "-$0",
					"Eargo discount amount doesn't matched.");

		}

		// Product Image
		Assert.assertTrue(insuranceForm.isProductImageDisplayed(insuranceProvider), "Product image doesn't displayed.");

		// Product Price
		Assert.assertEquals(insuranceForm.getProductPriceInGreatNewsSection(), "$2,400",
				"Product Price doesn't matched.");

		// Total Payable Amount
		Assert.assertEquals(insuranceForm.getTotalPayableAmountInGreatNewsSection(), "$0",
				"Total payable amount doesn't matched.");

		// By Proceeding Message
		Assert.assertEquals(insuranceForm.getByProceedingMessageInGreatNewsSection(),
				"By proceeding with this purchase you are confirming that you have not used your insurance for purchase within the last 36 months.",
				"By Proceeding message doesn't matched.");

	}

	@Then("Verify user should be navigate to checkout page")
	public void verify_user_should_be_navigate_to_checkout_page() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("corpSiteURL") + "insurance-checkout");
	}

	@Then("Verify 'My information' sub-section details for insurance {string}")
	public void verify_my_information_sub_section_details_for_insurance(String insuranceProvider) {
		insuranceCheckoutPage = new InsuranceCheckoutPage();
		Assert.assertEquals(insuranceCheckoutPage.getAcccountName(), federalForm.getPatientName());
		Assert.assertEquals(insuranceCheckoutPage.getAccountEmail(), federalForm.getPatientEmailAddress());
		Assert.assertEquals(insuranceCheckoutPage.getPhoneNumber(), federalForm.getPatientPhoneNumber());
	}

	@Then("Verify 'Ship my eargo to' sub-section details for insurance {string}")
	public void verify_ship_my_eargo_to_sub_section_details_for_insurance(String insuranceProvider) {
		Assert.assertEquals(insuranceCheckoutPage.getShippingName(), federalForm.getPatientName());

	}

	@Then("Verify 'Covered by' sub-section details for insurance {string}")
	public void verify_covered_by_sub_section_details_for_insurance(String insuranceProvider) {

	}

	@Then("Verify 'Order summary' sub-section details for insurance {string}")
	public void verify_order_summary_sub_section_details_for_insurance(String insuranceProvider) {

	}

	@Then("Verify Terms and Conditions radio button should display for insurance {string}")
	public void verify_Terms_and_Conditions_radio_button_should_display_for_insurance(String insuranceProvider) {

	}

	@Then("Verify 1-2 business day delivery option should not be present for insurance {string}")
	public void verify_business_day_delivery_option_should_not_be_present_for_insurance(String insuranceProvider) {

	}

	@When("I change the insurance provider as {string}")
	public void i_change_the_insurance_provider_as(String changedInsuranceProvider) throws InterruptedException {
		setGivenInsuranceProvider(changedInsuranceProvider);
		insuranceForm = new InsuranceForm();
		salesforcePage.setInsuranceProvider(changedInsuranceProvider);
		insuranceForm.changeInsuranceProvide(changedInsuranceProvider);

	}
	
//--------12-10-2020-------------	

	@When("I click on Checkout and enter required details to place an order")
	public void i_click_on_Checkout_and_enter_required_details_to_place_an_order() throws InterruptedException {
		
		Thread.sleep(3000);
		insuranceForm.clickCheckoutButton();
//		insuranceForm.checkout();
		Thread.sleep(3000);
		insuranceForm.fillInCheckoutPage(); 
		
	}

}
