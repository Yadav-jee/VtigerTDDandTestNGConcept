package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class InventoryInvoicelanding_OR {

	public InventoryInvoicelanding_OR(WebUtil wu) {

		PageFactory.initElements(wu.getDriver(), this);
	}

	@FindBy(xpath = "//img[@title='Create Invoice...']")
	private WebElement CreateInvoiceButton;
}
