package com.eargo.automation.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class SalesforcePage extends BasePage {

	String deliveryTaxValue = null;
	String deliveryTaxValue1 = null;
	String shippingTaxValue = null;
	String PaymentType = null;
	String shippingAddressOnSF = null;
	String orderNumber = null;
	
	FederalForm federalForm = null;

	public SalesforcePage() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	private String neoHifiProdName;
	private String neoHifiProdPrice;
	private String accessoryName;
	private String accessoryPrice;
	private String defaultCoupon;

	@FindBy(how = How.ID, using = "username")
	public WebElement SFuserName;

	@FindBy(how = How.ID, using = "password")
	public WebElement SFpassWord;

	@FindBy(how = How.ID, using = "Login")
	public WebElement SFLogInToSanbox;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Remind Me Later')]")
	public WebElement SFskipRegisterMobileNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='profileTrigger branding-user-profile bgimg slds-avatar slds-avatar_profile-image-small circular forceEntityIcon']//span[@class='uiImage']")
	public WebElement viewProfile;

	@FindBy(how = How.XPATH, using = "//a[@class='profile-link-label switch-to-aloha uiOutputURL']")
	public WebElement classicView;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Orders')]")
	public WebElement ordersTab;

	@FindBy(how = How.XPATH, using = "//a[@title='Orders']")
	public WebElement ordersTabPC1;

	@FindBy(how = How.ID, using = "fcf")
	public WebElement viewDropDown;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'fBody')]//input[contains(@name,'go')]")
	public WebElement Go;

	@FindBy(how = How.XPATH, using = "//input[@id='phSearchInput']")
	public WebElement searchOrderNumber;

	@FindBy(how = How.ID, using = "phSearchButton")
	public WebElement searchOrderButton;

	@FindBy(how = How.CLASS_NAME, using = "dataCell")
	public WebElement openOrderDetails;

	@FindBy(how = How.ID, using = "OrderReferenceNumber_ileinner")
	public WebElement orderNum;

	@FindBy(how = How.ID, using = "00NA000000AiMZ4_ileinner")
	public WebElement finalProductPrice;

	@FindBy(how = How.ID, using = "00NA000000BDBvq_ileinner")
	public WebElement actualproductPrice;

	@FindBy(how = How.ID, using = "00NA000000BxUfa_ileinner")
	public WebElement deliveryTax;

	@FindBy(how = How.ID, using = "00NA000000BxUfY_ileinner")
	public WebElement shippingTax;

	@FindBy(how = How.ID, using = "00NA000000AiFa4_ileinner")
	public WebElement billingPaymentType;

	@FindBy(how = How.ID, using = "00N4D000000siMi_ileinner")
	public WebElement appliedCoupon;

	@FindBy(how = How.ID, using = "00NA000000BxUfX_ileinner")
	public WebElement couponDiscount;

	@FindBy(how = How.XPATH, using = "//div[@id='ShippingAddress_ileinner']")
	public WebElement shippingAddress1;

	@FindBy(how = How.XPATH, using = "//td[@id='ShippingAddress_ilecell']")
	public WebElement shippingAddress2;

	// Added - 24-08-2020
	@FindBy(how = How.XPATH, using = "//h3[contains(@id, '_RelatedOrderItemList_title')]")
	public WebElement sectionOrderProductsSalesforce;

	@FindBy(how = How.XPATH, using = "//div[contains(@id, '_RelatedOrderItemList_body')]//table/tbody/tr[contains(@class,'dataRow')]")
	public List<WebElement> allProductsSummarySalesforce;

	@FindBy(how = How.XPATH, using = "//div[contains(@id, '_RelatedOrderItemList_body')]//table/tbody/tr[contains(@class,'dataRow')]/th")
	public List<WebElement> productNameSalesforce;

	@FindBy(how = How.XPATH, using = "//div[contains(@id, '_RelatedOrderItemList_body')]//table/tbody/tr[contains(@class,'dataRow')]/td[5]")
	public List<WebElement> productQuantitySalesforce;

	@FindBy(how = How.XPATH, using = "//div[contains(@id, '_RelatedOrderItemList_body')]//table/tbody/tr[contains(@class,'dataRow')]/td[6]")
	public List<WebElement> productPriceSalesforce;

	// Added on 22-09-2020
	@FindBy(how = How.XPATH, using = "//a[text()='Remind Me Later']")
	public WebElement lnkRemindMeLater;

	@FindBy(how = How.XPATH, using = "//input[@title='Search Orders and more']")
	public WebElement searchOrderNumberPC1;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'resultsItem')]//table/tbody/tr[1]/th[1]//a")
	public WebElement openOrderPC1;

	@FindBy(how = How.XPATH, using = "//a[@data-tab-name='relatedListsTab']")
	public WebElement openOrderRelatedPC1;

	@FindBy(how = How.XPATH, using = "//a[@data-tab-name='detailTab']")
	public WebElement openOrderDetailsPC1;

	@FindBy(how = How.XPATH, using = "//div/span[text()='Order Number']/parent::div/following-sibling::div/span/span")
	public WebElement orderNumPC1;

	@FindBy(how = How.XPATH, using = "//div/span[text()='PaymentType']/parent::div/following-sibling::div/span/span")
	public WebElement billingPaymentTypePC1;

	@FindBy(how = How.XPATH, using = "//div/span[text()='Order SubTotal']/parent::div/following-sibling::div/span/span")
	public WebElement finalProductPricePC1;

	@FindBy(how = How.XPATH, using = "//div/span[text()='Order Total']/parent::div/following-sibling::div/span/span")
	public WebElement actualproductPricePC1;

	@FindBy(how = How.XPATH, using = "//div/span[contains(text(),'Order Tax')]/parent::div/following-sibling::div/span/span")
	public WebElement deliveryTaxPC1;

	@FindBy(how = How.XPATH, using = "//div/span[contains(text(),'Order Shipping')]/parent::div/following-sibling::div/span/span")
	public WebElement shippingTaxPC1;

	// @FindBy(how = How.XPATH, using = "//div/span[contains(text(),'Order Promo
	// Discount')]/parent::div/following-sibling::div/span/span")
	@FindBy(how = How.XPATH, using = "//div[@id='00NA000000BxUfX_ileinner']")
	public WebElement appliedCouponPC1;

	@FindBy(how = How.XPATH, using = "//h3[contains(@id, '_RelatedOrderItemList_title')]")
	public WebElement sectionOrderProductsSalesforcePC1;

	@FindBy(how = How.XPATH, using = "//h2/a/span[contains(text(),'Order Products')]/ancestor::article//span[text()='View All']")
	public WebElement viewAllProductsSummarySalesforcePC1;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order Products')]/ancestor::div[contains(@class,'test-listViewManager')]//table/tbody/tr")
	public List<WebElement> allProductsSummarySalesforcePC1;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order Products')]/ancestor::div[contains(@class,'test-listViewManager')]//table/tbody/tr/th")
	public List<WebElement> productNameSalesforcePC1;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order Products')]/ancestor::div[contains(@class,'test-listViewManager')]//table/tbody/tr/td[5]")
	public List<WebElement> productQuantitySalesforcePC1;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Order Products')]/ancestor::div[contains(@class,'test-listViewManager')]//table/tbody/tr/td[6]")
	public List<WebElement> productPriceSalesforcePC1;

	/**
	 * Set the value of Neo Hifi Product Name
	 * 
	 * @param neoHifiProdName
	 */
	public void setNeoHifiProdName(String neoHifiProdName) {

		this.neoHifiProdName = neoHifiProdName;
	}

	public String getNeoHifiProdName() {

		return this.neoHifiProdName;
	}

	public void setNeoHifiProdPrice(String neoHifiProdPrice) {

		this.neoHifiProdPrice = neoHifiProdPrice;
	}

	public String getNeoHifiProdPrice() {

		return this.neoHifiProdPrice;
	}

	public void setAccessoryName(String accessoryName) {

		this.accessoryName = accessoryName;
	}

	public String getAccessoryName() {

		return this.accessoryName;
	}

	public void setAccessoryPrice(String accessoryPrice) {

		this.accessoryPrice = accessoryPrice;
	}

	public String getAccessoryPrice() {

		return this.accessoryPrice;
	}

	public void setCoupon(String couponCode) {

		this.defaultCoupon = prop.getProperty(couponCode);
	}

	public String getCoupon() {

		return this.defaultCoupon;
	}

	public void salesforceLogin(String orderNumber) throws InterruptedException {

		System.out.println("inside sales force");

		((JavascriptExecutor) driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get(prop.getProperty("saleforceURL"));

		SFuserName.sendKeys(prop.getProperty("SFUserName"));
		SFpassWord.sendKeys(prop.getProperty("SFPassword"));

		SFLogInToSanbox.click();

		// SFskipRegisterMobileNumber.click();

		// Added on 22-09-2020
		if (prop.getProperty("SFUserName").contains(".eargopc1")) {
			try {
				wait.until(ExpectedConditions.visibilityOf(lnkRemindMeLater));
			} catch (TimeoutException e) {

			}

			lnkRemindMeLater.click();

			Thread.sleep(3000);

			ordersTab.click();

			Thread.sleep(2000);
			searchOrderNumber.sendKeys(orderNumber);
			wait.until(ExpectedConditions.elementToBeClickable(searchOrderButton)).click();
			Thread.sleep(3000);

			System.out.println("in order details");
			Thread.sleep(3000);

			wait.until(ExpectedConditions.elementToBeClickable(openOrderDetails)).click();

			System.out.println("Order Summary =" + finalProductPrice.getText());

			System.out.println("Product Price =" + actualproductPrice.getText());

			System.out.println("Tax Applied =" + deliveryTax.getText());

			System.out.println("Shipping tax =" + shippingTax.getText());

			System.out.println("Coupon Applied =" + appliedCouponPC1.getText());

		} else {

			Thread.sleep(3000);
			ordersTab.click();

			Thread.sleep(2000);
			searchOrderNumber.sendKeys(orderNumber);
			wait.until(ExpectedConditions.elementToBeClickable(searchOrderButton)).click();
			Thread.sleep(3000);

			System.out.println("in order details");
			Thread.sleep(3000);

			wait.until(ExpectedConditions.elementToBeClickable(openOrderDetails)).click();

			System.out.println("Order Summary =" + finalProductPrice.getText());

			System.out.println("Product Price =" + actualproductPrice.getText());

			System.out.println("Tax Applied =" + deliveryTax.getText());

			System.out.println("Shipping tax =" + shippingTax.getText());

			System.out.println("Coupon Applied =" + appliedCoupon.getText());

		}

		// driver.switchTo().window(tabs.get(0)); // switch back to main screen
		Thread.sleep(3000);

	}

	public String sfOrderTax() {
		if (prop.getProperty("SFUserName").contains(".eargopc1")) {
			deliveryTaxValue = deliveryTax.getText();
			return this.deliveryTaxValue;
		} else {
			deliveryTaxValue = deliveryTax.getText();
			// deliveryTaxValue1 = "$" + deliveryTaxValue + "0";
			deliveryTaxValue1 = "$" + deliveryTaxValue;
			System.out.println("sfOrderTax=" + deliveryTaxValue1);
			return this.deliveryTaxValue1;
		}
	}

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public HashMap<String, String> getOrderProductsOnSalesForce() throws InterruptedException {

		HashMap<String, String> productOrderTableSalesforce = new HashMap<String, String>();
		wait.until(ExpectedConditions.visibilityOf(sectionOrderProductsSalesforce));
		scrollToElement(sectionOrderProductsSalesforce);
		wait.until(ExpectedConditions.visibilityOfAllElements(allProductsSummarySalesforce));
		Iterator productIterator = allProductsSummarySalesforce.iterator();

		// while(productIterator.hasNext()){
		// WebElement productRow = (WebElement) productIterator.next();
		// String key = productRow.findElement(by)
		// String value =
		// productOrderTable.put(key, value)
		// int key = m.getKey();
		// String value=m.getValue();
		// System.out.println("Key :"+key+" value :"+value);
		// }

		for (int i = 0; i < allProductsSummarySalesforce.size(); i++) {
			String key = null;

			String prodName = productNameSalesforce.get(i).getText();

			if (prodName.contains("SYSTEM")) {
				
				if (prodName.contains("NEO"))
					key = "NEO";
				if (prodName.contains("HIFI"))
					key = "NEO_HIFI";				
				if (prodName.contains("MAX"))
					key = "MAX";
			} else {

				if (prodName.contains("Flexi Fiber Bundle, Size Large"))
					key = "FLEXI_FIBERS_LARGE";
				else if (prodName.contains("Flexi Fiber Bundle, Size Regular"))
					key = "FLEXI_FIBERS_REGULAR";
				else if (prodName.contains("TETRA FLEXI PALM, SIZE LARGE"))
					key = "FLEXI_TETRA_PALMS_LARGE";
				else if (prodName.contains("TETRA FLEXI PALM, SIZE REGULAR"))
					key = "FLEXI_TETRA_PALMS_REGULAR";
				else if (prodName.contains("Flexi Palm Accessory Kit, Large"))
					key = "FLEXI_PALMS_LARGE";
				else if (prodName.contains("Flexi Palm Accessory Kit, Regular"))
					key = "FLEXI_PALMS_REGULAR";
				else if (prodName.contains("FLEXI DOME, LARGE"))
					key = "FLEXI_DOMES_LARGE";
				else if (prodName.contains("FLEXI DOME, REGULAR"))
					key = "FLEXI_DOMES_REGULAR";
				else if (prodName.contains("Wax Guard Replacement Tool"))
					key = "WAX";
				else
					key = "UNKNOWN";
			}

			String quantity = productQuantitySalesforce.get(i).getText();
			System.out.println("quantity" + quantity);
			String value = quantity.split("[.]")[0];
			String price = productPriceSalesforce.get(i).getText();
			System.out.println("SKey :" + key + " SQuantity :" + value + "  SPrice :" + price);
			productOrderTableSalesforce.put(key, value);
		}

		System.out.println("productOrderTableSalesforce:" + productOrderTableSalesforce.size());
		return productOrderTableSalesforce;
	}

	public HashMap<String, String> getOrderProductsOnSalesForcePC1() throws InterruptedException {

		HashMap<String, String> productOrderTableSalesforce = new HashMap<String, String>();
		wait.until(ExpectedConditions.visibilityOf(sectionOrderProductsSalesforcePC1));
		scrollToElement(sectionOrderProductsSalesforcePC1);
		wait.until(ExpectedConditions.visibilityOfAllElements(allProductsSummarySalesforcePC1));
		Iterator productIterator = allProductsSummarySalesforcePC1.iterator();

		// while(productIterator.hasNext()){
		// WebElement productRow = (WebElement) productIterator.next();
		// String key = productRow.findElement(by)
		// String value =
		// productOrderTable.put(key, value)
		// int key = m.getKey();
		// String value=m.getValue();
		// System.out.println("Key :"+key+" value :"+value);
		// }

		for (int i = 0; i < allProductsSummarySalesforcePC1.size(); i++) {
			String key = null;

			String prodName = productNameSalesforcePC1.get(i).getText();

			if (prodName.contains("SYSTEM")) {

				if (prodName.contains("NEO"))
					key = "NEO";
				if (prodName.contains("HIFI"))
					key = "NEO_HIFI";
				if (prodName.contains("MAX"))
					key = "MAX";
			} else {

				if (prodName.contains("Flexi Fiber Bundle, Size Large"))
					key = "FLEXI_FIBERS_LARGE";
				else if (prodName.contains("Flexi Fiber Bundle, Size Regular"))
					key = "FLEXI_FIBERS_REGULAR";
				else if (prodName.contains("TETRA FLEXI PALM, SIZE LARGE"))
					key = "FLEXI_TETRA_PALMS_LARGE";
				else if (prodName.contains("TETRA FLEXI PALM, SIZE REGULAR"))
					key = "FLEXI_TETRA_PALMS_REGULAR";
				else if (prodName.contains("Flexi Palm Accessory Kit, Large"))
					key = "FLEXI_PALMS_LARGE";
				else if (prodName.contains("Flexi Palm Accessory Kit, Regular"))
					key = "FLEXI_PALMS_REGULAR";
				else if (prodName.contains("FLEXI DOME, LARGE"))
					key = "FLEXI_DOMES_LARGE";
				else if (prodName.contains("FLEXI DOME, REGULAR"))
					key = "FLEXI_DOMES_REGULAR";
				else if (prodName.contains("Wax Guard Replacement Tool"))
					key = "WAX";
				else
					key = "UNKNOWN";
			}

			String quantity = productQuantitySalesforcePC1.get(i).getText();
			System.out.println("quantity" + quantity);
			String value = quantity.split("[.]")[0];
			String price = productPriceSalesforcePC1.get(i).getText();
			System.out.println("SKey :" + key + " SQuantity :" + value + "  SPrice :" + price);
			productOrderTableSalesforce.put(key, value);
		}

		System.out.println("productOrderTableSalesforce:" + productOrderTableSalesforce.size());
		return productOrderTableSalesforce;
	}

	public String sfshippingAddress() {
		shippingAddressOnSF = shippingAddress1.getText();
		return this.shippingAddressOnSF;
	}

	public String sfShippingTax() {
		// if (prop.getProperty("SFUserName").contains(".eargopc1")) {
		// shippingTaxValue = shippingTaxPC1.getText();
		// System.out.println("sfShippingTax=" + shippingTaxValue);
		// return this.shippingTaxValue;
		// } else {
		shippingTaxValue = shippingTax.getText();
		System.out.println("sfShippingTax=" + shippingTaxValue);
		return this.shippingTaxValue;
		// }
	}

	public String sfPaymentType() {
		// if (prop.getProperty("SFUserName").contains(".eargopc1")) {
		// PaymentType = billingPaymentTypePC1.getText();
		// return this.PaymentType;
		// } else {
		PaymentType = billingPaymentType.getText();
		return this.PaymentType;
		// }
	}

	// For Salesforce Lightning Interface
	public void navigateToOrderRelatedTabSalesForcePC1() {

		wait.until(ExpectedConditions.elementToBeClickable(openOrderRelatedPC1)).click();

	}

	// -----08-09-2020

	public String patientName;
	public String usedHearingAid;
	public String insuranceProvider;

	// public String patientName;
	// public String usedHearingAid;
	// public String insuranceProvider;

	@FindBy(how = How.XPATH, using = "//a[@class='brandPrimaryFgr']")
	public WebElement leadsTab;

	@FindBy(how = How.XPATH, using = "//tbody[1]/tr[2]/td[3]/span[1]/span[1]")
	public WebElement defaulfToDate;

	@FindBy(how = How.XPATH, using = "//tbody[1]/tr[1]/td[2]/span[1]/span[1]/a[1]")
	public WebElement defaultFromDate;

	public String getInsuranceProvider() {
		return this.insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public String getUsedHearingAid() {
		return this.usedHearingAid;
	}

	public void setUsedHearingAid(String usedHearingAid) {
		this.usedHearingAid = usedHearingAid;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

// 15_10_2020 :	
	
	@FindBy(how = How.XPATH, using = "//ul[@id='tabBar']/li[5]")
	public WebElement leadTab;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[2]/span[1]/span[1]/a[1]")
	public WebElement leadFromDate;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[2]/td[3]/span[1]/span[1]")
	public WebElement leadToDate;
	
	@FindBy(how = How.XPATH, using = "//select[@id='scope']")
	public WebElement viewDropdown;
	
	@FindBy(how = How.XPATH, using = "//select[@id='scope']/option[1]")
	public WebElement myLeadsDropdown;
	
	@FindBy(how = How.XPATH, using = "//select[@id='scope']/option[3]")
	public WebElement allLeadsDropdown;
	
	@FindBy(how = How.XPATH, using = "//td/input[@type='submit']")
	public WebElement runReportButton;


	
	public void salesForceLogin() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get(prop.getProperty("saleforceURL"));

		SFuserName.sendKeys(prop.getProperty("SFUserName"));
		SFpassWord.sendKeys(prop.getProperty("SFPassword"));

		SFLogInToSanbox.click();

		// Added on 22-09-2020
		try {
				if (prop.getProperty("SFUserName").contains(".eargopc1")) {
					wait.until(ExpectedConditions.elementToBeClickable(lnkRemindMeLater));
					}
			}catch(Exception e) {
				System.out.println(e);
			}
		
	}

	public void verify_leads() {

		leadsTab.click();
		defaulfToDate.click();

	}
	
//---------------[21_10_2020]-----------
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Remind Me Later')]")
	public WebElement remindMeLaterLink;
	
	public void verify_leads_for_pc1() throws InterruptedException {

		System.out.println("Inside lead for pc1 ");
		try {
			Thread.sleep(1000);
			remindMeLaterLink.click();
		}catch(Exception e) {
			System.out.println("Remind me later Not displayed");
		}
		
		Thread.sleep(1000);
//		wait.until(ExpectedConditions.visibilityOf(leadTab));
		leadTab.click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(leadFromDate));
		leadFromDate.click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(leadToDate));
		leadToDate.click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(viewDropdown));
		viewDropdown.click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.visibilityOf(allLeadsDropdown));
		allLeadsDropdown.click();
		Thread.sleep(1000);
		
		Thread.sleep(180000);
		
		wait.until(ExpectedConditions.visibilityOf(runReportButton));
		runReportButton.click();
		
	}
	
	
	
	
	public void select_recordFrom_lead_report(String emailID) {
	
		 String patientEmailLink = "//a[contains(text(),'"+emailID+"')]/parent::td/parent::tr/td[1]/a[1]";
//		 String patientEmailLink = "//a[contains(text(),'"+emailID+"')]/parent::td/parent::tr/td[1]/a[1]";
		 System.out.println(patientEmailLink);
	     driver.findElement(By.xpath(patientEmailLink)).click();
		
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='lea2_ileinner']")
	public WebElement lead_name;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[4]/td[2]/div[1]/div[1]/a[1]")
	public WebElement lead_email;
	
	@FindBy(how = How.XPATH, using = "//div[@id='lea8_ileinner']")
	public WebElement lead_phoneNumber;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AIUW_ileinner']")
	public WebElement lead_insuranceProvider;
	
	public void validate_lead_info() {
		
//		wait.until(ExpectedConditions.visibilityOf(lead_name));
//		
//		Assert.assertEquals(lead_name.getText(), getPatientName());
//		
//		Assert.assertEquals(lead_email.getText(), federalForm.getTimeStampEmail());
//		
//		Assert.assertEquals(lead_phoneNumber.getText(), prop.getProperty("patientPhoneNumber"));
//		
//		switch (insuranceProvider.toUpperCase()) {
//		case "AETNA":
//			Assert.assertEquals(lead_insuranceProvider.getText(), "Aetna");
//			break;
//				
//		case "APWU HEALTH PLAN":
//			Assert.assertEquals(lead_insuranceProvider.getText(), "APWU Health Plan");
//			break;
//			
//			
//		case "GEHA":
//			Assert.assertEquals(lead_insuranceProvider.getText(), "GEHA");
//			break;
//			
//		case "MHBP":
//			Assert.assertEquals(lead_insuranceProvider.getText(), "MHBP");
//			break;
//			
//		case "NALC":
//			Assert.assertEquals(lead_insuranceProvider.getText(), "NALC Health Benefit Plan");
//			break;
//
//		case "OTHERS":
//			Assert.assertEquals(lead_insuranceProvider.getText(), "Others");
//			break;
//
//		case "BCBS":
//		default:
//			Assert.assertEquals(lead_insuranceProvider.getText(), "Blue Cross / Blue Shield FEP");
//			break;
//
//		}
		
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Insurance Prequalifications')]")
	public WebElement prequalificationTab;
	
	@FindBy(how = How.XPATH, using = "//input[@name='go']")
	public WebElement goButton;
	
	@FindBy(how = How.XPATH, using = "//thead/tr[1]/td[3]/div[1]")
	public WebElement actionColumn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AK2Z_ileinner']")
	public WebElement preQual_patientFirstName;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AK2o_ileinner']")
	public WebElement preQual_patientLastName;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJuG_ileinner']")
	public WebElement preQual_patientDOB;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003DgdO_ileinner']")
	public WebElement preQual_patientState;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003DgdJ_ileinner']")
	public WebElement preQual_patientZipCode;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AK3N_ileinner']")
	public WebElement preQual_payerName;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000000TF5l_ileinner']")
	public WebElement preQual_phone;

	@FindBy(how = How.XPATH, using = "//div[@id='00N2a0000037ryH_ileinner']")
	public WebElement preQual_verificationStatus;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJvs_ileinner']")
	public WebElement preQual_memberID;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJvd_ileinner']")
	public WebElement preQual_enrollmentCode;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJvi_ileinner']")
	public WebElement preQual_groupNumber;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJuV_ileinner']")
	public WebElement preQual_primaryOrDependent;
	
	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJwl_ileinner']")
	public WebElement preQual_usedBenifits;

	@FindBy(how = How.XPATH, using = "//div[@id='00N2a000003AJwg_ileinner']")
	public WebElement preQual_medicalCare;
	
	public String preQual_verification_status(String email) {
		
		 String patientEmailLink = "//span[contains(text(),'"+email+"')]/parent::a/parent::div/parent::div/parent::td/parent::tr/td[11]";
		 System.out.println(patientEmailLink);
		 String verificationStatus = driver.findElement(By.xpath(patientEmailLink)).getText();
	     return verificationStatus;	 
	}
	
	public void select_preQual_id(String email) throws InterruptedException {
		System.out.println("inside prequal ID");
		String patientEmailLink = "//span[contains(text(),'"+email+"')]/parent::a/parent::div/parent::div/parent::td/parent::tr/td[4]/div[1]/a[1]/span";
		System.out.println("select-preQualId= "+patientEmailLink);
		Thread.sleep(2000);
	    driver.findElement(By.xpath(patientEmailLink)).click();	   
	    
	}
	
//	public void validate_preQual_info(String benifits_Used) {
		
	public void validate_preQual_info() throws InterruptedException {
		
		prequalificationTab.click();
		
		wait.until(ExpectedConditions.visibilityOf(goButton));
		
		System.out.println("inside - validate_preQual_info");
		
		Thread.sleep(3000);
		
		goButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(actionColumn));
	}
		
