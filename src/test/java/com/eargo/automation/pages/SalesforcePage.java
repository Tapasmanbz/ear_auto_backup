package com.eargo.automation.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SalesforcePage extends BasePage {

	String deliveryTaxValue = null;
	String deliveryTaxValue1 = null;

	public SalesforcePage() {
		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

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

	@FindBy(how = How.ID, using = "00NA000000BDBvb_ileinner")
	public WebElement deliveryTax;

	@FindBy(how = How.ID, using = "00NA000000BDBvg_ileinner")
	public WebElement shippingTax;

	@FindBy(how = How.ID, using = "00N4D000000siMi_ileinner")
	public WebElement appliedCoupon;

	@FindBy(how = How.ID, using = "00NA000000BxUfX_ileinner")
	public WebElement couponDiscount;

	private String neoHifiProdName;
	private String neoHifiProdPrice;
	private String accessoryName;
	private String accessoryPrice;
	private String defaultCoupon;

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

		// driver.switchTo().window(tabs.get(0)); // switch back to main screen
		Thread.sleep(3000);

	}

	public String sfOrderTax() {
		deliveryTaxValue = deliveryTax.getText();
		deliveryTaxValue1 = "$" + deliveryTaxValue + "0";
		System.out.println("sfOrderTax=" + deliveryTaxValue1);
		return this.deliveryTaxValue1;
	}

	// -------------------------------------------------------------------------------------------------------------------

	@FindBy(how = How.ID, using = "//div[@class='pShowMore']//child::a[2]")
	public WebElement show_more_prods;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO 2.1, HIFI, NEW SYSTEM')]")
	public WebElement check_eargo_Neo_Hifi;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO NEO SYSTEM')]")
	public WebElement check_eargo_Neo;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO MAX SYSTEM')]")
	public WebElement check_eargo_Max;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Eargo Wax Guard Replacement Tool')]")
	public WebElement check_wax;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Eargo Flexi Fiber Bundle, Size Regular')]")
	public WebElement check_flexiFiber_regular;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Eargo Flexi Fiber Bundle, Size Large')]")
	public WebElement check_flexiFiber_large;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO PLUS ACCESSORY KIT FLEXI DOME, REGULAR')]")
	public WebElement check_flexiDomes_regular;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO PLUS ACCESSORY KIT FLEXI DOME, LARGE')]")
	public WebElement check_flexiDomes_large;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Eargo Neo Flexi Palm Accessory Kit, Regular')]")
	public WebElement check_flexiPalms_regular;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Eargo Neo Flexi Palm Accessory Kit, Large')]")
	public WebElement check_flexiPalms_large;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO HIFI, ACCESSORY KIT, TETRA FLEXI PALM, SIZE REGULAR')]")
	public WebElement check_flexiTetraPalms_regular;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'EARGO HIFI, ACCESSORY KIT, TETRA FLEXI PALM, SIZE LARGE')]")
	public WebElement check_flexiTetraPalms_large;

	public ArrayList<String> prodsOn_SF_Page() throws InterruptedException {

		show_more_prods.click();

		ArrayList<String> prods_on_salesForce_page = new ArrayList<String>();

		String[] products = { "Eargo Neo HiFi", "Eargo Neo", "Eargo Max", "Flexi TetraPalms Regular",
				"Flexi TetraPalms Large", "Flexi Palms Large", "Flexi Palms Regular", "Flexi Domes Large",
				"Flexi Domes Regular", "Flexi Fibers Large", "Flexi Fibers Regular", "Wax Guard Replacement Tool" };

		for (int i = 0; i < products.length; i++) {

			String prod = products[i];
			boolean prod_Available;

			switch (prod.toLowerCase()) {

			case "eargo neo hifi":
				prod_Available = check_eargo_Neo_Hifi.isDisplayed();
				if (prod_Available == true) {
					prods_on_salesForce_page.add("Eargo Neo HiFi");
				}
				break;

			case "eargo neo":
				prod_Available = check_eargo_Neo.isDisplayed();
				if (prod_Available == true) {
					prods_on_salesForce_page.add("Eargo Neo");
				}
				break;

			case "eargo max":
				prod_Available = check_eargo_Max.isDisplayed();
				if (prod_Available == true) {
					prods_on_salesForce_page.add("Eargo Max");
				}
				break;

			case "flexi tetraPalms regular":
				prod_Available = check_flexiTetraPalms_regular.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi TetraPalms Regular");
				}
				break;

			case "flexi tetraPalms large":
				prod_Available = check_flexiTetraPalms_large.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi TetraPalms Large");
				}
				break;

			case "flexi palms large":
				prod_Available = check_flexiPalms_large.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi Palms Large");
				}
				break;

			case "flexi palms regular":
				prod_Available = check_flexiPalms_regular.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi Fibers Regular");
				}
				break;

			case "flexi domes large":
				prod_Available = check_flexiDomes_large.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi Domes Large");
				}
				break;

			case "flexi domes regular":
				prod_Available = check_flexiDomes_regular.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi Domes Regular");
				}
				break;

			case "flexi fibers regular":
				prod_Available = check_flexiFiber_regular.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi Fibers Regular");
				}
				break;

			case "flexi fibers large":
				prod_Available = check_flexiFiber_large.isDisplayed();

				if (prod_Available == true) {
					prods_on_salesForce_page.add("Flexi Fibers Large");
				}
				break;

			case "wax guard replacement tool":
				prod_Available = check_wax.isDisplayed();
				if (prod_Available == true) {
					prods_on_salesForce_page.add("Wax Guard Replacement Tool");
				}
				break;

			}
		}
		return (prods_on_salesForce_page);
	}

}
