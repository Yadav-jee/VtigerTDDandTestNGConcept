package com.evs.Vtiger.Pages.Inventory.Invoice;

import com.evs.Vtiger.ObjectRepository.InventoryInvoiceCreation_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class InventoryInvoiceCreationPage extends InventoryInvoiceCreation_OR {
	private WebUtil wt;

	public InventoryInvoiceCreationPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void enterInventoryInvoiceInfo() {
		wt.SendKeys(getAccountname(), "Account name Box", "AccountName TextBox");
		wt.Click(getSelectInvoiceAccountNameButton());

	}

	public void VerifyInvoiceAccountName() {
		wt.HandleWindowByTittle("admin - Inventory - Invoice - vtiger CRM 5 - Commercial Open Source CRM");
		String AccountNameValue = wt.getAttribute(getAccountname(), "value");

	}

	public void enterInventoryInvoiceWindowInfo() throws Exception {
		wt.HandleWindowByURL(
				"http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_account_address&form=TasksEditView&form_submit=false&fromlink=");
		wt.SendKeys(getSearchAccountTB(), "Search InvoiceAccount", "SearchAccountButton");
		wt.SelectByIndex(getSelectDropDown(), 0);
		wt.Click(getSearchButton());
		wt.Click(getAccountNameLink());
		wt.accept();

	}
}
