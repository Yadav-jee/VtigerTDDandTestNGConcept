package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountsDetail_OR {

	public MarketingAccountsDetail_OR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);
	}

	@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
	private WebElement DeleteButton;

	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement EditButton;

}
