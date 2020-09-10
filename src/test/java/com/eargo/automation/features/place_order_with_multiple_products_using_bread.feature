# Place an Order with multiple product using bread

Feature:
	Place an order with multiple product using Bread financing
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce
	
#This scenario works with different billing address
@smokeTest @regressionTest @multipleProductOrderWithBread @bread
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have multiple products <prod1>, <prod2>, <prod3> at a price of <price1>, <price2> and <price3>
			And I have a accessory <acc> at a price of <accPrice>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod1> in cart
			And I add a product <prod2> in cart
			And I add a product <prod3> twice in cart
			And I add a accessory <acc> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
			And use <payment> for payment
			And I edit shipping info with state <editedShippingState> and zipCode <editedShippingZipCode>
			And I edit payment method as <editedPayment>
			And I should be able to place the order with payment <editedPayment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
      Examples: 
      | prod1 		| prod2 | prod3 | acc 							| price1	 |price2	 |price3	|accPrice| couponCode			|	state			|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment	|	editedPayment	| editedShippingState	|	editedShippingZipCode	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"FLEXI TETRAPALMS"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "HIFILAUNCH" 	|	"FLORIDA"	|	"32003"		|	"1-2 business days"	|  "FLORIDA"		|	"32003"    			|	"Paypal"	|		"Bread"     |"WASHINGTON"					|	"98101"								|#TC-NJSHOP-54 (Different Shipping Address)
      		


#-----------------------------------As per older scenarios-----------------------------------------------

#This scenario works with default coupon
@smokeTest @regressionTest @multipleProductOrderUsingBread @TC-NJSHOP-31
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
#			And I add a accessory <acc> in cart
#			And I add a accessory <acc> in cart
			And I add a accessory <acc> in cart twice
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
    Examples: 
      | prod	| acc 					| price		|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| payment	| 
	    | "Neo"	|"Flexi Domes"	| "$2350" |	"$25"  | "HIFILAUNCH" 	|	"NEW JERSEY"	|	"07097"		|	"3-4 business days"	| "Bread"	|	#TC-NJSHOP-05 (Normal Order)
	    | "Neo"	|"Flexi Fibers"	| "$2350" |	"$25"  | "Hear250" 			|	"WASHINGTON"	|	"98101"		|	"3-4 business days"	| "Bread"	|	#TC-NJSHOP-12 (Tax Applied Address)
      | "Max"	|"Flexi Fibers"	| "$1850" |	"$25"  | "Hear250" 			|	"VERMONT"			|	"05009"		|	"3-4 business days"	| "Bread"	|	#TC-NJSHOP-17 (Hear 250)
    	| "Neo"	|"Flexi Fibers"	| "$2350" |	"$25"  | "Mothersday20" |	"VERMONT"			|	"05009"		|	"3-4 business days"	| "Bread"	|	#TC-NJSHOP-23 (Expired Coupon)
    	| "Neo"	|"Flexi Fibers"	| "$2350" |	"$25"  | "Hear250" 			|	"VERMONT"			|	"05009"		|	"1-2 business days"	| "Bread"	|	#TC-NJSHOP-31 (1-2 business days)
			
     	
@smokeTest @regressionTest @multipleProductOrderUsingBread @TC-NJSHOP-39 @mentionMe
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
			# And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And I add a accessory <acc> in cart
			And I used a friend referral <mentionMe>
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     #
    Examples: 
      | prod	| acc 					| price		|accPrice| mentionMe				|	state					|	zipCode		|	deliverBy 					| payment	| 
	    | "Neo"	|"Flexi Domes"	| "$2350" |	"$25"  | "FriendReferal" 	|	"NEW JERSEY"	|	"07097"		|	"3-4 business days"	| "Bread"	|	#TC-NJSHOP-39 (Mention Me)
	    
#This scenario works with different billing address
@smokeTest1 @regressionTest @multipleProductOrder @TC-NJSHOP-47
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And I have a accessory <acc> at a price of <accPrice>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I add a accessory <acc> in cart
			And I add a accessory <acc> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
    Examples: 
      | prod	| acc 					| price		|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment| 
     |	"Max"	|"Flexi Fibers"	| "$1850" |	"$25"  | "Hear250" 			|"NEW JERSEY"		|	"07097"		|	"3-4 business days"	|  "FLORIDA"		|	"32003"    			|	"Bread"	|	#TC-NJSHOP-47 (Different Shipping Address)
     

#This scenario works with different billing address
		@smokeTest1 @regressionTest @multipleProductOrder @TC-NJSHOP-54
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have multiple products <prod1>, <prod2>, <prod3> at a price of <price1>, <price2> and <price3>
			And I have a accessory <acc> at a price of <accPrice>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod1> in cart
			And I add a product <prod2> in cart
			And I add a product <prod3> twice in cart
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
     
      Examples: 
      | prod1 		| prod2 | prod3 | acc 	| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment	|	editedPayment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Wax"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "HIFILAUNCH" 	|	"California"	|	"95112"		|	"3-4 business days"	|  "FLORIDA"		|	"32003"    			|	"Paypal"	|		"Bread"     |#TC-NJSHOP-54 (Different Shipping Address) 

