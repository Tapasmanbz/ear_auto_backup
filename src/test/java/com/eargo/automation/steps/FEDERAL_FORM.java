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

public class FEDERAL_FORM {
	
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

}
