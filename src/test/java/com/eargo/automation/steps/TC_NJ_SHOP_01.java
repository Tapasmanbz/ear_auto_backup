package com.eargo.automation.steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
import io.cucumber.java.en.When;

public class TC_NJ_SHOP_01 extends TestBase {

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

	String discountValue = null;
	String orderNumber = null;
	String email = null;
	String shippingAddress = null;
	String deliveryDate = null;
	String orderSummaryAmount = null;
	String originalProductPrice = null;
	String originalProductQuantity = null;
	String taxAmount = null;
	String shippingCharges = null;
	private String enteredProd1 = null;
	private boolean isUserOptDifferentBilling = false;

	@Given("I have a product {string} at a price of {string}")
	public void i_have_a_product_at_a_price_of(String productName, String productPrice) throws InterruptedException {

		if (driver == null) {
			// invoking the browser with application URL
			// initialization();
		}

		salesforcePage = new SalesforcePage();
		salesforcePage.setNeoHifiProdName(productName);
		salesforcePage.setNeoHifiProdPrice(productPrice);

	}

	@Given("I have following products {string}, {string}, {string} with accessory {string} at a price of {string}, {string}, {string}, {string}")
	public void i_have_following_products_with_accessory_at_a_price_of(String prod1, String prod2, String prod3,
			String acc1, String prod1Price, String prod2Price, String prod3Price, String acc1Price) {

		if (driver == null) {
			// invoking the browser with application URL
			// initialization();
		}

		salesforcePage = new SalesforcePage();
		salesforcePage.setNeoHifiProdName(prod1);
		salesforcePage.setNeoHifiProdPrice(prod1Price);
	}

	@Given("a default coupon {string} is applied")
	public void a_default_coupon_is_applied(String couponCode) throws InterruptedException {

		salesforcePage.setCoupon(couponCode);

	}

	@Given("as a user with a default email")
	public void a_user_with() throws InterruptedException {

		basePage = new BasePage();
		basePage.setDefaultEmail(prop.getProperty("defaultEmail"));
		basePage.setFirstName();
		basePage.setLastName();
		basePage.setPhoneNumber();

	}

	@When("I add a product {string} in cart")
	public void i_Add_a_Product_in_the_cart(String product) throws InterruptedException {

		System.out.println("Given  product is" + product);

		switch (product.toUpperCase()) {
		case "NEO":
			System.out.println("inside neo" + neoPage);
			neoPage = new NeoPage();
			neoPage.navigateToProductPage("NEO");
			cartPage = neoPage.click_add_to_cart();
			break;
		case "MAX":
			System.out.println("inside max");
			maxPage = new MaxPage();
			maxPage.navigateToProductPage("MAX");
			cartPage = maxPage.click_add_to_cart();
			break;
		case "NEO HIFI":
		default:
			System.out.println("inside hifi");
			neoHifiPage = new NeoHifiPage();
			neoHifiPage.navigateToProductPage("NEO HIFI");
			cartPage = neoHifiPage.click_add_to_cart();
			System.out.println("added neo-hifi to cart");
		}

	}

	@When("I add a accessory {string} in cart")
	public void i_add_a_accessory_in_cart(String accessories) throws InterruptedException {

		// Thread.sleep(5000);
		accessoriesPage = new AccessoriesPage();
		accessoriesPage.navigateToProductPage("Accessories");
		cartPage = accessoriesPage.click_add_Flexi_to_cart(accessories, "regular");
	}

	@When("I add a accessory {string} in cart twice")
	public void i_add_a_accessory_in_cart_twice(String accessories) throws InterruptedException {

		// Thread.sleep(3000);
		accessoriesPage = new AccessoriesPage();
		accessoriesPage.navigateToProductPage("Accessories");
		accessoriesPage.click_add_Flexi_to_cart(accessories, "regular");
		// accessoriesPage.navigateToProductPage("Accessories");
		cartPage.closeCart();
		cartPage = accessoriesPage.click_add_Flexi_to_cart(accessories, "regular");
	}

