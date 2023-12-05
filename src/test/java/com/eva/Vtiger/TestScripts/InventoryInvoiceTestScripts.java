package com.eva.Vtiger.TestScripts;

import org.testng.annotations.Test;

import com.evs.Vtiger.Pages.Common.CommonPage;
import com.evs.Vtiger.Pages.Inventory.Invoice.InventoryInvoiceCreationPage;
import com.evs.Vtiger.Pages.Inventory.Invoice.InventoryInvoiceLandingpage;
import com.evs.Vtiger.Pages.Marketing.Accounts.MarketingAccountsCreateNewAccountPage;
import com.evs.Vtiger.Pages.Marketing.Accounts.MarketingAccountsLandingPage;
import com.evs.Vtiger.Utils.WebUtil;

public class InventoryInvoiceTestScripts extends BaseClass {
	private WebUtil wt = WebUtil.GetWebUtilInstance();

	@Test
	public void VerifyTC001InvoiceInfo() throws Exception {

		getCrc().goToMarketingAccountsPage();

		MarketingAccountsLandingPage mrkMainPage = new MarketingAccountsLandingPage(wt);
		mrkMainPage.ClickcreateNewAccountButton();

		MarketingAccountsCreateNewAccountPage MrkCreation = new MarketingAccountsCreateNewAccountPage(wt);
		MrkCreation.enterMarketingAccountInfo(null, null, null, null, null, null, null);

		getCrc().goToInventoryInvoicepage();

		InventoryInvoiceLandingpage InvoiceMainPage = new InventoryInvoiceLandingpage(wt);
		InvoiceMainPage.ClickOncreatenewInvoicbutton();

		InventoryInvoiceCreationPage InvoiceCreatingPage = new InventoryInvoiceCreationPage(wt);
		InvoiceCreatingPage.enterInventoryInvoiceInfo();

		InvoiceCreatingPage.enterInventoryInvoiceWindowInfo();

	}

}
