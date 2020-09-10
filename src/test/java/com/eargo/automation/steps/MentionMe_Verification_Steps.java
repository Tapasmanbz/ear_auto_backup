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

public class MentionMe_Verification_Steps extends TestBase {

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

	@When("I used a friend referral with already avail {string} email id")
	public void I_used_a_friend_referral_with_already_avail_email_id(String friendRefree) throws InterruptedException {
		basePage = new BasePage();
		cartPage = new CartPage();

		String refreeEmail = prop.getProperty("usedFriendRefreeEmail");
		basePage.setDefaultEmail(refreeEmail);
		if (cartPage.checkDefaultCouponApplied()) {
			cartPage.removeCoupon();
		}
		mentionMe = cartPage.clickReferByFriend();
		mentionMe.findFriend();
		mentionMe.submitFriendDetails();
		mentionMe.submitRefreeDetails(refreeEmail);
	}

	@When("I remove a product {string} from cart")
	public void I_remove_a_product_from_cart(String product) throws InterruptedException {
		
		System.out.println("Given  product is" + product);
		
		cartPage = new CartPage();

		switch (product.toUpperCase()) {
		case "NEO":
			cartPage.removeNeo();
			break;
		case "MAX":
			cartPage.removeMax();
			break;
		case "NEO HIFI":
			cartPage.removeNeoHifi();
			break;
		default:
			System.out.println("Invalid Product");
		}

	}

	@Then("verify that the error message displayed for already referal code availed email id")
	public void verify_that_the_error_message_displayed_for_already_availed_email_id() throws InterruptedException {

		System.out.println("verify_that_the_error_message_displayed_for_already_availed_email_id ");
		String expectedErrorMsg = "SORRY, TESTACCOUNTFIRST - YOU’VE ALREADY CLAIMED THIS OFFER.";
		Assert.assertEquals("Error message doesn't Matched.", expectedErrorMsg, mentionMe.getMentionMeErrorMessage());

	}

}
