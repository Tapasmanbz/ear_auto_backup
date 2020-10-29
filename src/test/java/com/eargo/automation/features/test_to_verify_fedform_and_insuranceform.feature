# Smoke test on federal form

Feature: 
	Submit a federal form 
	In order to ensure patients get maximun benifits on health insurance
	As a user
	I want to run a test to verify the form data in salesforce

@federal_form1
		Scenario Outline: Submit a federal form to verify NO THANKS functionality for maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			Then Submitted details should be present in Salesforce
		
		 @TC_Fed_01	
		 Examples: 
      | patientName				|insuranceProvider|usedHearingAid	| Nothanks_or_Continue| 
      | "Do not call"			|"GEHA"						|		"YES"				|			"NO THANKS"			| #TC_Fed_01
       
		
		@federal_form1 
		Scenario Outline: Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			Then Submitted details should be present in Salesforce
		
		@TC_Fed_02	@TC_Fed_03
		Examples: 
      | patientName				|	insuranceProvider		|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	DOB						|	Residence	|zipCode	|	InsuranceType	|	BenifitsInLast36Months	|	MedicareNumber	|
   	  | "Bcbs Test"				|	"BCBS"							|	"YES"						|			"CONTINUE"				|	"R12345678"	|	"104"						|	"65006500"	|	"1/28/1970"	|	"N/A"			|"N/A"		|	"PRIMARY"			|	"YES"										|	"N/A"						|#TC_Fed_2.0 
#      | "Second Test Bcbs"|	"BCBS"							|	"NO"						|			"CONTINUE"				|	"R12345777"	|	"105"						|	"65006500"	|	"1/01/1950"	|	"N/A"			|"90201"	|	"PRIMARY"			|	"YES"										|	"N/A"						|#TC_Fed_2.1 
#      | "Geha Test"				|	"GEHA"							|	"YES"						|			"CONTINUE"				|	"R87654321"	|	"N/A"						|	"78360001"	|	"1/30/1970"	|	"CA"			|"90201"	|	"PRIMARY"			|	"YES"										|	"N/A"						|#TC_Fed_2.2 
#      | "Nalc Test"				|	"NALC"							|	"YES"						|			"CONTINUE"				|	"N12345678"	|	"N/A"						|	"32"				|	"1/30/1947"	|	"CA"			|"90201"	|	"PRIMARY"			|	"YES"										|	"med-123-02"		|#TC_Fed_2.3 - required <Medicare Numbre> to proceed further
#      | "Aetna Test"			|	"Aetna"							|	"YES"						|			"CONTINUE"				|	"TestID123"	|	"N/A"						|	"111111"		|	"12/12/1980"	| "CA"			|"90201"	|	"PRIMARY"			|	"YES"										|	"N/A"						|#TC_Fed_3.0 
#      |	"Apwu Test"				|	"Apwu Health Plan"	|	"NO"						|			"CONTINUE"				|	"TestID123"	|	"N/A"						|	"222222"		|	"12/12/1980"	|	"CA"			|"90201"	|	"PRIMARY"			|	"YES"										|	"N/A"						|#TC_Fed_3.1 
#   	  |	"Mhbp Test"				|	"MHBP"							|	"YES"						|			"CONTINUE"				|	"TestID123"	|	"N/A"						|	"222222"		|	"12/12/1980"	|	"CA"			|"90201"	|	"PRIMARY"			|	"YES"										|	"N/A"						|#TC_Fed_3.2      

		@TC_Fed_04	@TC_Fed_05
		Examples: 
    	| patientName				|	insuranceProvider		|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	DOB						|	Residence	|zipCode	|	InsuranceType	|	BenifitsInLast36Months	|	MedicareNumber		|
