package com.evs.Vtiger.Pages.Marketing.Accounts;

import com.evs.Vtiger.ObjectRepository.MarketingExport_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class MarketingExportPage extends MarketingExport_OR {

	private WebUtil wt;

	public MarketingExportPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

}
