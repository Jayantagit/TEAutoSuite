package com.qa.te.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.te.base.BasePage;
import com.qa.te.utils.Constants;
import com.qa.te.utils.ElementUtil;
import com.qa.te.utils.JavaScriptUtil;
import com.qa.te.utils.TimeUtil;

public class NegotiationPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	//**********************Locators of NegotationPage***************
	 By addofferLink = By.xpath("//a[contains(text(),'Add Offer')]");
	//By addofferLink = By.linkText("Add Offer");
	//********************Add Offer Elements******************
	By customerNm=By.id("select2-customer-i2-container");
	By customerNmTextBox=By.className("select2-search__field");
	By spec=By.name("spec");
	By validuntilDt=By.name("valid_until"); //javascript executor-SetAttribute
	//By currency=By.id("select2-tp_currency-js-container");
	By currency=By.xpath("//span[@id='select2-tp_currency-ss-container']");
	By currencytxt=By.xpath("//input[@class='select2-search__field']");	
	
	By category=By.id("select2-tp_cat_id-lb-container");
	By noofshipment=By.name("no_of_shipment");
	By Locationlabel=By.xpath("//div[@class='fs-label']");
	By LocationCheckbox=By.xpath("//div[@class='fs-option g0 selected']//span[@class='fs-checkbox']/i");
	
	By goods_ready=By.id("select2-goods_ready_approx-k4-container");
	By goos_ready_month=By.id("select2-goods_ready_month-a7-container");
	
	By grade=By.id("select2-tp_grade_1-container");
	By species=By.id("select2-tp_species_id_1-container");
	By speciesselect=By.xpath("//ul[@id='select2-tp_species_id_1-results']/li");
	By dimension=By.name("tp_dimension[]");
	By prodm3=By.name("tp_m3[]");
	By prodprice=By.name("tp_priceidea[]");
	By companyLocation=By.id("company_location");//Select
	
	By addofferSubmitBtn=By.name("add_offer_submit");
	

	public NegotiationPage(WebDriver driver) 
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		jsUtil=new JavaScriptUtil(this.driver);
	}
	
	public String getNegotationPageTitle() {
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.NEGOTATION_PAGE_TITLE);
	}
	
	public void createOffer(String specval, String validuntil,String location,String species, String dimension,String m3,String price) {
		
     //Click on Add Offer Button
		TimeUtil.shortWait();
		elementUtil.waitForElementToBeClickable(addofferLink, 20);
		System.out.println("Cretea Offer Button Clicked");
		jsUtil.clickElementByJS(elementUtil.getElement(addofferLink));
	
	//	For Demo purpose not selecting-Customer,Destination,Supplier,Origin
		
		elementUtil.waitForElementToBeVisible(spec, 20);
		elementUtil.doSendKeys(this.spec, specval);
		jsUtil.setDateUsingJS(elementUtil.getElement(validuntilDt), validuntil);
		
		/*
		elementUtil.clickWhenReady(this.currency, 10);
		elementUtil.doSendKeys(this.currencytxt, currency);
		
		elementUtil.doSendKeys(this.goods_ready, goodsready);
		elementUtil.doSendKeys(this.goos_ready_month, goodsmonth);*/
		
		jsUtil.scrollIntoView(elementUtil.getElement(Locationlabel));
		elementUtil.doActionsClick(Locationlabel);
		TimeUtil.shortWait();
		elementUtil.clickLocationCustom(location);//Can use Select-which is hidden
		
		elementUtil.waitForElementToBeClickable(this.species, 20);
		
		elementUtil.doActionsClick(this.species);
		TimeUtil.shortWait();
		elementUtil.selectValuesFromDropDown(this.speciesselect, species);
		
		elementUtil.doSendKeys(this.dimension, dimension);
		elementUtil.doSendKeys(this.prodm3, m3);
		elementUtil.doSendKeys(this.prodprice, price);
		
				
		elementUtil.clickWhenReady(addofferSubmitBtn, 10);
		TimeUtil.LongWait();
		
		
		
	}

}