#   		| "Bcbs Test"				|	"BCBS"							|	"YES"						|			"CONTINUE"				|	"R12345678"	|	"104"						|	"65006500"	|	"1/28/1970"	|	"N/A"			|"N/A"		|	"PRIMARY"			|	"NOT SURE"							|	"N/A"							|#TC_Fed_4.0 
#      | "Geha Test"				|	"GEHA"							|	"YES"						|			"CONTINUE"				|	"R87654321"	|	"N/A"						|	"78360001"	|	"1/30/1970"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NOT SURE"							|"N/A"							|	#TC_Fed_4.1 
#      | "Nalc Test"				|	"NALC"							|	"YES"						|			"CONTINUE"				|	"N12345678"	|	"N/A"						|	"32"				|	"1/30/1947"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NOT SURE"							|	"med-123-02"			|#TC_Fed_4.2 - required <Medicare Numbre> to proceed further
#      | "Aetna Test"			|	"Aetna"							|	"YES"						|			"CONTINUE"				|	"TestID123"	|	"N/A"						|	"111111"		|	"12/12/1980"	| "CA"			|"90201"	|	"PRIMARY"			|	"NOT SURE"							|	"N/A"							|#TC_Fed_5.0 
#      |	"Apwu Test"				|	"Apwu Health Plan"	|	"NO"						|			"CONTINUE"				|	"TestID123"	|	"N/A"						|	"222222"		|	"12/12/1980"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NOT SURE"							|	"N/A"							|#TC_Fed_5.1 
#      |	"Mhbp Test"				|	"MHBP"							|	"YES"						|			"CONTINUE"				|	"TestID123"	|	"N/A"						|	"222222"		|	"12/12/1980"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NOT SURE"							|	"N/A"							|#TC_Fed_5.2 


@federal_form1
		Scenario Outline: TC_Fed_06,07 :Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on Checkout and enter required details to place an order
			Then Submitted details should be present in Salesforce
		
		 @TC_Fed_06	@TC_Fed_07	
		 Examples: 
      | patientName				|insuranceProvider	|usedHearingAid	| Nothanks_or_Continue|			MemberID	|EnrollmentCode	|	GroupNumber	|			DOB			|Residence|zipCode	|	InsuranceType	|BenifitsInLast36Months	|		MedicareNumber	|
      | "Bcbs Test"				|			"BCBS"				|		"YES"				|			"CONTINUE"			|		"R12345678"	|		"104"				|	"65006500"	|	"1/28/1970"|		"N/A"	|"N/A"		|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_6.0 
      | "Geha Test"				|			"GEHA"				|		"YES"				|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"1/30/1970"|		"CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_6.1 
      | "Nalc Test"				|			"NALC"				|		"YES"				|			"CONTINUE"			|		"N12345678"	|		"N/A"				|	"32"				|	"1/30/1947"|		"CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"med-123-02"				|#TC_Fed_6.2  
      | "Aetna Test"			|			"Aetna"				|		"YES"				|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"111111"		|	"12/12/1980"|   "CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_7.0 
      |	"Apwu Test"				|"Apwu Health Plan"	|		"NO"				|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"12/12/1980"|		"CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_7.1 
      |	"Mhbp Test"				|			"MHBP"				|		"YES"				|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"12/12/1980"|		"CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_7.2 

      
@federal_form1
		Scenario Outline: TC_Fed_08 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on No thanks,give me a call instead 
			Then Submitted details should be present in Salesforce
		
		 @TC_Fed_08		
		 Examples: 
      | patientName	|	insuranceProvider	|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	MedicareNumber	|	DOB					|	Residence	|zipCode	|	InsuranceType	|	BenifitsInLast36Months	|
      | "Bcbs Test"	|	"BCBS"						|	"YES"						|	"CONTINUE"						|	"R12345678"	|	"104"						|	"65006500"	|	"N/A"						|	"1/28/1970"	|	"N/A"			|"N/A"		|	"PRIMARY"			|	"NO"										|	#TC_Fed_8.0 
      | "Geha Test"	|	"GEHA"						|	"YES"						|	"CONTINUE"						|	"R87654321"	|	"N/A"						|	"78360001"	| "N/A"						|	"1/30/1970"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NO"										|	#TC_Fed_8.1 
      | "Nalc Test"	|	"NALC"						|	"YES"						|	"CONTINUE"						|	"N12345678"	|	"N/A"						|	"32"				|	"med-123-02"		|	"1/30/1947"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NO"										|	#TC_Fed_8.2 
      
  
