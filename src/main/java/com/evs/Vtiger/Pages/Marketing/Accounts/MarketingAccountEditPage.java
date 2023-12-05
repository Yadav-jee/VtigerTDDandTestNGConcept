package com.evs.Vtiger.Pages.Marketing.Accounts;

import com.evs.Vtiger.ObjectRepository.MarketingAccountEdition_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class MarketingAccountEditPage extends MarketingAccountEdition_OR {
	private WebUtil wt;

	public MarketingAccountEditPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void EditMarketingAccountInfo() throws Exception {
		wt.SendKeys(getAccountNameTb(), "kumar", "AccountName");
		wt.clear(getEmail_IdTb());
		wt.SendKeys(getEmail_IdTb(), "Sajan12@gmail.com", "Email_Id");
		wt.Click(getSaveButton());

	}

}
