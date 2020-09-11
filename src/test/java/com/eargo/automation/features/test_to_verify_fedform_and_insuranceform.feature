# Smoke test on federal form

Feature: 
	Submit a federal form 
	In order to ensure patients get maximun benifits on health insurance
	As a user
	I want to run a test to verify the form data in salesforce

@federal_form
		Scenario Outline: Submit a federal form to verify NO THANKS functionality for maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
#			Then Submitted details should be present in Salesforce
			
		 Examples: 
      | patientName				|insuranceProvider|usedHearingAid	| Nothanks_or_Continue| 
      | "Do not call"			|"GEHA"						|		"YES"				|			"NO THANKS"			| #TC_Fed_01
      
      
		
@federal_form1
		Scenario Outline: Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Date of Birth as <DOB> State of resident as <Residence> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits 
#			Then Submitted details should be present in Salesforce #(if No on 36month question then order will be placed)
			
		 Examples: 
      | patientName				|insuranceProvider	|usedHearingAid	| Nothanks_or_Continue|			MemberID	|EnrollmentCode	|	GroupNumber	|			DOB			|Residence|InsuranceType|BenifitsInLast36Months	|
   #  | "Bcbs Test"				|			"BCBS"				|			"YES"			|			"CONTINUE"			|		"R12345678"	|		"104"				|	"65006500"	|	"01/28/1970"|		"N/A"	|"PRIMARY"		|						"YES"				|#TC_Fed_2.0 
   #  | "Second Test Bcbs"|			"BCBS"				|			"NO"			|			"CONTINUE"			|		"R12345777"	|		"105"				|	"65006500"	|	"01/01/1950"|		"N/A"	|"PRIMARY"		|						"YES"				|#TC_Fed_2.1 
   	  | "Geha Test"				|			"GEHA"				|			"YES"			|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"01/30/1970"|		"CA"	|"PRIMARY"		|						"YES"				|#TC_Fed_2.2 
   #  | "Nalc Test"				|			"NALC"				|			"YES"			|			"CONTINUE"			|		"N12345678"	|		"N/A"				|	"32"				|	"01/30/1947"|		"CA"	|"PRIMARY"		|						"YES"				|#TC_Fed_2.3 - required <Medicare Numbre> to proceed further
   #  | "Aetna Test"			|			"Aetna"				|			"YES"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"111111"		|	"12/12/1980"|   "CA"	|"PRIMARY"		|						"YES"				|#TC_Fed_3.0 
  #   |	"Apwu Test"				|"Apwu Health Plan"	|			"NO"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"12/12/1980"|		"CA"	|"PRIMARY"		|						"YES"				|#TC_Fed_3.1 
   #  |	"Mhbp Test"				|			"MHBP"				|			"YES"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"12/12/1980"|		"CA"	|"PRIMARY"		|						"YES"				|#TC_Fed_3.2      
   #	   | "Bcbs Test"			|			"BCBS"				|			"YES"			|			"CONTINUE"			|		"R12345678"	|		"104"				|	"65006500"	|	"01/28/1970"|		"N/A"	|"PRIMARY"		|					"NOT SURE"		|#TC_Fed_4.0 
   #   | "Geha Test"			|			"GEHA"				|			"YES"			|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"01/30/1970"|		"CA"	|"PRIMARY"		|					"NOT SURE"		|#TC_Fed_4.1 
   #   | "Nalc Test"			|			"NALC"				|			"YES"			|			"CONTINUE"			|		"N12345678"	|		"N/A"				|	"32"				|	"01/30/1947"|		"CA"	|"PRIMARY"		|					"NOT SURE"		|#TC_Fed_4.2 - required <Medicare Numbre> to proceed further
   #   | "Aetna Test"			|			"Aetna"				|			"YES"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"111111"		|	"12/12/1980"|   "CA"	|"PRIMARY"		|					"NOT SURE"		|#TC_Fed_5.0 
   #   |	"Apwu Test"			|"Apwu Health Plan"	|			"NO"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"12/12/1980"|		"CA"	|"PRIMARY"		|					"NOT SURE"		|#TC_Fed_5.1 
   #   |	"Mhbp Test"			|			"MHBP"				|			"YES"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"12/12/1980"|		"CA"	|"PRIMARY"		|					"NOT SURE"		|#TC_Fed_5.2 


