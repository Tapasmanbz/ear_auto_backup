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
	Place an order with multiple product using discount coupon for a particular state
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce

 #This scenario works with Mention ME (Referal Coupon)     
 @smokeTest @regressionTest @oneProductWithDebitCard @mentionMe 
		Scenario Outline: Place a normal order with one product, Hear250 coupon, Visa Payment method and verify the order details in Salesforce
			Given I have a product <prod> at a price of <price>
			And as a user with a default email
			When I add a product <prod> in cart
			And I used a friend referral with already avail <mentionMe> email id
			Then verify that the error message displayed for already referal code availed email id
    
    @TC-NJSHOP-62
    Examples: 
      | prod  			| price		 | mentionMe				|	state			|	zipCode		|	deliverBy 					| payment				| 
      | "Neo HIFI"	| "$2950"  | "FriendReferal"	|	"FLORIDA"	|	"32003"		|	"1-2 business days"	| "Master Card"	|	#TC-NJSHOP-62
      
      
#This scenario works with Mention ME (Referal Coupon)     
 @smokeTest @regressionTest @oneProductWithDebitCard @mentionMe 
		Scenario Outline: Place a normal order with one product, Hear250 coupon, Visa Payment method and verify the order details in Salesforce
			Given I have multiple products <prod1>, <prod2>, <prod3> at a price of <price1>, <price2> and <price3>
			And I have a accessory <acc> at a price of <accPrice>
			And as a user with a default email
			When I add a product <prod1> in cart
			And I add a product <prod2> in cart
			And I add a product <prod3> in cart
			And I add a accessory <acc> in cart
			And I used a friend referral <mentionMe>
			And I remove a product <prod1> from cart
			And I remove a product <prod2> from cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-63 @mentionMe
    Examples: 
      | prod1 		| prod2 | prod3 | acc 	| price1	 |price2	 |price3	|accPrice| mentionMe				|	state					|	zipCode		|	deliverBy 					| payment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Wax"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "FriendReferal" 	|	"California"	|	"95112"		|	"3-4 business days"	| "Amex"	|	#TC-NJSHOP-63 (Mention ME)
 
 
 