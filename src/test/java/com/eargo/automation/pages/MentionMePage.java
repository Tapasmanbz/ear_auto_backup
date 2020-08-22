package com.eargo.automation.pages;

import java.time.Duration;

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

	public void findFriend() throws InterruptedException {
		System.out.println("Inside findFriend()");
		Thread.sleep(5000);
		WebDriverWait mentionMePopUPWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		mentionMePopUPWait.until(ExpectedConditions.visibilityOf(popupMentionMe));
		Thread.sleep(5000);
		driver.switchTo().frame(iFrameMentionMe);
		enterFriendName(prop.getProperty("friendName"));
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

}
