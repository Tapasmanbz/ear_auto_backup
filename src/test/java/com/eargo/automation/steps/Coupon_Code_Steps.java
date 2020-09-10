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

public class Coupon_Code_Steps extends TestBase {

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

	@When("I applied coupon code {string} on cart page")
	public void i_applied_coupon_code_on_cart_page(String couponCode) throws InterruptedException {

		cartPage = new CartPage();

		if (cartPage.isCouponApplied()) {
			cartPage.removeCoupon();
		}

		cartPage.applyCoupon(couponCode);

		cartPage.setCouponErrorMessage();
	}

	@When("I applied coupon code {string} on checkout page")
	public void i_applied_coupon_code_on_checkout_page(String couponCode) throws InterruptedException {

		if (cartPage.isCouponApplied()) {
			cartPage.removeCoupon();
		}

		cartPage.applyCoupon(couponCode);

		checkoutPage = new CheckoutPage();
		checkoutPage.setCouponErrorMessage();
	}

	@When("I applied coupon code {string} on review page")
	public void i_applied_coupon_code_on_review_page(String couponCode) throws InterruptedException {

		reviewPage = new ReviewPage();
		//	reviewPage = checkoutPage.clickContinueToReviewButton();

		if (cartPage.isCouponApplied()) {
			cartPage.removeCoupon();
		}

		reviewPage.applyCoupon(couponCode);

		reviewPage.setCouponErrorMessage();

	}

	@When("I place the order with payment method {string}")
	public void i_place_the_order(String paymentMethod) throws InterruptedException {

		if (prop.getProperty("environment").equalsIgnoreCase("staging")) {

			switch (paymentMethod.toUpperCase()) {
			case "BREAD":

				orderConfirmationPage = reviewPage.breadPayment();

				break;
			case "PAYPAL":
				// Need to develop
				System.out.println("Going to select paypal paynow button");
				orderConfirmationPage = reviewPage.payPalPayment();

				break;
			case "VISA":
			case "AMEX":
			case "MASTER":
			case "JCB":
			default:
				orderConfirmationPage = reviewPage.clickCompleteOrderButton();

			}

		}
	}

	@Then("verify that the error message displayed for coupon type {string}")
	public void verify_that_the_error_message_displayed_for_invlaid_coupon(String couponType)
			throws InterruptedException {

		switch(couponType.toUpperCase()) {
		case "EXPIRED":
			Assert.assertEquals("Error message doesn't matched on Cart Page.", "Coupon Expired!", cartPage.getCouponErrorMessage());
			Assert.assertEquals("Error message doesn't matched on Checkout Page.", "Coupon Expired!", checkoutPage.getCouponErrorMessage());
			Assert.assertEquals("Error message doesn't matched on Review Page.", "Coupon Expired!", reviewPage.getCouponErrorMessage());
			break;
		case "INVALID":
			Assert.assertEquals("Error message doesn't matched on Cart Page.", "Coupon not found", cartPage.getCouponErrorMessage());
			Assert.assertEquals("Error message doesn't matched on Checkout Page.", "Coupon not found", checkoutPage.getCouponErrorMessage());
			Assert.assertEquals("Error message doesn't matched on Review Page.", "Coupon not found", reviewPage.getCouponErrorMessage());
			break;
		case "INELIGIBLE":
			Assert.assertEquals("Error message doesn't matched on Cart Page.", "Ineligible coupon", cartPage.getCouponErrorMessage());
			Assert.assertEquals("Error message doesn't matched on Checkout Page.", "Ineligible coupon", checkoutPage.getCouponErrorMessage());
			Assert.assertEquals("Error message doesn't matched on Review Page.", "Ineligible coupon", reviewPage.getCouponErrorMessage());
			break;
		}

	}

	@Then("I should be able to place the order with coupon code {string}")
	public void i_should_be_able_to_place_the_order_with_coupon_code(String couponCode) throws InterruptedException {

	}

}