//		if(benifits_Used.equalsIgnoreCase("YES")) {
//			
//			switch (insuranceProvider.toUpperCase()) {
//			case "BCBS":
//			case "GEHA":
//			case "NALC":	
//				Assert.assertEquals(preQual_verification_status(), "Processed");
//				break;
//			
//			case "AETNA":
//			case "MHBP":
//			case "OTHERS":	
//				Assert.assertEquals(preQual_verification_status(), "Unable to Verify");
//				break;
//			}
//			
//		}else if(benifits_Used.equalsIgnoreCase("NOT SURE")) {
//			switch (insuranceProvider.toUpperCase()) {
//			case "BCBS":
//			case "GEHA":
//			case "NALC":	
//				Assert.assertEquals(preQual_verification_status(), "Processed");
//				break;
//			
//			case "AETNA":
//			case "MHBP":
//			case "OTHERS":	
//				Assert.assertEquals(preQual_verification_status(), "Unable to Verify");
//				break;
//			}
//			
//		}else{
//			switch (insuranceProvider.toUpperCase()) {
//			case "BCBS":
//			case "GEHA":
//			case "NALC":	
//				Assert.assertEquals(preQual_verification_status(), "Processed");
//				break;
//				
//			case "AETNA":
//			case "MHBP":
//			case "OTHERS":	
//				Assert.assertEquals(preQual_verification_status(), "Unable to Verify");
//				break;
//			}
//		}
			
