# Place an Order with multiple product using debitcard

@shop
Feature:
	Place an order with multiple product using discount coupon for a particular state
	In order to ensure that checkout works
	As a user
	I want to run a test to verify the order data in salesforce

#This scenario works with placing order with Tax applied address, 1-2 Business days and with various coupons like : Hear250, HifiLaunch, MothersDay20 using DEBIT CARD
@smokeTest @regressionTest @multipleProductOrderWithDebitCard
		Scenario Outline: [TC-NJSHOP-02, TC-NJSHOP-09, TC-NJSHOP-15, TC-NJSHOP-21, TC-NJSHOP-29] Place a order with multiple product with coupon using debit card and verify the order details in Salesforce
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
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce

   	@normalOrder @TC-NJSHOP-02
    Examples: 
      | prod1 		| prod2 | prod3 | acc 					| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| payment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Wax"					| "$2950"  |"$2350"  |"$1850" |	"$25"  | "HIFILAUNCH" 	|	"California"	|	"95112"		|	"1-2 business days"	| "Amex"	|	#TC-NJSHOP-02 (Normal order)		

		@taxOrder @TC-NJSHOP-09
		Examples: 
      | prod1 		| prod2 | prod3 | acc 					| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| payment	| 
		  | "Neo HIFI"|"Neo"	|"Max"	|"Flexi fiber"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "MothersDay20"	|	"Ohio"				|	"43003"		|	"3-4 business days"	| "Amex"	|	#TC-NJSHOP-09 (Tax applied address)

	 	@Hear250 @TC-NJSHOP-15
		Examples: 
      | prod1 		| prod2 | prod3 | acc 					| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| payment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Flexi Domes"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "Hear250"			|	"Colorado"		|	"80201"		|	"3-4 business days"	| "Amex"	|	#TC-NJSHOP-15 (Hear250)

	 	@HIFILAUNCH @TC-NJSHOP-21
		Examples: 
      | prod1 		| prod2 | prod3 | acc 					| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| payment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Flexi fiber"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "HIFILAUNCH"		|	"Colorado"		|	"80201"		|	"3-4 business days"	| "Amex"	|	#TC-NJSHOP-21 (MOTHERSDAY20, HIFILAUNCH)

	 	@1-2BusinessDays @TC-NJSHOP-29
		Examples: 
      | prod1 		| prod2 | prod3 | acc 					| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| payment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Flexi fiber"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "HIFILAUNCH"		|	"MAINE"				|	"04098"		|	"1-2 business days"	| "Amex"	|	#TC-NJSHOP-29 (1-2 business days)
      


#This scenario works with placing order with multiple accessories
@smokeTest @regressionTest @multipleProductOrderWithDebitCard @multipleAccessoriesWithDebitCard
	Scenario Outline: [TC-NJSHOP-10] Place a normal order with multiple accessories with coupon and verify the order details in Salesforce
			Given I have multiple accessories <acc1>, <acc2>, <acc3>, <acc4>, <acc5> at a price of <accPrice1>, <accPrice2>, <accPrice3>, <accPrice4> and <accPrice5>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a accessory <acc1>, <acc2>, <acc3>, <acc4> and <acc5> in cart
			And a coupon <couponCode> is applied
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-10 @taxOrder
    Examples: 
      | acc1 							|acc2 					| acc3 					| acc4 					|acc5 	| accPrice1	|accPrice2|accPrice3|accPrice4|accPrice5| couponCode	|	state									|	zipCode		|	deliverBy 					| payment		| 
	    |"FLEXI TETRAPALMS"	|"FLEXI PALMS"	|"FLEXI FIBERS"	|"FLEXI DOMES"	|"WAX"	| "25"			|"25"			|"25"			|"25"			|"25"			| "HEAR250" 	|	"DISTRICT OF COLUMBIA"|	"20001"		|	"3-4 business days"	| "VISA"		|	#TC-NJSHOP-10		
	    
	    
#This scenario works with Mention ME (Referal Coupon)
@smokeTest @regressionTest @multipleProductOrderWithDebitCard @mentionMe 
		Scenario Outline: [TC-NJSHOP-37] Place a normal order with multiple product and Mention Me coupon and verify the order details in Salesforce
			Given I have multiple products <prod1>, <prod2>, <prod3> at a price of <price1>, <price2> and <price3>
			And I have a accessory <acc> at a price of <accPrice>
#			And a default coupon <couponCode> is applied
			And as a user with a default email
			When I add a product <prod1> in cart
			And I add a product <prod2> in cart
			And I add a product <prod3> twice in cart
			And I add a accessory <acc> in cart
			And I used a friend referral <mentionMe>
			And I click on checkout
			And I select state as <state> with zipcode <zipCode>
			And I opt for <deliverBy> delivery
			And use <payment> for payment
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-37 @mentionMe
    Examples: 
      | prod1 		| prod2 | prod3 | acc 	| price1	 |price2	 |price3	|accPrice| mentionMe				|	state					|	zipCode		|	deliverBy 					| payment	| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Wax"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "FriendReferal" 	|	"California"	|	"95112"		|	"3-4 business days"	| "Amex"	|	#TC-NJSHOP-37 (Mention ME)
 
 
  
#This scenario works with different billing address
@smokeTest @regressionTest @multipleProductOrderWithDebitCard @differentShippingAddress
		Scenario Outline: [TC-NJSHOP-45] Place a normal order with multiple product, default coupon and verify the order details in Salesforce
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
			And I should be able to place the order with payment <payment> on a discounted price
			Then verify that the order details should be present in Salesforce
    
    @TC-NJSHOP-45 
    Examples: 
      | prod1 		| prod2 | prod3 | acc 	| price1	 |price2	 |price3	|accPrice| couponCode			|	state					|	zipCode		|	deliverBy 					| billingState	|	billingZipCode	|	 payment| 
      | "Neo HIFI"|"Neo"	|"Max"	|"Wax"	| "$2950"  |"$2350"  |"$1850" |	"$25"  | "MothersDay20" |	"California"	|	"95112"		|	"3-4 business days"	|  "FLORIDA"		|	"32003"    			|	"Amex"	|	#TC-NJSHOP-45 (Different Shipping Address)
     
     

     