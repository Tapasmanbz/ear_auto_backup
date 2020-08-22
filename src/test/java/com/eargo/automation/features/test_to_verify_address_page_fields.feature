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

Feature:
	Place an order with invalid card using discount coupon for a particular state
	In order to ensure that order should not place using invalid debit card
	As a user
	I want to run a test to verify error messsage is displayed on checkout page

#This scenario works with default coupon
@smokeTest @regressionTest @verifyAddresPageFields @singleProductUsingInvalidCC 
		Scenario Outline: Place a normal order with one product, default coupon and verify error messsage is displayed on checkout page
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			Then verify that the error message displayed for payment <payment>
			And order should not be placed
    
    @TC-NJSHOP-58 @negativeScenario
    Examples: 
      | prod  			| price		 | couponCode		|	state					|	zipCode		|	deliverBy 					| payment					| 
      | "Neo HIFI"	| "$2950"  | "HIFILAUNCH"	|	"California"	|	"95112"		|	"3-5 business days"	| "Invalid Card"	|	#TC-NJSHOP-58
    
    @TC-NJSHOP-59 @negativeScenario
    Examples: 
      | prod  			| price		 | couponCode		|	state					|	zipCode		|	deliverBy 					| payment					| 
      | "Neo"				| "$2950"  | "HIFILAUNCH"	|	"Arkansas"		|	"71730"		|	"1-2 business days"	| "Expired Card"	|	#TC-NJSHOP-59

#This scenario works with default coupon
@smokeTest @regressionTest @verifyAddresPageFields @singleProductUsingInvalidPhone 
		Scenario Outline: Place a normal order with one product, default coupon and verify error messsage is displayed on checkout page
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I click on checkout
			And I enter phone number <phoneNumber> and select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			Then verify that the error message displayed for phone number <phoneNumber>
			And order should not be placed
    
    @TC-NJSHOP-61 
    Examples: 
      | prod  | price		 |	state				|	zipCode		|	phoneNumber		|	deliverBy 					| payment				| 
      | "Max"	| "$1850"  |	"New York"	|	"10001"		|	"0000000000"	|	"3-5 business days"	| "Master Card"	|	#TC-NJSHOP-61


#This scenario works with default coupon
@smokeTest @regressionTest @verifyAddresPageFields @singleProductUsingInvalidStateZipCodeCombo 
		Scenario Outline: Place a normal order with one product, default coupon and verify error messsage is displayed on checkout page
			Given I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a accessory <acc> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			Then verify that the error message displayed for invalid state <state> and zipcode <zipCode> combo
			And order should not be placed
    
    @TC-NJSHOP-64 
    Examples: 
      | acc  	| accPrice	|	state				|	zipCode		|	deliverBy 					| payment		| 
      | "Wax"	| "$25"  		|	"New York"	|	"50001"		|	"3-5 business days"	| "JCB"			|	#TC-NJSHOP-64


#This scenario works with default coupon
@smokeTest @regressionTest @verifyAddresPageFields 
    Scenario Outline: Place a normal order with one product, default coupon and verify the order details in Salesforce
      Given I have a accessory <acc> at a price of <price>
      And as a user with a default email
      When I add a accessory <acc> in cart
      And I click on checkout
      And I select state as <state> with zipcode <zipCode>
      And I opt for <deliverBy> delivery
      And use <payment> for payment
      And I should be able to place the order with payment <payment> on a discounted price
      Then verify that no bread payment method is displayed
      And verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-03 @normalOrder
    Examples: 
      | acc      				| price |  state  |  zipCode	|  deliverBy          	| payment  | 
      | "Flexi Fibers"  | "$25"	|  "Iowa"	|  "50001"	|  "1-2 business days"  | "VISA"   |	#TC-NJSHOP-03
 