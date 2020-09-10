package com.eargo.automation.steps;

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

}
