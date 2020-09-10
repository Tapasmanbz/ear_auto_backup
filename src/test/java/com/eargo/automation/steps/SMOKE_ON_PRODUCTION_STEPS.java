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
		
		Assert.assertEquals("User Name doesn't matched", "TestAccountFirst TestAccountLast",  reviewPage.getCouponErrorMessage());
		Assert.assertEquals("User Phone Number doesn't matched", prop.getProperty("Phone"),  reviewPage.getCouponErrorMessage());
		Assert.assertEquals("User Eamil doesn't matched", prop.getProperty("defaultEmail"), reviewPage.getCouponErrorMessage());
		
		
		Assert.assertEquals("Shipping street doesn't matched", prop.getProperty("shippingStreetAddress"), reviewPage.getCouponErrorMessage());
		Assert.assertEquals("Shipping Address doesn't matched", "Need to develop", reviewPage.getCouponErrorMessage());
		
		Assert.assertEquals("Billing street doesn't matched", prop.getProperty("editedShippingStreetAddress"), reviewPage.getCouponErrorMessage());
		Assert.assertEquals("Billing Address doesn't matched","Need to develop", reviewPage.getCouponErrorMessage());
		
		Assert.assertEquals("Estimated Delivery Date doesn't matched","Need to develope", reviewPage.getCouponErrorMessage());
		
		Assert.assertEquals("Payment type doesn't matched","Need to develope", reviewPage.getCouponErrorMessage());
						
	}
	
	

}
