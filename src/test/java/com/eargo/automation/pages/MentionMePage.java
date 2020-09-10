package com.eargo.automation.pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MentionMePage extends BasePage {

	public MentionMePage() {

		PageFactory.initElements(driver, this);
		// waitForPageLoad();
	}

	@FindBy(how = How.ID, using = "mmModalReferee")
	public WebElement popupMentionMe;

	@FindBy(how = How.ID, using = "mmContentReferee")
	public WebElement iFrameMentionMe;

	@FindBy(how = How.ID, using = "SearchQuery_SearchQuery")
	public WebElement inputFriendName;

	@FindBy(how = How.ID, using = "searchbox")
	public WebElement btnFindThem;

	@FindBy(how = How.ID, using = "SearchQuery_SearchEmail")
	public WebElement inputFriendEmail;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement btnSubmit;

	@FindBy(how = How.ID, using = "Referee_User_email")
	public WebElement inputEmail;

	@FindBy(how = How.NAME, using = "ButtonRegister")
	public WebElement btnGet15PercentOff;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Referred by a friend?')]")
	public WebElement linkReferredByFriend;

	@FindBy(how = How.XPATH, using = "//button[@id='copy-button']")
	public WebElement btnCopyCode;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Continue shopping')]")
	public WebElement btnContinueShopping;
	
	@FindBy(how = How.XPATH, using = "//div[@class='mm-explainer']/h1")
	public WebElement alreadyAvailedRefreeErrorMSG;
	

	public void findFriend() throws InterruptedException {
		System.out.println("Inside findFriend()");
		
		WebDriverWait mentionMePopUPWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mentionMePopUPWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameMentionMe));
		enterFriendName(prop.getProperty("friendName"));
		Thread.sleep(1500);		
		clickFindThemButton();
		driver.switchTo().defaultContent();
	}

	public void submitFriendDetails() {
		driver.switchTo().frame(iFrameMentionMe);
		enterFriendEmail(prop.getProperty("friendReferalEmail"));
		clickSubmitButton();
		driver.switchTo().defaultContent();
	}

	public void submitRefreeDetails(String email) {
		driver.switchTo().frame(iFrameMentionMe);
		enterEmail(email);
		clickGetFifteenPercentOffButton();
		driver.switchTo().defaultContent();
	}

	public void continueShopping() {
		driver.switchTo().frame(iFrameMentionMe);
		clickCopyCodeButton();
		clickContinueShoppingButton();
		driver.switchTo().defaultContent();
	}
	
	public String getMentionMeErrorMessage() throws InterruptedException {
		driver.switchTo().frame(iFrameMentionMe);
		wait.until(ExpectedConditions.visibilityOf(alreadyAvailedRefreeErrorMSG));
		String errorMsg = alreadyAvailedRefreeErrorMSG.getText();
		driver.switchTo().defaultContent();
		return errorMsg;
	}

	private void enterFriendName(String friendName) {
		wait.until(ExpectedConditions.visibilityOf(inputFriendName)).sendKeys(friendName);
	}

	private void clickFindThemButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnFindThem)).click();
	}

	private void enterFriendEmail(String friendEmail) {
		wait.until(ExpectedConditions.visibilityOf(inputFriendEmail)).sendKeys(friendEmail);
	}

	private void clickSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();
	}

	private void enterEmail(String refereeEmail) {
		wait.until(ExpectedConditions.visibilityOf(inputEmail)).sendKeys(refereeEmail);
	}

	private void clickGetFifteenPercentOffButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnGet15PercentOff)).click();
	}

	private void clickCopyCodeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnCopyCode)).click();
	}

	private void clickContinueShoppingButton() {
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping)).click();
	}

}
