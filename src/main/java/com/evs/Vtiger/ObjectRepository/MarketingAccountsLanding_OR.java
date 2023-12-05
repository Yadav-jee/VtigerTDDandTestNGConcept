package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountsLanding_OR {

	public MarketingAccountsLanding_OR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);

	}
	
	@FindBy(xpath = "//img[@title='Create Account...']")
	private WebElement AccountCreateButton;

	@FindBy(name = "search_text")
	private WebElement SearchAccountTextBox;

	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']//select")
	private WebElement SelectDropdown;

	@FindBy(name = "submit")
	private WebElement ClickOnSearchButton;

	@FindBy(xpath = "//img[@title='Import Accounts']")
	private WebElement ImportButton;

}
