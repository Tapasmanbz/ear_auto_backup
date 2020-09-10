package com.eargo.automation.pages;

import org.openqa.selenium.support.PageFactory;

public class BreadPage extends BasePage {

	public BreadPage() {

		PageFactory.initElements(driver, this);
		waitForPageLoad();
		
		// Check the paypal if website is working
		// If website is working proceed with completing the script
		// else move your bread popup elements and methods code to in this page
		// understood ?
		// s, will let you know i face any issue
		// will sit with you after 7pm
		// break;
		// system.exit();
		// ok
	}
}
