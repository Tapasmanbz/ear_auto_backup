package com.eargo.automation.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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

	@FindBy(how = How.ID, using = "helpBubble")
	public WebElement searchGotSmaterPopUP;

	@FindBy(how = How.ID, using = "helpBubbleCloseX")
	public WebElement btnCloseSearchGotSmaterPopUP;

	@FindBy(how = How.XPATH, using = "//td[text()='Order Status']/following-sibling::td/div")
	public WebElement orderStatus;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Store Order Total')]/following-sibling::td/div")
	public WebElement storeOrderTotal;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Subtotal')]/following-sibling::td/div")
	public WebElement storeSubTotal;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Store Shipping & Handling Cost')]/following-sibling::td/div")
	public WebElement storeShippingAndHandlingCost;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Store Tax')]/following-sibling::td/div")
	public WebElement storeTax;

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Store Promo Discount')]/following-sibling::td/div")
	public WebElement storePromoDiscount;

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

			try {
				lnkRemindMeLater.click();
			} catch (Exception e) {

			}

			Thread.sleep(3000);

			ordersTab.click();

			Thread.sleep(2000);
			searchOrderNumber.sendKeys(orderNumber);
			wait.until(ExpectedConditions.elementToBeClickable(searchOrderButton)).click();
			// Thread.sleep(2000);
			//
			// try {
			// WebDriverWait searchGotSmaterPopUPWait = new WebDriverWait(driver,
			// Duration.ofSeconds(5));
			// searchGotSmaterPopUPWait.until(ExpectedConditions.visibilityOf(searchGotSmaterPopUP));
			// searchGotSmaterPopUPWait.until(ExpectedConditions.elementToBeClickable(btnCloseSearchGotSmaterPopUP)).click();
			// } catch (TimeoutException e) {
			//
			// }

			System.out.println("in order details");
			Thread.sleep(2000);

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
				else if (prodName.contains("Flexi Palm Accessory Kit, Large")
						|| prodName.contains("PALM FLEXI FIBER, LARGE"))
					key = "FLEXI_PALMS_LARGE";
				else if (prodName.contains("Flexi Palm Accessory Kit, Regular")
						|| prodName.contains("PALM FLEXI FIBER, REGULAR"))
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

	private String patientName;
	private String usedHearingAid;
	private String insuranceProvider;

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

	public void salesForceLogin() {
		((JavascriptExecutor) driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		driver.get(prop.getProperty("saleforceURL"));

		SFuserName.sendKeys(prop.getProperty("SFUserName"));
		SFpassWord.sendKeys(prop.getProperty("SFPassword"));

		SFLogInToSanbox.click();

		// Added on 22-09-2020
		if (prop.getProperty("SFUserName").contains(".eargopc1")) {
			wait.until(ExpectedConditions.elementToBeClickable(lnkRemindMeLater));
		}

	}

	public void verify_leads() {
		leadsTab.click();
		defaulfToDate.click();
	}

	public double getStoreOrderTotal() {
		String amount = storeOrderTotal.getText();
		return getFormattedAmount(amount, 1);
	}

	public double getStoreSubTotal() {
		String amount = storeSubTotal.getText();
		return getFormattedAmount(amount, 1);
	}

	public double getStoreShippingAndHandlingCost() {
		String amount = storeShippingAndHandlingCost.getText();
		return getFormattedAmount(amount, 1);
	}

	public double getStoreTax() {
		String amount = storeTax.getText();
		return getFormattedAmount(amount, 1);
	}

	public double getStorePromoDiscount() {
		String amount = storePromoDiscount.getText();
		return getFormattedAmount(amount, 1);
	}
}