@federal_form
		Scenario Outline: TC_Fed_06,07 :Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Date of Birth as <DOB> and State of resident as <Residence>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on Checkout and enter required details to place an order 
			Then Submitted details should be present in Salesforce #(if No on 36month question then order will be placed)
			
		 Examples: 
      | patientName				|insuranceProvider|usedHearingAid	| Nothanks_or_Continue|			MemberID	|EnrollmentCode	|	GroupNumber	|			DOB			|Residence|BenifitsInLast36Months	|
      | "Bcbs Test"				|			"BCBS"			|			"YES"			|			"CONTINUE"			|		"R12345678"	|		"104"				|	"65006500"	|	"1970-01-28"|		"N/A"	|						"NO"				|#TC_Fed_6.0 
      | "Geha Test"				|			"GEHA"			|			"YES"			|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"1970-01-30"|		"CA"	|						"NO"				|#TC_Fed_6.1 
      | "Nalc Test"				|			"NALC"			|			"YES"			|			"CONTINUE"			|		"N12345678"	|		"N/A"				|	"32"				|	"1947-01-30"|		"CA"	|						"NO"				|#TC_Fed_6.2  
      | "Aetna Test"			|			"Aetna"			|			"YES"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"111111"		|	"1980-12-12"|   "CA"	|						"NO"				|#TC_Fed_7.0 
      |	"Apwu Test"				|"Apwu Health Plan"|		"NO"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"1980-12-12"|		"CA"	|						"NO"				|#TC_Fed_7.1 
      |	"Mhbp Test"				|			"MHBP"			|			"YES"			|			"CONTINUE"			|		"TestID123"	|		"N/A"				|	"222222"		|	"1980-12-12"|		"CA"	|						"NO"				|#TC_Fed_7.2 

      
@federal_form
		Scenario Outline: TC_Fed_08 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Date of Birth as <DOB> and State of resident as <Residence>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on No thanks,give me a call instead 
			Then Submitted details should be present in Salesforce #(if No on 36month question then order will be placed)
			
		 Examples: 
      | patientName				|insuranceProvider|usedHearingAid	| Nothanks_or_Continue|			MemberID	|EnrollmentCode	|	GroupNumber	|			DOB			|Residence|BenifitsInLast36Months	|
      | "Bcbs Test"				|			"BCBS"			|			"YES"			|			"CONTINUE"			|		"R12345678"	|		"104"				|	"65006500"	|	"1970-01-28"|		"N/A"	|						"NO"				|#TC_Fed_8.0 
      | "Geha Test"				|			"GEHA"			|			"YES"			|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"1970-01-30"|		"CA"	|						"NO"				|#TC_Fed_8.1 
      | "Nalc Test"				|			"NALC"			|			"YES"			|			"CONTINUE"			|		"N12345678"	|		"N/A"				|	"32"				|	"1947-01-30"|		"CA"	|						"NO"				|#TC_Fed_8.2 
      
  
@federal_form
		Scenario Outline: TC_Fed_10 : Submit a federal form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the federal form with insurance provider as <insuranceProvider> and for ever used hearing aids option as <usedHearingAid>
			And I change the insurance provider as <changedInsuranceProvider>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Date of Birth as <DOB> and State of resident as <Residence>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on No thanks,give me a call instead 
			Then Submitted details should be present in Salesforce #(if No on 36month question then order will be placed)
			
		 Examples: 
      | patientName				|insuranceProvider|usedHearingAid	|changedInsuranceProvider	| Nothanks_or_Continue|			MemberID	|EnrollmentCode	|	GroupNumber	|			DOB			|Residence|BenifitsInLast36Months	|
      | "Bcbs Test"				|			"BCBS"			|			"YES"			|				"GEHA"						|			"CONTINUE"			|		"R87654321"	|		"N/A"				|	"78360001"	|	"1970-01-30"|		"CA"	|						"NO"				|#TC_Fed_10.0 
  