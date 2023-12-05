package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class InventoryInvoiceCreation_OR {

	public InventoryInvoiceCreation_OR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);

	}

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement SelectInvoiceAccountNameButton;

	@FindBy(id = "single_accountid")
	private WebElement Accountname;

	@FindBy(id = "search_txt")
	private WebElement SearchAccountTB;

	@FindBy(name = "search_field")
	private WebElement SelectDropDown;

	@FindBy(name = "search")
	private WebElement SearchButton;

	@FindBy(linkText = "Shivam")
	private WebElement AccountNameLink;

	private String ExpectedAccountName = "Shivam";

}