	@When("I add a accessory {string}, {string}, {string}, {string} and {string} in cart")
	public void i_add_a_accessory_and_in_cart(String acc1, String acc2, String acc3, String acc4, String acc5)
			throws InterruptedException {

		Thread.sleep(5000);
		accessoriesPage = new AccessoriesPage();
		accessoriesPage.navigateToProductPage("Accessories");

		cartPage = accessoriesPage.click_add_Flexi_to_cart(acc1, "regular");
		cartPage.closeCart();

		Thread.sleep(2000);
		cartPage = accessoriesPage.click_add_Flexi_to_cart(acc2, "regular");
		cartPage.closeCart();

		Thread.sleep(2000);
		cartPage = accessoriesPage.click_add_Flexi_to_cart(acc3, "regular");
		cartPage.closeCart();

		Thread.sleep(2000);
		cartPage = accessoriesPage.click_add_Flexi_to_cart(acc4, "regular");
		cartPage.closeCart();

		Thread.sleep(2000);
		cartPage = accessoriesPage.click_add_Flexi_to_cart(acc5, "regular");

	}

	@When("I close the cart")
	public void i_close_the_cart() throws InterruptedException {

		cartPage.closeCart();
	}

	@When("I click on checkout")
	public void i_click_on_checkout() throws InterruptedException {

		checkoutPage = cartPage.clickCheckoutButton();
	}

	@When("I select state as {string} with zipcode {string}")
	public void i_select_state_as(String state, String zipCode) throws InterruptedException {

		checkoutPage.enterPersonalDeatils();

		checkoutPage.enterShippingDetails(state, zipCode);

	}

	@When("I opt for different billing address with state {string} and zipCode {string}")
	public void i_select_state_as_zipcode_with_different_shipping_address(String state, String zipCode)
			throws InterruptedException {

		checkoutPage.enterBillingDeatils(state, zipCode);
		isUserOptDifferentBilling = true;

	}

	@When("I opt for {string} delivery")
	public void i_opt_for_delivery(String deliveryOption) throws InterruptedException {

		if (deliveryOption.equalsIgnoreCase("1-2 business days")) {
			System.out.println("i opt for 1-2 business days");
			checkoutPage.selectAcceleratedShipping();
			checkoutPage.calculateEstimatedDeliveryDate("1-2 business days");

		} else {
			System.out.println("i opt for 3-4 business days");
			checkoutPage.selectNormalShipping();
			checkoutPage.calculateEstimatedDeliveryDate("3-4 business days");
		}
	}

	@When("use {string} for payment")
	public void use_for_payment(String paymentType) throws InterruptedException {

		// checkoutPage = new CheckoutPage();
		checkoutPage.setGivenPaymentMethod(paymentType);

		System.out.println("in step defination payment method is = " + paymentType);

		checkoutPage.selectPaymentDetails(paymentType);
		checkoutPage.acceptMedicalWaiver();

		checkoutPage.setIsBreadPaymentMethodDisplayed();

		reviewPage = checkoutPage.clickContinueToReviewButton();

	}

	// @When("I should be able to place the order on a discounted price")
	@When("I should be able to place the order with payment {string} on a discounted price")
	public void i_should_be_able_to_place_the_order_on_a_discounted_price(String paymentMethod)
			throws InterruptedException {

		// checkoutPage.acceptMedicalWaiver();
		// reviewPage = checkoutPage.clickContinueToReviewButton();

		if (prop.getProperty("environment").equalsIgnoreCase("staging")) {

			switch (paymentMethod.toUpperCase()) {
			case "BREAD":

				orderConfirmationPage = reviewPage.breadPayment();

				break;
			case "PAYPAL":
				System.out.println("Going to select paypal paynow button");
				orderConfirmationPage = reviewPage.payPalPayment();
				break;
			case "VISA":
			case "AMEX":
			case "MASTER":
			case "MASTER CARD":
			case "JCB":
			default:
				orderConfirmationPage = reviewPage.clickCompleteOrderButton();

			}

			// if (prop.getProperty("environment").equalsIgnoreCase("staging")) {

			// orderConfirmationPage = reviewPage.clickCompleteOrderButton();
		}

	}

