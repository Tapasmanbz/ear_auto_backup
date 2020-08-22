package com.eargo.automation.steps;

import org.junit.Assert;

import com.eargo.automation.base.TestBase;
import com.eargo.automation.pages.AccessoriesPage;
import com.eargo.automation.pages.BasePage;
import com.eargo.automation.pages.CartPage;
import com.eargo.automation.pages.CheckoutPage;
import com.eargo.automation.pages.MaxPage;
import com.eargo.automation.pages.MentionMePage;
import com.eargo.automation.pages.NeoHifiPage;
import com.eargo.automation.pages.NeoPage;
import com.eargo.automation.pages.OrderConfirmationPage;
import com.eargo.automation.pages.ReviewPage;
import com.eargo.automation.pages.SalesforcePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Address_Field_Verification_Steps extends TestBase {

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

	@Then("verify that no bread payment method is displayed")
	public void verify_that_no_bread_payment_method_is_displayed() {
		checkoutPage = new CheckoutPage();

		boolean isBreadPaymentMethodDisplayed = checkoutPage.getIsBreadPaymentMethodDisplayed();
		System.out.println("Bread Payment method displayed :" + isBreadPaymentMethodDisplayed);
		Assert.assertFalse("Bread Payment method displayed.", isBreadPaymentMethodDisplayed);
	}

	@Then("verify that the error message displayed for payment {string}")
	public void verify_that_the_error_message_displayed_for_payment(String paymentType) throws InterruptedException {

		System.out.println("verify_that_the_error_message_displayed_for_payment " + paymentType);

		checkoutPage = new CheckoutPage();
		checkoutPage.setGivenPaymentMethod(paymentType);

		checkoutPage.selectPaymentDeatils(paymentType);
		checkoutPage.acceptMedicalWaiver();
		checkoutPage.clickContinueToReviewButton();

		String errorMsg = null;

		switch (paymentType.toUpperCase()) {

		case "INVALID CARD":
			errorMsg = checkoutPage.getInvalidCardPaymentErrorMessage();
			Assert.assertEquals("Error message doesn't matched.", "Card Number is not valid", errorMsg);
			break;

		case "EXPIRED CARD":
			errorMsg = checkoutPage.getExpiredCardPaymentErrorMessage();
			Assert.assertEquals("Error message doesn't matched.", "Expiration Date is not valid", errorMsg);
			break;

		}

	}

	@When("I enter phone number {string} and select state as {string} with zipcode {string}")
	public void i_enter_invalid_phone_Number_and_select_state(String phoneNumber, String state, String zipCode)
			throws InterruptedException {

		System.out.println("verify_that_the_error_message_displayed_for_phone_number " + phoneNumber);

		checkoutPage = new CheckoutPage();
		checkoutPage.enterPersonalDeatilsWithInvalidPhone(phoneNumber);

		checkoutPage.enterShippingDetails(state, zipCode);

	}

	@Then("verify that the error message displayed for phone number {string}")
	public void verify_that_the_error_message_displayed_for_phone_number(String phoneNumber)
			throws InterruptedException {

		System.out.println("verify_that_the_error_message_displayed_for_phone_number " + phoneNumber);

		checkoutPage = new CheckoutPage();

		String errorMsg = checkoutPage.getInvalidPhoneNumberErrorMessage();
		Assert.assertEquals("Error message doesn't matched for phone number " + phoneNumber + " .",
				"Please enter a valid US phone number.", errorMsg);

	}

	@Then("verify that the error message displayed for invalid state {string} and zipcode {string} combo")
	public void verify_that_the_error_message_displayed_for_invalid_state_and_zipcode_combo(String state,
			String zipCode) throws InterruptedException {

		System.out.println("verify_that_the_error_message_displayed_for_invalid_state_and_zipcode_combo");

		checkoutPage = new CheckoutPage();

		String errorMsg = checkoutPage.getInvalidStateZipCodeComboErrorMessage();
		Assert.assertEquals("Error message doesn't matched for state " + state + " and zip code " + zipCode + " combo.",
				"Zipcode combo is incorrect", errorMsg);

	}

	@Then("order should not be placed")
	public void verify_order_should_not_be_placed() throws InterruptedException {
		System.out.println("verify_order_should_not_be_placed");
		Assert.assertEquals("User is not in checkout page.", prop.getProperty("checkoutPageURL"),
				driver.getCurrentUrl());
	}

}
