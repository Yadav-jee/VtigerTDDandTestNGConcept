package com.evs.Vtiger.ObjectRepository;

import org.openqa.selenium.support.PageFactory;

import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountDeletion_OR {

	public MarketingAccountDeletion_OR(WebUtil wu) {
		PageFactory.initElements(wu.getDriver(), this);

	}

}
