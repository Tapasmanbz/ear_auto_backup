# Smoke test on federal form

Feature: 
	Submit a Master Insurance form 
	In order to ensure patients get maximun benifits on health insurance
	As a user
	I want to run a test to verify the form data in salesforce

    @master_insurance
		Scenario Outline: TC_MI_1 : Submit a master insurance form to verify get maximum benifits on health insurance and verify the details on Salesforce
			Given With a patient name <patientName>
			When I submit the master insurance form of insurance category <insuranceCategory> with insurance provider as <insuranceProvider>
			And I select <Nothanks_or_Continue> for maximum benefits for health insurance
			And I enter Member ID as <MemberID>, Enrollment code as <EnrollmentCode>, Group Number as <GroupNumber>, Medicare Number as <MedicareNumber>, Date of Birth as <DOB> State of resident as <Residence> and Insurance type as <InsuranceType>
			And I select <BenifitsInLast36Months> for using Hearing Aid insurance benefits in last 36 months
			And I agree to trems and conditions and click on check you benifits
			And I click on Checkout button
			Then Submitted details should be present in Salesforce
		
		 @TC_MI_1		
		 Examples: 
      | patientName					|	insuranceCategory	|	insuranceProvider	| Nothanks_or_Continue	|	MemberID			|	EnrollmentCode	|	GroupNumber				|	MedicareNumber	|	DOB						|	Residence	|	InsuranceType	|	BenifitsInLast36Months	|
      | "Aetna Test"				|	"Common"					|	"Aetna"						|	"CONTINUE"						|	"W987654321"	|	"N/A"						|	"28563001100003"	|	"N/A"						|	"01/12/1950"	|	"CA"			|	"PRIMARY"			|	"NO"										|	#TC_MI_1.0 
      | "Second Test Aetna"	|	"Common"					|	"Aetna"						|	"CONTINUE"						|	"W444555666"	|	"N/A"						|	"28563101400007"	| "N/A"						|	"01/01/1961"	|	"CA"			|	"PRIMARY"			|	"NO"										|	#TC_MI_1.1 
      