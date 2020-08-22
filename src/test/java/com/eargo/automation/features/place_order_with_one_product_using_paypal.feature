# Place an Order with one product using payPal

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
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @normalOrder @TC-NJSHOP-06 
    Examples: 
      | prod  			| price		 | couponCode		|	state	|	zipCode		|payment	| 
      | "Neo Hifi"	| "$2950"  | "HIFILAUNCH"	|	"WA"	|	"98101"		|"Paypal"	|	#TC-NJSHOP-06
      
      
@smokeTest @regressionTest @oneProductWithPaypal  
		Scenario Outline: TC-NJSHOP-50
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
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
      | prod        | price   | couponCode    |  state        |  zipCode    |  deliverBy           	| payment  |	editedPayment	| billingState	|	billingZipCode	| editedShippingState	|	editedShippingZipCode	| 
      | "Neo HIFI"	| "$2950"	| "HIFILAUNCH"  |  "California"	|  "95112"    |  "1-2 business days"	| "BREAD"  |	"Paypal"     	| "FLORIDA"			|	"32003"    			| "FLORIDA"						|				"32003"    			|	#TC-NJSHOP-50
    
 
@smokeTest @regressionTest @oneProductWithPaypal 
		Scenario Outline: TC-NJSHOP-50
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
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
    