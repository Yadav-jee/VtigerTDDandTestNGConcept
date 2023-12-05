package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingImport_OR {

	public MarketingImport_OR(WebUtil wu) {

		PageFactory.initElements(wu.getDriver(), this);
	}

}
