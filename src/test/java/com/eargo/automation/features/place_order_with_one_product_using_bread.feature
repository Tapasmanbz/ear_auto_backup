Feature: 
	Place an order for one product using bread financing
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce
  I want to use this template for my feature file

#This scenario works with default coupon
#@smokeTest @regressionTest @oneProductWithBread @production @tc_njshop_07 
		Scenario Outline: TC-NJSHOP-07
			Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
     
    @normalOrder @TC-NJSHOP-07
    Examples: 
      | prod  	| price		 | couponCode		|	state	|	zipCode		|payment	| 
      | "NEO"		| "$2350"  | "HIFILAUNCH"	|	"WA"	|	"98101"		|"Bread"	|	#TC-NJSHOP-07



#This scenario works with default coup#This scenario works with default coupon
#@smokeTest @regressionTest @oneProductWithBread @production @testOne 
    Scenario Outline: TC-NJSHOP-51
      Given I have a product <prod> at a price of <price>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod> in cart
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
      And use <payment> for payment
      And I click on Edit under "Account Info" on review page
      And I edit account info
      And I edit payment method as <editedPayment>
      And I should be able to place the order with payment <editedPayment> on a discounted price
      Then verify that the order details should be present in Salesforce
     
    @TC-NJSHOP-51 @verifyEdit
    Examples: 
      | prod  | price   | couponCode    |  state        |  zipCode    | payment  			|	editedPayment	| 
      | "Neo"	| "$2350"	| "HIFILAUNCH"  |  "California"	|  "95112"    | "MASTERCARD"  |	"BREAD"      	|#TC-NJSHOP-51
    

#This scenario works with default coup#This scenario works with default coupon
#@smokeTest @regressionTest @oneProductWithBread @production @tc_njshop_69
    Scenario Outline: TC-NJSHOP-69
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
     
    @TC-NJSHOP-69 @negativeScenario
    Examples: 
      | prod  			| price   | couponCode    |  state        |  zipCode    |  deliverBy           	| payment	 | 
      | "Neo Hifi"	| "$2950"	| "HIFILAUNCH"  |  "California"	|  "95112"    |  "1-2 business days"	| "BREAD"  |#TC-NJSHOP-69


#This scenario works with default coupon
#@smokeTest @regressionTest @oneProductWithBread @production @TC-NJSHOP-57
    Scenario Outline: Test to verify functionality of check your rate button
      Given I have a product <prod1>, <prod2> and <prod3>
      When I click on get your rate for <prod1>
      And I click on get your rate for <prod2>
      And I click on get your rate for <prod3>
      
    @TC-NJSHOP-57 
    Examples: 
      | prod1       | prod2	| prod3  |   
      | "Neo Hifi"	| "Neo"	| "Max"  |  #TC-NJSHOP-57
      
#		Given I have a product <prod> at a price of <price>
#		When I click on get your rate for <prod>
#		
#		@TC-NJSHOP-57 
#		Examples: 
      #| prod  			| price   |
      #| "Neo Hifi"	| "$2950"	|
      #| "Neo"				| "$2350"	|
      #| "Max"				| "$1850"	|	#TC-NJSHOP-57
