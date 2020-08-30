package com.qa.te.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.te.base.BasePage;
import com.qa.te.utils.Constants;
import com.qa.te.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	private WebDriver driver;
	ElementUtil elementUtil;

	// By Locators -- OR
	By username = By.id("timberuser");
	By password = By.id("timberpass");
	By nextButton = By.xpath("//button[text()='Next']");
	//By signUpLink = By.linkText("Sign up");
	By signUpLink = By.xpath("//a[contains(text(),'Sign up')]");
	By takemeInButton=By.id("submit");

	// constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	// page actions:
	@Step("getting Timber Exchange login page title...")
	public String getLoginPageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);
	}

	@Step("getting sing up link presence...")
	public boolean isSignUpLinkExist() {
		return elementUtil.doIsDisplayed(signUpLink);
	}

	@Step("login with username : {0} and password: {1}")
	public HomePage doLogin(String username, String pwd) {
		System.out.println("login to app with --> " + username + ":" + pwd);
		elementUtil.waitForElementToBeVisible(this.username, 30);
		elementUtil.doSendKeys(this.username, username);
		elementUtil.doClick(nextButton);
		elementUtil.waitForElementToBeVisible(this.password, 30);
		elementUtil.doSendKeys(this.password, pwd);
		elementUtil.doClick(takemeInButton);
		
		return new HomePage(driver);
	}

}
