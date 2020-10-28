package com.eargo.automation.steps;

import org.testng.Assert;

import com.eargo.automation.base.TestBase;
import com.eargo.automation.pages.AccessoriesPage;
import com.eargo.automation.pages.BasePage;
import com.eargo.automation.pages.CartPage;
import com.eargo.automation.pages.CheckoutPage;
import com.eargo.automation.pages.FederalForm;
import com.eargo.automation.pages.InsuranceCheckoutPage;
import com.eargo.automation.pages.InsuranceForm;
import com.eargo.automation.pages.MasterInsurancePage;
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
	MasterInsurancePage masterInsurancePage = null;
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

	@When("I select {string} for maximum benefits for health insurance")
	public void i_select_for_maximum_benefits_for_health_insurance(String nothanks_or_continue) {

		// Need to develop
		insuranceForm = new InsuranceForm();
		insuranceForm.for_maximum_benifits_i_select(nothanks_or_continue);

	}

	@Then("Submitted details should be present in Salesforce")
	public void submitted_details_should_be_present_in_Salesforce() {

		// Need to develop
		salesforcePage = new SalesforcePage();
		salesforcePage.salesForceLogin();
	}

	// -----------Newly added--------------------------------

	@When("I enter Member ID as {string}, Enrollment code as {string}, Group Number as {string}, Medicare Number as {string}, Date of Birth as {string} State of resident as {string} and Insurance type as {string}")
	public void i_enter_Member_ID_as_Enrollment_code_as_Group_Number_as_Date_of_Birth_as_and_State_of_resident_as(
			String givenMemberID, String givenEnrollmentCode, String givenGroupNumber, String givenMedicareNumber,
			String givenDOB, String givenState, String givenInsuranceType) throws InterruptedException {

		// Need to develop
		// salesforcePage = new SalesforcePage();
		insuranceForm = new InsuranceForm();

		givenInsuranceProvider = salesforcePage.getInsuranceProvider();

		// givenInsuranceProvider = "GEHA";

		switch (givenInsuranceProvider.toUpperCase()) {
		case "AETNA":
		case "APWU HEALTH PLAN":
		case "GEHA":
		case "MHBP":
			insuranceForm.fill_given_data(givenMemberID, givenGroupNumber, givenDOB, givenState, givenInsuranceType);
			break;

		case "NALC":
			insuranceForm.fill_nalc_data(givenMemberID, givenGroupNumber, givenMedicareNumber, givenDOB, givenState,
					givenInsuranceType);
			break;

		case "OTHERS":
			// Need to develop
			break;

		case "BCBS":
		default:
			insuranceForm.fill_bcbs_data(givenMemberID, givenEnrollmentCode, givenGroupNumber, givenDOB);
			break;

		}

	}

	@When("I select {string} for using Hearing Aid insurance benefits in last {int} months")
	public void i_select_for_using_Hearing_Aid_insurance_benefits_in_last_months(String yes_no_notsure, Integer int1)
			throws InterruptedException {

		// Need to develop
		insuranceForm.benifits_Used_In_Last36Month(yes_no_notsure);

	}

	@When("I agree to trems and conditions and click on check you benifits")
	public void i_agree_to_trems_and_conditions_and_click_on_check_you_benifits() throws InterruptedException {

		insuranceForm.i_agree_to_terms();
		insuranceForm.check_Your_Benifits();

	}

	@Then("Submitted details should be present in Salesforce #\\(if No on 36month question then order will be placed)")
	public void submitted_details_should_be_present_in_Salesforce_if_No_on_36month_question_then_order_will_be_placed() {

		// Need to develop

	}

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
		Assert.assertEquals(insuranceCheckoutPage.getAccountPhoneNumber(), federalForm.getPatientPhoneNumber());
	}

	@Then("Verify 'Ship my eargo to' sub-section details for insurance {string}")
	public void verify_ship_my_eargo_to_sub_section_details_for_insurance(String insuranceProvider) {
		Assert.assertEquals(insuranceCheckoutPage.getShippingName(), federalForm.getPatientName());
		Assert.assertTrue(insuranceCheckoutPage.isShippingStreetDisplayed(), "[Street] input field doesn't displayed.");
		Assert.assertTrue(insuranceCheckoutPage.isShippingAptSuiteDisplayed(),
				"[Apt/Suite] input field doesn't displayed.");
		Assert.assertTrue(insuranceCheckoutPage.isShippingCityDisplayed(), "[City] input field doesn't displayed.");
		Assert.assertTrue(insuranceCheckoutPage.isShippingStateDropDownDisplayed(),
				"[State] dropdown list doesn't displayed.");
		Assert.assertTrue(insuranceCheckoutPage.isShippingZipcodeDisplayed(),
				"[Zipcode] input field doesn't displayed.");
	}

	@Then("Verify 'Covered by' sub-section details for insurance {string}")
	public void verify_covered_by_sub_section_details_for_insurance(String insuranceProvider) {
		Assert.assertTrue(insuranceCheckoutPage.isCoveredByDisplayed(insuranceProvider),
				"[Covered By] section doesn't matched or displayed.");
	}

	@Then("Verify 'Order summary' sub-section details for insurance {string}")
	public void verify_order_summary_sub_section_details_for_insurance(String insuranceProvider) {
		Assert.assertTrue(insuranceCheckoutPage.isOrderSummarySectionDisplayed(),
				"[Order Summary] section doesn't matched or displayed.");

		switch (insuranceProvider.toLowerCase()) {
		case "nalc":
			Assert.assertEquals(insuranceCheckoutPage.getProduct(), "Eargo Neo", "Product Name doesn't matched.");
			Assert.assertEquals(insuranceCheckoutPage.getProductSubTotal(), "$2,350.00",
					"Product Subtotal doesn't matched.");
			break;
		default:
			Assert.assertEquals(insuranceCheckoutPage.getProduct(), "Eargo Neo HiFi", "Product Name doesn't matched.");
			Assert.assertEquals(insuranceCheckoutPage.getProductSubTotal(), "$2,950.00",
					"Product Subtotal doesn't matched.");
			break;

		}

		Assert.assertTrue(insuranceCheckoutPage.isEargoDiscountPresent(), "[Eargo Discount] doesn't displayed.");

		switch (insuranceProvider.toLowerCase()) {
		case "nalc":
			Assert.assertEquals(insuranceCheckoutPage.getFEHBDiscount(), "-$2,000.00",
					"FEHB Benefit amount doesn't matched.");
			break;
		default:
			Assert.assertEquals(insuranceCheckoutPage.getFEHBDiscount(), "-$2,500.00",
					"FEHB Benefit amount doesn't matched.");
			break;

		}

		Assert.assertTrue(insuranceCheckoutPage.isTaxPresent(), "[Tax] doesn't displayed.");

		Assert.assertEquals(insuranceCheckoutPage.getEstimatedTotal(), "$0.00", "Estimated Total doesn't matched.");
	}

	@Then("Verify Terms and Conditions radio button should display for insurance {string}")
	public void verify_Terms_and_Conditions_radio_button_should_display_for_insurance(String insuranceProvider) {
		Assert.assertTrue(insuranceCheckoutPage.isMedicalWaiverDisplayed(),
				"[Medical Waiver Terms and Conditions] radio button doesn't displayed.");
	}

	@Then("Verify 1-2 business day delivery option should not be present for insurance {string}")
	public void verify_business_day_delivery_option_should_not_be_present_for_insurance(String insuranceProvider) {
		Assert.assertFalse(insuranceCheckoutPage.isAcceleratedShippingDisplayed(),
				"1-2 business day delivery option displayed.");
	}

	@When("I change the insurance provider as {string}")
	public void i_change_the_insurance_provider_as(String changedInsuranceProvider) throws InterruptedException {
		setGivenInsuranceProvider(changedInsuranceProvider);
		insuranceForm.changeInsuranceProvide(changedInsuranceProvider);

	}

	@When("I submit the master insurance form of insurance category {string} with insurance provider as {string}")
	public void i_submit_the_master_insurance_form_of_insurance_category_with_insurance_provider_as(
			String insuranceCategory, String insuranceProvider) throws Exception {

		masterInsurancePage = new MasterInsurancePage();
		String patientName = salesforcePage.getPatientName();
		masterInsurancePage.navigateToInsurancePage();
		masterInsurancePage.selectMasterInsurance(insuranceCategory, insuranceProvider);
		masterInsurancePage.submitContactInfo(patientName, insuranceProvider);
		salesforcePage.setInsuranceProvider(insuranceProvider);
	}

}
