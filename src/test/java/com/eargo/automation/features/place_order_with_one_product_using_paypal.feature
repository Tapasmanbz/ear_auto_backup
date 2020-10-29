# Place an Order with one product using payPal

@shop
Feature: 
	Place an order for one product using bread financing
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce
  I want to use this template for my feature file

#This scenario works with default coupon
@smokeTest @regressionTest @oneProductWithPaypal 
		Scenario Outline: TC-NJSHOP-06
			Given I have a product <prod> at a price of <price>
			#And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @normalOrder @TC-NJSHOP-06 
    Examples: abc
      | prod  			| price		 | couponCode		|	state	|	zipCode		|  deliverBy           	|	payment		| 
      | "Neo Hifi"	| "$2950"  | "HIFILAUNCH"	|	"WA"	|	"98101"		|  "1-2 business days"	|	"Paypal"	|	#TC-NJSHOP-06
      
      
@smokeTest @regressionTest @oneProductWithPaypal  
		Scenario Outline: TC-NJSHOP-50
			Given I have a product <prod> at a price of <price>
			#And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			#And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
      And I opt for <deliverBy> delivery
      And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
      And use <payment> for payment
      And I edit shipping info with state <editedShippingState> and zipCode <editedShippingZipCode>
      And I edit payment method as <editedPayment>
      And I should be able to place the order with payment <editedPayment> on a discounted price
      Then verify that the order details should be present in Salesforce
     
    @TC-NJSHOP-50 
    Examples: 
      | prod        | price   |  state        |  zipCode    |  deliverBy           	| payment  |	editedPayment	| billingState	|	billingZipCode	| editedShippingState	|	editedShippingZipCode	| 
      | "Neo HIFI"	| "$2950"	|  "California"	|  "95112"    |  "1-2 business days"	| "BREAD"  |	"Paypal"     	| "FLORIDA"			|	"32003"    			| "FLORIDA"						|				"32003"    			|	#TC-NJSHOP-50
    

@smokeTest @regressionTest @oneProductWithDebitCard
    Scenario Outline: [TC-NJSHOP-53] Place a normal order with one product, default coupon and verify the order details in Salesforce
      Given I have a accessory <acc> at a price of <price>
      #And a default coupon <couponCode> is applied
      And as a user with a default email
      When I add a accessory <acc> in cart
      And I click on checkout
      And I select state as <state> with zipcode <zipCode>
      And I opt for <deliverBy> delivery
      #And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
      And use <payment> for payment
      And I click on Edit under "Account Info" on review page
      And I edit account info
      And I edit payment method as <editedPayment>
      And I should be able to place the order with payment <editedPayment> on a discounted price
      Then verify that the order details should be present in Salesforce
     
    @TC-NJSHOP-53 @verifyEdit
    Examples: 
      | acc      | price    |  state        |  zipCode	|  deliverBy          	| payment  |	editedPayment	| billingState	|	billingZipCode	|
      | "Wax"    | "$25"    |  "California"	|  "95112"	|  "1-2 business days"  | "VISA"   |	"Paypal"     	| "FLORIDA" 		|	"32003"     		|	#TC-NJSHOP-53

 
@smokeTest @regressionTest @oneProductWithPaypal 
		Scenario Outline: [TC-NJSHOP-68]
			Given I have a product <prod> at a price of <price>
			#And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
      And use <payment> for payment
      And I should able to cancel the <payment>
      And I should be able to place the order with payment <payment> on a discounted price
      Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-68 @negativeScenario
    Examples: 
      | prod  			| price   | couponCode    |  state        |  zipCode    |  deliverBy           	| payment	 | 
      | "Neo Hifi"	| "$2950"	| "HIFILAUNCH"  |  "California"	|  "95112"    |  "3-4 business days"	| "Paypal" |#TC-NJSHOP-68
    