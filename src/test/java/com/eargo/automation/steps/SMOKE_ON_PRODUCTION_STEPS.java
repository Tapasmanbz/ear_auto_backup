package com.eargo.automation.steps;

import org.junit.Assert;

import com.eargo.automation.base.TestBase;

import io.cucumber.java.en.Then;

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


public class SMOKE_ON_PRODUCTION_STEPS extends TestBase  {
	
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
	
	@Then("verify that the order details are present in review page")
	public void verify_that_the_order_details_are_present_in_review_page() throws InterruptedException {
		
		//Validating "Account Info"
		Assert.assertEquals("User Name doesn't matched", "TestAccountFirst TestAccountLast",  reviewPage.getCustomerName());
		Assert.assertEquals("User Phone Number doesn't matched", prop.getProperty("Phone"),  reviewPage.getPhoneNumber());
		Assert.assertEquals("User Eamil doesn't matched", prop.getProperty("defaultEmail"), reviewPage.getEnteredEmailID());
		
		//Validating "Shipping Address"
// 		Assert.assertEquals("Shipping street doesn't matched", prop.getProperty("shippingStreetAddress"), reviewPage.getEnteredStreetAddress());
		
		//Validating "Billing Address"	
// 		Assert.assertEquals("Billing street doesn't matched", prop.getProperty("editedShippingStreetAddress"), reviewPage.getEnteredBillingStreetAddress());

		//Validating "Estimated Delivery Date"
// 		Assert.assertEquals("Estimated Delivery Date doesn't matched",checkoutPage.getExpectedDeliveryDate(), reviewPage.getDeliveryDate());
		
		//Validating "Payment type"
// 		Assert.assertEquals("Payment type doesn't matched",reviewPage.getPaymentMethod(), reviewPage.getPaymentType());
		
		//Validating "Order Summary"
		// Need to discuss with tapas as this requires the array-list way of validating
						
	}

	
	

}
