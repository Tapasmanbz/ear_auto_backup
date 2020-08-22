package com.eargo.automation.pages;

import org.openqa.selenium.support.PageFactory;

public class PaypalPage extends BasePage {

	public PaypalPage() {

		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}
	
}
