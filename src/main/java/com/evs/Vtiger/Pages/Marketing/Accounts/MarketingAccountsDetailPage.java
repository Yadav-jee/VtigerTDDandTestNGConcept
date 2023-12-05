package com.evs.Vtiger.Pages.Marketing.Accounts;

import com.evs.Vtiger.ObjectRepository.MarketingAccountsDetail_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class MarketingAccountsDetailPage extends MarketingAccountsDetail_OR {
	private WebUtil wt;

	public MarketingAccountsDetailPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void ClickOnAccountDeleteButton() {
		wt.Click(getDeleteButton());
	}

	public void ClickOnAccountUpdateButton() {
		wt.Click(getEditButton());

	}

	public void ClickOnAccountDuplicateButton() {

	}

}
