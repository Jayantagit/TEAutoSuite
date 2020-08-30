package com.qa.te.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.te.base.BaseTest;
import com.qa.te.pages.HomePage;
import com.qa.te.pages.NegotiationPage;
import com.qa.te.utils.Constants;
import com.qa.te.utils.ExcelUtil;

public class NegotationPageTest extends BaseTest{
	
	HomePage homePage;
	NegotiationPage negotiationPage;

	@BeforeClass
	public void negotiationPageSetup() {
		homePage = loginPage.doLogin(prop.getProperty("supplier_username"), prop.getProperty("supplier_password"));
		homePage.clickTourAlert();
        negotiationPage = homePage.goToNegotiationPage();
	}

	@Test(priority = 1)
	public void verifyNegotitationPageTitleTest() {
		String title = negotiationPage.getNegotationPageTitle();
		System.out.println("Negotitation page title is: " + title);
		Assert.assertEquals(title, Constants.NEGOTATION_PAGE_TITLE);
	}

	
	
	@DataProvider()
	public Object[][] getOfferTestData(){
		Object data[][] = ExcelUtil.getTestData(Constants.NEGOTATION_SHEET_NAME);
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getOfferTestData", enabled=false)
	public void createNewOfferTest(String customer, String destination, String supplier, String origin) {
		negotiationPage.createOffer(customer, destination, supplier, origin);
		
	}

}
