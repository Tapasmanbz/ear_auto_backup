#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@shop
Feature:
	Place an order with invalid coupon
	In order to ensure that coupon should not applied using invalid coupons
	As a user
	I want to run a test to verify error messsage is displayed
	
#This scenario works with default coupon
@smokeTest @regressionTest @singleProductUsingInvalidCoupon @couponValidation
		Scenario Outline: [TC-NJSHOP-65, TC-NJSHOP-66, TC-NJSHOP-67, TC-NJSHOP-27] Place a normal order with one product, invalid coupon and verify error messsage is displayed on cart page
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I applied coupon code <couponCode> on cart page
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I applied coupon code <couponCode> on checkout page
			And use <payment> for payment
			And I applied coupon code <couponCode> on review page
			And I place the order with payment method <payment>
			Then verify that the error message displayed for coupon type <couponType>
			And I should be able to place the order with coupon code <couponCode>
			And verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-65 @negativeScenario
    Examples: 
      | prod  			| price		 | couponCode			| couponType	|	state					|	zipCode		|	deliverBy 					| payment				| 
      | "Neo HIFI"	| "$2950"  | "FATHERSDAY20"	| "Invalid"		|	"California"	|	"95112"		|	"3-5 business days"	| "Master Card"	|	#TC-NJSHOP-65
    
    @TC-NJSHOP-66 @negativeScenario
    Examples: 
      | prod  			| price		 | couponCode			| couponType	|	state					|	zipCode		|	deliverBy 					| payment				|   
      | "Neo"				| "$2350"  | "NEOLAUNCH"		| "Invalid"		|	"Arkansas"		|	"71730"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-66
    
    @TC-NJSHOP-67 @negativeScenario
    Examples: 
      | prod  			| price		 | couponCode			| couponType	|	state					|	zipCode		|	deliverBy 					| payment				|      
      | "Max"				| "$1850"  | "HIFILAUNCH"		| "Expired"		|	"Arkansas"		|	"71730"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-67
    
    @TC-NJSHOP-27 @HIFILAUNCH
    Examples: 
      | prod  			| price		 | couponCode			| couponType	|	state					|	zipCode		|	deliverBy 					| payment				|   
			| "Neo"				| "$1850"  | "HIFILAUNCH"		| "Expired"		|	"Arkansas"		|	"71730"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-27
			
#This scenario works with default coupon
@smokeTest @regressionTest @singleAccessoriesUsingInvalidCoupon @couponValidation
		Scenario Outline: [TC-NJSHOP-27] Place a normal order with one accessory, invalid coupon and verify error messsage is displayed on cart page
			Given I have a accessory <acc> at a price of <price>
			And as a user with a default email
			When I add a accessory <acc> in cart
			And I applied coupon code <couponCode> on cart page
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I applied coupon code <couponCode> on checkout page
			And use <payment> for payment
			And I applied coupon code <couponCode> on review page
			And I place the order with payment method <payment>
			Then verify that the error message displayed for coupon type <couponType>
			And I should be able to place the order with coupon code <couponCode>
			And verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-27 @HIFILAUNCH
    Examples: 
      | acc  					| price	 | couponCode			| couponType	|	state					|	zipCode		|	deliverBy 					| payment				|
      | "Wax"					| "$25"  | "HIFILAUNCH"		| "Expired"		|	"Arkansas"		|	"71730"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-27
		
		@TC-NJSHOP-27 @HIFILAUNCH
    Examples: 
      | acc  					| price	 | couponCode			| couponType	|	state					|	zipCode		|	deliverBy 					| payment				|
			| "Flexi Domes"	| "$25"  | "HIFILAUNCH"		| "Expired"		|	"Arkansas"		|	"71730"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-27

#This scenario works with default coupon
@smokeTest @regressionTest @multipleAccessoriestUsingInvalidCoupon @couponValidation
		Scenario Outline: [TC-NJSHOP-26] Place a normal order with multiple accessories, invalid coupon and verify error messsage is displayed on cart page
			Given I have a accessory <accessory1> at a price of <price>
			And as a user with a default email
			When I add a accessory <accessory1> in cart
			And I add a accessory <accessory2> in cart
			And I add a accessory <accessory3> in cart
			And I add a accessory <accessory4> in cart
			And I applied coupon code <couponCode> on cart page
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And I applied coupon code <couponCode> on checkout page
			And use <payment> for payment
			And I applied coupon code <couponCode> on review page
			And I place the order with payment method <payment>
			Then verify that the error message displayed for coupon type <couponType>
			And I should be able to place the order with coupon code <couponCode>
			And verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-26 
    Examples: 
      | accessory1  	| accessory2 		| accessory3 					| accessory4 			| price	| couponCode		| couponType	|	state				|	zipCode		|	deliverBy 					| payment		| 
      | "Flexi Palms"	| "Flexi Domes"	| "Flexi TetraPalms"	| "Flexi Fibers"	| "$25" | "HIFILAUNCH"	| "Expired"		|	"Virginia"	|	"20101"		|	"3-5 business days"	| "Paypal"	|	#TC-NJSHOP-26
      