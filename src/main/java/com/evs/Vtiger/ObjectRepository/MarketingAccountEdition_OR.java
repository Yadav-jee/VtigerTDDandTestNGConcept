package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountEdition_OR {

	public MarketingAccountEdition_OR(WebUtil wu) {

		PageFactory.initElements(wu.getDriver(), this);

	}

	@FindBy(name = "accountname")
	private WebElement AccountNameTb;

	@FindBy(id = "email1")
	private WebElement Email_IdTb;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

}
