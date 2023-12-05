package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountsCreateNewAccount_OR {

	public MarketingAccountsCreateNewAccount_OR(WebUtil wu) {

		PageFactory.initElements(wu.getDriver(), this);

	}

	// -- Locating element--------------//
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement AccountNameTB;

	@FindBy(name = "website")
	private WebElement WebsiteTB;

	@FindBy(id = "phone")
	private WebElement PhoneNoTB;

	@FindBy(id = "email1")
	private WebElement Email_IdTB;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(id="bill_state")
	private WebElement  BillingState;
	
	@FindBy(id="bill_city")
	private WebElement  BillingCity;
	
	@FindBy(id="bill_code")
	private WebElement  BillingPostalCode;

	
}
