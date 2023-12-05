package com.evs.Vtiger.Pages.Marketing.Accounts;

import com.evs.Vtiger.ObjectRepository.MarketingAccountDeletion_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class MarketingAccountDeletionPage extends MarketingAccountDeletion_OR {
	private WebUtil wt;

	public MarketingAccountDeletionPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void DeleteMarketingAccountInfo() {
		wt.accept();
	}
}
