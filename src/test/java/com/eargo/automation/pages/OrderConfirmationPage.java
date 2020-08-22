package com.eargo.automation.pages;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage {

	public OrderConfirmationPage() {

		PageFactory.initElements(driver, this);
		waitForPageLoad();
	}

	@FindBy(how = How.XPATH, using = "//div[@class='rowContainer orderNumber']")
	public WebElement orderNumber;

	@FindBy(how = How.XPATH, using = "//div[@class='orderInformation']//div[@class='rowContainer']//span[1]")
	public WebElement confirmationEmailID;

	@FindBy(how = How.XPATH, using = "//div[@class='shippingInformation']/div[1]/span[1]/following-sibling::span")
	public WebElement willBeShippedTo;

//	@FindBy(how = How.XPATH, using = "//div[@class='columnContainer estimated_delivery_container']")
//	public WebElement estimationDeliveryDate;
	
	@FindBy(how = How.XPATH, using = "//div[@class='columnContainer estimated_delivery_container']//span[1]")
	public WebElement estimationDeliveryDate;

	@FindBy(how = How.XPATH, using = "//span[@class='body1_regular orderNumber']")
	public WebElement orderSummary;

	@FindBy(how = How.XPATH, using = "//span[@class='quantity bold']")
	public WebElement productQuantity;

	@FindBy(how = How.XPATH, using = "//span[@class='price']")
	public WebElement prodPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='tax']//div[1]//span[1]")
	public WebElement taxApplied;
	
	@FindBy(how = How.XPATH, using = "//div[@class='tax']//div[2]//span[1]")
	public WebElement shippingPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='orderSummary']//div[3]//span[1]")
	public WebElement discountApplied;

	

	public String getDiscountValue() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(orderNumber)).isDisplayed();
		String discountValue = null;

		try {

			discountApplied.isDisplayed();
			// String disApply = discountApplied.getText();
			discountValue = discountApplied.getText().substring(discountApplied.getText().lastIndexOf(" ") + 1);
			System.out.println(discountValue);
			Thread.sleep(2000);

		} catch (Exception e) {

			System.out.println(e);
		}

		return discountValue;

	}

	

	public String getShippingAddress() throws InterruptedException {

		String shippingAddress = null;
		willBeShippedTo.isDisplayed();
		shippingAddress = willBeShippedTo.getText();
		System.out.println(shippingAddress);
		Thread.sleep(2000);

		return shippingAddress;

	}

	
	

	public String getOriginalProductPrice() throws InterruptedException {

		String originalProductPrice = null;

		prodPrice.isDisplayed();
		originalProductPrice = prodPrice.getText();
		System.out.println(originalProductPrice);
		Thread.sleep(2000);

		return originalProductPrice;

	}

	

	

	public String getOriginalProductQuantity() throws InterruptedException {
		String quantity = null;
		productQuantity.isDisplayed();
		// String shPrice = shippingPrice.getText();
		quantity = productQuantity.getText();
		System.out.println(quantity);

		return quantity;
	}

	public String getProductSubtotalAmt(String price, String quantity) throws InterruptedException {

		Float productSubtotal = null;
		// DecimalFormat df = new DecimalFormat("0.00");
		productSubtotal = Float.parseFloat(price.replaceAll("[^0-9.]", ""))
				* Float.parseFloat(quantity.replaceAll("[^\\d]", ""));
		System.out.println("Product Subtotal:" + productSubtotal);
		Locale usa = new Locale("en", "US");
		NumberFormat defaultFormat = NumberFormat.getCurrencyInstance(usa);
		return defaultFormat.format(productSubtotal);
	}
	
//	Method to get "Order_Number" from order confirmation page
	
	public String getOrderNumber() {

		String orderNo = null;
		orderNumber.isDisplayed();
		// String ON = orderNumber.getText();
		orderNo = orderNumber.getText().substring(orderNumber.getText().lastIndexOf(" ") + 1);
		System.out.println(orderNo);

		return orderNo;

	}
	

