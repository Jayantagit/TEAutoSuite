package com.qa.te.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.te.base.BasePage;
import com.qa.te.utils.Constants;
import com.qa.te.utils.ElementUtil;

public class NegotiationPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//**********************Locators of NegotationPage***************
	By addofferLink = By.xpath("//a[text()='Add Offer']");
	

	public NegotiationPage(WebDriver driver) 
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getNegotationPageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.NEGOTATION_PAGE_TITLE);
	}
	
	public void createOffer(String customer, String destination, String supplier, String origin) {
		
     //Code for Create Offer 
	}

}
