# Place an Order with one product using debitcard

Feature:
	Place an order normally using discount coupon for a particular state
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce

#This scenario works with default coupon
@smokeTest @regressionTest @oneProductWithDebitCard @production  
		Scenario Outline: Place a normal order with one product, default coupon and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
    @normalOrder @TC-NJSHOP-01
    Examples: 
      | prod  				| price		 | couponCode			|	state					|	zipCode		|	deliverBy 					| payment				| 
      | "Neo HIFI"		| "$2950"  | "FATHERSDAY20"	|	"California"	|	"95112"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-01

    @taxOrder @TC-NJSHOP-0
    Examples: 
      | prod  				| price		 | couponCode			|	state					|	zipCode		|	deliverBy 					| payment				| 
			| "Neo HIFI"		| "$2950"  | "HEAR250"			|	"ARKANSAS"		|	"71601"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-08
						
    @Hear250 @TC-NJSHOP-14
    Examples: 
      | prod  				| price		 | couponCode			|	state					|	zipCode		|	deliverBy 					| payment				| 			
			| "Neo HIFI"		| "$2950"  | "HEAR250"			|	"DELAWARE"		|	"19702"		|	"1-2 business days"	| "visa"				|	#TC-NJSHOP-14
			
    @HIFILAUNCH @TC-NJSHOP-20 @1-2BusinessDays
    Examples: 
      | prod  				| price		 | couponCode			|	state					|	zipCode		|	deliverBy 					| payment				| 						
			| "Neo HIFI"		| "$2950"  | "HIFILAUNCH"		|	"FLORIDA"			|	"32003"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-20
			
  
 #failed - mention me is not working
 #This scenario works with Mention ME (Referal Coupon)     
 @smokeTest @regressionTest @oneProductWithDebitCard @mentionMe 
		Scenario Outline: Place a normal order with one product, Hear250 coupon, Visa Payment method and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And as a user with a default email
			When I add a product <prod> in cart
			And I used a friend referral <mentionMe>
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-36
    Examples: 
      | prod  			| price		 | mentionMe				|	state			|	zipCode		|	deliverBy 					| payment				| 
      | "Neo HIFI"	| "$2950"  | "FriendReferal"	|	"FLORIDA"	|	"32003"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-36
      
#This scenario works with Billing address	        
 @smokeTest @regressionTest @oneProductWithDebitCard @differentShippingAddress 
    Scenario Outline: Place a normal order with one product, Hear250 coupon, Visa Payment method and verify the order details in Salesforce
      Given I have a product <prod> at a price of <price>
#	  	And a default coupon <couponCode> is applied
	  	And as a user with a default email
	  	When I add a product <prod> in cart
	  	And I click on checkout
      And I select state as <state> with zipcode <zipCode> 
      And I opt for <deliverBy> delivery
      And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
      And use <payment> for payment
      And I should be able to place the order with payment <payment> on a discounted price
      Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-44
    Examples: 
      | prod        | price     | couponCode	|  state      |  zipCode    |  deliverBy          	| billingState	|	billingZipCode	| payment        | 
      | "Neo HIFI"  | "$2950" 	| "Hear250" 	|  "FLORIDA"  |  "32003"    |  "1-2 business days"  | "FLORIDA"			|	"32003"    			| "Master Card"  |  #TC-NJSHOP-44
          
#This scenario works Verifying "EDIT" option after going Review page	
@smokeTest @regressionTest @oneProductWithDebitCard 
    Scenario Outline: place_order_with_one_product_using_debitcard
      Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> twice in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
      And I opt for <deliverBy> delivery
      And I opt for different billing address with state <billingState> and zipCode <billingZipCode>
      And use <payment> for payment
      And I click on Edit under "Account Info" on review page
      And I edit account info
      And I edit payment method as <editedPayment>
      And I should be able to place the order with payment <editedPayment> on a discounted price
      Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-52 @verifyEdit 
    Examples: 
      | prod        | price     | couponCode    |  state        |  zipCode    |  deliverBy           	| payment  | billingState	|	billingZipCode	| editedPayment	|
      | "Neo HIFI"	| "$2950"   | "HIFILAUNCH"  |  "California"	|  "95112"    |  "1-2 business days"	| "BREAD"  | "FLORIDA"		|	"32003"    			|	"Amex"     		|	#TC-NJSHOP-52
    
@smokeTest @regressionTest @oneProductWithDebitCard
    Scenario Outline: Place a normal order with one product, default coupon and verify the order details in Salesforce
      Given I have a accessory <acc> at a price of <price>
      #And a default coupon <couponCode> is applied
      And as a user with a default email
      When I add a accessory <acc> in cart
      And I click on checkout
      And I select state as <state> with zipcode <zipCode>
      And I opt for <deliverBy> delivery
      And use <payment> for payment
      And I click on Edit under "Account Info" on review page
      And I edit account info
      And I edit payment method as <editedPayment>
      And I should be able to place the order with payment <editedPayment> on a discounted price
      Then verify that the order details should be present in Salesforce
     
    @TC-NJSHOP-53 @verifyEdit
    Examples: 
      | acc      | price    | couponCode    |  state        |  zipCode	|  deliverBy          	| payment  |	editedPayment	| billingState	|	billingZipCode	|
      | "Wax"    | "$25"    | "HIFILAUNCH"  |  "California"	|  "95112"	|  "1-2 business days"  | "VISA"   |	"Paypal"     	| "FLORIDA" 		|	"32003"     		|	#TC-NJSHOP-53

          
          