@federal_form1
		Scenario Outline: TC_Fed_09 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I wait for more than 6 mins on insurance form page
			And I click on Checkout button
			Then Timeout popup should be displayed on insurance form page
			And Submitted details should be present in Salesforce
		
		 @TC_Fed_09		
		 Examples: 
      | patientName	|	insuranceProvider	|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	MedicareNumber	|	DOB						|	Residence	|zipCode	|	InsuranceType	|	BenifitsInLast36Months	|
      | "Bcbs Test"	|	"BCBS"						|	"YES"						|	"CONTINUE"						|	"R12345678"	|	"104"						|	"65006500"	|	"N/A"						|	"01/28/1970"	|	"N/A"			|"N/A"		|	"PRIMARY"			|	"NO"										|	#TC_Fed_9.0 
      | "Geha Test"	|	"GEHA"						|	"YES"						|	"CONTINUE"						|	"R87654321"	|	"N/A"						|	"78360001"	| "N/A"						|	"01/30/1970"	|	"CA"			|"90201"	|	"PRIMARY"			|	"NO"										|	#TC_Fed_9.1 
      | "Nalc Test"	|	"NALC"						|	"YES"						|	"CONTINUE"						|	"N12345678"	|	"N/A"						|	"32"				|	"med-123-02"		|"01/30/1947"		|	"CA"			|"90201"	|	"PRIMARY"			|	"NO"										|	#TC_Fed_9.2 
   
@federal_form1
    Scenario Outline: TC_Fed_10 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
      Given With a patient name <patientName>
      When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
      And I select <Nothanks_or_Continue> for maximum benefits for health insurance
      And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
      And I change the insurance provider as <changedInsuranceProvider>
      And I select <Nothanks_or_Continue> for maximum benefits for health insurance
      And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
      And I agree to trems and conditions and click on check you benifits
      Then Submitted details should be present in Salesforce 
      
     @TC_Fed_10	
     Examples: 
      | patientName	|	insuranceProvider |	usedHearingAid	| Nothanks_or_Continue	|	MemberID  	|	EnrollmentCode  |	GroupNumber |	DOB      			|	Residence	|	zipCode		|	InsuranceType	|	BenifitsInLast36Months |	changedInsuranceProvider	|		MedicareNumber	|
      | "Bcbs Test" |  "BCBS"       		| "YES"     			| "CONTINUE"      			| "R12345678" | "104"        		| "65006500"  | "01/28/1970"	| "CA"  		|	"90201"  	|	"PRIMARY"    	| "NO"       						 |  "GEHA"         						|"N/A"							|	#TC_Fed_10.0
   
@federal_form
		Scenario Outline: TC_Fed_11 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on Ok button in Unable to verify your details online section
			Then "We were unable to verify your benefits online." message should on insurance form page
			And Submitted details should be present in Salesforce
		
		 @TC_Fed_11		
		 Examples: 
      | patientName	|	insuranceProvider	|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	MedicareNumber	|	DOB						|	Residence	|	zipCode		|	InsuranceType	|	BenifitsInLast36Months	|
      | "Nalc Test"	|	"BCBS"						|	"YES"						|	"CONTINUE"						|	"R12345678"	|	"104"						|	"65006500"	|	"N/A"						|	"01/28/1970"	|	"N/A"			|"N/A" 		 	|	"PRIMARY"			|	"NO"										|	#TC_Fed_11.0 
#     | "Bcbs Test"	|	"GEHA"						|	"YES"						|	"CONTINUE"						|	"R87654321"	|	"N/A"						|	"78360001"	| "N/A"						|	"01/30/1970"	|	"CA"			|"90201"  	|	"PRIMARY"			|	"NO"										|	#TC_Fed_11.1 
#     | "Geha Test"	|	"NALC"						|	"YES"						|	"CONTINUE"						|	"N12345678"	|	"N/A"						|	"32"				|	"med-123-02"		|"01/30/1947"		|	"CA"			|"90201"  	|	"PRIMARY"			|	"med-123-02"						|	#TC_Fed_11.2 
      
@federal_form
		Scenario Outline: TC_Fed_12 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			Then Great news! sub-section should display for insurance <insuranceProvider>
		
		 @TC_Fed_12		
		 Examples: 
      | patientName	|	insuranceProvider	|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	MedicareNumber	|	DOB						|	Residence	|	zipCode		|	InsuranceType	|	BenifitsInLast36Months	|