//		select_preQual_id();
		
//		Assert.assertEquals(preQual_patientFirstName.getText(),"" );
		
//		Assert.assertEquals(preQual_patientLastName.getText(),"" );
		
//		Assert.assertEquals(preQual_patientDOB.getText(), getGiven_DOB());
//		
//		Assert.assertEquals(preQual_patientState.getText(),getGiven_state() );
//	
//		switch (insuranceProvider.toUpperCase()) {
//		
//		case "BCBS":
//			Assert.assertEquals(preQual_payerName.getText(),"Blue Cross / Blue Shield FEP");
//			break;
//			
//		case "GEHA":
//			Assert.assertEquals(preQual_payerName.getText(),"GEHA");
//			break;
//			
//		case "NALC":	
//			Assert.assertEquals(preQual_payerName.getText(),"NALC Health Benefit Plan");
//			break;
//			
//		case "AETNA":
//			Assert.assertEquals(preQual_payerName.getText(),"Aetna");
//			break;
//			
//		case "MHBP":
//			Assert.assertEquals(preQual_payerName.getText(),"MHBP");
//			break;
//			
//		case "OTHERS":
//			Assert.assertEquals(preQual_payerName.getText(),"");
//			break;
//			
//		}
//				
//		Assert.assertEquals(preQual_phone.getText(),prop.getProperty("patientPhoneNumber"));
//		
//		if(benifits_Used.equalsIgnoreCase("YES")) {
//			
//			Assert.assertEquals(preQual_verificationStatus.getText(),"YES");
//			
//		}else if (benifits_Used.equalsIgnoreCase("NO")) {
//			
//			Assert.assertEquals(preQual_verificationStatus.getText(),"NO" );
//			
//		}else {
//			
//			Assert.assertEquals(preQual_verificationStatus.getText(),"NOT SURE");
//			
//		}
//		
//		Assert.assertEquals(preQual_memberID.getText(),getGiven_MemberID());
//		
//		Assert.assertEquals(preQual_enrollmentCode.getText(),getGiven_EnrollmentCode() );
//		
//		Assert.assertEquals(preQual_groupNumber.getText(),getGiven_GroupNumber());
//		
//		Assert.assertEquals(preQual_usedBenifits.getText(),getGiven_BenifitsUsed());
//	
//		if(!insuranceProvider.equals("NALC")) {
//			Assert.assertEquals(preQual_patientZipCode.getText(),getGiven_ZipCode());  //not for NALC		
//		}
//		
//		if(!insuranceProvider.equals("BCBS")) {
//				Assert.assertEquals(preQual_primaryOrDependent.getText(),getGiven_PrimaryOrDependent() ); //not for bcbs
//		}
//	
//		if(insuranceProvider.equals("NALC")) {
//				Assert.assertEquals(preQual_medicalCare.getText(),getGiven_MedicalCare()); // available for NALC		
//		}
				
		
//		}
	
	
	private String given_DOB;
	private String given_MemberID;
	private String given_EnrollmentCode;
	private String given_GroupNumber;
	private String given_BenifitsUsed;
	private String given_ZipCode;
	private String given_PrimaryOrDependent;
	private String given_MedicalCare;
	private String given_state;

	public String getGiven_DOB() {
		return given_DOB;
	}

	public void setGiven_DOB(String given_DOB) {
		this.given_DOB = given_DOB;
	}
	
	public String getGiven_MemberID() {
		return given_MemberID;
	}

	public void setGiven_MemberID(String given_MemberID) {
		this.given_MemberID = given_MemberID;
	}

	public String getGiven_EnrollmentCode() {
		return given_EnrollmentCode;
	}

	public void setGiven_EnrollmentCode(String given_EnrollmentCode) {
		this.given_EnrollmentCode = given_EnrollmentCode;
	}

	public String getGiven_GroupNumber() {
		return given_GroupNumber;
	}

	public void setGiven_GroupNumber(String given_GroupNumber) {
		this.given_GroupNumber = given_GroupNumber;
	}
	
	public String getGiven_BenifitsUsed() {
		return given_BenifitsUsed;
	}

	public void setGiven_BenifitsUsed(String given_BenifitsUsed) {
		this.given_BenifitsUsed = given_BenifitsUsed;
	}
	
	public String getGiven_ZipCode() {
		return given_ZipCode;
	}

	public void setGiven_ZipCode(String given_ZipCode) {
		this.given_ZipCode = given_ZipCode;
	}

	public String getGiven_PrimaryOrDependent() {
		return given_PrimaryOrDependent;
	}

	public void setGiven_PrimaryOrDependent(String given_PrimaryOrDependent) {
		this.given_PrimaryOrDependent = given_PrimaryOrDependent;
	}

	public String getGiven_MedicalCare() {
		return given_MedicalCare;
	}

	public void setGiven_MedicalCare(String given_MedicalCare) {
		this.given_MedicalCare = given_MedicalCare;
	}
	
	public String getGiven_state() {
		return given_state;
	}

	public void setGiven_state(String given_state) {
		this.given_state = given_state;
	}

	
	
}

