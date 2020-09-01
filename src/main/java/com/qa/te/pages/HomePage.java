package com.qa.te.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;
import com.qa.te.base.BasePage;
import com.qa.te.utils.Constants;
import com.qa.te.utils.ElementUtil;
import com.qa.te.utils.TimeUtil;


public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//**********************Locators of HomePage***************
	By header = By.xpath("//div[contains(text(),' Account Setup Goals')]");	
	//By exportArrowLink = By.xpath("//li[@id='tour_1']//span[@class='title']//following-sibling::span[@class='arrow']");
	By exportArrowLink = By.xpath("//li[@id='tour_1']//span[@class='title']");
	By negotiationLink = By.xpath("//a[contains(text(),'Negotiations')]");
	//By endTourLink = By.id("end_tour");
	By endTourLink = By.xpath("//div[@class='popover-navigation']//button[@id='end_tour']");
	
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getHomePageTitle(){
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.HOME_PAGE_TITLE);
	}
	
	public String getHomePageHeader(){
		if(elementUtil.doIsDisplayed(header))
			return elementUtil.doGetText(header);
		return null;
	}
	
	public void dismissTourAlert(){
				
		System.out.println("Waiting for Tour Alert Popup");
		Alert tourAlert=elementUtil.waitForAlertPresent(20);
		System.out.println("Tour Alert text--------------->"+tourAlert.getText());
		elementUtil.doActionsClick(endTourLink);
		tourAlert.dismiss();
	}
	
	public void clickTourAlert(){
		elementUtil.waitForElementPresent(endTourLink, 30);
		elementUtil.doClick(endTourLink);
		
	}

	
	public NegotiationPage goToNegotiationPage(){
		clickOnNegotation();
		return new NegotiationPage(driver);
	}
	
	private void clickOnNegotation(){
		//elementUtil.doSwitchFrameByID(Constants.NEGOTIATION_PAGE_FRAME_ID);
		elementUtil.waitForElementToBeClickable(exportArrowLink, 30);
		//elementUtil.waitForElementPresent(exportArrowLink, 10);
		//elementUtil.doClick(exportArrowLink);
		elementUtil.doActionsClick(exportArrowLink);
		elementUtil.clickWhenReady(negotiationLink, 10);
		TimeUtil.MediumWait();
	}
	

}
