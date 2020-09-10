package com.eargo.automation.pages;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

	// @FindBy(how = How.XPATH, using = "//div[@class='columnContainer
	// estimated_delivery_container']")
	// public WebElement estimationDeliveryDate;

	@FindBy(how = How.XPATH, using = "//div[@class='columnContainer estimated_delivery_container']//span[1]")
	public WebElement estimationDeliveryDate;

	@FindBy(how = How.XPATH, using = "//span[@class='body1_regular orderNumber']")
	public WebElement orderSummary;

	@FindBy(how = How.XPATH, using = "//span[@class='price']")
	public WebElement prodPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='tax']//div[1]//span[1]")
	public WebElement taxApplied;

	@FindBy(how = How.XPATH, using = "//div[@class='tax']//div[2]//span[1]")
	public WebElement shippingPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='orderSummary']//div[3]//span[1]")
	public WebElement discountApplied;

	@FindBy(how = How.XPATH, using = "//li[contains(@class,'d-list-item')]/div[@class='d-flex']")
	public List<WebElement> allProductsSummary;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'productName')]")
	public List<WebElement> productName;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'productName')]/parent::div/following-sibling::div")
	public List<WebElement> productSize;

	@FindBy(how = How.XPATH, using = "//span[@class='quantity bold']")
	public List<WebElement> productQuantity;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'price')]")
	public List<WebElement> productPrice;

	public String getDiscountValue() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(orderNumber));
		String discountValue = null;

		try {

			discountApplied.isDisplayed();
			// String disApply = discountApplied.getText();
			discountValue = discountApplied.getText().substring(discountApplied.getText().lastIndexOf(" ") + 1);
			System.out.println(discountValue);

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

		return shippingAddress;

	}

	public String getOriginalProductPrice() throws InterruptedException {

		String originalProductPrice = null;

		prodPrice.isDisplayed();
		originalProductPrice = prodPrice.getText();
		System.out.println(originalProductPrice);

		return originalProductPrice;

	}

	public String getOriginalProductQuantity() throws InterruptedException {
		String quantity = null;
		productQuantity.get(0).isDisplayed();
		// String shPrice = shippingPrice.getText();
		quantity = productQuantity.get(0).getText();
		System.out.println(quantity);

		return quantity;
	}

	public HashMap<String, String> getOrderProducts() throws InterruptedException {

		HashMap<String, String> productOrderTable = new HashMap<String, String>();

		Iterator productIterator = allProductsSummary.iterator();

		// while(productIterator.hasNext()){
		// WebElement productRow = (WebElement) productIterator.next();
		// String key = productRow.findElement(by)
		// String value =
		// productOrderTable.put(key, value)
		// int key = m.getKey();
		// String value=m.getValue();
		// System.out.println("Key :"+key+" value :"+value);
		// }

		for (int i = 0; i < allProductsSummary.size(); i++) {
			String key = null;
			String pName = productName.get(i).getText();
			String pSize = productSize.get(i).getText();

			if (pName.equalsIgnoreCase("Eargo Neo HiFi"))
				key = "NEO_ HIFI";
			else if (pName.equalsIgnoreCase("Eargo Max"))
				key = "MAX";
			else if (pName.equalsIgnoreCase("Eargo Neo"))
				key = "NEO";
			else if (pName.equalsIgnoreCase("Flexi Fibers") && pSize.equalsIgnoreCase("Regular"))
				key = "FLEXI_FIBERS_REGULAR";
			else if (pName.equalsIgnoreCase("Flexi Fibers") && pSize.equalsIgnoreCase("Large"))
				key = "FLEXI_FIBERS_LARGE";
			else if (pName.equalsIgnoreCase("Flexi Domes") && pSize.equalsIgnoreCase("Regular"))
				key = "FLEXI_DOMES_REGULAR";
			else if (pName.equalsIgnoreCase("Flexi Domes") && pSize.equalsIgnoreCase("Large"))
				key = "FLEXI_DOMES_LARGE";
			else if (pName.equalsIgnoreCase("Flexi Palms") && pSize.equalsIgnoreCase("Regular"))
				key = "FLEXI_PALMS_REGULAR";
			else if (pName.equalsIgnoreCase("Flexi Palms") && pSize.equalsIgnoreCase("Large"))
				key = "FLEXI_PALMS_LARGE";
			else if (pName.equalsIgnoreCase("Flexi TetraPalms") && pSize.equalsIgnoreCase("Regular"))
				key = "FLEXI_TETRA_PALMS_REGULAR";
			else if (pName.equalsIgnoreCase("Flexi TetraPalms") && pSize.equalsIgnoreCase("Large"))
				key = "FLEXI_TETRA_PALMS_LARGE";
			else if (pName.equalsIgnoreCase("Wax Guard Replacement Tool"))
				key = "WAX";
			else
				key = "UNKNOWN";

			String quantity = productQuantity.get(i).getText();
			String value = quantity.replaceAll("[^\\d]", "");
			String price = productPrice.get(i).getText();
			System.out.println(
					"Key:" + key + " quantity:" + value + "  price:" + price + "  pName:" + pName + "  pSize:" + pSize);
			productOrderTable.put(key, value);
		}

		return productOrderTable;
	}

	public String getProductsSubtotal() throws InterruptedException {
		return null;
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

	/**
	 * Get "Order_Number" from order confirmation page
	 * 
	 * @return String order number
	 */
	public String getOrderNumber() {

		String orderNo = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(orderNumber));
		orderNo = orderNumber.getText().substring(orderNumber.getText().lastIndexOf(" ") + 1);
		System.out.println(orderNo);

		return orderNo;

	}

	/**
	 * Get "Email_ID" from order confirmation page
	 * 
	 * @return String email id from which order has been placed
	 */
	public String getEmailID() {

		String email = null;

		try {
			confirmationEmailID.isDisplayed();
			// String CEID = confirmationEmailID.getText();
			email = confirmationEmailID.getText().substring(confirmationEmailID.getText().lastIndexOf(" ") + 1);

			System.out.println(email);

		} catch (Exception e) {

			System.out.println(e);

		}

		return email;

	}

	/**
	 * Get "Estimated_Delivery_date" from order confirmation page
	 * 
	 * @return String Estimated Delivery date
	 * @throws InterruptedException
	 */
	public String getDeliveryDate() throws InterruptedException {

		String deliveryDate = null;
		estimationDeliveryDate.isDisplayed();
		deliveryDate = estimationDeliveryDate.getText();
		System.out.println(deliveryDate);

		return deliveryDate;

	}

	// Method to get "order_Summary / Total_Price" from order confirmation page

	public String getOrderSummaryAmount() {

		String orderSummaryAmount = null;

		try {
			// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			// wait.until(ExpectedConditions.visibilityOf(orderSummary));
			orderSummaryAmount = orderSummary.getText();
			System.out.println("----" + orderSummaryAmount + "----");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return orderSummaryAmount;
	}

	// Method to get "Tax / Order Tax" (with respect to the given state and zipcode)
	// from order confirmation page

	public String getTaxAmount() throws InterruptedException {

		String taxAmount = null;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(taxApplied));
		// String tA = taxApplied.getText();
		taxAmount = taxApplied.getText().substring(taxApplied.getText().lastIndexOf(" ") + 1);
		System.out.println(taxAmount);

		return taxAmount;

	}

	// Method to get "Shipping / Order_Shipping_&_Handling_Cost" from order
	// confirmation page

	public String getShippingCharges() throws InterruptedException {

		String shippingCharges = null;
		shippingPrice.isDisplayed();
		// String shPrice = shippingPrice.getText();
		shippingCharges = shippingPrice.getText().substring(shippingPrice.getText().lastIndexOf(" ") + 1);
		System.out.println(shippingCharges);

		if (shippingCharges.equals("FREE")) {
			shippingCharges = "$0.00";
		}

		return shippingCharges;

	}

}