	@Then("verify that the order details should be present in Salesforce")
	public void verify_that_the_order_details_should_be_present_in_Salesforce() throws InterruptedException {

		System.out.println(driver.getWindowHandle());

		orderConfirmationPage = new OrderConfirmationPage();

		if (prop.getProperty("environment").equalsIgnoreCase("staging")) {
			
			discountValue = orderConfirmationPage.getDiscountValue();
			orderNumber = orderConfirmationPage.getOrderNumber();
			email = orderConfirmationPage.getEmailID();

			shippingAddress = orderConfirmationPage.getShippingAddress();
			deliveryDate = orderConfirmationPage.getDeliveryDate();
			orderSummaryAmount = orderConfirmationPage.getOrderSummaryAmount();
			originalProductPrice = orderConfirmationPage.getOriginalProductPrice();
			originalProductQuantity = orderConfirmationPage.getOriginalProductQuantity();
			taxAmount = orderConfirmationPage.getTaxAmount();
			shippingCharges = orderConfirmationPage.getShippingCharges();

			String productSubtotal = orderConfirmationPage.getProductSubtotalAmt(originalProductPrice,
					originalProductQuantity);

			HashMap<String, String> orderedProductDetails = orderConfirmationPage.getOrderProducts();

			Set<Entry<String, String>> stockSet = orderedProductDetails.entrySet();

			// Iterator<Entry<String, String>> i = stockSet.iterator();
			// System.out.println("Iterating over Hashtable in Java");
			// Iterator begins
			// while (i.hasNext()) {
			// Entry<String, String> m = i.next();
			// String key = m.getKey();
			// String value = m.getValue();
			// System.out.println("TCKey :" + key + " TCValue :" + value);
			// }

			String orderNumber = orderConfirmationPage.getOrderNumber();

			SalesforcePage salesforcePage = new SalesforcePage();
			salesforcePage.salesforceLogin(orderNumber);

			// 1. Verify order number
			// if (prop.getProperty("SFUserName").contains(".eargopc1")) {
			// Assert.assertEquals("Order Number doesn't displayed on the Salesforce Page",
			// orderNumber,
			// salesforcePage.orderNumPC1.getText());
			// } else if (prop.getProperty("SFUserName").contains(".webstore")) {
			Assert.assertEquals("Order Number doesn't displayed on the Salesforce Page", orderNumber,
					salesforcePage.orderNum.getText());
			// }
			System.out.println("verification 1 passes");

			// 2. Verify Email ID
			Assert.assertEquals("Email ID doesn't match for order no: " + orderNumber, email,
					checkoutPage.getEnteredCustomerEmailID());
			System.out.println("verification 2 passes");

			// 3. Verify shipping address
			// Assert.assertEquals(shippingAddress, salesforcePage.sfshippingAddress());
			// System.out.println("verification 3 passes");

			// 4. Verify the order total price
			// if (prop.getProperty("SFUserName").contains(".eargopc1")) {
			// Assert.assertEquals("Order summary amount doesn't matched with Order
			// Confirmation Page",
			// orderSummaryAmount, salesforcePage.finalProductPricePC1.getText());
			// } else if (prop.getProperty("SFUserName").contains(".webstore")) {
			Assert.assertEquals(
					"Order summary amount doesn't match with Order Confirmation Page for order no: " + orderNumber,
					orderSummaryAmount, salesforcePage.finalProductPrice.getText());
			// }
			System.out.println("verification 4 passes");

			// Assert.assertEquals(productSubtotal,
			// salesforcePage.actualproductPrice.getText());

			// 5. Verify tax (which applied with respect to state address)
			Assert.assertEquals("Tax amount doesn't match for order no: " + orderNumber, taxAmount,
					salesforcePage.sfOrderTax());
			System.out.println("verification 5 passes");

			// 6. Verify Shipping Charges
			Assert.assertEquals("Shipping charges doesn't match for order no: " + orderNumber, shippingCharges,
					salesforcePage.sfShippingTax());
			System.out.println("verification 6 passes");

			// 7. Verify payment type
			// paymentType = salesforcePage.getGivenPaymentType();
			Assert.assertEquals("Payment type doesn't match for order no: " + orderNumber,
					reviewPage.getPaymentMethod(), salesforcePage.sfPaymentType());
			System.out.println("verification 7 passes");

			// ----------------------------------------------------------------------------------

			// 8. Verify product details
			// Need to be developed
			HashMap<String, String> orderedProductDetailsSalesforce = null;
			// if (prop.getProperty("SFUserName").contains(".eargopc1")) {
			// // Navigate to Related Tab
			// // salesforcePage.navigateToOrderRelatedTabSalesForcePC1();
			//
			// orderedProductDetailsSalesforce =
			// salesforcePage.getOrderProductsOnSalesForcePC1();
			// orderedProductDetailsSalesforce =
			// salesforcePage.getOrderProductsOnSalesForce();
			// } else if (prop.getProperty("SFUserName").contains(".webstore")) {
			orderedProductDetailsSalesforce = salesforcePage.getOrderProductsOnSalesForce();
			// }


			Iterator<Entry<String, String>> stockIterator = stockSet.iterator();
			System.out.println("Iterating over Hashtable in Java");
			// Iterator begins
			while (stockIterator.hasNext()) {
				Entry<String, String> m = stockIterator.next();
				String key = m.getKey();
				String value = m.getValue();
				System.out.println("TCV_Key :" + key + " TCV_Value :" + value);

				Assert.assertTrue(key + " is not present in the salesforce product list",
						orderedProductDetailsSalesforce.containsKey(key));

				Assert.assertEquals("Quantity doesn't matched for order no: " + orderNumber, value,
						orderedProductDetailsSalesforce.get(key));
			}

			// ----------------------------------------------------------------------------------

			// 9. verify Estimated Delivery Date
			Assert.assertEquals("Estimated delivery date doesn't matched for order no: " + orderNumber,
					checkoutPage.getExpectedDeliveryDate(), deliveryDate);
			System.out.println("verification 9 passes");

			// 10. Verify 'Order Status'
			if (isUserOptDifferentBilling) {
				Assert.assertEquals("Order status doesn't matched for order no: " + orderNumber, "Pending Approval",
						salesforcePage.orderStatus.getText());
				System.out.println("verification 10 passes");

			}

			// 11. Verify Store Orders Total
			double calculatedTotal = salesforcePage.getStoreSubTotal()
					+ salesforcePage.getStoreShippingAndHandlingCost() + salesforcePage.getStoreTax()
					- salesforcePage.getStorePromoDiscount();
			Assert.assertEquals("Store order total and calculated total are not matched for order no: " + orderNumber,
					salesforcePage.getStoreOrderTotal(), calculatedTotal, 0);

		}

	}

