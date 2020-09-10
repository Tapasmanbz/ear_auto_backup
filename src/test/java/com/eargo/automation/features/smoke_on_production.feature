# Smoke test on production

Feature: 
	Place an order for multiple product
	In order to ensure that cart page and address page works
	As a user
	I want to run a test to verify the order data in review page

@production
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
#			Then verify that the order details are present in review page
     
      Examples: 
      | prod				| acc 							| price		|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment	|	editedPayment	| 
      | "Neo Hifi"	|"FLEXI TETRAPALMS"	| "$2950" |	"$25"  | "HIFILAUNCH" 	|	"California"	|	"95112"		|	"1-2 business days"	|  "FLORIDA"		|	"32003"    			|	"Bread"		|		"Paypal"    |#TC-NJSHOP-55 

      
 @production
		Scenario Outline: Place a normal order with multiple product, default coupon and verify the order details in Salesforce
			Given I have multiple products <prod1>, <prod2>, <prod3> at a price of <price1>, <price2> and <price3>
			And I have a accessory <acc> at a price of <accPrice>
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
#      Then verify that the order details are present in review page
    
      Examples: 
      | prod1 		| prod2 | prod3 | acc 							| price1	 |price2	 |price3	|accPrice| couponCode			|	state			|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment	|	editedPayment	| editedShippingState	|	editedShippingZipCode	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"FLEXI TETRAPALMS"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "HIFILAUNCH" 	|	"FLORIDA"	|	"32003"		|	"1-2 business days"	|  "FLORIDA"		|	"32003"    			|	"Paypal"	|		"Bread"     |"WASHINGTON"					|	"98101"								|#TC-NJSHOP-54
      		
 