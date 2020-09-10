package com.eargo.automation.steps;

import com.eargo.automation.pages.AccessoriesPage;
import com.eargo.automation.pages.BasePage;
import com.eargo.automation.pages.CartPage;
import com.eargo.automation.pages.CheckoutPage;
import com.eargo.automation.pages.FederalForm;
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

public class FEDERAL_FORM_STEPS {
	
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
	InsuranceForm insuranceForm=null;
	
	String givenInsuranceProvider;
	
	
	@Given("With a patient name {string}")
	public void with_a_patient_name(String patientName) {
	   
		//Need to develop
		salesforcePage = new SalesforcePage();
		salesforcePage.setPatientName(patientName);
		
	}

	@When("I submit the federal form with insurance provider as {string} and for ever used hearing aids option as {string}")
	public void i_submit_the_federal_form_with_insurance_provider_as_and_for_ever_used_hearing_aids_option_as(String insuranceProvider, String usedHearingAid) throws InterruptedException {
	    
		salesforcePage = new SalesforcePage();
		salesforcePage.setUsedHearingAid(usedHearingAid);
		salesforcePage.setInsuranceProvider(insuranceProvider);
		
		federalForm = new FederalForm();
		federalForm.navigateToFedform();
		federalForm.fillFedForm(insuranceProvider,usedHearingAid);
		
		
	}

	@When("I select {string} for maximum benefits for health insurance")
	public void i_select_for_maximum_benefits_for_health_insurance(String nothanks_or_continue) {

		//Need to develop
		insuranceForm = new InsuranceForm();
		insuranceForm.for_maximum_benifits_i_select(nothanks_or_continue);
		
	}

	@Then("Submitted details should be present in Salesforce")
	public void submitted_details_should_be_present_in_Salesforce() {

		//Need to develop
		salesforcePage = new SalesforcePage();
		salesforcePage.salesForceLogin();	
	}

	
	//-----------Newly added--------------------------------
	
	@When("I enter Member ID as {string}, Enrollment code as {string}, Group Number as {string}, Date of Birth as {string} State of resident as {string} and Insurance type as {string}")
	public void i_enter_Member_ID_as_Enrollment_code_as_Group_Number_as_Date_of_Birth_as_and_State_of_resident_as(String givenMemberID, String givenEnrollmentCode, String givenGroupNumber, String givenDOB, String givenState, String givenInsuranceType) throws InterruptedException {
	 
		//Need to develop
		salesforcePage = new SalesforcePage();
		insuranceForm = new InsuranceForm();
		
		//givenInsuranceProvider = salesforcePage.getInsuranceProvider();
		
		givenInsuranceProvider = "GEHA";
		
		switch (givenInsuranceProvider.toUpperCase()) {
		case "AETNA":
		case "APWU HEALTH PLAN":
		case "GEHA":
		case "MHBP":
			insuranceForm.fill_given_data(givenMemberID,givenGroupNumber, givenDOB, givenState, givenInsuranceType );
			break;
		
		case "OTHERS":
			//Need to develop
			break;
		
		case "BCBS":
		default:
			insuranceForm.fill_bcbs_data(givenMemberID, givenEnrollmentCode, givenGroupNumber, givenDOB);
			break;
			
		}
		

		
	}

	@When("I select {string} for using Hearing Aid insurance benefits in last {int} months")
	public void i_select_for_using_Hearing_Aid_insurance_benefits_in_last_months(String yes_no_notsure, Integer int1) throws InterruptedException {
		 
		//Need to develop
		insuranceForm.benifits_Used_In_Last36Month(yes_no_notsure);
	    
	}

	@When("I agree to trems and conditions and click on check you benifits")
	public void i_agree_to_trems_and_conditions_and_click_on_check_you_benifits() throws InterruptedException {
		 
		insuranceForm.i_agree_to_terms();
		insuranceForm.check_Your_Benifits();
	    
	}

	@Then("Submitted details should be present in Salesforce #\\(if No on 36month question then order will be placed)")
	public void submitted_details_should_be_present_in_Salesforce_if_No_on_36month_question_then_order_will_be_placed() {
		 
			//Need to develop

	    
	}
	
	
	
}