	@When("a coupon {string} is applied")
	public void a_coupon_is_applied(String couponCode) throws InterruptedException {

		ArrayList<String> allProductName = cartPage.getAllCartProductName();
		boolean isCouponRemoved = false;

		// Commented as there is no default coupon applied now.
		// for (String productName : allProductName) {
		// switch (productName.toUpperCase().trim()) {
		// case "EARGO NEO HIFI":
		// isCouponRemoved = cartPage.removeCoupon();
		// break;
		// default:
		// break;
		// }
		//
		// if (isCouponRemoved)
		// break;
		// }

		cartPage.applyCoupon(couponCode);

	}

	@When("I used a friend referral {string}")
	public void i_used_a_friend_referral(String friendReferral) throws InterruptedException {

		String refreeEmail = BasePage.generateUniqueEmail();
		basePage.setDefaultEmail(refreeEmail);
		if (cartPage.checkDefaultCouponApplied()) {
			cartPage.removeCoupon();
		}
		mentionMe = cartPage.clickReferByFriend();
		mentionMe.findFriend();
		mentionMe.submitFriendDetails();
		mentionMe.submitRefreeDetails(refreeEmail);
		mentionMe.continueShopping();
		String couponCode = cartPage.applyReferralCoupon();
		salesforcePage.setCoupon(couponCode);
	}

