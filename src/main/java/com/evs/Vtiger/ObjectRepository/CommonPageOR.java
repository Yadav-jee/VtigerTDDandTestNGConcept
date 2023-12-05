package com.evs.Vtiger.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class CommonPageOR {

	public CommonPageOR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);

	}

	@FindBy(name = "user_name")
	private WebElement UsernameTB;

	@FindBy(name = "user_password")
	private WebElement PasswordTB;

	@FindBy(name = "Login")
	private WebElement LoginBt;

	@FindBy(xpath = "//font[@color='Brown']")
	private WebElement LoginErrorMsg;

	@FindBy(linkText = "Sign Out")
	private WebElement LogOutButton;

	@FindBy(linkText = "Marketing")
	private WebElement MarketingTaB;

	@FindBy(linkText = "Accounts")
	private WebElement MarketingAccountSubTaB;

	@FindBy(linkText = "Leads")
	private WebElement MarketingLeadsSubTab;

	@FindBy(linkText = "Contacts")
	private WebElement MarketingContactsTab;

	@FindBy(linkText = "Campaigns")
	private WebElement MarketingCompaign;

	@FindBy(xpath = "//a[text()='Inventory']")
	private WebElement InventoryTab;

	@FindBy(xpath = "//a[text()='Invoice']")
	private WebElement InventoryInvoiceTab;

	@FindBy(xpath = "//font[@color='Brown']")
	private WebElement ErrorMSg;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a")
	private List<WebElement> AllMainModules;

	private String URL = "http://localhost:8888/";

}
