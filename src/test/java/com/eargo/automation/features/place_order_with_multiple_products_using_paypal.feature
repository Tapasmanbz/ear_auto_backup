# Place an Order with multiple product using payPal

@shop
Feature: 
	Place an order for one product using Paypal
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce
  I want to use this template for my feature file

#This scenario works with placing order with default coupon using PAYPAL
@smokeTest @regressionTest @multipleProductOrderWithPaypal 
	Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
    @normalOrder @TC-NJSHOP-04
    Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state						|	zipCode		|	deliverBy 					| payment		| 
	    | "Neo Hifi"	|"Flexi TetraPalms"	| "$2950" |	"$25"  | "HIFILAUNCH" 	|	"NEW YORK"			|	"10001"		|	"3-4 business days"	| "Paypal"	|	#TC-NJSHOP-04


#This scenario works with placing order with Tax applied address, 1-2 Business days and with various coupons like : Hear250, HifiLaunch, MothersDay20 using PAYPAL
@smokeTest @regressionTest @multipleProductOrderWithPaypal 
	Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce


		@taxOrder @TC-NJSHOP-11
    Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state						|	zipCode		|	deliverBy 					| payment		| 
	    | "Neo Hifi"	|"Flexi TetraPalms"	| "$2950" |	"$25"  | "HIFILAUNCH" 	|	"PENNSYLVANIA"	|	"15001"		|	"3-4 business days"	| "Paypal"	|	#TC-NJSHOP-11

		@Hear250 @TC-NJSHOP-16
    Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state						|	zipCode		|	deliverBy 					| payment		| 
			| "Neo Hifi"	|"Flexi TetraPalms"	| "$2950" |	"$25"  | "HEAR250" 			|	"WEST VIRGINIA"	|	"24701"		|	"3-4 business days"	| "Paypal"	|	#TC-NJSHOP-16

		#Duplicate of @TC-NJSHOP-11
		@taxOrder @TC-NJSHOP-22
    Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state						|	zipCode		|	deliverBy 					| payment		| 
	    | "Neo Hifi"	|"Flexi TetraPalms"	| "$2950" |	"$25"  | "HIFILAUNCH" 	|	"PENNSYLVANIA"	|	"15001"		|	"3-4 business days"	| "Paypal"	|	#TC-NJSHOP-22

		@1-2BusinessDays @TC-NJSHOP-30
    Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state						|	zipCode		|	deliverBy 					| payment		| 
			| "Neo Hifi"	|"Flexi TetraPalms"	| "$2950" |	"$25"  | "HIFILAUNCH"		|	"INDIANA"				|	"46077"		|	"1-2 business days"	| "Paypal"	|	#TC-NJSHOP-30

	

#This scenario works with Mention ME		
@smokeTest @regressionTest @multipleProductOrderWithPaypal @mentionMe 
	Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And I used a friend referral <mentionMe>
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-38 
    Examples: 
      | prod				| acc 							| price		|accPrice| mentionMe				|	state						|	zipCode		|	deliverBy 					| payment		| 
	    | "Neo Hifi"	|"FLEXI TETRAPALMS"	| "$2950" |	"$25"  | "FriendReferal" 	|	"PENNSYLVANIA"	|	"15001"		|	"3-4 business days"	| "Paypal"	|	#TC-NJSHOP-38


#This scenario works with different billing address
@smokeTest @regressionTest @multipleProductOrderWithPaypal @differentShippingAddress
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
    @TC-NJSHOP-46 
    Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state				|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment| 
      | "Neo Hifi"	|"FLEXI TETRAPALMS"	| "$2950" |	"$25"  | "HIFILAUNCH" 	|	"NEW YORK"	|	"10001"		|	"1-2 business days"	|  "FLORIDA"		|	"32003"    			|	"Paypal"|	#TC-NJSHOP-46 (Different Shipping Address)
 	    

#This scenario works with different billing address with edited payment method
@smokeTest @regressionTest @multipleProductOrderWithPaypal @differentShippingAddress
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
			And use <payment> for payment	
			And I click on Edit under "Account Info" on review page
			And I edit payment method as <editedPayment>
			And I should be able to place the order with payment <editedPayment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
     	@TC-NJSHOP-55  @verifyEdit
      Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment	|	editedPayment	| 
      | "Neo Hifi"	|"FLEXI TETRAPALMS"	| "$2950" |	"$25"  | "HIFILAUNCH" 	|	"California"	|	"95112"		|	"3-4 business days"	|  "FLORIDA"		|	"32003"    			|	"Bread"		|		"Paypal"    |#TC-NJSHOP-55 (Different Shipping Address with edited payment)
