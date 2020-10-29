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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC_NJ_SHOP_STEPS extends TestBase {
	
	
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
	
	
	@Given("I have multiple products {string}, {string}, {string} at a price of {string}, {string} and {string}")
	public void i_have_multiple_products_at_a_price_of_and(String productName1, String productName2, String productName3, String productPrice1, String productPrice2, String productPrice3) {
	    
		//Need to develop for all products
		
		// if(driver==null) {
		// 	// invoking the browser with application URL
		// 	initialization();
		// 	}
			
			salesforcePage = new SalesforcePage();
			salesforcePage.setNeoHifiProdName(productName1);
			salesforcePage.setNeoHifiProdPrice(productPrice1);
			
	}


	@Given("I have multiple accessories {string}, {string}, {string}, {string}, {string} at a price of {string}, {string}, {string}, {string} and {string}")
	public void i_have_multiple_accessories_at_a_price_of_and(String acc1, String acc2, String acc3, String acc4, String acc5, String accPrice1, String accPrice2, String accPrice3, String accPrice4, String accPrice5) throws InterruptedException {
	    
		//Need to develop for all products
		
				// if(driver==null) {
				// 	// invoking the browser with application URL
				// 	initialization();
				// 	}else {
				// 		driver.quit();
				// 		Thread.sleep(5000);
				// 		initialization();
				// 	}
					
				salesforcePage = new SalesforcePage();
				salesforcePage.setNeoHifiProdName(acc1);
				salesforcePage.setNeoHifiProdPrice(accPrice1);

	}
	
	@Then("verify that the order details are present in review page")
	public void verify_that_the_order_details_are_present_in_review_page() throws InterruptedException {
		Thread.sleep(5000);
		// Validating the review page details
		
		ReviewPage reviewPage = new ReviewPage();
		
		reviewPage.verifyDetailsOnReviewPage();
//		
//		//Validating "Account Info"
//		Assert.assertEquals("User Name doesn't matched", "TestAccountFirst TestAccountLast",  reviewPage.getCustomerName());
		Assert.assertEquals("User Phone Number doesn't matched", prop.getProperty("Phone"),  reviewPage.getPhoneNumber());
		Assert.assertEquals("User Eamil doesn't matched", prop.getProperty("defaultEmail"), reviewPage.getEnteredEmailID());
//		
//		//Validating "Shipping Address"
//		Assert.assertEquals("Shipping street doesn't matched", prop.getProperty("shippingStreetAddress"), reviewPage.getEnteredStreetAddress());
//		
//		//Validating "Billing Address"	
//		Assert.assertEquals("Billing street doesn't matched", prop.getProperty("editedShippingStreetAddress"), reviewPage.getEnteredBillingStreetAddress());
//
//		//Validating "Estimated Delivery Date"
//		Assert.assertEquals("Estimated Delivery Date doesn't matched",checkoutPage.getExpectedDeliveryDate(), reviewPage.getDeliveryDate());
//		
//		//Validating "Payment type"
//		Assert.assertEquals("Payment type doesn't matched",reviewPage.getPaymentMethod(), reviewPage.getPaymentType());
//		
//		//Validating "Order Summary"
//		// Need to discuss with tapas as this requires the array-list way of validating
						
	}

}
