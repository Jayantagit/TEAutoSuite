package com.qa.te.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.te.base.BaseTest;
import com.qa.te.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : design login page features...")
@Feature("US - 201: desgin login page title, sign up link and login form modules...")
public class LoginPageTest extends BaseTest 
{
	
	@Description("verify login page title login page...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		System.out.println("running login page title test...");
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("verify SignUp Link presence in login page...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifySignUpLinkPresnceeTest() {
		System.out.println("running Sign Up Link presence test in Login Page...");
		Assert.assertTrue(loginPage.isSignUpLinkExist());
		//Assert.assertEquals(loginPage.isSignUpLinkExist(), true);
	}

	@Description("verify user is able to login page...")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("supplier_username"), prop.getProperty("supplier_password"));
	}

}