//	Method to get "Email_ID" from order confirmation page
	
	public String getEmailID() {

		String email = null;

		try {
			confirmationEmailID.isDisplayed();
			// String CEID = confirmationEmailID.getText();
			email = confirmationEmailID.getText().substring(confirmationEmailID.getText().lastIndexOf(" ") + 1);

			System.out.println(email);
			Thread.sleep(2000);

		} catch (Exception e) {

			System.out.println(e);

		}

		return email;

	}
	

//	Method to get "Estimation_Delivery_date" from order confirmation page
	
	public String getDeliveryDate() throws InterruptedException {

		String deliveryDate = null;
		estimationDeliveryDate.isDisplayed();
		deliveryDate = estimationDeliveryDate.getText();
		System.out.println(deliveryDate);
		Thread.sleep(2000);

		return deliveryDate;

	}
		

//	Method to get "order_Summary / Total_Price" from order confirmation page
	
	public String getOrderSummaryAmount() {

		String orderSummaryAmount = null;

		try {
			Thread.sleep(2000);
			orderSummary.isDisplayed();
			orderSummaryAmount = orderSummary.getText();
			System.out.println("----" + orderSummaryAmount + "----");
			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return orderSummaryAmount;
	}
	

//	Method to get "Tax / Order Tax" (with respect to the given state and zipcode) from order confirmation page
	
	public String getTaxAmount() throws InterruptedException {

		String taxAmount = null;

		taxApplied.isDisplayed();
		// String tA = taxApplied.getText();
		taxAmount = taxApplied.getText().substring(taxApplied.getText().lastIndexOf(" ") + 1);
		System.out.println(taxAmount);
		Thread.sleep(2000);

		return taxAmount;

	}
		

//	Method to get "Shipping / Order_Shipping_&_Handling_Cost" from order confirmation page

	public String getShippingCharges() throws InterruptedException {

		String shippingCharges = null;
		shippingPrice.isDisplayed();
		// String shPrice = shippingPrice.getText();
		shippingCharges = shippingPrice.getText().substring(shippingPrice.getText().lastIndexOf(" ") + 1);
		System.out.println(shippingCharges);

		return shippingCharges;

	}
	
	
	
	
	
	
//---------------------------------------------------------------------------		
		
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Eargo Neo HiFi')]")
	public WebElement check_eargo_Neo_Hifi;

	@FindBy(how = How.XPATH, using = "//div[text()[not(contains(.,'Eargo Neo HiFi'))]] | div[contains(text(),'Eargo Neo')]")
	public WebElement check_eargo_Neo;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Eargo Max')]")
	public WebElement check_eargo_Max;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Wax Guard Replacement Tool')]")
	public WebElement check_wax;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Fibers')]")
	public WebElement check_flexiFiber;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Fibers')]//ancestor::li//descendant::div[contains(text(),'Regular')]")
	public WebElement check_flexiFiber_regular;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Fibers')]//ancestor::li//descendant::div[contains(text(),'Large')]")
	public WebElement check_flexiFiber_large;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Domes')]")
	public WebElement check_flexiDomes;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Domes')]//ancestor::li//descendant::div[contains(text(),'Regular')]")
	public WebElement check_flexiDomes_regular;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Domes')]//ancestor::li//descendant::div[contains(text(),'Large')]")
	public WebElement check_flexiDomes_large;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Palms')]")
	public WebElement check_flexiPalms;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Palms')]//ancestor::li//descendant::div[contains(text(),'Regular')]")
	public WebElement check_flexiPalms_regular;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Palms')]//ancestor::li//descendant::div[contains(text(),'Large')]")
	public WebElement check_flexiPalms_large;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Palms')]")
	public WebElement check_flexiTetraPalms;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Palms')]//ancestor::li//descendant::div[contains(text(),'Regular')]")
	public WebElement check_flexiTetraPalms_regular;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flexi Palms')]//ancestor::li//descendant::div[contains(text(),'Large')]")
	public WebElement check_flexiTetraPalms_large;

	
// Method to get "Products_Name" from order confirmation page
	
	public ArrayList<String> prodsOnConfirmPage() throws InterruptedException {
		
	ArrayList<String> prods_on_confirm_page = new ArrayList<String>();

	String[] products = {"Eargo Neo HiFi", "Eargo Neo", "Eargo Max", "Flexi TetraPalms Regular", "Flexi TetraPalms Large","Flexi Palms Large",
			"Flexi Palms Regular", "Flexi Domes Large", "Flexi Domes Regular", "Flexi Fibers Large", "Flexi Fibers Regular", "Wax Guard Replacement Tool"};


	for (int i = 0; i < products.length; i++) {
	  
	String prod = products[i];
	boolean prod_Available;
	boolean regular;
	boolean large;
	
	switch (prod.toLowerCase()) {

		case "eargo neo hifi":
			prod_Available = check_eargo_Neo_Hifi.isDisplayed();
				if(prod_Available == true){
					prods_on_confirm_page.add("Eargo Neo HiFi");
				}
		break;

		case "eargo neo":
			prod_Available = check_eargo_Neo.isDisplayed();
				if(prod_Available == true){
					prods_on_confirm_page.add("Eargo Neo");
				}
		break;
	
		
		case "eargo max":
			prod_Available = check_eargo_Max.isDisplayed();
				if(prod_Available == true){
					prods_on_confirm_page.add("Eargo Max");
				}
		break;
		
		case "flexi tetraPalms regular":
			prod_Available = check_flexiTetraPalms.isDisplayed();
				
				if(prod_Available == true){
					regular = check_flexiTetraPalms_regular.isDisplayed();
						if(regular==true) {	
							prods_on_confirm_page.add("Flexi TetraPalms Regular");
						}
				}
		break;
		
		case "flexi tetraPalms large":
			prod_Available = check_flexiTetraPalms.isDisplayed();
				
				if(prod_Available == true){
					large = check_flexiTetraPalms_large.isDisplayed();
						if(large==true) {	
							prods_on_confirm_page.add("Flexi TetraPalms Large");
						}
				}
		break;
		
		case "flexi palms large":
			prod_Available = check_flexiPalms.isDisplayed();
				
				if(prod_Available == true){
					large = check_flexiPalms_large.isDisplayed();
						if(large==true) {	
							prods_on_confirm_page.add("Flexi Palms Large");
						}
				}
		break;
		
		case "flexi palms regular":
			prod_Available = check_flexiPalms.isDisplayed();
				
				if(prod_Available == true){
					regular = check_flexiPalms_regular.isDisplayed();
						if(regular==true) {	
							prods_on_confirm_page.add("Flexi Fibers Regular");
						}
				}
		break;
		
		case "flexi domes large":
			prod_Available = check_flexiDomes.isDisplayed();
				
				if(prod_Available == true){
					large = check_flexiDomes_large.isDisplayed();
						if(large==true) {	
							prods_on_confirm_page.add("Flexi Domes Large");
						}
				}
		break;
		
		case "flexi domes regular":
			prod_Available = check_flexiDomes.isDisplayed();
				
				if(prod_Available == true){
					regular = check_flexiDomes_regular.isDisplayed();
						if(regular==true) {	
							prods_on_confirm_page.add("Flexi Domes Regular");
						}
				}
		break;
		
		case "flexi fibers regular":
			prod_Available = check_flexiFiber.isDisplayed();
				
				if(prod_Available == true){
					regular = check_flexiFiber_regular.isDisplayed();
						if(regular==true) {	
							prods_on_confirm_page.add("Flexi Fibers Regular");
						}
				}
		break;
		
		case "flexi fibers large":
			prod_Available = check_flexiFiber.isDisplayed();
				
				if(prod_Available == true){
					large = check_flexiFiber_large.isDisplayed();
						if(large==true) {	
							prods_on_confirm_page.add("Flexi Fibers Large");
						}
				}
		break;	
		
		case "wax guard replacement tool":
			prod_Available = check_wax.isDisplayed();
				if(prod_Available == true){
					prods_on_confirm_page.add("Wax Guard Replacement Tool");
				}
		break;
	
		
			}
		}
	 
	return(prods_on_confirm_page);
	}
	
	
	
}