#     | "Bcbs Test"	|	"BCBS"						|	"YES"						|	"CONTINUE"						|	"R12345678"	|	"104"						|	"65006500"	|	"N/A"						|	"01/28/1970"	|	"N/A"			|"N/A" 		 	|	"PRIMARY"			|	"NO"										|	#TC_Fed_12.0 
      | "Geha Test"	|	"GEHA"						|	"YES"						|	"CONTINUE"						|	"R87654321"	|	"N/A"						|	"78360001"	| "N/A"						|	"01/30/1970"	|	"CA"			|"90201"  	|	"PRIMARY"			|	"NO"										|	#TC_Fed_12.1 
#     | "Nalc Test"	|	"NALC"						|	"YES"						|	"CONTINUE"						|	"N12345678"	|	"N/A"						|	"32"				|	"med-123-02"		|"01/30/1947"		|	"CA"			|"90201"  	|	"PRIMARY"			|	"NO"										|	#TC_Fed_12.2 
      
@federal_form
		Scenario Outline: TC_Fed_13 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on Checkout button
			Then Verify user should be navigate to checkout page
			And Verify 'My information' sub-section details for insurance <insuranceProvider>
			And Verify 'Ship my eargo to' sub-section details for insurance <insuranceProvider>
			And Verify 'Covered by' sub-section details for insurance <insuranceProvider>
			And Verify Terms and Conditions radio button should display for insurance <insuranceProvider>
			And Verify 'Order summary' sub-section details for insurance <insuranceProvider>
			And Verify 1-2 business day delivery option should not be present for insurance <insuranceProvider>
		
		 @TC_Fed_13		
		 Examples: 
      | patientName	|	insuranceProvider	|	usedHearingAid	| Nothanks_or_Continue	|	MemberID		|	EnrollmentCode	|	GroupNumber	|	MedicareNumber	|	DOB						|	Residence	|	zipCode		|	InsuranceType	|	BenifitsInLast36Months	|
      | "Bcbs Test"	|	"BCBS"						|	"YES"						|	"CONTINUE"						|	"R12345678"	|	"104"						|	"65006500"	|	"N/A"						|	"01/28/1970"	|"N/A" 		 	|	"N/A"			|	"PRIMARY"			|	"NO"										|	#TC_Fed_13.0 
 #    | "Geha Test"	|	"GEHA"						|	"YES"						|	"CONTINUE"						|	"R87654321"	|	"N/A"						|	"78360001"	| "N/A"						|	"01/30/1970"	|	"CA"			|"90201"  	|	"PRIMARY"			|	"NO"										|	#TC_Fed_13.1 
 #    | "Nalc Test"	|	"NALC"						|	"YES"						|	"CONTINUE"						|	"N12345678"	|	"N/A"						|	"32"				|	"med-123-02"		|"01/30/1947"		|	"CA"			|"90201"  	|	"PRIMARY"			|	"NO"										|	#TC_Fed_13.2 
     
     
@federal_form
		Scenario Outline: TC_Fed_14:Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> with zipcode <zipCode> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on Checkout and enter required details to place an order
#			Then Submitted details should be present in Salesforce
		
		 @TC_Fed_14	
		 Examples: 
      | patientName				|insuranceProvider	|usedHearingAid	| Nothanks_or_Continue|			MemberID	|EnrollmentCode	|	GroupNumber	|			DOB			|Residence|zipCode	|	InsuranceType	|BenifitsInLast36Months	|		MedicareNumber	|
  #   | "Bcbs Test"				|			"BCBS"				|		"YES"				|			"CONTINUE"			|		"R12345678"	|		"104"				|	"65006500"	|	"01/28/1970"|		"N/A"	|"N/A"		|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_14.0 
      | "Geha Test"				|			"GEHA"				|		"YES"				|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"01/30/1970"|		"CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"N/A"							|#TC_Fed_14.1 
  #   | "Nalc Test"				|			"NALC"				|		"YES"				|			"CONTINUE"			|		"N12345678"	|		"N/A"				|	"32"				|	"01/30/1947"|		"CA"	|"90201"	|	"PRIMARY"			|						"NO"				|"med-123-02"				|#TC_Fed_14.2       
  
      
      