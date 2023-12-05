package com.evs.Vtiger.Pages.Marketing.Accounts;

import com.evs.Vtiger.ObjectRepository.MarketingAccountsLanding_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class MarketingAccountsLandingPage extends MarketingAccountsLanding_OR {
	private WebUtil wt;

	public MarketingAccountsLandingPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void ClickcreateNewAccountButton() {
		wt.Click(getAccountCreateButton());

	}

	public void SearchAccount(String inputvalue, int index) throws Exception {
		wt.SendKeys(getSearchAccountTextBox(), inputvalue, "AccountBox");
		wt.SelectByIndex(getSelectDropdown(), index);
		wt.Click(getClickOnSearchButton());

	}

	public void ClickonAccountImportButton() {
		wt.Click(getImportButton());
	}

}