	@Given("a referal coupon with existing user {string}")
	public void a_referal_coupon_with_existing_user(String string) {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I apply referal coupon using {string}")
	public void i_apply_referal_coupon_using(String string) {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("a referal coupon with existing user <mailID>")
	public void a_referal_coupon_with_existing_user_mailID() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I apply referal coupon using <mailID>")
	public void i_apply_referal_coupon_using_mailID() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I opt for different shipping address")
	public void i_opt_for_different_shipping_address() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I add a product {string} twice in cart")
	public void i_add_product_twice(String product) throws InterruptedException {

		switch (product.toUpperCase()) {
		case "NEO":
			neoPage = new NeoPage();
			neoPage.navigateToProductPage("NEO");
			neoPage.click_add_to_cart();
			cartPage = new CartPage();
			cartPage.closeCart();
			cartPage = neoPage.click_add_to_cart();
			Assert.assertEquals("2", cartPage.afterIncrement());
			break;
		case "MAX":
			maxPage = new MaxPage();
			maxPage.navigateToProductPage("MAX");
			maxPage.click_add_to_cart();
			cartPage = new CartPage();
			cartPage.closeCart();
			cartPage = maxPage.click_add_to_cart();
			Assert.assertEquals("2", cartPage.afterIncrement());
			break;
		case "NEO HIFI":
		default:
			neoHifiPage = new NeoHifiPage();
			neoHifiPage.navigateToProductPage("NEO HIFI");
			neoHifiPage.click_add_to_cart();
			cartPage = new CartPage();
			cartPage.closeCart();
			cartPage = neoHifiPage.click_add_to_cart();
			Assert.assertEquals("2", cartPage.afterIncrement());
			break;
		}

	}

	@When("I click on Edit under {string} on review page")
	public void i_click_edit_on_review_page(String sectionName) throws InterruptedException {

		ReviewPage reviewPage = new ReviewPage();

		switch (sectionName.trim()) {
		case "Ship my Eargo to":
			break;
		case "I would like to pay with":
			break;
		case "Account Info":
		default:
			reviewPage.editAccountInfo();
		}

	}

	@When("I edit account info")
	public void i_edit_account_info() throws InterruptedException {

		// CheckoutPage checkoutPage = new CheckoutPage();
		Thread.sleep(2000);
		checkoutPage.editPersonalDeatils();
		
	//	checkoutPage.accountInfoEdited();

		String enteredPaymentMethod = checkoutPage.getGivenPaymentMethod();

		System.out.println("Payment method inside edit account infor is = " + enteredPaymentMethod);
		//
		// if (enteredPaymentMethod.equalsIgnoreCase("PAYPAL") &&
		// enteredPaymentMethod.equalsIgnoreCase("BREAD")) {
		//
		// checkoutPage.enterPaymentDetails(enteredPaymentMethod);
		// }
		//

		switch (enteredPaymentMethod.toUpperCase()) {
		case "VISA":
		case "AMEX":
		case "MASTER":
			checkoutPage.enterPaymentDetails(enteredPaymentMethod);
			// reviewPage = checkoutPage.clickContinueToReviewButton();
		case "BREAD":
		case "PAYPAL":
		default:
			// reviewPage = checkoutPage.clickContinueToReviewButton();
		}

	}

	@When("I edit payment method as {string}")
	public void i_edit_payment_info(String paymentMethod) throws InterruptedException {

		// ReviewPage reviewPage = new ReviewPage();
		Thread.sleep(2000);
		// CheckoutPage checkoutPage = reviewPage.editPaymentInfo();

		// checkoutPage.enterEditedEmail();

		checkoutPage.selectPaymentDetails(paymentMethod);

		reviewPage = checkoutPage.clickContinueToReviewButton();

	}

	// @Given("I have a product {string}, {string} and {string}")
	// public void i_have_a_product(String product1, String product2, String
	// product3) throws InterruptedException {
	//
	// if (driver == null) {
	// // invoking the browser with application URL
	//// initialization();
	// }
	//
	// // Need to develop
	// System.out.println("After step 1");
	// // salesforcePage = new SalesforcePage();
	// // salesforcePage.setNeoHifiProdName(productName);
	// // salesforcePage.setNeoHifiProdPrice(productPrice);
	//
	// }

	@Given("I have a accessory {string} at a price of {string}")
	public void i_have_a_accessory_at_a_price_of(String accName, String accPrice) {

		System.out.println("value of driver inside : " + driver);

		if (driver == null) {
			// invoking the browser with application URL
			// initialization();
		}

		salesforcePage = new SalesforcePage();
		salesforcePage.setAccessoryName(accName);
		salesforcePage.setAccessoryPrice(accPrice);

	}

	@Given("I have a product {string}, {string} and {string}")
	public void i_have_a_product_and(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
	}

	@When("I click on get your rate for {string}")
	public void i_click_on_get_your_rate(String prodname) throws InterruptedException {

		basePage = new BasePage();

		// basePage.navigateToProductPage(prodname);

		System.out.println("navigated to respected page");

		Thread.sleep(2000);

		switch (prodname.toUpperCase()) {

		case "NEO":
			neoPage = new NeoPage();
			driver.get(prop.getProperty("neoPageURL"));
			basePage.waitForPageLoad();
			neoPage.neo_get_your_rate();
			System.out.println("neo click your rate clicked");
			Thread.sleep(2000);
			basePage = new BasePage();
			basePage.bread_popup();
			// Assert.assertTrue(basePage.bread_popup());
			break;

		case "MAX":
			maxPage = new MaxPage();
			driver.get(prop.getProperty("maxPageURL"));
			basePage.waitForPageLoad();
			maxPage.max_get_your_rate();

			Thread.sleep(2000);
			basePage = new BasePage();
			basePage.bread_popup();
			// Assert.assertTrue(basePage.bread_popup());
			break;

		case "NEO HIFI":
		case "HIFI":
		case "NEOHIFI":
			neoHifiPage = new NeoHifiPage();
			neoHifiPage.hifi_get_your_rate();

			Thread.sleep(2000);
			basePage = new BasePage();
			basePage.bread_popup();
			break;

		}

	}

	@When("I should able to cancel the {string}")
	public void i_should_able_to_cancel_the(String paymentmethod) throws InterruptedException {

		switch (paymentmethod.toUpperCase()) {

		case "BREAD":
			// reviewPage = checkoutPage.clickContinueToReviewButton();
			reviewPage.breadPaymentCancel();

			// checkoutPage = reviewPage.editPaymentInfo();
			// reviewPage = checkoutPage.clickContinueToReviewButton();
			break;
		case "PAYPAL":

			reviewPage.paypalPaymentCancel();
			// reviewPage = checkoutPage.clickContinueToReviewButton();
			Thread.sleep(5000);
			// checkoutPage = reviewPage.editPaymentInfo();
			// reviewPage = checkoutPage.clickContinueToReviewButton();
			break;
		}

	}

	@When("I edit shipping info with state {string} and zipCode {string}")
	public void i_edit_shipping_info(String editedState, String editedZipCode) throws InterruptedException {

		// reviewPage = checkoutPage.clickContinueToReviewButton();

		Thread.sleep(2000);

		reviewPage.editShippingInfo();

		Thread.sleep(2000);

		checkoutPage.enterEditedShippingDetails(editedState, editedZipCode);

		String enteredPaymentMethod = checkoutPage.getGivenPaymentMethod();

		System.out.println("Payment method inside edit shipping info is = " + enteredPaymentMethod);

		switch (enteredPaymentMethod.toUpperCase()) {
		case "VISA":
		case "AMEX":
		case "MASTER":
			checkoutPage.enterPaymentDetails(enteredPaymentMethod);
			// reviewPage = checkoutPage.clickContinueToReviewButton();
		case "BREAD":
		case "PAYPAL":
		default:
			// reviewPage = checkoutPage.clickContinueToReviewButton();
		}
	
		try {
			
			if(checkoutPage.btnContinueToReview.isDisplayed()) {
				reviewPage = checkoutPage.clickContinueToReviewButton();
			}
			
		}catch(Exception e) {
			
		}
		// reviewPage = checkoutPage.clickContinueToReviewButton();
	}

}
