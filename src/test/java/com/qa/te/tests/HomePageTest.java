package com.qa.te.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.te.base.BaseTest;
import com.qa.te.pages.HomePage;
import com.qa.te.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 102 : design Home page features...")
@Feature("US - 301: desgin home page title, header and account names modules...")
public class HomePageTest extends BaseTest {
	
HomePage homePage;
	
	@BeforeClass
	public void homePageSetup(){
		homePage = loginPage.doLogin(prop.getProperty("supplier_username"), prop.getProperty("supplier_password"));
		homePage.clickTourAlert();
	}
	
	@Description("verify Title Test on home page....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Description("verify header Test on home page....")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void verifyHomePageHeaderTest(){
		String header = homePage.getHomePageHeader();
		System.out.println("home page header is : " + header);
		//Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
		Assert.assertTrue(header.contains(Constants.HOME_PAGE_HEADER));
	}
	
	}
