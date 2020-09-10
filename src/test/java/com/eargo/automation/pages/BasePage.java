package com.eargo.automation.pages;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eargo.automation.base.TestBase;

public class BasePage extends TestBase {

	/**
	 * This method will generate unique Email based on datetimestamp
	 * 
	 * @return
	 */
	public static String generateUniqueEmail() {

		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");

		String uniqueEmail = "automn_" + ft.format(dNow) + "@eargo.com";
		return uniqueEmail;
	}

	private String defaultEmail;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	@FindBy(how = How.XPATH, using = "//span[@id='_GUARANTEE_SealSpan']/img[@alt='Norton Shopping Guarantee']")
	public WebElement nortonPopUp;

	@FindBy(how = How.ID, using = "firstName")
	public WebElement breadPopUp;

	@FindBy(how = How.XPATH, using = "//div[@class='nav_list nav_horizontal nav-mm-inactive']//a[contains(text(),'Shop')]")
	public WebElement dropDwnShop;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Accessories')]")
	public WebElement linkAccessories;

	public void setDefaultEmail(String email) {

		this.defaultEmail = email;

	}

	public String getDefaultEmail() {

		return this.defaultEmail;
	}

	public void setFirstName() {

		this.firstName = prop.getProperty("firstName");
	}

	public String getFirstName() {

		return this.firstName;
	}

	public void setLastName() {

		this.lastName = prop.getProperty("lastName");
	}

	public String getLastName() {

		return this.lastName;
	}

	public void setPhoneNumber() {

		this.phoneNumber = prop.getProperty("Phone");
	}

	public String getPhoneNumber() {

		return this.phoneNumber;
	}

	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

	}

	public void scrollToElement(WebElement element) throws InterruptedException {
		String script_string = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0); var elementTop = arguments[0].getBoundingClientRect().top; window.scrollBy(0, elementTop-(viewPortHeight/4));";
		((JavascriptExecutor) driver).executeScript(script_string, element);
		Thread.sleep(1000);
	}

	public void navigateToProductPage(String productName) throws InterruptedException {
		switch (productName.toUpperCase()) {
		case "NEO":
			if (!driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("neoPageURL"))) {
				driver.get(prop.getProperty("neoPageURL"));
				Thread.sleep(2000);
			}
			break;
		case "MAX":
			if (!driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("maxPageURL"))) {
				driver.get(prop.getProperty("maxPageURL"));
				Thread.sleep(2000);
			}
			break;
		case "NEO HIFI":
			if (!driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("neoHifiPageURL"))) {
				driver.get(prop.getProperty("neoHifiPageURL"));
				Thread.sleep(2000);
			}
			break;
		case "ACCESSORIES":
			if (!driver.getCurrentUrl().equalsIgnoreCase(prop.getProperty("accessoriesPageURL"))) {
				// driver.get(prop.getProperty("accessoriesPageURL"));
				CartPage cartPage = new CartPage();
				if (cartPage.isCartOpen()) {
					cartPage.closeCart();
				}
				wait.until(ExpectedConditions.visibilityOf(dropDwnShop));
				Actions action = new Actions(driver);
				action.moveToElement(dropDwnShop).build().perform();
				wait.until(ExpectedConditions.elementToBeClickable(linkAccessories)).click();
			}
			break;
		default:
			System.out.println("Page doesn't Exists ...");
		}
		Thread.sleep(1000);
	}

	public void bread_popup() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bread-modal"));
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		// breadPopUp.isDisplayed();

		// Assert.assertTrue(breadPopUp.isDisplayed());

	}

	public String generatePhoneNumber() throws InterruptedException {

		Random rand = new Random();
		int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
		int num2 = rand.nextInt(743);
		int num3 = rand.nextInt(10000);

		DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
		DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

		String phoneNumber = df3.format(num1) + df3.format(num2) + df4.format(num3);

		return phoneNumber;

	}

}
